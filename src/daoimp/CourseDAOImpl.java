package daoimp;

import dao.AvancementCoursDAO;
import dao.CourseDAO;
import models.AvancementCours;
import models.Course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO, AvancementCoursDAO {
    private Connection con;

    public CourseDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public void addCourse(Course course) throws Exception {
        String query = "INSERT INTO Courses (NomCours, CodeCours, ProfesseurID, HeuresParSemaine, Semestre, VolumeHoraireTotal) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, course.getNomCours());
            pstmt.setString(2, course.getCodeCours());
            pstmt.setInt(3, course.getProfesseurID());
            pstmt.setInt(4, course.getHeuresParSemaine());
            pstmt.setString(5, course.getSemestre());
            pstmt.setInt(6, course.getVolumeHoraireTotal());
            pstmt.executeUpdate();
        }
    }

    @Override
    public Course getCourse(int coursID) throws Exception {
        String query = "SELECT * FROM Courses WHERE CoursID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, coursID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Course(
                    rs.getInt("CoursID"),
                    rs.getString("NomCours"),
                    rs.getString("CodeCours"),
                    rs.getInt("ProfesseurID"),
                    rs.getInt("HeuresParSemaine"),
                    rs.getString("Semestre"),
                    rs.getInt("VolumeHoraireTotal")
                );
            }
        }
        return null;
    }

    @Override
    public List<Course> getAllCourses() throws Exception {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM Courses";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                courses.add(new Course(
                    rs.getInt("CoursID"),
                    rs.getString("NomCours"),
                    rs.getString("CodeCours"),
                    rs.getInt("ProfesseurID"),
                    rs.getInt("HeuresParSemaine"),
                    rs.getString("Semestre"),
                    rs.getInt("VolumeHoraireTotal")
                ));
            }
        }
        return courses;
    }

    @Override
    public void updateCourse(Course course) throws Exception {
        String query = "UPDATE Courses SET NomCours = ?, CodeCours = ?, ProfesseurID = ?, HeuresParSemaine = ?, Semestre = ?, VolumeHoraireTotal = ? WHERE CoursID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, course.getNomCours());
            pstmt.setString(2, course.getCodeCours());
            pstmt.setInt(3, course.getProfesseurID());
            pstmt.setInt(4, course.getHeuresParSemaine());
            pstmt.setString(5, course.getSemestre());
            pstmt.setInt(6, course.getVolumeHoraireTotal());
            pstmt.setInt(7, course.getCoursID());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void deleteCourse(int coursID) throws Exception {
        String query = "DELETE FROM Courses WHERE CoursID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, coursID);
            pstmt.executeUpdate();
        }
    }

	@Override
	public void addAvancement(AvancementCours avancement) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AvancementCours getAvancement(int avancementID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AvancementCours> getAllAvancements() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAvancement(AvancementCours avancement) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAvancement(int avancementID) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
