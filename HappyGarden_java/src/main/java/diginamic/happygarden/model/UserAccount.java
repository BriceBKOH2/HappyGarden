package diginamic.happygarden.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/** The list of information contained in a User's account **/
@Entity
public class UserAccount implements HibernateClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@Column(unique = true)
	@NotBlank
	private String pseudonyme;
	
	@NotBlank
	private String password;
	
	@NotNull
	@ManyToOne
	private UserRole userRole;

	@ManyToMany
	@ElementCollection
	private List<Conversation> conversations = new ArrayList<Conversation>();

	@ManyToMany
	@ElementCollection
	private List<UserAccount> friends  = new ArrayList<UserAccount>();

	@ManyToMany
	@ElementCollection
	private List<Plant> favoritePlants = new ArrayList<Plant>();

	@OneToMany
	@ElementCollection
	private List<Garden> gardens = new ArrayList<Garden>();;

	/* Constructors */

	public UserAccount() {
		super();
	}

	public UserAccount(String firstName, String lastName, String pseudonyme) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.pseudonyme = pseudonyme;
		/*/!\ DEFINE A userRole BY DEFAULT (basic user)!!!!!!!! */
		// userRole = new userRole(????);		
	}

	public UserAccount(String firstName, String lastName, String pseudonyme, UserRole userRole) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.pseudonyme = pseudonyme;
		this.userRole = userRole;
	}

	/* Getters Setters */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPseudonyme() {
		return pseudonyme;
	}

	public void setPseudonyme(String pseudonyme) {
		this.pseudonyme = pseudonyme;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public List<Conversation> getConversations() {
		return conversations;
	}

	public void setConversations(List<Conversation> conversations) {
		this.conversations = conversations;
	}

	public void setConversations(Conversation... conversations) {
		this.conversations.clear();
		for (Conversation conversation : conversations) {
			this.conversations.add(conversation);
		}
	}

	public List<UserAccount> getFriends() {
		return friends;
	}

	public void setFriends(List<UserAccount> friends) {
		this.friends = friends;
	}

	public void setFriends(UserAccount... friends) {
		this.friends.clear();
		for (UserAccount friend : friends) {
			this.friends.add(friend);
		}
	}

	public List<Plant> getFavoritePlants() {
		return favoritePlants;
	}

	public void setFavoritePlants(List<Plant> favoritePlants) {
		this.favoritePlants = favoritePlants;
	}

	public void setFavoritePlants(Plant... favoritePlants) {
		this.favoritePlants.clear();
		for (Plant favoritePlant : favoritePlants) {
			this.favoritePlants.add(favoritePlant);
		}
	}

	public List<Garden> getGardens() {
		return gardens;
	}

	public void setGardens(List<Garden> gardens) {
		this.gardens = gardens;
	}

	public void setGardens(Garden... gardens) {
		this.gardens.clear();
		for (Garden garden : gardens) {
			this.gardens.add(garden);
		}
	}

	/* Methods */

	public void addConversations(List<Conversation> conversations) {
		this.conversations.addAll(conversations);
	}

	public void addConversations(Conversation... conversations) {
		for (Conversation conversation : conversations) {
			this.conversations.add(conversation);
		}
	}

	public void addFriends(List<UserAccount> friends) {
		this.friends.addAll(friends);
	}

	public void addFriends(UserAccount... friends) {
		for (UserAccount friend : friends) {
			this.friends.add(friend);
		}
	}

	public void addFavoritePlants(List<Plant> favoritePlants) {
		this.favoritePlants.addAll(favoritePlants);
	}

	public void addFavoritePlants(Plant... favoritePlants) {
		for (Plant favoritePlant : favoritePlants) {
			this.favoritePlants.add(favoritePlant);
		}
	}

	public void addGardens(List<Garden> gardens) {
		this.gardens.addAll(gardens);
	}

	public void addGardens(Garden... gardens) {
		for (Garden garden : gardens) {
			this.gardens.add(garden);
		}
	}
}
