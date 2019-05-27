<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring Boot Application with JSP</title>
</head>
<body>
    Hello, Spring Boot App
    
    <form action="https://cvu.awin.com/rest/upload/cv" 
    method="POST" 
    enctype="multipart/form-data">
    	<table>
			<tr>
				<td>File to upload:</td>
				<td><input type="file" name="file" />
				</td>
			</tr>
			<tr>
				<td>firstname : </td>
				<td><input type="text" name="firstname"></td>
			</tr>
			<tr>
				<td>lastname : </td>
				<td><input type="text" name="lastname"></td>
			</tr>
			
			<tr>
				<td>email : </td>
				<td><input type="email" name="email"></td>
			</tr>
			
			
			<tr>
				<td>jobtitle : </td>
				<td><input type="text" name="jobtitle"></td>
			</tr>
			
			
			<tr>
				<td>source : </td>
				<td><input type="text" name="source"></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Upload" /></td>
			</tr>
		</table>
    
    </form>
</body>
</html>