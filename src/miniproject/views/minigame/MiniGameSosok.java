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

public class MiniGameSosok extends JPanel  { // 미니게임 연결화면 (소속사 화면)

	private ImageIcon back; //배경
	private ImageIcon talk; //대화상자
	private ImageIcon characters; //캐릭터
	private ImageIcon boss;//소속사 사장
	private Image doorR; //소속사 문(미니게임 춤)
	private Image doorL; //소속사 문(미니게임 노래)
	
	private MainFrame mf;
	private JPanel panel4;
	

	public MiniGameSosok(MainFrame mf) { //게임화면?

		this.mf=mf;
		panel4 = this;
		this.setLayout(null);

		back = new ImageIcon("src/miniproject/images/SJH/minibackgroundfinish.PNG"); //배경-소속사
		talk = new ImageIcon("src/miniproject/images/SJH/conv.PNG"); //대화창
		characters = new ImageIcon("src/miniproject/images/SJH/Characters_5.png"); //캐릭터
		boss = new ImageIcon("src/miniproject/images/SJH/boss.PNG"); //소속사 사장
		doorR = new ImageIcon("src/miniproject/images/SJH/door.PNG").getImage().getScaledInstance(175, 282, 0); //소속사 문(미니게임 춤)
		doorL = new ImageIcon("src/miniproject/images/SJH/door.PNG").getImage().getScaledInstance(175, 282, 0); //소속사 문(미니게임 노래)

		//JLabel labelR = new JLabel(doorR);  //소속사 문(미니게임 춤)
		//JLabel labelL = new JLabel(doorL);  //소속사 문(미니게임 노래)
		
		
		
		JButton dR = new JButton(new ImageIcon(doorR));
		JButton dL = new JButton(new ImageIcon(doorL));
		
		dR.setBounds(496,118,175,282);
		dL.setBounds(142,118,175,282);
		
		//doorR.add(labelR);
		//doorL.add(labelL);
		//doorR.setBounds(50, 50, 200, 200);  //버튼(문)
		//doorR.setBounds(50, 50, 200, 200);
		
		panel4.add(dR); //미니게임 춤
		panel4.add(dL); //미니게임 노래
		
		
		
		dR.addMouseListener(new clickButtonR());
		dL.addMouseListener(new clickButtonL());
		
		
	}	


	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.drawImage(back.getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
		g.drawImage(talk.getImage(), 0, 600, 1400, 250,null); //원래 위치 : 0,600,1400,250
		g.setFont(new Font("Neo둥근모", Font.BOLD, 30));
		g.drawString("문을 클릭해서 노래와 춤연습을 하자~", 100, 700);
		g.drawImage(characters.getImage(), 600, 100, 398, 398, this); //원래크기 : 398,398
		g.drawImage(boss.getImage(), 900, 100, 398, 398, this);
		setOpaque(false);

	}

	
	class clickButtonR extends MouseAdapter{  //미니게임 춤
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, panel4, new MiniGameSosok(mf));
			mf.revalidate();
		}
		
	}
	
	class clickButtonL extends MouseAdapter{  //미니게임 노래  -> 여기에 노래화면 받아서 연결해야함~
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





