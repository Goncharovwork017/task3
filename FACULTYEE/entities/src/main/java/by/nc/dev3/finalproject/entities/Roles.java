package by.nc.dev3.finalproject.entities;

import by.nc.dev3.finalproject.enums.RolesType;

import javax.persistence.*;
import java.util.List;


/**
 * Created by ivan on 01.05.2017.
 */
@Entity
@Table(name="roles")
public class Roles extends AbstractEntity  {

    private RolesType rolesName;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('STUDENT', 'ADMIN')", name = ("RolesName"))
    public RolesType getRolesName() {
        return rolesName;
    }

    public void setRolesName(RolesType rolesName) {
        this.rolesName = rolesName;
    }
}
