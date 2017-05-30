package dto.dto;

/**
 * Created by ivan on 20.05.2017.
 */
public class RolesDTO extends AbstractDTO {

    private String rolesName;

    public RolesDTO() {
    }

    public String getRolesName() {
        return rolesName;
    }

    public void setRolesName(String rolesName) {
        this.rolesName = rolesName;
    }


    @Override
    public String toString() {
        return "RolesDTO{" +
                "rolesName='" + rolesName + '\'' +
                '}';
    }
}
