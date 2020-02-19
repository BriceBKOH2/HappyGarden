package diginamic.happygarden.classes;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import diginamic.happygarden.model.GrowthRate;
import diginamic.happygarden.model.Season;

@JsonDeserialize(using = PlantApiDeserializer.class)
public class PlantApi {

	protected String scientificName;

	protected String commonName;

	protected String familyCommonName;

	protected String toxicity;

	protected Float matureHeight;

	protected String lifeSpan;

	protected String image;

	protected String bloomPeriod;

	protected GrowthRate growthRate;

	protected List<Season> seasons = new ArrayList<>();

	
	/* Getters Setters */

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getFamilyCommonName() {
		return familyCommonName;
	}

	public void setFamilyCommonName(String familyCommonName) {
		this.familyCommonName = familyCommonName;
	}

	public String getToxicity() {
		return toxicity;
	}

	public void setToxicity(String toxicity) {
		this.toxicity = toxicity;
	}

	public Float getMatureHeight() {
		return matureHeight;
	}

	public void setMatureHeight(Float matureHeight) {
		this.matureHeight = matureHeight;
	}

	public String getLifeSpan() {
		return lifeSpan;
	}

	public void setLifeSpan(String lifeSpan) {
		this.lifeSpan = lifeSpan;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBloomPeriod() {
		return bloomPeriod;
	}

	public void setBloomPeriod(String bloomPeriod) {
		this.bloomPeriod = bloomPeriod;
	}

	public GrowthRate getGrowthRate() {
		return growthRate;
	}

	public void setGrowthRate(GrowthRate growthRate) {
		this.growthRate = growthRate;
	}

	public List<Season> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
	}

	
	/* Methods */

	@Override
	public String toString() {
		return "PlantApi [scientificName=" + scientificName + ", commonName=" + commonName + ", familyCommonName="
				+ familyCommonName + ", toxicity=" + toxicity + ", matureHeight=" + matureHeight + ", lifeSpan="
				+ lifeSpan + ", image=" + image + ", bloomPeriod=" + bloomPeriod + ", growthRate=" + growthRate
				+ ", seasons=" + seasons + "]";
	}

}
