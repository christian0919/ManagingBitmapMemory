package gui;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import bitmapmemorymanagement.Theme;

class Memory extends Canvas {
	final int widthSquare = 10;
	final int heightSquare = 10;
	final int widthRectangle = 1280;
	final int heightRectangle = 80;
	int option = 0;
	int width, height, rows, columns;
	Color back;
	String size_Process;
	List<String[]> list;
	List<String[]> Auxlist;
	int[] begin_Process = new int[2];
	int XSquare = 0, YSquare = 0;

	Memory(int w, int h, int r, int c) {
		setSize(width = w, height = h);
		rows = r;
		columns = c;
		Theme theme = new Theme();
		back = theme.GetBackgroundMap();
	}

	@Override
	public void paint(Graphics g) {

		switch (option) {
		case 0://
			ColoringAll(g, back);
			DrawGrid(g);
			break;
		case 1:// Hole Does Not Found
			AnimatedBlink(g, Color.red);
			ColoringAll(g, back);
			DrawGrid(g);
			DrawAllMap(g);
			break;
		case 2:// Process Does Not Found
			AnimatedBlink(g, Color.yellow);
			ColoringAll(g, back);
			DrawGrid(g);
			DrawAllMap(g);
			break;
		case 3:// Inserting Process
			ColoringAll(g, back);
			DrawGrid(g);
			Searching(g);
			LocalizeProcess(g, Color.green, Integer.parseInt(size_Process), begin_Process[0], begin_Process[1]);
			ColoringAll(g, back);
			DrawGrid(g);
			DrawAllMap(g);
			break;
		case 4:// Deleting Process
			ColoringAll(g, back);
			DrawGrid(g);
			LocalizeProcess(g, Color.red, Integer.parseInt(size_Process), begin_Process[0], begin_Process[1]);
			ColoringAll(g, back);
			DrawGrid(g);
			DrawAllMap(g);
			break;
		case 5://coloring example info
			ColoringSquare(g,0,0,Color.green);
			ColoringSquare(g,0,10,Color.green);
			
			ColoringSquare(g,0,40,Color.green);
			
			ColoringSquare(g,0,70,Color.green);
			ColoringSquare(g,0,80,Color.green);
			break;


		}

	}

	public void ColoringSquare(Graphics g, int x, int y, Color color) {

		g.setColor(color);
		g.fillRect(x, y, widthSquare, heightSquare);
		DrawGrid(g);

	}

	public void ColoringAll(Graphics g, Color color) {
		g.setColor(color);
		g.fillRect(0, 0, widthRectangle, heightRectangle);
		DrawGrid(g);

	}

	public void DrawGrid(Graphics g) {
		int k;
		width = getSize().width;
		height = getSize().height;
		g.setColor(Color.BLACK);
		int htOfRow = height / (rows);
		for (k = 0; k < rows; k++) {
			g.drawLine(0, k * htOfRow, width, k * htOfRow);
		}

		int wdOfRow = width / (columns);
		for (k = 0; k < columns; k++) {
			g.drawLine(k * wdOfRow, 0, k * wdOfRow, height);
		}
	}

	public void AnimatedBlink(Graphics g, Color color) {
		for (int i = 0; i < 3; i++) {
			wait(1000);
			ColoringAll(g, color);
			wait(800);
			ColoringAll(g, back);
			wait(400);
		}
		ColoringAll(g, back);
		DrawGrid(g);
	}

	public void SetOption(int op) {
		option = op;
	}

	public static void wait(int ms) {
		try {
			Thread.sleep(ms); // Suspender el hilo durante 1 segundo
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void LocalizeProcess(Graphics g, Color color, int size, int index, int position) {
		index = index * 10;
		position = position * 10;
		for (int i = 0; i < size; i++) {
			wait(300);
			ColoringSquare(g, index, position, color);
			position += 10;
			if (position >= 80) {
				position = 0;
				index += 10;
			}
		}
		wait(400);
	}

	public void LocalizeProcess2(Graphics g, Color color, int size, int index, int position) {
		index = index * 10;
		position = position * 10;
		for (int i = 0; i < size; i++) {
			ColoringSquare(g, index, position, color);
			position += 10;
			if (position >= 80) {
				position = 0;
				index += 10;
			}
		}

	}

	public void DrawAuxAllMap(Graphics g) {
		if (!(Auxlist == null || Auxlist.size() == 0)) {
			for (String p[] : Auxlist) {
				// System.out.println("Name:"+p[0]+" Begin:"+p[1]+" Size:"+p[2]);
				String[] str = p[1].split(",");
				LocalizeProcess2(g, Color.green, Integer.parseInt(p[2]), Integer.parseInt(str[1]),
						Integer.parseInt(str[0]));
			}
		}
	}
	
	public void DrawAllMap(Graphics g) {
		if (!(list == null || list.size() == 0)) {
			for (String p[] : list) {
				// System.out.println("Name:"+p[0]+" Begin:"+p[1]+" Size:"+p[2]);
				String[] str = p[1].split(",");
				LocalizeProcess2(g, Color.green, Integer.parseInt(p[2]), Integer.parseInt(str[1]),
						Integer.parseInt(str[0]));
			}
		}
	}

	public void SetList(List<String[]> getlist) {

		if (!(list == null || list.size() == 0)) {
			list.clear();
		}
		list = new ArrayList<>(getlist);
	}
	public void SetAuxList(List<String[]> getlist) {

		if (!(Auxlist == null || Auxlist.size() == 0)) {
			Auxlist.clear();
		}
		Auxlist = new ArrayList<>(getlist);
	}
	public void Searching(Graphics g) {
		// begin_Process[0], begin_Process[1] - position index
		int j = 0;
		for (int i = 0; i <= begin_Process[1]; i++) {
			for (j = 0; j < 8; j++) {
				if ((i == begin_Process[0] && j==begin_Process[1])) {return ;}
				ColoringAll(g, back);
				DrawAuxAllMap(g);
				ColoringSquare(g, i * 10, j * 10, Color.orange);
				wait(400);
				ColoringAll(g, back);
				DrawAuxAllMap(g);
			}

		}

	}

}
