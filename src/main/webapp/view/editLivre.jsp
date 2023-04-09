<%--
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

    </style>
</head>
<body>

<%
request.setAttribute("isbn", request.getParameter("isbn"));

%>

<form action="submit-form.php" method="post">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required><br>

    <label for="description">Description:</label>
    <textarea id="description" name="description" required></textarea><br>

    <label for="date_edition">Publication Date:</label>
    <input type="date" id="date_edition" name="date_edition" required><br>

    <label for="editeur">Publisher:</label>
    <select id="editeur" name="editeur" required>
        <option value="">Select a publisher</option>
        <option value="ENI">ENI</option>
        <option value="DUNOD">DUNOD</option>
        <option value="FIRST">FIRST</option>
    </select><br>

    <label for="matricule">Author ID:</label>
    <input type="number" id="matricule" name="matricule" required><br>

    <input type="submit" value="Submit">
</form>


</body>
</html>
