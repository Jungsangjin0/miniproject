package miniproject.views.mainMap;

import java.awt.Graphics;
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
import miniproject.views.jungukGame.MainPage;
import miniproject.views.somang.Park;
import miniproject.views.suddenGame.GamePanelSu;
import miniproject.views.suddenGame.SuddenGameStart;



public class MainMapSudden extends JPanel {	
	private MainFrame mf;
	private MainMapSudden panel = this;
	private PlayerLabel fl = new PlayerLabel();
	private JLabel quest = new JLabel();
	
	private Player123 player;
	
	public void paintComponent(Graphics g) {
		
		ImageIcon bground = new ImageIcon("src/miniproject/images/mainMap/MainMap.png");
		g.drawImage(bground.getImage(), 0, 0, 1400, 900, null);
		setOpaque(false); //그림을 표시하게 설정,투명하게 조절
		super.paintComponent(g);
	}
	
	
	public MainMapSudden (MainFrame mf,Player123 player) {
		this.player = player;
		this.mf = mf;
		
		quest.setIcon(new ImageIcon("src/miniproject/images/camera/startp.PNG"));
		quest.setBounds(200,50,1000,700);
		quest.setVisible(true);
		panel.add(quest);
		
		fl.setLayout(null);
		fl.setBounds(850, 0, 100, 100);
		this.add(fl);
		
		quest.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new SuddenGameStart(mf,player));
				
			}
		});
		
	}
}
	

