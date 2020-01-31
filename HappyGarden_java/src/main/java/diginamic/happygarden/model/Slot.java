package diginamic.happygarden.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Slot implements HibernateEntity, ReminderManager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date date;
	
	@JsonManagedReference("plant_slots")
	@ManyToOne
	private Plant plant;
	
	@ManyToMany
	private List<Reminder> reminders = new ArrayList<>();

	@JsonBackReference("area_slots")
	@ManyToOne
	private PlantingArea plantingArea;
	
	/* Constructors */
	
	public Slot() {
		super();
	}

	public Slot(Date date) {
		super();
		this.date = date;
	}

	public Slot(Date date, Plant plant) {
		super();
		this.date = date;
		this.plant = plant;
	}
	
	public Slot(Date date, List<Reminder> reminders) {
		super();
		this.date = date;
		this.reminders = reminders;
	}

	public Slot(Date date, Plant plant, List<Reminder> reminders) {
		super();
		this.date = date;
		this.plant = plant;
		this.reminders = reminders;
	}
	
	/* Getters Setters */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public List<Reminder> getReminders() {
		return reminders;
	}

	public void setReminders(List<Reminder> reminders) {
		this.reminders = reminders;
	}
	
	
	
/* Methods */
	
	public PlantingArea getPlantingArea() {
		return plantingArea;
	}

	public void setPlantingArea(PlantingArea plantingArea) {
		this.plantingArea = plantingArea;
	}

	public void addReminders(List<Reminder> reminders) {
		this.reminders.addAll(reminders);
	}

	public void addReminders(Reminder... reminders) {
		for (Reminder reminder : reminders) {
			this.reminders.add(reminder);
		}
	}

}
