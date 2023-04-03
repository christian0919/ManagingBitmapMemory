package bitmapmemorymanagement;
import java.util.ArrayList;

public class BitMap {

	private byte[] map = new byte[128];
	private byte specialBytes[]= {(byte)1,(byte)2,(byte)4,(byte)8,(byte)16,(byte)32,(byte)64,(byte) 128};
	
	private  ArrayList<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer> inner = new ArrayList<Integer>();        

	public BitMap() {
		InitializeMap();	
	}

	
	public boolean BitState(int position,int index){
		//**Check if the bit in the position is seated or not**//
		 if ((map[index] & (1 <<position)) != 0)
	         return true;   
	     else
	         return false;		
	}
	
	private void InitializeMap(){
		for (int i = 0; i < map.length; i++) {
			map[i] = (byte) 0;
			/** Muestra los bits en forma binaria
			String binaryByte = String.format("%8s", Integer.toBinaryString(map[i] & 0xFF)).replace(' ', '0');
			System.out.println(binaryByte);
			**/
		}
	}
	
	public int LookForArrayPosition(int wantedBit){
		int positionArray=0;
		for( positionArray=0 ; positionArray <= 127 ; positionArray++){
			if(  wantedBit >= 8*positionArray && wantedBit <= (8*(positionArray+1))-1 ) {
				return positionArray;
			}
		}
		return positionArray;
	}
	
	public void SetBit(int bitPosition,int positionArray) {
		map[positionArray]= (byte) (map[positionArray] | specialBytes[bitPosition]);
	}
	
	public void UnsetBit(int bitPosition,int positionArray) {
		map[positionArray]= (byte) (map[positionArray] ^ specialBytes[bitPosition]);
	}
	
	public void PrintMap() {
		for(int i = 0 ; i < 128 ; i++) {
			String binaryByte = String.format("%8s", Integer.toBinaryString(map[i] & 0xFF)).replace(' ', '0');
			System.out.println(binaryByte);
		}
	}
	
	public int[] LookForHole(int holeSize) {
		int check = 0;
		int beginPosition = 0;
		int index=0;
		int[] ans= new int[2];
		for(int i = 0 ; i < 128 ; i++) {
			for (int j = 0 ; j < 8 ; j++) {
				if(!BitState( j, i)) {
					check ++;
					if(check==1) {
						beginPosition=j;
						index=i;
					}
					if(check == holeSize) {
						System.out.println("beginPosition:"+beginPosition+" \nindex:"+index);
						ans[0] = beginPosition;
						ans[1] = index;
						return ans;
					}
				}else {
					check = 0;
				}
			}
		}
		ans[0] = -1;
		ans[1] = -1;
		System.out.println("no hole finded");
		return ans;
	}
	
}
