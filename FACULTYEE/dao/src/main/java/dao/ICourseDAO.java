package dao;


import entities.Course;

import java.util.List;

/**
 * Created by ivan on 02.05.2017.
 */
public interface ICourseDAO extends IDAO<Course> {

    List<Course> findAvailableCourse(String login);
    List<Course> findCurrentCoursesForStudents(String login);
    List<Course> findCourseWithTeacher(int id);
}
