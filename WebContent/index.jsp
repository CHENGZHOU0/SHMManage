<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="http://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.0/normalize.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/datepicker.css">
    <title>各种时间和日期选择器 可以指定具体月份或者某天等</title>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed' rel='stylesheet' type='text/css'>
    <style type="text/css">
    	  * {
	        margin: 0;
	        padding: 0;
	      }
	      html, body {
	        height: 100%;
	      }
	      .buttons {
	        font-size: 0;
	      }
	      .button {
	        margin: 5px 0 5px 5px;
	        width: 90px;
	        height: 30px;
	        border-radius: 3px;
	        border: none;
	        background: #11DAB7;
	        color: #FFFFFF;
	      }
	      .main {
	        display: flex;
	        flex-direction: column;
	        overflow: hidden;
	        height: 100%;
	      }
	      #domId {
	        flex: 1;
	      }
        body {
            font-family: 'Roboto Condensed';
            background: #fafafa;
        }

        .p20 {
            padding: 20px;
        }

        .mt20 {
            margin-top: 20px;
        }

        .mt40 {
            margin-top: 40px;
        }

        .mt10 {
            margin-top: 10px;
        }

        .hide {
            display: none;
        }

        body {
            height: 1000px;
        }

        .c999 {
            color: #999;
            font-size: 12px;
        }
    </style>

</head>
<body>
    <div id="main_demo">
        <div class="p20 container">
            <div class="mt40">
            	<!-- form表单提交请求 -->
            	<form action="monitoring_data_query" method="post">
                <div>Date Range Picker</div>
                <div class="c-datepicker-date-editor  J-datepicker-range-day mt10">
                    <i class="c-datepicker-range__icon kxiconfont icon-clock"></i>
                    <input placeholder="Start" name="startTime" class="c-datepicker-data-input only-date" value="">
                    <span class="c-datepicker-range-separator">-</span>
                    <input placeholder="End" name="endTime" class="c-datepicker-data-input only-date" value="">
                    <button type="submit">检索</button>
                </div>
                </form>
            </div>
        </div>
    </div>
    
    <div >
	    <select class="combobox" id="po" onchange="zoomToSelectedComponents()">
			<option value="QJ1">1号倾角传感器</option>
			<option value="QJ2">2号倾角传感器</option>
		</select>
	</div>
	    
    <div id="domId" class='main'></div>
	
	
	<script src="https://static.bimface.com/api/BimfaceSDKLoader/BimfaceSDKLoader@latest-release.js"></script>
	
    <script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
    <script src="js/datepicker.all.js"></script>
    <script src="js/datepicker.en.js"></script>
    
    <script type="text/javascript">
    	
	    var viewToken = '17b562e160a4477792aa1f48283da1ac';
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
	  			alert(objectdata.elementId);
	  		  	if (objectdata.elementId=="355731")
	  			{
	  		  		document.getElementById("po").value = "QJ1"
	  				alert("qj1");
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
	      		viewer3D.isolateComponentsById(["355731","355526","355800","355946","355884","356011","355426","355248"], makeOthersTranslucent);
		  
	  
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
		  	var myselect = document.getElementById("po");
		  	var id = myselect.value;
		  	//alert(myselect.value);
		  	
	  		if (id == "QJ1") {
	      		// 选中id为"355731"的构件
	      		viewer3D.addSelectedComponentsById(["355731"]);
	      		// 定位到选中的构件
	      		viewer3D.zoomToSelectedComponents();
	      		// 清除构件选中状态
	      		viewer3D.clearSelectedComponents();
	      		
	   		 } 
	  		else if (id == "QJ2"){
	      		// 切换至主视角
	      		viewer3D.addSelectedComponentsById(["355946"]);
	      		viewer3D.zoomToSelectedComponents();
	      		viewer3D.clearSelectedComponents();
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
    
    
 
		//***************日期选择部分*****************
        $(function () {
            $('.J-datepicker-time').datePicker({
                format: 'HH:mm:ss',
                min: '04:23:11'
            });
            $('.J-datepicker-time-range').datePicker({
                format: 'HH:mm:ss',
                isRange: true,
                min: '04:23:11',
                max: '20:59:59'
            });

            var DATAPICKERAPI = {
                activeMonthRange: function () {
                    return {
                        begin: moment().set({ 'date': 1, 'hour': 0, 'minute': 0, 'second': 0 }).format('YYYY-MM-DD HH:mm:ss'),
                        end: moment().set({ 'hour': 23, 'minute': 59, 'second': 59 }).format('YYYY-MM-DD HH:mm:ss')
                    }
                },
                shortcutMonth: function () {
                    var nowDay = moment().get('date');
                    var prevMonthFirstDay = moment().subtract(1, 'months').set({ 'date': 1 });
                    var prevMonthDay = moment().diff(prevMonthFirstDay, 'days');
                    return {
                        now: '-' + nowDay + ',0',
                        prev: '-' + prevMonthDay + ',-' + nowDay
                    }
                },
                shortcutPrevHours: function (hour) {
                    var nowDay = moment().get('date');
                    var prevHours = moment().subtract(hour, 'hours');
                    var prevDate = prevHours.get('date') - nowDay;
                    var nowTime = moment().format('HH:mm:ss');
                    var prevTime = prevHours.format('HH:mm:ss');
                    return {
                        day: prevDate + ',0',
                        time: prevTime + ',' + nowTime,
                        name: 'Nearly ' + hour + ' Hours'
                    }
                },
                rangeMonthShortcutOption1: function () {
                    var result = DATAPICKERAPI.shortcutMonth();
                    var resultTime = DATAPICKERAPI.shortcutPrevHours(18);
                    return [{
                        name: 'Yesterday',
                        day: '-1,-1',
                        time: '00:00:00,23:59:59'
                    }, {
                        name: 'This Month',
                        day: result.now,
                        time: '00:00:00,'
                    }, {
                        name: 'Lasy Month',
                        day: result.prev,
                        time: '00:00:00,23:59:59'
                    }, {
                        name: resultTime.name,
                        day: resultTime.day,
                        time: resultTime.time
                    }];
                },
                rangeShortcutOption1: [{
                    name: 'Last week',
                    day: '-7,0'
                }, {
                    name: 'Last Month',
                    day: '-30,0'
                }, {
                    name: 'Last Three Months',
                    day: '-90, 0'
                }],
                singleShortcutOptions1: [{
                    name: 'Today',
                    day: '0',
                    time: '00:00:00'
                }, {
                    name: 'Yesterday',
                    day: '-1',
                    time: '00:00:00'
                }, {
                    name: 'One Week Ago',
                    day: '-7'
                }]
            };
            $('.J-datepicker').datePicker({
                hasShortcut: true,
                min: '2018-01-01 04:00:00',
                max: '2029-10-29 20:59:59',
                shortcutOptions: [{
                    name: 'Today',
                    day: '0'
                }, {
                    name: 'Yesterday',
                    day: '-1',
                    time: '00:00:00'
                }, {
                    name: 'One Week Ago',
                    day: '-7'
                }],
                hide: function () {
                    console.info(this)
                }
            });


            $('.J-datepicker-day').datePicker({
                hasShortcut: true,
                shortcutOptions: [{
                    name: 'Today',
                    day: '0'
                }, {
                    name: 'Yesterday',
                    day: '-1'
                }, {
                    name: 'One week ago',
                    day: '-7'
                }]
            });


            $('.J-datepicker-range-day').datePicker({
                hasShortcut: true,
                format: 'YYYY-MM-DD',
                isRange: true,
                shortcutOptions: DATAPICKERAPI.rangeShortcutOption1
            });


            $('.J-datepickerTime-single').datePicker({
                format: 'YYYY-MM-DD HH:mm'
            });


            $('.J-datepickerTime-range').datePicker({
                format: 'YYYY-MM-DD HH:mm',
                isRange: true
            });


            $('.J-datepicker-range').datePicker({
                hasShortcut: true,
                min: '2018-01-01 06:00:00',
                max: '2029-04-29 20:59:59',
                isRange: true,
                shortcutOptions: [{
                    name: 'Yesterday',
                    day: '-1,-1',
                    time: '00:00:00,23:59:59'
                }, {
                    name: 'Last Week',
                    day: '-7,0',
                    time: '00:00:00,'
                }, {
                    name: 'Last Month',
                    day: '-30,0',
                    time: '00:00:00,'
                }, {
                    name: 'Last Three Months',
                    day: '-90, 0',
                    time: '00:00:00,'
                }],
                hide: function (type) {
                    console.info(this.$input.eq(0).val(), this.$input.eq(1).val());
                    console.info('Type:', type)
                }
            });
            $('.J-datepicker-range-betweenMonth').datePicker({
                isRange: true,
                between: 'month',
                hasShortcut: true,
                shortcutOptions: DATAPICKERAPI.rangeMonthShortcutOption1()
            });


            $('.J-datepicker-range-between30').datePicker({
                isRange: true,
                between: 30
            });

            $('.J-yearMonthPicker-single').datePicker({
                format: 'YYYY-MM',
                min: '2018-01',
                max: '2029-04',
                hide: function (type) {
                    console.info(this.$input.eq(0).val());
                }
            });

            $('.J-yearPicker-single').datePicker({
                format: 'YYYY',
                min: '2018',
                max: '2029'
            });


        });
    </script>
</body>

</html>

