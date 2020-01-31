package diginamic.happygarden.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

/** Contains a list of Parcel, Pot with possible list of Comment" **/
@Entity
public class Garden implements HibernateEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;

	@OneToMany
	private List<T> comments = new ArrayList<T>();	
	
	@OneToMany
	private List<PlantingArea> plantingAreas = new ArrayList<PlantingArea>();

	
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

	public List<T> getComments() {
		return comments;
	}

	public void setComments(List<T> comments) {
		this.comments = comments;
	}

	public List<PlantingArea> getPlantingAreas() {
		return plantingAreas;
	}

	public void setPlantingAreas(List<PlantingArea> plantingAreas) {
		this.plantingAreas = plantingAreas;
	}
	
	
	/* Methods */
	
	public void addComments(List<T> comments) {
		this.comments.addAll(comments);
	}
	
	public void addComments(T... comments) {
		for (T comment : comments) {
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
	
	
	
}
