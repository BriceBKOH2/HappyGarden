package diginamic.happygarden.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import diginamic.happygarden.controller.AdminController;
import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.UserAccount;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserAccountTest {
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private UserAccountRepository repo;
	
	@Autowired
	private UserRoleRepository userRoleRepo;
	
	/* Test findAllByFirstnameIgnoreCase */
	@Test
	public void findAllByFirstnameIgnoreCaseCorrect() throws NotFoundException {
		UserAccount user = new UserAccount("TESTUNIT", "TESTUNIT", "TESTUNIT",userRoleRepo.getDefaultRole(AdminController.BASIC).orElseThrow(() -> new NotFoundException("Cannot retrieve default role.")));
		user.setPassword("TESTUNIT");
		entityManager.persist(user);
		entityManager.flush();
		
		user = repo.findAllByFirstnameIgnoreCase("testunit").get(0);
		
		Assert.assertEquals("TESTUNIT",user.getFirstname());
		
	}

}
