package miniproject.views;

import javax.swing.JFrame;

import miniproject.views.dispatchGame.dispatchPanel;
import miniproject.views.mainMap.MainMap;
import miniproject.views.sangjin.MainRoom;


public class MainFrame extends JFrame {
	public MainFrame(){
		this.setBounds(60, 0, 1400, 900);
//		MainMap mainmap = new MainMap(this);
//		MainRoom mainroom = new MainRoom(this);
		dispatchPanel dp = new dispatchPanel(this);
//		mainmap.setLayout(null);
//		this.add(mainmap);
//		this.add(mainroom);
		this.add(dp);
		
		setResizable(false); 		//화면 사이즈 고정
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
	}
	
}
