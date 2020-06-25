package miniproject.views.ending;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	Container contentPane;
	public MainFrame() {
		this.setTitle("트롯스타메이커");
		this.setSize(1400, 900);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		contentPane = getContentPane();
		
		EndingBack01 panel = new EndingBack01();
		contentPane.add(panel,BorderLayout.CENTER);
		
		this.setResizable(false);
		//add(new Ending01(this));
		//setLocationRelativeTo(null);
	}

	

	
}
