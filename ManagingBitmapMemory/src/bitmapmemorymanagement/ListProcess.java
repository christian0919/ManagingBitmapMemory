package bitmapmemorymanagement;
import java.util.ArrayList;
import java.util.List;

public class ListProcess {
	List<String[]> processList = new ArrayList<String[]>();
	
	
	public ListProcess() {
		this.processList = new ArrayList<String[]>();
	}

	public void addProcessToList(String nm , String bg , String sz){
		processList.add(new String[]{nm,bg,sz});
	}
	
	public void printProcessList(){
		for(String p[] :  processList) {
			System.out.println("Name:"+p[0]+" Begin:"+p[1]+" Size:"+p[2]);
		}
	}
	
	public void deleteProcessFromList(String name){
		for(int i = 0; i < processList.size(); i++ ) {
			if(name == processList.get(i)[0]){
				processList.remove(i);
				System.out.println("deleted");
				break;
			}
		}
	}
	public void deleteAllList(){
		processList.clear();
	}
}
