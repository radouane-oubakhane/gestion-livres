package com.oubakhane.tp1atelierservletsjspfiltersmvc.controller;

import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Editeur;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.services.AuteurServices;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.services.LivreServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;


@WebServlet(name = "addServlet", value = "/add-livre-servlet")
public class AddLivreServlet extends HttpServlet {
    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("auteurs", AuteurServices.findAllAuteurs());
        request.getRequestDispatcher("/view/addLivre.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String titre = request.getParameter("titre").trim();
        String description = request.getParameter("description").trim();
        String dateEdition = request.getParameter("dateEdition").trim();
        String editeur = request.getParameter("editeur").trim();
        String matricule = request.getParameter("matricule").trim();


        if (titre.isEmpty() || description.isEmpty() || dateEdition.isEmpty() || editeur.isEmpty() || matricule.isEmpty()) {
            request.setAttribute("error", "Veuillez remplir tous les champs!");
            request.getRequestDispatcher("/view/addLivre.jsp").forward(request, response);
        } else {

            LivreServices.addLivre(
                    titre,
                    description,
                    Date.valueOf(dateEdition),
                    Editeur.valueOf(editeur),
                    Integer.parseInt(matricule
                    ));
            response.sendRedirect("dashboard-servlet");
        }
    }

    public void destroy() {

    }
}
