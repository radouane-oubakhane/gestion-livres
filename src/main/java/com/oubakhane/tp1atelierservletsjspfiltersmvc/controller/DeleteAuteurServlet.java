package com.oubakhane.tp1atelierservletsjspfiltersmvc.controller;

import com.oubakhane.tp1atelierservletsjspfiltersmvc.services.AuteurServices;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import jakarta.servlet.ServletException;


@WebServlet(name = "deleteAuteurServlet", value = "/delete-auteur-servlet")
public class DeleteAuteurServlet extends HttpServlet {
    public void init() {}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String matricule = request.getParameter("matricule").trim();
        AuteurServices.deleteAuteur(Integer.parseInt(matricule));
        response.sendRedirect("dashboard-servlet");
    }

    public void destroy() {

    }

}
