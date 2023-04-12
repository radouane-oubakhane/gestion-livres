package com.oubakhane.tp1atelierservletsjspfiltersmvc.controller;

import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Auteur;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.enums.Role;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.services.AuteurServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "dashboardAuteursServlet", value = "/dashboard-auteurs-servlet")
public class DashboardAuteursServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Role role = (Role) request.getSession().getAttribute("role");
        if (role == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else {
            List<Auteur> auteurs = AuteurServices.findAllAuteurs();
            request.setAttribute("auteurs", auteurs);
            request.getRequestDispatcher("/view/adminDashboardAuteur.jsp").forward(request, response);
        }
    }
}

