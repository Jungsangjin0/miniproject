package miniproject.views.mainMap;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import dongyub.PlayerLabel;
import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.somang.Park;



public class MainMapSosok extends JPanel {	
	private int donum;
	private MainFrame mf;
	private MainMapSosok panel = this;
	private Player123 player;
	
	PlayerLabel fl = new PlayerLabel();
	
	public void paintComponent(Graphics g) {
		setFocusable(true);
		requestFocus();
		ImageIcon bground = new ImageIcon("src/miniproject/images/mainMap/MainMap.png");
		
		g.drawImage(bground.getImage(), 0, 0, 1400, 900, null);
		setOpaque(false); //그림을 표시하게 설정,투명하게 조절
		super.paintComponent(g);
	}
	public MainMapSosok(MainFrame mf, Player123 player) {
		
		this.mf = mf;
		this.player = player;
		
		addKeyListener(new MyKeyListenerSosok(fl, mf, panel, player));
		fl.setLayout(null);
		fl.setBounds(630, 130, 100, 100);
		this.add(fl);
		this.setFocusable(true);
	}
}
	

