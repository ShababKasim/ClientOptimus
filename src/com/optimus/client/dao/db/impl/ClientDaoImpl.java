package com.optimus.client.dao.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.optimus.client.dao.ClientDao;
import com.optimus.client.dto.Client;

public class ClientDaoImpl  implements ClientDao{

		
	@Override
	public Client clientLogin(String username, String password) {

		try {

			Connection con = DbUtil.getConnection();
			PreparedStatement statement = con.prepareStatement(CLIENT_LOGIN);
			statement.setString(1, username );
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();

			if(rs.next()) {
				if(username.equals(rs.getString("username")) && password.equals(rs.getString("password"))){
					return new Client(rs.getString("username"),rs.getString("password"), rs.getString("name"), rs.getString("designation"), rs.getString("email"), rs.getBoolean("gender"), rs.getString("mobile"), rs.getInt("privilege"));
				}
					
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Client> getClients() {
		List<Client> clients = new ArrayList<Client>();
		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement statement = con.prepareStatement(GET_USERS);
			ResultSet rs = statement.executeQuery();

			while(rs.next()) {
				clients.add(new Client(rs.getString("username"),rs.getString("password"), rs.getString("name"), rs.getString("designation"), rs.getString("email"), rs.getBoolean("gender"), rs.getString("mobile"), rs.getInt("privilege")));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return clients;
	}

	@Override
	public boolean addClient(String username,String password,String name,String designation,String email,boolean gender,String mobile,int privilege) {
		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement statement = con.prepareStatement(ADD_CLIENT);
			statement.setString(1, username );
			statement.setString(2, password);
			statement.setString(3, name );
			statement.setString(4, designation);
			statement.setString(5, email );
			statement.setBoolean(6, gender);
			statement.setString(7, mobile );
			statement.setInt(8, privilege);
			statement.executeUpdate();
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean deleteClient(String username) {
		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement statement = con.prepareStatement(DELETE_CLIENT);
			statement.setString(1, username );
			statement.executeUpdate();
			return true;
		} catch(Exception e) {
			return false;
		}
	}
}
