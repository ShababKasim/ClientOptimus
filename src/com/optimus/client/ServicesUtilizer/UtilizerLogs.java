package com.optimus.client.ServicesUtilizer;

import java.util.List;

import com.samaylabs.optimus.webservices.ListWrapper;
import com.samaylabs.optimus.webservices.Logs;
import com.samaylabs.optimus.webservices.LogsDefination;
import com.samaylabs.optimus.webservices.LogsService;

public class UtilizerLogs {
	
	private LogsService logService = new LogsService();
	private LogsDefination logCall = logService.getLogsPort();
	
	public List<Logs> getOptimusLogs(){
		return logCall.getOptimusLogs();
	}
	
	public ListWrapper getUsers(){
		return logCall.getUsers();
	}
	
	public List<Logs> getOptimusLogsDated(String userid, String start , String end){
		return logCall.getOptimusLogsDated(userid, start, end);
	}
	
}
