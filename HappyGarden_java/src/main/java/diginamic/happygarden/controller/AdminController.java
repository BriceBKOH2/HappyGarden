package diginamic.happygarden.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.exception.AlreadyExistException;
import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.GrowthRate;
import diginamic.happygarden.model.Plant;
import diginamic.happygarden.model.Garden;
import diginamic.happygarden.model.Season;
import diginamic.happygarden.model.Slot;
import diginamic.happygarden.model.UserAccount;
import diginamic.happygarden.model.UserRight;
import diginamic.happygarden.model.UserRole;
import diginamic.happygarden.service.PlantService;
import diginamic.happygarden.service.UserAccountService;
import diginamic.happygarden.service.UserRightService;
import diginamic.happygarden.service.UserRoleService;//@PreAuthorize("admnistration")

@RestController
@RequestMapping("/Admin")
public class AdminController {

	// TODO : changer de place ces constantes > entity ou enum
	/* Role Constant */

	public static final String BASIC = "Basic";
	public static final String ADMIN = "Admin";

	/* Right Constant */
	public static final String RIGHT_COMMENT = "Comment";
	public static final String RIGHT_MESSAGE = "Message";
	public static final String RIGHT_ADMINISTRATION = "administration";
	public static final String RIGHT_ACCOUNT_SUPPRESION = "account_suppression";
	public static final String RIGHT_PLANT_SUPPRESSION = "plant_suppression";
	public static final String RIGHT_PLANT_ADDITION = "plant_addition";
	public static final String RIGHT_PLANT_MODIFICATION = "plant_modification";

	@Autowired
	private UserRightService userRightServ;

	@Autowired
	private UserRoleService userRoleServ;

	@Autowired
	private UserAccountService userAccServ;

	@Autowired
	private PlantService plantServ;

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
			UserRight userRightBasic = new UserRight(RIGHT_COMMENT);
			userRightsBasic.add(userRightBasic);
			userRightBasic = new UserRight(RIGHT_MESSAGE);
			userRightsBasic.add(userRightBasic); /* Saving user rights in DataBase */
			userRightServ.saveAll(userRightsBasic); /* Saving role basic for regular users in DataBase */
			UserRole userRoleBasic = new UserRole(BASIC, userRightsBasic);
			userRoleServ.save(userRoleBasic);
		}
		try {
			userRoleServ.findByName(ADMIN);
		} catch (NotFoundException e) {
			List<UserRight> userRightsAdmin = new ArrayList<UserRight>();
			UserRight userRightAdmin = new UserRight(RIGHT_ADMINISTRATION);
			userRightsAdmin.add(userRightAdmin);
			userRightAdmin = new UserRight(RIGHT_ACCOUNT_SUPPRESION);
			userRightsAdmin.add(userRightAdmin);
			userRightAdmin = new UserRight(RIGHT_PLANT_SUPPRESSION);
			userRightsAdmin.add(userRightAdmin);
			userRightAdmin = new UserRight(RIGHT_PLANT_ADDITION);
			userRightsAdmin.add(userRightAdmin);
			userRightAdmin = new UserRight(RIGHT_PLANT_MODIFICATION);
			userRightsAdmin.add(userRightAdmin); /* Saving admin rights in DataBase */
			userRightServ.saveAll(userRightsAdmin); /* Saving role admin for regular users in DataBase */
			userRightsAdmin.addAll(userRoleServ.findByName(BASIC).getUserRights());
			UserRole userRoleAdmin = new UserRole(ADMIN, userRightsAdmin);
			userRoleServ.save(userRoleAdmin);
		}
		try {
			userAccServ.findByNickname("admin");
		} catch (NotFoundException e) {
			/* Saving a admin user in DataBase */
			UserAccount userAccAdmin = new UserAccount("admin", "admin", "admin", userRoleServ.findByName(ADMIN));
			userAccAdmin.setPassword("admin");
			userAccServ.save(userAccAdmin);
		}
		try {
			userAccServ.findByNickname("testNickname");
		} catch (NotFoundException e) {
			/* Saving a basic user in DataBase */
			UserAccount userAccBasic = new UserAccount("testFirstName", "testLastName", "testNickname",
					userRoleServ.findByName(BASIC));
			userAccBasic.setPassword("testPassword");
			userAccServ.save(userAccBasic);
		}
		// Ajoût de plantes randomn pour la BDD
		if (plantServ.count() == 0) {
			System.out.println(plantServ.count());
			ArrayList<Season> season = new ArrayList<>();
			season.add(Season.FALL);
			Plant lierre = new Plant("Hedera helix", "Lierre", "Lierre", "None", 91.1F, "Long", "lierre.jpg",
					"Mid Spring", GrowthRate.RAPID, season);
			Plant basilic = new Plant("Ocimum basilicum", "Basilic", "Basilic", "None", 31.1F, "Long", "basilic.jpg",
					"Mid Spring", GrowthRate.RAPID, season);
			Plant camomille = new Plant("Chamaemelum nobile", "Camomille", "Camomille", "None", 91.1F, "Long",
					"camomille.jpg", "Mid Spring", GrowthRate.RAPID, season);
			Plant livewort = new Plant("Hepatica nobilis", "Livewort", "Livewort", "None", 40.6F, "Long",
					"liverwort.jpg", "Mid Spring", GrowthRate.RAPID, season);
			Plant coquelicot = new Plant("Papaver rhoeas", "Coquelicot", "Coquelicot", "Yes", 50F, "Long",
					"coquelicot.jpg", "Mid Spring", GrowthRate.RAPID, season);
			Plant lavande = new Plant("Lavandula", "Lavande", "Lavande", "None", 91.1F, "Long", "lavande.jpg",
					"Mid Spring", GrowthRate.RAPID, season);
			Plant anemone = new Plant("Anemone coronaria", "Anemone", "Anemone", "None", 23.1F, "Long", "anemone.jpg",
					"Mid Spring", GrowthRate.RAPID, season);
			Plant cactus = new Plant("Cactaceae", "Cactus", "Cactus", "None", 150.7F, "Long", "cactus.jpg",
					"Mid Spring", GrowthRate.RAPID, season);
			Plant succulente = new Plant("Asphodelaceae", "Succulente", "Succulente", "None", 8.7F, "Long",
					"succulente.jpg", "Mid Spring", GrowthRate.RAPID, season);
			Plant tournesol = new Plant("Helianthus annuus", "Tournesol", "Tournesol", "None", 150.7F, "Long",
					"tournesol.jpg", "Mid Spring", GrowthRate.RAPID, season);

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

			Slot one = new Slot(new Date(2019, 05, 21), lierre);
			Slot two = new Slot(new Date(2019, 06, 04), basilic);
			Slot three = new Slot(new Date(2018, 07, 22), camomille);
			Slot four = new Slot(new Date(2019, 05, 30), livewort);
			Slot five = new Slot(new Date(2018, 07, 21), coquelicot);
			Slot six = new Slot(new Date(2019, 10, 13), lavande);
			Slot seven = new Slot(new Date(2019, 11, 15), anemone);
			Slot height = new Slot(new Date(2018, 12, 01), cactus);
			Slot nine = new Slot(new Date(2020, 01, 02), succulente);
			Slot ten = new Slot(new Date(2020, 05, 07), tournesol);

			Set<Garden> gardensMachin = new HashSet<>();

			UserAccount machin = new UserAccount("Machin", "Truc", "Bidule", userRoleServ.findByName(BASIC));
			machin.setPassword("testPassword");
			machin.setGardens(gardensMachin);
			userAccServ.save(machin);
		}

		return userAccServ.findAll();
	}
}