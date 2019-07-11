<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/laboratory/res/jquery.min.js"></script>
<title>Insert title here</title>


</head>
<body>
  
  <script>
//   var abc = [1,2,3,4,5,6,7]
//   var newAbc = abc.filter(function(index){
// 	  return index
//   })
//   function a(){
// 	  alert(b)
//   }
//   var b=0;
//   a();
var a=1; //声明了一个全局变量
function func(){
  console.log(a); //输出：undefined。打印a，而在func这个作用域中已经声明了a变量，按照js的执行顺序，此时的a并未被赋值。
  console.log(a); //输出：1。
}
func();  
//   abc.forEach(function(curValue,index){
// 	  alert(index)
//   })
  
  
</script>
</body>
</html>