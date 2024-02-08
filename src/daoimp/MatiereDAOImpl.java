package daoimp;

import dao.MatiereDAO;
import models.Matiere;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatiereDAOImpl implements MatiereDAO {
    private Connection con;

    public MatiereDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public void addMatiere(Matiere matiere) throws Exception {
    	String query = "INSERT INTO Matiere (NomMatiere, CoursID) VALUES (?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
        	pstmt.setString(1, matiere.getNomMatiere());
        	pstmt.setInt(2, matiere.getCoursID());
        	pstmt.executeUpdate();

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating matiere failed, no rows affected.");
            }

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    matiere.setMatiereID(generatedKeys.getInt(1)); // Optionally capture the generated MatiereID
                }
                else {
                    throw new SQLException("Creating matiere failed, no ID obtained.");
                }
            }
        }
    }

    

    @Override
    public Matiere getMatiere(int matiereID) throws Exception {
        String query = "SELECT * FROM Matiere WHERE MatiereID = ?";
        Matiere matiere = null;
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, matiereID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                matiere = new Matiere(rs.getInt("MatiereID"), rs.getString("NomMatiere"), rs.getInt("CoursID"));
            }
        }
        return matiere;
    }

    @Override
    public List<Matiere> getAllMatieres() throws Exception {
        List<Matiere> matieres = new ArrayList<>();
        String query = "SELECT * FROM Matiere";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                matieres.add(new Matiere(rs.getInt("MatiereID"), rs.getString("NomMatiere"), rs.getInt("CoursID")));
            }
        }
        return matieres;
    }

    @Override
    public void updateMatiere(Matiere matiere) throws Exception {
        String query = "UPDATE Matiere SET NomMatiere = ?, CoursID = ? WHERE MatiereID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, matiere.getNomMatiere());
            pstmt.setInt(2, matiere.getCoursID());
            pstmt.setInt(3, matiere.getMatiereID());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void deleteMatiere(int matiereID) throws Exception {
        String query = "DELETE FROM Matiere WHERE MatiereID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, matiereID);
            pstmt.executeUpdate();
        }
    }
}
