
package bitmapmemorymanagement;

import gui.MainView;

/**
 * @author christian0919
 */
public class Main {

	
	public static void main(String[] args) {	
	//Launch view
		/**
		MainView frame = new MainView();
		frame.setVisible(true);
		**/
		
	//check bitmap class
		BitMap mapabits= new BitMap();
		
		System.out.println(mapabits.LookForArrayPosition(66));
	}

}
