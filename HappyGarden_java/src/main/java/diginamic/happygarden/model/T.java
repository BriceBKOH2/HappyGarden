package diginamic.happygarden.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

public class T implements HibernateEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** The content of the comment shown in a Garden **/
	@NotBlank
	private String content;
	
	/** The user that sent the comment **/
	@ManyToOne
	@NotNull
	private UserAccount author;

	
	/* Constructors */
	
	public T() {
		content = "default";
		author = null;
	}
	
	public T(String content, UserAccount author) {
		super();
		this.content = content;
		this.author = author;
	}

	
	/* Getters Setters */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UserAccount getAuthor() {
		return author;
	}

	public void setAuthor(UserAccount author) {
		this.author = author;
	}
}
