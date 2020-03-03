package diginamic.happygarden.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.exception.AlreadyExistException;
import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.Conversation;
import diginamic.happygarden.model.Garden;
import diginamic.happygarden.model.GrowthRate;
import diginamic.happygarden.model.Message;
import diginamic.happygarden.model.Parcel;
import diginamic.happygarden.model.Plant;
import diginamic.happygarden.model.PlantUser;
import diginamic.happygarden.model.PlantingArea;
import diginamic.happygarden.model.Season;
import diginamic.happygarden.model.Slot;
import diginamic.happygarden.model.UserAccount;
import diginamic.happygarden.model.UserRight;
import diginamic.happygarden.model.UserRole;
import diginamic.happygarden.service.ConversationService;
import diginamic.happygarden.service.GardenService;
import diginamic.happygarden.service.MessageService;
import diginamic.happygarden.service.PlantService;
import diginamic.happygarden.service.PlantUserService;
import diginamic.happygarden.service.UserAccountService;
import diginamic.happygarden.service.UserRightService;
import diginamic.happygarden.service.UserRoleService;//@PreAuthorize("admnistration")

@RestController
@RequestMapping("/Admin")
public class AdminController {

	public static final String BASIC = "Basic";
	public static final String ADMIN = "Admin";

	@Autowired
	private UserRightService userRightServ;

	@Autowired
	private UserRoleService userRoleServ;

	@Autowired
	private UserAccountService userAccServ;

	@Autowired
	private PlantService plantServ;
	
	@Autowired
	private GardenService gardenServ;
	
	@Autowired
	private MessageService messageServ;
	
	@Autowired
	private ConversationService conversationServ;
	
	@Autowired
	private PlantUserService plantUserServ;
	
	
	/**
	 * Instantiate database with rights, roles, admin and basic user
	 * 
	 * @return
	 * @throws AlreadyExistException entity already exist in database
	 * @throws NotFoundException     entity doesn't exist in database
	 */
	@GetMapping(value = "/initiateDB")
	@EventListener(ApplicationReadyEvent.class)
	public List<UserAccount> intiateDB() throws NotFoundException, AlreadyExistException {
		try {
			userRoleServ.findByName(BASIC);
		} catch (NotFoundException e) {
			List<UserRight> userRightsBasic = new ArrayList<>();
			UserRight userRightBasic = new UserRight(UserRight.RIGHT_COMMENT);
			userRightsBasic.add(userRightBasic);
			userRightBasic = new UserRight(UserRight.RIGHT_MESSAGE);
			userRightsBasic.add(userRightBasic); /* Saving user rights in DataBase */
			userRightServ.saveAll(userRightsBasic); /* Saving role basic for regular users in DataBase */
			UserRole userRoleBasic = new UserRole(BASIC, userRightsBasic);
			userRoleServ.save(userRoleBasic);
		}
		
		try {
			userRoleServ.findByName(ADMIN);
		} catch (NotFoundException e) {
			List<UserRight> userRightsAdmin = new ArrayList<UserRight>();
			UserRight userRightAdmin = new UserRight(UserRight.RIGHT_ADMINISTRATION);
			userRightsAdmin.add(userRightAdmin);
			userRightAdmin = new UserRight(UserRight.RIGHT_ACCOUNT_SUPPRESSION);
			userRightsAdmin.add(userRightAdmin);
			userRightAdmin = new UserRight(UserRight.RIGHT_PLANT_SUPPRESSION);
			userRightsAdmin.add(userRightAdmin);
			userRightAdmin = new UserRight(UserRight.RIGHT_PLANT_ADDITION);
			userRightsAdmin.add(userRightAdmin);
			userRightAdmin = new UserRight(UserRight.RIGHT_PLANT_MODIFICATION);
			userRightsAdmin.add(userRightAdmin); /* Saving admin rights in DataBase */
			userRightServ.saveAll(userRightsAdmin); /* Saving role admin for regular users in DataBase */
			userRightsAdmin.addAll(userRoleServ.findByName(BASIC).getUserRights());
			UserRole userRoleAdmin = new UserRole(ADMIN, userRightsAdmin);
			userRoleServ.save(userRoleAdmin);
		}
		
		//adding admin account to DB
		try {
			userAccServ.findByNickname("admin");
		} catch (NotFoundException e) {
			/* Saving a admin user in DataBase */
			UserAccount userAccAdmin = new UserAccount("admin", "admin", "admin", userRoleServ.findByName(ADMIN));
			userAccAdmin.setPassword("admin");
			userAccServ.save(userAccAdmin);
		}
		
		// adding an user account for testing
		try {
			userAccServ.findByNickname("testNickname");
		} catch (NotFoundException e) {
			/* Saving a basic user in DataBase */
			UserAccount userAccBasic = new UserAccount("testFirstName", "testLastName", "testNickname",
					userRoleServ.findByName(BASIC));
			userAccBasic.setPassword("testPassword");
			userAccServ.save(userAccBasic);
		}
		
		// adding random plants for DB
		if (plantServ.findByCommonNameOrScientificName("Cactus").isEmpty()) {
		ArrayList<Season> season = new ArrayList<>();
		season.add(Season.FALL);
		Plant lierre = new Plant("Hedera helix", "Lierre", "Lierre", "None", 91.1F, "Long", "lierre.jpg", "Mid Spring", GrowthRate.RAPID, season);
		Plant basilic = new Plant("Ocimum basilicum", "Basilic", "Basilic", "None", 31.1F, "Long", "basilic.jpg", "Mid Spring", GrowthRate.RAPID, season);
		Plant camomille = new Plant("Chamaemelum nobile", "Camomille", "Camomille", "None", 91.1F, "Long", "camomille.jpg", "Mid Spring", GrowthRate.RAPID, season);
		Plant livewort = new Plant("Hepatica nobilis", "Livewort", "Livewort", "None", 40.6F, "Long", "liverwort.jpg", "Mid Spring", GrowthRate.RAPID, season);
		Plant coquelicot = new Plant("Papaver rhoeas", "Coquelicot", "Coquelicot", "Yes", 50F, "Long", "coquelicot.jpg", "Mid Spring", GrowthRate.RAPID, season);
		Plant lavande = new Plant("Lavandula", "Lavande", "Lavande", "None", 91.1F, "Long", "lavande.jpg", "Mid Spring", GrowthRate.RAPID, season);
		Plant anemone = new Plant("Anemone coronaria", "Anemone", "Anemone", "None", 23.1F, "Long", "anemone.jpg", "Mid Spring", GrowthRate.RAPID, season);
		Plant cactus = new Plant("Cactaceae", "Cactus", "Cactus", "None", 150.7F, "Long", "cactus.jpg", "Mid Spring", GrowthRate.RAPID, season);
		Plant succulente = new Plant("Asphodelaceae", "Succulente", "Succulente", "None", 8.7F, "Long", "succulente.jpg", "Mid Spring", GrowthRate.RAPID, season);
		Plant tournesol = new Plant("Helianthus annuus", "Tournesol", "Tournesol", "None", 150.7F, "Long", "tournesol.jpg", "Mid Spring", GrowthRate.RAPID, season);
		
		plantServ.save(lierre);
		plantServ.save(basilic);
		plantServ.save(camomille);
		plantServ.save(livewort);
		plantServ.save(coquelicot);
		plantServ.save(lavande);
		plantServ.save(anemone);
		plantServ.save(cactus);
		plantServ.save(succulente);
		plantServ.save(tournesol);
		
		}
		
		// Adding PLant User
		if (plantUserServ.findByCommonNameOrScientificName("Cactus").isEmpty()) {
			ArrayList<Season> season = new ArrayList<>();
			season.add(Season.FALL);
		PlantUser rose = new PlantUser("Rosa", "Rose", "Rose", "None", 150.7F, "Long", "rose.jpg", "Mid Spring", GrowthRate.RAPID, season, "Estelle");
		plantUserServ.save(rose);
		}
		
		// Ajoût de jardins randomn pour la BDD
		try {
			userAccServ.findByNickname("Estelle");
			userAccServ.findByNickname("Jade");
		}
		catch (NotFoundException e) {
			Slot slot = new Slot(Date.valueOf(LocalDate.now()), plantServ.findByCommonNameOrScientificName("Cactus").get(0));
			ArrayList<Slot> slots = new ArrayList<>();
			slots.add(slot);
			
			Parcel parcel = new Parcel("nouvelle parcelle", 19L, 157486532156L, slots);
			ArrayList<PlantingArea> parcels = new ArrayList<>();
			parcels.add(parcel);
			slot.setPlantingArea(parcel);
			
			Garden jardinUn = new Garden("plantes aromatiques", parcels);
			parcel.setGarden(jardinUn);
			
			
			UserAccount jade = new UserAccount("Jade", "Acc", "Jade", userRoleServ.findByName(ADMIN));
			jade.setPassword("jade");
			jade.setProfileImg("profil_2.jpg");
			jade.addFriends("Estelle");
			userAccServ.save(jade);
			
			UserAccount estelle = new UserAccount("Estelle", "IDEE", "Estelle", userRoleServ.findByName(ADMIN));
			estelle.setPassword("estelle");
			estelle.setProfileImg("profil.jpg");
			
			
			// Ajoût Amis
			List<String> friends = new ArrayList<String>();
			friends.add(jade.getNickname());
			estelle.addFriends(friends);
			
			userAccServ.save(estelle);
			

			
			UserAccount jordi = new UserAccount("Jordi", "Mage", "Jordi", userRoleServ.findByName(ADMIN));
			jordi.setPassword("jordi");
			jordi.setProfileImg("profil_3.jpg");
			userAccServ.save(jordi);
			
			
			//TEST
			Conversation conv = new Conversation();
			conv.addUser(estelle);
			conv.addUser(jade);
			Message msgJade = new Message("Coucou Estelle.", jade, conv);
			Message msgEstelle = new Message("Coucou Jade.", estelle, conv);
			Message msgJade2 = new Message("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna 			aliqua. Ut enim ad minim veniam.", jade, conv);
			Message msgEstelle2 = new Message("dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna 			aliqua. Ut enim ad minim veniam, quis nostrud", estelle, conv);
			
			conversationServ.save(conv);
			messageServ.save(msgJade);
			messageServ.save(msgEstelle);
			messageServ.save(msgJade2);
			messageServ.save(msgEstelle2);
			
			
			// Conversation Estelle Jade
//			ArrayList<Message> messagesEstelleJade = new ArrayList<Message>();
//			
//			Message msgEstelle = new Message("Coucou Jade.", estelle);
//			messageServ.save(msgEstelle);
//			messagesEstelleJade.add(msgEstelle);
//			
//			Message msgJade = new Message("Coucou Estelle.", jade);
//			messagesEstelleJade.add(msgJade);
//			messageServ.save(msgJade);
//			
//			Conversation conversationEstelleJade = new Conversation(messagesEstelleJade);
//			
//			List<UserAccount> usersConvEstelleJade = new ArrayList<UserAccount>();
//			usersConvEstelleJade.add(jade);
//			usersConvEstelleJade.add(estelle);
//			conversationEstelleJade.setUsers(usersConvEstelleJade);
//			
//			// Conversation Estelle Jordi
//			ArrayList<Message> messagesEstelleJordi = new ArrayList<Message>();
//			
//			Message msgEstellej = new Message("Coucou Jade.", estelle);
//			messageServ.save(msgEstellej);
//			messagesEstelleJordi.add(msgEstellej);
//			
//			Message msgJordi = new Message("Coucou Estelle.", jordi);
//			messagesEstelleJordi.add(msgJordi);
//			messageServ.save(msgJordi);
//			
//			Conversation conversationEstelleJordi = new Conversation(messagesEstelleJordi);
//			
//			List<UserAccount> usersConvEstelleJordi = new ArrayList<UserAccount>();
//			usersConvEstelleJordi.add(jordi);
//			usersConvEstelleJordi.add(estelle);
//			conversationEstelleJordi.setUsers(usersConvEstelleJordi);
//			
//			
//			
//			
			jardinUn.setUser(estelle);
//			
			gardenServ.save(jardinUn);
//			conversationServ.save(conversationEstelleJade);
//			conversationServ.save(conversationEstelleJordi);
//			
//			Message msgJordi2 = new Message("Ceci est un deuxième test.", jordi);
//
//			messageServ.save(msgJordi2);
//			conversationEstelleJordi.addMessages(msgJordi2);
//			conversationServ.update(conversationEstelleJordi);
				
		}
		return userAccServ.findAll();
	}
	
	@GetMapping("users")
	public List<UserAccount> getUsers() {
		return userAccServ.findAll();
	}
	
	
	
}