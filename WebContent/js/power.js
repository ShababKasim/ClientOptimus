
$(document).ready(function(){

	init();
	getStatus();
	
	$("#power-on").click(function(){
		$.ajax({
	        type: 'Post',
	        data:{
	            action : "poweron"
	        },
	        url: 'PowerServlet',
	        async : false,
	        success: function(response){
	        	$(".console").html('');
	        	$.each(response,function(i,val){
	        		var prev = $(".console").html();
	            	$(".console").html(prev + val + "<br>");
	            });
	        }
	    });
		init();
	});
	
	$("#power-off").click(function(){
		$.ajax({
	        type: 'Post',
	        data:{
	            action : "poweroff"
	        },
	        url: 'PowerServlet',
	        async : false,
	        success: function(response){
	        	$(".console").html('');
	        	$.each(response,function(i,val){
	        		var prev = $(".console").html();
	            	$(".console").html( prev + val + "<br>");
	            });
	        }
	    });
		init();
		getStatus();
	});
	
	function init(){
		$.ajax({
	        type: 'Post',
	        data:{
	            action : "powerKey"
	        },
	        url: 'PowerServlet',
	        async : false,
	        success: function(response){
	        	if(response == 1){
	    			$("#power-on").addClass("disabled");
	    			$("#power-off").removeClass("disabled");
	    		} else {
	    			$("#power-off").addClass("disabled");
	    			$("#power-on").removeClass("disabled");
	    		}
	        },
	        error : function(res){
	        	$("#power-off").addClass("disabled");
	        	$("#power-on").addClass("disabled");
	        	$(".console").html( "Looks like Optimus Server is Off  <br>");
	        }
	    });
	}
	
	function getStatus(){
		$.ajax({
	        type: 'Post',
	        data:{
	            action : "powerstatus"
	        },
	        url: 'PowerServlet',
	        async : false,
	        success: function(response){
	        	$(".console").html('');
	        	$.each(response,function(i,val){
	        		var prev = $(".console").html();
	        		$(".console").html( prev + val + "<br>");
	            });
	        }
	    });
	}
	
});