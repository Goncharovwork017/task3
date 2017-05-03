package by.nc.dev3.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ivan on 01.05.2017.
 */

@Entity
@Table(name="sheetlist")
public class SheetList implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SheetID")
    public Integer sheetId;


    @ManyToOne
    @JoinColumn(name="UserID")
    private User user;

    @ManyToOne
    @JoinColumn(name="CourseID")
    public Course course;

    @Column(name="Score", length = 15)
    public Integer score;

    @Column(name="ShortComment", length = 15)
    public String shortComment;




    public SheetList() {
    }


    public Integer getSheetId() {
        return sheetId;
    }

    public void setSheetId(Integer sheetId) {
        this.sheetId = sheetId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
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


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SheetList sheetList = (SheetList) o;

        if (sheetId != null ? !sheetId.equals(sheetList.sheetId) : sheetList.sheetId != null) return false;
        if (user != null ? !user.equals(sheetList.user) : sheetList.user != null) return false;
        if (course != null ? !course.equals(sheetList.course) : sheetList.course != null) return false;
        if (score != null ? !score.equals(sheetList.score) : sheetList.score != null) return false;
        return shortComment != null ? shortComment.equals(sheetList.shortComment) : sheetList.shortComment == null;
    }

    @Override
    public int hashCode() {
        int result = sheetId != null ? sheetId.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (shortComment != null ? shortComment.hashCode() : 0);
        return result;
    }
}
