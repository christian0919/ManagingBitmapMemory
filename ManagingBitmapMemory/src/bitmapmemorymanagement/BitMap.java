package bitmapmemorymanagement;

public class BitMap {

	private byte[] map = new byte[128];
	private byte specialBytes[]= {(byte)1,(byte)2,(byte)4,(byte)8,(byte)16,(byte)32,(byte)64,(byte) 128};

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
	
}
