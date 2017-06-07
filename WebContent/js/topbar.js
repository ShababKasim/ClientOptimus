 $(document).ready(function(){
                    
                    setInterval(function() {
                        time();
                        date();
                    }, 1000);
                    
                    getActiveNodes();
                	getAgvErrors();
                	getIsErrors();
                    
                    setInterval(function() {
                    	getActiveNodes();
                    	getAgvErrors();
                    	getIsErrors();
                    }, 5000);
                    
                    
                    
                    function time() {
                        var date = new Date();
                        var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
                        var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
                        var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
                        var time = hours + ":" + minutes + ":" + seconds;
                        $("#time").html("Time: " + time);
                    }
                    
                    function date(){
                        var date = new Date();
                        $("#date").html(date.toDateString());
                    }
                    
                     $(document).on('click', 'a[id=logout]', function(e) {
                        $("#signout").submit(); 
                     });
                     
                     function getActiveNodes(){
                    	 $.ajax({
                             type: 'GET',
                             url: 'ActiveNodes',
                             success: function(res){
                                 $('.active-node').html(res);
                             }
                         });
                     }
                     
                     function getAgvErrors(){
                    	 $.ajax({
                             type: 'GET',
                             url: 'AgvDataServlet',
                             data:{
                            	 action : "errormessage"
                             },
                             success: function(res){
                            	 $('.agv-info').html('');
                            	 $.each(res,function(i,val){
                                	$('.agv-info').append('<li><a href="#"><i class="fa fa-truck"></i>'+ val +'</li>'); 
                                 });
                             }
                         });
                     }
                     
                     function getIsErrors(){
                    	 $.ajax({
                             type: 'GET',
                             url: 'AgvDataServlet',
                             data:{
                            	 action : "errorboolean"
                             },
                             success: function(res){
                            	 $('.agv-errors').html('<i class="fa fa-truck fa-fw"></i>');
                            	 if(res == 0){
                            		 $('.agv-errors').append('<span class="badge badge-yellow"><i class="fa fa-check fa-fw"></i></span>');
                            	 } else {
                            		 $('.agv-errors').append('<span class="badge badge-red"><strong>!</strong></span>');
                            	 }
                            		  
                             }
                         });
                     }
                     
                });