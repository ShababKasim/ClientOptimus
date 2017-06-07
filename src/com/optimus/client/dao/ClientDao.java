package com.optimus.client.dao;

import java.util.List;

import com.optimus.client.dto.Client;

public interface ClientDao {

	String CLIENT_LOGIN = "select * from user where username=? and password=?";
	String GET_USERS = "select * from user";
	String ADD_CLIENT = "insert into user values(?,?,?,?,?,?,?,?)";
	String DELETE_CLIENT = "delete from user where username=?";
	
	public Client clientLogin(String username, String password);
	public List<Client> getClients();
	public boolean addClient(String username,String password,String name,String designation,String email,boolean gender,String mobile,int privilege);
	public boolean deleteClient(String username);
	
}
