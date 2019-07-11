<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
<body>
<input type="button" id="b1" value="1">
  <input type="button" id="b2" value="2">
  <input type="button" id="b3" value="3">
  <input type="button" id="b4" value="4">
  
  
  <script>

var num=999  
  
function setupSomeGlobals() {
    // Local variable that ends up within closure
     num = 666;
    // Store some references to functions as global variables
    gAlertNumber = function() { console.log(num); }
    gIncreaseNumber = function() { num++; }
    gSetNumber = function(x) { num = x; }
}
console.log(num)
num=123
console.log(num)
setupSomeGlobals(); // 为三个全局变量赋值
gAlertNumber(); //666
gIncreaseNumber();
gAlertNumber(); // 667
gSetNumber(12);//
gAlertNumber();//12
gIncreaseNumber();
gAlertNumber();//12


// var buttons = document.getElementsByTagName("input");

// (function(){
	
// 	for (var i = 0; i < buttons.length; i++)
// 	{
// 	  // 方式1:i的值一直是3
// 	  var a=i;
// 	  buttons[a].onclick = function() {
// 	  console.log(a + " was clicked.");
// 	  }
// 	  // 方式2:从0到3,是我们要的效果
// // 	  (function(i){
// // 	    buttons[i].onclick = function() {
// // 	      console.log(i + " was clicked.");
// // 	    }
// // 	  })(i);
// 	}
// })()

</script>
</body>
</html>