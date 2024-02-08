
package dao;
import java.sql.SQLException;
import java.util.List;

import models.Department;

public interface DepartmentDAO {
    void addDepartment(Department department) throws SQLException;
    Department getDepartment(int departmentID) throws SQLException;
    List<Department> getAllDepartments() throws SQLException;
    void updateDepartment(Department department) throws SQLException;
    void deleteDepartment(int departmentID) throws SQLException;
}
