package gui;
import java.awt.*;
import java.util.concurrent.TimeUnit;
class Memory extends Canvas {
  	final int widthSquare = 10;
    final int heightSquare = 10;
  	final int widthRectangle = 1280;
    final int heightRectangle = 80;
	int  option=0;
	
	int width, height, rows, columns;
   
    int XSquare = 0, YSquare = 0;
    Memory(int w, int h, int r, int c) {
        setSize(width = w, height = h);
        rows = r;
        columns = c;
        
    }
    
    @Override
    public void paint(Graphics g) {
        
    	switch (option) { 
        case 0://
        	 DrawGrid(g);
         break;
        case 1:// Not Found
        	NotFound(g);
         break;
  
        case 2://
        
         break;
         
        case 3://
        	
         break;
        	
     }
  
    }
    
    public void ColoringSquare(Graphics g, int x, int y, Color color){

     g.setColor(color);
     g.fillRect(x, y, widthSquare, heightSquare);
     DrawGrid(g);
     System.out.println(width+"||" +height);
    	
    }
    public void ColoringAll(Graphics g, Color color){
        g.setColor(color);
        g.fillRect(0, 0, widthRectangle, heightRectangle);
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
    
    public void NotFound(Graphics g) {
         for(int i = 0 ; i < 3 ;i++){
        	 wait(1000);
        	 ColoringAll(g,Color.RED);
        	 wait(1000);
             ColoringAll(g,new Color(119, 118, 123));
             System.out.println(i);
             wait(1000);
         }
    }
    
    public void SetOption(int op){
    	option=op;
    }
    public static void wait(int ms)
    {
   	 try {
         Thread.sleep(ms); // Suspender el hilo durante 1 segundo
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
    }
}

