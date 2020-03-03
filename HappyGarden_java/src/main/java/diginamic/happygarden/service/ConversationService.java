package diginamic.happygarden.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import diginamic.happygarden.model.Conversation;
import diginamic.happygarden.model.UserAccount;
import diginamic.happygarden.repository.ConversationRepository;

@Transactional
@Service
public class ConversationService extends AbstractService<Conversation, Long, ConversationRepository>{
	
	public List<Conversation> findByUserId(Long id) {
		return repo.findAllByUserId(id);
	}
	
	public Long countNbCOnversationsByUserId(Long id) {
		return repo.countByUserId(id);
	}
//	
//	public List<UserAccount> findUsersByConvId(Long id) {
//		return repo.findAllUserAccountbyConversationId(id);
//	}
}
