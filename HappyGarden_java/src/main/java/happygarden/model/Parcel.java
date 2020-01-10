package happygarden.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Parcel extends PlantingArea {

	private Long length;

	private Long width;

	/* Constructors */

	public Parcel() {
		super();
	}

	public Parcel(String name) {
		super(name);
	}

	public Parcel(String name, Long length, Long width) {
		super(name);
		this.length = length;
		this.width = width;
	}

	public Parcel(String name, Long length, Long width, List<Slot> slots) {
		super(name);
		this.length = length;
		this.width = width;
		this.slots = slots;
	}

	/* Getters Setters */

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public Long getWidth() {
		return width;
	}

	public void setWidth(Long width) {
		this.width = width;
	}

}
