package happygarden.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

/** Abstract Class for Parcel and Pot **/
public abstract class PlantingArea implements HibernateClass, ReminderManager, SlotManager{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@NotBlank
	protected String name;
	
	@OneToMany
	protected List<Reminder> reminders;
	
	@OneToMany
	protected List<Slot> slots;

	
	/* Constructors */
	
	public PlantingArea() {
		super();
	}

	public PlantingArea(String name) {
		super();
		this.name = name;
		this.reminders = new ArrayList<Reminder>();
		this.slots = new ArrayList<Slot>();
	}

	public PlantingArea(String name, List<Reminder> reminders) {
		super();
		this.name = name;
		this.reminders = reminders;
		this.slots = new ArrayList<Slot>();
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
		
	public void setReminders(Reminder... reminders) {
		this.reminders = new ArrayList<Reminder>();
		for (Reminder reminder : reminders) {
			this.reminders.add(reminder);
		}
	}
	
	public List<Slot> getSlots() {
		return slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}
	
	public void setSlots(Slot... slots) {
		for (Slot slot : slots) {
			this.slots.add(slot);
		}
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
