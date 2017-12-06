<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!-- ck finder -->
<%@ taglib uri="http://cksource.com/ckfinder" prefix="ckfinder" %>
<html>
<% response.addHeader("X-Frame-Options", "SAMEORIGIN"); %> 

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Users List</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
<!-- ck -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ckeditor/ckeditor.js"/></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ckfinder/ckfinder.js"></script>
</head>

<body>
<!-- 	<div class="generic-container">
 -->	<div class="">
		<%@include file="authheader.jsp" %>	
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">List of Users </span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>Firstname</th>
				        <th>Lastname</th>
				        <th>Email</th>
				        <th>Selog ID</th>
				        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
				        	<th width="100"></th>
				        </sec:authorize>
				        <sec:authorize access="hasRole('ADMIN')">
				        	<th width="100"></th>
				        </sec:authorize>
				        
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.email}</td>
						<td>${user.ssoId}</td>
					    <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
							<td><a href="<c:url value='/edit-user-${user.ssoId}' />" class="btn btn-success custom-width">edit</a></td>
				        </sec:authorize>
				        <sec:authorize access="hasRole('ADMIN')">
							<td><a href="<c:url value='/delete-user-${user.ssoId}' />" class="btn btn-danger custom-width">delete</a></td>
        				</sec:authorize>
					</tr>
					
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
		
		<sec:authorize access="hasRole('ADMIN')">
		 	<div class="well">
		 		<a href="<c:url value='/newuser' />">Add New User</a>
		 	</div>
	 	</sec:authorize>
	 	<sec:authorize access="hasRole('USER')">
	 		<div class="well">
		 		<a href="<c:url value='/index' />">go to Index</a>
		 	</div>	
	 	</sec:authorize>
	 	<%-- <sec:authorize access="hasRole('USER')"> --%>
		 	<div class="well">
		 	<textarea id="post_content" name="post_content"></textarea>
			<script>
				window.onload=function(){
					
					var editor = CKEDITOR.replace('post_content');
					CKFinder.setupCKEditor(editor,'/ckfinder/')	
				}
			</script>
			 
		 	<!-- post list -->
		   	<h3>Posts List</h3>
			<table class="tg">
			<tr>
				<th width="80">Post ID</th>
				<th width="120">Post Title</th>
				<th width="120">Post Content</th>
				<th width="120">Post Owner</th>
				<th width="120">Post visible</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listPosts}" var="post">
				<tr>
					<td>${post.post_key}</td>
					<td>${post.post_title}</td>
					<td>${post.post_content}</td>
					<td>${post.post_owner}</td>	
					<td>${post.post_visible}</td>
					<td><a href="noidea" >Edit</a></td>
					<td><a href="noidea" >Delete</a></td>
				</tr>
			</c:forEach>
		 
		 
		</table>
		</div>	
		<%-- </sec:authorize> --%>
   	</div>
</body>
</html>