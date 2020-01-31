package diginamic.happygarden.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Comment implements HibernateEntity{

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
	
	public Comment() {
		content = "default";
		author = null;
	}
	
	public Comment(String content, UserAccount author) {
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
