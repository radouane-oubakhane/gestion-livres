package com.oubakhane.tp1atelierservletsjspfiltersmvc.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "LIVRE")
public class Livre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ISBN")
    private int ISBN;

    @Column(name = "titre")
    private String titre;

    @Column(name = "description")
    private String description;

    @Column(name = "date_edition")
    private Date dateEdition;

    @Enumerated(EnumType.STRING)
    @Column(name = "editeur")
    private Editeur editeur;

    @ManyToOne
    @JoinColumn(name = "matricule")
    private Auteur auteur;

    public Livre() {
    }

    public Livre(String titre, String description, Date dateEdition, Editeur editeur, Auteur auteur) {
        this.titre = titre;
        this.description = description;
        this.dateEdition = dateEdition;
        this.editeur = editeur;
        this.auteur = auteur;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(Date dateEdition) {
        this.dateEdition = dateEdition;
    }

    public Editeur getEditeur() {
        return editeur;
    }

    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "ISBN=" + ISBN +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", dateEdition=" + dateEdition +
                ", editeur=" + editeur +
                ", auteur=" + auteur +
                '}';
    }
}

