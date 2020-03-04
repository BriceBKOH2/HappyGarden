package diginamic.happygarden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diginamic.happygarden.model.Reminder;
import diginamic.happygarden.service.PlantingAreaService;
import diginamic.happygarden.service.ReminderService;
import diginamic.happygarden.service.SlotService;

@RestController
@RequestMapping("/Reminder")
public class ReminderController extends AbstractCRUDController<Reminder, Long, ReminderService> {
	
	@Autowired
	private PlantingAreaService plantingAreaService;
	
	@Autowired
	private SlotService slotService;
	
	/**
	 * Returns a list of all reminders linked to the planting area with the id specified.
	 * @param plantingAreaId
	 * @return
	 */
	@GetMapping("/area/{plantingAreaId}")
	public List<Reminder> getRemindersFromPlantingArea(@PathVariable Long plantingAreaId) {
		return plantingAreaService.getRemindersFromId(plantingAreaId);
	}
	
	/**
	 * Returns a list of all reminders linked to the planting area with the id specified.
	 * @param slotId
	 * @return
	 */
	@GetMapping("/slot/{slotId}")
	public List<Reminder> getRemindersFromSlot(@PathVariable Long slotId) {
		return slotService.getRemindersFromId(slotId);
	}

}
