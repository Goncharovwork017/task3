package entities;


import javax.persistence.*;


/**
 * Created by ivan on 01.05.2017.
 */


public class UserSheetList extends AbstractEntity {


    @ManyToOne
    @JoinColumn(name="SheetID")
    public SheetList sheetId;

    @ManyToOne
    @JoinColumn(name="UserID")
    private User user;

    @ManyToOne
    @JoinColumn(name="CourseID")
    public Course course;

    @ManyToOne
    @JoinColumn(name="Score")
    public SheetList score;

    @ManyToOne
    @JoinColumn(name="ShortComment")
    public SheetList shortComment;

    @ManyToOne
    @JoinColumn(name="FirstName")
    private User firstName;

    @ManyToOne
    @JoinColumn(name="LastName")
    private User lastName;


    public UserSheetList() {
    }


    public SheetList getSheetId() {
        return sheetId;
    }

    public void setSheetId(SheetList sheetId) {
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

    public SheetList getScore() {
        return score;
    }

    public void setScore(SheetList score) {
        this.score = score;
    }

    public SheetList getShortComment() {
        return shortComment;
    }

    public void setShortComment(SheetList shortComment) {
        this.shortComment = shortComment;
    }

    public User getFirstName() {
        return firstName;
    }

    public void setFirstName(User firstName) {
        this.firstName = firstName;
    }

    public User getLastName() {
        return lastName;
    }

    public void setLastName(User lastName) {
        this.lastName = lastName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSheetList that = (UserSheetList) o;

        if (sheetId != null ? !sheetId.equals(that.sheetId) : that.sheetId != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (course != null ? !course.equals(that.course) : that.course != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;
        if (shortComment != null ? !shortComment.equals(that.shortComment) : that.shortComment != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = sheetId != null ? sheetId.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (shortComment != null ? shortComment.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
