package com.oubakhane.tp1atelierservletsjspfiltersmvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "deleteServlet", value = "/delete-servlet")
public class DeleteServlet extends HttpServlet {
    public void init() {}

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");


        request.getRequestDispatcher("index.jsp").forward(request, response);


    }

    public void destroy() {

    }


}
