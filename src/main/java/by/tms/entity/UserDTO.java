package by.tms.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

public class UserDTO {

    @NotEmpty(message = "name empty")
    @Size(min = 3, max = 50, message = "name should be between 3 and 50 characters")
    private String name;

    @NotEmpty(message = "password empty")
    @Size(min = 3, max = 50, message = "password should be between 3 and 50 characters")
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
