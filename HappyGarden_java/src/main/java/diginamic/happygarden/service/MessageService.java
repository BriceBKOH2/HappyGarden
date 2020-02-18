package diginamic.happygarden.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import diginamic.happygarden.model.Message;
import diginamic.happygarden.repository.MessageRepository;

@Transactional
@Service
public class MessageService extends AbstractService<Message, Long, MessageRepository> {

	public List<Message> findByIdConversation(Long id) {
		return repo.findByIdConversation(id);
	}
}
