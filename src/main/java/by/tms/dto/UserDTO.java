package by.tms.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class UserDTO {

    @NotEmpty(message = "name empty")
    private String name;

    @NotEmpty(message = "password empty")
    private String password;

    public UserDTO() {
    }

    public UserDTO(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
