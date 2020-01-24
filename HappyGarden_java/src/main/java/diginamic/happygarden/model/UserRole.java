package diginamic.happygarden.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Contains a list of Right given to a UserAccount to access the different
 * functionalities of the application
 **/
@Entity
public class UserRole implements HibernateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(unique = true)
	private String name;
	
	@NotNull
	@ManyToMany
	private List<UserRight> userRights = new ArrayList<UserRight>();

	/* Constructors */

	public UserRole() {
		super();
	}

	public UserRole(String name) {
		super();
		this.name = name;
	}

	public UserRole(String name, List<UserRight> userRights) {
		super();
		this.name = name;
		this.userRights = userRights;
	}

	public UserRole(String name, UserRight... userRights) {
		super();
		this.name = name;
		for (UserRight userRight : userRights) {
			this.userRights.add(userRight);
		}
	}

	/* Getters Setters */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserRight> getUserRights() {
		return userRights;
	}

	public void setUserRights(List<UserRight> userRights) {
		this.userRights = userRights;
	}


	/* Methods */

	public void addUserRights(List<UserRight> userRights) {
		this.userRights.addAll(userRights);
	}

	public void addUserRights(UserRight... userRights) {
		for (UserRight right : userRights) {
			this.userRights.add(right);
		}
	}
}
