package diginamic.happygarden.classes;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = PlantApiLinkDeserializer.class)
public class PlantApiLink {
	
	Long id;
	
	Boolean completeData;
	
	String scientificName;

	
	/* Getters Setters */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getCompleteData() {
		return completeData;
	}

	public void setCompleteData(Boolean completeData) {
		this.completeData = completeData;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	/* Methods */
	
	@Override
	public String toString() {
		return "PlantApiLink [id=" + id + ", completeData=" + completeData + ", scientificName=" + scientificName + "]";
	} 

	
}
