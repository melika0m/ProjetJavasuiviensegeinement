package dao;

import models.AvancementCours;
import java.util.List;

public interface AvancementCoursDAO {
    void addAvancement(AvancementCours avancement) throws Exception;
    AvancementCours getAvancement(int avancementID) throws Exception;
    List<AvancementCours> getAllAvancements() throws Exception;
    void updateAvancement(AvancementCours avancement) throws Exception;
    void deleteAvancement(int avancementID) throws Exception;
}
