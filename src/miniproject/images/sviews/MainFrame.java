package miniProject4.com.kh.views;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	Container contentPane;

	public MainFrame() {
		this.setBounds(0, 0, 1400, 900);
		contentPane = getContentPane();
		Ssing s = new Ssing(this);
		//Park s = new Park(this);
		//Sosok s = new Sosok(this);
		//SsingNext s = new SsingNext(this);
	     contentPane.add(s,BorderLayout.CENTER);
		// this.add(new Ssing(this));

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

