package bitmapmemorymanagement;

public class BitMap {
 
	private byte[] map = new byte[128];
	private byte specialBytes[] = { (byte) 1, (byte) 2, (byte) 4, (byte) 8, (byte) 16, (byte) 32, (byte) 64,
			(byte) 128 };
	public ListProcess listProcess = new ListProcess();
	
	public Verbose verbose = new Verbose("");
	
	public boolean state = false;

	public BitMap() {
		InitializeMap();
	}

	public boolean BitState(int position, int index,int  verb) {
		// **Check if the bit in the position is seated or not**//
		String bin = String.format("%8s", Integer.toBinaryString(map[index] & 0xFF)).replace(' ', '0');;
		if ((map[index] & (1 << position)) != 0) {
			if (verb == 1) {
			verbose.AddToVerbose("\n"+(bin+" &"+ " 1<<"+position + " = 1"));
			System.out.println(bin+" &"+ " 1<<"+position + " = 1");
			}
			return true;
		}else {
			if (verb ==1) {
			verbose.AddToVerbose("\n"+(bin+" &"+ " 1<<"+position + " = 0"));
			System.out.println(bin+" &"+ " 1<<"+position + " = 0");
			}
			return false;}
	}

	private void InitializeMap() {
		for (int i = 0; i < map.length; i++) {
			map[i] = (byte) 0;
		}
	}

	public int LookForArrayPosition(int wantedBit) {
		int positionArray = 0;
		for (positionArray = 0; positionArray <= 127; positionArray++) {
			if (wantedBit >= 8 * positionArray && wantedBit <= (8 * (positionArray + 1)) - 1) {
				return positionArray;
			}
		}
		return positionArray;
	}

	public void SetBit(int bitPosition, int positionArray) {
		String bin1 = String.format("%8s", Integer.toBinaryString(map[positionArray] & 0xFF)).replace(' ', '0');
		String bin2 = String.format("%8s", Integer.toBinaryString(specialBytes[bitPosition] & 0xFF)).replace(' ', '0');
		String msj = (bin1 +" | "+ bin2);
		map[positionArray] = (byte) (map[positionArray] | specialBytes[bitPosition]);
		bin1 = String.format("%8s", Integer.toBinaryString(map[positionArray] & 0xFF)).replace(' ', '0');
		System.out.print("\n" +msj +" = "+ bin1);
		verbose.AddToVerbose("\n" +msj +" = "+ bin1);
	}

	public void UnsetBit(int bitPosition, int positionArray) {
		String bin1 = String.format("%8s", Integer.toBinaryString(map[positionArray] & 0xFF)).replace(' ', '0');
		String bin2 = String.format("%8s", Integer.toBinaryString(specialBytes[bitPosition] & 0xFF)).replace(' ', '0');
		String msj = (bin1 +" ^ "+ bin2);
		map[positionArray] = (byte) (map[positionArray] ^ specialBytes[bitPosition]);
		bin1 = String.format("%8s", Integer.toBinaryString(map[positionArray] & 0xFF)).replace(' ', '0');
		System.out.print("\n" +msj +" = "+ bin1);
		verbose.AddToVerbose("\n" +msj +" = "+ bin1);
	}

	public void PrintMap() {
		for (int i = 0; i < 128; i++) {
			String binaryByte = String.format("%8s", Integer.toBinaryString(map[i] & 0xFF)).replace(' ', '0');
			System.out.println(binaryByte);
		}
	}

	public int[] LookForHole(int holeSize, int verb) {
		int check = 0;
		int beginPosition = 0;
		int index = 0;
		int[] ans = new int[2];
		if (verb ==1 ) {
		System.out.println("\n**********BUSCANDO HUECO**********");
		verbose.AddToVerbose("\n**********BUSCANDO HUECO**********");

		}
		for (int i = 0; i < 128; i++) {
			if ( verb == 1 ){
				System.out.println("\n ---Indice " + i+"---" );
				verbose.AddToVerbose("\n ---Indice" + i+"---");
			}
			for (int j = 0; j < 8; j++) {

				if (!BitState(j, i,verb)) {
					check++;
					if (check == 1) {
						beginPosition = j;
						index = i;
					}
					if (check == holeSize) {
						if (verb == 1) {
						verbose.AddToVerbose("\n********** Espacio para proceso encontrado *********");
						verbose.AddToVerbose("\nPosicion :" + beginPosition + " \nIndice:" + index+"\nTamaño : "+ holeSize);
						System.out.println("\n********** Espacio para proceso encontrado *********");
						System.out.println("\nPosicion :" + beginPosition + " \nIndice:" + index+"\nTamaño : "+ holeSize);
						}
						ans[0] = beginPosition;
						ans[1] = index;
						return ans;
					}
				} else {
					check = 0;
				}
			}

		}
		ans[0] = -1;
		ans[1] = -1;
		if (verb==1) {
		verbose.AddToVerbose("\n********** NO SE ENCONTRO ESPACIO PARA EL PROCESO **********");
		System.out.println("Hole didn't found");
		}
		return ans;
	}

	public int[] DispatchProcess(int sizeProcess, String name) {
		boolean flag = false;
		int[] positionsHole = new int[2];
		int[] aux_PositionHole = new int[2];
		positionsHole = LookForHole(sizeProcess,1);
		aux_PositionHole[0] = positionsHole[0];
		aux_PositionHole[1] = positionsHole[1];

		if (positionsHole[0] == -1) {
			return positionsHole;// Hole didn't found
		} else {
			/* Assign process to list */
			listProcess.addProcessToList(name, positionsHole[0] + "," + positionsHole[1], String.valueOf(sizeProcess));
			//listProcess.printProcessList();
			/* Assign process to Bitmap */
			System.out.println("\n********** Asignando Proceso **********");
			verbose.AddToVerbose("\n********** Asignando Proceso **********");
			System.out.println("\n --- Indice " + positionsHole[1] +"---");
			verbose.AddToVerbose("\n --- Indice " + positionsHole[1] +"---");
			for (int i = 0; i < sizeProcess; i++) {

				/* bitPosition positionArray */
				SetBit(positionsHole[0], positionsHole[1]);
				positionsHole[0]++;
				if (positionsHole[0] == 8) {
					positionsHole[0] = 0;
					positionsHole[1]++;
					if(i != sizeProcess-1) {
					System.out.println("\n ---Indice " + positionsHole[1]+"---" );
					verbose.AddToVerbose("\n ---Indice" + positionsHole[1]+"---");
					}
				}
			}
		}
		return aux_PositionHole;
	}
	
	public String stringDecimalNumbers(int op){
		String aux = "";
		String hundreds = "";
		String tens = "";
		String units = "";
		for(byte a : map) {

			//System.out.print(a & 0xFF);
			aux = ""+(a & 0xFF);
			if((a & 0xFF)<10){
				aux = "00" + aux;
			}else {
				if((a & 0xFF)<100){
					aux = "0" + aux;
				}
			}
			//Asgnacion a 3 cadenas
			hundreds = hundreds+ " " + aux.charAt(0);
			tens = tens + " " + aux.charAt(1); 
			units = units + " " + aux.charAt(2);

			
			}
		
		switch(op) {
		
		case 0://hundreds
				return hundreds;
		case 1:// tens
				return tens;
		case 2://units
				return units;
		
		}
		return "";
	}
	
	public void UndispatchProcess(String name) {
		int[] positionsHole = new int[2];
		int position = listProcess.ValidateProcessExist(name);
		//System.out.println("position: " + position);
		/* Check if process exist */
		//lest try 2
		if (position != -1) {
			positionsHole = listProcess.getProcessIndex(position);

			//System.out.println("Position hole : ***" + positionsHole[0] + "***" + positionsHole[1] + "***");
			/* Delete process from the map */
			System.out.print("\n********** Eliminando Proceso **********");
			verbose.AddToVerbose("\n********** Eliminando Proceso **********");
			System.out.println("\n --- Indice " + positionsHole[1] +"---");
			verbose.AddToVerbose("\n --- Indice " + positionsHole[1] +"---");
			for (int i = 0; i < listProcess.getProcessSize(position); i++) {
				/* bitPosition positionArray */
				UnsetBit(positionsHole[0], positionsHole[1]);
				
				
				positionsHole[0]++;
				if (positionsHole[0] == 8) {
					positionsHole[0] = 0;
					positionsHole[1]++;
					System.out.println("\n ---Indice " + positionsHole[1]+"---" );
					verbose.AddToVerbose("\n ---Indice" + positionsHole[1]+"---");
				}
			}
			/* Delete process from the List */
			listProcess.deleteProcessFromList(name);
		}

	}

}
