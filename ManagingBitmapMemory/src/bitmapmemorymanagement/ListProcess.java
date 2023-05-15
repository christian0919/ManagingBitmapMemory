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
				System.out.println("Deleted");
				break;
			}
		}
		System.out.println("No deleted");
	}
	public void deleteAllList(){
		processList.clear();
	}
	
	
	public int ValidateProcessExist(String name){
		for(int i = 0; i < processList.size(); i++ ) {
			if(name == processList.get(i)[0]){
				return i;
				}
		}
		return -1;
	}
	
	public int[] getProcessIndex(int i){
		String[] str = processList.get(i)[1].split(",");
		int[] values = {Integer.parseInt(str[0]),Integer.parseInt(str[1])};
		return values;
	}
	
	public int getProcessSize(int i){
		return Integer.parseInt(processList.get(i)[2]);
	}
	
}
