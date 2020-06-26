package miniproject.views;

import javax.swing.JFrame;

import miniproject.views.firstPage.FirstPage;
import miniproject.views.mainMap.MainMap;
import miniproject.views.sangjin.MainRoom;


public class MainFrame extends JFrame {
	public MainFrame(){
		this.setBounds(60, 0, 1400, 900);
//		MainMap mainmap = new MainMap(this);
//		MainRoom mainroom = new MainRoom(this);
		FirstPage first = new FirstPage(this);
//		mainmap.setLayout(null);
		this.add(first);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
	}
	
}
