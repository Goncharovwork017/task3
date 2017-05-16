package utils;


import entities.Course;
import entities.Roles;
import entities.SheetList;
import entities.User;
import enums.RolesType;

/**
 * Created by ivan on 03.05.2017.
 */
public class EntityBuilder {
    private EntityBuilder(){}


    public static User buildUser(String login, String pass, String name, String surname, Roles roles){
        User user = new User();
        user.setFirstName(name);
        user.setLastName(surname);
        user.setLogin(login);
        user.setPassword(pass);
        user.setRoles(roles)
        ;return user;
    }


    public static Course buildCourse(String name,User user, String courseDesc, String status){
        Course course = new Course();
        course.setName(name);
        course.setUser(user);
        course.setCourseDescription(courseDesc);
        course.setStatus(status);
        return course;
    }


    public static SheetList buildSheetList(User user, Course course, Integer score, String shortComm){
        SheetList sheetList = new SheetList();
        sheetList.setUser(user);
        sheetList.setCourse(course);
        sheetList.setScore(score);
        sheetList.setShortComment(shortComm);
        return sheetList;
    }

    public static Roles buildRoles(RolesType name){
        Roles roles = new Roles();
        roles.setRolesName(name);
        return roles;
    }

}
