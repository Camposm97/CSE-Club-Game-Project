package gui;



public class LogEntry {
	String entry;
	LogEntry older;
	
	LogEntry (String string){
		this.entry = string;
	}

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public LogEntry getOlder() {
		return older;
	}

	public void setOlder(LogEntry older) {
		this.older = older;
	}
	
}
