package models;

import java.sql.Date;

public class AvancementCours {
    private int avancementID;
    private int coursID;
    private int heuresDonnees;
    private Date date; // Utilisez java.sql.Date pour les champs de date dans JDBC
    
    public AvancementCours() {}
    
    public AvancementCours(int avancementID, int coursID, int heuresDonnees, Date date) {
        this.avancementID = avancementID;
        this.coursID = coursID;
        this.heuresDonnees = heuresDonnees;
        this.date = date;
    }
    
    public int getAvancementID() {
        return avancementID;
    }
    
    public void setAvancementID(int avancementID) {
        this.avancementID = avancementID;
    }
    
    public int getCoursID() {
        return coursID;
    }
    
    public void setCoursID(int coursID) {
        this.coursID = coursID;
    }
    
    public int getHeuresDonnees() {
        return heuresDonnees;
    }
    
    public void setHeuresDonnees(int heuresDonnees) {
        this.heuresDonnees = heuresDonnees;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
}
