package diginamic.happygarden.model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Pot extends PlantingArea {
	
	private Boolean interior;

	
	/* Constructors */
	
	public Pot() {
		super();
	}

	public Pot(String name) {
		super(name);
	}
	
	public Pot(String name, Boolean interior) {
		super(name);
		this.interior = interior;
	}
	
	public Pot(String name, Boolean interior, List<Slot> slots) {
		super(name);
		this.interior = interior;
		this.slots = slots;
	}

	
	/* Getters Setters */
	
	public Boolean getInterior() {
		return interior;
	}

	public void setInterior(Boolean interior) {
		this.interior = interior;
	}
	
	
}
