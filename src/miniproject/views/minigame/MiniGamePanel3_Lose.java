package  miniproject.views.minigame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;


public class MiniGamePanel3_Lose extends JPanel{ // 미니게임 지면 나오는 화면

	private MainFrame mf;
	private MiniGamePanel3_Lose panel3_lose;
	private ImageIcon back;
	private ImageIcon talk;
	private ImageIcon characters;
	private ImageIcon lose;

	public MiniGamePanel3_Lose(MainFrame mf) {
		this.mf = mf;
		panel3_lose = this;
		this.setLayout(null);
		back = new ImageIcon("src/miniproject/images/SJH/minigamekey.png");
		talk = new ImageIcon("images/conv.png");
		characters = new ImageIcon("src/miniproject/images/SJH/Lose_Characters02_1.png");
		lose = new ImageIcon("src/miniproject/images/SJH/lose.png");
		this.addMouseListener(new clickPanel());
	}

	public void paintComponent(Graphics g) {
		g.drawImage(back.getImage(), 0, 0,1400,900, null);
		g.drawImage(talk.getImage(), 5, 620, 1390, 250, null);
		g.drawImage(lose.getImage(),350,50,700,170,null);
		if (characters != null) {
			g.drawImage(characters.getImage(), 500, 250, 398, 398, this);
		}
		g.setFont(new Font("Neo둥근모", Font.BOLD, 40));
		g.drawString("아쉬워요.. 춤스킬을 얻지 못했습니다........", 70, 750);

		setOpaque(false);
		super.paintComponent(g);
	}


	class clickPanel extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			

			ChangePanel.changePanel(mf, panel3_lose, new MiniGamePanel4(mf));
			//MiniGamePanel3

		}

	}

	
}




