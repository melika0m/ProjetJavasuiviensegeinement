package daoimp;



import dao.AUDAO;
import models.AU;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AUDAOImpl implements AUDAO {
    private Connection con;

    public AUDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public void addAU(AU au) throws Exception {
        String query = "INSERT INTO AU (Annee) VALUES (?)";
        try (PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, au.getAnnee());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    au.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating AU failed, no ID obtained.");
                }
            }
        }
    }

    @Override
    public AU getAU(int id) throws Exception {
        String query = "SELECT * FROM AU WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new AU(rs.getInt("id"), rs.getString("Annee"));
            }
        }
        return null;
    }

    @Override
    public List<AU> getAllAU() throws Exception {
        List<AU> aus = new ArrayList<>();
        String query = "SELECT * FROM AU";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                aus.add(new AU(rs.getInt("id"), rs.getString("Annee")));
            }
        }
        return aus;
    }

    @Override
    public void updateAU(AU au) throws Exception {
        String query = "UPDATE AU SET Annee = ? WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, au.getAnnee());
            pstmt.setInt(2, au.getId());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void deleteAU(int id) throws Exception {
        String query = "DELETE FROM AU WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
