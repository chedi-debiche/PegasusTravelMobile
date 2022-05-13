/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author rahma
 */
public class Evenement {
    public int idevent ;
    public String nomevent ;
    public Float prixevent ;
    public String date ;

    public Evenement() {
    }

    public Evenement(int idevent, String nomevent, Float prixevent, String date) {
        this.idevent = idevent;
        this.nomevent = nomevent;
        this.prixevent = prixevent;
        this.date = date;
    }

    public Evenement(String nomevent, Float prixevent, String date) {
        this.nomevent = nomevent;
        this.prixevent = prixevent;
        this.date = date;
    }

    public int getIdevent() {
        return idevent;
    }

    public String getNomevent() {
        return nomevent;
    }

    public Float getPrixevent() {
        return prixevent;
    }

    public String getDate() {
        return date;
    }

    public void setIdevent(int idevent) {
        this.idevent = idevent;
    }

    public void setNomevent(String nomevent) {
        this.nomevent = nomevent;
    }

    public void setPrixevent(Float prixevent) {
        this.prixevent = prixevent;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Evenement{" + "idevent=" + idevent + ", nomevent=" + nomevent + ", prixevent=" + prixevent + ", date=" + date + '}';
    }

   
    
    
}
