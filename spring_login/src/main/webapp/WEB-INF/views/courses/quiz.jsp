<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
    <style>

        body {
            font-family: Arial, sans-serif;
            background: whitesmoke;
        }

        .quiz-container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 80vh;
        }

        .question-box {
            display: flex;
            justify-content: center;
            align-items: center;
            background: white;
            width: 500px;
            height: 500px;
            margin-right: 40px;
            margin-left: 30px;
            text-align: center;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3); /* 影の設定 */

        }



        .answer1-container {
            display: flex;
            flex-direction: column;
            width: 300px;
            height: 350px;
        }

        .answer1-container p {
            font-size: 20px;
            margin-top: 10px;
            text-align: left;
            border-bottom: 1px solid black; /* 下線を設定 */

        }


        .cta {
            border-radius: 40px; /* ボタンを丸くする */
            background-color: black; /* グレーの背景色 */
            color: white; /* テキストの色を白に設定 */
            padding: 15px 70px; /* 必要に応じてパディングを調整 */
            border: none; /* ボーダーを削除 */
            cursor: pointer; /* カーソルをポインターに変更 */
            transition: background-color 0.3s; /* ホバー時のアニメーションを追加 */
            display: inline-block; /* インラインブロック要素として表示 */
        }

        .cta:hover {
            background-color: grey; /* ホバー時の背景色を変更 */
        }

        .cta-container {
            text-align: center;
        }

        .q1{
            float: left;
            width: 100%;
            margin:90px 0 50px 0;
        }



    </style>
</head>
<meta charset="UTF-8">
<title>Complete</title>
</head>
<body>
<form method="post" action="/submitQuiz" onsubmit="return validateForm()">
    <div class="quiz-container">
        <div class="question-box">
            <div class="answer1-container">
                <p>Question 1: Choose right answer</p>
                <div class="q1">
                    <input type="radio" id="true1" name="answer1" value="true1">
                    <label for="true1">True</label>
                </div>
                <div>
                    <input type="radio" id="false1" name="answer1" value="false1">
                    <label for="false1">False</label>
                </div>
            </div>
        </div>
        <div class="question-box">
            <div class="answer1-container">
                <p>Question 2: Choose right answer</p>
                <div class="q1">
                    <input type="radio" id="true2" name="answer2" value="true2">
                    <label for="true2">True</label><br>
                </div>
                <div>
                    <input type="radio" id="false2" name="answer2" value="false2">
                    <label for="false2">False</label>
                </div>
            </div>
        </div>
    </div>
    <input type="hidden" name="courseName" value="${courseName}">
    <div class="cta-container">
        <button type="submit" class="cta">Submit</button>
        <p id="errorMessage"></p>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</form>


<script>
    function validateForm() {
        const answer1Checked = document.querySelector('input[name="answer1"]:checked');
        const answer2Checked = document.querySelector('input[name="answer2"]:checked');

        if (!answer1Checked || !answer2Checked) {
            document.getElementById("errorMessage").textContent = "Please select an answer for all questions.";
            return false; // フォーム送信をキャンセル
        }
        return true; // フォーム送信を許可
    }
</script>

</body>
</html>
