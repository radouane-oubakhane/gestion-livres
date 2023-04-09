package com.oubakhane.tp1atelierservletsjspfiltersmvc.dao;

import com.oubakhane.tp1atelierservletsjspfiltersmvc.model.Auteur;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.awt.geom.QuadCurve2D;
import java.util.List;

public class AuteurDoa implements Dao {
    private final EntityManagerFactory emf;

    public AuteurDoa(EntityManagerFactory emf) {
        this.emf = emf;
    }
    @Override
    public void add(Object o) {
        Auteur auteur = (Auteur) o;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(auteur);
        em.getTransaction().commit();
    }

    @Override
    public void update(Object o) {
        Auteur auteur = (Auteur) o;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(auteur);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Object o) {
        Auteur auteur = (Auteur) o;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(auteur);
        em.getTransaction().commit();
    }

    @Override
    public Object find(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Auteur.class, id);
    }

    @Override
    public List findAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT auteur FROM Auteur As auteur", Auteur.class);
        return query.getResultList();
    }
}
