package diginamic.happygarden.service;

import java.util.List;

import org.springframework.stereotype.Service;

import diginamic.happygarden.model.Reminder;
import diginamic.happygarden.model.Slot;
import diginamic.happygarden.repository.SlotRepository;

@Service
public class SlotService extends AbstractService<Slot, Long, SlotRepository> {

	public List<Reminder> getRemindersFromId(Long id) {
		return this.repo.getRemindersFromId(id);
	}

}
