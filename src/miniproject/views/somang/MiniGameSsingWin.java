package miniproject.views.somang;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.minigame.MiniGameSosok;


public class MiniGameSsingWin extends JPanel{

	private MainFrame mf;
	private MiniGameSsingWin panel = this;
	private ImageIcon back;
	private ImageIcon talk;
	private ImageIcon charac01;
	private ImageIcon win;
	
	public MiniGameSsingWin(MainFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		back = new ImageIcon("src/miniproject/images/ssing/sosokSing.png");
		talk = new ImageIcon("src/miniproject/images/ssing/talkframe.png");
		charac01 = new ImageIcon("src/miniproject/images/ssing/Characters01.gif");
		win = new ImageIcon("src/miniproject/images/ssing/win.png");
		this.addMouseListener(new clickPanel());
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(back.getImage(), 0, 0, null);
		g.drawImage(talk.getImage(), 5, 620, 1390, 250, null);
		g.drawImage(win.getImage(),350,50,700,170,null);
		if (charac01 != null) {
			g.drawImage(charac01.getImage(), 500, 250, 398, 398, this);
		}
		g.setFont(new Font("Neo둥근모", Font.BOLD, 40));
		g.drawString("만세~! 노래 능력치가 올랐다!!", 70, 750);
		
		setOpaque(false);
		super.paintComponent(g);
	}
	
	
	class clickPanel extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			//ChangePanel.replacePanel(mf, panel, new Ssing2());
			//ChangePanel cp = new ChangePanel(mf,panel, panel);
			
			ChangePanel.changePanel(mf, panel, new MiniGameSosok(mf));
			mf.revalidate();
			
		}

	}
	
}

