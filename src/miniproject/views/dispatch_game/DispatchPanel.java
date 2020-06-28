package miniproject.views.dispatch_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.ending.EndingBack01;
import miniproject.views.ending.EndingBack02;
import miniproject.views.ending.EndingBack03;

public class DispatchPanel extends JPanel implements KeyListener{
	private static final int SCREEN_WIDTH = 1400;
	private static final int SCREEN_HEIGHT = 900;
	MainFrame mf;         //MainFrame ���� ������ �Ѱܹ޴� ����
	JPanel panel;      //�г��� Ÿ�� ����
	Player123 player;

	int x = 100 ;      // player�� �ʱ� x ��ǥ ��ġ
	int y = 100 ;       // player�� �ʱ� y ��ǥ ��ġ

	int bx = 0;             //��ü ��� ��ũ�� �� ����

	boolean KeyUp = false;      //Ű������ ���� ���� (��)
	boolean KeyDown = false;   //Ű������ ���� ���� (�Ʒ�)
	boolean KeyLeft = false;   //Ű������ ���� ���� (����)
	boolean KeyRight = false;   //Ű������ ���� ���� (������)
	boolean KeySpace = false;   //�ɸ��� ���� ��ǥ ��ġ Ȯ�� ����
	
	boolean stopAll = false;

	int cnt = 0;            //�÷��̾� �߻���Ű�� ī���� ����
	int cnt2 = 0;            //��Ʈ �߻���Ű�� ī���� ����
	int cnt3 = 0;            //�� �߻���Ű�� ī���� ����

	int player_Speed;         // ������ �ɸ��Ͱ� �����̴� �ӵ��� ������ ����
	int score_Speed;         // ������ ���󰡴� �ӵ� ������ ����
	int dispatch_Speed;      // ����ġ�� ������� �ӵ� ������ ����   
	int star_Speed;         // ���� ������� �ӵ� ������ ����
	int heart_Speed;      // ��Ʈ�� ������� �ӵ� ������ ����
	int player_Status = 0;      // ���� ĳ���� ���� üũ ���� 0: ����, 1: �浹
	int game_Score = 0;          // ���� ���� ���

	Timer timer;
	private int timeLeft = 30;      //���� �ð� 30�ʷ� ����
	private JLabel lbTimeLeft;      //"���� �ð� : " �̶�� ���ڿ� ��� ��
	private JLabel totalScore;      //�� ���� �󺧿� ���϶� ���� ����
	private JTextField printText;   //�� ���� ���â

	Thread thPlayer;            //�÷��̾� ������
	Thread thStar;               //�� ������
	Thread thHeart;               //��Ʈ ������


	Image bg_img;            // ���ȭ�� �̹���
	Image player_img;         // �÷��̾� �̹���

	Image dispatch_img;         // ���ؾ� �� ����ġ �̹���
	Image heart_img;         // �Ծ�� �� ������Ʈ �̹���
	Image star_img;            // �Ծ�� �� ������Ÿ �̹���

	ArrayList<Score> Score_List = new ArrayList<Score>();               //����ġ �ӵ�, x�� y ��ǥ�� �־�ΰ� �޾ƿ��� list
	ArrayList<Score_heart> Scoreh_List = new ArrayList<Score_heart>();      //��Ʈ �ӵ�, x�� y ��ǥ�� �־�ΰ� �޾ƿ��� list
	ArrayList<Score_star> Scores_List = new ArrayList<Score_star>();      //�� �ӵ�, x�� y ��ǥ�� �־�ΰ� �޾ƿ��� list

	Image buffImage;      //���� ���� ����
	Graphics buffg;         //���� ���� �̹����� �׸��� ���� �׷��� ��ü ����

	//������ Ŭ���� ����Ű
	Score sc;            //����ġ Ŭ������ ���� ����
	Score_heart sc_heart;   //��Ʈ Ŭ������ ���� ����
	Score_star sc_star;      //�� Ŭ������ ���� ����


	public DispatchPanel (MainFrame mf, Player123 player) {
		System.out.println(player.getUserId());
		this.mf = mf;
		panel = this;
		this.player = player;

		init();            //�̹��� ������ ���� ���ھ� �ʱ�ȭ �� �ӵ� ����
		start();         //������ ���� �� Ÿ�̸ӿ� paint �׸��� �޼ҵ� ����
		setFocusable(true);   //��Ŀ���� �������� �ƴ� �гο��� �ֱ�
		KeyProcess();      //Ű������ �۵� �κ�
	}

	public void init() {
		//�̹��� �־��ְ� ���� ���ھ� �ʱ�ȭ , �ӵ� ����

		//�÷��̾� �̹���
		player_img = new ImageIcon("src/miniproject/images/dispatch_images/chracter/CharactersM.gif"
				+ "").getImage().getScaledInstance(80, 80, 0);
		//���� �̹���, getScaledInstance �� ������ ���ڷ� java.awt.Image.SCALE_SMOOTH �� �Ẹ��( ���� )
		dispatch_img = new ImageIcon("src/miniproject/images/dispatch_images/miniGame/score_avoid.png").getImage().getScaledInstance(80, 80, 0);
		heart_img = new ImageIcon("src/miniproject/images/dispatch_images/miniGame/score_heart.png").getImage().getScaledInstance(80, 80, 0);
		star_img = new ImageIcon("src/miniproject/images/dispatch_images/miniGame/score_star.png").getImage().getScaledInstance(80, 80, 0);
		//��ü ���ȭ�� �̹���
		bg_img = new ImageIcon("src/miniproject/images/dispatch_images/miniGame/background.png").getImage().getScaledInstance(SCREEN_WIDTH, SCREEN_HEIGHT, 0);

		game_Score = player.getTotalScore();          //���� ���ھ� �ʱ�ȭ

		player_Speed = 10;    //���� �ɸ��� �����̴� �ӵ� ����
		score_Speed = 5;    //������ ������� �ӵ� ����, ���� ���� ������

		dispatch_Speed = 2;   //����ġ �ӵ� ����
		heart_Speed= 2;      //��Ʈ �ӵ� ����
		star_Speed = 2;      //�� �ӵ� ����

		Image talk = new ImageIcon("src/miniproject/images/ssing/talkframe.png")
				.getImage().getScaledInstance(800, 400,java.awt.Image.SCALE_SMOOTH );

		totalScore = new JLabel();
		totalScore.setIcon(new ImageIcon(talk));
		totalScore.setLayout(null);
		totalScore.setBounds(300,0,1000,1000);
		totalScore.setVisible(false);
		this.add(totalScore);
		revalidate();


		lbTimeLeft = new JLabel("�ð� : ");
		lbTimeLeft.setHorizontalAlignment(SwingConstants.CENTER);
		lbTimeLeft.setFont(new Font("�޸տ�����", Font.BOLD, 30));
		lbTimeLeft.setForeground(Color.WHITE);
		lbTimeLeft.setBounds(100,20,250,200);
		this.add(lbTimeLeft);
		revalidate();

	}


	public void start() {

		addKeyListener(this);
		KeyProcess();      //Ű ����


		thPlayer = new playerThread();
		thPlayer.start();
		repaint();
		
		thStar = new starThread();
		thStar.start();
		repaint();

		thHeart = new heartThread();
		thHeart.start();
		repaint();

		timer = new Timer(1000, new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				if(timeLeft == 0) {
					lbTimeLeft.setText("�����ð�  : ");
					timer.stop();
					stopAll = true;			//������ ���� flag
					if(game_Score >= 500) {
						ChangePanel.changePanel(mf, panel, new EndingBack03(mf, player));
						mf.revalidate();
						
					}else if(game_Score >= 250 && game_Score <= 499) {
						ChangePanel.changePanel(mf, panel, new EndingBack02(mf, player));
						mf.revalidate();
						
					}else if(game_Score > 1 && game_Score < 250) {
						ChangePanel.changePanel(mf, panel, new EndingBack01(mf, player));
						mf.revalidate();
					}	
					

				}
				lbTimeLeft.setText("�����ð� : " + timeLeft);
				timeLeft--;

			}
		});

		timer.start();

		if(game_Score < 0 || timeLeft == 0) {
			timer.stop();
			stopAll = true;			//������ ���� flag
			
		}




	}

	class starThread extends Thread{
		public starThread() {

		}

		@Override
		public void run() {
			try{
				while(true) {
					if(!(stopAll)) {
					repaint();
					cnt++;
					System.out.println("cnt1 : " + cnt);
					sleep(10);
					starProcess();
					}
				}

			} catch(Exception e) {
				System.out.println("starThread ����");
				e.printStackTrace();
			}
		}

		public void starProcess() {
			//�� �浹 ����
			for(int i = 0; i < Scores_List.size(); ++i) {
				sc_star = (Score_star) (Scores_List.get(i));
				sc_star.move();
				if(sc_star.x < -200) {
					Scores_List.remove(i);
				}

				if(Crash(x,y, sc_star.x, sc_star.y, player_img, star_img)) {

					Scores_List.remove(i);   //�� ����
					game_Score += 30;      //���� ������ +30��
					System.out.println("game_score : " + game_Score);
				}

				if(game_Score < 0) {
					thStar.interrupt();

				}
			}
			//���� ����
			if(cnt % 200 == 0) {
				//�� ����

				for(int m = (int)(Math.random()*900 + 1); m < (SCREEN_HEIGHT -80); m+=500) {
					sc_star = new Score_star(SCREEN_WIDTH + 
							(int)(Math.random()*70 + 1), (int)(Math.random()*720 + 1), star_Speed + (int)(Math.random()*7 + 3));
					Scores_List.add(sc_star);
				}

			}

		}
	}

	class heartThread extends Thread{
		public heartThread() {

		}

		@Override
		public void run() {
			try{
				while(true) {
					if(!(stopAll)) {
					repaint();
					cnt2++;
					Thread.sleep(10);
					heartProcess();
					}
				}

			} catch(Exception e) {
				System.out.println("heartThread ����");
				e.printStackTrace();
			}
		}
		public void heartProcess() {
			//��Ʈ �浹 ����
			for(int i = 0; i < Scoreh_List.size(); ++i) {
				sc_heart = (Score_heart) (Scoreh_List.get(i));
				sc_heart.move();
				if(sc_heart.x < -200) {
					Scoreh_List.remove(i);
				}

				if(Crash(x,y, sc_heart.x, sc_heart.y, player_img, heart_img)) {

					Scoreh_List.remove(i);   //�� ����
					game_Score += 30;      //���� ������ +30��
					System.out.println("game_score : " + game_Score);
				}

				if(game_Score < 0) {
					thHeart.interrupt();

				}
			}
			if(cnt2 % 200 == 0) {

				//��Ʈ ���� , x ��ǥ  & �ӵ� ���� �� ����
				for(int k = (int)(Math.random()*720+ 1); k < (SCREEN_HEIGHT -80); k+=(int)(Math.random()*720+ 1)) {
					sc_heart = new Score_heart(SCREEN_WIDTH + 
							(int)(Math.random()*70 + 1),(int)(Math.random()*780+ 1), heart_Speed + (int)(Math.random()*7+ 3));
					Scoreh_List.add(sc_heart);
				}
			}
		}

	}

	class playerThread extends Thread {

		public playerThread() {

		}

		@Override
		public void run() {
			try{
				while(true) {
					if(!(stopAll)) {
					KeyProcess();      //Ű ����
					repaint();
					cnt3++;
					Thread.sleep(30);
					playerProcess();
					}
				}
			} catch(Exception e) {
				System.out.println("run() ����");
				e.printStackTrace();
			}
		}

		public void playerProcess() {

			for(int i = 0; i < Score_List.size(); ++i) {
				sc = (Score) (Score_List.get(i));
				sc.move();
				if(sc.x < -200 ) {
					Score_List.remove(i);
				}

				//����ġ �浹 ����
				if (Crash(x, y, sc.x, sc.y, player_img, dispatch_img)) {
					//�÷��̾�� ���� �浹�� �����Ͽ� check���� ���� �޾� true�� �Ʒ��� ����
					Score_List.remove(i);   //���� ����
					game_Score -= 10;      //�� ��ġ�� ������ -20��
					System.out.println("game_score : " + game_Score);

				}

				if(game_Score < 0) {
					stopAll = true;			//������ ���� flag
					thPlayer.interrupt();
					timer.stop();
					System.out.println("�汸�� ����");
					ChangePanel.changePanel(mf, panel, new EndingBack01(mf, player));
				}            
			}

			if(cnt3 % 100 == 0) {

				//i �� ��ġ��, �������� ���� ��ġ ���� ����,  
				//����ġ ����, x��ǥ & �ӵ� ���� �� ����
				for(int j = (int)(Math.random()*720+ 1); j < (SCREEN_HEIGHT -20); j+=45) {
					sc = new Score(SCREEN_WIDTH + 
							(int)(Math.random()*500 + 1), (int)(Math.random()*720+ 1), dispatch_Speed +(int)(Math.random()*7+ 3));
					Score_List.add(sc);

				}
			}
		}

	}

	public void Crash() {}       //��ġ �̵���
	public boolean Crash(int x1, int y1, int x2, int y2, Image player_img, Image dispatch_img) {
		//�ش� �̹����� ����, ���̰��� ���
		boolean check = false;

		if(Math.abs((x1 + player_img.getWidth(null) / 2) - (x2 + dispatch_img.getWidth(null) / 2)) <
				(dispatch_img.getWidth(null) / 2 + player_img.getWidth(null) / 2) 
				&& Math.abs((y1 + player_img.getHeight(null) / 2)  - (y2 + dispatch_img.getHeight(null) /2)) <
				(dispatch_img.getHeight(null) / 2 + player_img.getHeight(null) /2 )) {
			//�̹��� ����, ���̰��� �ٷ� �޾� ���

			check = true;   //�� ���� true�� check�� true�� ����
		} else {
			check = false;
		}

		return check;      //check�� ���� �޼ҵ忡 ���� ��Ŵ
	}

	public void paint() {}
	public void paint(Graphics g) {
		setFocusable(true);
		requestFocus();
		buffImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
		buffg = buffImage.getGraphics();
		update(g);
	}

	public void update() {}
	public void update(Graphics g) {
		Draw_Background(); // ��� �̹��� �׸��� �޼ҵ� ����
		Draw_Player(); // �÷��̾ �׸��� �޼ҵ� �̸� ����

		Draw_Score();   // ���� �׸���

		Draw_StatusText();   // ���� ǥ�� �ؽ�Ʈ�� �׸��� �޼ҵ� ����

		Draw_Ending();      //���� �׸��� �κ�

		Draw_Timer();      //Ÿ�̸� �׸��� �κ�

		g.drawImage(buffImage, 0, 0, this);      //������ ���� ���� ���� �����κ�
	}

	public void Draw_Timer() {
		buffg.drawString("���� �ð��� : " + timeLeft +"�Դϴ�.",700, 70);
	}

	public void Draw_Ending() {
	}

	public void Draw_Background() {
		if(game_Score >= 0) {
			//ȭ�� ����� ���
			buffg.clearRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
			if(bx> - 1400) {
				buffg.drawImage(bg_img, bx, 0, this);
				bx -= 1;
				buffg.drawImage(bg_img, bx+1401, 0, this);
			} else {
				bx = 0;
			}
		} else {
			buffg.drawImage(bg_img, bx, 0, this);
			buffg.drawImage(bg_img, bx+1399, 0, this);
		}
	}

	public void Draw_Player() {
		buffg.drawImage(player_img, x, y, this);
	}

	public void Draw_StatusText() {
		//���� üũ�� �ؽ�Ʈ�� �׸��ϴ�.
		buffg.setFont(new Font("serif", Font.BOLD, 20));
		//��Ʈ ���� : ����, ����, ������ 20

		buffg.drawString("Score : "  + game_Score, 1000, 70);
		//��ǥ x : 1000, y : 70 �� ���ھ ǥ��

	}   

	public void Draw_Score() {

		//����ġ �׸� �׸���
		for (int i = 0; i < Score_List.size(); ++i) {
			sc = (Score) (Score_List.get(i));
			buffg.drawImage(dispatch_img, sc.x,   sc.y, this);
		}

		//��Ʈ �׸� �׸���
		for ( int i= 0; i < Scoreh_List.size(); ++i) {
			sc_heart = (Score_heart) (Scoreh_List.get(i));
			buffg.drawImage(heart_img, sc_heart.x, sc_heart.y, this);
		}

		//�� �׸� �׸���
		for ( int i= 0; i < Scores_List.size(); ++i) {
			sc_star = (Score_star) (Scores_List.get(i));
			buffg.drawImage(star_img, sc_star.x, sc_star.y, this);
		}

	}

	public void KeyProcess() {
		if(KeyUp == true) {
			if (y > 20)
				y -= 10;               //�ɸ��Ͱ� �������� ȭ�� ���� �� �Ѿ�� �մϴ�.
		}

		if(KeyDown == true) {
			if (y + player_img.getHeight(null)+40 < SCREEN_HEIGHT)
				y += 10;               //�ɸ��Ͱ� �������� ȭ�� �Ʒ��� �� �Ѿ�� �մϴ�.
		}

		if(KeyLeft == true) {
			if(x > 0)
				x -= 10;               //�ɸ��Ͱ� �������� ȭ�� �������� �� �Ѿ�� �մϴ�.
		}

		if(KeyRight == true) {
			if(x + player_img.getWidth(null) < SCREEN_WIDTH)
				x += 10;               //�ɸ��Ͱ� �������� ȭ�� ���������� �� �Ѿ�� �մϴ�.
		}

		if(KeySpace == true) {
			//��ǥ Ȯ�ο�
			System.out.println( x+ ", " + y);

		}
	}

	@Override
	public void keyPressed(KeyEvent e) {      //Ű�� ������ �� ����
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP :
			KeyUp = true;
			break;

		case KeyEvent.VK_DOWN :
			KeyDown = true;
			break;

		case KeyEvent.VK_LEFT :
			KeyLeft = true;
			break;

		case KeyEvent.VK_RIGHT :
			KeyRight = true;
			break;

		case KeyEvent.VK_SPACE :
			KeySpace = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {      //Ű�� ������ �� ����

		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP :
			KeyUp = false;
			break;

		case KeyEvent.VK_DOWN :
			KeyDown = false;
			break;

		case KeyEvent.VK_LEFT :
			KeyLeft = false;
			break;

		case KeyEvent.VK_RIGHT :
			KeyRight = false;
			break;

		case KeyEvent.VK_SPACE :
			KeySpace = false;
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}