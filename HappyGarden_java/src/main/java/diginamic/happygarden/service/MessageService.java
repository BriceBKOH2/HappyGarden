package diginamic.happygarden.service;

import org.springframework.stereotype.Service;

import diginamic.happygarden.model.Message;
import diginamic.happygarden.repository.MessageRepository;

@Service
public class MessageService extends AbstractService<Message, Long, MessageRepository> {
	
//	@Autowired
//	MessageRepository repo;
}
