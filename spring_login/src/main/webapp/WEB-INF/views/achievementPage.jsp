<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #e5e8e8;
            color: #333;
            margin: 0;
            padding: 20px;
            text-align: center;
        }
        header#showcase {
            text-align: center;
            margin-bottom: 50px;
        }
        header#showcase h2 {
            font-size: 3em;
            margin-bottom: 20px;
            font-family: 'Bebas Neue', cursive;
            color: #333;
        }
        header#showcase p {
            font-size: 1.2em;
            margin-bottom: 30px;
        }
        header#showcase a {
            display: block;
            margin-bottom: 10px;
            text-decoration: none;
            color: #fff;
            background-color: #0056b3;
            padding: 10px 20px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        header#showcase a:hover {
            background-color: #003e80;
        }
        .not-achieved {
            opacity: 0.5;
        }
        /* New CSS for badges */
        .container {
            display: flex;
            justify-content: space-around; /* Distribute space evenly */
            align-items: flex-start; /* Align items at the start */
            flex-wrap: wrap; /* Allow items to wrap to the next row */
        }
        .column {
            width: 45%; /* Adjust width as needed */
        }
        .achievement,
        .badge {
            margin-bottom: 20px;
        }
        .badge img {
            width: 100px; /* Adjust size as needed */
            height: auto; /* Maintain aspect ratio */
        }
    </style>

    <title>Achievements and Badges</title>


</head>
<body>

<h1>User Achievements and Badges</h1>

<div class="container">
    <!-- Achievements column -->
    <div class="column">
        <div class="achievement">
            <h3>${achievementName1}</h3>
            <img src="https://static.thenounproject.com/png/426708-200.png" alt="First Login!">
            <p>First Login!</p>
        </div>

        <div class="achievement">
            <h3>${achievementName2}</h3>
            <img src="https://static.thenounproject.com/png/4861995-200.png" alt="Second Achievement!" class="not-achieved">
            <p class="not-achieved">Added a friend!</p>
        </div>

        <div class="achievement">
            <h3>${achievementName3}</h3>
            <img src="https://static.thenounproject.com/png/1876505-200.png" alt="Third Achievement!" class="not-achieved">
            <p class="not-achieved">Complete a skills build course!</p>
        </div>
    </div>

    <!-- Badges column -->
    <div class="column">
        <div class="badge">
            <h3>100 coins!</h3>
            <img src="https://netpayadvance.com/wp-content/uploads/2022/08/100-points.webp" alt="Badge 1">
            <p></p>
        </div>
        <div class="badge">
            <h3>500 coins!</h3>
            <img src="https://i.imgur.com/QdgaRUO.png" alt="Badge 2">
            <p></p>
        </div>
        <div class="badge not-achieved">
            <h3>1000 coins!</h3>
            <img src="https://i.imgur.com/pGwzyRS.png" alt="Badge 3">
            <p></p>
        </div>
    </div>
</div>

<a href="/achievements">Refresh achievements</a><br/>
<p><a href="/">Return Home</a><br/>


</body>
</html>
