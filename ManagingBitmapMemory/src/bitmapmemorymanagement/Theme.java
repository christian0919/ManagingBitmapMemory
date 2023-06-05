package bitmapmemorymanagement;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.awt.Color;
import java.io.FileWriter;


public class Theme {

	private Color background;

	private Color letters;

	private Color background_Map;

	/*
	 * i -> [0]=R | [1]=G | [2]=B
	 * 
	 * background = [0][i] letters = [1][i] background_Map = [2][i]
	 */
	private int[][] Theme1 = { { 61, 56, 70 }, { 255, 255, 255 }, { 119, 118, 123 } };// { new Color(61, 56, 70),
																						// Color.white,
																						// new Color(119,118, 123) };
	private int[][] Theme2 = { { 139, 166, 172 }, { 229, 230, 201 }, { 215, 215, 184 } };// { new Color(139, 166, 172),
																							// new Color(229, 230, 201),
																							// new Color(215, 215, 184)
																							// };
	private int[][] Theme3 = { { 136, 180, 153 }, { 247, 234, 217 }, { 225, 210, 169 } };// { new Color(136, 180, 153),
																							// new Color(247, 234, 217),
																							// new Color(225, 210, 169)
																							// };
	private int[][] Theme4 = { { 255, 255, 255 }, { 0, 0, 0 }, { 255, 255, 255 } };// { Color.white, Color.black,
																					// Color.white };

	public Theme() {
		GetConfig();
		}

	public Color GetBackgroundColor() {
		return background;
	}

	public Color GetLettersColor() {
		return letters;
	}

	public Color GetBackgroundMap() {
		return background_Map;
	}

	public void SetConfig(int option) {
		switch (option) {

		case 1:// theme 1
			WriteInFile(Theme1);
			break;
		case 2:// theme 2
			WriteInFile(Theme2);
			break;
		case 3:// theme 3
			WriteInFile(Theme3);
			break;
		case 4:// theme 4
			WriteInFile(Theme4);
			break;

		}
	}

	void WriteInFile(int[][] theme) {

		String sFichero = "./Config";
		File fichero = new File(sFichero);
		//fill file
		if (fichero.exists()) {
			 try {
		            FileWriter writer = new FileWriter("./Config");
		            writer.write("background:"+theme[0][0]+","+theme[0][1]+","+theme[0][2]+"\n"); 
		            writer.write("letters:"+theme[1][0]+","+theme[1][1]+","+theme[1][2]+"\n"); 
		            writer.write("background_Map:"+theme[2][0]+","+theme[2][1]+","+theme[2][2]); 
		            writer.close();
		        } catch (IOException e) {
		            System.out.println("Error  " + e.getMessage());
		        }
		}
		/*
		 background:61,56,70
		 letters:255,255,255
		 background_Map:119, 118, 123
		 */
		//insert info in file
		
		
	}

	public void GetConfig() {
		short cont = 0;
		String ruta = "./Config";
		try {
			File file = new File(ruta);
			if (!file.exists()) {
				file.createNewFile();
				SetConfig(4);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(ruta));
			String texto = br.readLine();
			while (texto != null) {
				setConfig(cont, texto);
				cont++;
				texto = br.readLine();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (Exception ex) {
				System.out.println("Error al cerrar el fichero");
				ex.printStackTrace();
			}
		}
	}

	private void setConfig(short op, String colors) {
		String[] values = colors.split(":");
		String[] RGB = values[1].split(",");
		Color aux = new Color(Integer.parseInt(RGB[0]), Integer.parseInt(RGB[1]), Integer.parseInt(RGB[2]));
		switch (op) {
		case 0:
			background = aux;
			break;
		case 1:
			letters = aux;
			break;
		case 2:
			background_Map = aux;
			break;

		}
	}

}
