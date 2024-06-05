package com.chainsys.servlet;

import java.io.IOException;
import java.lang.ProcessHandle.Info;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.ServerManager;
import com.chainsys.model.BankAccountInfo;
import com.chainsys.model.UserInfo;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ServerManager manager = new ServerManager(); 
    BankAccountInfo accountInfo = new BankAccountInfo();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccount() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//doGet(request, response);
		//System.out.println("CreateAccountPostMethod");
		
		String choice = request.getParameter("action");
		System.out.println("Choice : " + choice);
		if(choice.equals("createAccount"))
		{
			String fname = request.getParameter("firstName");
			accountInfo.setFname(fname);
			String lname = request.getParameter("lastName");
			accountInfo.setLname(lname);
			String phNumber = request.getParameter("phoneNumber");
			accountInfo.setPhoneNumber(phNumber);
			String dob = request.getParameter("dateOfBirth");
			accountInfo.setDOB(dob);
			String aadharNo = request.getParameter("aadhaarNumber");
			long adrNo = Long.parseLong(aadharNo);
			accountInfo.setAadharNumber(adrNo);
			String address = request.getParameter("residentialAddress");
			accountInfo.setAddress(address);
			
			int id = (int) session.getAttribute("userid");
			//System.out.println("_____id : " + id);
			
			try {
				if(!manager.getEmail(id)) {
					try {
						manager.createAccount(accountInfo, id);
						response.sendRedirect("LandingPage.jsp");
					} catch (ClassNotFoundException e) {
						
						e.printStackTrace();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
				else
				{
					//System.out.println("Account Already Exist!!!");
					request.setAttribute("message", "Account Already Exist!!!");
					request.getRequestDispatcher("CreateBankAccount.jsp").forward(request, response);
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(choice.equals("depositAmount"))
		{
			String accountNumber = request.getParameter("accountNumber");
			accountInfo.setAccNo(accountNumber);
			double amount = Double.parseDouble(request.getParameter("amount"));
			try {
				amount += manager.getAvailableBalance(accountNumber);
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			accountInfo.setAmount(amount);
			String password = request.getParameter("password");
			
			int id = (int) session.getAttribute("userid");
			System.out.println("_____id : " + id);
			
			try {
				if(manager.checkAccountNumber(accountNumber) && manager.checkPassword(id,password))
				{
					manager.depositAmount(accountNumber, amount);
					response.sendRedirect("LandingPage.jsp");
				}
				else if(!manager.checkPassword(id, password))
				{
					System.out.println("invalid password");
					response.sendRedirect("DepositAmount.jsp");
				}
				else if(!manager.checkAccountNumber(accountNumber))
				{
					System.out.println("invalid AccountNumber");
					response.sendRedirect("DepositAmount.jsp");
				}
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

}
