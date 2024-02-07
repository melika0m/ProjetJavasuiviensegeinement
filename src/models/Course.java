package models;

public class Course {
    private int coursID;
    private String nomCours;
    private String codeCours;
    private int professeurID;
    private int heuresParSemaine;
    private String semestre;
    private int volumeHoraireTotal;
    
    public Course() {}
    
    public Course(int coursID, String nomCours, String codeCours, int professeurID, int heuresParSemaine, String semestre, int volumeHoraireTotal) {
        this.coursID = coursID;
        this.nomCours = nomCours;
        this.codeCours = codeCours;
        this.professeurID = professeurID;
        this.heuresParSemaine = heuresParSemaine;
        this.semestre = semestre;
        this.volumeHoraireTotal = volumeHoraireTotal;
    }
    
    public int getCoursID() {
        return coursID;
    }
    
    public void setCoursID(int coursID) {
        this.coursID = coursID;
    }
    
    public String getNomCours() {
        return nomCours;
    }
    
    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }
    
    public String getCodeCours() {
        return codeCours;
    }
    
    public void setCodeCours(String codeCours) {
        this.codeCours = codeCours;
    }
    
    public int getProfesseurID() {
        return professeurID;
    }
    
    public void setProfesseurID(int professeurID) {
        this.professeurID = professeurID;
    }
    
    public int getHeuresParSemaine() {
        return heuresParSemaine;
    }
    
    public void setHeuresParSemaine(int heuresParSemaine) {
        this.heuresParSemaine = heuresParSemaine;
    }
    
    public String getSemestre() {
        return semestre;
    }
    
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    
    public int getVolumeHoraireTotal() {
        return volumeHoraireTotal;
    }
    
    public void setVolumeHoraireTotal(int volumeHoraireTotal) {
        this.volumeHoraireTotal = volumeHoraireTotal;
    }
}
