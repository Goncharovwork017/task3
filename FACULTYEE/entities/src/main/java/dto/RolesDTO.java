package dto;

import enums.RolesType;

/**
 * Created by ivan on 20.05.2017.
 */
public class RolesDTO extends AbstractDTO {

    private RolesType rolesName;

    public RolesDTO() {
    }

    public RolesDTO(RolesType rolesName) {
        this.rolesName = rolesName;
    }


    public RolesDTO(int id, RolesType rolesName) {
        super(id);
        this.rolesName = rolesName;
    }


    public RolesType getRolesName() {
        return rolesName;
    }

    public void setRolesName(RolesType rolesName) {
        this.rolesName = rolesName;
    }
}
