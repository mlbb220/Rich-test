<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
System.out.println("i's in index.jsp");
String key = "key";
String contextvalue = request.getParameter("contextvalue");
if(contextvalue ==null||contextvalue==""){
	
}else{
	this.getServletContext().setAttribute(key, contextvalue);
}
String value = "";
value = (String)this.getServletContext().getAttribute(key);
%>
<script type="text/javascript">
function getvalue(){
	document.getElementById("keyvalue").Value=<%=value%>;
}
function setvalue(){
	value = document.getElementById("contextvalue").Value;
	if(value==null||value==""){
		return false;
	}
	return true;
}
</script>
<title>Insert title here</title>
</head>
<body>
Context Value is :<input type="text" id="keyvalue" disabled="disabled"/>
<br>

<form name="selectservice"  action="index.jsp" method="post">
	Set to:<input type="text" id="contextvalue" name="contextvalue"/>
	<br>
	<input type="submit" value="setvalue"/>
</form>
<br>

Value is :<input type="text" id="test" disabled="disabled" value="<%=value %>"/>
<br>

<input type="button" value="getvalue" onclick="getvalue();"/>
</body>
</html>