<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Top Courses</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e5e8e8;
            color: #333;
            margin: 0;
            padding: 20px;
            padding-top: 0px ;
        }
        table {
            font-family: Arial, sans-serif;
            background-color: #e5e8e8;
            color: #333;
            margin: 0;
            font-size: 1.5em;

        }
        header#showcase h2 {
            font-size: 3em;
            margin-bottom: 20px;
        }
        header#showcase p {
            font-size: 1.2em;
            margin-bottom: 30px;
        }
        header#showcase a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Top Courses</h1>
    <table border="1">
        <tr>
            <th>Course Name</th>
            <th>Finished Attempts</th>
        </tr>
        <c:forEach var="course" items="${topCourses}">
            <tr>
                <td>${course.courseName}</td>
                <td>${course.clickCount}</td>
            </tr>
        </c:forEach>
    </table>

    <p><a href="/courses">Go back</a><br/>
</body>
</html>