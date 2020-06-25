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

public class MiniGamePanel3 extends JPanel  { // 미니게임 연결화면 (소속사 화면)

	private ImageIcon back; //배경
	private ImageIcon talk; //대화상자
	private ImageIcon characters; //캐릭터
	private ImageIcon boss;//소속사 사장
	private Image doorR; //소속사 문(미니게임 춤)
	private Image doorL; //소속사 문(미니게임 노래)
	
	private JFrame mf;
	private JPanel panel3;
	

	public MiniGamePanel3(JFrame mf) { //게임화면?

		this.mf=mf;
		panel3 = this;
		this.setLayout(null);

		back = new ImageIcon("images/minibackgroundfinish.PNG"); //배경-소속사
		talk = new ImageIcon("images/conv.PNG"); //대화창
		characters = new ImageIcon("images/Characters_4.GIF"); //캐릭터
		boss = new ImageIcon("images/boss.PNG"); //소속사 사장
		doorR = new ImageIcon("images/door.PNG").getImage().getScaledInstance(175, 238, 0); //소속사 문(미니게임 춤)
		doorL = new ImageIcon("images/door.PNG").getImage().getScaledInstance(175, 238, 0); //소속사 문(미니게임 노래)

		//JLabel labelR = new JLabel(doorR);  //소속사 문(미니게임 춤)
		//JLabel labelL = new JLabel(doorL);  //소속사 문(미니게임 노래)
		
		
		
		JButton dR = new JButton(new ImageIcon(doorR));
		JButton dL = new JButton(new ImageIcon(doorL));
		
		dR.setBounds(490,112,175,235);
		dL.setBounds(140,112,175,235);
		
		//doorR.add(labelR);
		//doorL.add(labelL);
		//doorR.setBounds(50, 50, 200, 200);  //버튼(문)
		//doorR.setBounds(50, 50, 200, 200);
		
		panel3.add(dR); //미니게임 춤
		panel3.add(dL); //미니게임 노래
		
		
		
		dR.addMouseListener(new clickButtonR());
		dL.addMouseListener(new clickButtonL());
		
		
	}	


	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.drawImage(back.getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
		g.drawImage(talk.getImage(), 0, 600, 1400, 250,null); //원래 위치 : 0,600,1400,250
		g.setFont(new Font("Neo둥근모", Font.BOLD, 30));
		g.drawImage(characters.getImage(), 600, 100, 398, 398, this); //원래크기 : 398,398
		g.drawImage(boss.getImage(), 900, 100, 398, 398, this);


	}

	
	class clickButtonR extends MouseAdapter{  //미니게임 춤
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, panel3, new MiniGamePanel(mf));
		}
		
	}
	
	class clickButtonL extends MouseAdapter{  //미니게임 춤
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





