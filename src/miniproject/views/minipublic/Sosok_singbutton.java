package miniproject.views.minipublic;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.mainMap.MainMapJunguk;
import miniproject.views.somang.MiniGameSsing;

public class Sosok_singbutton extends JPanel{
   

      private MainFrame mf;
      private Sosok_singbutton panel = this;
      private JLabel door;
      
      private ImageIcon back;
      private ImageIcon talk;
      private ImageIcon charac01 =new ImageIcon("src/miniproject/images/SJH/Characters_5.png");
      private ImageIcon sajang = new ImageIcon("src/miniproject/images/sosok/sajang.PNG");
      private ImageIcon sDoorL; //�뷡
      private ImageIcon doorMain;
      
      private Player123 player;
      
      public Sosok_singbutton(MainFrame mf, Player123 player) {
         this.mf = mf;
         this.player = player;
         this.setLayout(null);
         
         back = new ImageIcon("src/miniproject/images/sosok/sosok.png");
         talk = new ImageIcon("src/miniproject/images/sosok/talkframe.png");
         Image cimage = charac01.getImage().getScaledInstance(250, 250, 0);
         Image simage  = sajang.getImage().getScaledInstance(250, 250, 0);
         sDoorL = new ImageIcon("src/miniproject/images/sosok/Door.png");
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
         //ĳ���͵�
         JLabel cLabel = new JLabel(cIcon);
         JLabel sLabel = new JLabel(sIcon);
         cLabel.setBounds(30, 250, 398, 398);

         JButton sajangButton = new JButton();
         sajangButton.add(sLabel);
         sajangButton.setBorderPainted(false);
         sajangButton.setContentAreaFilled(false);
         
         sajangButton.setBounds(300, 300, 250, 250);
         panel.add(cLabel);
         panel.add(sajangButton);
         
         //��
         JLabel labelL = new JLabel(sDoorL);
         JButton doorL = new JButton();
         doorL.setBounds(149,134,171,280);
         doorL.setBorderPainted(false);
         doorL.add(labelL);
         doorL.setBorderPainted(false);
         doorL.setContentAreaFilled(false);
         doorL.setFocusPainted(false);
         panel.add(doorL);
         
         
         
         
         //�뷡
         doorL.addMouseListener(new clickButtonL());
         
      }
      
      public void paintComponent(Graphics g) {
         g.drawImage(back.getImage(), 0, 0, null);
         g.drawImage(talk.getImage(), 5, 600, 1390, 250, null);
         g.setFont(new Font("Neo�ձٸ�", Font.BOLD, 30));
         g.drawString("�뷡�����Ƿ� ����",100,730);
         
         setOpaque(false);
         super.paintComponent(g);
      }
      
      //�뷡
      class clickButtonL extends MouseAdapter {
         @Override
         public void mouseClicked(MouseEvent e) {
            ChangePanel.changePanel(mf, panel, new MiniGameSsing(mf,player)); //��ư������ �뷡 �������� �Ѿ.
            mf.revalidate();
         }
      }
      
   }