package miniproject.views.dispatch_game;

public class Score {

	int x;		// ����ġ ���ϴ� ��ֹ��� x ��ǥ
	int y;		// ����ġ ���ϴ� ��ֹ��� y ��ǥ
	int speed;	// ����ġ ���ϴ� ��ֹ��� �ӵ�
	
	int score;	// ����
	int total; // ����
	
	public Score(int x, int y, int speed) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.score = score;
	}
	
	public void move() {
		x -= speed ;		// �̻��� �ӵ� ��ŭ �̵�
	}
}
