package models;

public class Professeur {
    private int professeurID; // Auto-incremented
    private String nom;
    private String prenom;
    private String email;
    private int departementID;
    private String status; // New field

   
   

    // Full constructor including professeurID for fetched records
//    public Professeur(int id, String nom, String prenom, String email, int departementID, String status) {
//        this.professeurID = professeurID;
//        this.nom = nom;
//        this.prenom = prenom;
//        this.email = email;
//        this.departementID = departementID;
//        this.status = status;
//    }
    public Professeur(int id, String nom, String prenom, String email, int departementID, String status) {
        this.professeurID = id; // Corrected to use the parameter 'id'
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.departementID = departementID;
        this.status = status;
    }


    // Getters and Setters
    // Include getters and setters for all fields

 

   
    

	public Professeur() {
		// TODO Auto-generated constructor stub
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
    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Professeur{" +
                "professeurID=" + professeurID +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", departementID=" + departementID +
                ", status='" + status + '\'' +
                '}';
    }

}

