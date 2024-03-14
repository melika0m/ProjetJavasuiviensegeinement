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
        // Adjusted query to exclude ProfesseurID and include Status
        String query = "INSERT INTO Professeurs (Nom, Prenom, Email, DepartementID, Status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, professeur.getNom());
            pstmt.setString(2, professeur.getPrenom());
            pstmt.setString(3, professeur.getEmail());
            pstmt.setInt(4, professeur.getDepartementID());
            pstmt.setString(5, professeur.getstatus()); // Include Status
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    professeur.setProfesseurID(generatedKeys.getInt(1)); // Capture the generated ProfesseurID
                } else {
                    throw new SQLException("Creating professeur failed, no ID obtained.");
                }
            }
        }
    }
    @Override
    public int addProfesseurAndGetId(Professeur professeur) throws SQLException {
        String query = "INSERT INTO Professeurs (Nom, Prenom, Email, DepartementID, Status) VALUES (?, ?, ?, ?, ?)";
        int generatedId = 0;

        try (PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, professeur.getNom());
            pstmt.setString(2, professeur.getPrenom());
            pstmt.setString(3, professeur.getEmail());
            pstmt.setInt(4, professeur.getDepartementID());
            pstmt.setString(5, professeur.getstatus());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating professeur failed, no rows affected.");
            }

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating professeur failed, no ID obtained.");
                }
            }
        }
        return generatedId; // Return the generated ID
    }


    @Override
    public Professeur getProfesseur(int professeurID) throws SQLException {
        String query = "SELECT * FROM Professeurs WHERE ProfesseurID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, professeurID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Adjust to include Status in the returned Professeur object
                return new Professeur(
                    rs.getInt("ProfesseurID"), 
                    rs.getString("Nom"), 
                    rs.getString("Prenom"), 
                    rs.getString("Email"), 
                    rs.getInt("DepartementID"),
                    rs.getString("Status") // Retrieve Status
                );
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
                professeurs.add(new Professeur(
                    rs.getInt("ProfesseurID"), 
                    rs.getString("Nom"), 
                    rs.getString("Prenom"), 
                    rs.getString("Email"), 
                    rs.getInt("DepartementID"),
                    rs.getString("Status") // Include Status
                ));
            }
        }
        return professeurs;
    }

    @Override
    public void updateProfesseur(Professeur professeur) throws SQLException {
        // Adjust query to include Status in the update
        String query = "UPDATE Professeurs SET Nom = ?, Prenom = ?, Email = ?, DepartementID = ?, Status = ? WHERE ProfesseurID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, professeur.getNom());
            pstmt.setString(2, professeur.getPrenom());
            pstmt.setString(3, professeur.getEmail());
            pstmt.setInt(4, professeur.getDepartementID());
            pstmt.setString(5, professeur.getstatus()); // Update Status
            pstmt.setInt(6, professeur.getProfesseurID());
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

//	public int addProfesseurAndGetId(Professeur professeur) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public void addProfesseur(Professeur professeur) throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
}
