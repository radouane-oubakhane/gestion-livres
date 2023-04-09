package com.oubakhane.tp1atelierservletsjspfiltersmvc.controller;

import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Role;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.services.Authentification;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;
import java.io.*;




@WebServlet(name = "authentificationServlet", value = "/authentification-servlet")
public class AuthentificationServlet extends HttpServlet {
    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().invalidate();
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login").trim();
        String password = request.getParameter("password").trim();

        boolean isAuth = Authentification.authentification(login, password);

        if (isAuth) {
            Role role = Authentification.getRole(login);
            HttpSession session = request.getSession(true);
            session.setAttribute("login", login);
            session.setAttribute("role", role);

            response.sendRedirect("dashboard-servlet");

        } else {
            request.setAttribute("error", "Login ou mot de passe incorrect!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }


}
