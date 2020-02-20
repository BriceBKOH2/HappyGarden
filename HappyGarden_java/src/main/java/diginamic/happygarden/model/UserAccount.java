package diginamic.happygarden.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/** The list of information contained in a User's account **/
@Entity
public class UserAccount implements HibernateEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String firstname;

	@NotBlank
	private String lastname;

	@Column(unique = true)
	@NotBlank
	private String nickname;
	
	@NotBlank
	private String password;
	
	@NotNull
	@ManyToOne
	private UserRole userRole;

	@JsonManagedReference("user_conversations")
	@JsonBackReference("user_msg")
	@ManyToMany(mappedBy = "users")
	private List<Conversation> conversations = new ArrayList<>();
	
	@ElementCollection
	private List<String> friends  = new ArrayList<>();

	@ManyToMany
	private List<Plant> usedPlants = new ArrayList<>();
	
	@ManyToMany
	private Set<Plant> favoritePlants = new HashSet<>();

	@JsonManagedReference("user_gardens")
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Garden> gardens = new HashSet<>();

	/* Constructors */

	public UserAccount() {
		super();
		this.userRole = new UserRole();
	}
	
	public UserAccount(String firstName, String lastName, String nickname,UserRole userRole) {
		super();
		this.firstname = firstName;
		this.lastname = lastName;
		this.nickname = nickname;
		this.userRole = userRole;
	}


	/* Getters Setters */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastName) {
		this.lastname = lastName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String pseudonyme) {
		this.nickname = pseudonyme;
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

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
	
	public List<Plant> getUsedPlants() {
		return usedPlants;
	}

	public void setUsedPlants(List<Plant> usedPlants) {
		this.usedPlants = usedPlants;
	}

	public Set<Plant> getFavoritePlants() {
		return favoritePlants;
	}

	public void setFavoritePlants(Set<Plant> favoritePlants) {
		this.favoritePlants = favoritePlants;
	}

	public Set<Garden> getGardens() {
		return gardens;
	}

	public void setGardens(Set<Garden> gardens) {
		this.gardens = gardens;
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

	public void addFriends(List<String> friends) {
		this.friends.addAll(friends);
	}

	public void addFriends(String... friends) {
		for (String friend : friends) {
			this.friends.add(friend);
		}
	}
	
	public void addUsedPlants(List<Plant> usedPlants) {
		this.usedPlants.addAll(usedPlants);
	}

	public void addUsedPlants(Plant... usedPlants) {
		for (Plant usedPlant : usedPlants) {
			this.usedPlants.add(usedPlant);
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
