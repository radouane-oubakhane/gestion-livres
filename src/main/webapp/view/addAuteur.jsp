<%--
  Created by IntelliJ IDEA.
  User: radouane
  Date: 4/9/23
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        form {
            display: flex;
            flex-direction: column;
            align-items: flex-start;
            gap: 10px;
            max-width: 500px;
            margin: 0 auto;
        }

        label {
            font-weight: bold;
        }

        input[type="number"],
        input[type="text"],
        textarea,
        select {
            width: 100%;
            padding: 5px;
            font-size: 16px;
            border-radius: 5px;
            border: 1px solid gray;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border-radius: 5px;
            border: none;
            font-size: 18px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0062cc;
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

<form action="add-auteur-servlet" method="post">
    <label for="title">Nom:</label>
    <input type="text" id="title" name="nom" required ><br>

    <label for="title">Prenom:</label>
    <input type="text" id="title" name="prenom" required ><br>


    <label for="editeur">Genre:</label>
    <select id="editeur" name="genre" required>
        <option value="Masculin">Masculin</option>
        <option value="Féminin">Féminin</option>
    </select><br>

    <input type="submit" value="Submit">

    <%
        boolean error = request.getAttribute("error") != null;
        if (error) {
    %>
    <p class="error-message">${requestScope.get('error')}</p>
    <% } %>
</form>

</body>
</html>
