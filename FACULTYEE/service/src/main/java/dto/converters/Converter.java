package dto.converters;

import dto.dto.CourseDTO;
import dto.dto.RolesDTO;
import dto.dto.SheetListDTO;
import dto.dto.UserDTO;
import entities.Course;
import entities.Roles;
import entities.SheetList;
import entities.User;
import enums.RolesType;

/**
 * Created by ivan on 26.05.2017.
 */
public class Converter {





    public static UserDTO userEntityToUserDtoConverter(User user){
        UserDTO userDTO = null;
        if(user != null){
            userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setFirstName(user.getFirstName());
            userDTO.setLastName(user.getLastName());
            userDTO.setLogin(user.getLogin());
            userDTO.setPassword(user.getPassword());

        }
        return userDTO;
    }

    public static RolesDTO rolesEntityToRolesDTOConverter(Roles roles){
        RolesDTO rolesDTO = null;
        if(roles != null){
            rolesDTO = new RolesDTO();
            rolesDTO.setId(roles.getId());
            rolesDTO.setRolesName(String.valueOf(RolesType.ADMIN));
        }
        return rolesDTO;
    }


    public static CourseDTO courseEntityToCourseDTOConverter(Course course){
        CourseDTO courseDTO = null;
        if(course != null){
            courseDTO = new CourseDTO();
            courseDTO.setId(course.getId());
            courseDTO.setName(course.getName());
            courseDTO.setUser(course.getUser().getId());
            courseDTO.setCourseDescription(course.getCourseDescription());
            courseDTO.setStatus(course.getStatus());
        }
        return courseDTO;
    }


    public  static SheetListDTO sheetListEntityToSheetListDTOConverter(SheetList sheetList){
        SheetListDTO sheetListDTO = null;
        if(sheetList != null){
            sheetListDTO = new SheetListDTO();
            sheetListDTO.setId(sheetList.getId());
            sheetListDTO.setUser(sheetList.getUser().getId());
            sheetListDTO.setCourse(sheetList.getCourse().getId());
            sheetListDTO.setScore(sheetList.getScore());
            sheetListDTO.setShortComment(sheetList.getShortComment());
        }
        return sheetListDTO;
    }






    public static User userDTOToTypeEntityConverter(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getFirstName());
        user.setLogin(user.getLogin());
        user.setPassword(user.getPassword());
        return user;
    }

    public static Roles roleDtoToRoleEntityConverter(RolesDTO rolesDTO){
        Roles roles = new Roles();
        roles.setId(rolesDTO.getId());
       // roles.setRolesName(rolesDTO.getRolesName());
        roles.setRolesName(RolesType.ADMIN);
        return roles;
    }

    public static Course courseDTOToCourseEntityConverter(CourseDTO courseDTO){
        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());

        User user = new User();
        user.setId(courseDTO.getUser());
        course.setUser(user);

        course.setCourseDescription(courseDTO.getCourseDescription());
        course.setStatus(courseDTO.getStatus());
        return course;
    }



    public static SheetList sheetListDTOToSheetListEntityConverter(SheetListDTO sheetListDTO){
        SheetList sheetList = new SheetList();
        sheetList.setId(sheetListDTO.getId());

        User user = new User();
        user.setId(sheetListDTO.getUser());
        sheetList.setUser(user);

        Course course = new Course();
        course.setId(sheetListDTO.getCourse());
        sheetList.setCourse(course);

        sheetList.setScore(sheetListDTO.getScore());
        sheetList.setShortComment(sheetListDTO.getShortComment());
        return sheetList;

    }



}
