package gui;
import java.awt.*;


class Memory extends Canvas {
    int width, height, rows, columns;
    
    int XSquare = 0, YSquare = 0;
    Memory(int w, int h, int r, int c) {
        setSize(width = w, height = h);
        rows = r;
        columns = c;
    }

    @Override
    public void paint(Graphics g) {
        
        NotFound(g);
        DrawSquare(g, 20,10);
        DrawGrid(g);
    }
    
    public void DrawSquare(Graphics g, int x, int y){
   	 final int widthSquare = 10;
     final int heightSquare = 10;
     g.setColor(Color.BLUE);
     g.fillRect(x, y, widthSquare, heightSquare);
     DrawGrid(g);
     System.out.println(width+"||" +height);
    	
    }
    
    public void DrawGrid(Graphics g)  {
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
    
    public void NotFound(Graphics g){
    	 width = getSize().width;
         height = getSize().height;
         g.setColor(Color.red);
         g.fillRect(0, 0, width-1, height-1);
         DrawGrid(g);
         System.out.println(width+"||" +height);
    }
}

