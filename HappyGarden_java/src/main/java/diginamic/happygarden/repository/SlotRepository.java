package diginamic.happygarden.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.Reminder;
import diginamic.happygarden.model.Slot;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long>{

	@Query("select s.reminders from Slot s where s.id = :id")
	public List<Reminder> getRemindersFromId(Long id);

}
