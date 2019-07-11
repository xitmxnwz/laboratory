<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8"> -->
<title>Insert title here</title>
<script type="text/javascript" src="/laboratory/res/jquery.min.js"></script>
<script type="text/javascript" src="/laboratory/res/echarts/echarts_4.1.0.min.js"></script>

</head>
<body>
<div id="echartsDiv" style="width:500px;height:500px">
</div> 
我们说好
<script>
var eOption = {
		 title : {
		     text: 'test',
		     x:'center'
		 },
		 calculable:false,
		 tooltip : {
		     show : true,
		           axisPointer : {
		               type : 'shadow'
		           },
		           feature : {
		               mark : {show: true},
		               dataView : {show: true, readOnly: false},
		               magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
		               restore : {show: true},
		               saveAsImage : {show: true}
		           },
		           formatter: function (params) {
		               return params[1] + '<br/>耗时 : ' + params[2] + '天';
		           }
		       },
		    axis:{
		     splitLine:{
		      show:false
		     },
		     splitArea:{
		      show:false
		     } 
		    },
		 calculable : true,
		 yAxis : [{
		  type:"category",
		  splitLine:{show:true},
		  data:["项目确定", "问卷设计", "试访", "问卷确定","实地执行","数据录入","数据分析"]
		 }],
		 xAxis : [{
		  type : 'value',
		  axisLabel : {
		   formatter: function (value){
		         var end_time = 1418428800000;
		         var start_time = 1417392000000;
		         var date = new Array();
		         var i = 1;
		         while(end_time > start_time){
		    var date_formatter = new Date(start_time);
		    var date_time = (date_formatter.getFullYear()+"-"+(date_formatter.getMonth()+1)+"-"+date_formatter.getDate());
		    date.push(date_time);
		    start_time = start_time + i*24*60*60*1000;
		         }
		         console.log(date);
		         return date[value*1];
		       }
		  },
		 }],
		 series : [
		  {
		   name:"辅助",
		   type:"bar",
		   stack:"总",
		   itemStyle:{
		    normal:{
		     barBorderColor:'rgba(0,0,0,0)',
		     color:'rgba(0,0,0,0)'
		    },
		    emphasis:{
		     barBorderColor:'rgba(0,0,0,0)',
		     color:'rgba(0,0,0,0)'
		    }
		   },
		   data:[0,1,2,3,4,5,6]
		  },
		  {
		   name:"项目确定",
		   type:"bar",
		   stack:"总",
		   data:[8,0,0,0,0,0,0]
		  },
		  {
		   name:"问卷设计",
		   type:"bar",
		   stack:"总",
		   data:[0,1,0,0,0,0,0]
		  },
		  {
		   name:"试访",
		   type:"bar",
		   stack:"总",
		   data:[0,0,2,0,0,0,0]
		  },
		  {
		   name:"问卷确定",
		   type:"bar",
		   stack:"总",
		   data:[0,0,0,1,0,0,0]
		  },
		  {
		   name:"实地执行",
		   type:"bar",
		   stack:"总",
		   data:[0,0,0,0,4,0,0]
		  },
		  {
		   name:"数据录入",
		   type:"bar",
		   stack:"总",
		   data:[0,0,0,0,0,1,0]
		  },
		  {
		   name:"数据分析",
		   type:"bar",
		   stack:"总",
		   data:[0,0,0,0,0,0,3]
		  }
		 ]
		}; 
		
var myChart = echarts.init(document.getElementById('echartsDiv'));
myChart.setOption(eOption);
</script>
  
</body>
</html>