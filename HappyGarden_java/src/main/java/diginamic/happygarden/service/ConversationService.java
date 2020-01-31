package diginamic.happygarden.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import diginamic.happygarden.model.Conversation;
import diginamic.happygarden.repository.ConversationRepository;

@Transactional
@Service
public class ConversationService extends AbstractService<Conversation, Long, ConversationRepository>{
	
}
