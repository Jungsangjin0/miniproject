package view;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

class MyKeyListener extends KeyAdapter {

	// 케릭터 속도 조절 기본 : 10
	private static final int FLYING_UNIT = 10;		
	JLabel la;

	
	public MyKeyListener(JLabel la) {
		this.la = la;
	}

	public void keyPressed(KeyEvent e) {
		//키보드의 자판 숫자로 받아옴
		int keyCode = e.getKeyCode();

		switch (keyCode) {

		case KeyEvent.VK_UP:

			la.setLocation(la.getX(), la.getY() - FLYING_UNIT);

			break;

		case KeyEvent.VK_DOWN:

			la.setLocation(la.getX(), la.getY() + FLYING_UNIT);

			break;

		case KeyEvent.VK_LEFT:

			la.setLocation(la.getX() - FLYING_UNIT, la.getY());

			break;

		case KeyEvent.VK_RIGHT:

			la.setLocation(la.getX() + FLYING_UNIT, la.getY());

			break;

		}
	}
}

