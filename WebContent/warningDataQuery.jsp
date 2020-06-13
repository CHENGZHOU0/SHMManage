<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
							<a href="list_sensor?pid=${pid}">
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
							<a href="#">
								<i class="ace-icon fa fa-envelope"></i>
								预警信息
								
							</a>
						</li>
						
						<li>
							<a href="list_file?pid=${pid}">
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
									<a href="list_project">	选择其他项目</a>
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

								<div class="center">
									
										
										<div class="container">
											<div class="row">
												<form action="warning_data_query?pid=${pid }" method="post">
											
													<div class="col-xs-2">
														<label for="form-field-select-3">选择传感器</label>
														
														 <select class="chosen-select form-control" id="sensor" name="sid" onchange="zoomToSelectedComponents()">
															<c:forEach items="${sensors}" var="sensor" varStatus="st">
																<option value=${sensor.id }>${sensor.name }</option>
															</c:forEach>
														</select>
														
													</div>
													
													<div class="col-xs-3">
														<label for="id-date-range-picker-1">起止日期选择</label>
														
														<div class="input-group">
															<span class="input-group-addon">
																<i class="fa fa-calendar bigger-110"></i>
															</span>
			
															<input class="form-control" type="text" name="date-range-picker" id="id-date-range-picker-1" />
														</div>
													</div>
													
													<div class="col-xs-1"></div>
													<div class="col-xs-1"></div>
													<div class="col-xs-1"></div>
													
													<div class="col-xs-2" style="line-height:60px;">
														<button type="submit" class="btn btn-inverse">查询</button>
													</div>
												</form>
												
												<div class="col-xs-1" style="line-height:60px;">
													<button class="btn btn-inverse" id="btnIsolation" onclick="isolateComponents() ">构件透明化</button>
												</div>
											</div>
										</div>
									
									
									<br />
									
									<div id="domId" style="height:600px; width:80%; margin: 0 auto;">
									
										
										
									</div>
									
									
					
								</div>

								<!-- PAGE CONTENT ENDS -->
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
		
		<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->
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

		<!-- ace scripts -->
		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>
		
		<!-- bimface scripts -->
		<script src="https://static.bimface.com/api/BimfaceSDKLoader/BimfaceSDKLoader@latest-release.js"></script>
    	<script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
    	
    	<!-- echarts scripts -->
    	<script src="js/echarts.js"></script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
	
			//**************************bimface javascript**************************
			
			var viewToken = "${viewToken}";
		  	// 声明Viewer及App
		  	var viewer3D;
		  	var app;
		  	// 配置JSSDK加载项
		  	window.onload = function() {
		    	var loaderConfig = new BimfaceSDKLoaderConfig();
		    	loaderConfig.viewToken = viewToken;
		    	BimfaceSDKLoader.load(loaderConfig, successCallback, failureCallback);
		  		}
		  	// 加载成功回调函数
		  	function successCallback(viewMetaData) {
		    	var dom4Show = document.getElementById('domId');
		    	// 设置WebApplication3D的配置项
		    	var webAppConfig = new Glodon.Bimface.Application.WebApplication3DConfig();
		    	webAppConfig.domElement = dom4Show;
		    	// 创建WebApplication3D，用以显示模型
		    	app = new Glodon.Bimface.Application.WebApplication3D(webAppConfig);  
		    	app.addView(viewToken);
		    	viewer3D = app.getViewer();
		    	
		    	viewer3D.addEventListener(Glodon.Bimface.Viewer.Viewer3DEvent.ViewAdded, function () {
		            // 调用viewer3D对象的Method，可以继续扩展功能
		             //自适应屏幕大小
		   			window.onresize=function(){
		    		viewer3D.resize(document.documentElement.clientWidth,document.documentElement.clientHeight-40)
		  			}
		            // 渲染3D模型
		            viewer3D.render();
		        });  
		           // 监听添加view点击构件的监听事件
		        viewer3D.addEventListener(Glodon.Bimface.Viewer.Viewer3DEvent.MouseClicked, function (objectdata) {
		             //获取点击构件的相关属性
		            //alert(JSON.stringify(objectdata));
		  		  	//alert(JSON.stringify(objectdata.elementId));
		  			//alert(objectdata.elementId);
		  		  	if (objectdata.elementId=="355731")
		  			{
		  		  		document.getElementById("sensor").value = "QJ1"
		  		  		//alert(document.getElementById("sensor").value);
		  				//alert("qj1");
		  			}
		         });   
		       
		  	}
			
		  		
		  	
		  	
		  	// 加载失败回调函数
		  	function failureCallback(error) {
		    	console.log(error);
		  	}
			
		  	
		  	
		  	// ************************** 隔离 **************************
		  	var isIsolationActivated = false;
		  	function isolateComponents() {
		    	if (!isIsolationActivated) {
		      		// 设置隔离选项，指定其他构件为半透明状态
		      		var makeOthersTranslucent = Glodon.Bimface.Viewer.IsolateOption.MakeOthersTranslucent;
		      		// 调用viewer3D.method，隔离楼层为"F2"的构件
		      		var arrElementId = 
			  		[<c:forEach items="${sensors}" var="sensor" varStatus="st">
			  		<c:if test="${st.count > 1}">, </c:if>'${sensor.elementId}'
			  		</c:forEach> ];
		      		
		      		viewer3D.isolateComponentsById(arrElementId, makeOthersTranslucent);
			  
		  
		      		// 渲染三维模型
		      		viewer3D.render(); 
		      		// 修改按钮的文字内容
		      		setButtonText("btnIsolation", "取消透明化");
		    	} else {
		      		// 清除隔离
		      		viewer3D.clearIsolation();
		      		// 渲染三维模型
		      		viewer3D.render();
		      		// 修改按钮的文字内容
		      		setButtonText("btnIsolation", "构件透明化");
		    	}
		    	isIsolationActivated = !isIsolationActivated;
		  	}
		
		  	// ************************** 定位 **************************
		  	function zoomToSelectedComponents(){
			  	var myselect = document.getElementById("sensor");
			  	var id = myselect.value;
			  	var num = parseInt('${fn:length(sensors)}');
			  	//alert(myselect.value);
			  	
			  	var arrId = 
			  		[<c:forEach items="${sensors}" var="sensor" varStatus="st">
			  		<c:if test="${st.count > 1}">, </c:if>'${sensor.id}'
			  		</c:forEach>];
			  	//alert(arrId[0]);
			  	
			  	var arrElementId = 
			  		[<c:forEach items="${sensors}" var="sensor" varStatus="st">
			  		<c:if test="${st.count > 1}">, </c:if>'${sensor.elementId}'
			  		</c:forEach> ];
			  	
			  	//var test = '${sensors[0].id}';
			  	//alert(test);
			  	
			  	//'${fn:length(sensors)}'为列表的大小
			  	//alert('${fn:length(sensors)}');
			  	//alert("变量a的类型是:"+(typeof '${fn:length(sensors)}'));
			  	
			  	for(var i=0;i<num;i++){
			  		//alert(i)
			  		//alert(id)
			  		//alert(test('${sensors[i].id}'))
			  		if (id == arrId[i]) {
			  			//alert(arrElementId[i]);
			      		// 选中id为"355731"的构件
			      		viewer3D.addSelectedComponentsById([arrElementId[i]]);
			      		// 定位到选中的构件
			      		viewer3D.zoomToSelectedComponents();
			      		// 清除构件选中状态
			      		viewer3D.clearSelectedComponents();
			      		
			   		 } 
			  		
			  	}
		    	
		  	}
		
		
		  	// ************************** 着色 **************************
		  	var isOverrideActivated = false;
		  	function overrideComponents(){
		    	if (!isOverrideActivated) {
		      		// 新建color对象，指定关注构件被染色的数值
		      		var color = new Glodon.Web.Graphics.Color("#000000", 1);
		      		// 对关注构件进行着色
		      		viewer3D.overrideComponentsColorById(["355731","355526","355800","355946","355884","356011","355426","355248"], color);
		      		viewer3D.render();
		      		setButtonText("btnOverrideColor", "清除着色");
		    	} else {
		      		// 清除构件着色
		      		viewer3D.clearOverrideColorComponents();
		      		viewer3D.render();
		      		setButtonText("btnOverrideColor", "构件着色");
		    	}
		    	isOverrideActivated = !isOverrideActivated;
		  	}
		
		
		  	// ************************** 构件闪烁 **************************
		  	var isBlinkActivated = false;
		  	function blinkComponents() {
		    	if (!isBlinkActivated) {
			  		var blinkColor = new Glodon.Web.Graphics.Color("#FF0000", 1);
			  		// 打开构件强调开关
			  		viewer3D.enableBlinkComponents(true);
			  		// 给需要报警的构件添加强调状态
			  		viewer3D.addBlinkComponentsById(["355731"]);
			  		// 设置强调状态下的颜色
			  		viewer3D.setBlinkColor(blinkColor);
			  		// 设置强调状态下的频率
			  		viewer3D.setBlinkIntervalTime(500);
			  		viewer3D.render();
			  		setButtonText("btnBlinkComponent", "清除强调");
		    	} else {
			  		// 清除构件强调
			  		viewer3D.clearAllBlinkComponents();
			  		viewer3D.render();
			  		setButtonText("btnBlinkComponent", "构件强调");
		    	}
		    	isBlinkActivated = !isBlinkActivated;
		  	}
		
		  	// ************************** 构件信息 **************************
		  	function getComponentProperty(){
		    	viewer3D.getComponentProperty("307240",function(objectdata){alert(JSON.stringify(objectdata))});
		  	}
		
		  	// ************************** 按钮文字 **************************
		  	function setButtonText(btnId, text) {
		    	var dom = document.getElementById(btnId);
		    	if (dom != null && dom.nodeName == "BUTTON") {
		      		dom.innerText = text;
		    	}
		  	}
		
			// ************************** echarts javascript **************************
			
			
		  	
		  	
		  	
		  	
		  	
		
			//**************************blankpage javascript**************************
			jQuery(function($) {
			 var $sidebar = $('.sidebar').eq(0);
			 if( !$sidebar.hasClass('h-sidebar') ) return;
			
			 $(document).on('settings.ace.top_menu' , function(ev, event_name, fixed) {
				if( event_name !== 'sidebar_fixed' ) return;
			
				var sidebar = $sidebar.get(0);
				var $window = $(window);
			
				//return if sidebar is not fixed or in mobile view mode
				var sidebar_vars = $sidebar.ace_sidebar('vars');
				if( !fixed || ( sidebar_vars['mobile_view'] || sidebar_vars['collapsible'] ) ) {
					$sidebar.removeClass('lower-highlight');
					//restore original, default marginTop
					sidebar.style.marginTop = '';
			
					$window.off('scroll.ace.top_menu')
					return;
				}
			
			
				 var done = false;
				 $window.on('scroll.ace.top_menu', function(e) {
			
					var scroll = $window.scrollTop();
					scroll = parseInt(scroll / 4);
					//move the menu up 1px for every 4px of document scrolling
					if (scroll > 17) scroll = 17;
			
			
					if (scroll > 16) {			
						if(!done) {
							$sidebar.addClass('lower-highlight');
							done = true;
						}
					}
					else {
						if(done) {
							$sidebar.removeClass('lower-highlight');
							done = false;
						}
					}
			
					sidebar.style['marginTop'] = (17-scroll)+'px';
				 }).triggerHandler('scroll.ace.top_menu');
			
			 }).triggerHandler('settings.ace.top_menu', ['sidebar_fixed' , $sidebar.hasClass('sidebar-fixed')]);
			
			 $(window).on('resize.ace.top_menu', function() {
				$(document).triggerHandler('settings.ace.top_menu', ['sidebar_fixed' , $sidebar.hasClass('sidebar-fixed')]);
			 });
			
			
			});
			
			//**************************form-elements javascript**************************
			jQuery(function($) {
				$('#id-disable-check').on('click', function() {
					var inp = $('#form-input-readonly').get(0);
					if(inp.hasAttribute('disabled')) {
						inp.setAttribute('readonly' , 'true');
						inp.removeAttribute('disabled');
						inp.value="This text field is readonly!";
					}
					else {
						inp.setAttribute('disabled' , 'disabled');
						inp.removeAttribute('readonly');
						inp.value="This text field is disabled!";
					}
				});
			
			
				if(!ace.vars['touch']) {
					$('.chosen-select').chosen({allow_single_deselect:true}); 
					//resize the chosen on window resize
			
					$(window)
					.off('resize.chosen')
					.on('resize.chosen', function() {
						$('.chosen-select').each(function() {
							 var $this = $(this);
							 $this.next().css({'width': $this.parent().width()});
						})
					}).trigger('resize.chosen');
					//resize chosen on sidebar collapse/expand
					$(document).on('settings.ace.chosen', function(e, event_name, event_val) {
						if(event_name != 'sidebar_collapsed') return;
						$('.chosen-select').each(function() {
							 var $this = $(this);
							 $this.next().css({'width': $this.parent().width()});
						})
					});
			
			
					$('#chosen-multiple-style .btn').on('click', function(e){
						var target = $(this).find('input[type=radio]');
						var which = parseInt(target.val());
						if(which == 2) $('#form-field-select-4').addClass('tag-input-style');
						 else $('#form-field-select-4').removeClass('tag-input-style');
					});
				}
			
			
				$('[data-rel=tooltip]').tooltip({container:'body'});
				$('[data-rel=popover]').popover({container:'body'});
			
				autosize($('textarea[class*=autosize]'));
				
				$('textarea.limited').inputlimiter({
					remText: '%n character%s remaining...',
					limitText: 'max allowed : %n.'
				});
			
				$.mask.definitions['~']='[+-]';
				$('.input-mask-date').mask('99/99/9999');
				$('.input-mask-phone').mask('(999) 999-9999');
				$('.input-mask-eyescript').mask('~9.99 ~9.99 999');
				$(".input-mask-product").mask("a*-999-a999",{placeholder:" ",completed:function(){alert("You typed the following: "+this.val());}});
			
			
			
				$( "#input-size-slider" ).css('width','200px').slider({
					value:1,
					range: "min",
					min: 1,
					max: 8,
					step: 1,
					slide: function( event, ui ) {
						var sizing = ['', 'input-sm', 'input-lg', 'input-mini', 'input-small', 'input-medium', 'input-large', 'input-xlarge', 'input-xxlarge'];
						var val = parseInt(ui.value);
						$('#form-field-4').attr('class', sizing[val]).attr('placeholder', '.'+sizing[val]);
					}
				});
			
				$( "#input-span-slider" ).slider({
					value:1,
					range: "min",
					min: 1,
					max: 12,
					step: 1,
					slide: function( event, ui ) {
						var val = parseInt(ui.value);
						$('#form-field-5').attr('class', 'col-xs-'+val).val('.col-xs-'+val);
					}
				});
			
			
				
				//"jQuery UI Slider"
				//range slider tooltip example
				$( "#slider-range" ).css('height','200px').slider({
					orientation: "vertical",
					range: true,
					min: 0,
					max: 100,
					values: [ 17, 67 ],
					slide: function( event, ui ) {
						var val = ui.values[$(ui.handle).index()-1] + "";
			
						if( !ui.handle.firstChild ) {
							$("<div class='tooltip right in' style='display:none;left:16px;top:-6px;'><div class='tooltip-arrow'></div><div class='tooltip-inner'></div></div>")
							.prependTo(ui.handle);
						}
						$(ui.handle.firstChild).show().children().eq(1).text(val);
					}
				}).find('span.ui-slider-handle').on('blur', function(){
					$(this.firstChild).hide();
				});
				
				
				$( "#slider-range-max" ).slider({
					range: "max",
					min: 1,
					max: 10,
					value: 2
				});
				
				$( "#slider-eq > span" ).css({width:'90%', 'float':'left', margin:'15px'}).each(function() {
					// read initial values from markup and remove that
					var value = parseInt( $( this ).text(), 10 );
					$( this ).empty().slider({
						value: value,
						range: "min",
						animate: true
						
					});
				});
				
				$("#slider-eq > span.ui-slider-purple").slider('disable');//disable third item
			
				
				$('#id-input-file-1 , #id-input-file-2').ace_file_input({
					no_file:'No File ...',
					btn_choose:'Choose',
					btn_change:'Change',
					droppable:false,
					onchange:null,
					thumbnail:false //| true | large
					//whitelist:'gif|png|jpg|jpeg'
					//blacklist:'exe|php'
					//onchange:''
					//
				});
				//pre-show a file name, for example a previously selected file
				//$('#id-input-file-1').ace_file_input('show_file_list', ['myfile.txt'])
			
			
				$('#id-input-file-3').ace_file_input({
					style: 'well',
					btn_choose: 'Drop files here or click to choose',
					btn_change: null,
					no_icon: 'ace-icon fa fa-cloud-upload',
					droppable: true,
					thumbnail: 'small'//large | fit
					//,icon_remove:null//set null, to hide remove/reset button
					/**,before_change:function(files, dropped) {
						//Check an example below
						//or examples/file-upload.html
						return true;
					}*/
					/**,before_remove : function() {
						return true;
					}*/
					,
					preview_error : function(filename, error_code) {
						//name of the file that failed
						//error_code values
						//1 = 'FILE_LOAD_FAILED',
						//2 = 'IMAGE_LOAD_FAILED',
						//3 = 'THUMBNAIL_FAILED'
						//alert(error_code);
					}
			
				}).on('change', function(){
					//console.log($(this).data('ace_input_files'));
					//console.log($(this).data('ace_input_method'));
				});
				
				
				//$('#id-input-file-3')
				//.ace_file_input('show_file_list', [
					//{type: 'image', name: 'name of image', path: 'http://path/to/image/for/preview'},
					//{type: 'file', name: 'hello.txt'}
				//]);
			
				
				
			
				//dynamically change allowed formats by changing allowExt && allowMime function
				$('#id-file-format').removeAttr('checked').on('change', function() {
					var whitelist_ext, whitelist_mime;
					var btn_choose
					var no_icon
					if(this.checked) {
						btn_choose = "Drop images here or click to choose";
						no_icon = "ace-icon fa fa-picture-o";
			
						whitelist_ext = ["jpeg", "jpg", "png", "gif" , "bmp"];
						whitelist_mime = ["image/jpg", "image/jpeg", "image/png", "image/gif", "image/bmp"];
					}
					else {
						btn_choose = "Drop files here or click to choose";
						no_icon = "ace-icon fa fa-cloud-upload";
						
						whitelist_ext = null;//all extensions are acceptable
						whitelist_mime = null;//all mimes are acceptable
					}
					var file_input = $('#id-input-file-3');
					file_input
					.ace_file_input('update_settings',
					{
						'btn_choose': btn_choose,
						'no_icon': no_icon,
						'allowExt': whitelist_ext,
						'allowMime': whitelist_mime
					})
					file_input.ace_file_input('reset_input');
					
					file_input
					.off('file.error.ace')
					.on('file.error.ace', function(e, info) {
						//console.log(info.file_count);//number of selected files
						//console.log(info.invalid_count);//number of invalid files
						//console.log(info.error_list);//a list of errors in the following format
						
						//info.error_count['ext']
						//info.error_count['mime']
						//info.error_count['size']
						
						//info.error_list['ext']  = [list of file names with invalid extension]
						//info.error_list['mime'] = [list of file names with invalid mimetype]
						//info.error_list['size'] = [list of file names with invalid size]
						
						
						/**
						if( !info.dropped ) {
							//perhapse reset file field if files have been selected, and there are invalid files among them
							//when files are dropped, only valid files will be added to our file array
							e.preventDefault();//it will rest input
						}
						*/
						
						
						//if files have been selected (not dropped), you can choose to reset input
						//because browser keeps all selected files anyway and this cannot be changed
						//we can only reset file field to become empty again
						//on any case you still should check files with your server side script
						//because any arbitrary file can be uploaded by user and it's not safe to rely on browser-side measures
					});
					
					
					/**
					file_input
					.off('file.preview.ace')
					.on('file.preview.ace', function(e, info) {
						console.log(info.file.width);
						console.log(info.file.height);
						e.preventDefault();//to prevent preview
					});
					*/
				
				});
			
				$('#spinner1').ace_spinner({value:0,min:0,max:200,step:10, btn_up_class:'btn-info' , btn_down_class:'btn-info'})
				.closest('.ace-spinner')
				.on('changed.fu.spinbox', function(){
					//console.log($('#spinner1').val())
				}); 
				$('#spinner2').ace_spinner({value:0,min:0,max:10000,step:100, touch_spinner: true, icon_up:'ace-icon fa fa-caret-up bigger-110', icon_down:'ace-icon fa fa-caret-down bigger-110'});
				$('#spinner3').ace_spinner({value:0,min:-100,max:100,step:10, on_sides: true, icon_up:'ace-icon fa fa-plus bigger-110', icon_down:'ace-icon fa fa-minus bigger-110', btn_up_class:'btn-success' , btn_down_class:'btn-danger'});
				$('#spinner4').ace_spinner({value:0,min:-100,max:100,step:10, on_sides: true, icon_up:'ace-icon fa fa-plus', icon_down:'ace-icon fa fa-minus', btn_up_class:'btn-purple' , btn_down_class:'btn-purple'});
			
				//$('#spinner1').ace_spinner('disable').ace_spinner('value', 11);
				//or
				//$('#spinner1').closest('.ace-spinner').spinner('disable').spinner('enable').spinner('value', 11);//disable, enable or change value
				//$('#spinner1').closest('.ace-spinner').spinner('value', 0);//reset to 0
			
			
				//datepicker plugin
				//link
				$('.date-picker').datepicker({
					autoclose: true,
					todayHighlight: true
				})
				//show datepicker when clicking on the icon
				.next().on(ace.click_event, function(){
					$(this).prev().focus();
				});
			
				//or change it into a date range picker
				$('.input-daterange').datepicker({autoclose:true});
			
			
				//to translate the daterange picker, please copy the "examples/daterange-fr.js" contents here before initialization
				$('input[name=date-range-picker]').daterangepicker({
					'applyClass' : 'btn-sm btn-success',
					'cancelClass' : 'btn-sm btn-default',
					locale: {
						applyLabel: 'Apply',
						cancelLabel: 'Cancel',
					}
				})
				.prev().on(ace.click_event, function(){
					$(this).next().focus();
				});
			
			
				$('#timepicker1').timepicker({
					minuteStep: 1,
					showSeconds: true,
					showMeridian: false,
					disableFocus: true,
					icons: {
						up: 'fa fa-chevron-up',
						down: 'fa fa-chevron-down'
					}
				}).on('focus', function() {
					$('#timepicker1').timepicker('showWidget');
				}).next().on(ace.click_event, function(){
					$(this).prev().focus();
				});
				
				
			
				
				if(!ace.vars['old_ie']) $('#date-timepicker1').datetimepicker({
				 //format: 'MM/DD/YYYY h:mm:ss A',//use this option to display seconds
				 icons: {
					time: 'fa fa-clock-o',
					date: 'fa fa-calendar',
					up: 'fa fa-chevron-up',
					down: 'fa fa-chevron-down',
					previous: 'fa fa-chevron-left',
					next: 'fa fa-chevron-right',
					today: 'fa fa-arrows ',
					clear: 'fa fa-trash',
					close: 'fa fa-times'
				 }
				}).next().on(ace.click_event, function(){
					$(this).prev().focus();
				});
				
			
				$('#colorpicker1').colorpicker();
				//$('.colorpicker').last().css('z-index', 2000);//if colorpicker is inside a modal, its z-index should be higher than modal'safe
			
				$('#simple-colorpicker-1').ace_colorpicker();
				//$('#simple-colorpicker-1').ace_colorpicker('pick', 2);//select 2nd color
				//$('#simple-colorpicker-1').ace_colorpicker('pick', '#fbe983');//select #fbe983 color
				//var picker = $('#simple-colorpicker-1').data('ace_colorpicker')
				//picker.pick('red', true);//insert the color if it doesn't exist
			
			
				$(".knob").knob();
				
				
				var tag_input = $('#form-field-tags');
				try{
					tag_input.tag(
					  {
						placeholder:tag_input.attr('placeholder'),
						//enable typeahead by specifying the source array
						source: ace.vars['US_STATES'],//defined in ace.js >> ace.enable_search_ahead
						/**
						//or fetch data from database, fetch those that match "query"
						source: function(query, process) {
						  $.ajax({url: 'remote_source.php?q='+encodeURIComponent(query)})
						  .done(function(result_items){
							process(result_items);
						  });
						}
						*/
					  }
					)
			
					//programmatically add/remove a tag
					var $tag_obj = $('#form-field-tags').data('tag');
					$tag_obj.add('Programmatically Added');
					
					var index = $tag_obj.inValues('some tag');
					$tag_obj.remove(index);
				}
				catch(e) {
					//display a textarea for old IE, because it doesn't support this plugin or another one I tried!
					tag_input.after('<textarea id="'+tag_input.attr('id')+'" name="'+tag_input.attr('name')+'" rows="3">'+tag_input.val()+'</textarea>').remove();
					//autosize($('#form-field-tags'));
				}
				
				
				/////////
				$('#modal-form input[type=file]').ace_file_input({
					style:'well',
					btn_choose:'Drop files here or click to choose',
					btn_change:null,
					no_icon:'ace-icon fa fa-cloud-upload',
					droppable:true,
					thumbnail:'large'
				})
				
				//chosen plugin inside a modal will have a zero width because the select element is originally hidden
				//and its width cannot be determined.
				//so we set the width after modal is show
				$('#modal-form').on('shown.bs.modal', function () {
					if(!ace.vars['touch']) {
						$(this).find('.chosen-container').each(function(){
							$(this).find('a:first-child').css('width' , '210px');
							$(this).find('.chosen-drop').css('width' , '210px');
							$(this).find('.chosen-search input').css('width' , '200px');
						});
					}
				})
				/**
				//or you can activate the chosen plugin after modal is shown
				//this way select element becomes visible with dimensions and chosen works as expected
				$('#modal-form').on('shown', function () {
					$(this).find('.modal-chosen').chosen();
				})
				*/
			
				
				
				$(document).one('ajaxloadstart.page', function(e) {
					autosize.destroy('textarea[class*=autosize]')
					
					$('.limiterBox,.autosizejs').remove();
					$('.daterangepicker.dropdown-menu,.colorpicker.dropdown-menu,.bootstrap-datetimepicker-widget.dropdown-menu').remove();
				});
			
			});
		</script>
	</body>
</html>
