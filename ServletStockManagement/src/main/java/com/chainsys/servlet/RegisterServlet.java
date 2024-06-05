package com.chainsys.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.ServerManager;
import com.chainsys.model.StockInfo;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ServerManager manager = new ServerManager();
       StockInfo info = new StockInfo();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Get");
		
		String choice = request.getParameter("action");
		System.out.println("choice" + choice);
		
		if(choice.equals("viewStock"))
		{
			try {
				manager.readEntireStock();
				System.out.println(manager.readEntireStock());
//				RequestDispatcher dispatcher = request.getRequestDispatcher("viewstock.jsp");
//				dispatcher.forward(request, response);
				
				response.sendRedirect("viewstock.jsp");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		else if(choice.equals("addStock"))
		{
			
				
//				RequestDispatcher dispatcher = request.getRequestDispatcher("RegistrationForm.html");
//				dispatcher.forward(request, response);
			
			response.sendRedirect("RegistrationForm.html");
		}		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		System.out.println("Post");
		
		String choice = request.getParameter("action");
		System.out.println("choice" + choice);
		if(choice.equals("signUP"))
		{
			String name = request.getParameter("userName");
			int password = Integer.parseInt(request.getParameter("Password"));
			
			info.setAdminName(name);
			info.setPassword(password);
			try {
				if(!manager.retrieveUserCred(info))
				{
					System.out.println("UserName Exist");
//					RequestDispatcher dispatcher = request.getRequestDispatcher("RegistrationForm.html");
//					dispatcher.forward(request, response);
					
					 response.sendRedirect("RegistrationForm.html");
				}
				else
				{
					manager.insertUserCred(info);
					
//					RequestDispatcher dispatcher = request.getRequestDispatcher("loginpage.html");
//					dispatcher.forward(request, response);
					
					 response.sendRedirect("loginpage.html");
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
		}
		else if(choice.equals("logIN"))
		{
			String name = request.getParameter("loginName");
			int password = Integer.parseInt(request.getParameter("loginPassword"));
			
			try {
				HttpSession session = request.getSession();
				if(manager.readUserCred(name, password)){
					
					session.setAttribute("loginName", name);
//					RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
//					dispatcher.forward(request, response);
					
					 response.sendRedirect("home.jsp");
				}
				else {
//					RequestDispatcher dispatcher = request.getRequestDispatcher("loginpage.html");
//					dispatcher.forward(request, response);
					
					 response.sendRedirect("loginpage.html");
				}
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(choice.equals("logout"))
		{
			 HttpSession session = request.getSession(false);
		        if (session != null) {
		            session.invalidate();
		        }
	        response.sendRedirect("loginpage.html");
		        
		}
		
	}

}
