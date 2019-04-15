package gui;


public class Log {
	
	LogEntry first;
	
	Log(){
		first = null;
	}
	public void addEntry(String string) {
		LogEntry entry = new LogEntry(string);
		if (first == null) {
			first = entry;
		}
		else {
			entry.setOlder(first);
		}
	}
	public String printToBattleLog() {
		String temp = new String();
		LogEntry current = first;
		while (current != null) {
			temp += ("<<{{ " + current.getEntry() + "}}>>\n");
			current = current.older;
		}
		return temp;
	}

}

