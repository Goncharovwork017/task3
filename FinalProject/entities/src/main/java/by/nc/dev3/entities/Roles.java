package by.nc.dev3.entities;

import javax.persistence.*;
import java.util.List;


/**
 * Created by ivan on 01.05.2017.
 */
@Entity
@Table(name="roles")
public class Roles {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoleID")
    private Integer roleId;

    @Column(name="Roles", length = 15)
    private String roles;

    @OneToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    private List<User> userList;


    public Roles() {
    }


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roles roles1 = (Roles) o;

        if (roleId != null ? !roleId.equals(roles1.roleId) : roles1.roleId != null) return false;
        if (roles != null ? !roles.equals(roles1.roles) : roles1.roles != null) return false;
        return userList != null ? userList.equals(roles1.userList) : roles1.userList == null;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + (userList != null ? userList.hashCode() : 0);
        return result;
    }
}
