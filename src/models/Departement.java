package models;

public class Departement {
    private int departmentID;
    private String departmentName;
    
    public Departement() {}
    
    public Departement(int departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }
    
    public int getDepartmentID() {
        return departmentID;
    }
    
    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }
    
    public String getDepartmentName() {
        return departmentName;
    }
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}

