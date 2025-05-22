<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <title>Result</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e5e8e8;
            color: #333;
            margin: 0;
            padding: 40px;
            padding-top: 40px ;
        }

        p{
            font-size: 30px;
        }

        a {
            display: block;
            text-align: center;
            vertical-align: middle;
            text-decoration: none;
            width: 120px;
            padding: 1rem 4rem;
            font-weight: bold;
            border: 2px solid black;
            color: black;
            transition: 0.5s;
            margin-top: 60px;
        }
        a:hover {
            color: #fff;
            background: black;
        }


    </style>
</head>
<body>
<c:if test="${counter == 2}">
    <p>Congratulations! You got both answers correct. You have completed the course successfully.</p>
    <c:choose>
        <c:when test="${courseName eq 'AI'}">
            <a href="/completeAI">Complete</a>
        </c:when>
        <c:when test="${courseName eq 'DataScience'}">
            <a href="/completeDataScience">Complete</a>
        </c:when>
        <c:when test="${courseName eq 'CloudTechnology'}">
            <a href="/completeCloudTechnology">Complete</a>
        </c:when>
        <c:when test="${courseName eq 'CyberThreat'}">
            <a href="/completeCyberThreat">Complete</a>
        </c:when>
        <c:when test="${courseName eq 'Sustainability'}">
            <a href="/completeSustainability">Complete</a>
        </c:when>
    </c:choose>
</c:if>

<c:if test="${counter != 2}">
    <p>You must pass "Quiz" to complete the course.</p>
    <a href="/quizForm?courseName=${courseName}">Try Again</a><br>
    <a href="/">Home</a>
</c:if>

</body>
</html>
