package dao;


import models.AU;
import java.util.List;

public interface AUDAO {
    void addAU(AU au) throws Exception;
    AU getAU(int id) throws Exception;
    List<AU> getAllAU() throws Exception;
    void updateAU(AU au) throws Exception;
    void deleteAU(int id) throws Exception;
}

