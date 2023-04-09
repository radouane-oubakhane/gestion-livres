package com.oubakhane.tp1atelierservletsjspfiltersmvc.services;

import com.oubakhane.tp1atelierservletsjspfiltersmvc.dao.LivreDoa;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Livre;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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
        else if (searchType.equals("auteur") && !search.isEmpty())
            return livreDoa.findByAuteur(search);
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

}
