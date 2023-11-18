<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello</title>
</head>
<body>
    <form:form method="POST" action="uploadFile" enctype="multipart/form-data" modelAttribute="fileUploadModel">
        File to Upload: <input type="file" name="file"><br>
        Name: <input type="text" name="name"> <br>
        <input type="submit" value="Upload"><br>
        <form:errors path="file" style="color:red;"/>
    </form:form>
</body>
</html>