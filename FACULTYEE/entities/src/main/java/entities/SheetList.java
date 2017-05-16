package entities;

import javax.persistence.*;

/**
 * Created by ivan on 01.05.2017.
 */

@Entity
@Table(name="sheetlist")
public class SheetList extends AbstractEntity {




    private User user;


    public Course course;


    public Integer score;


    public String shortComment;




    public SheetList() {
    }


    @Override
    public String toString() {
        return "SheetList{" +
                "user=" + user +
                ", course=" + course +
                ", score=" + score +
                ", shortComment='" + shortComment + '\'' +
                '}';
    }

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "UserID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "CourseID")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Column(nullable = false, name = ("Score"))
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Column(nullable = false, name = ("ShortComment"))
    public String getShortComment() {
        return shortComment;
    }

    public void setShortComment(String shortComment) {
        this.shortComment = shortComment;
    }


}
