package by.nc.dev3.finalproject.entities;

import javax.persistence.*;
import java.util.List;


/**
 * Created by ivan on 01.05.2017.
 */



@Entity
@Table(name="course")
public class Course extends AbstractEntity {




    private String name;
    private User user;
    private String courseDescription;
    private String status;




    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", user=" + user +
                ", courseDescription='" + courseDescription + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Column(nullable = false, name = ("Name"))
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "UserID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(nullable = false, name = ("CourseDescription"))
    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    @Column(nullable = false, name = ("Status"))
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
