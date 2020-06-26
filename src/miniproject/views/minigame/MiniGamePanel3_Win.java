package miniproject.views.minigame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import miniproject.views.ChangePanel;

public class MiniGamePanel3_Win extends JPanel{ // 미니게임 이기면 나오는 화면

	private JFrame mf;
	private JPanel panel3_win;
	private ImageIcon back;
	private ImageIcon talk;
	private ImageIcon characters;
	private ImageIcon win;

	public MiniGamePanel3_Win(JFrame mf) {
		this.mf = mf;
		panel3_win = this;
		this.setLayout(null);
		back = new ImageIcon("images/minigamekey.png");
		talk = new ImageIcon("images/conv.png");
		characters = new ImageIcon("images/Characters_5.png");
		win = new ImageIcon("images/win.png");
		this.addMouseListener(new clickPanel());
		
	}
	

	public void paintComponent(Graphics g) {
		g.drawImage(back.getImage(), 0, 0,1400,900, null);
		g.drawImage(talk.getImage(), 5, 620, 1390, 250, null);
		g.drawImage(win.getImage(),350,50,700,170,null);
		if (characters != null) {
			g.drawImage(characters.getImage(), 500, 250, 398, 398, this);
		}
		g.setFont(new Font("Neo둥근모", Font.BOLD, 40));
		g.drawString("깡춤한번 더 춰볼까~ 춤능력치 +1 !!!", 70, 750);
	
		setOpaque(false);
		super.paintComponent(g);
	}


	class clickPanel extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {


			ChangePanel.changePanel(mf, panel3_win, new MiniGamePanel4(mf));
			//MiniGamePanel3

		}

	}

}




