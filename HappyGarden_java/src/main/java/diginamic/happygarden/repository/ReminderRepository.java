package diginamic.happygarden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.Reminder;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Long>{

}
