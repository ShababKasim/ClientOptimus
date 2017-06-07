$(document).ready(function(){
	
	var caxis = 0;
	var xmax = 0; var ymax = 0;
	var agvs;
	
	var originalMap = '';
	
	getMinMax();
	getGraph();
	
	setInterval(function(){
		printAgv();
	},3000);
	
	function getGraph(){
		$.ajax({
	        type: 'Post',
	        data:{
	            operation : "Retrive"
	        },
	        url: 'EdgeServlet',
	        success: function(response){
//	        	plotLegent();
	        	$.each(response,function(i,edge){
	        		
	        		var sx = edge.source.xCo; var sy = edge.source.yCo;
	        		var dx = edge.destination.xCo; var dy = edge.destination.yCo;
	        		var cf = edge.flag ? 1 : 0;
	        		
	        		sy = (sy < caxis) ? ymax - sy : (sy > caxis) ? sy - 2 * (sy - caxis) : sy = sy;
	        		dy = (dy < caxis) ? ymax - dy : (dy > caxis) ? dy - 2 * (dy - caxis) : dy = dy;
	        			        		
	        		if(edge.radius > 0){
	        			drawCurve(edge.id,sx,sy,edge.radius,cf,dx,dy);
	        		} else {
	        			drawEdge(edge.id,sx, sy, dx, dy);
	        		}
	        		
	        		if(edge.source.nodeType == 1){
	        			drawBusinessNode(edge.source.anchorId,sx,sy);
	        		} else if(edge.source.nodeType == 2 || edge.source.nodeType == 4){
	        			drawParkingNode(edge.source.anchorId,sx,sy);
	        		} else if(edge.source.nodeType == 3){
	        			drawAnchorNode(edge.source.anchorId,sx,sy);
	        		}
	        		if(edge.destination.nodeType == 1){
	        			drawBusinessNode(edge.destination.anchorId,dx,dy);
	        		} else if(edge.destination.nodeType == 2 || edge.destination.nodeType == 4){
	        			drawParkingNode(edge.destination.anchorId,dx,dy);
	        		} else if(edge.destination.nodeType == 3){
	        			drawAnchorNode(edge.destination.anchorId,dx,dy);
	        		}
	        		
	        		$('#map').html($('#map').html());
	        		originalMap = $('#map').html();
	        	});
	        }
	    });
	}
	
	function getMinMax(){
		$.ajax({
	        type: 'Post',
	        data:{
	            operation : "Retrive"
	        },
	        url: 'NodeServlet',
	        async: false,
	        success: function(response){
	        	$.each(response,function(i,node){
	        		if(xmax < node.xCo)
	        			xmax = node.xCo;
	        		if(ymax < node.yCo)
	        			ymax = node.yCo;
	            });
	        }
	    });
		caxis = ymax / 2;
	}
	
	function drawEdge(id,x1, y1, x2, y2){
		$('#map').append('<line class="edge" id="' + id +'" x1="'+ x1 +'" y1="'+ y1 +'" x2="'+ x2 +'" y2="'+ y2 +'">');
	}
	
	function drawCurve(id,x1, y1,r, cf , x2, y2) {
		$('#map').append('<path class="curve" id="' + id +'" d="M'+ x1 +' '+ y1 +' A '+ r +' '+ r +', 0, 0 ,'+ cf +' , ' + x2 + ' ' + y2 + '" ">');
	}
	
	function drawBusinessNode(id,x , y){
		$('#map').append('<circle class="nodes bnode" id="' + id +'" r="700" cx="'+ x +'" cy="'+ y +'">' + 
				'<title>Station: Anchor no..> ' + id +'</title></circle>');
		}
	
	function drawParkingNode(id,x , y){
		$('#map').append('<circle class="nodes pnode" r="700" id="' + id +'" cx="'+ x +'" cy="'+ y +'">' + 
				'<title>Parking: Anchor no..> ' + id +'</title></circle>');
	}
	
	function drawAnchorNode(id,x, y){
		$('#map').append('<circle class="nodes anode" id="' + id +'" r="500" cx="'+ x +'" cy="'+ y +'">' +
				'<title>Anchor no..> ' + id +'</title></circle>');
		$('#map').append('<circle class="nodes anode" r="200" cx="'+ x +'" cy="'+ y +'" >' + 
				'<title>Anchor no..> ' + id +'</title></circle>');
	}
	
	function plotLegent() {
		$('#map').append('<path d="M74500 0 L 74500 0 L 74500 11000 L 83200 11000 L 83200 0 L 74500 0 L74500 1500 L 83200 1500" fill="none" stroke="red" stroke-width="210"/>');
		$('#map').html($('#map').html());
	}
	
	function drawAgv(name,sid){
		var x = $('#map #' + sid +'.nodes').attr("cx");
		var y = $('#map #' + sid +'.nodes').attr("cy");
		$('#map').append('<text style="cursor:default" x="' + (x - 900) +'" y="'+ (y-200) +' "><title>' + name + ' on Anchor: ' + sid + '</title>&#xf041;</text>');
	    $('#map').html($('#map').html());
	}
	
	function printAgv(){
		$.ajax({
            type: 'POST',
            data:{},
            url: 'AgvDataServlet',
            asunc: false,
            success: function(response) {
            	$('#map').html(originalMap);
            	$(response).each(function(i,agv){
            		if(!(typeof(agv.position) == 'undefined')){
	            		var color = (agv.id == 1) ? "red" : "#69157c";
	            		drawAgv(agv.name,agv.position.anchorId);
	            		getSignals(agv.id,color);
            		}
            	});
            }
        });
	}
	
	function getSignals(id,color){
		$.ajax({
            type: 'GET',
            data:{},
            url: 'ActiveSignals',
           	success: function(response) {
           		$.each(response.signals.entry,function(i,val){
           			if(val.value == id){
           				$('#'+val.key+'.nodes').css("fill",color);
           				$('#map').html($('#map').html());
           			}	
           		})
            }
        });
	}
	
});

