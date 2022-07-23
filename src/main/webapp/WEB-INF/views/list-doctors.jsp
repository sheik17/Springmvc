<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor List</title>
</head>
<body>
	<div id="table root">
		<table>
			<thead>
				<tr>
					<th>Doc_Id</th>
					<th>Doc_Name</th>
					<th>Dob</th>
					<th>Speciality</th>
					<th>City</th>
					<th>Phone_no</th>
					<th>Fees</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="doctor" items="${alldoctor}">
					<!--var represents variable items represents collection  -->
					<tr>
						<td>${doctor.id}</td>
						<td>${doctor.doc_name}</td>
						<td>${doctor.dob}</td>
						<td>${doctor.speciality}</td>
						<td>${doctor.city}</td>
						<td>${doctor.phone_no}</td>
						<td>${doctor.fees}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>