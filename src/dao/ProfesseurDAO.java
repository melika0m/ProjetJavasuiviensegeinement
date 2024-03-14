package dao;

import models.Professeur;
import java.sql.SQLException;
import java.util.List;

public interface ProfesseurDAO {
    void addProfesseur(Professeur professeur) throws SQLException;
    int addProfesseurAndGetId(Professeur professeur) throws SQLException; // New method
    Professeur getProfesseur(int professeurID) throws SQLException;
    List<Professeur> getAllProfesseurs() throws SQLException;
    void updateProfesseur(Professeur professeur) throws SQLException;
    void deleteProfesseur(int professeurID) throws SQLException;
}
