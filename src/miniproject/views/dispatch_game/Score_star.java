package miniproject.views.dispatch_game;

public class Score_star {
   int x;      // �� �Ծ���ϴ� ��ֹ��� x ��ǥ
   int y;      // �� �Ծ���ϴ� ��ֹ��� y ��ǥ
   int speed;   // �� �Ծ���ϴ� ��ֹ��� �ӵ�
   
   int score;   // ����
   int total; // ����
   
   public Score_star(int x, int y, int speed) {
      this.x = x;
      this.y = y;
      this.speed = speed;
   }
   
   public void move() {
      x -= speed ;      // �̻��� �ӵ� ��ŭ �̵�
   }
}