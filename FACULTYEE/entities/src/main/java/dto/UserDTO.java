package dto;



/**
 * Created by ivan on 20.05.2017.
 */
public class UserDTO extends AbstractDTO {

    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private RolesDTO roles;


    public UserDTO() {
    }


    public UserDTO(String firstName, String lastName, String login, String password, RolesDTO roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.roles = roles;
    }


    public UserDTO(int id, String firstName, String lastName, String login, String password, RolesDTO roles) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.roles = roles;
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

    public RolesDTO getRoles() {
        return roles;
    }

    public void setRoles(RolesDTO roles) {
        this.roles = roles;
    }
}
