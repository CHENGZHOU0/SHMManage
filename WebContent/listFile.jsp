<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
		<meta charset="utf-8" />
		<title>结构健康监测信息管理系统</title>

		<meta name="description" content="top menu &amp; navigation" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="assets/css/jquery-ui.custom.min.css" />
		<link rel="stylesheet" href="assets/css/chosen.min.css" />
		<link rel="stylesheet" href="assets/css/bootstrap-datepicker3.min.css" />
		<link rel="stylesheet" href="assets/css/bootstrap-timepicker.min.css" />
		<link rel="stylesheet" href="assets/css/daterangepicker.min.css" />
		<link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.min.css" />
		<link rel="stylesheet" href="assets/css/bootstrap-colorpicker.min.css" />
		<link rel="stylesheet" href="assets/css/dropzone.min.css" />

		<!-- text fonts -->
		<link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->
		<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->
		<script src="assets/js/ace-extra.min.js"></script>

		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
		
		
	</head>

	<body class="no-skin">
		<div id="navbar" class="navbar navbar-default    navbar-collapse       h-navbar ace-save-state">
			<div class="navbar-container ace-save-state" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="list_project" class="navbar-brand">
						<small>
							<i class="fa fa-leaf"></i>
							结构健康监测信息管理系统
						</small>
					</a>

					<button class="pull-right navbar-toggle navbar-toggle-img collapsed" type="button" data-toggle="collapse" data-target=".navbar-buttons,.navbar-menu">
						<span class="sr-only">Toggle user menu</span>

						<img src="assets/images/avatars/user.jpg" alt="Jason's Photo" />
					</button>

					<button class="pull-right navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#sidebar">
						<span class="sr-only">Toggle sidebar</span>

						<span class="icon-bar"></span>

						<span class="icon-bar"></span>

						<span class="icon-bar"></span>
					</button>
				</div>

				<div class="navbar-buttons navbar-header pull-right  collapse navbar-collapse" role="navigation">
					
	
					<ul class="nav ace-nav">

						<li class="light-blue dropdown-modal user-min">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="assets/images/avatars/avatar5.png" alt="Jason's Photo" />
								<span class="user-info">
									<small>欢迎</small>
									${username }
								</span>

								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="ace-icon fa fa-cog"></i>
										设置
									</a>
								</li>

								<li>
									<a href="#">
										<i class="ace-icon fa fa-user"></i>
										信息
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="login.jsp">
										<i class="ace-icon fa fa-power-off"></i>
										注销
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>

				<nav role="navigation" class="navbar-menu pull-left collapse navbar-collapse">
					<ul class="nav navbar-nav">
						
						<li>
							<a href="list_sensor?pid=${pid }">
								<i class="ace-icon fa fa-envelope"></i>
								传感器列表
							</a>
						</li>

						<li>
							<a href="monitoring?pid=${pid}">
								<i class="ace-icon fa fa-envelope"></i>
								数据查询
							</a>
						</li>


						<li>
							<a href="warning?pid=${pid }">
								<i class="ace-icon fa fa-envelope"></i>
								预警信息
								
							</a>
						</li>
						
						<li>
							<a href="#">
								<i class="ace-icon fa fa-envelope"></i>
								文件管理
							</a>
						</li>
					</ul>


				</nav>
			</div><!-- /.navbar-container -->
		</div>

		<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>

			<div class="main-content">
				<div class="main-content-inner">
					<div class="page-content">
						<div class="ace-settings-container" id="ace-settings-container">
							<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
								<i class="ace-icon fa fa-cog bigger-130"></i>
							</div>

							<div class="ace-settings-box clearfix" id="ace-settings-box">
								<div class="pull-left width-50">
									<div class="ace-settings-item">
										<div class="pull-left">
											<select id="skin-colorpicker" class="hide">
												<option data-skin="no-skin" value="#438EB9">#438EB9</option>
												<option data-skin="skin-1" value="#222A2D">#222A2D</option>
												<option data-skin="skin-2" value="#C6487E">#C6487E</option>
												<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
											</select>
										</div>
										<span>&nbsp; 选择颜色</span>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-navbar" autocomplete="on" />
										<label class="lbl" for="ace-settings-navbar"> 固定导航栏</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-add-container" autocomplete="off" />
										<label class="lbl" for="ace-settings-add-container">
											Inside
											<b>.container</b>
										</label>
									</div>
								</div><!-- /.pull-left -->

								<div class="pull-left width-50">
								</div><!-- /.pull-left -->
							</div><!-- /.ace-settings-box -->
						</div><!-- /.ace-settings-container -->

						<div class="page-header">
							<h1>
								当前项目：${pname }
								<small>
									<i class="ace-icon fa fa-angle-double-right"></i>
									<a href="list_project">选择其他项目</a>
								</small>
							</h1>

							
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="alert alert-info visible-sm visible-xs">
									<button type="button" class="close" data-dismiss="alert">
										<i class="ace-icon fa fa-times"></i>
									</button>
									Please note that
									<span class="blue bolder">top menu style</span>
									is visible only in devices larger than
									<span class="blue bolder">991px</span>
									which you can change using CSS builder tool.
								</div>

								<div class="well well-sm visible-sm visible-xs">
									Top menu can become any of the 3 mobile view menu styles:
									<em>default</em>
,
									<em>collapsible</em>
									or
									<em>minimized</em>.
								</div>
								
								<!-- 主页面 -->
								<div>
									
									<div class="clearfix">
										<div class="pull-right tableTools-container"></div>
									</div>
										
									<div class="table-header">
										文件列表
									</div>

									<!-- div.table-responsive -->
									
									<!-- div.dataTables_borderWrap -->
									<div>
										<table id="dynamic-table" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th class="center">序号</th>
													<th>名称</th>
													<th>
														<i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
														上传时间
													</th>
													
													<th>下载</th>
													<th></th>
												</tr>
											</thead>

											<tbody>
												<c:forEach items="${files }" var="file" varStatus="st">
													<tr>
														<td class="center">
															${st.count}
														</td>
	
														<td>
															${file.name}
														</td>
														<td>${file.time}</td>
														<td>
															<a href="download_file?fid=${file.id }&pid=${pid }">下载</a>
														</td>
														
														<td>
															<c:if test="${userType == 'administrator'}">
																<div class="hidden-sm hidden-xs action-buttons">
																	
																	<a class="red" href="delete_file?fid=${file.id}&pid=${pid}">
																		<i class="ace-icon fa fa-trash-o bigger-130"></i>
																	</a>
																</div>
		
																<div class="hidden-md hidden-lg">
																	<div class="inline pos-rel">
																		<button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
																			<i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
																		</button>
		
																		<ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
																			<li>
																				<a href="#" class="tooltip-info" data-rel="tooltip" title="View">
																					<span class="blue">
																						<i class="ace-icon fa fa-search-plus bigger-120"></i>
																					</span>
																				</a>
																			</li>
		
																			<li>
																				<a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
																					<span class="green">
																						<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																					</span>
																				</a>
																			</li>
		
																			<li>
																				<a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
																					<span class="red">
																						<i class="ace-icon fa fa-trash-o bigger-120"></i>
																					</span>
																				</a>
																			</li>
																		</ul>
																	</div>
																</div>
															</c:if>
														</td>
													</tr>
												</c:forEach>
												
											</tbody>
										</table>
									</div>
									
									<br />
									
								</div>
								
								<div class="col-sm-3"></div>
								<div class="col-sm-6">
									<div class="widget-box">
										
										<div class="widget-header widget-header-flat">
											<h4 class="widget-title">上传文件</h4>
										</div>
										
										<div class="widget-body" align="center">
											<form action="UploadServlet?pid=${pid }" method="post" enctype="multipart/form-data">
											    <br />
											    
												<div class="col-sm-9">
													<input type="file" name="file" class="col-xs-10 col-sm-9" />
													
												</div>
												
												<div>
													<button type="submit" class="btn btn-primary">上 传</button>
												</div>
												
											    <div>
											    	<h4 class="header blue lighter bigger">
											    		<%
											    			String str = (String)request.getAttribute("message");
											    			if(str == null){
											    				str = "请选择需要上传的文件";
											    			}
											    		%>
											    		
											    		<%=str %>
											    	</h4>
											    </div>
											    <div><br /></div>
											    
		
											</form>
										</div>
										
									</div>
								

								
								</div><!-- PAGE CONTENT ENDS -->  
									
									

								
							</div><!-- /.col -->
						</div><!-- /.row -->
						
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

			<div class="footer">
				<div class="footer-inner">
					<div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">结构健康监测</span>
							信息管理系统 &copy; 2019-2021
						</span>

						&nbsp; &nbsp;
						<span class="action-buttons">
							
						</span>
					</div>
				</div>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script src="assets/js/jquery-2.1.4.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="assets/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->
		<script src="assets/js/dropzone.min.js"></script>
		<script src="assets/js/jquery.dataTables.min.js"></script>
		<script src="assets/js/jquery.dataTables.bootstrap.min.js"></script>
		<script src="assets/js/dataTables.buttons.min.js"></script>
		<script src="assets/js/buttons.flash.min.js"></script>
		<script src="assets/js/buttons.html5.min.js"></script>
		<script src="assets/js/buttons.print.min.js"></script>
		<script src="assets/js/buttons.colVis.min.js"></script>
		<script src="assets/js/dataTables.select.min.js"></script>
		
		<script src="assets/js/jquery-ui.custom.min.js"></script>
		<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
		
		<script src="assets/js/chosen.jquery.min.js"></script>
		
		<script src="assets/js/spinbox.min.js"></script>
		<script src="assets/js/bootstrap-datepicker.min.js"></script>
		<script src="assets/js/bootstrap-timepicker.min.js"></script>
		<script src="assets/js/moment.min.js"></script>
		<script src="assets/js/daterangepicker.min.js"></script>
		<script src="assets/js/bootstrap-datetimepicker.min.js"></script>
		<script src="assets/js/bootstrap-colorpicker.min.js"></script>
		<script src="assets/js/jquery.knob.min.js"></script>
		<script src="assets/js/autosize.min.js"></script>
		<script src="assets/js/jquery.inputlimiter.min.js"></script>
		<script src="assets/js/jquery.maskedinput.min.js"></script>
		<script src="assets/js/bootstrap-tag.min.js"></script>
		
		<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->
		

		<!-- ace scripts -->
		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>
		
		<!-- inline scripts related to this page -->
		<script type="text/javascript">
		
			
		</script>
	</body>
</html>
