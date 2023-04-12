package com.oubakhane.tp1atelierservletsjspfiltersmvc.services;

import com.oubakhane.tp1atelierservletsjspfiltersmvc.dao.AuteurDoa;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Auteur;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.enums.Genre;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AuteurServices {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public static void addAuteur(String nom, String prenom, Genre genre) {
        AuteurDoa auteurDoa = new AuteurDoa(emf);
        Auteur auteur = new Auteur(nom, prenom, genre);
        auteurDoa.add(auteur);
    }

    public static void deleteAuteur(int id) {
        AuteurDoa auteurDoa = new AuteurDoa(emf);
        auteurDoa.delete(auteurDoa.find(id));
    }

    public static void updateAuteur(int matricule, String nom, String prenom, Genre genre) {
        AuteurDoa auteurDoa = new AuteurDoa(emf);
        Auteur auteur = (Auteur) auteurDoa.find(matricule);
        auteur.setNom(nom);
        auteur.setPrenom(prenom);
        auteur.setGenre(genre);

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
