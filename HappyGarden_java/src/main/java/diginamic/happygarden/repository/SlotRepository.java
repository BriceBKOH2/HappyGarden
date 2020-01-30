package diginamic.happygarden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diginamic.happygarden.model.Slot;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long>{

}
