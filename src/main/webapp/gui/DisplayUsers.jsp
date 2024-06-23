<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Users Display Page</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
	<style>
		table {
			border: 1px solid black;
		}
		
		.tr, th, td {
			text-align: center;
		}
	</style>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Here are all the registered users</h1>
        <table class="table table-bordered table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.value.name}</td>
                        <td>${user.value.surname}</td>
                        <td>
                        	<a class="btn btn-primary" href="${pageContext.request.contextPath}/userDetails?id=${user.value.id}">View Details</a>
	                        <form method="post" action="${pageContext.request.contextPath}/display" style="display:inline;">
                                <input type="hidden" name="userId" value="${user.value.id}" />
                                <input type="hidden" name="action" value="delete" />
                                <button type="submit" class="btn btn-danger button big">Delete</button>
	                       	</form>
                       	</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="container">
		  <div class="row">
		    <div class="col text-center">
		      <a class="btn btn-primary" href="/JavaWebApp" role="button">Home</a>
		    </div>
		  </div>
		</div>
    </div>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"></script>
</body>
</html>
