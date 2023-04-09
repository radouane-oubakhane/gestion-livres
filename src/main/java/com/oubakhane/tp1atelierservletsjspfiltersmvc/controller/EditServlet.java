package com.oubakhane.tp1atelierservletsjspfiltersmvc.controller;

import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Auteur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.oubakhane.tp1atelierservletsjspfiltersmvc.services.AuteurServices;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "editServlet", value = "/edit-servlet")
public class EditServlet extends HttpServlet {
    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        List<Auteur> auteurs = AuteurServices.findAllAuteurs();
        request.setAttribute("auteurs", auteurs);
        request.getRequestDispatcher("/view/editLivre.jsp").forward(request, response);
    }

    public void destroy() {

    }
}
