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
import com.samaylabs.optimus.webservices.AgvData;

/**
 * Servlet implementation class AgvDataServlet
 */
@WebServlet("/AgvDataServlet")
public class AgvDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilizerOptimus util = new UtilizerOptimus();   
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgvDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if(action.equals("errormessage")){
			List<String> data = util.areErrors().getMessages();
			
			String json = new Gson().toJson(data);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			
		} else if(action.equals("errorboolean")) {
		
			int data = util.isError() ? 1 : 0 ;
			response.setContentType("text/plain");
			response.getWriter().println(data);
		}
		
			
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<AgvData> data = util.getAgvInfo();
		
		String json = new Gson().toJson(data);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);	
	
	
	}

}
