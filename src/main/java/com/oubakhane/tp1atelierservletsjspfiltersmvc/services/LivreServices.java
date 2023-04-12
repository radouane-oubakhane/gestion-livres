package com.oubakhane.tp1atelierservletsjspfiltersmvc.services;

import com.oubakhane.tp1atelierservletsjspfiltersmvc.dao.LivreDoa;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Auteur;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.enums.Editeur;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Livre;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Date;
import java.util.List;

public class LivreServices {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public static List<Livre> findAllLivresWithAuteur() {
        LivreDoa livreDoa = new LivreDoa(emf);
        return livreDoa.findAll();
    }

    public static List<Livre> findLivresBy(String search, String searchType) {
        LivreDoa livreDoa = new LivreDoa(emf);
        if (searchType.equals("titre") && !search.isEmpty())
            return livreDoa.findByTitre(search);
        else if (searchType.equals("auteur") && !search.isEmpty()) {
            return livreDoa.findByAuteur(search);
        }
        else
            return livreDoa.findAll();
    }

    public static void deleteLivre(int id) {
        LivreDoa livreDoa = new LivreDoa(emf);
        livreDoa.delete(livreDoa.find(id));
    }

    public static void editLivre(Livre livre) {
        LivreDoa livreDoa = new LivreDoa(emf);
        livreDoa.update(livre);
    }

    public static void addLivre(Livre livre) {
        LivreDoa livreDoa = new LivreDoa(emf);
        livreDoa.add(livre);
    }

    public static void addLivre(String titre, String description, Date dateEdition, Editeur editeur, int matricule) {
        LivreDoa livreDoa = new LivreDoa(emf);
        Auteur auteur = AuteurServices.findAuteur(matricule);
        livreDoa.add(new Livre(titre, description, dateEdition, editeur, auteur));
    }

    public static Livre findLivre(int id) {
        LivreDoa livreDoa = new LivreDoa(emf);
        return (Livre) livreDoa.find(id);
    }

    public static void editLivre(int id, String titre, String description, Date dateEdition, Editeur editeur, int matricule) {
        LivreDoa livreDoa = new LivreDoa(emf);
        Auteur auteur = AuteurServices.findAuteur(matricule);
        Livre livre = (Livre) livreDoa.find(id);
        livre.setTitre(titre);
        livre.setDescription(description);
        livre.setDateEdition(dateEdition);
        livre.setEditeur(editeur);
        livre.setAuteur(auteur);
        livreDoa.update(livre);
    }
}
