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

        button[type="submit"] {
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


    </style>
</head>
<body>
<div>
<h1>Visiteur - ${sessionScope.get('login')} </h1>

<form action="authentification-servlet" method="get">
    <input type="submit" value="Log Out" class="search" style="background-color: #c82333">
</form>
</div>

<form action="search-servlet" method="get">
    <input type="text" placeholder="Recherche..." name="search">
    <select name="searchType">
        <option value="all">All</option>
        <option value="titre">Title</option>
        <option value="author">Author</option>
    </select>
    <button type="submit">Recherche</button>
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
    out.println("<th>Nom Auteur</th>");
    out.println("<th>Prenom Auteur</th>");
    out.println("</tr>");
    for (int i = 0; i < livres.size(); i++) {
        out.println("<tr>");
        out.println("<td>" + livres.get(i).getTitre() + "</td>");
        out.println("<td>" + livres.get(i).getDescription() + "</td>");
        out.println("<td>" + livres.get(i).getDateEdition() + "</td>");
        out.println("<td>" + livres.get(i).getEditeur() + "</td>");

        out.println("<td>" + livres.get(i).getAuteur().getNom() + "</td>");
        out.println("<td>" + livres.get(i).getAuteur().getPrenom() + "</td>");
        out.println("</tr>");
    }

    out.println("</table>");
%>



</body>
</html>
