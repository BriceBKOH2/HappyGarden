package diginamic.happygarden.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import diginamic.happygarden.model.Conversation;

public interface ConversationRepository extends JpaRepository<Conversation, Long>{

}
