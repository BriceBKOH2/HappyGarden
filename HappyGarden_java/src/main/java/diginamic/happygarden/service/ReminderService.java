package diginamic.happygarden.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import diginamic.happygarden.model.Reminder;
import diginamic.happygarden.repository.ReminderRepository;

@Transactional
@Service
public class ReminderService extends AbstractService<Reminder, Long, ReminderRepository> {

}
