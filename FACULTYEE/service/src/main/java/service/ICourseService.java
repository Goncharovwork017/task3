package service;

import entities.Course;

import java.util.List;

/**
 * Created by ivan on 14.05.2017.
 */
public interface ICourseService extends IService<Course> {

    List<Course> findAvailableCourse(String login);
    List<Course> findCurrentCoursesForStudents(String login);
    List<Course> findCourseWithTeacher(Integer id);

}
