<%@ page import="java.util.List" %>
<%@ page import="com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Livre" %><%--
  Created by IntelliJ IDEA.
  User: radouane
  Date: 4/8/23
  Time: 5:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* Basic page styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            color: #333;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 40px;
        }

        h1 {
            font-size: 28px;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 40px;
        }

        th, td {
            padding: 12px;
            text-align: left;
            vertical-align: middle;
            border-bottom: 1px solid #ccc;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f7f7f7;
        }

        td:nth-child(odd) {
            font-weight: bold;
        }

        @media screen and (max-width: 768px) {
            h1 {
                font-size: 24px;
            }

            table {
                font-size: 14px;
            }

            th, td {
                padding: 8px;
            }
        }

        .search-container {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 20px;
        }

        input[type="text"] {
            width: 300px;
            padding: 10px;
            font-size: 16px;
            border: none;
            border-radius: 5px 0 0 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        select[name="type"] {
            padding: 10px;
            border: none;
            border-radius: 0 5px 5px 0;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            font-size: 16px;
            margin-left: -4px;
        }

        .search {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 0 5px 5px 0;
            padding: 10px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button[type="submit"]:hover {
            background-color: #0062cc;
        }

        /* Media query for smaller screens */
        @media screen and (max-width: 480px) {
            .search-container {
                flex-wrap: wrap;
            }

            input[type="text"], select[name="type"], button[type="submit"] {
                width: 100%;
                margin-bottom: 10px;
            }

            select[name="type"] {
                margin-left: 0;
                border-radius: 5px;
            }
        }

        .edit-btn {
            background-color: #007bff;
            color: #fff;
            padding: 8px 16px;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }

        .edit-btn:hover {
            background-color: #0062cc;
        }

        .delete-btn {
            background-color: #dc3545;
            color: #fff;
            padding: 8px 16px;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }

        .delete-btn:hover {
            background-color: #c82333;
        }

        .add-button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 12px 24px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 10px;
            cursor: pointer;
        }


    </style>
</head>
<body>
<h1>Admin - ${sessionScope.get('login')}</h1>

<form action="search-servlet" method="get">
    <input type="text" placeholder="Recherche..." name="search">
    <select name="searchType">
        <option value="all">All</option>
        <option value="titre">Title</option>
        <option value="author">Author</option>
    </select>
    <button type="submit" class="search">Recherche</button>
</form>

<form action="add-servlet" method="get">
    <button class="add-button">Ajouter</button>
</form>


<%
    List<Livre> livres = (List<Livre>) request.getAttribute("livres");
%>

<%
    out.println("<table>");
    out.println("<tr>");
    out.println("<th>Titre</th>");
    out.println("<th>Description</th>");
    out.println("<th>Date Edition</th>");
    out.println("<th>Editeur</th>");
    out.println("<th></th>");
    out.println("<th></th>");
    out.println("</tr>");
    for (int i = 0; i < livres.size(); i++) {
        out.println("<tr>");
        out.println("<td>" + livres.get(i).getTitre() + "</td>");
        out.println("<td>" + livres.get(i).getDescription() + "</td>");
        out.println("<td>" + livres.get(i).getDateEdition() + "</td>");
        out.println("<td>" + livres.get(i).getEditeur() + "</td>");

        out.print("<td>");
        out.print("<form action=\"edit-servlet\" method=\"get\">");
        out.print("<button class=\"edit-btn\" type=\"submit\" name=\"id\" value=\"" + livres.get(i).getISBN() + "\">Modifier</button>");
        out.print("</form>");
        out.print("</td>");

        out.print("<td>");
        out.print("<form action=\"delete-servlet\" method=\"delete\">");
        out.print("<button class=\"delete-btn\" type=\"submit\" name=\"id\" value=\"" + livres.get(i).getISBN() + "\">Supprimer</button>");
        out.print("</form>");
        out.print("</td>");

        out.println("</tr>");
    }

    out.println("</table>");
%>



</body>
</html>
