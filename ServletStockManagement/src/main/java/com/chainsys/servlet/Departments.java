package com.chainsys.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.ServerManager;
import com.chainsys.model.StockInfo;

/**
 * Servlet implementation class Departments
 */
@WebServlet("/Departments")
public class Departments extends HttpServlet {
	private static final long serialVersionUID = 1L;
     ServerManager manager = new ServerManager();  
     StockInfo info = new StockInfo();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Departments() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Get Method");
				
		String choice = request.getParameter("departments");
		System.out.println("Dep Choice : " + choice);
		if(choice.equals("phone"))
		{
			try {
				manager.readStock(101, 200);
				info.setMinRange(101);
				info.setMaxRange(200);
				request.setAttribute("pojo", info);
				RequestDispatcher dispatcher = request.getRequestDispatcher("viewstockbydep.jsp");
				dispatcher.forward(request, response);
				
				//response.sendRedirect("viewstockbydep.jsp");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		else if(choice.equals("fruit"))
		{
			try {
				manager.readStock(201, 300);
				info.setMinRange(201);
				info.setMaxRange(300);
				request.setAttribute("pojo", info);
				RequestDispatcher dispatcher = request.getRequestDispatcher("viewstockbydep.jsp");
				dispatcher.forward(request, response);
				
				//response.sendRedirect("viewstockbydep.jsp");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(choice.equals("jewel")){
			try {
				manager.readStock(301, 400);
				info.setMinRange(301);
				info.setMaxRange(400);
				request.setAttribute("pojo", info);
				RequestDispatcher dispatcher = request.getRequestDispatcher("viewstockbydep.jsp");
				dispatcher.forward(request, response);
				
				//response.sendRedirect("viewstockbydep.jsp");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
