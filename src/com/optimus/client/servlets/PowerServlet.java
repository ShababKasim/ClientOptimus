package com.optimus.client.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.optimus.client.ServicesUtilizer.UtilizerOptimus;

/**
 * Servlet implementation class PowerServlet
 */
@WebServlet("/PowerServlet")
public class PowerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PowerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		UtilizerOptimus util = new UtilizerOptimus();
		
		String action = request.getParameter("action");
		
		if(action.equals("poweron")){
		
			List<String> data = util.startScheduler().getMessages(); 
			String json = new Gson().toJson(data);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);	
		
		} else if(action.equals("poweroff")){
		
			int res = util.stopScheduler() ? 1 : 0;
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(res);
		
		} else if(action.equals("powerstatus")){
		
			List<String> data = util.powerStatus().getMessages();
			String json = new Gson().toJson(data);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		
		} else if(action.equals("powerKey")){
			
			int res = util.powerStatusKey();
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(res);
	
		}
		
		
	}

}
