package com.optimus.client.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.optimus.client.ServicesUtilizer.UtilizerTrack;
import com.samaylabs.optimus.webservices.Node;

/**
 * Servlet implementation class NodeServlet
 */
@WebServlet("/NodeServlet")
public class NodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UtilizerTrack util;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NodeServlet() {
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


		util = new UtilizerTrack();
		String operation = request.getParameter("operation");

		if(operation.equals("Create")){
			
			Long anchor = Long.parseLong(request.getParameter("anchor"));
			float xco = Float.parseFloat(request.getParameter("xco"));
			float yco = Float.parseFloat(request.getParameter("yco"));
			int type = Integer.parseInt(request.getParameter("type"));
			
			util.createNode(anchor, xco, yco, type);
			
		} else if(operation.equals("Retrive")){
			List<Node> nodes = util.retriveNode();
			String json = new Gson().toJson(nodes);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);	
			
		} else if(operation.equals("Update")){
			
			Long prevanchor = Long.parseLong(request.getParameter("panchor"));
			Long anchor = Long.parseLong(request.getParameter("anchor"));
			float xco = Float.parseFloat(request.getParameter("xco"));
			float yco = Float.parseFloat(request.getParameter("yco"));
			int type = Integer.parseInt(request.getParameter("type"));
			
			boolean ret = util.updateNode(prevanchor, anchor, xco, yco, type);
			
			response.setContentType("text/plain");
			response.getWriter().println(ret);
			
		} else if(operation.equals("Delete")){ 
			
			Long anchor = Long.parseLong(request.getParameter("anchor"));
			util.deleteNode(anchor);
			
		} else if(operation.equals("allAnchors")){
			List<Long> anchors = util.getAllAnchors();
			
			String json = new Gson().toJson(anchors);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(json);	
			
		} else if(operation.equals("Anchors")){
			List<Long> anchors = util.getAnchors();
	
			String json = new Gson().toJson(anchors);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(json);	
			
		}
		


		/*switch(operation){
		case "Create":
			util.createNode(anchor, xco, yco, type);
			break;

		case "Retrive":
			List<Node> nodes = new ArrayList<Node>(Arrays.asList(util.retriveNode()));
			String json = new Gson().toJson(nodes);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);			
			break;

		case "Update":
			util.updateNode(prevanchor, anchor, xco, yco, type);
			break;

		case "Delete":
			util.deleteNode(anchor);
			break;
		}*/

	}
	
	
}
