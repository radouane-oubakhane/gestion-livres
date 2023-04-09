package com.oubakhane.tp1atelierservletsjspfiltersmvc.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Livre;
import jakarta.persistence.Query;


public class LivreDoa implements Dao {
    private final EntityManagerFactory emf;

    public LivreDoa(EntityManagerFactory emf) {
        this.emf = emf;
    }
    @Override
    public void add(Object o) {
        Livre livre = (Livre) o;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(livre);
        em.getTransaction().commit();
    }

    @Override
    public void update(Object o) {
        Livre livre = (Livre) o;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(livre);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Object o) {
        EntityManager em = emf.createEntityManager();
        Livre livre = (Livre) o;
        em.getTransaction().begin();
        em.remove(em.contains(livre) ? livre : em.merge(livre));
        em.getTransaction().commit();
    }

    @Override
    public Object find(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Livre.class, id);
    }

    @Override
    public List findAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT livre FROM Livre As livre", Livre.class);
        return query.getResultList();
    }

    public List findByTitre(String titre) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT livre FROM Livre As livre WHERE livre.titre LIKE :titre", Livre.class);
        query.setParameter("titre", titre);
        return query.getResultList();
    }

    public List findByAuteur(String auteur) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT livre FROM Livre As livre WHERE livre.auteur.prenom LIKE :auteur", Livre.class);
        query.setParameter("auteur", auteur);
        return query.getResultList();
    }
}