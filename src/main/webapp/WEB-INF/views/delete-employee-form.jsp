<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Employee</title>
</head>
<body>
	<div id="root">
		<div id="form">
			<form:form action="" method="post" modelAttribute="deleteemployee">
				<div>
					<label for="emp_Id">Employee id</label>
					<div>
						<form:input path="emp_Id" readonly="true" />
					</div>
				</div>
			</form:form>
		</div>
	</div>

</body>
</html>