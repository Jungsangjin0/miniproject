package miniproject.views.mainMap;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.jungukGame.MainPage;
import miniproject.views.trotGame.FirstPanel;

public class MyKeyListenerJunGuk extends KeyAdapter{
	
	private MainFrame mf;
	private JPanel panel;
	private JLabel la;
	private Player123 player;
	private static final int MOVE_UNIT = 10;
	
	public MyKeyListenerJunGuk(JLabel la, MainFrame mf, JPanel panel, Player123 player) {
		this.la = la;
		this.mf = mf;
		this.panel = panel;
		this.player = player;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int a = la.getX();
		int b = la.getY();
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		int a = la.getX();
		int b = la.getY();
		if((a >= 800 && a <= 900)&&(b >= -50 && b <= 0)) {
			ChangePanel.changePanel(mf, panel, new MainPage(mf,player));
			mf.revalidate();
		}
		if((a >= 250 && a <= 350) && (b >= 500 && b <= 580)) {
			ChangePanel.changePanel(mf, panel, new FirstPanel(mf,player));
			mf.revalidate();
		}
		
		switch(keyCode) {
		case KeyEvent.VK_UP:
			la.setLocation(la.getX(), la.getY() - MOVE_UNIT);
			break;
		case KeyEvent.VK_DOWN:
			la.setLocation(la.getX(), la.getY() + MOVE_UNIT);
			break;
		case KeyEvent.VK_LEFT:
			la.setLocation(la.getX() - MOVE_UNIT, la.getY());
			break;
		case KeyEvent.VK_RIGHT :
			la.setLocation(la.getX() + MOVE_UNIT, la.getY());
			break;
		case KeyEvent.VK_SPACE:
			System.out.println(la.getX());
			System.out.println(la.getY());
		}
	}

}
