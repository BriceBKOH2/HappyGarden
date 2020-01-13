package diginamic.happygarden.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * Contains a list of Right given to a UserAccount to access the different
 * functionalities of the application
 **/
@Entity
@Table
public class Role implements HibernateClass{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;

	@NotBlank
	private List<Right> rights;

	/* Constructors */

	public Role() {
		super();
		this.rights = new ArrayList<Right>();
	}

	public Role(String name) {
		super();
		this.name = name;
		this.rights = new ArrayList<Right>();
	}

	public Role(String name, List<Right> rights) {
		super();
		this.name = name;
		this.rights = rights;
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

	public List<Right> getRights() {
		return rights;
	}

	public void setRights(List<Right> rights) {
		this.rights = rights;
	}

	public void setRights(Right... rights) {
		this.rights = new ArrayList<Right>();
		for (Right right : rights) {
			this.rights.add(right);
		}
	}

	/* Methods */

	public void addRights(List<Right> rights) {
		this.rights.addAll(rights);
	}

	public void addRights(Right... rights) {
		for (Right right : rights) {
			this.rights.add(right);
		}
	}
}
