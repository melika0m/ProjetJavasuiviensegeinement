package models;

public class Professeur {
    private int professeurID;
    private String nom;
    private String prenom;
    private String email;
    private int departementID;
    
    public Professeur() {}
    
    public Professeur(int professeurID, String nom, String prenom, String email, int departementID) {
        this.professeurID = professeurID;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.departementID = departementID;
    }
    
    public int getProfesseurID() {
        return professeurID;
    }
    
    public void setProfesseurID(int professeurID) {
        this.professeurID = professeurID;
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
    
    public int getDepartementID() {
        return departementID;
    }
    
    public void setDepartementID(int departementID) {
        this.departementID = departementID;
    }
}

