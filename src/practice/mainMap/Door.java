package practice.mainMap;

import java.awt.Graphics;


import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Door extends JLabel {
		public void paintComponent(Graphics g) {
		ImageIcon d = new ImageIcon("mainMap/pad.png");

		g.drawImage(d.getImage(), 0, 0, 500, 900, null);
		//			Point p = scrollPane.getViewport().getViewPosition();
		setOpaque(false); //�׸��� ǥ���ϰ� ����,�����ϰ� ����
		super.paintComponent(g);
		
			}
		
		
	}
