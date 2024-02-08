package dao;

import models.Course;
import java.util.List;

public interface CourseDAO {
    void addCourse(Course course) throws Exception;
    Course getCourse(int coursID) throws Exception;
    List<Course> getAllCourses() throws Exception;
    void updateCourse(Course course) throws Exception;
    void deleteCourse(int coursID) throws Exception;
}
