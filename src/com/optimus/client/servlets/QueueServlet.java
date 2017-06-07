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
import com.samaylabs.optimus.webservices.Ticket;


/**
 * Servlet implementation class QueueServlet
 */
@WebServlet("/QueueServlet")
public class QueueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueueServlet() {
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
//		doGet(request, response);
		
		UtilizerOptimus util = new UtilizerOptimus();
		String operation = request.getParameter("operation");

		if(operation.equals("insert")){
			
			int Id = Integer.parseInt(request.getParameter("tid"));
			Long uid = Long.parseLong(request.getParameter("uid"));
			int pdest = Integer.parseInt(request.getParameter("pdest"));
			String type= request.getParameter("type");
			String status = request.getParameter("status");
			
			util.insertTicket(Id, uid, pdest, type, status);
			
		} else if(operation.equals("Retrive")){
			
			List<Ticket> tickets = util.getQueue();
			String json = new Gson().toJson(tickets);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);	
			
		} else if(operation.equals("Alter")){
			
			int index1 = Integer.parseInt(request.getParameter("index1"));
			int index2 = Integer.parseInt(request.getParameter("index2"));
			
			util.alterTicket(index1, index2);
			
		} else if(operation.equals("Delete")){ 
			
			int index = Integer.parseInt(request.getParameter("index"));
			util.removeTicket(index);
			
		} else if(operation.equals("Set")){ 
			
			int index = Integer.parseInt(request.getParameter("index"));
			int agvno = Integer.parseInt(request.getParameter("agvno"));
			String status = request.getParameter("status");
			util.setTicketToAgv(index, agvno, status);
			
		} else if(operation.equals("uiAbort")){ 
			
			int id = Integer.parseInt(request.getParameter("id"));
			util.uiAbort(id);
			
		}
		
	}

}
