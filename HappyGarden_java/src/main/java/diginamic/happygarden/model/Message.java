package diginamic.happygarden.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

/** Contained in a Conversation, it has the content of the message and the User that sent it **/
@Entity
public class Message implements HibernateEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
//	@NotBlank
	@JsonBackReference("conversation_messages")
	@ManyToOne
	@JoinColumn(name = "conversation_id")
	private Conversation conversation;
	
	/** The content of the message shown in the conversation **/
	@NotBlank
	private String content;
	
	/** The user that sent the message**/
	@NotNull
	private String author;

	
	/* Constructors */
	
	public Message() {
	}
	
	public Message(String content, UserAccount author, Conversation conversation) {
		super();
		this.content = content;
		this.author = author.getNickname();
		this.conversation = conversation;
	}

	public Message(String content, String author) {
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(UserAccount author) {
		this.author = author.getNickname();
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}
	
	
}
