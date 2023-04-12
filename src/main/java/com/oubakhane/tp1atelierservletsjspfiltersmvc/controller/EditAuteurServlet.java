package com.oubakhane.tp1atelierservletsjspfiltersmvc.controller;

import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Auteur;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.enums.Genre;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.services.AuteurServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "editAuteurServlet", value = "/edit-auteur-servlet")
public class EditAuteurServlet extends HttpServlet {
    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String matricule = request.getParameter("matricule");
        Auteur auteur = AuteurServices.findAuteur(Integer.parseInt(matricule));
        request.setAttribute("auteur", auteur);
        request.getRequestDispatcher("/view/editAuteur.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String matricule = request.getParameter("matricule");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String genre = request.getParameter("genre");

        if (matricule.isEmpty() || nom.isEmpty() || prenom.isEmpty() || genre.isEmpty()) {
            request.setAttribute("error", "Veuillez remplir tous les champs!");
            request.getRequestDispatcher("/view/editAuteur.jsp").forward(request, response);
        } else {
            AuteurServices.updateAuteur(
                    Integer.parseInt(matricule),
                    nom,
                    prenom,
                    Genre.valueOf(genre)
            );
            List<Auteur> auteurs = AuteurServices.findAllAuteurs();
            request.setAttribute("auteurs", auteurs);
            request.getRequestDispatcher("/view/adminDashboardAuteur.jsp").forward(request, response);

        }
    }

    public void destroy() {

    }
}
