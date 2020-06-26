package miniproject.views.sangjin;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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
	JPanel panel;
	Image room = new ImageIcon("src/miniproject/images/camera/mainroom.jpg").getImage();
	Image talk = new ImageIcon("src/miniproject/images/ssing/talkframe.png").getImage();
	PlayerLabel pl = new PlayerLabel();
	JLabel door = new JLabel(); 
	boolean check = false;
	
	int x = 0;
	int y = 0;
		public MainRoom(MainFrame mf) {
		
		panel = this;
		this.mf = mf;
		
		addKeyListener(new MyKeyListener(pl));
		this.add(pl);
		
		this.setFocusable(true);
		this.setVisible(true);
		panel.setLayout(null);
		pl.setLayout(null);
		pl.setBounds(650,300,100,100);
		
		door.setLayout(null);
		door.setBounds(600,580,150,150);
		door.setOpaque(true);
		this.add(door);
//		if((pl.getX()>= 600 && pl.getX()<= 650)&& (pl.getY() >= 530)) {
//			
//			ChangePanel.changePanel(mf, panel, new MainMap(mf));
//			mf.revalidate();
//		}
		
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
