package entities;



import enums.RolesType;

import javax.persistence.*;


/**
 * Created by ivan on 01.05.2017.
 */
@Entity
@Table(name="roles")
public class Roles extends AbstractEntity {

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
