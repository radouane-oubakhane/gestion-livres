package com.oubakhane.tp1atelierservletsjspfiltersmvc.services;

import com.oubakhane.tp1atelierservletsjspfiltersmvc.dao.UserDoa;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Role;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Authentification {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    public static boolean authentification(String login, String password) {
        Pattern emailPattern = Pattern.compile(
                "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$"
        );

        Matcher emailMatcher = emailPattern.matcher(login);
        if (emailMatcher.matches()) {
            UserDoa userDoa = new UserDoa(emf);
            User currentUser = (User) userDoa.find(login);
            return currentUser.getPassword().equals(password);
        }
        return false;
    }

    public static Role getRole(String login) {
        UserDoa userDoa = new UserDoa(emf);
        User currentUser = (User) userDoa.find(login);
        return currentUser.getRole();
    }
}
