package dao;

import java.util.List;

import models.Semestre;

public interface SemestreDAO {
    void addSemestre(Semestre semestre) throws Exception;
    Semestre getSemestre(int semestreID) throws Exception;
    List<Semestre> getAllSemestres() throws Exception;
    void updateSemestre(Semestre semestre) throws Exception;
    void deleteSemestre(int semestreID) throws Exception;
}

