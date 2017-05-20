package dto;

/**
 * Created by ivan on 20.05.2017.
 */
public class SheetListDTO extends AbstractDTO {


    private UserDTO user;


    public CourseDTO course;


    public Integer score;


    public String shortComment;

    public SheetListDTO() {
    }

    public SheetListDTO(UserDTO user, CourseDTO course, Integer score, String shortComment) {
        this.user = user;
        this.course = course;
        this.score = score;
        this.shortComment = shortComment;
    }


    public SheetListDTO(int id, UserDTO user, CourseDTO course, Integer score, String shortComment) {
        super(id);
        this.user = user;
        this.course = course;
        this.score = score;
        this.shortComment = shortComment;
    }


    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getShortComment() {
        return shortComment;
    }

    public void setShortComment(String shortComment) {
        this.shortComment = shortComment;
    }
}
