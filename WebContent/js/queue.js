
$(document).ready(function(){

	
	var business = getBusiness();
	
	clearQueue();
	displayQueue();
	$(".agv-data").html('');
	getAgvData();
	
	setInterval(function() {
		clearQueue();
		displayQueue();
		$(".agv-data").html('');
		getAgvData();
	}, 5000);
	
	
	
	
//	$("#spinner").html('');
	
	$(document).on('click', 'a[id=alter]', function(e) {
        var index1 = $(this).attr("value");
        var index2 = $(this).attr("index");
        alterTicket(index1, index2);
    });

	$(document).on('click', 'a[id=abort]', function(e) {
        var id = $(this).attr("value");
        if(confirm("Are you Serious?")){
        	$.ajax({
                type: 'Post',
                data:{
                	id : id,
                    operation : "uiAbort"
                },
                url: 'QueueServlet',
                success: function(response){
                    alert("Ticket Aborted");
                }
            });
        }         
    });
	
	$(document).on('click', 'a[id=delete]', function(e) {
        var index = $(this).attr("value");
        $.ajax({
            type: 'Post',
            data:{
            	index : index,
                operation : "Delete"
            },
            url: 'QueueServlet',
            success: function(response){
                displayQueue();
            }
        });
    });

	function displayQueue() {
		$.ajax({
            type: 'Post',
            data:{
                operation : "Retrive"
            },
            url: 'QueueServlet',
            success: function(response){
                clearQueue();
                for (var i = 0; i < response.length; i++) {
                	var index1 = ( i == 0 ) ? i : i - 1;
                	var index2 = ( i == response.length - 1 ) ? i : i + 1 ;
                    displayTicket(response[i].tid, resolveNode(response[i].pdestination), response[i].agvno , response[i].type, response[i].status, i, index1, index2);    
                }
            }
        });
	}

	function alterTicket(index1, index2) {
		$.ajax({
            type: 'Post',
            data:{
            	index1 : index1,
            	index2 : index2,
                operation : "Alter"
            },
            url: 'QueueServlet',
            success: function(response){
                clearQueue();
                displayQueue();
            }
        });
	}

	function resolveNode(nid){
		var label = '';
		$.each(business,function(i, bus){
			if(bus.nRid === nid)
				label = bus.label;	
		});
		if(label === '')
			return nid;
		else 
			return label;
	}

	function getBusiness(){
		var business = [];
		$.ajax({
            type: 'Post',
            data:{
            	operation : "Retrive"
            },
            url: 'BusinessServlet',
            async: false,
            success: function(responseJson){
                business = responseJson;
            }
        });
        return business;
	}

	function displayTicket(id, destination, agvno , type, status, index, index1, index2) {
		$("#tickets").append('<tr>'+ 
                '<td class="text-center">' + id + '</td>' + 
                '<td class="text-center">' + destination + '</td>' +
                '<td class="text-center">' + agvno + '</td>' +
                '<td class="text-center">' + type + '</td>' +
                '<td class="text-center">' + status + '</td>' + 
                '<td class="text-center">' + '<a style="cursor:pointer" id="alter" value=' + index1 + 
                ' index='+ index +'><i class="fa fa-chevron-circle-up fa-fw"></i></a>' + '<a style="cursor:pointer" id="alter" value=' + index2 + 
                ' index='+ index +'><i class="fa fa-chevron-circle-down fa-fw"></i></a>' + '</td>' +
                '<td class="text-center col-lg-1 col-md-1 col-sm-1"><a style="cursor:pointer" id="delete" value=' + index + '><i class="fa fa-trash-o fa-fw"></i></a></td>'+
                '</tr>');

	}

	function clearQueue(){
		$("#tickets").html('<thead><tr>' +
				'<th class="text-center col-lg-1 col-md-1 col-sm-1">#</th>' +
				'<th class="text-center col-lg-1 col-md-1 col-sm-1">Destination</th>' +
				'<th class="text-center col-lg-2 col-md-2 col-sm-2">Serving Agv No.</th>' +
				'<th class="text-center col-lg-2 col-md-2 col-sm-2">Type</th>' +
				'<th class="text-center col-lg-1 col-md-1 col-sm-1">Status</th>' +
				'<th class="text-center col-lg-1 col-md-1 col-sm-1">Alter</th>' +
				'<th class="text-center col-lg-1 col-md-1 col-sm-1"><i class="fa fa-trash-o fa-fw"></i></th>' +
			'</tr></thead>');
	}

	function getAgvData(){
		$.ajax({
            type: 'POST',
            data:{},
            url: 'AgvDataServlet',
            success: function(response){
            	displayServingInfo(response);
            }
        });
	}

	function displayServingInfo(data){
		$.each(data,function(i,val){
			$(".agv-data").append("<h3>"+ val.name +"</H3><hr>");
			$(".agv-data").append('<table class="table table-responsive table-bordered" id="data-'+ val.id +'"><thead><tr>' +
					'<th class="text-center col-lg-1 col-md-1 col-sm-1">#</th>' +
					'<th class="text-center col-lg-1 col-md-1 col-sm-1">Source</th>' +
					'<th class="text-center col-lg-2 col-md-1 col-sm-2">PDestination</th>' +
					'<th class="text-center col-lg-2 col-md-1 col-sm-2">SDestination</th>' +
					'<th class="text-center col-lg-1 col-md-1 col-sm-1">Agv No.</th>' +
					'<th class="text-center col-lg-1 col-md-1 col-sm-1">Type</th>' +
					'<th class="text-center col-lg-1 col-md-1 col-sm-1">Status</th>' +
					'<th class="text-center col-lg-1 col-md-1 col-sm-1">Abort</th>' +
					'</tr></thead></table>');
			if(!(typeof(val.servingTicket) == 'undefined')){
				$('#data-' + val.id).append('<tr>' +
						  '<td class="text-center">' + val.servingTicket.tid +'</td>' + 
						  '<td class="text-center">' + resolveNode(val.servingTicket.source) +'</td>' + 
						  '<td class="text-center">' + resolveNode(val.servingTicket.pdestination) +'</td>' + 
						  '<td class="text-center">' + resolveNode(val.servingTicket.sdestination) +'</td>' +
						  '<td class="text-center">' + val.servingTicket.agvno +'</td>' +
						  '<td class="text-center">' + val.servingTicket.type +'</td>' +
						  '<td class="text-center">' + val.servingTicket.status +'</td>' +
						  '<td class="text-center"><a style="cursor:pointer" id="abort" value=' + val.servingTicket.agvno + '><i class="fa fa-ban fa-fw"></i></a></td>'+
						  '</td></tr>');
			} else {
				$('#data-' + val.id).append('<tr>' + 
						'<td colspan="8" class="text-center"><strong> No Tickets Yet </strong>'
						+'</td></tr>');
			}
			
							
		});
	}


});