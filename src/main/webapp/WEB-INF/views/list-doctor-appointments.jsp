<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
    <div id="root">
        <div id="docform">
            <form:form action="" method="post" modelAttribute="getdoctor">
                <div>
                    <label for="id">Doctor Id</label>
                    <div>
                        <form:input path="id" />
                    </div>
                </div>
                <div>
                    <label for="doc_name">Doctor Name</label>
                    <div>
                        <form:input path="doc_name" />
                    </div>
                </div>
                <div>
                    <label for="dob">DOB</label>
                    <div>
                        <form:input path="dob" />
                    </div>
                </div>
                <div>
                    <label for="speciality">Special</label>
                    <div>
                        <form:input path="speciality" />
                    </div>
                </div>
                <div>
                    <label for="city">City</label>
                    <div>
                        <form:input path="city" />
                    </div>
                </div>
                <div>
                    <label for="phone_no">Phone Number</label>
                    <div>
                        <form:input path="phone_no" />
                    </div>
                </div>
                <div>
                    <label for="fees">Fees</label>
                    <div>
                        <form:input path="fees" />
                    </div>
                </div>
                </form:form>
                </div>
              
           <div id="applist">
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>AppointDate</th>
					<th>DocId</th>
					<th>PatientName</th>
					<th>Fees</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="app" items="${applist}">
					<!--var represents variable items represents collection  -->
					<tr>
						<td>${app.id}</td>
						<td>${app.appointDate}</td>
						<td>${app.docid}</td>
						<td>${app.patientname}</td>
						<td>${app.fees}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>