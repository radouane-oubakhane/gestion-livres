package com.oubakhane.tp1atelierservletsjspfiltersmvc.controller;

import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Auteur;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Livre;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.enums.Role;
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
        Role role = (Role) request.getSession().getAttribute("role");
        if (role == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }else {
            List<Livre> livres = LivreServices.findAllLivresWithAuteur();
            request.setAttribute("livres", livres);

            if (role.equals(Role.admin)) {
                request.getRequestDispatcher("/view/adminDashboard.jsp").forward(request, response);
            } else if (role.equals(Role.visiteur)) {
                request.getRequestDispatcher("/view/visiteurDashboard.jsp").forward(request, response);
            }
        }
    }
}
