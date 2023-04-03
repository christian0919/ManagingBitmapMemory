
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
		// bitPosition, positionArray
		mapabits.SetBit(0, 0);
		mapabits.SetBit(1, 0);
		mapabits.SetBit(3, 0);
		mapabits.SetBit(4, 0);
		mapabits.SetBit(5, 0);
		mapabits.SetBit(3, 1);
		mapabits.SetBit(4, 1);
		mapabits.SetBit(5, 1);
		mapabits.PrintMap();
		mapabits.LookForHole(3);
		System.out.println(mapabits.LookForArrayPosition(66));
	}

}
