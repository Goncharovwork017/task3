package by.nc.dev3.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * Created by ivan on 01.05.2017.
 */



@Entity
@Table(name="course")
public class Course implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CourseID")
    private Integer courseId;

    @Column(name="Name", length = 15)
    private String name;

    @ManyToOne
    @JoinColumn(name="UserID")
    private User user;

    @Column(name="CourseDescription", length = 15)
    private String courseDescription;

    @Column(name="Status", length = 15)
    private String status;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, targetEntity = SheetList.class)
    private List<SheetList> sheetLists;



    public Course() {
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (courseId != null ? !courseId.equals(course.courseId) : course.courseId != null) return false;
        if (name != null ? !name.equals(course.name) : course.name != null) return false;
        if (user != null ? !user.equals(course.user) : course.user != null) return false;
        if (courseDescription != null ? !courseDescription.equals(course.courseDescription) : course.courseDescription != null)
            return false;
        return status != null ? status.equals(course.status) : course.status == null;
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (courseDescription != null ? courseDescription.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
