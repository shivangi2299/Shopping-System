package sys;

import java.util.ArrayList;
import java.util.List;

//This class contains the history of transactions for the given user
public class Logger {

	// Transactions list
	private List<String> logs;

	public Logger() {
		this.logs = new ArrayList<>();
	}

	// Add a log entry
	public void addLog(String log) {
		logs.add(log);
	}

	// Getters/Setters
	public List<String> getHistory() {
		return logs;
	}
}