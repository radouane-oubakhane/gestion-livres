package com.oubakhane.tp1atelierservletsjspfiltersmvc.services;

import com.oubakhane.tp1atelierservletsjspfiltersmvc.dao.AuteurDoa;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Auteur;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AuteurServices {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public static void addAuteur(String nom, String prenom, String email, String telephone) {
        AuteurDoa auteurDoa = new AuteurDoa(emf);
        Auteur auteur = new Auteur(nom, prenom, email, telephone);
        auteurDoa.create(auteur);
    }

    public static void deleteAuteur(int id) {
        AuteurDoa auteurDoa = new AuteurDoa(emf);
        auteurDoa.delete(auteurDoa.find(id));
    }

    public static void updateAuteur(int id, String nom, String prenom, String email, String telephone) {
        AuteurDoa auteurDoa = new AuteurDoa(emf);
        Auteur auteur = (Auteur) auteurDoa.find(id);
        auteur.setNom(nom);
        auteur.setPrenom(prenom);

        auteurDoa.update(auteur);
    }

    public static Auteur findAuteur(int id) {
        AuteurDoa auteurDoa = new AuteurDoa(emf);
        return (Auteur) auteurDoa.find(id);
    }

    public static List<Auteur> findAllAuteurs() {
        AuteurDoa auteurDoa = new AuteurDoa(emf);
        return auteurDoa.findAll();
    }



}
