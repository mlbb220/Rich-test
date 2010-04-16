<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show DB Details</title>
</head>
<script type="text/javascript">
function deleteDBDetail(id){
	if(confirm("Do you want to delete this DB Info?")){
		document.deleteform.dbdetailid.value=id;
		document.deleteform.submit();
	}
}
function editDBDetail(id){
	document.editform.dbdetailid.value=id;
	document.editform.submit();
}
function saveDBDetail(id){
	document.saveform.savedbdetailid.value=id;
	//document.saveform.dbdetailname.value=document.getElementById('name').value;
	//document.saveform.dbdetailpassword.value=document.getElementById('password').value;
	//document.saveform.dbdetailip.value=document.getElementById('ip').value;
	//document.saveform.dbdetailport.value=document.getElementById('port').value;
	//document.saveform.dbdetailsid.value=document.getElementById('sid').value;
	document.saveform.dbdetaildescr.value=document.getElementById('descr').value;
	document.saveform.submit();
}
</script>
<body>
<a href="newdbdetail.do">New DBDetail</a>
<table border="1">
	<tr>
		<td>ID</td>
		<td>StateName</td>
		<td>Name</td>
		<td>Password</td>
		<td>Host</td>
		<td>Port</td>
		<td>SID</td>
		<td>DESCR</td>
		<td>EntryDate</td>
		<td>Edit</td>
	</tr>
	<c:forEach var="dbdetail" items="${dbdetails}">
		<c:choose>
			<c:when test="${dbdetail.id==dbdetailid}">
				<tr>
					<td>${dbdetail.id}</td>
					<td>						
					<c:forEach var="state" items="${states}">
						<c:if test="${state.id==dbdetail.states_id}">
							${state.name }
						</c:if>
					</c:forEach>
					</td>
					<td>${dbdetail.name}</td>
					<td>${dbdetail.password}</td>
					<td>${dbdetail.ip}</td>
					<td>${dbdetail.port}</td>
					<td>${dbdetail.sid}</td>
					<td><input type="text" value="${dbdetail.descr}" name="descr" id="descr"/></td>
					<td>${dbdetail.entry_date}</td>
					<td><input type="button" value="Save"onclick="saveDBDetail(${dbdetail.id})"></td>
				</tr>
			</c:when>
			<c:when test="${dbdetail.id==1}">
				<tr>
					<td>${dbdetail.id}</td>
					<td>						
					<c:forEach var="state" items="${states}">
						<c:if test="${state.id==dbdetail.states_id}">
							${state.name }
						</c:if>
					</c:forEach>
					</td>
					<td><input type="text" value="${dbdetail.name}" name="name" id="name"/></td>
					<td><input type="text" value="${dbdetail.password}" name="password" id="password"/></td>
					<td><input type="text" value="${dbdetail.ip}" name="ip" id="ip"/></td>
					<td><input type="text" value="${dbdetail.port}" name="port" id="port"/></td>
					<td><input type="text" value="${dbdetail.sid}" name="sid" id="sid"/></td>
					<td><input type="text" value="${dbdetail.descr}" name="descr" id="descr"/></td>
					<td>${dbdetail.entry_date}</td>
					<td><input type="button" value="Save"onclick="saveDBDetail(${dbdetail.id})"></td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td>${dbdetail.id}</td>
					<td>						
					<c:forEach var="state" items="${states}">
						<c:if test="${state.id==dbdetail.states_id}">
							${state.name }
						</c:if>
					</c:forEach>
					</td>
					<td>${dbdetail.name}</td>
					<td>${dbdetail.password}</td>
					<td>${dbdetail.ip}</td>
					<td>${dbdetail.port}</td>
					<td>${dbdetail.sid}</td>
					<td>${dbdetail.descr}</td>
					<td>${dbdetail.entry_date}</td>
					<td>
						<input type="button" value="Edit"onclick="editDBDetail(${dbdetail.id})">
						&nbsp;&nbsp;
						<input type="button" value="Delete"onclick="deleteDBDetail(${dbdetail.id})">
					</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</table>
<form action="deletedbdetail.do" method="post" name="deleteform">
	<input name="dbdetailid" id="dbdetailid" type="hidden">
</form>
<form action="showdbdetail.do" method="post" name="editform">
	<input name="dbdetailid" id="dbdetailid" type="hidden">
</form>
<form action="savedbdetail.do" method="post" name="saveform">
	<input name="savedbdetailid" id="savedbdetailid" type="hidden">
	<input name="dbdetailname" id="dbdetailname" type="hidden">
	<input name="dbdetailpassword" id="dbdetailpassword" type="hidden">
	<input name="dbdetailip" id="dbdetailip" type="hidden">
	<input name="dbdetailport" id="dbdetailport" type="hidden">
	<input name="dbdetailsid" id="dbdetailsid" type="hidden">
	<input name="dbdetaildescr" id="dbdetaildescr" type="hidden">
</form>

</body>
</html>