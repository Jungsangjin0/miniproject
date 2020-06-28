package miniproject.views.mainMap;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dongyub.PlayerLabel;
import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.sangjin.MainRoom;
import miniproject.views.somang.Park;



public class MainMapFirst extends JPanel {	
	private MainFrame mf;
	private MainMapFirst panel = this;
	private Player123 player;
	private JLabel quest = new JLabel();

	private PlayerLabel fl = new PlayerLabel();

	public void paintComponent(Graphics g) {
		setFocusable(true);
		requestFocus();

		ImageIcon bground = new ImageIcon("src/miniproject/images/mainMap/MainMap.png");

		g.drawImage(bground.getImage(), 0, 0, 1400, 900, null);
		setOpaque(false); //그림을 표시하게 설정,투명하게 조절
		super.paintComponent(g);
	}
	public MainMapFirst (MainFrame mf, Player123 player) {


		this.mf = mf;
		this.player = player;
		quest.setIcon(new ImageIcon("src/miniproject/images/mainMap/parkQ.png"));
		quest.setBounds(200,50,1000,700);
		quest.setVisible(true);
		panel.add(quest);
		fl.setLayout(null);
		fl.setBounds(1075, 500, 100, 100);
		this.add(fl);

		this.addKeyListener(new MyKeyListenerMainMap(fl,mf,panel,player));



		panel.addKeyListener(new KeyAdapter() {
			

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					quest.setVisible(false);

				}
			}
		});
		
		panel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				quest.setVisible(false);
			}
		});
	
	}



}


