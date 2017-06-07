package com.optimus.client.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.optimus.client.dao.ClientDao;
import com.optimus.client.dao.db.impl.ClientDaoImpl;
import com.optimus.client.dto.Client;

/**
 * Servlet implementation class ClientLoginServlet
 */
@WebServlet("/Login")
public class ClientLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientLoginServlet() {
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
		
		HttpSession session = request.getSession();
		ClientDao clientDaoObj = new ClientDaoImpl();
		String action = request.getParameter("action");
		
		if(action.equals("login") && action != null){
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			Client client = clientDaoObj.clientLogin(username, password);
			
			if( client != null ){
				session.setAttribute("username", client.getUsername() );
				session.setAttribute("name", client.getName() );
				session.setAttribute("designation", client.getDesignation() );
				session.setAttribute("email", client.getEmail() );
				session.setAttribute("gender", client.isGender() );
				session.setAttribute("mobile", client.getMobile() );
				session.setAttribute("privilege", client.getPrivilege() );
				
				if(client.getPrivilege() == 1 || client.getPrivilege() == 2)
					session.setMaxInactiveInterval(2*60);
				
				response.sendRedirect("index.jsp");
			} else {
				
				request.setAttribute("status",0 );
			    request.getRequestDispatcher("Login.jsp").forward(request, response);
				
				
			}
			
		} else if(action.equals("Logout") && action != null) {
//			session.invalidate();
			response.sendRedirect("Logout.jsp");
		
		} else if(action.equals("Retrive") && action != null) {
			
			List<Client> clients = clientDaoObj.getClients();
			String json = new Gson().toJson(clients);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		
		} else if(action.equals("Insert") && action != null) {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String designation = request.getParameter("designation");
			String email = request.getParameter("email");
			boolean gender = (request.getParameter("gender").equals("1")) ? true : false; 
			String mobile = request.getParameter("mobile");
			int privilege = Integer.parseInt(request.getParameter("privilege"));
			boolean res = clientDaoObj.addClient(username, password, name, designation, email, gender, mobile, privilege);
			
			response.getWriter().write(res ? 1 : 2);
		} else if(action.equals("Delete") && action != null) {
			
			String username = request.getParameter("username");
			boolean res = clientDaoObj.deleteClient(username);
			response.getWriter().write(res ? 1 : 2);	
		
		}
		
		
	}

}
