package models;

public class Matiere {
    private int matiereID;
    private String nomMatiere;
    private int coursID;

    public Matiere(int matiereID, String nomMatiere, int coursID) {
        this.matiereID = matiereID;
        this.nomMatiere = nomMatiere;
        this.coursID = coursID;
    }

    public int getMatiereID() {
        return matiereID;
    }

    public void setMatiereID(int matiereID) {
        this.matiereID = matiereID;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public int getCoursID() {
        return coursID;
    }

    public void setCoursID(int coursID) {
        this.coursID = coursID;
    }
}
