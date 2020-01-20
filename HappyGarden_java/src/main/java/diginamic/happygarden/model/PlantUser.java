package diginamic.happygarden.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PlantUser extends Plant {

	@ManyToOne
	private UserAccount creator;
	
	/* Constructor */
	
	public PlantUser() {
		super();
	}

	public PlantUser(String commonName, UserAccount creator) {
		super(commonName);
		this.creator = creator;
	}

	public PlantUser(String scientificName, String commonName, String familyCommonName, String toxicity, Float matureHeight,
			String lifeSpan, String bloomPeriod, GrowthRate growthRate, List<Season> seasons, UserAccount creator) {
		super(scientificName, commonName, familyCommonName, toxicity, matureHeight,
				lifeSpan, bloomPeriod, growthRate, seasons);
		this.creator = creator;
	}

	public PlantUser(String scientificName, String commonName, String familyCommonName, String toxicity, Float matureHeight,
			String lifeSpan, String image, String bloomPeriod, GrowthRate growthRate, List<Season> seasons, UserAccount creator) {
		super(scientificName, commonName, familyCommonName, toxicity, matureHeight,
				lifeSpan, image, bloomPeriod, growthRate, seasons);
		this.creator = creator;
	}

	
	/* Getters Setters */

	public UserAccount getCreator() {
		return creator;
	}

	public void setCreator(UserAccount creator) {
		this.creator = creator;
	}
	
}
