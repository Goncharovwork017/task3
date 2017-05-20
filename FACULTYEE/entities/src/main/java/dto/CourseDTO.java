package dto;

/**
 * Created by ivan on 20.05.2017.
 */
public class CourseDTO extends AbstractDTO {


    private String name;
    private UserDTO user;
    private String courseDescription;
    private String status;

    public CourseDTO() {
    }

    public CourseDTO(String name, UserDTO user, String courseDescription, String status) {
        this.name = name;
        this.user = user;
        this.courseDescription = courseDescription;
        this.status = status;
    }


    public CourseDTO(int id, String name, UserDTO user, String courseDescription, String status) {
        super(id);
        this.name = name;
        this.user = user;
        this.courseDescription = courseDescription;
        this.status = status;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
