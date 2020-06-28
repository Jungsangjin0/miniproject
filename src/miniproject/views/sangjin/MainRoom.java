package miniproject.views.sangjin;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dongyub.PlayerLabel;
import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.mainMap.MainMapFirst;

public class MainRoom extends JPanel{
	private MainFrame mf;
	private MainRoom panel;
	private Player123 player;
	private PlayerLabel pl = new PlayerLabel();
	
	private Image room = new ImageIcon("src/miniproject/images/camera/mainroom.jpg").getImage();
	private Image talk = new ImageIcon("src/miniproject/images/ssing/talkframe.png").getImage();
	
	
		public MainRoom(MainFrame mf, Player123 player) {
		System.out.println(player.getUserId());
		panel = this;
		this.mf = mf;
		this.player = player;
		
		panel.setLayout(null);
		
		pl.setLayout(null);
		pl.setBounds(650,320,100,100);
		this.add(pl);
		
		
		this.setVisible(true);
		addKeyListener(new MyKeyListenerMainRoom(pl,mf,panel,player));
		
	}
	public void paintComponent(Graphics g) {
		setFocusable(true);
		requestFocus();
		super.paintComponent(g);
		g.drawImage(room,250,120,848,482,null);
		g.drawImage(talk,5,620,1390,250,null);
		g.setFont(new Font("gorthic", Font.BOLD,40));
		g.drawString("������ ������� ���̾�...", 70, 750);
		setOpaque(false);
		
	}
	
}
