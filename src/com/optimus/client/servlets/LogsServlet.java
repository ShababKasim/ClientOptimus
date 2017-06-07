package com.optimus.client.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.optimus.client.ServicesUtilizer.UtilizerLogs;
import com.samaylabs.optimus.webservices.Logs;

/**
 * Servlet implementation class LogsServlet
 */
@WebServlet("/LogsServlet")
public class LogsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		UtilizerLogs util = new UtilizerLogs();
		String action = request.getParameter("action");
		
		if(action.equals("getusers")){
			List<String> data = util.getUsers().getMessages();
			
			String json = new Gson().toJson(data);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(json);	
			
		} else if(action.equals("getlogs")){
			
			String user = request.getParameter("user");
			String start = request.getParameter("start");
			String end = request.getParameter("end");
			
			List<Logs> data = util.getOptimusLogsDated(user, start, end);
			
			String json = new Gson().toJson(data);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(json);
			
		}
		
		
	}

}
