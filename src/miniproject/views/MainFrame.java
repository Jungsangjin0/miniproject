package miniproject.views;

import javax.swing.JFrame;

import miniproject.views.mainMap.MainMap;
import miniproject.views.sangjin.MainRoom;


public class MainFrame extends JFrame {
	public MainFrame(){
		this.setBounds(60, 0, 1400, 900);
		MainMap mainmap = new MainMap(this);
		MainRoom mainroom = new MainRoom(this);
		mainmap.setLayout(null);
		this.add(mainmap);
		this.add(mainroom);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
	}
	
}
