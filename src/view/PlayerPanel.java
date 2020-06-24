package view;

import java.awt.Image;

import javax.swing.*;

public class PlayerPanel extends JPanel {
	
//	private Filasd mf; 
//	private JPanel fp;
	
	PlayerLabel fl = new PlayerLabel();
	
	public PlayerPanel() {
//		this.mf = mf;
//		this.fp = this;
		
		this.addKeyListener(new MyKeyListener(fl));
		this.add(fl);
//		revalidate();
		
		this.setFocusable(true);
		this.setVisible(true);
		this.setLayout(null);
		this.setSize(1400,900);
		
	}

}
