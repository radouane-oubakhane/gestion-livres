package com.oubakhane.tp1atelierservletsjspfiltersmvc.services;

import com.oubakhane.tp1atelierservletsjspfiltersmvc.dao.UserDoa;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Role;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.User;

public class Authentification {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    public static boolean authentification(String login, String password) {
        UserDoa userDoa = new UserDoa(emf);
        User currentUser = (User) userDoa.find(login);
        return currentUser.getPassword().equals(password);
    }

    public static Role getRole(String login) {
        UserDoa userDoa = new UserDoa(emf);
        User currentUser = (User) userDoa.find(login);
        System.out.println("===================================="+currentUser);

        return currentUser.getRole();
    }
}
