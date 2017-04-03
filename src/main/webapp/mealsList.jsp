<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meal list</title>
</head>
<body>
<h2><a href="index.html">Home</a></h2>
<h2>Meal list</h2>


<table>
    <tr>
        <th width="120">Date</th>
        <th width="120">Description</th>
        <th width="120">Calories</th>
        <th width="80">Delete</th>
        <th width="80">Update</th>
        <th width="80">Read</th>
    </tr>
    <c:forEach items="${listMeals}" var="meal">
        <tr>
            <td>${meal.dateTime}</td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td><a href="MealServlet?action=delete&id=<c:out value="${meal.id}"/>">Update</a></td>
            <td><a href="MealServlet?action=update&id=<c:out value="${meal.id}"/>">Update</a></td>
            <td><a href="<c:url value='/read/${user.id}'/>">Read</a></td>
        </tr>
    </c:forEach>
</table>
<p><a href="MealServlet?action=insert">Add User</a></p>
</body>
</html>