<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function saveDBDetail(){
	document.saveform.stateid.value=document.getElementById("stateid").options[document.getElementById("stateid").selectedIndex].value;
	document.saveform.dbdetailname.value=document.getElementById('name').value;
	document.saveform.dbdetailpassword.value=document.getElementById('password').value;
	document.saveform.dbdetailip.value=document.getElementById('ip').value;
	document.saveform.dbdetailport.value=document.getElementById('port').value;
	document.saveform.dbdetailsid.value=document.getElementById('sid').value;
	document.saveform.dbdetaildescr.value=document.getElementById('descr').value;
	document.saveform.submit();
}
</script>
<body>

<table border="1">
	<tr>
		<td>StateName</td>
		<td>
		<select id="stateid" name="stateid">
		<c:forEach var="state" items="${states}">
			<option value="${state.id }">${state.name }</option>
		</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<td>Name</td>
		<td><input type="text" value="${dbdetail.name}" name="name" id="name" /></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="text" value="${dbdetail.password}" name="password" id="password" /></td>
	</tr>
	<tr>
		<td>Host</td>
		<td><input type="text" value="${dbdetail.ip}" name="ip" id="ip" /></td>
	</tr>
	<tr>
		<td>Port</td>
		<td><input type="text" value="${dbdetail.port}" name="port" id="port" /></td>
	</tr>
	<tr>
		<td>SID</td>
		<td><input type="text" value="${dbdetail.sid}" name="sid" id="sid" /></td>
	</tr>
	<tr>
		<td>DESCR</td>
		<td><input type="text" value="${dbdetail.descr}" name="descr" id="descr" /></td>
	</tr>
	<tr>
		<td><input type="button" value="Save"
			onclick="saveDBDetail()"></td>
	</tr>
</table>

<form action="savedbdetail.do" method="post" name="saveform">
	<input name="stateid" id="stateid" type="hidden">
	<input name="dbdetailname" id="dbdetailname" type="hidden">
	<input name="dbdetailpassword" id="dbdetailpassword" type="hidden">
	<input name="dbdetailip" id="dbdetailip" type="hidden">
	<input name="dbdetailport" id="dbdetailport" type="hidden">
	<input name="dbdetailsid" id="dbdetailsid" type="hidden">
	<input name="dbdetaildescr" id="dbdetaildescr" type="hidden">
	<input name="newpojo" id="newpojo" type="hidden" value="true">
</form>
</body>
</html>