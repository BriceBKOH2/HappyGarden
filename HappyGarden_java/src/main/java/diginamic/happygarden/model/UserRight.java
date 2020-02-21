package diginamic.happygarden.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * a specification / autorisation given for a Role 
 * 
 */
@Entity
public class UserRight implements HibernateEntity<Long> {
	
	public final static String RIGHT_COMMENT = "comment";
	public final static String RIGHT_MESSAGE = "message";
	public final static String RIGHT_ADMINISTRATION = "administration";
	public final static String RIGHT_ACCOUNT_SUPPRESSION = "account_suppression";
	public final static String RIGHT_PLANT_SUPPRESSION = "plant_suppression";
	public final static String RIGHT_PLANT_ADDITION = "plant_addition";
	public final static String RIGHT_PLANT_MODIFICATION = "plant_modification";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(unique = true)
	private String name;

	
	/* Constructors */
	
	public UserRight() {
		super();
	}

	public UserRight(String name) {
		super();
		this.name = name;
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

	
	
}
