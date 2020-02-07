package diginamic.happygarden.model;

/**
 * Specifies that the class extending this interface must have an identification
 * number as well as a getter and a setter.
 * @author formation
 *
 * @param <ID> The type of the id
 */
public interface HibernateEntity <ID>{
	
	ID getId();

	void setId(Long id);
	
}
