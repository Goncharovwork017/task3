package by.nc.dev3.finalproject.entities;

import javax.persistence.*;
import java.util.List;


/**
 * Created by ivan on 01.05.2017.
 */
@Entity
@Table(name="roles")
public class Roles extends AbstractEntity  {


    private String roles;

    @Column(nullable = false, name = ("Roles"))
    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }



}
