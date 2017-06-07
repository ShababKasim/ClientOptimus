package com.optimus.client.ServicesUtilizer;

import java.util.List;

import com.samaylabs.optimus.webservices.AgvData;
import com.samaylabs.optimus.webservices.ListWrapper;
import com.samaylabs.optimus.webservices.MapWrapper;
import com.samaylabs.optimus.webservices.OptimusDefination;
import com.samaylabs.optimus.webservices.OptimusService;
import com.samaylabs.optimus.webservices.Ticket;

public class UtilizerOptimus {

	private OptimusService optimusService = new OptimusService();
	private OptimusDefination optimusD = optimusService.getOptimusPort();
	
	
	public boolean stopNodeServer(){
		return optimusD.stopNodeServer();
	}
	
	public ListWrapper startScheduler(){
		return optimusD.startScheduler();
	}
	
	public boolean stopScheduler(){
		return optimusD.stopScheduler();
	}
	
	public int powerStatusKey(){
		return optimusD.powerStatusKey();
	}
	
	public ListWrapper powerStatus(){
		return optimusD.powerStatus();
	}
	
	public boolean insertTicket(int Id, long  uid, int pdest, String type, String status) {
		return optimusD.insertTicket(Id, uid, pdest, type, status); 
		
	}
	
	public boolean removeTicket(int index) {
		return optimusD.removeTicket(index);
	}
	
	public boolean alterTicket(int index1, int index2) {
		return optimusD.alterTicket(index1, index2);
	}

	public List<Ticket> getQueue() {
		return optimusD.getQueue();
	}
	
	public boolean setTicketToAgv(int index,int Agvno,String status){
		return optimusD.setTicketToAgv(index, Agvno, status);
	}
	
	public List<AgvData> getAgvInfo(){
		return optimusD.getAgvInfo();
	}
	
	public int getActiveNodes(){
		return optimusD.getActiveNode();
	}
	
	public boolean uiAbort(int id){
		return optimusD.uiAbort(id);
	}
	
	public MapWrapper getActiveSignals(){
		return optimusD.getActiveSignals();
	}
	
	public ListWrapper areErrors(){
		return optimusD.areErrors();
	}
	
	public boolean isError(){
		return optimusD.isErrors();
	}
}
