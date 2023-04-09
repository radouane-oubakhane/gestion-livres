<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>authentification</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Helvetica Neue', sans-serif;
            background-color: #f9f9f9;
        }

        .container {
            max-width: 500px;
            margin: 100px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        h1 {
            text-align: center;
            color: #008000;
            margin-bottom: 30px;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="password"] {
            margin-bottom: 15px;
            padding: 10px;
            border: none;
            border-radius: 3px;
            font-size: 16px;
            background-color: #f2f2f2;
        }

        input[type="submit"] {
            background-color: #008000;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 3px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #006400;
        }
        .error-message {
            color: #f00;
            font-weight: bold;
            border: 2px solid #f00;
            background-color: #ffe6e6;
            padding: 10px;
            margin-bottom: 10px;
        }

    </style>
</head>
<body>
    <div class="container">
        <h1>Formulaire d'authentification</h1>
        <form action="authentification-servlet" method="post">
            <label for="login">Login :</label>
            <input type="text" id="login" name="login" required>
            <%
                boolean error = request.getAttribute("error") != null;
                if (error) {
            %>
            <p class="error-message">${requestScope.get('error')}</p>
            <% } %>

            <label for="password">Mot de passe :</label>
            <input type="password" id="password" name="password" required>

            <input type="submit" value="Se connecter">
        </form>
    </div>
</body>
</html>



