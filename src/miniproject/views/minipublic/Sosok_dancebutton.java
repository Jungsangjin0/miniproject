package miniproject.views.minipublic;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.Pyosi;
import miniproject.views.mainMap.MainMapJunguk;
import miniproject.views.minigame.MiniGameDance;
import miniproject.views.somang.MiniGameSsing;

public class Sosok_dancebutton extends JPanel{


	private MainFrame mf;
	private Sosok_dancebutton panel = this;
	private JLabel door;
	
	private ImageIcon back;
	private ImageIcon talk;
	private ImageIcon charac01 =new ImageIcon("src/miniproject/images/SJH/Characters_5.png");
	private ImageIcon sajang = new ImageIcon("src/miniproject/images/sosok/sajang.PNG");
	private ImageIcon sDoorR; //√„
	private ImageIcon doorMain;
	
	private Player123 player;
	private Pyosi pyosi;


	public Sosok_dancebutton(MainFrame mf, Player123 player) {
		
		this.mf = mf;
		this.player = player;
		
		pyosi = new Pyosi(player);
		pyosi.setLayout(null);
		pyosi.setBounds(600,0,500,200);
		pyosi.setFont(new Font("∏º¿∫∞ÌµÒ", Font.BOLD, 25));
		pyosi.setForeground(Color.WHITE);
		panel.add(pyosi);
		
		this.setLayout(null);
		back = new ImageIcon("src/miniproject/images/sosok/sosok.png");
		talk = new ImageIcon("src/miniproject/images/sosok/talkframe.png");
		Image cimage = charac01.getImage().getScaledInstance(250, 250, 0);
		Image simage  = sajang.getImage().getScaledInstance(250, 250, 0);
		sDoorR = new ImageIcon("src/miniproject/images/sosok/Door.png");
		ImageIcon cIcon = new ImageIcon(cimage);
		ImageIcon sIcon = new ImageIcon(simage);

		doorMain = new ImageIcon("src/miniproject/images/SJH/outdoor.png");

		//πÆ 
		door = new JLabel(doorMain);
		door.setLayout(null);
		door.setBounds(0, 300, 40, 250);
		door.setOpaque(false);
		this.add(door);



		door.addMouseListener(new MouseAdapter() {



			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new MainMapJunguk(mf,player));

			}
		});
		//ƒ≥∏Ø≈ÕµÈ
		JLabel cLabel = new JLabel(cIcon);
		JLabel sLabel = new JLabel(sIcon);
		cLabel.setBounds(30, 250, 398, 398);

		JButton sajangButton = new JButton();
		sajangButton.add(sLabel);
		sajangButton.setBorderPainted(false);
		sajangButton.setContentAreaFilled(false);

		sajangButton.setBounds(300, 250, 398, 398);
		panel.add(cLabel);
		panel.add(sajangButton);

		//πÆ
		JLabel labelR = new JLabel(sDoorR);
		JButton doorR = new JButton();
		doorR.setBounds(504,134,171,280);
		doorR.setBorderPainted(false);
		doorR.setContentAreaFilled(false);
		doorR.setFocusPainted(false);
		doorR.setBorderPainted(false);
		doorR.add(labelR);
		panel.add(doorR);





		//√„
		doorR.addMouseListener(new clickButtonR());
	}

	public void paintComponent(Graphics g) {
		g.drawImage(back.getImage(), 0, 0, null);
		g.drawImage(talk.getImage(), 5, 620, 1390, 250, null);
		g.setFont(new Font("Neoµ’±Ÿ∏", Font.BOLD, 30));
		g.drawString("√„ ø¨Ω¿Ω«∑Œ µÈæÓ∞°∂Û!",100, 750);
		setOpaque(false);
		super.paintComponent(g);
	}


	//√„
	class clickButtonR extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, panel, new MiniGameDance(mf,player));   //πˆ∆∞ ¥©∏£∏È √„∞‘¿” »≠∏È¿∏∑Œ ≥—æÓ∞®.
			mf.revalidate();
		}
	}


}