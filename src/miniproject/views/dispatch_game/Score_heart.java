package miniproject.views.dispatch_game;

public class Score_heart {
   int x;      // ��Ʈ �Ծ���ϴ� ��ֹ��� x ��ǥ
   int y;      // ��Ʈ �Ծ���ϴ� ��ֹ��� y ��ǥ
   int speed;   // ��Ʈ �Ծ���ϴ� ��ֹ��� �ӵ�
   
   int score;   // ����
   int total; // ����
   
   public Score_heart(int x, int y, int speed) {
      this.x = x;
      this.y = y;
      this.speed = speed;
   }
   
   public void move() {
      x -= speed ;      // �̻��� �ӵ� ��ŭ �̵�
   }
}