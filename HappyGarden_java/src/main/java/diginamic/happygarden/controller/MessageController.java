package diginamic.happygarden.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.model.Message;
import diginamic.happygarden.service.MessageService;

@RestController
@RequestMapping("/Message")
public class MessageController extends AbstractCRUDController<Message, Long, MessageService>  {

	@GetMapping("/conv/{id}")
	public List<Message> findAllMessageByIdConv(@PathVariable Long id) {
		return service.findByIdConversation(id);
	}
}
