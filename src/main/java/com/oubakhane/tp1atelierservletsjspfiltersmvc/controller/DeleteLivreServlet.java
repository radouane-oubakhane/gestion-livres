package com.oubakhane.tp1atelierservletsjspfiltersmvc.controller;

import com.oubakhane.tp1atelierservletsjspfiltersmvc.services.LivreServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "deleteServlet", value = "/delete-livre-servlet")
public class DeleteLivreServlet extends HttpServlet {
    public void init() {}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id").trim();
        LivreServices.deleteLivre(Integer.parseInt(id));
        response.sendRedirect("dashboard-servlet");

    }

    public void destroy() {

    }


}
