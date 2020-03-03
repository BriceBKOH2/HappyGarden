package diginamic.happygarden.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.Conversation;
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
	
	@PutMapping(name ="/update", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Conversation update(@RequestBody Conversation conversation) throws NotFoundException {
		System.out.println(conversation);
		return service.update(conversation);
	}
	
}
