<%@ page import="com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Auteur" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: radouane
  Date: 4/9/23
  Time: 2:46 AM
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



<form action="add-livre-servlet" method="post">
    <label for="title">Title:</label>
    <input type="text" id="title" name="titre" required ><br>

    <label for="description">Description:</label>
    <textarea id="description" name="description" required></textarea><br>

    <label for="dateEdition">Publication Date:</label>
    <input type="date" id="dateEdition" name="dateEdition" required><br>

    <label for="editeur">Editeur:</label>
    <select id="editeur" name="editeur" required>
        <option value="">All</option>
        <option value="ENI">ENI</option>
        <option value="DUNOD">DUNOD</option>
        <option value="FIRST">FIRST</option>
    </select><br>

    <label for="matricule">Author:</label>
    <select id="matricule" name="matricule" required>
        <option value="">All</option>
        <%
        List<Auteur> auteurs = (List<Auteur>) request.getAttribute("auteurs");

        for (Auteur auteur : auteurs) {
            out.println("<option value=\"" + auteur.getMatricule() + "\">" + auteur.getNom() + " " + auteur.getPrenom() + "</option>");
        }
        %>
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
