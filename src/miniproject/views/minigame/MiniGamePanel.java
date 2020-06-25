package miniproject.views.minigame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MiniGamePanel extends JPanel { // 미니게임 연결화면 (춤연습장 들어가서 첫화면)

	private ImageIcon back;
	private ImageIcon talk;
	private ImageIcon characters;
	private JPanel panel;
	private JFrame mf;


	public MiniGamePanel(JFrame mf) {

		this.mf = mf;
		this.panel = this;
		this.setLayout(null);
		back = new ImageIcon("images/minigamekey.PNG"); //배경
		talk = new ImageIcon("images/conv.PNG"); //대화창
		characters = new ImageIcon("images/Characters_1.GIF"); //캐릭터


		this.addMouseListener(new MyMouseAdapter()); 
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(back.getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
		g.drawImage(talk.getImage(), 0, 600, 1400, 250,null); //원래 위치 : 0,600,1400,250
		g.setFont(new Font("Neo둥근모", Font.BOLD, 40));
		g.drawString("오늘도 춤연습을 해보자 두둠치", 100, 700); //글씨 위치 조절 필요
		g.drawImage(characters.getImage(), 520, 200, 398, 398, this);//원래크기 : 398,398

	}


	class MyMouseAdapter extends MouseAdapter{


		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, panel, new MiniGamePanel2(mf));		
		}



	}
}




