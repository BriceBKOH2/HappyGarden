package diginamic.happygarden.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Plant implements HibernateEntity<Long> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	protected Long id;
	
	protected String scientificName;
	
	protected String commonName;
	
	protected String familyCommonName;
	
	protected String toxicity;
	
	protected Float matureHeight;
	
	protected String lifeSpan;
	
	protected String image;
	
	protected String bloomPeriod;
	
	@Enumerated(EnumType.STRING)
	protected GrowthRate growthRate;
	
	@Enumerated(EnumType.STRING)
	@ElementCollection
	protected List<Season> seasons = new ArrayList<>();

	/* Constructors */
	
	public Plant() {
		super();
	}

	public Plant(String commonName) {
		super();
		this.commonName = commonName;
	}

	public Plant(String scientificName, String commonName, String familyCommonName, String toxicity, Float matureHeight,
			String lifeSpan, String bloomPeriod, GrowthRate growthRate, List<Season> seasons) {
		super();
		this.scientificName = scientificName;
		this.commonName = commonName;
		this.familyCommonName = familyCommonName;
		this.toxicity = toxicity;
		this.matureHeight = matureHeight;
		this.lifeSpan = lifeSpan;
		this.bloomPeriod = bloomPeriod;
		this.growthRate = growthRate;
		this.seasons = seasons;
	}

	public Plant(String scientificName, String commonName, String familyCommonName, String toxicity, Float matureHeight,
			String lifeSpan, String image, String bloomPeriod, GrowthRate growthRate, List<Season> seasons) {
		super();
		this.scientificName = scientificName;
		this.commonName = commonName;
		this.familyCommonName = familyCommonName;
		this.toxicity = toxicity;
		this.matureHeight = matureHeight;
		this.lifeSpan = lifeSpan;
		this.image = image;
		this.bloomPeriod = bloomPeriod;
		this.growthRate = growthRate;
		this.seasons = seasons;
	}

	
	/* Getters Setters */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	
}
