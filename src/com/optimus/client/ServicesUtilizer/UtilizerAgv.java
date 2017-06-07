package com.optimus.client.ServicesUtilizer;

import java.util.List;

import com.samaylabs.optimus.webservices.AgvDeclaration;
import com.samaylabs.optimus.webservices.AgvService;
import com.samaylabs.optimus.webservices.AgvData;

public class UtilizerAgv {

	private AgvService agvService = new AgvService();
	private AgvDeclaration agvCall = agvService.getAgvPort();
	
	public boolean createAgv(int id, String name, String ip, int port){
	return agvCall.createAgv(id, name, ip, port);
	}
	
	public boolean deleteAgv(int id){
		return agvCall.deleteAgv(id);
	}
	
	public List<AgvData> retriveAgv(){
		return agvCall.retriveAgv();
	}
	
	public boolean updateAgv(int pid, int id, String name, String ip, int port){
		return agvCall.updateAgv(pid, id, name, ip, port);
		} 
	
	public List<String> pingAgv(String ip, int port){
		return agvCall.pingAgv(ip, port).getMessages();
	}
	
	
	
}
