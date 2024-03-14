package models;


public class AU {
    private int id;
    private String annee;

    public AU() {
    }

    public AU(int id, String annee) {
        this.id = id;
        this.annee = annee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    @Override
    public String toString() {
        return "AU{" +
                "id=" + id +
                ", annee='" + annee + '\'' +
                '}';
    }
}

