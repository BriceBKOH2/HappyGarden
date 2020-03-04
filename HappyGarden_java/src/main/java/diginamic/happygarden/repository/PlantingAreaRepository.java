package diginamic.happygarden.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.PlantingArea;
import diginamic.happygarden.model.Reminder;

@Repository
public interface PlantingAreaRepository extends JpaRepository<PlantingArea, Long> {
	
	@Query("select p.reminders from PlantingArea p where p.id = :id")
	public List<Reminder> getRemindersFromId(Long id);

	
	public long countGardenById(Long id);
	


	
	
}
