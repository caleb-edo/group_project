<%--
    View for user's friend list
    Can see the user's friends and friend requests
    Can accept/decline requests
    Can add/remove friends
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/friendlist.css" />
    <title>List of Friends</title>
</head>

<body>
<div class="container">
    <div class="friends">
        <h2>Friends</h2>
        <c:forEach items="${friends}" var="friend">
            <div class="friends_row">
                <p class="a_container1">${friend.name}</p>
                <a class="a_button1" href="/remove?userid=${user.id}&friendid=${friend.id}">Remove</a> <%-- Link to controller mapping to remove friend--%>
            </div>
        </c:forEach>
        <br>
        <%--<p><a class="special" href="/newFriend?userid=${user.id}">Add Friend</a></p>--%> <%-- Add link to controller mapping to add friend--%>
    </div>
    <div class="add_friend">
        <div class="requests">
            <h2>Friend Requests</h2>
            <c:forEach items="${requests}" var="request">
                <div class="friends_row">
                    <p class="a_container2">${request.sender.name}</p>
                    <div class="request_button">
                        <a class="a_button2" href="/accept?userid=${user.id}&requestid=${request.r_id}">Accept</a> <%-- Link to controller mapping to accept friend request--%>
                        <a class="a_button1" href="/decline?userid=${user.id}&requestid=${request.r_id}">Decline</a> <%-- Link to controller mapping to decline friend request--%>
                    </div>
                </div>
            </c:forEach>
            <br>
        </div>
        <h2>Add Friends</h2>
        <form action="/addFriend" method="post">
            <div class="form">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" />

                <input name="userid" type="hidden" value="${user.id}"><br/>

                <button type="submit">Add</button>
                <h3>${msg}</h3>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
    </div>
</div>
<a class="special" href="/">Return Home</a>
</body>
</html>