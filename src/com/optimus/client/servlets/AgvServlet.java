package com.optimus.client.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.optimus.client.ServicesUtilizer.UtilizerAgv;
import com.samaylabs.optimus.webservices.AgvData;

/**
 * Servlet implementation class AgvServlet
 */
@WebServlet("/AgvServlet")
public class AgvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgvServlet() {
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
		
		UtilizerAgv util = new UtilizerAgv();
		String action = request.getParameter("action");

		if(action.equals("Insert")){
			
			int Id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String ipaddress = request.getParameter("ip");
			int port = Integer.parseInt(request.getParameter("port"));
			
			util.createAgv(Id, name, ipaddress, port);
			
		} else if(action.equals("Retrive")){
			
			List<AgvData> data = util.retriveAgv();
			String json = new Gson().toJson(data);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);	
			
		} else if(action.equals("Alter")){
			
			int pid = Integer.parseInt(request.getParameter("pid"));
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String ipaddress = request.getParameter("ip");
			int port = Integer.parseInt(request.getParameter("port"));
			
			util.updateAgv(pid, id, name, ipaddress, port);
			
		} else if(action.equals("Delete")){ 
			
			int id = Integer.parseInt(request.getParameter("id"));
			util.deleteAgv(id);
			
		} else if(action.equals("Ping")){ 
			
			String ip = request.getParameter("ip");
			int port = Integer.parseInt(request.getParameter("port"));
			
			List<String> data = util.pingAgv(ip, port);
			String json = new Gson().toJson(data);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			
			
		}

	
	}

}
