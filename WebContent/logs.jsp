<!DOCTYPE html>
<% 
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setHeader("Expires", "0"); // Proxies.	
	if(session.getAttribute("name") == null){
		response.sendRedirect("Login.jsp");
} %>
<html lang="en">
<head>
    <title>Logs | Optimus</title>
    <meta charset="utf-8">
   <% 
    Integer priv = (Integer) session.getAttribute("privilege");
    if(priv != null)
    	if(priv == 1 || priv == 2){
//     		out.print("<Meta HTTP-EQUIV='refresh' Content='"+ session.getMaxInactiveInterval() +"' URL='Logout.jsp' >");
    	} %>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   	<link rel='shortcut icon' href='images/Agv.png' >
	<link rel='icon' href='images/Agv.png'>	
   	<!--Loading bootstrap css-->
    <link type="text/css" rel="stylesheet" href="styles/jquery-ui-1.10.4.custom.min.css">
    <link type="text/css" rel="stylesheet" href="styles/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="styles/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="styles/animate.css">
    <link type="text/css" rel="stylesheet" href="styles/all.css">
    <link type="text/css" rel="stylesheet" href="styles/main.css">
    <link type="text/css" rel="stylesheet" href="styles/style-responsive.css">
    <link type="text/css" rel="stylesheet" href="styles/datepicker.css">
    <script src="js/jquery-1.10.2.min.js"></script>
	<script src="js/datepicker.js"></script>
	<script src="js/logs.js"></script>
	
   
   
</head>
<body>
    <div>
        <!--BEGIN BACK TO TOP-->
        <a id="totop" href="#"><i class="fa fa-angle-up"></i></a>
        <!--END BACK TO TOP-->
        <!--BEGIN TOPBAR-->
        <div id="header-topbar-option-demo" class="page-header-topbar">
            <nav id="topbar" role="navigation" style="margin-bottom: 0;"
                data-step="3" class="navbar navbar-default navbar-static-top">
                <div class="navbar-header">
                    <div class="col-md-3">
                        <a id="logo" href="index.jsp" class="navbar-brand"> <span
                            class="fa fa-rocket"></span> <span class="logo-text">Optimus</span>
                        </a>
                        <button type="button" data-toggle="collapse"
                            data-target=".sidebar-collapse" class="navbar-toggle">
                            <span class="sr-only">Toggle navigation</span><span
                                class="icon-bar"></span><span class="icon-bar"></span><span
                                class="icon-bar"></span>
                        </button>
                    </div>
                </div>
                <script src="js/topbar.js"></script>
                <div class="topbar-main">
                    <a id="menu-toggle" href="#" class="hidden-xs"> <i
                        class="fa fa-bars"></i></a>

                    <div class="news-update-box hidden-xs">
                        <span class="text-uppercase mrm  text-white"></span> <span
                            class="text-green" id="time"></span> <span class="text-green"
                            id="date"></span>
                    </div>
                    <ul class="nav navbar navbar-top-links navbar-right mbn">
                       	<li class="dropdown">
                       		<a data-hover="dropdown" href="#" class="dropdown-toggle agv-errors"><i class="fa fa-truck fa-fw"></i>
	                    	</a>
							<ul class="dropdown-menu dropdown-user pull-right agv-info">
                                
                            </ul></li>	                        	  
                        <li class="dropdown"><a data-hover="dropdown" href="#"
                               class="dropdown-toggle"><i class="fa fa-microchip fa-fw"></i><span
                                   class="badge badge-blue active-node"></span></a></li>
                        <li class="dropdown topbar-user"><a data-hover="dropdown"
                            href="#" class="dropdown-toggle"> <img
                                src="images/profile-pic.png" alt=""
                                class="img-responsive img-circle" />&nbsp; <span
                                class="hidden-xs"><%= session.getAttribute("name") %></span>&nbsp;
                                <span class="caret"></span></a>
                            <form method="Post" action="Login" id="signout">
                                <input type="hidden" name="action" value="Logout" />
                            </form>
                            <ul class="dropdown-menu dropdown-user pull-right">
                                <li><a href="#"><i class="fa fa-user"></i>My Profile</a></li>
                                <li><a id="logout" style="cursor: pointer"><i
                                        class="fa fa-key"></i>Log Out</a></li>
                            </ul></li>
                    </ul>

                </div>
            </nav>
            
        </div>

        <!--END TOPBAR-->
        <div id="wrapper">
            <!--BEGIN SIDEBAR MENU-->
            <nav id="sidebar" role="navigation" data-step="2" data-intro="Template has &lt;b&gt;many navigation styles&lt;/b&gt;"
                data-position="right" class="navbar-default navbar-static-side">
            <div class="sidebar-collapse menu-scroll">
                <ul id="side-menu" class="nav">

                        <div class="clearfix"></div>

                         <% 
						out.print("<li><a href='dashboard.jsp'><i " +
                                "class='fa fa-tachometer fa-fw'> </i><span class='menu-title'>Dashboard</span></a></li>");
                       	out.print("<li><a href='queue.jsp'><i class='fa fa-list fa-fw'> " +
	                            "</i><span class='menu-title'>Ticket Queue</span></a></li>");
						out.print("<li><a href='map.jsp'><i " +
                                "class='fa fa-location-arrow fa-fw'> </i><span class='menu-title'>Live" +
                                "Map</span></a></li>");
						if(priv != null){
							if(priv == 1 || priv == 2){
								out.print(" <li><a href='map-entry.jsp'><i " +
		                                "class='fa fa-edit fa-fw'> </i><span class='menu-title'>Map" +
		                                "Entry</span></a></li>");
								out.print("<li><a href='agv-entry.jsp'><i class='fa fa-edit fa-fw'>" +
			                            "</i><span class='menu-title'>Agv Entry</span></a></li>");
								out.print("<li><a href='diagnostic.jsp'><i " +
		                                "class='fa fa-stethoscope fa-fw'> </i><span class='menu-title'>Diagnostic</span></a></li>");
								out.print(" <li class='active'><a href='logs.jsp'><i class='fa fa-list-alt fa-fw'>" +
			                            	"</i><span class='menu-title'>Logs</span></a></li>");
								if(priv != null){
									if(priv == 1){
									out.print("<li><a href='users.jsp'><i class='fa fa-user fa-fw'>" +
				                            "</i><span class='menu-title'>Manage Users</span></a></li>");
								}}
								out.print("<li><a href='power.jsp'><i class='fa fa-power-off fa-fw'>" +
			                            "</i><span class='menu-title'>Power Optimus</span></a></li>");
							}
						}
						
						%>
					</ul>

            </div>
        </nav>
          
          	      
            <div id="page-wrapper">
                <!--BEGIN CONTENT-->
                <div class="page-content">
                    <div id="tab-general">
                        <div class="row mb1">
                        	
                        	<div class="panel">
                        		<div class="panel-body">
	                        		<div class="row">
	                        			<div class="col-lg-12 col-md-12 col-sm-12">
	                        				<H1>Optimus Logs</H1>
	                        				<hr>
	                        			</div>
	                        		</div>
                        			<div class="row">
                        				<div class="col-lg-9 col-md-9 col-sm-9">
		                        			<table class="table table-bordered table-strpped">
		                        				<thead>
		                        					<tr>
			                        					<th class="text-center col-lg-2 col-md-2 col-sm-2">Logger</th>
			                        					<th class="text-center col-lg-2 col-md-2 col-sm-2">Start date</th>
			                        					<th class="text-center col-lg-2 col-md-2 col-sm-2">End date</th>
			                        					<th class="text-center col-lg-1 col-md-1 col-sm-1"></th>
			                        				</tr>
		                        				</thead>
		                        					<tr>
		                        						<td><div class="form-group" id="value-users">
                                                                 <select class="form-control" id="user">
                                                                 	<option value='All'>All</option>
                                                                 </select>
                                                            </div></td>
		                        						<td><div class="form-group" id="value-start">
                  													<input class="form-control" type="text" id="start" name="date" placeholder="yyyy-MM-dd HH:mm:ss" />
															</div></td>
		                        						<td><div class="form-group" id="value-end">
                       											<input class="form-control" type="text" id="end" name="date" placeholder="yyyy-MM-dd HH:mm:ss"/>
               												</div></td>
		                   								<td><div class="form-group" id="value-submit">
		                                                                        <button id="submit-logs" class="btn btn-warning ">Submit</button>
		                                                                    </div></td>
		                        					</tr>
		                        			</table>
		                        		</div>
                        			</div>
                        		</div>
                        	</div>
                        	
                        	<div class="panel">
                        		<div class="panel-body">
                        			<div style="width:100%;height:450px;margin: 0px auto;margin: 20px 0px;background-color: white;border: 1px solid #333;overflow: auto;">
                        					<div class="console" style="margin-left:10px;margin-top:5px; font-family: Courier New, Courier, monospace;  font-size: 11px;  "></div>
                        				</div>
                        		
                        		</div>
                        	</div>
                        	
                            <div class="col-md-12">
                                 <div id="area-chart-spline" style="width: 100%; height: 300px; display: none;"></div>
                            </div>
                		</div>
                	</div>
        		</div>
    
    <div id="footer">
    	<div class="copyright">2014 © KAdmin Responsive</div>
    </div>
    	</div>
  </div>
  </div>
<!--     <script src="script/jquery-1.10.2.min.js"></script> -->
    <script src="script/jquery-migrate-1.2.1.min.js"></script>
<!--     <script src="script/jquery-ui.js"></script> -->
    <script src="script/bootstrap.min.js"></script>
    <script src="script/bootstrap-hover-dropdown.js"></script>
    <script src="script/html5shiv.js"></script>
    <script src="script/respond.min.js"></script>
    <script src="script/jquery.metisMenu.js"></script>
    <script src="script/jquery.slimscroll.js"></script>
    <script src="script/jquery.cookie.js"></script>
    <script src="script/custom.min.js"></script>
    <script src="script/jquery.menu.js"></script>
    <script src="script/responsive-tabs.js"></script>
    <script src="script/jquery.flot.js"></script>
    <script src="script/jquery.flot.categories.js"></script>
    <script src="script/jquery.flot.pie.js"></script>
    <script src="script/jquery.flot.tooltip.js"></script>
    <script src="script/jquery.flot.resize.js"></script>
    <script src="script/jquery.flot.fillbetween.js"></script>
    <script src="script/jquery.flot.stack.js"></script>
    <script src="script/jquery.flot.spline.js"></script>
    <script src="script/animation.js"></script>
    <script type="text/javascript">
		$(function() {
			$('*[name=date]').appendDtpicker();
		});
	</script>
    <!--CORE JAVASCRIPT-->
   </body>
</html>
