package constants;


public class Queries {
    public static String GET_BY_LOGIN = "from User where login = :login";
    public static String CHECK_AUTHORIZATION = "from User where login = :login and password = :password";
    public static String REG = "from User where login = :login";
    public static String ROLES = "from Roles where rolesname = :rolesname";


    public static final String FIND_CHECK_COURSE = "from course where course.id not in" +
            "(select sheetlist.courseid from sheetlist inner join user on user.id = sheetlist.userid " +
            "where user.login = :login";

    public static final String FIND_CURRENT_COURSE = "from sheetlist inner join " +
            "course on course.id = sheetlist.courseid inner join user on user.id = sheetlist.userid" +
            " where user.login = :login";


    public static final String GET_ALL_COURSE_WITH_TEACHER ="from course where userid = :userid";




    public static final String FIND_ALL_STUDENT_FOR_COURSE = "select sheetlist.id,sheetlist.score,sheetlist.shortcomment," +
            " user.id from sheetlist inner join user on sheetlist.userid = user.id where sheetlist.courseid = :courseid";

//select sheetlist.id,sheetlist.score,sheetlist.shortcomment," +" user.id, user.firstname,user.lastname from sheetlist inner join user on sheetlist.userid = user.id where sheetlist.courseid = :courseid



}
