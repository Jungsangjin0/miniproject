package miniproject.views.minigame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MiniGamePanel extends JPanel { // �̴ϰ��� ����ȭ�� (�㿬���� ���� ùȭ��)

	private ImageIcon back;
	private ImageIcon talk;
	private ImageIcon characters;
	private JPanel panel;
	private JFrame mf;


	public MiniGamePanel(JFrame mf) {

		this.mf = mf;
		this.panel = this;
		this.setLayout(null);
		back = new ImageIcon("images/minigamekey.PNG"); //���
		talk = new ImageIcon("images/conv.PNG"); //��ȭâ
		characters = new ImageIcon("images/Characters_1.GIF"); //ĳ����


		this.addMouseListener(new MyMouseAdapter()); 
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(back.getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
		g.drawImage(talk.getImage(), 0, 600, 1400, 250,null); //���� ��ġ : 0,600,1400,250
		g.setFont(new Font("Neo�ձٸ�", Font.BOLD, 40));
		g.drawString("���õ� �㿬���� �غ��� �ε�ġ", 100, 700); //�۾� ��ġ ���� �ʿ�
		g.drawImage(characters.getImage(), 520, 200, 398, 398, this);//����ũ�� : 398,398

	}


	class MyMouseAdapter extends MouseAdapter{


		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, panel, new MiniGamePanel2(mf));		
		}



	}
}




