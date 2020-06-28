package miniproject.views.minipublic;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.mainMap.MainMapJunguk;

public class Sosok_01 extends JPanel { //�Ҽӻ� ùȭ��

   private MainFrame mf;
   private JPanel panel;

   private ImageIcon back; //���
   private ImageIcon talk; //��ȭ����
   private ImageIcon characters =new ImageIcon("src/miniproject/images/SJH/Characters_5.png");
   private ImageIcon sajang = new ImageIcon("src/miniproject/images/sosok/sajang.PNG");

   private ImageIcon doorMain;
   private JLabel door;//��
   private Player123 player;
   
   
   public Sosok_01(MainFrame mf, Player123 player) {

      this.mf=mf;
      panel = this;
      this.player  = player;
      this.setLayout(null);
      

      back = new ImageIcon("src/miniproject/images/SJH/minibackgroundfinish.PNG"); //���-�Ҽӻ�
      talk = new ImageIcon("src/miniproject/images/SJH/conv.PNG"); //��ȭâ
      Image cimage = characters.getImage().getScaledInstance(100, 100, 0);
      Image simage  = sajang.getImage().getScaledInstance(100, 100, 0);
      ImageIcon cIcon = new ImageIcon(cimage);
      ImageIcon sIcon = new ImageIcon(simage);
      

      doorMain = new ImageIcon("src/miniproject/images/SJH/outdoor.png");
      //�� 
      door = new JLabel(doorMain);
      door.setLayout(null);
      door.setBounds(0, 400, 40, 250);
      door.setOpaque(false);
      this.add(door);

      door.addMouseListener(new MouseAdapter() {

         @Override
         public void mouseClicked(MouseEvent e) {
            ChangePanel.changePanel(mf, panel, new MainMapJunguk(mf,player));

         }
      });
      
      
      this.addMouseListener(new clickButton() );
      
      
   }

   public void paintComponent(Graphics g) {

      super.paintComponent(g);

      g.drawImage(back.getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
      g.drawImage(talk.getImage(), 0, 600, 1400, 250,null); //���� ��ġ : 0,600,1400,250
      g.drawImage(sajang.getImage(), 300, 300, 250, 250, this);
      g.drawImage(characters.getImage(), 10, 300, 250, 250, this);
      g.setFont(new Font("Neo�ձٸ�", Font.BOLD, 30));
      g.drawString("[�Ҽӻ��...]", 100, 730);
   
   }


   class clickButton extends MouseAdapter{  
      @Override
      public void mouseClicked(MouseEvent e) {
         ChangePanel.changePanel(mf, panel, new Sosok_02(mf,player));
         mf.revalidate();
      }


   }
}