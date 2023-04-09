package com.oubakhane.tp1atelierservletsjspfiltersmvc.controller;

import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Auteur;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Livre;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Role;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.services.AuteurServices;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.services.LivreServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "dashboardServlet", value = "/dashboard-servlet")
public class DashboardServlet extends HttpServlet {
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Livre> livres = LivreServices.findAllLivresWithAuteur();
        request.setAttribute("livres", livres);
        List<Auteur> auteurs = AuteurServices.findAllAuteurs();
        request.setAttribute("auteurs", auteurs);
        Role role = (Role) request.getSession().getAttribute("role");
        if (role == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }else if (role.equals(Role.admin)) {
            request.getRequestDispatcher("/view/admin.jsp").forward(request, response);
        } else if (role.equals(Role.visiteur)) {
            request.getRequestDispatcher("/view/visiteur.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String titre = request.getParameter("titre").trim();
        String description = request.getParameter("description").trim();
        String dateEdition = request.getParameter("dateEdition").trim();
        String editeur = request.getParameter("editeur").trim();
        String matricule = request.getParameter("matricule").trim();
    }
}
