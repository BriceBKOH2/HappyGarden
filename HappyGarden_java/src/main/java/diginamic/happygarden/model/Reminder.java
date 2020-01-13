package diginamic.happygarden.model;

import java.sql.Date;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Reminder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;

	private String content;
	
	@NotBlank
	private Date activationDate;
	
	/** Reminder will not loop if period is null **/
	private Period period;

	
	/* Reminder */
	
	public Reminder() {
		super();
	}

	public Reminder(String name, String content, Date activationDate) {
		super();
		this.name = name;
		this.content = content;
		this.activationDate = activationDate;
	}

	public Reminder(String name, String content, Date activationDate, Period period) {
		super();
		this.name = name;
		this.content = content;
		this.activationDate = activationDate;
		this.period = period;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}
	
	
	
}
