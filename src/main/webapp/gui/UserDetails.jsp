<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User ${user.name}</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
	<style>
		table {
			border: 1px solid black;
		}
	</style>
</head>
<body>
	<div align="center" class="container mt-5">
        <h1 class="text-center">Details for User: ${user.name} ${user.surname}</h1>
        <table class="table table-bordered table-striped">
			<tr>
				<td>Full name: ${user.name} ${user.surname} </td>
			</tr>
			<tr>
			<c:choose>
			    <c:when test="${user.gender=='M'}">
			        <td> Male ${user.birthdate} </td>
			    </c:when>    
			    <c:otherwise>
			        <td> Female ${user.birthdate} </td> 
			    </c:otherwise>
			</c:choose>
			</tr>
			<tr>
				<td> Working address: ${user.workAddress} </td>
			</tr>
			<tr>
				<td> Home address: ${user.homeAddress} </td>
			</tr>
		</table>
	</div>
	<div class="container">
		  <div class="row">
		    <div class="col text-center">
		      <a class="btn btn-danger" href="javascript:;" onclick="window.close()" role="button">Back</a>
		    </div>
		  </div>
		</div>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"></script>
</body>
</html>