package daoimp;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.DepartmentDAO;
import models.Department;

public class DepartmentDAOImpl implements DepartmentDAO {
    private Connection con;

    public DepartmentDAOImpl(Connection con) {
        this.con = con;
    }

    @Override
    public void addDepartment(Department department) throws SQLException {
        String query = "INSERT INTO Departments (DepartmentID, DepartmentName) VALUES (?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, department.getDepartmentID());
            pstmt.setString(2, department.getDepartmentName());
            pstmt.executeUpdate();
        }
    }

    @Override
    public Department getDepartment(int departmentID) throws SQLException {
        String query = "SELECT * FROM Departments WHERE DepartmentID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, departmentID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Department(rs.getInt("DepartmentID"), rs.getString("DepartmentName"));
            }
        }
        return null;
    }

  
    public List<Department> getAllDepartments() throws SQLException {
        List<Department> departments = new ArrayList<>();
        String query = "SELECT * FROM Departments";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                departments.add(new Department(rs.getInt("DepartmentID"), rs.getString("DepartmentName")));
            }
        }
        return departments;
    }

    @Override
    public void updateDepartment(Department department) throws SQLException {
        String query = "UPDATE Departments SET DepartmentName = ? WHERE DepartmentID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, department.getDepartmentName());
            pstmt.setInt(2, department.getDepartmentID());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void deleteDepartment(int departmentID) throws SQLException {
        String query = "DELETE FROM Departments WHERE DepartmentID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, departmentID);
            pstmt.executeUpdate();
        }
    }
}
