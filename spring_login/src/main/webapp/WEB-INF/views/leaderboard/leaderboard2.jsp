<%--
    View for global leaderboard
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/leaderboard.css" />
    <script src="https://kit.fontawesome.com/85f7d81ead.js" crossorigin="anonymous"></script>
    <title>Global Leaderboard</title>
</head>

<body>
<h2>Global Leaderboard</h2>

<c:set var="rank" value="1" />
<c:set var="count" value="1" />
<c:set var="achievements" value="-1" />
<div>
    <table border="1">
        <thead>
        <tr>
            <th>RANK</th>
            <th>NAME</th>
            <th>ACHIEVEMENTS</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${leaderboard}" var="user">
            <%-- JSTL if-else to check if current User has same number of completed courses with previous User
                    if so: Give the rank
                    else: Give the positional rank
               --%>
            <c:choose>
                <c:when test="${achievements == user.achievementCount}">
                    <c:set var="rank" value="${rank}" />
                </c:when>
                <c:otherwise>
                    <c:set var="rank" value="${count}" />
                </c:otherwise>
            </c:choose>
            <tr>
                <td>${rank}</td>
                <td>${user.name}</td>
                <td>${user.achievementCount}</td>
            </tr>
            <c:set var="count" value="${count + 1}" />
            <c:set var="achievements" value="${user.achievementCount}" />
        </c:forEach>
        </tbody>
    </table>
    <a class="arrow" href="/leaderboard"><i class="fa-solid fa-arrow-right fa-flip"></i></a>
    <a class="button" href="/">RETURN HOME</a>
</div>
<br>
</body>
</html>
