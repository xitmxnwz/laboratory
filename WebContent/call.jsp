<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
<body>
  
  
  <script>
  
  
var opt={
		aa:function(){
			alert(456)
		}
}

function test(){
	this.aa()
}
test.call(opt)

// function test2(param){
// 	param.aa()
// }

// test2(opt)

  
  
</script>

</body>

</html>