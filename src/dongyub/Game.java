package dongyub;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;

import run.Run;

public class Game extends JFrame implements KeyListener, Runnable{

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
	
	Image[] Score_img;		//����ġ, ��Ʈ, �� ���� �̹��� ( �����Ⱦ� )

	Image bg_img;				// ���ȭ�� �̹���
	Image player_img;			// �÷��̾� �̹���

	Image dispatch_img;			// ���ؾ� �� ����ġ �̹���
	Image heart_img;			// �Ծ�� �� ������Ʈ �̹���
	Image star_img;				// �Ծ�� �� ������Ÿ �̹���

	ArrayList Score_List = new ArrayList();

	Image buffImage;		//���� ���� ����
	Graphics buffg;			//���� ���� �̹����� �׸��� ���� �׷��� ��ü ����

	Score sc;

public	Game() {
		init();
		start();

		setTitle("�� ��ġ�� ���ض�!!");
		setSize(Run.SCREEN_WIDTH, Run.SCREEN_HEIGHT);

		//ȭ�� ũ�� �����Ͽ� setLocation ���� ���ַ��� �� ( �ʿ�� ��� )
		//		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();		//ȭ�� ũ�� ����
		//		
		//		int f_xpos = (int) (screen.getWidth() / 2 - Run.SCREEN_WIDTH / 2);
		//		int f_ypos = (int) (screen.getHeight() / 2 - Run.SCREEN_HEIGHT / 2);
		//		System.out.println("x: " + f_xpos + ", y : " + f_ypos);
		//		setLocation(f_xpos, f_ypos);

		setResizable(false); 		//ȭ�� ������ ����
		setVisible(true);

	}

	public void init() {
		//�̹��� �־��ְ� ���� ���ھ� �ʱ�ȭ , �ӵ� ����

		//�÷��̾� �̹���
		player_img = new ImageIcon("dispatch_images/miniGame/character.png"
				+ "").getImage().getScaledInstance(80, 80, 0);
		//���� �̹���, getScaledInstance �� ������ ���ڷ� java.awt.Image.SCALE_SMOOTH �� �Ẹ��( ���� )
		dispatch_img = new ImageIcon("dispatch_images/miniGame/score_avoid.png").getImage().getScaledInstance(80, 80, 0);
		heart_img = new ImageIcon("dispatch_images/miniGame/score_heart.png").getImage().getScaledInstance(80, 80, 0);
		star_img = new ImageIcon("dispatch_images/miniGame/score_star.png").getImage().getScaledInstance(80, 80, 0);
		//��ü ���ȭ�� �̹���
		bg_img = new ImageIcon("dispatch_images/miniGame/background.png").getImage().getScaledInstance(Run.SCREEN_WIDTH, Run.SCREEN_HEIGHT, 0);

		game_Score = 0;	 		//���� ���ھ� �ʱ�ȭ

		player_Speed = 10; 	//���� �ɸ��� �����̴� �ӵ� ����
		score_Speed = 5; 	//������ ������� �ӵ� ����, ���� ���� ������

	}


	public void start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(this);

		th = new Thread(this);
		th.start();

	}

	@Override
	public void run() {
		try{
			while(true) {
				KeyProcess();		//Ű ����
				//				EnemyProcess();		//�� ���۰���
				//				MissileProcess();	//�̻��� ���۰���
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

			if (Crash(x, y, sc.x, sc.y, player_img, dispatch_img)) {
				//�÷��̾�� ���� �浹�� �����Ͽ� check���� ���� �޾� true�� �Ʒ��� ����
					
				Score_List.remove(i);	//���� ����
				game_Score -= 20;		//�� ��ġ�� ������ -20��
				System.out.println("game_score : " + game_Score);
				
			} 
			
			else if(Crash(x,y, sc.x, sc.y, player_img, star_img)) {
				
				Score_List.remove(i);	//�� ����
				game_Score += 30;		//���� ������ +30��
				System.out.println("game_score : " + game_Score);
			}
			
			else if(Crash(x,y, sc.x, sc.y, player_img, heart_img)) {
				
				Score_List.remove(i);	//��Ʈ ����
				game_Score += 30;
				System.out.println("game_score : " + game_Score);
			}
			
			if(game_Score == 0) {
				System.out.println("�汸�� ����");
				th.interrupt();
			}
		}
			//���� ����
			if(cnt % 200 == 0) {
				//i �� ��ġ��, �������� ���� ��ġ ���� ����
				for(int i = 50; i < (Run.SCREEN_HEIGHT -50); i+=60) {
					sc = new Score(Run.SCREEN_WIDTH + 100, i, score_Speed);
					Score_List.add(sc);
				
			}
		}
	}

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
		buffImage = createImage(Run.SCREEN_WIDTH, Run.SCREEN_HEIGHT);
		buffg = buffImage.getGraphics();
		update(g);
	}
	
	public void update() {}
	public void update(Graphics g) {
//		Draw_Background(); // ��� �̹��� �׸��� �޼ҵ� ����
//		Draw_Player(); // �÷��̾ �׸��� �޼ҵ� �̸� ����

		Draw_Score();	// ���� �׸���
//		Draw_Missile();	// �̻��� �׸���
//
//		Draw_Explosion();	// ��������Ʈ�׸��� �޼ҵ� ����
		Draw_StatusText();	// ���� ǥ�� �ؽ�Ʈ�� �׸��� �޼ҵ� ����

		g.drawImage(buffImage, 0, 0, this);
	}


	private void Draw_StatusText() {
		//���� üũ�� �ؽ�Ʈ�� �׸��ϴ�.
		buffg.setFont(new Font("serif", Font.BOLD, 20));
		//��Ʈ ���� : ����, ����, ������ 20
		
		buffg.drawString("Score : "  + game_Score, 1000, 70);
		//��ǥ x : 1000, y : 70 �� ���ھ ǥ��
		
	}	

	private void Draw_Score() {
		for (int i = 0; i < Score_List.size(); ++i) {
			sc = (Score) (Score_List.get(i));
			buffg.drawImage(dispatch_img, sc.x,	sc.y, this);
		}
		
	}


	private void KeyProcess() {
		if(KeyUp == true) {
			if (y > 20)
				y -= 5;					//�ɸ��Ͱ� �������� ȭ�� ���� �� �Ѿ�� �մϴ�.

			player_Status = 0;			//�̵�Ű�� �÷����� �÷��̾� ���¸� 0���� �����ϴ�.
		}

		if(KeyDown == true) {
			if (y + player_img.getHeight(null) < Run.SCREEN_HEIGHT)
				y += 5;					//�ɸ��Ͱ� �������� ȭ�� �Ʒ��� �� �Ѿ�� �մϴ�.

			player_Status = 0;			//�̵�Ű�� �÷����� �÷��̾� ���¸� 0���� �����ϴ�.
		}

		if(KeyLeft == true) {
			if(x > 0)
				x -= 5;					//�ɸ��Ͱ� �������� ȭ�� �������� �� �Ѿ�� �մϴ�.

			player_Status = 0;			//�̵�Ű�� �÷����� �÷��̾� ���¸� 0���� �����ϴ�.
		}

		if(KeyRight == true) {
			if(x + player_img.getWidth(null) < Run.SCREEN_WIDTH)
				x += 5;					//�ɸ��Ͱ� �������� ȭ�� ���������� �� �Ѿ�� �մϴ�.

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
			KeyUp = true;
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
			KeyUp = false;
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
