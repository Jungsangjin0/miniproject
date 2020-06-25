package miniproject.views.minigame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MiniGamePanel3 extends JPanel  { // �̴ϰ��� ����ȭ�� (�Ҽӻ� ȭ��)

	private ImageIcon back; //���
	private ImageIcon talk; //��ȭ����
	private ImageIcon characters; //ĳ����
	private ImageIcon boss;//�Ҽӻ� ����
	private Image doorR; //�Ҽӻ� ��(�̴ϰ��� ��)
	private Image doorL; //�Ҽӻ� ��(�̴ϰ��� �뷡)
	
	private JFrame mf;
	private JPanel panel3;
	

	public MiniGamePanel3(JFrame mf) { //����ȭ��?

		this.mf=mf;
		panel3 = this;
		this.setLayout(null);

		back = new ImageIcon("images/minibackgroundfinish.PNG"); //���-�Ҽӻ�
		talk = new ImageIcon("images/conv.PNG"); //��ȭâ
		characters = new ImageIcon("images/Characters_4.GIF"); //ĳ����
		boss = new ImageIcon("images/boss.PNG"); //�Ҽӻ� ����
		doorR = new ImageIcon("images/door.PNG").getImage().getScaledInstance(175, 238, 0); //�Ҽӻ� ��(�̴ϰ��� ��)
		doorL = new ImageIcon("images/door.PNG").getImage().getScaledInstance(175, 238, 0); //�Ҽӻ� ��(�̴ϰ��� �뷡)

		//JLabel labelR = new JLabel(doorR);  //�Ҽӻ� ��(�̴ϰ��� ��)
		//JLabel labelL = new JLabel(doorL);  //�Ҽӻ� ��(�̴ϰ��� �뷡)
		
		
		
		JButton dR = new JButton(new ImageIcon(doorR));
		JButton dL = new JButton(new ImageIcon(doorL));
		
		dR.setBounds(490,112,175,235);
		dL.setBounds(140,112,175,235);
		
		//doorR.add(labelR);
		//doorL.add(labelL);
		//doorR.setBounds(50, 50, 200, 200);  //��ư(��)
		//doorR.setBounds(50, 50, 200, 200);
		
		panel3.add(dR); //�̴ϰ��� ��
		panel3.add(dL); //�̴ϰ��� �뷡
		
		
		
		dR.addMouseListener(new clickButtonR());
		dL.addMouseListener(new clickButtonL());
		
		
	}	


	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.drawImage(back.getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
		g.drawImage(talk.getImage(), 0, 600, 1400, 250,null); //���� ��ġ : 0,600,1400,250
		g.setFont(new Font("Neo�ձٸ�", Font.BOLD, 30));
		g.drawImage(characters.getImage(), 600, 100, 398, 398, this); //����ũ�� : 398,398
		g.drawImage(boss.getImage(), 900, 100, 398, 398, this);


	}

	
	class clickButtonR extends MouseAdapter{  //�̴ϰ��� ��
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, panel3, new MiniGamePanel(mf));
		}
		
	}
	
	class clickButtonL extends MouseAdapter{  //�̴ϰ��� ��
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, panel3, new MiniGamePanel(mf));
		}
		
	}
	
	
	
/*		class MyMouseAdapter extends MouseAdapter{


		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, panel3, new MiniGamePanel4(mf));		
			}
	 



}*/
	
	
	
}





