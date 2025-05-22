<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Congratulations!</title>
    <link rel="stylesheet" type="text/css" href="/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>

</head>
<body>
<h2>You have finished ${completedCourse.courseName} in ${time} seconds.</h2>
<p>You now have ${coinsEarned} coins after completing the course!</p>
<p>Thank you for taking the course. We hope you enjoyed it.</p>



<%--COMMENT BOX --%>

<div class="comment-box" >
    <p>Leave a comment!</p>
    <form class="comment-form" action="/courses" >
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input type="text" placeholder="Name">
        <input type="email" placeholder="Email">
        <textarea rows="10" placeholder="How can we make improvements?"></textarea>
        <button type="submit">Post Comment</button>
    </form>
</div>


<%--STAR RATING --%>
<div class="container">
    <div class="star-widget">
        <input type="radio" name="rate" id="rate-5">
        <label for="rate-5" class="fas fa-star"></label>
        <input type="radio" name="rate" id="rate-4">
        <label for="rate-4" class="fas fa-star"></label>
        <input type="radio" name="rate" id="rate-3">
        <label for="rate-3" class="fas fa-star"></label>
        <input type="radio" name="rate" id="rate-2">
        <label for="rate-2" class="fas fa-star"></label>
        <input type="radio" name="rate" id="rate-1">
        <label for="rate-1" class="fas fa-star"></label>
        <header></header>
        <div class="textarea">
            <form class="comment-form" action="/courses" >
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

                <label>

                                <button type="submit">Post Rating</button>
                            </div>
                        </div>
                    <textarea cols="30" placeholder="Describe your experience.."></textarea>
                </label>
            </form>
        </div>
        <div class="btn">

</div>

<a href="/">Return Home</a><br/>

</body>
</html>

