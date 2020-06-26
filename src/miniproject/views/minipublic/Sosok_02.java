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

	private ImageIcon back; //���
	private ImageIcon talk; //��ȭ����
	private Image doorR; //�Ҽӻ� ��(�̴ϰ��� ��)
	private Image doorL; //�Ҽӻ� ��(�̴ϰ��� �뷡)

	public Sosok_02(MainFrame mf) {

		this.mf=mf;
		panel = this;
		this.setLayout(null);

		back = new ImageIcon("src/miniproject/images/SJH/minibackgroundfinish.PNG"); //���-�Ҽӻ�
		talk = new ImageIcon("src/miniproject/images/SJH/conv.PNG"); //��ȭâ

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(back.getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
		g.drawImage(talk.getImage(), 0, 600, 1400, 250,null); //���� ��ġ : 0,600,1400,250
		g.drawString("�����.......", 100, 700);
	
	}


	class clickButtonL extends MouseAdapter{  //�����ʿ� 0626 17:24
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, panel, new Sosok_03(mf));
			mf.revalidate();
		}


	}
}

