package daoimp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.SemestreDAO;
import models.Semestre;

public class SemestreDAOImpl implements SemestreDAO {
    private Connection con;

    public SemestreDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public void addSemestre(Semestre semestre) throws Exception {
        String query = "INSERT INTO Semestres (SemestreID, NomSemestre, NombreDeSemaines) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, semestre.getSemestreID());
            pstmt.setString(2, semestre.getNomSemestre());
            pstmt.setInt(3, semestre.getNombreDeSemaines());
            pstmt.executeUpdate();
        }
    }

    @Override
    public Semestre getSemestre(int semestreID) throws Exception {
        String query = "SELECT * FROM Semestres WHERE SemestreID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, semestreID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Semestre(rs.getInt("SemestreID"), rs.getString("NomSemestre"), rs.getInt("NombreDeSemaines"));
            }
        }
        return null;
    }

    @Override
    public List<Semestre> getAllSemestres() throws Exception {
        List<Semestre> semestres = new ArrayList<>();
        String query = "SELECT * FROM Semestres";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                semestres.add(new Semestre(rs.getInt("SemestreID"), rs.getString("NomSemestre"), rs.getInt("NombreDeSemaines")));
            }
        }
        return semestres;
    }

    @Override
    public void updateSemestre(Semestre semestre) throws Exception {
        String query = "UPDATE Semestres SET NomSemestre = ?, NombreDeSemaines = ? WHERE SemestreID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, semestre.getNomSemestre());
            pstmt.setInt(2, semestre.getNombreDeSemaines());
            pstmt.setInt(3, semestre.getSemestreID());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void deleteSemestre(int semestreID) throws Exception {
        String query = "DELETE FROM Semestres WHERE SemestreID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, semestreID);
            pstmt.executeUpdate();
        }
    }
}

