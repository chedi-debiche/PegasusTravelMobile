/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author CC
 */
public class Maison {
     private int idMaison;
    private String nom,localisation,description,imageMaison;
    private float prix;

    public Maison() {
    }

    public Maison(int idMaison, String nom, String localisation, String description,float prix, String imageMaison) {
        this.idMaison = idMaison;
        this.nom = nom;
        this.localisation = localisation;
        this.description = description;
        this.prix = prix;
        this.imageMaison = imageMaison;

    }

    public Maison(String nom, String localisation, String description,float prix ,String imageMaison) {
        this.nom = nom;
        this.localisation = localisation;
        this.description = description;
        this.prix = prix;
        this.imageMaison = imageMaison;
    }

    public int getIdMaison() {
        return idMaison;
    }

    public String getNom() {
        return nom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public String getDescription() {
        return description;
    }

    public String getImageMaison() {
        return imageMaison;
    }

    public float getPrix() {
        return prix;
    }

    public void setIdMaison(int idMaison) {
        this.idMaison = idMaison;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageMaison(String imageMaison) {
        this.imageMaison = imageMaison;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

   

   
    
    
    
}
