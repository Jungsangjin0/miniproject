package miniproject.views.somang;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.mainMap.MainMap3;
import miniproject.views.minigame.MiniGamePanel;


public class Sosok extends JPanel{

	private MainFrame mf;
	private Sosok panel = this;
	private ImageIcon back;
	private ImageIcon talk;
	private ImageIcon charac01 =new ImageIcon("src/miniproject/images/sosok/FCharacters02.GIF");
	private ImageIcon sajang = new ImageIcon("src/miniproject/images/sosok/sajang.PNG");
	private ImageIcon sDoorL;
	private ImageIcon sDoorR;
	private JLabel door;
	
	public Sosok(MainFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		back = new ImageIcon("src/miniproject/images/sosok/sosok.png");
		talk = new ImageIcon("src/miniproject/images/sosok/talkframe.png");
		Image cimage = charac01.getImage().getScaledInstance(250, 250, 0);
		Image simage  = sajang.getImage().getScaledInstance(250, 250, 0);
		sDoorL = new ImageIcon("src/miniproject/images/sosok/Door.png");
		sDoorR = new ImageIcon("src/miniproject/images/sosok/Door.png");
		ImageIcon cIcon = new ImageIcon(cimage);
		ImageIcon sIcon = new ImageIcon(simage);
		
		door = new JLabel();
		door.setLayout(null);
		door.setBounds(0, 400, 20, 200); 
		door.setOpaque(true);
		this.add(door);
		
		door.addMouseListener(new MouseAdapter() {
			
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new MainMap3(mf));
				
			}
		});
		//캐릭터들
		JLabel cLabel = new JLabel(cIcon);
		JLabel sLabel = new JLabel(sIcon);
		cLabel.setBounds(30, 250, 398, 398);

		JButton sajangButton = new JButton();
		sajangButton.add(sLabel);
		sajangButton.setBorderPainted(false);
		sajangButton.setContentAreaFilled(false);
//		sajangButton.setFocusPainted(false);
		
		sajangButton.setBounds(300, 250, 398, 398);
		panel.add(cLabel);
		panel.add(sajangButton);
		
		//문
		JLabel labelL = new JLabel(sDoorL);
		JLabel labelR = new JLabel(sDoorR);
		//label.getIcon();
		JButton doorL = new JButton();
		JButton doorR = new JButton();
		doorL.setBounds(149,134,171,280);
		doorR.setBounds(504,134,171,280);
		doorL.setBorderPainted(false);
		doorR.setBorderPainted(false);
		doorL.add(labelL);
		doorR.add(labelR);
		panel.add(doorR);
		panel.add(doorL);
		
		
		
		
		//노래
		doorL.addMouseListener(new clickButtonL());
		
		//춤
		doorR.addMouseListener(new clickButtonR());
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(back.getImage(), 0, 0, null);
		g.drawImage(talk.getImage(), 5, 620, 1390, 250, null);
		//g.drawImage(sajang.getImage(), 300, 200, 398, 398, this);
		//g.drawImage(sDoorL.getImage(),149,134,171,280,null);
		//g.drawImage(sDoorR.getImage(),504,134,171,280,null);
//		if (charac01 != null) {
//			g.drawImage(charac01.getImage(), 30, 300, 200, 200, this);
//		}
		
		setOpaque(false);
		super.paintComponent(g);
	}
	
	
	
	//노래
	class clickButtonL extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, panel, new Ssing(mf));
			mf.revalidate();
		}
	}
	//춤
	class clickButtonR extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, panel, new MiniGamePanel(mf));
			mf.revalidate();
		}
	}
	
//	class clickPanel extends MouseAdapter {
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			//ChangePanel.replacePanel(mf, panel, new Ssing2());
//			//ChangePanel cp = new ChangePanel(mf,panel, panel);
//			
//			ChangePanel.replacePanel(mf, panel, new Ssing(mf));
//			
//		}
//
//	}
	
}
