$(document).ready(function(){
	
	retriveUsers();
	
	$('#submit-values').click(function(){
		var username  = $('#username').val();
		var password = $('#password').val();
		var name = $('#name').val();
		var designation = $('#designation').val();
		var email = $('#email').val();
		var gender = $('#gender').val();
		var mobile = $('#mobile').val();
		var privilege = $('#privilege').val();
		
		var success = validateInputs(username,password,name,designation,email,mobile);
		if(success == 6){
			addUser(username,password,name,designation,email,gender,mobile,privilege);
		}
	});
	
	$(document).on('click', 'a[id=delete]', function(e) {
        var username = $(this).attr("value");
        $.ajax({
            type: 'Post',
            data:{
            	username : username,
                action : "Delete"
            },
            url: 'Login',
            success: function(response){
            	retriveUsers();
            }
        });
    });
	
	
	function validateInputs(username,password,name,designation,email,mobile){
		var success = 0;
		if( username !== '' ){
			$("#value-username").removeClass("has-warning");
			$(".username").remove();
			success++; 
		} else {
			$(".username").remove();
			$("#value-username").addClass("has-warning");
			$("#value-username").append('<span class="help-block text-center username">Invalid input</span>');
		}
		if( password !== '' ){
			$("#value-password").removeClass("has-warning");
			$(".password").remove();
			success++; 
		} else {
			$(".password").remove();
			$("#value-password").addClass("has-warning");
			$("#value-password").append('<span class="help-block text-center password">Invalid input</span>');
		}
		if( name !== ''){
			$("#value-name").removeClass("has-warning");
			$(".name").remove();
			success++; 
		} else {
			$(".name").remove();
			$("#value-name").addClass("has-warning");
			$("#value-name").append('<span class="help-block text-center name">Invalid input</span>');
		}
		if( designation !== '' ){
			$("#value-designation").removeClass("has-warning");
			$(".designation").remove();
			success++; 
		} else {
			$(".designation").remove();
			$("#value-designation").addClass("has-warning");
			$("#value-designation").append('<span class="help-block text-center designation">Invalid input</span>');
		}
		if( email !== '' ){
			$("#value-email").removeClass("has-warning");
			$(".email").remove();
			success++; 
		} else {
			$(".email").remove();
			$("#value-email").addClass("has-warning");
			$("#value-email").append('<span class="help-block text-center email">Invalid input</span>');
		}
		if( mobile !== '' ){
			$("#value-mobile").removeClass("has-warning");
			$(".mobile").remove();
			success++; 
		} else {
			$(".mobile").remove();
			$("#value-mobile").addClass("has-warning");
			$("#value-mobile").append('<span class="help-block text-center mobile">Invalid input</span>');
		}
		return success;
	}
	
	function retriveUsers(){
		$.ajax({
			type: 'Post',
			data:{
				action : "Retrive"
			},
			url: 'Login',
			success: function(response){
				clearValue();
				$(response).each(function(i,user){
					displayValue(user.username,user.password,user.name,user.designation,user.email,user.gender,user.mobile,user.privilege);
				});
			}
		});
	}
	
	function addUser(username,password,name,designation,email,gender,mobile,privilege){
		$.ajax({
			type: 'Post',
			data:{
				username : username,
				password : password,
				name : name,
				designation: designation,
				email : email,
				gender : gender,
				mobile : mobile,
				privilege: privilege,
				action : "Insert"
			},
			url: 'Login',
			success: function(response){
				$('#username').val('');
				$('#password').val('');
				$('#name').val('');
				$('#designation').val('');
				$('#email').val('');
				$('#mobile').val('');
				retriveUsers();
			}
		});
	}
	
	function displayValue(username,password,name,designation,email,gender,mobile,privilege){
		gender = gender ? "Male" : "Female";
		privilege = privilege == "1" ? "Super Admin" : privilege == "2" ? "Manager" : "Supervisor";  
		$("#user-display").append('<tr>'+ 
				'<td class="text-center">' + username + '</td>' + 
				'<td class="text-center">' + password + '</td>' +
				'<td class="text-center">' + name + '</td>' +
				'<td class="text-center">' + designation + '</td>' +
				'<td class="text-center">' + email + '</td>' +
				'<td class="text-center">' + gender + '</td>' + 
				'<td class="text-center">' + mobile + '</td>' + 
				'<td class="text-center">' + privilege + '</td>' + 
				'<td class="text-center"><a style="cursor:pointer" id="delete" value=' + username + '><i class="fa fa-trash-o fa-fw"></i></a></td>' +
				'</tr>'
		);  
	}
	
	function clearValue(){
		$('#user-display').html('<thead><tr> ' +
               ' <th class="text-center col-md-2 col-lg-2 col-sm-2">Username</th> ' +
               ' <th class="text-center col-md-1 col-lg-1 col-sm-1">Password</th> ' +
               ' <th class="text-center col-md-2 col-lg-2 col-sm-2">Name</th> ' +
               ' <th class="text-center col-md-1 col-lg-1 col-sm-1">Designation</th> ' +
                '<th class="text-center col-md-1 col-lg-1 col-sm-1">Email</th> ' +
                '<th class="text-center col-md-1 col-lg-1 col-sm-1">Gender</th> ' +
               ' <th class="text-center col-md-1 col-lg-1 col-sm-1">Mobile</th>' + 
               ' <th class="text-center col-md-1 col-lg-1 col-sm-1">Privilege</th>' +
               ' <th class="text-center col-md-1"><i ' +
                    'class="fa fa-trash-o fa-fw"></i></th>' +
            '</tr></thead>');
	}
	
});