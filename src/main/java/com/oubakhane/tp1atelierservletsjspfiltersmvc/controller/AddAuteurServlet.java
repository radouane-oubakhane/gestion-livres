package com.oubakhane.tp1atelierservletsjspfiltersmvc.controller;

import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Genre;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.services.AuteurServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "AddAuteurServlet", urlPatterns = "/add-auteur-servlet")
public class AddAuteurServlet extends HttpServlet {
    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/view/addAuteur.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nom = request.getParameter("nom").trim();
        String prenom = request.getParameter("prenom").trim();
        String genre = request.getParameter("genre").trim();


        if (nom.isEmpty() || prenom.isEmpty() || genre.isEmpty()) {
            request.setAttribute("error", "Veuillez remplir tous les champs!");
            request.getRequestDispatcher("/view/addAuteur.jsp").forward(request, response);
        } else {
            AuteurServices.addAuteur(
                    nom,
                    prenom,
                    Genre.valueOf(genre
                    ));
            response.sendRedirect("dashboard-servlet");
        }
    }

    public void destroy() {

    }

}
