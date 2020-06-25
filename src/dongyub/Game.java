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

	int x = 100 ;		// player의 초기 위치
	int y = 100 ; 

	int[] cx = { 0, 0, 0 }; 	//배경 스크롤 속도 제어용 변수
	int bx = 0; 				//전체 배경 스크롤 용 변수

	boolean KeyUp = false;
	boolean KeyDown = false;
	boolean KeyLeft = false;
	boolean KeyRight = false;
	boolean KeySpace = false;

	int cnt;

	int player_Speed;			// 유저의 케릭터가 움직이는 속도를 조절할 변수
	int score_Speed;			// 점수가 날라가는 속도 조절할 변수
		int dispatch_Speed;		// 디스패치가 날라오는 속도 조절할 변수	
		int star_Speed;			// 별이 날라오는 속도 조절할 변수
		int heart_Speed;		// 하트가 날라오는 속도 조절할 변수
	int player_Status = 0;		// 유저 캐릭터 상태 체크 변수 0: 평상시, 1: 충돌
	int game_Score; 			// 게임 점수 계산

	Thread th;
	
	Image[] Score_img;		//디스패치, 하트, 별 넣을 이미지 ( 아직안씀 )

	Image bg_img;				// 배경화면 이미지
	Image player_img;			// 플레이어 이미지

	Image dispatch_img;			// 피해야 할 디스패치 이미지
	Image heart_img;			// 먹어야 할 선물하트 이미지
	Image star_img;				// 먹어야 할 선물스타 이미지

	ArrayList Score_List = new ArrayList();

	Image buffImage;		//이중 버퍼 생성
	Graphics buffg;			//이중 버퍼 이미지를 그리기 위한 그래픽 객체 생성

	Score sc;

public	Game() {
		init();
		start();

		setTitle("디스 패치를 피해라!!");
		setSize(Run.SCREEN_WIDTH, Run.SCREEN_HEIGHT);

		//화면 크기 삽입하여 setLocation 지정 해주려고 씀 ( 필요시 사용 )
		//		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();		//화면 크기 삽입
		//		
		//		int f_xpos = (int) (screen.getWidth() / 2 - Run.SCREEN_WIDTH / 2);
		//		int f_ypos = (int) (screen.getHeight() / 2 - Run.SCREEN_HEIGHT / 2);
		//		System.out.println("x: " + f_xpos + ", y : " + f_ypos);
		//		setLocation(f_xpos, f_ypos);

		setResizable(false); 		//화면 사이즈 고정
		setVisible(true);

	}

	public void init() {
		//이미지 넣어주고 게임 스코어 초기화 , 속도 설정

		//플레이어 이미지
		player_img = new ImageIcon("dispatch_images/miniGame/character.png"
				+ "").getImage().getScaledInstance(80, 80, 0);
		//점수 이미지, getScaledInstance 의 마지막 인자로 java.awt.Image.SCALE_SMOOTH 를 써보자( 선택 )
		dispatch_img = new ImageIcon("dispatch_images/miniGame/score_avoid.png").getImage().getScaledInstance(80, 80, 0);
		heart_img = new ImageIcon("dispatch_images/miniGame/score_heart.png").getImage().getScaledInstance(80, 80, 0);
		star_img = new ImageIcon("dispatch_images/miniGame/score_star.png").getImage().getScaledInstance(80, 80, 0);
		//전체 배경화면 이미지
		bg_img = new ImageIcon("dispatch_images/miniGame/background.png").getImage().getScaledInstance(Run.SCREEN_WIDTH, Run.SCREEN_HEIGHT, 0);

		game_Score = 0;	 		//게임 스코어 초기화

		player_Speed = 10; 	//유저 케릭터 움직이는 속도 설정
		score_Speed = 5; 	//점수가 날라오는 속도 설정, 높을 수록 빨라짐

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
				KeyProcess();		//키 동작
				//				EnemyProcess();		//적 동작과정
				//				MissileProcess();	//미사일 동작과정
				ScoreProcess();		//점수 동작과정
				
				repaint();

				Thread.sleep(10);
				cnt++;
			}

		} catch(Exception e) {
			System.out.println("run() 오류");
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
				//플레이어와 적의 충돌을 판정하여 check값을 리턴 받아 true면 아래를 실행
					
				Score_List.remove(i);	//적을 제거
				game_Score -= 20;		//디스 패치를 먹으면 -20점
				System.out.println("game_score : " + game_Score);
				
			} 
			
			else if(Crash(x,y, sc.x, sc.y, player_img, star_img)) {
				
				Score_List.remove(i);	//별 제거
				game_Score += 30;		//별을 먹으면 +30점
				System.out.println("game_score : " + game_Score);
			}
			
			else if(Crash(x,y, sc.x, sc.y, player_img, heart_img)) {
				
				Score_List.remove(i);	//하트 제거
				game_Score += 30;
				System.out.println("game_score : " + game_Score);
			}
			
			if(game_Score == 0) {
				System.out.println("방구석 엔딩");
				th.interrupt();
			}
		}
			//점수 생성
			if(cnt % 200 == 0) {
				//i 는 위치값, 증감값에 따라 배치 조절 가능
				for(int i = 50; i < (Run.SCREEN_HEIGHT -50); i+=60) {
					sc = new Score(Run.SCREEN_WIDTH + 100, i, score_Speed);
					Score_List.add(sc);
				
			}
		}
	}

	public void Crash() {} 		//위치 이동용
	public boolean Crash(int x1, int y1, int x2, int y2, Image player_img, Image dispatch_img) {
		//해당 이미지의 넓이, 높이값을 계산
		boolean check = false;

		if(Math.abs((x1 + player_img.getWidth(null) / 2) - (x2 + dispatch_img.getWidth(null) / 2)) <
				(dispatch_img.getWidth(null) / 2 + player_img.getWidth(null) / 2) 
				&& Math.abs((y1 + player_img.getHeight(null) / 2)  - (y2 + dispatch_img.getHeight(null) /2)) <
				(dispatch_img.getHeight(null) / 2 + player_img.getHeight(null) /2 )) {
			//이미지 넓이, 높이값을 바로 받아 계산

			check = true;	//위 값이 true면 check에 true를 전달
		} else {
			check = false;
		}

		return check;		//check의 값을 메소드에 리턴 시킴
	}
	
	public void paint() {}
	public void paint(Graphics g) {
		buffImage = createImage(Run.SCREEN_WIDTH, Run.SCREEN_HEIGHT);
		buffg = buffImage.getGraphics();
		update(g);
	}
	
	public void update() {}
	public void update(Graphics g) {
//		Draw_Background(); // 배경 이미지 그리기 메소드 실행
//		Draw_Player(); // 플레이어를 그리는 메소드 이름 변경

		Draw_Score();	// 적기 그리기
//		Draw_Missile();	// 미사일 그리기
//
//		Draw_Explosion();	// 폭발이펙트그리기 메소드 실행
		Draw_StatusText();	// 상태 표시 텍스트를 그리는 메소드 실행

		g.drawImage(buffImage, 0, 0, this);
	}


	private void Draw_StatusText() {
		//샅애 체크용 텍스트를 그립니다.
		buffg.setFont(new Font("serif", Font.BOLD, 20));
		//폰트 설정 : 돋움, 굵게, 사이즈 20
		
		buffg.drawString("Score : "  + game_Score, 1000, 70);
		//좌표 x : 1000, y : 70 에 스코어를 표시
		
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
				y -= 5;					//케릭터가 보여지는 화면 위로 못 넘어가게 합니다.

			player_Status = 0;			//이동키가 늘려지면 플레이어 상태를 0으로 돌립니다.
		}

		if(KeyDown == true) {
			if (y + player_img.getHeight(null) < Run.SCREEN_HEIGHT)
				y += 5;					//케릭터가 보여지는 화면 아래로 못 넘어가게 합니다.

			player_Status = 0;			//이동키가 늘려지면 플레이어 상태를 0으로 돌립니다.
		}

		if(KeyLeft == true) {
			if(x > 0)
				x -= 5;					//케릭터가 보여지는 화면 왼쪽으로 못 넘어가게 합니다.

			player_Status = 0;			//이동키가 늘려지면 플레이어 상태를 0으로 돌립니다.
		}

		if(KeyRight == true) {
			if(x + player_img.getWidth(null) < Run.SCREEN_WIDTH)
				x += 5;					//케릭터가 보여지는 화면 오른쪽으로 못 넘어가게 합니다.

			player_Status = 0; 			//이동키가 늘려지면 플레이어 상태를 0으로 돌립니다.
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {		//키를 눌렀을 때 동작
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
	public void keyReleased(KeyEvent e) {		//키를 떼었을 때 동작

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

	public void functionList() {	// 사용 함수 목록, [ Ctrl+함수 ] → 해당 함수위치로 이동 
		init();	// 초기설정값, 이미지 불러오기 
		start();	// 프레임 시작
		run();
		//		MissileProcess();	// 미사일 진행 과정
		//		EnemyProcess();	// 적 진행 과정
		//		ExplosionProcess();	// 폭발시 이벤트
		Crash();	// 충돌 이벤트, EnemyProcess() → Crash()
		//		paint();
		//		update();
		//		Draw_Background();	// 배경 그리기
		//		Draw_Player();	// user 상태 이벤트
		//		Draw_Missile();	// 미사일 그리기
		//		Draw_Enemy();	// 적 그리기
		//		Draw_Explosion();	// 요격 및 충돌시 폭발 이벤트
		//		Draw_StatusText();	// 상태 체크용(점수, 생명 등)
		KeyProcess();	// 키 입력 부분
	}
}
