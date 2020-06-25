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
		
//		x = pl.getX(); 
//		y = pl.getY();
		
//		if(Crash(x,y,door.getX(),door.getY(),pl,door)) {
//			ChangePanel.changePanel(mf, this, new MainMap());
//		}
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(room,250,120,848,482,null);
		g.drawImage(talk,5,620,1390,250,null);
		g.setFont(new Font("gorthic", Font.BOLD,40));
		g.drawString("공원에 가고싶은 날이양...", 70, 750);
		setOpaque(false);
	}
	
	
	
	public void Crash() {}       //위치 이동용
	
	
	
//	   public boolean Crash(int x1, int y1, int x2, int y2, Image player_img, Image dispatch_img) {
//	      //해당 이미지의 넓이, 높이값을 계산
//	      boolean check = false;
//
//	      if(Math.abs((x1 + player_img.getWidth(null) / 2) - (x2 + dispatch_img.getWidth(null) / 2)) <
//	            (dispatch_img.getWidth(null) / 2 + player_img.getWidth(null) / 2) 
//	            && Math.abs((y1 + player_img.getHeight(null) / 2)  - (y2 + dispatch_img.getHeight(null) /2)) <
//	            (dispatch_img.getHeight(null) / 2 + player_img.getHeight(null) /2 )) {
//	         //이미지 넓이, 높이값을 바로 받아 계산
//
//	         check = true;   //위 값이 true면 check에 true를 전달
//	      } else {
//	         check = false;
//	      }
//
//	      return check;      //check의 값을 메소드에 리턴 시킴
//	
//	
//	   }
//	   public boolean Crash(int x1, int y1, int x2, int y2, JLabel pl, JLabel door) {
//		   //해당 이미지의 넓이, 높이값을 계산
//		   check = false;
//		   
//		   if((((pl.getX() + pl.getX() + 100) / 2) - ((x2 + door.getX() + 150 ) / 2)) <
//				   (door.getX() / 2 + pl.getX() / 2) 
//				   && (((y1 + pl.getY() + 100) / 2)  - ((y2 + door.getY()+20) /2)) <
//				   (door.getY() / 2 + pl.getY() /2 )) {
//			   //이미지 넓이, 높이값을 바로 받아 계산
//			   
//			   check = true;   //위 값이 true면 check에 true를 전달
//		   } else {
//			   check = false;
//		   }
//		   
//		   return check;      //check의 값을 메소드에 리턴 시킴
		   
		   
//	   }
}
