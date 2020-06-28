package miniproject.views.minipublic;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.minipublic.Sosok_02.clickButton;
import miniproject.views.somang.MiniGameSsing;

public class Sosok_03_second extends JPanel { //��������� �̼ǹ޴� ���(ĳ���Ͱ� �ٰ�����

   private MainFrame mf;
   private JPanel panel;

   private ImageIcon back; //���
   private ImageIcon talk; //��ȭ����
   private ImageIcon characters =new ImageIcon("src/miniproject/images/SJH/Characters_6.png");
   private ImageIcon sajang = new ImageIcon("src/miniproject/images/sosok/sajang.PNG");

   private Image doorR; //�Ҽӻ� ��(�̴ϰ��� ��)
   private Image doorL; //�Ҽӻ� ��(�̴ϰ��� �뷡)
   
   private Player123 player;

   public Sosok_03_second(MainFrame mf, Player123 player) {

      this.mf=mf;
      panel = this;
      this.player = player;
      
      this.setLayout(null);

      back = new ImageIcon("src/miniproject/images/SJH/minibackgroundfinish.PNG"); //���-�Ҽӻ�
      talk = new ImageIcon("src/miniproject/images/SJH/conv.PNG"); //��ȭâ
      
      Image cimage = characters.getImage().getScaledInstance(100, 100, 0);
      Image simage  = sajang.getImage().getScaledInstance(100, 100, 0);
      ImageIcon cIcon = new ImageIcon(cimage);
      ImageIcon sIcon = new ImageIcon(simage);
      
      this.addMouseListener(new clickButton() );
      
   }

   public void paintComponent(Graphics g) {

      super.paintComponent(g);

      g.drawImage(back.getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
      g.drawImage(talk.getImage(), 0, 600, 1400, 250,null); //���� ��ġ : 0,600,1400,250
      g.drawImage(sajang.getImage(), 300, 300, 250, 250, this);
      g.drawImage(characters.getImage(), 10, 300, 250, 250, this);
      g.setFont(new Font("Neo�ձٸ�", Font.BOLD, 30));
      g.drawString("����� : �Ǹ��ϱ�, Ʈ�Խ�Ÿ�� �������� �뷡�� �� �ɷ�ġ�� 1�� �� �÷����ðԳ�", 100, 700);
      g.drawString("�뷡�������� ���ʹ��̰�, �㿬������ �����ʹ��̴� ������� �ɷ�ġ�� �÷�����", 120, 750);
   
   }
   

   class clickButton extends MouseAdapter{  
      @Override
      public void mouseClicked(MouseEvent e) {
         ChangePanel.changePanel(mf, panel, new Sosok_singbutton(mf,player));
         mf.revalidate();
      }


   }
}
	