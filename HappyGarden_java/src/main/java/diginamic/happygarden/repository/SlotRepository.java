package diginamic.happygarden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.Slot;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long>{

	@Query("SELECT count(s) from Slot s join s.plantingArea p where p.id = :id")
	public Long countByPlantingAreaId(Long id);
}
