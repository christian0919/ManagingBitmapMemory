package gui;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import bitmapmemorymanagement.BitMap;

class Memory extends Canvas {
  	final int widthSquare = 10;
    final int heightSquare = 10;
  	final int widthRectangle = 1280;
    final int heightRectangle = 80;
	int  option=0;
	int width, height, rows, columns;
	String size_Process;
	 List<String[]> list;
	int[] begin_Process = new int[2];
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
        	 ColoringAll(g,new Color(119,118,123));
        	 DrawGrid(g);
        	 break;
        case 1://Hole Does Not Found
        	AnimatedBlink(g, Color.red);
        	ColoringAll(g,new Color(119,118,123));
        	DrawGrid(g);
        	DrawAllMap(g);
        	break;
         	
        case 2://Process Does Not Found 
        	AnimatedBlink(g, Color.yellow);
        	ColoringAll(g,new Color(119,118,123));
        	DrawGrid(g);
        	DrawAllMap(g);
        	break;
         
        case 3://Inserting Process
        	 ColoringAll(g,new Color(119,118,123));
        	 DrawGrid(g);
        	 LocalizeProcess( g, Color.green, Integer.parseInt(size_Process), begin_Process[0],begin_Process[1]);
        	 ColoringAll(g,new Color(119,118,123));
        	 DrawGrid(g);
        	 DrawAllMap(g);
        	break;
         
        case 4://Deleting Process
        	 ColoringAll(g,new Color(119,118,123));
        	 DrawGrid(g);
        	 LocalizeProcess( g, Color.red, Integer.parseInt(size_Process), begin_Process[0],begin_Process[1]);
        	 ColoringAll(g,new Color(119,118,123));
        	 DrawGrid(g);
        	 DrawAllMap(g);
        	break;
        
        case 5://
        	
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
    
    public void AnimatedBlink(Graphics g, Color color) {
         for(int i = 0 ; i < 3 ;i++){
        	 wait(1000);
        	 ColoringAll(g,color);
        	 wait(1000);
             ColoringAll(g,new Color(119, 118, 123));
             System.out.println(i);
             wait(1000);
         }
         ColoringAll(g,new Color(119,118,123));
    	 DrawGrid(g);
    }
    
    public void SetOption(int op){
    	option=op;
    }
    public static void wait(int ms){
   	 try {
         Thread.sleep(ms); // Suspender el hilo durante 1 segundo
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
    }
    
    public void LocalizeProcess(Graphics g, Color color,int size,int index,int position){
    	ColoringAll(g,new Color(119,118,123));
    	index=index*10;
    	position=position*10;
    	for(int i = 0 ; i < size ; i++ ) {
    		wait(300);
    		ColoringSquare(g,index,position,color);
			position+=10;
			if(position >= 80) {
				position=0;
				index+=10;
			}	
		}
    	
    	
    }
    public void LocalizeProcess2(Graphics g, Color color,int size,int index,int position){
    	index=index*10;
    	position=position*10;
    	for(int i = 0 ; i < size ; i++ ) {
    		wait(300);
    		ColoringSquare(g,index,position,color);
			position+=10;
			if(position >= 80) {
				position=0;
				index+=10;
			}	
		}
    	
    	
    }
    
    public void DrawAllMap(Graphics g){
    	
    	for(String p[] :  list) {
			//System.out.println("Name:"+p[0]+" Begin:"+p[1]+" Size:"+p[2]);
    		String[] str= p[1].split(",");
    		LocalizeProcess2(g, Color.green ,Integer.parseInt(p[2]),Integer.parseInt(str[1]),Integer.parseInt(str[0]));
		}
    }
    
    public void SetList( List<String[]> getlist){
    	
    	if(!(list == null || list.size() == 0)){
    		list.clear();
    	}
    	  list = new ArrayList<>(getlist);
    }
    
    
}

