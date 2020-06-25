package dongyub;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Player extends JFrame {
	private static final int SCREEN_WIDTH = 1400;
	private static final int SCREEN_HEIGHT = 900;
	
	public Player() {
		
		this.setTitle("트롯스타메이커!!");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setBounds(100, 100, SCREEN_WIDTH, SCREEN_HEIGHT);
		
		this.setLayout(null);
		
		this.add(new PyPanel());
		
		this.addKeyListener(new MyKeyAdapter());
		
	}
	
	
}

class PyPanel extends JPanel {
	
	public PyPanel() {
		
		
	}
	
	
}

class MyThread extends Thread {
	
	@Override
	public void run() {
		
		while(true) {
			try {
				
				Thread.sleep(20);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	
}

class MyKeyAdapter extends KeyAdapter{
	
	  public void keyPressed(KeyEvent e) {
		  
	  }

	    public void keyReleased(KeyEvent e) {
	    	
	    }
	}

