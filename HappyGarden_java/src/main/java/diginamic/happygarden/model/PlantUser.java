package diginamic.happygarden.model;

import java.util.List;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class PlantUser extends Plant {

	@NotNull
	private String creator;
	
	/* Constructor */
	
	public PlantUser() {
		super();
	}

	public PlantUser(String commonName, String creator) {
		super(commonName);
		this.creator = creator;
	}

	public PlantUser(String scientificName, String commonName, String familyCommonName, String toxicity, Float matureHeight,
			String lifeSpan, String bloomPeriod, GrowthRate growthRate, List<Season> seasons, String creator) {
		super(scientificName, commonName, familyCommonName, toxicity, matureHeight,
				lifeSpan, bloomPeriod, growthRate, seasons);
		this.creator = creator;
	}

	public PlantUser(String scientificName, String commonName, String familyCommonName, String toxicity, Float matureHeight,
			String lifeSpan, String image, String bloomPeriod, GrowthRate growthRate, List<Season> seasons, String creator) {
		super(scientificName, commonName, familyCommonName, toxicity, matureHeight,
				lifeSpan, image, bloomPeriod, growthRate, seasons);
		this.creator = creator;
	}

	
	/* Getters Setters */

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
	
}
