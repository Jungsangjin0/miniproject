package miniproject.views.sangjin;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dongyub.PlayerLabel;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.mainMap.MainMap;

public class MainRoom extends JPanel{
	MainFrame mf;
	MainRoom panel;
	static final int FLYING_UNIT = 10; 
	Image room = new ImageIcon("src/miniproject/images/camera/mainroom.jpg").getImage();
	Image talk = new ImageIcon("src/miniproject/images/ssing/talkframe.png").getImage();
	PlayerLabel pl = new PlayerLabel();
	JLabel door = new JLabel(); 
	boolean check = false;
	
	int x = 500;
	int y = 500;
		public MainRoom(MainFrame mf) {
		
		panel = this;
		this.mf = mf;
		
		
		this.setVisible(true);

		panel.setLayout(null);
		
		pl.setLayout(null);
		pl.setBounds(x,y,100,100);
		this.add(pl);
		
		door.setLayout(null);
		door.setBounds(600,580,150,150);
		door.setOpaque(true);
		this.add(door);
		this.setFocusable(true);
		
		addKeyListener(new KeyAdapter() {
			
			
			
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();

				switch (keyCode) {

				case KeyEvent.VK_UP:

					pl.setLocation(pl.getX(), pl.getY() - FLYING_UNIT);
					

					break;

				case KeyEvent.VK_DOWN:

					pl.setLocation(pl.getX(), pl.getY() + FLYING_UNIT);

					break;

				case KeyEvent.VK_LEFT:

					pl.setLocation(pl.getX() - FLYING_UNIT, pl.getY());

					break;

				case KeyEvent.VK_RIGHT:

					pl.setLocation(pl.getX() + FLYING_UNIT, pl.getY());

					break;
				}
			}
			});
		
		door.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ChangePanel.changePanel(mf, panel, new MainMap(mf));
				mf.revalidate();
			}
		
		});
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(room,250,120,848,482,null);
		g.drawImage(talk,5,620,1390,250,null);
		g.setFont(new Font("gorthic", Font.BOLD,40));
		g.drawString("공원에 가고싶은 날이양...", 70, 750);
		setOpaque(false);
	}
	
}
