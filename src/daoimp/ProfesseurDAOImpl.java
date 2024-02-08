package daoimp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.ProfesseurDAO;
import models.Professeur;

public class ProfesseurDAOImpl implements ProfesseurDAO {
    private Connection con;

    public ProfesseurDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public void addProfesseur(Professeur professeur) throws SQLException {
        String query = "INSERT INTO Professeurs (ProfesseurID, Nom, Prenom, Email, DepartementID) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, professeur.getProfesseurID());
            pstmt.setString(2, professeur.getNom());
            pstmt.setString(3, professeur.getPrenom());
            pstmt.setString(4, professeur.getEmail());
            pstmt.setInt(5, professeur.getDepartementID());
            pstmt.executeUpdate();
        }
    }

    @Override
    public Professeur getProfesseur(int professeurID) throws SQLException {
        String query = "SELECT * FROM Professeurs WHERE ProfesseurID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, professeurID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Professeur(rs.getInt("ProfesseurID"), rs.getString("Nom"), rs.getString("Prenom"), rs.getString("Email"), rs.getInt("DepartementID"));
            }
        }
        return null;
    }

    @Override
    public List<Professeur> getAllProfesseurs() throws SQLException {
        List<Professeur> professeurs = new ArrayList<>();
        String query = "SELECT * FROM Professeurs";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                professeurs.add(new Professeur(rs.getInt("ProfesseurID"), rs.getString("Nom"), rs.getString("Prenom"), rs.getString("Email"), rs.getInt("DepartementID")));
            }
        }
        return professeurs;
    }

    @Override
    public void updateProfesseur(Professeur professeur) throws SQLException {
        String query = "UPDATE Professeurs SET Nom = ?, Prenom = ?, Email = ?, DepartementID = ? WHERE ProfesseurID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, professeur.getNom());
            pstmt.setString(2, professeur.getPrenom());
            pstmt.setString(3, professeur.getEmail());
            pstmt.setInt(4, professeur.getDepartementID());
            pstmt.setInt(5, professeur.getProfesseurID());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void deleteProfesseur(int professeurID) throws SQLException {
        String query = "DELETE FROM Professeurs WHERE ProfesseurID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, professeurID);
            pstmt.executeUpdate();
        }
    }
}
