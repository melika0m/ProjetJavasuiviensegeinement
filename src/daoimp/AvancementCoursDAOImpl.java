package daoimp;

import dao.AvancementCoursDAO;
import models.AvancementCours;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvancementCoursDAOImpl implements AvancementCoursDAO {
    private Connection con;

    public AvancementCoursDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public void addAvancement(AvancementCours avancement) throws Exception {
        String query = "INSERT INTO AvancementCours (CoursID, HeuresDonnees, Date) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, avancement.getCoursID());
            pstmt.setInt(2, avancement.getHeuresDonnees());
            pstmt.setDate(3, avancement.getDate());
            pstmt.executeUpdate();
        }
    }

    // Implement the other methods similar to addAvancement

@Override
public AvancementCours getAvancement(int avancementID) throws Exception {
    String query = "SELECT * FROM AvancementCours WHERE AvancementID = ?";
    try (PreparedStatement pstmt = con.prepareStatement(query)) {
        pstmt.setInt(1, avancementID);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return new AvancementCours(
                rs.getInt("AvancementID"),
                rs.getInt("CoursID"),
                rs.getInt("HeuresDonnees"),
                rs.getDate("Date")
            );
        }
    }
    return null;
}

@Override
public List<AvancementCours> getAllAvancements() throws Exception {
    List<AvancementCours> avancements = new ArrayList<>();
    String query = "SELECT * FROM AvancementCours";
    try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
        while (rs.next()) {
            avancements.add(new AvancementCours(
                rs.getInt("AvancementID"),
                rs.getInt("CoursID"),
                rs.getInt("HeuresDonnees"),
                rs.getDate("Date")
            ));
        }
    }
    return avancements;
}

@Override
public void updateAvancement(AvancementCours avancement) throws Exception {
    String query = "UPDATE AvancementCours SET CoursID = ?, HeuresDonnees = ?, Date = ? WHERE AvancementID = ?";
    try (PreparedStatement pstmt = con.prepareStatement(query)) {
        pstmt.setInt(1, avancement.getCoursID());
        pstmt.setInt(2, avancement.getHeuresDonnees());
        pstmt.setDate(3, avancement.getDate());
        pstmt.setInt(4, avancement.getAvancementID());
        pstmt.executeUpdate();
    }
}

@Override
public void deleteAvancement(int avancementID) throws Exception {
    String query = "DELETE FROM AvancementCours WHERE AvancementID = ?";
    try (PreparedStatement pstmt = con.prepareStatement(query)) {
        pstmt.setInt(1, avancementID);
        pstmt.executeUpdate();
    }
}
}
