package by.nc.dev3.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * Created by ivan on 01.05.2017.
 */
@Entity
@Table(name="user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UserID")
    private Integer userId;

    @Column(name="FirstName",length = 25)
    private String firstName;

    @Column(name="LastName",length = 25)
    private String lastName;

    @Column(name="Login", length = 25)
    private String login;

    @Column(name="Password", length = 25)
    private String password;


    @ManyToOne
    @JoinColumn(name="RoleID")
    private Roles roles;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, targetEntity = SheetList.class)
    private List<SheetList> sheetLists;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, targetEntity = Course.class)
    private List<Course> courseList;


    public User(String firstName, String lastName, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    public User(String firstName, String lastName, String login, String password, Integer roleID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public List<SheetList> getSheetLists() {
        return sheetLists;
    }

    public void setSheetLists(List<SheetList> sheetLists) {
        this.sheetLists = sheetLists;
    }


    @Override
    public boolean equals(Object o) {


        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (roles != null ? !roles.equals(user.roles) : user.roles != null) return false;
        return sheetLists != null ? sheetLists.equals(user.sheetLists) : user.sheetLists == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + (sheetLists != null ? sheetLists.hashCode() : 0);
        return result;
    }
}
