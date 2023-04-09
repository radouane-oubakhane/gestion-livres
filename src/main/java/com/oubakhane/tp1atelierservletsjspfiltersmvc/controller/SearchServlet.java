package com.oubakhane.tp1atelierservletsjspfiltersmvc.controller;

import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Role;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.services.Authentification;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.services.LivreServices;
import jakarta.servlet.annotation.WebServlet;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Livre;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "searchServlet", value = "/search-servlet")
public class SearchServlet extends HttpServlet {
    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String search = request.getParameter("search").trim();
        String searchType = request.getParameter("searchType").trim();
        List<Livre> livres = LivreServices.findLivresBy(search, searchType);
        request.setAttribute("livres", livres);


        Role role = (Role) request.getSession().getAttribute("role");

        System.out.println("==============Role======"+request.getSession().getAttribute("role"));

        if (role.equals(Role.admin)) {
            request.getRequestDispatcher("/view/admin.jsp").forward(request, response);
        } else if (role.equals(Role.visiteur)) {
            request.getRequestDispatcher("/view/visiteur.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }


}
