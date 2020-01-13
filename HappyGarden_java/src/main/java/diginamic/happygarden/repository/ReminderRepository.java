package diginamic.happygarden.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import diginamic.happygarden.model.Reminder;

public interface ReminderRepository extends JpaRepository<Reminder, Long>{

}
