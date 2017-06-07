package com.optimus.client.ServicesUtilizer;

import java.util.List;

import com.samaylabs.optimus.webservices.Edge;
import com.samaylabs.optimus.webservices.Node;
import com.samaylabs.optimus.webservices.NodeResolver;
import com.samaylabs.optimus.webservices.TrackDefination;
import com.samaylabs.optimus.webservices.TrackDefinationService;

public class UtilizerTrack {

	private TrackDefinationService trackService = new TrackDefinationService();
	private TrackDefination trackPort = trackService.getTrackPort();
	
	public UtilizerTrack(){
		trackService = new TrackDefinationService();
		trackPort = trackService.getTrackPort();
	}
		
	public boolean createNode(long anchor,float xco, float yco, int type){
		return trackPort.createNode(anchor, xco, yco, type);
	}
	
	public boolean deleteNode(long anchor){
		return trackPort.deleteNode(anchor);
	}
	
	public List<Node> retriveNode(){
		return trackPort.retriveNodes();
	}
	
	public boolean updateNode(long prevanchor, long anchor,float xco, float yco, int type){
		return trackPort.updateNode(prevanchor, anchor, xco, yco, type);
	} 
	
	public boolean createBusiness(int id, long anchor,  String Label){
		return trackPort.createNodeResolver(id, anchor, Label);
	}
	
	public List<NodeResolver> retriveBusiness(){
		return trackPort.retriveNodeResolver();
	}
	
	public boolean updateBusiness(int pnrid, int nrid,Long anchor, String label){
		return trackPort.updateNodeResolver(pnrid, nrid, nrid, label);
	}
	
	public boolean deleteBusiness(int nrid){
		return trackPort.deleteNodeResolver(nrid);
	}
	
	public boolean createEdge(long src, long dest, double dist, float radius){
		return trackPort.createEdge(src, dest, dist, radius);
	}
	
	public List<Edge> retriveEdge(){
		return trackPort.retriveEdge();
	}
	
	public boolean deleteEdge(long src, long dest){
		return trackPort.deleteEdge(src, dest);
	}
	
	public boolean updateEdge(long prevsrc, long prevdest,long src, long dest, double dist, float radius){
		return trackPort.updateEdge(prevsrc, prevdest, src, dest, dist, radius);
	}	
	
	public List<Long> getAnchors(){
		return trackPort.getAnchors();
	}
	
	public List<Long> getAllAnchors(){
		return trackPort.getAllAnchors();
	}
		
}
