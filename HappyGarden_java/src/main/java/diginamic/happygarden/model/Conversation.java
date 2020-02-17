package diginamic.happygarden.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;


/** A Conversation between Users that contains a list of messages **/
@Entity
@Table
public class Conversation implements HibernateEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@OneToMany
	//@OneToMany(cascade = CascadeType.PERSIST)
	private List<Message> messages = new ArrayList<>() ;

	@JsonBackReference("user_conversations")
	@ManyToMany
	private List<UserAccount> users = new ArrayList<>();
	
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
	
	public List<UserAccount> getUsers() {
		return users;
	}

	public void setUsers(List<UserAccount> users) {
		this.users = users;
	}
		
	/* Methods */
	
	public void addUser(UserAccount user) {
		this.users.add(user);
	}

	public void addMessages(List<Message> messages) {
		this.messages.addAll(messages);
	}
	
	public void addMessages(Message... messages) {
		for (Message message : messages) {
			this.messages.add(message);
		}
	}
	
}
