<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8"> -->
<title>Insert title here</title>
<script type="text/javascript" src="/laboratory/res/jquery.min.js"></script>
<script type="text/javascript" src="my_scrollbar.js"></script>
<script type="text/javascript" src="zUI.js"></script>
<style>
		.zUIzPanelScrollBox,.zUIzPanelScrollBar{
			width:10px;
			top:4px;
			right:2px;
			border-radius:5px;
			
		}
		.zUIzPanelScrollBox{
			background:black;opacity:0.1;
			filter:alpha(opacity=10);
		}
		.zUIzPanelScrollBar{
			background:#fff;opacity:0.8;
			filter:alpha(opacity=80);
		}
</style>
</head>
<body>
<div id="echartsDiv" style="width:500px;height:300px;border:solid 1px #000;overflow:hidden">
	<div>
	
	<div style="width:500px;height:500px;background-color:red"></div>
	<div style="width:500px;height:500px;background-color:yellow"></div>
	<div style="width:500px;height:500px;background-color:red"></div>
	<div style="width:500px;height:500px;background-color:red"></div>
	</div>
</div> 
<script>
$("#echartsDiv").zPanel({iWheelStep:32});
// var oMyBar3 = new MyScrollBar({
// 	selId: 'echartsDiv',
// 	bgColor: 'rgba(00, 255, 255, 0.1)',
// 	barColor: '#00ffff',
// 	enterColor: '#056FD8',
// 	enterShow: false,
// 	hasX: true,
// 	hasY: true,
// 	width: 5
// })
</script>
  
</body>
</html>