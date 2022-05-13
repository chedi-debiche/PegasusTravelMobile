/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author 21695
 */
public class Reclamation {
     private int numero;
    private String nom;
    private String prenom;
    private String email;
    private String commentaire;
    private String datereclamation;
    private String typereclamation;
    private int id;

    public Reclamation() {
    }

    public Reclamation(int numero, String nom, String prenom, String email, String commentaire, String datereclamation, String typereclamation, int id) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.commentaire = commentaire;
        this.datereclamation = datereclamation;
        this.typereclamation = typereclamation;
        this.id = id;
    }

    public Reclamation(String nom, String prenom, String email, String commentaire, String datereclamation, String typereclamation) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.commentaire = commentaire;
        this.datereclamation = datereclamation;
        this.typereclamation = typereclamation;
    }

    public Reclamation(String nom, String prenom, String email, String commentaire, String datereclamation, String typereclamation, int id) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.commentaire = commentaire;
        this.datereclamation = datereclamation;
        this.typereclamation = typereclamation;
        this.id = id;
    }



    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getDatereclamation() {
        return datereclamation;
    }

    public void setDatereclamation(String datereclamation) {
        this.datereclamation = datereclamation;
    }

    public String getTypereclamation() {
        return typereclamation;
    }

    public void setTypereclamation(String typereclamation) {
        this.typereclamation = typereclamation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", commentaire=" + commentaire + ", datereclamation=" + datereclamation + ", typereclamation=" + typereclamation + ", id=" + id + '}';
    }

    public Reclamation(int numero, String nom, String prenom, String email, String commentaire, String datereclamation, String typereclamation) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.commentaire = commentaire;
        this.datereclamation = datereclamation;
        this.typereclamation = typereclamation;
    }
    
}
