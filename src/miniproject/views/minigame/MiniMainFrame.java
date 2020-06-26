package miniproject.views.minigame;

import java.awt.Container;

import javax.swing.JFrame;

public class MiniMainFrame extends JFrame{
		
		Container contentPane;
		public MiniMainFrame() {
			
			this.setTitle("트롯스타메이커");
			this.setSize(1400, 900);
			//this.add(new MiniGamePanel(this));
			this.setVisible(true);
									
		
			this.setResizable(false);
			
			
			
			
			//add(new Ending01(this));
			//setLocationRelativeTo(null);
			
		
		}

		
		
		/*this.setBounds(200, 30, 1000, 800);
		//this.setLayout(null);
		
		this.add(new MiniBackgroundPanel(this));
		//this.add(new GraphicTest(this));
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
	}



