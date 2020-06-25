package miniproject.views.mainMap;

import java.awt.*;
import javax.swing.*;



public class MainMap extends JPanel {	
	private int donum;
	private Door[] doors = {new Door(), new Door(), new Door(), new Door(), new Door(), new Door()};

	
	public void paintComponent(Graphics g) {
		ImageIcon bground = new ImageIcon("src/miniproject/images/mainMap/MainMap.png");
		
		g.drawImage(bground.getImage(), 0, 0, 1400, 900, null);
		//			Point p = scrollPane.getViewport().getViewPosition();
		//g.drawImage(bground.getImage(), p.x, p.y, null);
		setOpaque(false); //그림을 표시하게 설정,투명하게 조절
		super.paintComponent(g);
	}
	public MainMap () {
	this.doors[0].setLayout(null); //집
	this.doors[0].setBounds(1075, 500, 50, 25); 
//	doors[0].setVisible(false);
	
	this.doors[1].setLayout(null); //공원
	this.doors[1].setBounds(500, 180, 308, 65); 
//	doors[1].setVisible(false);
	
	this.doors[2].setLayout(null); //소속사
	this.doors[2].setBounds(650, 500, 50, 25); 
//	doors[2].setVisible(false);
	
	this.doors[3].setLayout(null); //전국노래자랑
	this.doors[3].setBounds(850, 30, 80, 40); 
	
	this.doors[4].setLayout(null); //미스터트롯 방송국 
	this.doors[4].setBounds(340, 595, 70, 30); 
	
	this.doors[5].setLayout(null); //디스패치
	this.doors[5].setBounds(870, 0, 10, 900); 
	
	this.add(doors[0]);
	this.add(doors[1]);
	this.add(doors[2]);
	this.add(doors[3]);
	this.add(doors[4]);
	this.add(doors[5]);
	
	}
	
	public int doorsEnter() {
		int door1x =this.doors[0].getX(); 
		int door1y = this.doors[0].getY();
		return 0 ;
	}
	
	public void doors_excute() {
		
		switch(donum) {
		case 1: break;
		case 2: break;
		case 3: break;
		case 4: break;
		case 5: break;
		case 6: break;
		}
	}
}
	

