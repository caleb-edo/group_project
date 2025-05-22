<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Error Page</title>

    <style>
        body {
            background-image: url('/list.jpg');
            background-size: cover;
        }
        h1 {
            color: white;
            font-family: "Poppins", sans-serif;
            line-height: 4;
            font-size: 4rem;
            margin: 10px;
        }
        .button {
            display: block;
            background: rgb(249, 168, 212);
            width: 12rem;
            padding: 1rem;
            border-radius: .6rem;
            color: rgba(2,14,59,1);
            text-align: center;
            text-decoration: none;
            font-family: "Poppins", sans-serif;

            letter-spacing: .1rem;

            transition: .5s;
            margin: 15rem auto;
            box-shadow: 0 0 10px 5px rgba(255, 255, 255, 0.5); /* 白く光らせる境界線 */
        }
        .button:hover {
            transform: scale(1.3,1.3);
        }
        p {
            color: cornflowerblue;
            font-family: "Poppins", sans-serif;
            padding-left: 10px;
            font-size: 2rem;

        }

    </style>
</head>
<body>

<h1>An error occurred.</h1>
<p>${errorMessage}</p>
<a class="button" href="/courses">Return Home</a>

</body>
</html>
