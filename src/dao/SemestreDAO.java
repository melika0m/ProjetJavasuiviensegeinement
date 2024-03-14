package dao;

import models.Semestre;

import java.sql.SQLException;
import java.util.List;

public interface SemestreDAO {
    int addSemestreAndGetID(Semestre semestre) throws Exception; // Adjusted to return int
    Semestre getSemestre(int semestreID) throws Exception;
    List<Semestre> getAllSemestres() throws Exception;
    void updateSemestre(Semestre semestre) throws Exception;
    void deleteSemestre(int semestreID) throws Exception;
    List<Semestre> getSemestresByAnneeUniversitaire(String anneeUniversitaire) throws Exception;
	List<String> getAllAnneeUniversitaire() throws SQLException;
    
}
