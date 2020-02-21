package diginamic.happygarden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.model.Conversation;
import diginamic.happygarden.model.Message;
import diginamic.happygarden.service.ConversationService;
import diginamic.happygarden.service.MessageService;

@RestController
@RequestMapping("/Message")
public class MessageController extends AbstractCRUDController<Message, Long, MessageService>  {
	
	@Autowired
	ConversationService convService;

	@GetMapping("/conv/{id}")
	public List<Message> findAllMessageByIdConv(@PathVariable Long id) {
		return service.findByIdConversation(id);
	}
	
	@GetMapping(value = "/{id}/count")
	public Long countMessagesByConvId(@PathVariable Long id) {
		return service.countMessagesByConvId(id);
	}
	
	//@GetMapping(value = "/{id}/save")
//	@PutMapping(consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
//	public Conversation saveMessageAndUpdateConversation(@PathVariable Message message, @PathVariable("app") String app, @PathVariable("fnm") String fnm) {
//		 this.save(message);
//		 Conversation conv = 
//		 return this.convService.update(entity)
//	}
}
