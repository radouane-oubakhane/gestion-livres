package com.oubakhane.tp1atelierservletsjspfiltersmvc.filter;


import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.enums.Role;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.services.Authentification;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebFilter(urlPatterns = {
        "/add-livre-servlet",
        "/delete-livre-servlet",
        "/edit-livre-servlet",
        "/dashboard-auteurs-servlet",
        "/add-auteur-servlet",
        "/delete-auteur-servlet",
        "/edit-auteur-servlet"
})
public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);
        if (session == null || session.getAttribute("login") == null) {
            servletRequest.getRequestDispatcher("index.jsp").forward(servletRequest, servletResponse);
        } else {
            String login = (String) session.getAttribute("login");
            Role role = Authentification.getRole(login);
            if (role.equals(Role.visiteur)) {
                servletRequest.getRequestDispatcher("dashboard-servlet").forward(servletRequest, servletResponse);
            } else if (role.equals(Role.admin)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                servletRequest.getRequestDispatcher("index.jsp").forward(servletRequest, servletResponse);
            }

        }

    }
}