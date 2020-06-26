package miniproject.views.minigame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import minigame.view.MiniGamePanel3_Win;
//import minigame.view.MiniGamePanel2.MyMouseAdapter;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.somang.Sosok;

public class MiniGamePanel2 extends JPanel  { // 미니게임 연결화면 (춤연습장 들어가서 두번째화면) -> 다시 소속사 
											  // 키보드 입력받을 때 두번째화면 문제(화살표) 안뜸..., 게임 조건(3문제(화살표21개)중 2줄 이상 맞춰야 스킬+1, 아니면 실패 후 나가기.
	private ImageIcon back;
	private ImageIcon talk;
	private ImageIcon characters;
	private MainFrame mf;
	private JPanel panel2;
	private int x = 300;  //고정(첫번째화살표 위치값)
	private int x2 = 300; //고정(두번째화살표 위치값)
	private JLabel[] arrows; //화살표(문제)
	private int[] arrNo; //화살표(문제)
	private ArrayList<JLabel> inputs;
	private int ctn = 0;
	private int index = 0;
	int num = 0;
	//----점수출력	
	int su = 0;
	//---------	

	public int point = 0;
	private JTextField keyScore;
	


	public MiniGamePanel2(MainFrame mf) { //게임화면

		this.mf=mf;
		panel2 = this;
		this.setLayout(null);

		back = new ImageIcon("src/miniproject/images/SJH/minigamekey.PNG"); //배경
		talk = new ImageIcon("src/miniproject/images/SJH/conv.PNG"); //대화창
		characters = new ImageIcon("src/miniproject/images/SJH/Characters_1.GIF"); //캐릭터
		
//		mf.setFocusable(true);

		//화살표(문제)
		arrows = new JLabel[7];
		inputs = new ArrayList<JLabel>();
		arrNo = new int[7];


		panel2.addMouseListener(new MyMouseAdapter());


		buttonInit();
		

		mf.addKeyListener(new KeyAdapter() {		//**this로 하면 절대안됨........z

			@Override
			public void keyPressed(KeyEvent e) { 
				System.out.println(e.getKeyCode()+ " 첫번째 확인용 ");

				//a = answer1.getText();
				int num = 0;

				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					num = 4;
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					num = 3;
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					num = 2;
				}
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					num = 1;
				}


				addButton(num);	//(안생김.........ㅋ안ㅋ됨ㅋ)->해결함.	
				ctn++;
			}


		});

	}

	//첫번재 화살표 출력(문제)
	public void buttonInit(){
			
		for(int i = 0; i < arrows.length; ++i) {
			int num = new Random().nextInt(4) + 1;
			arrNo[i] = num;
			ImageIcon arrow = new ImageIcon("src/miniproject/images/SJH/"+num+"-blue.png");
			//URL url = getClass().getClassLoader().getResource(num+"-blue.png");

			arrows[i] = new JLabel(new ImageIcon(arrow.getImage().getScaledInstance(150, 150, 0)));
			arrows[i].setBounds(x, 100, 150, 150);
			x += 150;
			this.add(arrows[i]);
			System.out.println("두번 확인용");

			this.repaint();
			this.revalidate();
			
		}
		
		
		
	}




	// 두번째 화살표 출력(정답)
	public void addButton(int num) { 

		//this.num = num;
		//this.addButton(num);
		//this.add(panel2);

		System.out.println("세번째확인용 :" + num);

		if(index >= 7){
			reset();
			index = 0;
		}else{
			System.out.println("네번째확인용 : " + index);

			String color = "";

			if(arrNo[index] == num) { 
				color = "blue";
				ImageIcon arrow = new ImageIcon("src/miniproject/images/SJH/"+num+"-"+color+".png");

				//URL url = getClass().getClassLoader().getResource("pororo-"+num+".png");


				//point-----------------------------------------------------------------------
				point += 1;
				System.out.println("점수확인 : " + point);
				
				System.out.println("다섯번째확인용 : " + index);
				//this.back.getImage();	
				
				if(point >=14) {
					System.out.println("14개 이상 화살표를 맞췄습니당. 춤스킬 +1 짝짝!!");

					//-------------	
					su += 1;
					keygamewin();
					//--------------		



				}else {
					System.out.println("아쉽게 스킬획득을 못했네염...ㅎ.ㅎ....");
					//-------------------				
					//keygamelose();

					this.addMouseListener(new MyMouseAdapter());

				}


				System.out.println("다섯번째확인용 : " + index);
				//this.back.getImage();		

				//--------------------------
				
				
				
				
				

			}else {
				color = "red";

				ImageIcon arrow = new ImageIcon("src/miniproject/images/SJH/"+num+"-"+color+".png");

				System.out.println("여섯번째확인용 :" + index);
				//this.back.getImage();

			}

			ImageIcon arrow = new ImageIcon("src/miniproject/images/SJH/"+num+"-"+color+".png");
			//URL url = getClass().getClassLoader().getResource(num + "-" + color + ".png");

			JLabel input = new JLabel(new ImageIcon(arrow.getImage().getScaledInstance(150, 150, 0)));
			input.setBounds(x2, 350, 150, 150);
			inputs.add(input);
			x2 += 150;
			this.add(inputs.get(index));
			System.out.println("일곱번째 확인용");
			this.repaint();
			//this.revalidate();
			index++;

		}


	}

	
	//point----------------------------------------
		public void keyScore() {
			keyScore = new JTextField("맞춘개수 : " + point);
			keyScore.setFont(new Font("Sanscerif", Font.BOLD, 20));
			keyScore.setBorder(BorderFactory.createEmptyBorder());
			keyScore.setBackground(Color.blue);
			this.setComponentZOrder(keyScore, 0);
			keyScore.setBounds(500, 0, 500, 500);
			panel2.add(keyScore);

		}

		//--------------------------------------	

	

	public void reset(){

		System.out.println("여덟번째확인용");

		//21개화살표(총3줄)까지는 리셋(7개 기준)해서 문제 출제,  
		//한줄에 7개화살표, 총 21개 화살표 
		//화살표가 7개보다 많아지면 화살표 리셋한 뒤 다시 출력 총 21개까지..
		if(ctn < 22 ) {
			
		for (int i = 0; i < arrows.length; i++) {
			this.remove(arrows[i]);
			System.out.println("아홉번째확인용" + "arrows : " + arrows +"i"+i  );
			this.repaint();
		}

		buttonInit();

		for (int i = 0; i < arrNo.length; i++) {
			this.remove(this.inputs.get(i));
			System.out.println("열번째확인용");
			this.repaint();
		}

		inputs.clear();

		System.out.println("열한번째확인용");
		mf.repaint();
		index = 0;
		x =300;
		x2 = 300;
		
		} else {
			System.out.println("end");
			
		}
	}

	public void keygamewin() {
		MiniGamePanel3_Win win = new MiniGamePanel3_Win(mf);
		ChangePanel.changePanel(mf, panel2, win);

	}
	





	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(back.getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
		g.drawImage(talk.getImage(), 0, 600, 1400, 250,null); //원래 위치 : 0,600,1400,250
		g.setFont(new Font("Neo둥근모", Font.BOLD, 30));
		g.drawString("통과하면 노래스킬 +1 !!!", 100, 700); //글씨 위치 조절 필요
		g.drawString("14개 이상 동일한 키보드를 입력하세용", 100, 750);
		g.drawImage(characters.getImage(), 10, 100, 398, 398, this); //원래크기 : 398,398
		setOpaque(false);

	}

	class MyMouseAdapter extends MouseAdapter{


		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, panel2, new MiniGamePanel3_Lose(mf));		
//			ChangePanel.changePanel(mf, panel2, new Sosok(mf));
			
			mf.revalidate();
			
		}



	}
}




