/**
 * 
 */

$(document).ready(function(){

    var NodeId = 1;var EdgeId = 1;var BusinessId = 1;
    var nsuccess = 0;var bsuccess = 0;var esuccess = 0;
    var panchor = 0; var pnrid = 0; var psrc = 0; var pdest = 0;
    

    $(".content-value-node").hide();
    $(".content-value-edge").hide();
    $(".content-value-business").hide();

    var display = $(".content-type").attr("value");
   
    init(display);
  
    
    $("#pan-next").click(function(){
         
         var display = $(".content-type").attr("value");
         
         if(display == "node"){
             $(".content-type").attr("value","business");
             init("business");
             
         } else if(display == "business"){
             $(".content-type").attr("value","edge");
             init("edge");
         }
    });
    
    $("#pan-previous").click(function(){
        
        var display = $(".content-type").attr("value");
         
        if(display == "business"){
             $(".content-type").attr("value","node");
             init("node");
             
        } else if(display == "edge"){
             $(".content-type").attr("value","business");
             init("business");
        }

   });



    //TODO CHeck for duplicate entries
    function validateInputNode(anchor, xco, yco){
            
            var duplicate = false;
         
            if( !Number.isNaN(parseInt(anchor)) && anchor !== '' && duplicate == false){
                $("#value-anchor").removeClass("has-warning");
                $(".anchor").remove();
                nsuccess++; 
            } else {
                $(".anchor").remove();
                $("#value-anchor").addClass("has-warning");
                $("#value-anchor").append('<span class="help-block text-center anchor">Invalid input</span>');
            }   
            if( !Number.isNaN(parseInt(xco)) && xco !== ''){
                $("#value-xco").removeClass("has-warning");
                $(".xco").remove();
                nsuccess++;
            } else {
                $(".xco").remove();
                $("#value-xco").addClass("has-warning");
                $("#value-xco").append('<span class="help-block text-center xco">Invalid input</span>');
            }
            if( !Number.isNaN(parseInt(yco)) && yco !== ''){
                $("#value-yco").removeClass("has-warning");
                $(".yco").remove();
                nsuccess++;
            } else {
                $(".yco").remove();
                $("#value-yco").addClass("has-warning");
                $("#value-yco").append('<span class="help-block text-center yco">Invalid input</span>');
            }
    }

    function displayNodeVal(anchor,xco,yco,type){
        $("#value-display").append('<tr>'+ 
                '<td class="text-center">' + NodeId++ + '</td>' + 
                '<td id='+anchor+' class="text-center dis-anchor">' + anchor + '</td>' +
                '<td id='+anchor+' class="text-center dis-xco">' + xco + '</td>' +
                '<td id='+anchor+' class="text-center dis-yco">' + yco + '</td>' + 
                '<td id='+anchor+' class="text-center dis-type">' + type + '</td>' +
                '<td class="text-center">' + '<a href="#" id="edit-value-node" value=' + anchor + 
                '><i class="fa fa-edit fa-fw"></i></a>' + '</td>' +
                '<td class="text-center">' + '<a style="cursor:pointer" id="value-delete-node" value=' + anchor + 
                '><i class="fa fa-trash-o fa-fw"></i></a>' + '</td>' +
                '</tr>'
        );  
    };

    function clearNodeValues(){
        NodeId = 1;

        $("#value-display").html('<thead>' + '<tr>' +
                '<th class="text-center col-md-1">#</th>' +
                '<th class="text-center">Anchor</th>' +
                '<th class="text-center">X - Co</th>' +
                '<th class="text-center">Y - CO</th>' +
                '<th class="text-center col-md-2">type</th>' +
                '<th class="text-center col-md-1"><i class="fa fa-edit"></i></th>' +
                '<th class="text-center col-md-1"><i class="fa fa-trash-o"></i></th>' +
                '</tr></thead>'
        );
    };

    function createNodes(anchor,xco,yco,type){
       $.ajax({
            type: 'Post',
            data:{
                anchor : anchor,
                xco : xco,
                yco : yco,
                type : type,
                operation : "Create"
            },
            url: 'NodeServlet',
            success: function(responseJson){
                $("#id").val('');
                $("#anchor").val('');
                $("#xco").val('');
                $("#yco").val('');  
                displayNodes();
            }
        });
    }
    
    function editNodes(panchor,anchor,xco,yco,type){
        $.ajax({
             type: 'Post',
             data:{
                 anchor : anchor,
                 panchor: panchor,
                 xco : xco,
                 yco : yco,
                 type : type,
                 operation : "Update"
             },
             url: 'NodeServlet',
             success: function(responseJson){
                 $("#id").val('');
                 $("#anchor").val('');
                 $("#xco").val('');
                 $("#yco").val('');  
                 displayNodes();
             }
         });
     }

    function displayNodes(){
        $.ajax({
            type: 'Post',
            data:{
                operation : "Retrive"
            },
            url: 'NodeServlet',
            success: function(responseJson){
                clearNodeValues();
                $.each(responseJson, function(index, node) {    
                    var type = node.nodeType;
                    var type1 = (type == 3) ? "Other" : (type == 2 ) ? "Parking" : (type == 4 ) ? "Charging" : "Business";
                    displayNodeVal(node.anchorId, node.xCo, node.yCo, type1);    
                });
            }
        });
    }        

    //TODO CHeck for duplicate entries
    function validateInputEdge(src, dest, distance, radius){
        if( !Number.isNaN(parseInt(distance)) && distance !== ''){
            $("#value-distance").removeClass("has-warning");
            $(".distance").remove();
            esuccess++; 
        } else {
            $(".distance").remove();
            $("#value-distance").addClass("has-warning");
            $("#value-distance").append('<span class="help-block text-center distance">Invalid input</span>');
        }
        if( !Number.isNaN(parseInt(radius)) && radius !== ''){
            $("#value-radius").removeClass("has-warning");
            $(".radius").remove();
            esuccess++; 
        } else {
            $(".radius").remove();
            $("#value-radius").addClass("has-warning");
            $("#value-radius").append('<span class="help-block text-center radius">Invalid input</span>');
        }   
        if( src !== dest){
            $("#value-src").removeClass("has-warning");
            $(".src").remove();
            $("#value-dest").removeClass("has-warning");
            $(".dest").remove();
            esuccess++; 
        } else {
            $(".src").remove();
            $("#value-src").addClass("has-warning");
            $("#value-src").append('<span class="help-block text-center src">Source equals Destination</span>');
            $(".dest").remove();
            $("#value-dest").addClass("has-warning");
            $("#value-dest").append('<span class="help-block text-center dest">Destination equals Source</span>');
        }   
    }

    function displayEdgeVal(src,dest,distance,radius){
        $("#value-display").append('<tr>'+ 
                '<td class="text-center">' + ++EdgeId + '</td>' + 
                '<td id='+EdgeId+' class="text-center dis-src">' + src + '</td>' +
                '<td id='+EdgeId+' class="text-center dis-dest">' + dest + '</td>' +
                '<td id='+EdgeId+' class="text-center dis-distance">' + distance + '</td>' + 
                '<td id='+EdgeId+' class="text-center dis-radius">' + radius + '</td>' +
                '<td class="text-center">' + '<a href="#" id="edit-value-edge" eid='+EdgeId+'><i class="fa fa-edit fa-fw"></i></a>' + '</td>' +
                '<td class="text-center">' + '<a style="cursor:pointer" id="value-delete-edge" src=' + src + 
                ' dest='+ dest +' ><i class="fa fa-trash-o fa-fw"></i></a>' + '</td>' +
                '</tr>'
        );  
    };

    function clearEdgeValues(){
        EdgeId = 0;

        $("#value-display").html('<thead>' + '<tr>' +
                '<th class="text-center col-md-1">#</th>' +
                '<th class="text-center">Source Anc.</th>' +
                '<th class="text-center">Dest Anc.</th>' +
                '<th class="text-center">Distance</th>' +
                '<th class="text-center col-md-2">Radius</th>' +
                '<th class="text-center col-md-1"><i class="fa fa-edit"></i></th>' +
                '<th class="text-center col-md-1"><i class="fa fa-trash-o"></i></th>' +
                '</tr></thead>'
        );
    };

    function displayEdges(){
        $.ajax({
            type: 'Post',
            data:{
                operation : "Retrive"
            },
            url: 'EdgeServlet',
            success: function(response){
                clearEdgeValues();
                $.each(response, function(index, edge) {    
                    displayEdgeVal(edge.source.anchorId, edge.destination.anchorId, edge.distance, edge.radius);    
                });
            }
        });
    }

    function createEdge(src,dest,distance,radius){

    	$.ajax({
            type: 'Post',
            data:{
                src : src,
                dest : dest,
                distance : distance,
                radius : radius,
                operation : "Create"
            },
            url: 'EdgeServlet',
            success: function(responseJson){
                $("#distance").val('');
                $("#radius").val('');   
                displayEdges();
            }
        });
    }

    function editEdge(psrc,pdest,src,dest,distance,radius){

    	$.ajax({
            type: 'Post',
            data:{
                psrc : psrc,
                pdest: pdest,
            	src : src,
                dest : dest,
                distance : distance,
                radius : radius,
                operation : "Update"
            },
            url: 'EdgeServlet',
            success: function(responseJson){
                $("#distance").val('');
                $("#radius").val('');   
                displayEdges();
            }
        });
    }
    
    //TODO CHeck for duplicate entries
    function validateInputBusiness(nrid, anchor, label){
    	
    	if( !Number.isNaN(parseInt(nrid)) && nrid !== ''){
            $("#value-nrid").removeClass("has-warning");
            $(".nrid").remove();
            bsuccess++; 
        } else {
            $(".nrid").remove();
            $("#value-nrid").addClass("has-warning");
            $("#value-nrid").append('<span class="help-block text-center nrid">Enter Some value</span>');
        }
    	if( anchor !== ''){
            $("#value-anchor").removeClass("has-warning");
            $(".anchor").remove();
            bsuccess++; 
        } else {
            $(".anchor").remove();
            $("#value-anchor").addClass("has-warning");
            $("#value-anchor").append('<span class="help-block text-center anchor">Enter Some value</span>');
        }
        if( label !== ''){
            $("#value-label").removeClass("has-warning");
            $(".label-name").remove();
            bsuccess++; 
        } else {
            $(".label-name").remove();
            $("#value-label").addClass("has-warning");
            $("#value-label").append('<span class="help-block text-center label-name">Invalid input String</span>');
        }
    }

    function displayBusinessVal(nrid, anchor, label){
        $("#value-display").append('<tr>'+ 
                '<td id='+nrid+' class="text-center dis-nrid">' + nrid + '</td>' + 
                '<td id='+nrid+' class="text-center dis-anchor">' + anchor + '</td>' +
                '<td id='+nrid+' class="text-center dis-label">' + label + '</td>' +
                '<td class="text-center">' + '<a href="#" id="edit-value-business" value=' + nrid + 
                ' ><i class="fa fa-edit fa-fw"></i></a>' + '</td>' +
                '<td class="text-center">' + '<a style="cursor:pointer" id="value-delete-business" value=' + nrid + 
                ' ><i class="fa fa-trash-o fa-fw"></i></a>' + '</td>' +
                '</tr>'
        );  
    };

    function clearBusinessValues(){
        BusinessId = 1;

        $("#value-display").html('<thead>' + '<tr>' +
                '<th class="text-center col-md-1">#</th>' +
                '<th class="text-center col-md-2">Anchor</th>' +
                '<th class="text-center col-md-6">Label</th>' +
                '<th class="text-center col-md-1"><i class="fa fa-edit"></i></th>' +
                '<th class="text-center col-md-1"><i class="fa fa-trash-o"></i></th>' +
                '</tr></thead>'
        );
    };

    function displayBusiness(){
        $.ajax({
            type: 'Post',
            data:{
                operation : "Retrive"
            },
            url: 'BusinessServlet',
            success: function(response){
                clearBusinessValues();
                $.each(response, function(index, business) {    
                    displayBusinessVal(business.nRid,business.aid,business.label);    
                });
            }
        });
    }
    
    function createBusiness(nrid,anchor,label){

       $.ajax({
            type: 'Post',
            data:{
                anchor : anchor,
                label : label,
                nrid : nrid,
                operation : "Create"
            },
            url: 'BusinessServlet',
            success: function(responseJson){
            	$("#nrid").val(''); 
            	$("#anchor").val('');
                $("#label").val('');   
                displayBusiness();
            }
        });
    }

    function editBusiness(pnrid,nrid,anchor,label){

        $.ajax({
             type: 'Post',
             data:{
                 pnrid : pnrid,
            	 anchor : anchor,
                 label : label,
                 nrid : nrid,
                 operation : "Update"
             },
             url: 'BusinessServlet',
             success: function(responseJson){
             	$("#nrid").val(''); 
             	$("#anchor").val('');
                 $("#label").val('');   
                 displayBusiness();
             }
         });
     }
    
    function getAnchors(){
        var values = [];
        $.ajax({
            type: 'Post',
            data:{
                operation : "Anchors"
            },
            async: false,
            url: 'NodeServlet',
            success: function(response){
                values = response;
            }
        });
        return values;
    }

    function getAllAnchors(){
        var values = [];
        $.ajax({
            type: 'Post',
            data:{
                operation : "allAnchors"
            },
            async: false,
            url: 'NodeServlet',
            success: function(response){
                values = response;
            }
        });
        return values;
    }

    $(document).on('click', 'button[id=value-input-node]', function(e) {

        var anchor = $("#anchor").val();
        var xco = $("#xco").val();
        var yco = $("#yco").val();
        var type = $("#type").val();

        validateInputNode(anchor, xco, yco);

        if(nsuccess == 3){
            createNodes(anchor,xco,yco,type);
            nsuccess = 0;
        }
    });

    $(document).on('click', 'button[id=value-input-edge]', function(e) {

        var src = $("#src").val();
        var dest = $("#dest").val();
        var distance = $("#distance").val();
        var radius = $("#radius").val();

        validateInputEdge(src, dest, distance, radius);
        
        if(esuccess == 3){
            createEdge(src,dest,distance,radius);
            esuccess = 0;
        }
    });
    
    $(document).on('click', 'button[id=value-input-business]', function(e) {

        var id = $("#nrid").val();
        var anchor = $("#anchor").val();
        var label = $("#label").val();
        
        validateInputBusiness(id, anchor, label);
        
        if(bsuccess == 3){
            createBusiness(id,anchor,label);
            bsuccess = 0;
        }
    });
    
    cancelEdit('node');
    cancelEdit('edge');
    cancelEdit('business');
    
    function cancelEdit(identifier){
    	$(document).on('click', 'button[id=cancel-'+identifier+']', function(e) {
    		if(identifier == 'node'){
    			$('#anchor').val('');$('#xco').val('');
    			$('#yco').val('');$('#type').val('');
    		} else if(identifier == 'edge'){
    			$('#src').val('');$('#dest').val('');
    			$('#distance').val('');$('#radius').val('');
    		} else{
    			$('#nrid').val('');$('#anchor').val('');
    			$('#label').val('');
    		}
        	$('.input-button').html('<button class="btn btn-warning" id="value-input-'+identifier+'"><i class="fa fa-plus fa-fw"></i>Add</button><hr>');
        });
    }
    $(document).on('click', 'button[id=edit-apply-node]', function(e) {
    	var anchor = $("#anchor").val();
        var xco = $("#xco").val();
        var yco = $("#yco").val();
        var type = $("#type").val();

        validateInputNode(anchor, xco, yco);
        
        if(nsuccess == 3){
            editNodes(panchor,anchor,xco,yco,type);
            $('.input-button').html('<button class="btn btn-warning" id="value-input-node"><i class="fa fa-plus fa-fw"></i>Add</button><hr>');
            nsuccess = 0;
        }
    });
    
    $(document).on('click', 'button[id=edit-apply-edge]', function(e) {
    	var src = $("#src").val();
        var dest = $("#dest").val();
        var distance = $("#distance").val();
        var radius = $("#radius").val();

        validateInputEdge(src, dest, distance, radius);
        
        if(esuccess == 3){
            editEdge(psrc,pdest,src,dest,distance,radius);
            $('.input-button').html('<button class="btn btn-warning" id="value-input-edge"><i class="fa fa-plus fa-fw"></i>Add</button><hr>');
            esuccess = 0;
        }
    });
    
    $(document).on('click', 'button[id=edit-apply-business]', function(e) {
    	var id = $("#nrid").val();
        var anchor = $("#anchor").val();
        var label = $("#label").val();
        
        validateInputBusiness(id, anchor, label);
        
        if(bsuccess == 3){
            editBusiness(pnrid,id,anchor,label);
            $('.input-button').html('<button class="btn btn-warning" id="value-input-business"><i class="fa fa-plus fa-fw"></i>Add</button><hr>');
            bsuccess = 0;
        }
    });
    
    $(document).on('click', 'a[id=edit-value-node]', function(e) {
        var id = $(this).attr("value");
        $('#anchor').val($('#'+ id + '.dis-anchor').html());
        $('#xco').val($('#'+ id + '.dis-xco').html());
        $('#yco').val($('#'+ id + '.dis-yco').html());
        $('#type').val($('#'+ id + '.dis-value').html());
        
        panchor = id;
        
        $('.input-button').html('<button class="btn btn-success pull-left" id="edit-apply-node">Apply</button>'+
			'<button class="btn btn-danger pull-right" id="cancel-node">cancel</button><br><br><hr>');
        
    });

    $(document).on('click', 'a[id=edit-value-business]', function(e) {
        var id = $(this).attr("value");
        $('#nrid').val($('#'+ id + '.dis-nrid').html());
        $('#anchor').val($('#'+ id + '.dis-anchor').html());
        $('#label').val($('#'+ id + '.dis-label').html());
        
        pnrid = id;
        
        $('.input-button').html('<button class="btn btn-success pull-left" id="edit-apply-business">Apply</button>'+
		'<button class="btn btn-danger pull-right" id="cancel-business">cancel</button><br><br><hr>');
        
    });

    $(document).on('click', 'a[id=edit-value-edge]', function(e) {
        var id = $(this).attr("eid");
        $('#src').val($('#'+ id + '.dis-src').html());
        $('#dest').val($('#'+ id + '.dis-dest').html());
        $('#distance').val($('#'+ id + '.dis-distance').html());
        $('#radius').val($('#'+ id + '.dis-radius').html());
        
        psrc = src; pdest = dest;
        
        $('.input-button').html('<button class="btn btn-success pull-left" id="edit-apply-edge">Apply</button>'+
		'<button class="btn btn-danger pull-right" id="cancel-edge">cancel</button><br><br><hr>');
        
    });

    function node(){

        displayNodes();
      
        $(document).on('click', 'a[id=value-delete-node]', function(e) {
            var anchor = $(this).attr("value");
            $.ajax({
                type: 'Post',
                data:{
                    anchor : anchor,
                    operation : "Delete"
                },
                url: 'NodeServlet',
                success: function(result){
                    displayNodes();
                }
            }); 
            alert('Value Deleted');
        });
    }
    
    function edge(){

        displayEdges();
        var anchors = getAllAnchors();

        $.each(anchors, function(i, val){
            $("#src").append('<option value=' + val + '>'+ val +'</option>');
            $("#dest").append('<option value=' + val + '>'+ val +'</option>');
        });

        $(document).on('click', 'a[id=value-delete-edge]', function(e) {
            var src = $(this).attr("src");
            var dest = $(this).attr("dest");
            $.ajax({
                type: 'Post',
                data:{
                    src : src,
                    dest : dest,
                    operation : "Delete"
                },
                url: 'EdgeServlet',
                success: function(result){
                    displayEdges();
                }
            }); 
            alert('Value Deleted');
        });
        
    }
        
    function business(){

        displayBusiness();
        var anchors = getAnchors();

        $.each(anchors, function(i, val){
            $("#anchor").append('<option value=' + val + '>'+ val +'</option>');
        });

        $(document).on('click', 'a[id=value-delete-business]', function(e) {
            var nrid = $(this).attr("value");
            $.ajax({
                type: 'Post',
                data:{
                    nrid : nrid,
                    operation : "Delete"
                },
                url: 'BusinessServlet',
                success: function(result){
                    displayBusiness();
                }
            }); 
            alert('Value Deleted');
        });
    }

    function init(display){
        if(display == "node") {
            $(".content-type").html('');
            $(".content-type").html($(".content-value-node").html());
            $("#pan-previous").addClass("disabled");
            $("#pan-next").removeClass("disabled");
            node();
        } else if(display == "business") {
            $(".content-type").html('');
            $(".content-type").html($(".content-value-business").html());
            $("#pan-previous").removeClass("disabled");
            $("#pan-next").removeClass("disabled");
            business();
        } else if(display == "edge") {
            $(".content-type").html('');
            $(".content-type").html($(".content-value-edge").html());
            $("#pan-next").addClass("disabled");
            $("#pan-previous").removeClass("disabled");
            edge();
        } 
    }

});

