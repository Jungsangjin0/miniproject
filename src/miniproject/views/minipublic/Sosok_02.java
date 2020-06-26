package miniproject.views.minipublic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.somang.MiniGameSsing;

public class Sosok_02 extends JPanel {

	private MainFrame mf;
	private JPanel panel;

	private ImageIcon back; //배경
	private ImageIcon talk; //대화상자
	private Image doorR; //소속사 문(미니게임 춤)
	private Image doorL; //소속사 문(미니게임 노래)

	public Sosok_02(MainFrame mf) {

		this.mf=mf;
		panel = this;
		this.setLayout(null);

		back = new ImageIcon("src/miniproject/images/SJH/minibackgroundfinish.PNG"); //배경-소속사
		talk = new ImageIcon("src/miniproject/images/SJH/conv.PNG"); //대화창

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(back.getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
		g.drawImage(talk.getImage(), 0, 600, 1400, 250,null); //원래 위치 : 0,600,1400,250
		g.drawString("사장님.......", 100, 700);
	
	}


	class clickButtonL extends MouseAdapter{  //수정필요 0626 17:24
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, panel, new Sosok_03(mf));
			mf.revalidate();
		}


	}
}

