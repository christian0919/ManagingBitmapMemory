package bitmapmemorymanagement;

public class BitMap {

	private byte[] map = new byte[128];
	private byte specialBytes[] = { (byte) 1, (byte) 2, (byte) 4, (byte) 8, (byte) 16, (byte) 32, (byte) 64,
			(byte) 128 };
	public ListProcess listProcess = new ListProcess();

	public boolean state = false;

	public BitMap() {
		InitializeMap();
	}

	public boolean BitState(int position, int index) {
		// **Check if the bit in the position is seated or not**//
		if ((map[index] & (1 << position)) != 0)
			return true;
		else
			return false;
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
		map[positionArray] = (byte) (map[positionArray] | specialBytes[bitPosition]);
	}

	public void UnsetBit(int bitPosition, int positionArray) {
		map[positionArray] = (byte) (map[positionArray] ^ specialBytes[bitPosition]);
	}

	public void PrintMap() {
		for (int i = 0; i < 128; i++) {
			String binaryByte = String.format("%8s", Integer.toBinaryString(map[i] & 0xFF)).replace(' ', '0');
			System.out.println(binaryByte);
		}
	}

	public int[] LookForHole(int holeSize) {
		int check = 0;
		int beginPosition = 0;
		int index = 0;
		int[] ans = new int[2];
		for (int i = 0; i < 128; i++) {
			for (int j = 0; j < 8; j++) {
				if (!BitState(j, i)) {
					check++;
					if (check == 1) {
						beginPosition = j;
						index = i;
					}
					if (check == holeSize) {
						System.out.println("beginPosition:" + beginPosition + " \nindex:" + index);
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
		System.out.println("Hole didn't found");
		return ans;
	}

	public int[] DispatchProcess(int sizeProcess, String name) {
		int[] positionsHole = new int[2];
		int[] aux_PositionHole = new int[2];
		positionsHole = LookForHole(sizeProcess);
		aux_PositionHole[0] = positionsHole[0];
		aux_PositionHole[1] = positionsHole[1];

		if (positionsHole[0] == -1) {
			return positionsHole;// Hole didn't found
		} else {
			/* Assign process to list */
			listProcess.addProcessToList(name, positionsHole[0] + "," + positionsHole[1], String.valueOf(sizeProcess));
			listProcess.printProcessList();
			/* Assign process to Bitmap */
			for (int i = 0; i < sizeProcess; i++) {
				/* bitPosition positionArray */
				SetBit(positionsHole[0], positionsHole[1]);
				positionsHole[0]++;
				if (positionsHole[0] == 8) {
					positionsHole[0] = 0;
					positionsHole[1]++;
				}
			}
		}
		return aux_PositionHole;
	}

	public void UndispatchProcess(String name) {
		int[] positionsHole = new int[2];
		int[] aux_PositionHole = new int[3];
		int position = listProcess.ValidateProcessExist(name);
		System.out.println("position: " + position);
		/* Check if process exist */
		if (position != -1) {
			positionsHole = listProcess.getProcessIndex(position);

			System.out.println("Position hole : ***" + positionsHole[0] + "***" + positionsHole[1] + "***");
			/* Delete process from the map */
			for (int i = 0; i < listProcess.getProcessSize(position); i++) {
				/* bitPosition positionArray */
				UnsetBit(positionsHole[0], positionsHole[1]);
				positionsHole[0]++;
				if (positionsHole[0] == 8) {
					positionsHole[0] = 0;
					positionsHole[1]++;
				}
			}
			/* Delete process from the List */
			listProcess.deleteProcessFromList(name);
		}

	}

}
