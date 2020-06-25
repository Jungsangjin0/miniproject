package practice.mainMap;

import javax.swing.JFrame;

import  practice.mainMap.MainMap;

public class MainFrame extends JFrame {
	public MainFrame(){
		this.setBounds(60, 0, 1400, 900);
		MainMap mainmap = new MainMap();
		mainmap.setLayout(null);
		this.add(mainmap);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	
	}
	
}
