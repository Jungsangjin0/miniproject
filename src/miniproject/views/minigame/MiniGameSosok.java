package miniproject.views.minigame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;

public class MiniGameSosok extends JPanel  { // �̴ϰ��� ����ȭ�� (�Ҽӻ� ȭ��)

	private ImageIcon back; //���
	private ImageIcon talk; //��ȭ����
	private ImageIcon characters; //ĳ����
	private ImageIcon boss;//�Ҽӻ� ����
	private Image doorR; //�Ҽӻ� ��(�̴ϰ��� ��)
	private Image doorL; //�Ҽӻ� ��(�̴ϰ��� �뷡)
	
	private MainFrame mf;
	private JPanel panel4;
	

	public MiniGameSosok(MainFrame mf) { //����ȭ��?

		this.mf=mf;
		panel4 = this;
		this.setLayout(null);

		back = new ImageIcon("src/miniproject/images/SJH/minibackgroundfinish.PNG"); //���-�Ҽӻ�
		talk = new ImageIcon("src/miniproject/images/SJH/conv.PNG"); //��ȭâ
		characters = new ImageIcon("src/miniproject/images/SJH/Characters_5.png"); //ĳ����
		boss = new ImageIcon("src/miniproject/images/SJH/boss.PNG"); //�Ҽӻ� ����
		doorR = new ImageIcon("src/miniproject/images/SJH/door.PNG").getImage().getScaledInstance(175, 282, 0); //�Ҽӻ� ��(�̴ϰ��� ��)
		doorL = new ImageIcon("src/miniproject/images/SJH/door.PNG").getImage().getScaledInstance(175, 282, 0); //�Ҽӻ� ��(�̴ϰ��� �뷡)

		//JLabel labelR = new JLabel(doorR);  //�Ҽӻ� ��(�̴ϰ��� ��)
		//JLabel labelL = new JLabel(doorL);  //�Ҽӻ� ��(�̴ϰ��� �뷡)
		
		
		
		JButton dR = new JButton(new ImageIcon(doorR));
		JButton dL = new JButton(new ImageIcon(doorL));
		
		dR.setBounds(496,118,175,282);
		dL.setBounds(142,118,175,282);
		
		//doorR.add(labelR);
		//doorL.add(labelL);
		//doorR.setBounds(50, 50, 200, 200);  //��ư(��)
		//doorR.setBounds(50, 50, 200, 200);
		
		panel4.add(dR); //�̴ϰ��� ��
		panel4.add(dL); //�̴ϰ��� �뷡
		
		
		
		dR.addMouseListener(new clickButtonR());
		dL.addMouseListener(new clickButtonL());
		
		
	}	


	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.drawImage(back.getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
		g.drawImage(talk.getImage(), 0, 600, 1400, 250,null); //���� ��ġ : 0,600,1400,250
		g.setFont(new Font("Neo�ձٸ�", Font.BOLD, 30));
		g.drawString("���� Ŭ���ؼ� �뷡�� �㿬���� ����~", 100, 700);
		g.drawImage(characters.getImage(), 600, 100, 398, 398, this); //����ũ�� : 398,398
		g.drawImage(boss.getImage(), 900, 100, 398, 398, this);
		setOpaque(false);

	}

	
	class clickButtonR extends MouseAdapter{  //�̴ϰ��� ��
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, panel4, new MiniGameSosok(mf));
			mf.revalidate();
		}
		
	}
	
	class clickButtonL extends MouseAdapter{  //�̴ϰ��� �뷡  -> ���⿡ �뷡ȭ�� �޾Ƽ� �����ؾ���~
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, panel4, new MiniGameSosok(mf));
			mf.revalidate();
		}
		
		
	}
	
	
	
/*		class MyMouseAdapter extends MouseAdapter{


		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, panel3, new MiniGamePanel4(mf));		
			}
	 



}*/
	
	
	
}





