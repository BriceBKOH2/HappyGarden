package diginamic.happygarden.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.model.Conversation;
import diginamic.happygarden.model.UserAccount;
import diginamic.happygarden.service.ConversationService;

@RestController
@RequestMapping("/Conversation")
public class ConversationController extends AbstractCRUDController<Conversation, Long, ConversationService>{


	@GetMapping("/user/{id}")
	public List<Conversation> findAllConvByIdUser(@PathVariable Long id) {
		return service.findByUserId(id);
	}
	
//	@GetMapping("/users/{id}")
//	public List<UserAccount> findAllUsersByIdConv(@PathVariable Long id) {
//		return service.findUsersByConvId(id);
//	}
}
