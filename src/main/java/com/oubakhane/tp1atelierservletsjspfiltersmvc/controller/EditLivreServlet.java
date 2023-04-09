package com.oubakhane.tp1atelierservletsjspfiltersmvc.controller;

import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Auteur;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Editeur;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Livre;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.services.LivreServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.oubakhane.tp1atelierservletsjspfiltersmvc.services.AuteurServices;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "editServlet", value = "/edit-livre-servlet")
public class EditLivreServlet extends HttpServlet {
    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        Livre livre = LivreServices.findLivre(Integer.parseInt(id));
        request.setAttribute("livre", livre);
        List<Auteur> auteurs = AuteurServices.findAllAuteurs();
        request.setAttribute("auteurs", auteurs);
        request.getRequestDispatcher("/view/editLivre.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String isbn = request.getParameter("isbn");
        String titre = request.getParameter("titre");
        String description = request.getParameter("description");
        String dateEdition = request.getParameter("dateEdition");
        String editeur = request.getParameter("editeur");
        String matricule = request.getParameter("matricule");

        if (titre.isEmpty() || description.isEmpty() || dateEdition.isEmpty() || editeur.isEmpty() || matricule.isEmpty()) {
            request.setAttribute("error", "Veuillez remplir tous les champs!");
            request.getRequestDispatcher("/view/editLivre.jsp").forward(request, response);
        } else {
            LivreServices.editLivre(
                    Integer.parseInt(isbn),
                    titre,
                    description,
                    Date.valueOf(dateEdition),
                    Editeur.valueOf(editeur),
                    Integer.parseInt(matricule)
            );
            response.sendRedirect("dashboard-servlet");

        }
    }

    public void destroy() {

    }
}
