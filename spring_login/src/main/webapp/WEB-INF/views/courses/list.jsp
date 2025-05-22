<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e5e8e8;
            color: #333;
            margin: 0;
            padding: 20px;
            padding-top: 0px ;

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
        .progressBar{
            width:100%;
            height:40px;
            position: relative;
            border: 1px solid #000000;
        }
        .AIprogressBarFill{
            height:100%;
            width:${AITime}%;
            background: #2cbb2e ;
          <!--transition: width 0.5s; -->

        }
        .DSprogressBarFill{
            height:100%;
            width:${DSTime}%;
            background: #2cbb2e ;
        <!--transition: width 0.5s; -->

        }
        .CTEprogressBarFill{
            height:100%;
            width:${CTeTime}%;
            background: #2cbb2e ;
        <!--transition: width 0.5s; -->

        }
        .CTHprogressBarFill{
            height:100%;
            width:${CThTime}%;
            background: #2cbb2e ;
        <!--transition: width 0.5s; -->

        }
        .SprogressBarFill{
            height:100%;
            width:${STime}%;
            background: #2cbb2e ;
        <!--transition: width 0.5s; -->

        }
        .progressBarValue{
            position: absolute;
            width:100%;
            height:100%;
            display:flex;
            align-items:center;
            justify-content: center;
        }
    </style>
</head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Courses</title>
</head>
<body>
<h1><a href="/">Homepage</a><br/> </h1>

<h2><u>Coins</u></h2>
<p>Earn coins as a reward for exploring the dashboard and completing courses! </p>
<p><b>Coin Balance : ${coinsEarned} coins</b> </p>

<h2><u>Available Courses</u></h2>
<h3><a href="/topCourses">View most popular courses</a><br/> </h3>


<h2>Name: Getting Started with Enterprise-grade AI</h2>
<p>Description: This course teaches an understanding of the foundations of Artificial Intelligence for business, including the following topics: AI Evolution, AI Industry Adoption Trends, Natural Language Processing and Virtual Agents.</p>
<p><a href="/aiCourse">Start learning!</a><br/> <a href="/pauseAI"> Pause Course</a><br/><a href="/aiCourse"> Resume Course</a><br><a href="quizForm?courseName=AI">Complete</a></p><div class = "progressBar"><div class = "progressBarValue">${AITime}%</div><div class = "AIprogressBarFill"></div></div>
<%--<p>Total finished attempts for AI: <c:out value="${clickCounts['AI']}" /></p>--%>


<h2>Name: Getting Started with Enterprise Data Science</h2>
<p>Description: This course teaches an understanding of the foundations of Data Science including: Data science team roles, Data analysis tools, and real-world use cases for the application of the Data science method.</p>
<p><a href="/dataScience">Start learning!</a><br/><a href="/pauseDataScience">Pause Course</a><br/><a href="/dataScience"> Resume Course</a><br/><a href="quizForm?courseName=DataScience">Complete</a></p><div class = "progressBar"><div class = "progressBarValue">${DSTime}%</div><div class = "DSprogressBarFill"></div></div>
<%--<p>Total finished attempts for Data Science: <c:out value="${clickCounts['DataScience']}" /></p>--%>

<h2>Name: Journey to Cloud: Envisioning Your Solution</h2>
<p>Description: This course teaches an understanding of the digital transformation drivers made possible by cloud technologies and services. This includes: how cloud works, its capabilities, types, and delivery models (IaaS, SaaS, and PaaS); digital transformation strategies such as Agile practices, the IBM Garage Method, and Enterprise Design Thinking to help organizations get started on their transformation journey; and deploying a test pilot cloud application using IBM Code Engine.</p>
<p><a href="/cloudTechnology">Start learning!</a><br/><a href="/pauseCloudTech">Pause Course</a><br/><a href="/cloudTechnology"> Resume Course</a><br/><a href="quizForm?courseName=CloudTechnology">Complete</a></p><div class = "progressBar"><div class = "progressBarValue">${CTeTime}%</div><div class = "CTEprogressBarFill"></div></div>
<%--<p>Total finished attempts for Cloud Technology: <c:out value="${clickCounts['CloudTechnology']}" /></p>--%>


<h2>Name: Getting Started with Threat Intelligence and Hunting</h2>
<p>Description: This course teaches an understanding in adopting practices, methods and tools that relates to the activities performed in cyber threat hunting.</p>
<p><a href="/cyberThreat">Start learning!</a><br/><a href="/pauseCyberThreat">Pause Course</a><br/><a href="/cyberThreat"> Resume Course</a><br/><a href="quizForm?courseName=CyberThreat">Complete</a></p><div class = "progressBar"><div class = "progressBarValue">${CThTime}%</div><div class = "CTHprogressBarFill"></div></div>
<%--<p>Total finished attempts for Cyber Threats: <c:out value="${clickCounts['CyberThreat']}" /></p>--%>


<h2>Name: Fundamentals of Sustainability and Technology</h2>
<p>Description: This course teaches an understanding of how data analytics, artificial intelligence (AI), and hybrid cloud computing are revolutionizing ways that humans support each other, while protecting Earth's resources, as well as a conceptual understanding of how to select and apply advanced technologies to sustainability issues, and is familiar with the skills required for success in various technology roles.</p>
<p><a href="/sustainability">Start learning!</a><br/><a href="/pauseSustainability">Pause Course</a><br/><a href="/sustainability"> Resume Course</a><br/><a href="quizForm?courseName=Sustainability">Complete</a></p><div class = "progressBar"><div class = "progressBarValue">${STime}%</div><div class = "SprogressBarFill"></div></div>
<%--<p>Total finished attempts for Sustainability: <c:out value="${clickCounts['Sustainability']}" /></p>--%>


</body>
</html>
