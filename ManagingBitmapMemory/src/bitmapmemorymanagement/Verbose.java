package bitmapmemorymanagement;

public class Verbose {
	
	String message;	
	
	public Verbose(String message) {
		this.message = message;
	}

	public void ClearVerbose() {
		message = "";
	}
	
	public String GetVerbose(){
		return message;
	}
	
	public void AddToVerbose(String messageToAdd){
		message = message + messageToAdd;
	}
}
