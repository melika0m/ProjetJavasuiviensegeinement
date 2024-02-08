package dao;

import java.sql.SQLException;
import java.util.List;

import models.Professeur;

public interface ProfesseurDAO {
    void addProfesseur(Professeur professeur) throws SQLException;
    Professeur getProfesseur(int professeurID) throws SQLException;
    List<Professeur> getAllProfesseurs() throws SQLException;
    void updateProfesseur(Professeur professeur) throws SQLException;
    void deleteProfesseur(int professeurID) throws SQLException;
}
