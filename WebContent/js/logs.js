$(document).ready(function(){
	
	var anchors = getLoggers();
	
	$.each(anchors, function(i, val){
        $("#user").append('<option value="' + val + '">'+ val +'</option>');
    });
	
	
	$('#value-submit').click(function(){
		var user = $('#user').val();
		var start = $('#start').val();
		var end = $('#end').val();
		
		var ret = validate(user, start, end);
		if(ret == 2) {
	        $.ajax({
	            type: 'Post',
	            data:{
	            	user : user,
	            	start : start,
	            	end : end,
	                action : "getlogs"
	            },
	            url: 'LogsServlet',
	            success: function(response){
	            	$('.console').html('');
	            	$(response).each(function(i,val){
	            		var prev = $(".console").html();
	            		var message = val.userid + " | " + val.date + " | " + val.level + " | " + val.message;
		            	$(".console").html(prev + message + "<br>");
	                });
	            }
	        });
		}
	});
	
	
	function validate(user, start, end){
		var duplicate = false;
      var suc = 0; 
      if( start !== ''){
            $("#value-start").removeClass("has-warning");
            $(".start").remove();
            suc++; 
        } else {
            $(".start").remove();
            $("#value-start").addClass("has-warning");
            $("#value-start").append('<span class="help-block text-center start">Enter Something</span>');
        }   
        if( end !== ''){
            $("#value-end").removeClass("has-warning");
            $(".end").remove();
            suc++;
        } else {
            $(".end").remove();
            $("#value-end").addClass("has-warning");
            $("#value-end").append('<span class="help-block text-center end">Enter Something</span>');
        }
        return suc;
	}
	
	 function getLoggers(){
	        var values = [''];
	        $.ajax({
	            type: 'Post',
	            data:{
	                action : "getusers"
	            },
	            async: false,
	            url: 'LogsServlet',
	            success: function(response){
	                values = response;
	            }
	        });
	        return values;
	    }
	
});