package diginamic.happygarden.model;

public enum UserRights {
	
	ROLEBASIC("Basic"),
	ROLEADMIN("Admin"),
	
	/* Right Constant */
	RIGHT_COMMENT("Comment"),
	RIGHT_MESSAGE("Message"),
	RIGHT_ADMINISTRATION("administration"),
	RIGHT_ACCOUNT_SUPPRESION("account_suppression"),
	RIGHT_PLANT_SUPPRESSION("plant_suppression"),
	RIGHT_PLANT_ADDITION("plant_addition"),
	RIGHT_PLANT_MODIFICATION("plant_modification");
	
	String name;
	
	private UserRights(String name) {
		this.name = name;
	}
}
