package miniproject.views.suddenGameuddenGame;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
 public MainFrame () {
	 GamePanel bground = new GamePanel(this);
	 bground.setLayout(null);
	 this.add(bground);
	 this.setSize(1400,900);
	 this.setVisible(true);
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
	
}
