package com.oubakhane.tp1atelierservletsjspfiltersmvc.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebFilter(urlPatterns = {
        "/dashboard-servlet",
        "/add-livre-servlet",
        "/delete-livre-servlet",
        "/edit-livre-servlet",
        "/dashboard-auteurs-servlet",
        "/add-auteur-servlet",
        "/delete-auteur-servlet",
        "/edit-auteur-servlet",
        "/search-servlet"
})

public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);
        if (session == null || session.getAttribute("login") == null) {
            servletRequest.getRequestDispatcher("index.jsp").forward(servletRequest, servletResponse);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }


}
