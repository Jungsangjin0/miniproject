package miniproject.views.minigame;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;



public class MiniGameDance extends JPanel { // �̴ϰ��� ����ȭ�� (�㿬���� ���� ùȭ��)

	private ImageIcon back;
	private ImageIcon talk;
	private ImageIcon characters;
	private MiniGameDance panel = this;
	private MainFrame mf;


	public MiniGameDance(MainFrame mf) {

		this.mf = mf;
		this.panel = this;
		this.setLayout(null);
		back = new ImageIcon("src/miniproject/images/SJH/minigamekey.PNG"); //���
		talk = new ImageIcon("src/miniproject/images/SJH/conv.PNG"); //��ȭâ
		characters = new ImageIcon("src/miniproject/images/SJH/Characters_1.GIF"); //ĳ����


		this.addMouseListener(new MyMouseAdapter()); 
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(back.getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
		g.drawImage(talk.getImage(), 0, 600, 1400, 250,null); //���� ��ġ : 0,600,1400,250
		g.drawString("�� Ŭ���Ͽ� ������ �����ϼ��� �� ", 100, 660);
		g.drawString("���õ� �㿬���� �غ��� ��", 100, 710); //�۾� ��ġ ���� �ʿ�    //700->700
		g.drawString("Yeah �ٽ� ���ƿ��� �� �̸� ���� ������ �˳� WHOO ~ ��  ", 100, 760);   //780->750
		g.drawString("They call it ���� ��ȯ ~ �� ", 100, 810);  //850->800
		g.drawImage(characters.getImage(), 520, 200, 398, 398, this);//����ũ�� : 398,398
		setOpaque(false);
	}


	class MyMouseAdapter extends MouseAdapter{


		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, panel, new MiniGamePanel2(mf));		
			mf.revalidate();
		}



	}
}




