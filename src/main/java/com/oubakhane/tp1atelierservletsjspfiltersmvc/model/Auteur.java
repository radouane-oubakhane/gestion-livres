package com.oubakhane.tp1atelierservletsjspfiltersmvc.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "AUTEUR")
public class Auteur implements Serializable {
    @Id
    @Column(name = "matricule")
    private int matricule;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @OneToMany(mappedBy = "auteur")
    private List<Livre> livres = new ArrayList<>();

    // getters and setters


    public Auteur(int matricule, String nom, String prenom, Genre genre, List<Livre> livres) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.livres = livres;
    }

    public Auteur() {
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }
}


