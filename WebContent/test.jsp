<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>hp</td>
        <td>edit</td>
        <td>delete</td>
    </tr>
    <c:forEach items="${projects}" var="project" varStatus="st">
        <tr>
            <td>${project.id}</td>
            <td>${project.name}</td>
            <td>${project.userId}</td>
            <td><a href="">edit</a></td>
            <td><a href="">delete</a></td>
        </tr>
    </c:forEach>

</table>

