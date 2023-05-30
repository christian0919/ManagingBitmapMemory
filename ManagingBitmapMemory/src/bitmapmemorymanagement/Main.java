
package bitmapmemorymanagement;

import gui.MainView;

/**
 * @author christian0919
 */
public class Main {

	
	public static void main(String[] args) {	
	//Launch view

		MainView frame = new MainView();
		frame.setVisible(true);

	//check bitmap class
		BitMap mapabits= new BitMap();
		// bitPosition, positionArray

		mapabits.DispatchProcess(200, "empanada");
		mapabits.PrintMap();
		mapabits.DispatchProcess(300, "angel");
		//mapabits.PrintMap();
		mapabits.UndispatchProcess("angel");
		//mapabits.PrintMap();
		


		

	}

}
