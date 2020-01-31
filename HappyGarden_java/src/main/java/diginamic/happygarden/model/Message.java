package diginamic.happygarden.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/** Contained in a Conversation, it has the content of the message and the User that sent it **/
@Entity
public class Message implements HibernateEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** The content of the message shown in the conversation **/
	@NotBlank
	private String content;
	
	/** The user that sent the message**/
	@NotNull
	@ManyToOne
	private UserAccount author;

	
	/* Constructors */
	
	public Message() {
		content = "default";
		author = null;
	}
	
	public Message(String content, UserAccount author) {
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
