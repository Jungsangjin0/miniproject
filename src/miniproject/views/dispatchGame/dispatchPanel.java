package miniproject.views.dispatchGame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;


public class dispatchPanel extends JPanel implements KeyListener, Runnable{
	private static final int SCREEN_WIDTH = 1400;
	private static final int SCREEN_HEIGHT = 900;
	
	JFrame mf;
	JPanel dpl;
	
	int x = 100 ;		// player�� �ʱ� ��ġ
	int y = 100 ; 

	int[] cx = { 0, 0, 0 }; 	//��� ��ũ�� �ӵ� ����� ����
	int bx = 0; 				//��ü ��� ��ũ�� �� ����

	boolean KeyUp = false;
	boolean KeyDown = false;
	boolean KeyLeft = false;
	boolean KeyRight = false;
	boolean KeySpace = false;

	int cnt;

	int player_Speed;			// ������ �ɸ��Ͱ� �����̴� �ӵ��� ������ ����
	int score_Speed;			// ������ ���󰡴� �ӵ� ������ ����
		int dispatch_Speed;		// ����ġ�� ������� �ӵ� ������ ����	
		int star_Speed;			// ���� ������� �ӵ� ������ ����
		int heart_Speed;		// ��Ʈ�� ������� �ӵ� ������ ����
	int player_Status = 0;		// ���� ĳ���� ���� üũ ���� 0: ����, 1: �浹
	int game_Score; 			// ���� ���� ���

	Thread th;
	Thread th1;
	Thread th2;
//	HeartThread hth ;
	private Vector<Thread> targetThreadV = new Vector<Thread>();
	private Vector<JLabel> targetLabelV = new Vector<JLabel>();
	
	//Image[] Score_img;		//����ġ, ��Ʈ, �� ���� �̹��� ( �����Ⱦ� )

	Image bg_img;				// ���ȭ�� �̹���
	Image player_img;			// �÷��̾� �̹���

	Image dispatch_img;			// ���ؾ� �� ����ġ �̹���
	Image heart_img;			// �Ծ�� �� ������Ʈ �̹���
	Image star_img;				// �Ծ�� �� ������Ÿ �̹���

	ArrayList<Score> Score_List = new ArrayList<Score>();
	ArrayList<Score_heart> Scoreh_List = new ArrayList<Score_heart>();
	ArrayList<Score_star> Scores_List = new ArrayList<Score_star>();

	Image buffImage;		//���� ���� ����
	Graphics buffg;			//���� ���� �̹����� �׸��� ���� �׷��� ��ü ����

	//������ Ŭ���� ����Ű
	Score sc;
	Score_heart sc_heart;
	Score_star sc_star;

public	dispatchPanel(JFrame mf) {
		this.mf = mf;
		dpl = this;
//		System.out.println("this: " + this);
		init();
		start();
		
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);

		//ȭ�� ũ�� �����Ͽ� setLocation ���� ���ַ��� �� ( �ʿ�� ��� )
		//		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();		//ȭ�� ũ�� ����
		//		
		//		int f_xpos = (int) (screen.getWidth() / 2 - Run.SCREEN_WIDTH / 2);
		//		int f_ypos = (int) (screen.getHeight() / 2 - Run.SCREEN_HEIGHT / 2);
		//		System.out.println("x: " + f_xpos + ", y : " + f_ypos);
		//		setLocation(f_xpos, f_ypos);

		
		setVisible(true);

	}

	public void init() {
		//�̹��� �־��ְ� ���� ���ھ� �ʱ�ȭ , �ӵ� ����

		//�÷��̾� �̹���
		player_img = new ImageIcon("src/miniproject/images/dispatch_images/chracter/character.png"
				+ "").getImage().getScaledInstance(80, 80, 0);
		//���� �̹���, getScaledInstance �� ������ ���ڷ� java.awt.Image.SCALE_SMOOTH �� �Ẹ��( ���� )
		dispatch_img = new ImageIcon("src/miniproject/images/dispatch_images/miniGame/score_avoid.png").getImage().getScaledInstance(80, 80, 0);
		heart_img = new ImageIcon("src/miniproject/images/dispatch_images/miniGame/score_heart.png").getImage().getScaledInstance(80, 80, 0);
		star_img = new ImageIcon("src/miniproject/images/dispatch_images/miniGame/score_star.png").getImage().getScaledInstance(80, 80, 0);
		//��ü ���ȭ�� �̹���
		bg_img = new ImageIcon("src/miniproject/images/dispatch_images/miniGame/background.png").getImage().getScaledInstance(1400, 900, 0);

		game_Score = 0;	 		//���� ���ھ� �ʱ�ȭ

		player_Speed = 10; 	//���� �ɸ��� �����̴� �ӵ� ����
		score_Speed = 5; 	//������ ������� �ӵ� ����, ���� ���� ������
		
		dispatch_Speed = 2;
		heart_Speed= 2;
		star_Speed = 2;

	}


	public void start() {
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.addKeyListener(this);

		th = new Thread(this);
		th.start();
		
//		HeartThread htThread = new HeartThread();
//		htThread.start();

	}

	@Override
	public void run() {
		try{
			while(true) {
				KeyProcess();		//Ű ����

				ScoreProcess();		//���� ���۰���

				repaint();

				Thread.sleep(10);
				cnt++;
			}

		} catch(Exception e) {
			System.out.println("run() ����");
			e.printStackTrace();
		}
	}


	public void ScoreProcess() {
		for(int i = 0; i < Score_List.size(); ++i) {
			sc = (Score) (Score_List.get(i));
			sc.move();
			if(sc.x < -200) {
				Score_List.remove(i);
			}

			//����ġ �浹 ����
			if (Crash(x, y, sc.x, sc.y, player_img, dispatch_img)) {
				//�÷��̾�� ���� �浹�� �����Ͽ� check���� ���� �޾� true�� �Ʒ��� ����
				Score_List.remove(i);	//���� ����
				game_Score -= 20;		//�� ��ġ�� ������ -20��
				System.out.println("game_score : " + game_Score);
				
			} 
			
			else if(Crash(x,y, sc.x, sc.y, player_img, heart_img)) {
				
				Score_List.remove(i);	//��Ʈ ����
				game_Score += 30;
				System.out.println("game_score : " + game_Score);
			}
			
			if(game_Score < 0) {
				System.out.println("�汸�� ����");
				th.interrupt();
			}
		}
		
//		//��Ʈ �浹 ����
//		for(int i = 0; i < Scoreh_List.size(); ++i) {
//			sc_heart = (Score_heart) (Scoreh_List.get(i));
//			sc_heart.move();
//			if(sc_heart.x < -200) {
//				Scoreh_List.remove(i);
//			}
//
//			if(Crash(x,y, sc_heart.x, sc_heart.y, player_img, heart_img)) {
//
//				Scoreh_List.remove(i);	//�� ����
//				game_Score += 30;		//���� ������ +30��
//				System.out.println("game_score : " + game_Score);
//			}
//
//			if(game_Score < 0) {
//				System.out.println("�汸�� ����");
//				th.interrupt();
//			}
//		}
			//�� �浹 ����
			for(int i = 0; i < Scores_List.size(); ++i) {
				sc_star = (Score_star) (Scores_List.get(i));
				sc_star.move();
				if(sc_star.x < -200) {
					Scores_List.remove(i);
				}
				
				if(Crash(x,y, sc_star.x, sc_star.y, player_img, star_img)) {
					
					Scores_List.remove(i);	//�� ����
					game_Score += 30;		//���� ������ +30��
					System.out.println("game_score : " + game_Score);
				}

				if(game_Score < 0) {
					JOptionPane.showMessageDialog(null, "����� ������ " + game_Score+ "�Դϴ�" );
					System.out.println("�汸�� ����");
					th.interrupt();
				}
			}

			//���� ����
			if(cnt % 200 == 0) {
				//i �� ��ġ��, �������� ���� ��ġ ���� ����,  
				//����ġ ����, x��ǥ & �ӵ� ���� �� ����
				for(int i = (int)(Math.random()*820+ 1); i < (SCREEN_HEIGHT -80); i+=50) {
					sc = new Score(SCREEN_WIDTH + 
							(int)(Math.random()*70 + 1), i, dispatch_Speed +(int)(Math.random()*7+ 3));
					Score_List.add(sc);
				}
				
//				//��Ʈ ���� , x ��ǥ  & �ӵ� ���� �� ����
//				for(int i = (int)(Math.random()*820+ 1); i < (Run.SCREEN_HEIGHT -80); i+=150) {
//					sc_heart = new Score_heart(Run.SCREEN_WIDTH + 
//							(int)(Math.random()*70 + 1), i, heart_Speed + (int)(Math.random()*7+ 3));
//					Scoreh_List.add(sc_heart);
//				}
				
				//�� ����
				for(int i = (int)(Math.random()*820 + 1); i < (SCREEN_HEIGHT -80); i+=150) {
					sc_star = new Score_star(SCREEN_WIDTH + 
							(int)(Math.random()*70 + 1), i, star_Speed + (int)(Math.random()*7 + 3));
					Scores_List.add(sc_star);
				}
				
		}
	}
	
	class HeartThread extends Thread{
		public HeartThread() {
			
		}
		
		@Override
		public void run() {
			try {
				while(true) {

					ScoreHeartProcess();
					Draw_heartScore();
					Thread.sleep(10);
					
				}
			} catch(Exception e) {
				System.out.println("HeartThread ����...");
				e.printStackTrace();
			}
		}
		
		public void paint() {}
		public void paint(Graphics g) {
			buffImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
			buffg = buffImage.getGraphics();
			update(g);
		}
		
		public void update() {}
		public void update(Graphics g) {

			Draw_heartScore();
			g.drawImage(buffImage, 0, 0, new dispatchPanel(mf));
		}
		public void Draw_heartScore() {
			//��Ʈ �׸� �׸���
			for ( int i= 0; i < Scoreh_List.size(); ++i) {
				sc_heart = (Score_heart) (Scoreh_List.get(i));
				buffg.drawImage(heart_img, sc_heart.x, sc_heart.y, new dispatchPanel(mf) );
			}
			
		}

		public void ScoreHeartProcess() {
			for(int i = 0; i < Scoreh_List.size(); ++i) {
				sc_heart = (Score_heart) (Scoreh_List.get(i));
				sc_heart.move();
				if(sc_heart.x < -200) {
					Scoreh_List.remove(i);
				}

				if(Crash(x,y, sc_heart.x, sc_heart.y, player_img, heart_img)) {

					Scoreh_List.remove(i);	//�� ����
					game_Score += 30;		//���� ������ +30��
					System.out.println("game_score : " + game_Score);
				}

				if(cnt % 200 == 0) {
				if(game_Score < 0) {
					System.out.println("�汸�� ����");
					th.interrupt();
				}
				}
			}
			
			//��Ʈ ���� , x ��ǥ  & �ӵ� ���� �� ����
			for(int i = (int)(Math.random()*820+ 1); i < (SCREEN_HEIGHT -80); i+=800) {
				sc_heart = new Score_heart(SCREEN_WIDTH + 
						(int)(Math.random()*500 + 1), i, heart_Speed + (int)(Math.random()*7+ 3));
				Scoreh_List.add(sc_heart);
			}

		}
	}
//-----------------------------------------------------------------heart ������ ��
	
	public void Crash() {} 		//��ġ �̵���
	public boolean Crash(int x1, int y1, int x2, int y2, Image player_img, Image dispatch_img) {
		//�ش� �̹����� ����, ���̰��� ���
		boolean check = false;

		if(Math.abs((x1 + player_img.getWidth(null) / 2) - (x2 + dispatch_img.getWidth(null) / 2)) <
				(dispatch_img.getWidth(null) / 2 + player_img.getWidth(null) / 2) 
				&& Math.abs((y1 + player_img.getHeight(null) / 2)  - (y2 + dispatch_img.getHeight(null) /2)) <
				(dispatch_img.getHeight(null) / 2 + player_img.getHeight(null) /2 )) {
			//�̹��� ����, ���̰��� �ٷ� �޾� ���

			check = true;	//�� ���� true�� check�� true�� ����
		} else {
			check = false;
		}

		return check;		//check�� ���� �޼ҵ忡 ���� ��Ŵ
	}
	
	public void paint() {}
	public void paint(Graphics g) {
		buffImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
		buffg = buffImage.getGraphics();
		update(g);
	}
	
	public void update() {}
	public void update(Graphics g) {
		Draw_Background(); // ��� �̹��� �׸��� �޼ҵ� ����
		Draw_Player(); // �÷��̾ �׸��� �޼ҵ� �̸� ����

		Draw_Score();	// ���� �׸���
//		Draw_Missile();	// �̻��� �׸���
//
//		Draw_Explosion();	// ��������Ʈ�׸��� �޼ҵ� ����
		Draw_StatusText();	// ���� ǥ�� �ؽ�Ʈ�� �׸��� �޼ҵ� ����

		g.drawImage(buffImage, 0, 0, this);
	}


	public void Draw_Background() {
		//ȭ�� ����� ���
		buffg.clearRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		if(bx> - 1400) {
		buffg.drawImage(bg_img, bx, 0, this);
		bx -= 1;
		buffg.drawImage(bg_img, bx+1401, 0, this);
		} else {
			bx = 0;
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
			buffg.drawImage(dispatch_img, sc.x,	sc.y, this);
		}
		
//		//��Ʈ �׸� �׸���
//		for ( int i= 0; i < Scoreh_List.size(); ++i) {
//			sc_heart = (Score_heart) (Scoreh_List.get(i));
//			buffg.drawImage(heart_img, sc_heart.x, sc_heart.y, this);
//		}
		
		//�� �׸� �׸���
		for ( int i= 0; i < Scores_List.size(); ++i) {
			sc_star = (Score_star) (Scores_List.get(i));
			buffg.drawImage(star_img, sc_star.x, sc_star.y, this);
		}
		
	}


	public void KeyProcess() {
		if(KeyUp == true) {
			if (y > 20)
				y -= 10;					//�ɸ��Ͱ� �������� ȭ�� ���� �� �Ѿ�� �մϴ�.

			player_Status = 0;			//�̵�Ű�� �÷����� �÷��̾� ���¸� 0���� �����ϴ�.
		}

		if(KeyDown == true) {
			if (y + player_img.getHeight(null) < SCREEN_HEIGHT)
				y += 10;					//�ɸ��Ͱ� �������� ȭ�� �Ʒ��� �� �Ѿ�� �մϴ�.

			player_Status = 0;			//�̵�Ű�� �÷����� �÷��̾� ���¸� 0���� �����ϴ�.
		}

		if(KeyLeft == true) {
			if(x > 0)
				x -= 10;					//�ɸ��Ͱ� �������� ȭ�� �������� �� �Ѿ�� �մϴ�.

			player_Status = 0;			//�̵�Ű�� �÷����� �÷��̾� ���¸� 0���� �����ϴ�.
		}

		if(KeyRight == true) {
			if(x + player_img.getWidth(null) < SCREEN_WIDTH)
				x += 10;					//�ɸ��Ͱ� �������� ȭ�� ���������� �� �Ѿ�� �մϴ�.

			player_Status = 0; 			//�̵�Ű�� �÷����� �÷��̾� ���¸� 0���� �����ϴ�.
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {		//Ű�� ������ �� ����
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
	public void keyReleased(KeyEvent e) {		//Ű�� ������ �� ����

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

	public void functionList() {	// ��� �Լ� ���, [ Ctrl+�Լ� ] �� �ش� �Լ���ġ�� �̵� 
		init();	// �ʱ⼳����, �̹��� �ҷ����� 
		start();	// ������ ����
		run();
		//		MissileProcess();	// �̻��� ���� ����
		//		EnemyProcess();	// �� ���� ����
		//		ExplosionProcess();	// ���߽� �̺�Ʈ
		Crash();	// �浹 �̺�Ʈ, EnemyProcess() �� Crash()
		//		paint();
		//		update();
		//		Draw_Background();	// ��� �׸���
		//		Draw_Player();	// user ���� �̺�Ʈ
		//		Draw_Missile();	// �̻��� �׸���
		//		Draw_Enemy();	// �� �׸���
		//		Draw_Explosion();	// ��� �� �浹�� ���� �̺�Ʈ
		//		Draw_StatusText();	// ���� üũ��(����, ���� ��)
		KeyProcess();	// Ű �Է� �κ�
	}
}
