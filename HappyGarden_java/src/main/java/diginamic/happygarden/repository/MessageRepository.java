package diginamic.happygarden.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import diginamic.happygarden.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{

}
