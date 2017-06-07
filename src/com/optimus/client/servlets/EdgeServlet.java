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
import com.samaylabs.optimus.webservices.Edge;

/**
 * Servlet implementation class EdgeServlet
 */
@WebServlet("/EdgeServlet")
public class EdgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EdgeServlet() {
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
		
		UtilizerTrack util = new UtilizerTrack();
		String operation = request.getParameter("operation");

		if(operation.equals("Create")){
			
			Long src = Long.parseLong(request.getParameter("src"));
			Long dest = Long.parseLong(request.getParameter("dest"));
			float radius = Float.parseFloat(request.getParameter("radius"));
			double dist = Double.parseDouble(request.getParameter("distance"));
			
			boolean ret = util.createEdge(src, dest, dist, radius);
			
			response.setContentType("text/plain");
			response.getWriter().println(ret);
			
		} else if(operation.equals("Retrive")){
			
			List<Edge> edges = util.retriveEdge();
			String json = new Gson().toJson(edges);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);	
			
		} else if(operation.equals("Update")){
			
			Long prevsrc = Long.parseLong(request.getParameter("psrc"));
			Long prevdest = Long.parseLong(request.getParameter("pdest"));
			Long src = Long.parseLong(request.getParameter("src"));
			Long dest = Long.parseLong(request.getParameter("dest"));
			float radius = Float.parseFloat(request.getParameter("radius"));
			double dist = Double.parseDouble(request.getParameter("distance"));
			
			util.updateEdge(prevsrc, prevdest, src, dest, dist, radius);
			
		} else if(operation.equals("Delete")){ 
			
			Long src = Long.parseLong(request.getParameter("src"));
			Long dest = Long.parseLong(request.getParameter("dest"));
			util.deleteEdge(src, dest);
			
		}
		
	}

}
