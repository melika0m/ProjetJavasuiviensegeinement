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
    public int addSemestreAndGetID(Semestre semestre) throws SQLException {
        String sql = "INSERT INTO Semestres (NomSemestre, NombreDeSemaines) VALUES (?, ?)";
        int generatedId = 0;

        try (PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, semestre.getNomSemestre());
            pstmt.setInt(2, semestre.getNombreDeSemaines());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating semestre failed, no ID obtained.");
                }
            }
        }
        return generatedId;
    }

    @Override
    public Semestre getSemestre(int semestreID) throws Exception {
        String query = "SELECT * FROM Semestres WHERE SemestreID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, semestreID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Semestre(
                        rs.getInt("SemestreID"),
                        rs.getString("NomSemestre"),
                        rs.getInt("NombreDeSemaines")
                    );
                }
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
                semestres.add(new Semestre(
                    rs.getInt("SemestreID"),
                    rs.getString("NomSemestre"),
                    rs.getInt("NombreDeSemaines")
                ));
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

    // Since AnneeUniversitaire is removed, methods related to it are either removed or commented out.
    @Override
    public List<Semestre> getSemestresByAnneeUniversitaire(String anneeUniversitaire) throws Exception {
        // This method is no longer applicable.
        throw new UnsupportedOperationException("Operation is not supported after removal of AnneeUniversitaire.");
    }

    @Override
    public List<String> getAllAnneeUniversitaire() throws SQLException {
        // This method is no longer applicable.
        throw new UnsupportedOperationException("Operation is not supported after removal of AnneeUniversitaire.");
    }
}
