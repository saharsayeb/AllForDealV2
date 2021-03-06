/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import dao.ReclamationDao;
import java.util.Date;

/**
 *
 * @author SaharS
 */
public class Reclamation {
     private int id_reclamation;
    private Date date;
    private String description;
    private String sujet;
   // private User client;

    public Reclamation() {
    }

    public Reclamation(Date date, String description, String sujet) {
        this.date = date;
        this.description = description;
        this.sujet = sujet;
    }
    

    public Reclamation(int id_reclamation, Date date, String description, String sujet) {
        this.id_reclamation = id_reclamation;
        this.date = date;
        this.description = description;
        this.sujet = sujet;
    }
    
    
    

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    @Override
    public String toString() {
        return "ReclamationDao{" + "id_reclamation=" + id_reclamation + ", date=" + date + ", description=" + description + ", sujet=" + sujet + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id_reclamation;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reclamation other = (Reclamation) obj;
        if (this.id_reclamation != other.id_reclamation) {
            return false;
        }
        return true;
    }

  

}
