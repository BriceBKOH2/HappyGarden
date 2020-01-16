package diginamic.happygarden.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

/** A Conversation between Users that contains a list of messages **/
@Entity
@Table
public class Conversation implements HibernateClass{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@ElementCollection
	private List<Message> messages = new ArrayList<Message>() ;

	
	/* Constructors */
	
	public Conversation() {
		super();
	}

	public Conversation(List<Message> messages) {
		super();
		this.messages = messages;
	}
	
	public Conversation(Message... messages) {
		super();
		for (Message message : messages) {
			this.messages.add(message);
		}
	}
	
	
	/* Getters Setters */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	public void setMessages(Message... messages) {
		this.messages.clear();
		for (Message message : messages) {
			this.messages.add(message);
		}
	}
	
	
	/* Methods */
	
	public void addMessages(List<Message> messages) {
		this.messages.addAll(messages);
	}
	
	public void addMessages(Message... messages) {
		for (Message message : messages) {
			this.messages.add(message);
		}
	}
	
}
