package by.tms.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
		@NamedQuery(name = "User.findAll", query = "select u from User u"),
		@NamedQuery(name = "User.findAllByName", query = "select u from User u where u.name = :name"),
		@NamedQuery(name = "User.findByUsername", query =  "select u from User u where u.name = :name" )
})
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

//	@NotBlank // " " true
//	@NotEmpty //"    " false

	@NotEmpty(message = "name empty")
	@Size(min = 3, max = 50, message = "name should be between 3 and 50 characters")
	private String name;

	@NotEmpty(message = "password empty")
	@Size(min = 3, max = 50, message = "password should be between 3 and 50 characters")
	private String password;

	@NotEmpty(message = "email empty")
	@Email(message = "not valid email")
	private String email;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Operation> operationList;

	public User() {
	}

	public User(long id, String name, String password, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Operation> getOperationList() {
		return operationList;
	}

	public void setOperationList(List<Operation> operationList) {
		this.operationList = operationList;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
