package diginamic.happygarden;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HappyGardenJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyGardenJavaApplication.class, args);
		/* 
		 * public List<UserAccount> intiateDB() in AdminController is launched 
		 * with @EventListener(ApplicationReadyEvent.class) when 
		 * SpringApplication is done with configuration.
		*/
	}

}
