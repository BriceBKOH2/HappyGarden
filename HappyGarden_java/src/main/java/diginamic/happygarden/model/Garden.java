package diginamic.happygarden.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/** Contains a list of Parcel, Pot with possible list of Comment" **/
@Entity
public class Garden implements HibernateEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;

	@OneToMany
	private List<Comment> comments = new ArrayList<Comment>();	
	@JsonManagedReference("garden_areas")
	@OneToMany(mappedBy = "garden", cascade = CascadeType.PERSIST)
	private List<PlantingArea> plantingAreas = new ArrayList<PlantingArea>();

	
	@JsonBackReference("user_gardens")
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserAccount user;
	
	/* Constructors */
	
	public Garden() {
		super();
	}

	public Garden(String name) {
		super();
		this.name = name;
	}

	public Garden(String name, List<PlantingArea> plantingAreas) {
		super();
		this.name = name;
		this.plantingAreas = plantingAreas;
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<PlantingArea> getPlantingAreas() {
		return plantingAreas;
	}

	public void setPlantingAreas(List<PlantingArea> plantingAreas) {
		this.plantingAreas = plantingAreas;
	}
	
	
	/* Methods */
	
	public void addComments(List<Comment> comments) {
		this.comments.addAll(comments);
	}
	
	public void addComments(Comment... comments) {
		for (Comment comment : comments) {
			this.comments.add(comment);
		}
	}
	
	public void addPlantingAreas(List<PlantingArea>plantingAreas) {
		this.plantingAreas.addAll(plantingAreas);
	}
	
	public void addPlantingAreas(PlantingArea...plantingAreas) {
		for (PlantingArea plantingArea : plantingAreas) {
			this.plantingAreas.add(plantingArea);
		}
	}

	public UserAccount getUser() {
		return user;
	}

	public void setUser(UserAccount user) {
		this.user = user;
	}
	
}
