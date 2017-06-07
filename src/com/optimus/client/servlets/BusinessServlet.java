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
import com.samaylabs.optimus.webservices.NodeResolver;

/**
 * Servlet implementation class BusinessServlet
 */
@WebServlet("/BusinessServlet")
public class BusinessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusinessServlet() {
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
			
			int nrid = Integer.parseInt(request.getParameter("nrid"));
			Long anchor = Long.parseLong(request.getParameter("anchor"));
			String label = request.getParameter("label");
			
			util.createBusiness(nrid, anchor, label);
			
		} else if(operation.equals("Retrive")){
			
			List<NodeResolver> business = util.retriveBusiness();
			String json = new Gson().toJson(business);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);	
			
		} else if(operation.equals("Update")){
			
			int nrid = Integer.parseInt(request.getParameter("nrid"));
			int pnrid = Integer.parseInt(request.getParameter("pnrid"));
			Long anchor = Long.parseLong(request.getParameter("anchor"));
			String Label = request.getParameter("label");
			
			util.updateBusiness(pnrid, nrid, anchor, Label);
			
		} else if(operation.equals("Delete")){ 
			
			int nrid = Integer.parseInt(request.getParameter("nrid"));
			util.deleteBusiness(nrid);
			
			
		}  else if(operation.equals("Resolve")){ 
			
			int pdest = Integer.parseInt(request.getParameter("pdest"));
			List<NodeResolver> business = util.retriveBusiness();
			String resolve = null;
			for(NodeResolver b : business){
				if(b.getNRid() == pdest){
					resolve = b.getLabel();
					break;
				}	
			}
			response.getWriter().write(resolve);
		}
	}

}
