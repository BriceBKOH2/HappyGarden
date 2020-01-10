package happygarden.model;

import java.util.List;

public interface ReminderManager {

	public void addReminders(List<Reminder> reminders);

	public void addReminders(Reminder... reminders);
	
	/*ToDo*/
//	public void removeReminders(List<Reminder> reminders);
//	
//	public void removeReminder(Reminder reminder);
}
