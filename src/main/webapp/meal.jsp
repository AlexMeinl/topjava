<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meal</title>
</head>
<body>
<form method="POST" action='MealServlet' name="addMeal">
    <input type="text" readonly="readonly" name="id"
                     value="<c:out value="${meal.id}" />" /> <br />
    <input
        type="text" name="Date"
        value="<c:out value="${meal.dateTime}" />" /> <br />
    <input
        type="text" name="Description"
        value="<c:out value="${meal.description}" />" /> <br />
     <input type="text" name="calories"
                   value="<c:out value="${meal.calories}" />" /> <br /> <input
        type="submit" value="Submit" />
</form>
</body>
</html>
