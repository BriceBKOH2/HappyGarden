package diginamic.happygarden;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
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
