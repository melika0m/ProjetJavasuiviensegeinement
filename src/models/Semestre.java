package models;

public class Semestre {
    private int semestreID;
    private String nomSemestre;
    private int nombreDeSemaines;
//    private String anneeUniversitaire; // New field

    public Semestre() {
    }

    public Semestre(int semestreID, String nomSemestre, int nombreDeSemaines) {
        this.semestreID = semestreID;
        this.nomSemestre = nomSemestre;
        this.nombreDeSemaines = nombreDeSemaines;
//        this.anneeUniversitaire = anneeUniversitaire; // Initialize the new field
    }

    // Getters and setters
    public int getSemestreID() {
        return semestreID;
    }

    public void setSemestreID(int semestreID) {
        this.semestreID = semestreID;
    }

    public String getNomSemestre() {
        return nomSemestre;
    }

    public void setNomSemestre(String nomSemestre) {
        this.nomSemestre = nomSemestre;
    }

    public int getNombreDeSemaines() {
        return nombreDeSemaines;
    }

    public void setNombreDeSemaines(int nombreDeSemaines) {
        this.nombreDeSemaines = nombreDeSemaines;
    }

//    public String getAnneeUniversitaire() { // Getter for the new field
//        return anneeUniversitaire;
//    }
//
//    public void setAnneeUniversitaire(String anneeUniversitaire) { // Setter for the new field
//        this.anneeUniversitaire = anneeUniversitaire;
//    }

    @Override
    public String toString() {
        return "Semestre{" +
                "semestreID=" + semestreID +
                ", nomSemestre='" + nomSemestre + '\'' +
                ", nombreDeSemaines=" + nombreDeSemaines +
               // Include the new field in toString
                '}';
    }
}
