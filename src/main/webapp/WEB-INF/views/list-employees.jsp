<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
</head>
<body>
	<div id="table root">
		<table>
			<thead>
				<tr>
					<th>Emp_Id</th>
					<th>First_name</th>
					<th>Last_name</th>
					<th>Email</th>
					<th>Hire_date</th>
					<th>Job_id</th>
					<th>Salary</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="employee" items="${allemployees}">
					<!--var represents variable items represents collection  -->
					<tr>
						<td>${employee.emp_Id}</td>
						<td>${employee.first_name}</td>
						<td>${employee.last_name}</td>
						<td>${employee.email}</td>
						<td>${employee.hire_date}</td>
						<td>${employee.job_id}</td>
						<td>${employee.salary}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>