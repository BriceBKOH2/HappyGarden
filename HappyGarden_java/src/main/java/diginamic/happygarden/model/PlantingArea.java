package diginamic.happygarden.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/** Abstract Class for Parcel and Pot **/
@JsonTypeInfo(
		  use = JsonTypeInfo.Id.NAME, 
		  include = JsonTypeInfo.As.PROPERTY, 
		  property = "type")
		@JsonSubTypes({ 
		  @Type(value = Parcel.class, name = "parcel"), 
		  @Type(value = Pot.class, name = "pot") 
		})
@Entity
public abstract class PlantingArea implements HibernateEntity<Long>, ReminderManager, SlotManager{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@NotBlank
	protected String name;
	
	@OneToMany
	protected List<Reminder> reminders = new ArrayList<>();

	@JsonManagedReference("area_slots")
	@OneToMany(mappedBy = "plantingArea", cascade = CascadeType.PERSIST)
	protected List<Slot> slots = new ArrayList<>();
	
	@JsonBackReference("garden_areas")
	@ManyToOne
	@JoinColumn(name = "garden_id")
	private Garden garden;

	@Column
	protected String image;
	
	/* Constructors */
	
	public PlantingArea() {
		super();
	}

	public PlantingArea(String name) {
		super();
		this.name = name;
	}

	public PlantingArea(String name, List<Reminder> reminders) {
		super();
		this.name = name;
		this.reminders = reminders;
	}

	public PlantingArea(String name, List<Reminder> reminders, List<Slot> slots) {
		super();
		this.name = name;
		this.reminders = reminders;
		this.slots = slots;
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

	public List<Reminder> getReminders() {
		return reminders;
	}

	public void setReminders(List<Reminder> reminders) {
		this.reminders = reminders;
	}
	@JsonIgnore
	public List<Slot> getSlots() {
		return slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}

	

	public Garden getGarden() {
		return garden;
	}

	public void setGarden(Garden garden) {
		this.garden = garden;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	/* Methods */



	public void addReminders(List<Reminder> reminders) {
		this.reminders.addAll(reminders);
	}


	public void addReminders(Reminder... reminders) {
		for (Reminder reminder : reminders) {
			this.reminders.add(reminder);
		}
	}
	
	public void addSlots(List<Slot> Slots) {
		this.slots.addAll(slots);
	}

	public void addSlots(Slot... Slots) {
		for (Slot slot : Slots) {
			this.slots.add(slot);
		}
	}
	
	
	
}
