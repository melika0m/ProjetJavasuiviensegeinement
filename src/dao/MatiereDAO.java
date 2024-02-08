package dao;

import models.Matiere;
import java.util.List;

public interface MatiereDAO {
    void addMatiere(Matiere matiere) throws Exception;
    Matiere getMatiere(int matiereID) throws Exception;
    List<Matiere> getAllMatieres() throws Exception;
    void updateMatiere(Matiere matiere) throws Exception;
    void deleteMatiere(int matiereID) throws Exception;
}

