package daoimp;

import dao.CourseDAO;
import models.AvancementCours;
import models.Course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    private Connection con;

    public CourseDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public void addCourse(Course course) throws Exception {
        // Removed CodeCours from query
        String query = "INSERT INTO Courses (NomCours, ProfesseurID, HeuresParSemaine, SemestreID, VolumeHoraireTotal) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, course.getNomCours());
            pstmt.setInt(2, course.getProfesseurID());
            pstmt.setInt(3, course.getHeuresParSemaine());
            pstmt.setInt(4, course.getSemestreID());
            pstmt.setInt(5, course.getVolumeHoraireTotal());
            pstmt.executeUpdate();
        }
    }

    @Override
    public Course getCourse(int coursID) throws Exception {
        String query = "SELECT * FROM Courses WHERE CoursID = ?";
        Course course = null;
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, coursID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                course = new Course(
                    rs.getInt("CoursID"),
                    rs.getString("NomCours"),
                    query, rs.getInt("ProfesseurID"),
                    rs.getInt("HeuresParSemaine"),
                    rs.getInt("SemestreID"),
                    rs.getInt("VolumeHoraireTotal")
                );
            }
        }
        return course;
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
                    query, rs.getInt("ProfesseurID"),
                    rs.getInt("HeuresParSemaine"),
                    rs.getInt("SemestreID"),
                    rs.getInt("VolumeHoraireTotal")
                ));
            }
        }
        return courses;
    }

    @Override
    public void updateCourse(Course course) throws Exception {
        // Removed CodeCours from update query
        String query = "UPDATE Courses SET NomCours = ?, ProfesseurID = ?, HeuresParSemaine = ?, SemestreID = ?, VolumeHoraireTotal = ? WHERE CoursID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, course.getNomCours());
            pstmt.setInt(2, course.getProfesseurID());
            pstmt.setInt(3, course.getHeuresParSemaine());
            pstmt.setInt(4, course.getSemestreID());
            pstmt.setInt(5, course.getVolumeHoraireTotal());
            pstmt.setInt(6, course.getCoursID());
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

    // Implementations for AvancementCoursDAO methods...
    // These methods would remain unchanged unless they also interact with the CodeCours field.


  

	

	@Override
	public void addAvancement(AvancementCours avancement) throws Exception {
		// TODO Auto-generated method stub
		
	}

    // Implementations for AvancementCoursDAO methods...


//	@Override
//	public void addAvancement(AvancementCours avancement) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public AvancementCours getAvancement(int avancementID) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<AvancementCours> getAllAvancements() throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void updateAvancement(AvancementCours avancement) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAvancement(int avancementID) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
}
