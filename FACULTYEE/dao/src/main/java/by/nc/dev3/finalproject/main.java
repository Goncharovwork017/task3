package by.nc.dev3.finalproject;



import by.nc.dev3.finalproject.dao.UserDAO;
import by.nc.dev3.finalproject.dao.impl.CourseDAOHibernate;
import by.nc.dev3.finalproject.dao.impl.UserDAOHibernate;
import by.nc.dev3.finalproject.entities.Course;
import by.nc.dev3.finalproject.entities.User;
import by.nc.dev3.finalproject.enums.RolesType;
import by.nc.dev3.finalproject.utils.EntityBuilder;

import java.util.List;

/**
 * Created by ivan on 03.05.2017.
 */
public class main {
    public static void main(String[] args) {

//
//            CourseDAOHibernate courseDAOHibernate = new CourseDAOHibernate(Course.class);
//            courseDAOHibernate.delete(1);
//            List<Course> results = courseDAOHibernate.getAll();


//        System.out.println(results);

        UserDAOHibernate userDAOHibernate = new UserDAOHibernate(User.class);


           userDAOHibernate.save(EntityBuilder.buildUser("bahbkOasd","11122","Ivan","Goncharov", EntityBuilder.buildRoles(RolesType.ADMIN)));
        userDAOHibernate.save(EntityBuilder.buildUser("oleg","olrg","Oleg","Zheleznov", EntityBuilder.buildRoles(RolesType.ADMIN)));

            //  userDAOHibernate.delete(4);
        List<User> users = userDAOHibernate.getAll();

        System.out.println(users);

       // System.out.println(userDAOHibernate.getById(1));
       // System.out.println(userDAOHibernate.getByLogin("qwe"));
    }
}
