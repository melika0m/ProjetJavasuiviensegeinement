package models;
public class Semestre {
    private int semestreID;
    private String nomSemestre;
    private int nombreDeSemaines;

    public Semestre() {
    }

    public Semestre(int semestreID, String nomSemestre, int nombreDeSemaines) {
        this.semestreID = semestreID;
        this.nomSemestre = nomSemestre;
        this.nombreDeSemaines = nombreDeSemaines;
    }

    // Getters et setters
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

    @Override
    public String toString() {
        return "Semestre{" +
                "semestreID=" + semestreID +
                ", nomSemestre='" + nomSemestre + '\'' +
                ", nombreDeSemaines=" + nombreDeSemaines +
                '}';
    }
}
