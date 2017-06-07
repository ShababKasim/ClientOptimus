
$(document).ready(function(){
	
	var tempEditId = 0;
	
	retriveAgv();	
	
	$('#validate-agv').click(function(){
		var id = $('#id').val();
		var name = $('#name').val();
		var ip = $('#ip').val();
		var port = $('#port').val();

		var success = validateInput(id, name, ip, port);
		if(success == 4){
			pingAgv(ip, port);
			if($('.console').html() === "Success"){
				addAgv(id, name, ip, port);
			}
		}
	});
	
	$(document).on('click', 'a[id=delete]', function(e) {
        var id = $(this).attr("value");
        $.ajax({
            type: 'Post',
            data:{
            	id : id,
                action : "Delete"
            },
            url: 'AgvServlet',
            success: function(response){
            	retriveAgv();
            }
        });
    });

	$(document).on('click', 'button[id=cancel]', function(e){
		$('#id').val('');
		$('#name').val('');
		$('#ip').val('');
		$('#port').val('');

		$('.input-buttons').html('<button class="btn btn-success" id="validate-agv">Validate and Add</button>');
	});
	
	$(document).on('click', 'button[id=edit-validate-agv]', function(e){
		var pid =  tempEditId;
		var id = $('#id').val();
		var name = $('#name').val();
		var ip = $('#ip').val();
		var port = $('#port').val();

		var success = validateInput(id, name, ip, port);
		if(success == 4){
			pingAgv(ip, port);
			if($('.console').html() === "Success"){
				editAgv(pid,id, name, ip, port);
			}
		}
	});
	
	$(document).on('click', 'a[id=edit]', function(e) {
        var id = $(this).attr("value");
        tempEditId = id;
        $('#id').val($('#'+id+'.dis-id').html());
        $('#name').val($('#'+id+'.dis-name').html());
        $('#ip').val($('#'+id+'.dis-ip').html());
        $('#port').val($('#'+id+'.dis-port').html());
        
        $('.input-buttons').html('<button class="btn btn-success pull-left" id="edit-validate-agv">Apply and Add</button>'+
        		'<button class="btn btn-danger pull-right" id="cancel">cancel</button>');
       
    });
	
	function displayAgvVal(id, name, ipaddress, port, status){
		$("#agv-display").append('<tr>'+ 
				'<td id='+id+' class="text-center dis-id">' + id + '</td>' + 
				'<td id='+id+' class="text-center dis-name">' + name + '</td>' +
				'<td id='+id+' class="text-center dis-ip">' + ipaddress + '</td>' +
				'<td id='+id+' class="text-center dis-port">' + port + '</td>' +
				'<td class="text-center">' + status + '</td>' +
				'<td class="text-center"><a style="cursor:pointer" id="delete" value=' + id + '><i class="fa fa-trash-o fa-fw"></i></a></td>' +
				'<td class="text-center"><a href="#" id="edit" value=' + id + '><i class="fa fa-edit fa-fw"></i></a></td>' +
				'</tr>'
		);  
	};

	function clearAgvVal(){
		$("#agv-display").html('<thead><tr> '+
				' <th class="text-center col-md-1">#</th>' +
				'<th class="text-center col-md-3">Name</th>' +
				'<th class="text-center col-md-2">Ip address</th>' +
				'<th class="text-center col-md-1">Port</th>' +
				'<th class="text-center col-md-1">Status</th>' +
				'<th class="text-center col-md-1"><i ' +
				'class="fa fa-trash-o fa-fw"></i></th>' +
				'<th class="text-center col-md-1"><i ' +
				'class="fa fa-edit fa-fw"></i></th>' +
				'</tr></thead>'
		);  
	}

	function pingAgv(ip, port){
		$.ajax({
			type: 'Post',
			data:{
				ip : ip,
				port: port,
				action : "Ping"
			},
			async: false,
			url: 'AgvServlet',
			success: function(response){
				$('.console').html('');
				$(response).each(function(i,val){
					var prev = $(".console").html();
					$(".console").html(prev + val + "<br>");
				});
			}
		});
	}

	function removeAgv(id){
		$.ajax({
			type: 'Post',
			data:{
				id : id,
				action : "Delete"
			},
			url: 'AgvServlet',
			success: function(response){
				retriveAgv();
			}
		});
	}
	
	function editAgv(pid,id, name, ip, port){
		$.ajax({
			type: 'Post',
			data:{
				pid : pid,
				id : id,
				name : name,
				ip : ip,
				port: port,
				action : "Alter"
			},
			url: 'AgvServlet',
			success: function(response){
				$('#id').val('');
				$('#name').val('');
				$('#ip').val('');
				$('#port').val('');
				retriveAgv();
			}
		});
	}

	function addAgv(id, name, ip, port){
		$.ajax({
			type: 'Post',
			data:{
				id : id,
				name : name,
				ip : ip,
				port: port,
				action : "Insert"
			},
			url: 'AgvServlet',
			success: function(response){
				$('#id').val('');
				$('#name').val('');
				$('#ip').val('');
				$('#port').val('');
				retriveAgv();
			}
		});
	}
	
	function retriveAgv(){
		$.ajax({
			type: 'Post',
			data:{
				action : "Retrive"
			},
			url: 'AgvServlet',
			success: function(response){
				clearAgvVal();
				$(response).each(function(i,agv){
					displayAgvVal(agv.id, agv.name, agv.ipaddress, agv.port, agv.status)
				});
			}
		});
	}

	
	function validateInput(id, name, ip, port){
		var success = 0;
		if( id !== '' ){
			$("#value-id").removeClass("has-warning");
			$(".id").remove();
			success++; 
		} else {
			$(".id").remove();
			$("#value-id").addClass("has-warning");
			$("#value-id").append('<span class="help-block text-center id">Invalid input</span>');
		}
		if( name !== '' ){
			$("#value-name").removeClass("has-warning");
			$(".name").remove();
			success++; 
		} else {
			$(".name").remove();
			$("#value-name").addClass("has-warning");
			$("#value-name").append('<span class="help-block text-center name">Invalid input</span>');
		}
		if( validateIp(ip)){
			$("#value-ip").removeClass("has-warning");
			$(".ip").remove();
			success++; 
		} else {
			$(".ip").remove();
			$("#value-ip").addClass("has-warning");
			$("#value-ip").append('<span class="help-block text-center ip">Invalid ipaddress</span>');
		}
		if( port !== '' ){
			$("#value-port").removeClass("has-warning");
			$(".port").remove();
			success++; 
		} else {
			$(".port").remove();
			$("#value-port").addClass("has-warning");
			$("#value-port").append('<span class="help-block text-center port">Invalid input</span>');
		}
		return success;
	}

	function validateIp(ipaddress){  
		if (/^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/.test(ipaddress)) {  
			return true;  
		}  
		return false;
	}  

	function popEdit(id){
		var tabledata = $('#' + id +'').html();
		
	}
	

});