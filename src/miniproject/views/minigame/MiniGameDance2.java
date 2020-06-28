package miniproject.views.minigame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;

public class MiniGameDance2 extends JPanel  { // �̴ϰ��� ����ȭ�� (�㿬���� ���� �ι�°ȭ��) -> �ٽ� �Ҽӻ� 
   // Ű���� �Է¹��� �� �ι�°ȭ�� ����(ȭ��ǥ) �ȶ�..., ���� ����(3����(ȭ��ǥ21��)�� 2�� �̻� ����� ��ų+1, �ƴϸ� ���� �� ������.
   private ImageIcon back;
   private ImageIcon talk;
   private ImageIcon characters;
   //private ImageIcon keyspace;
   private MainFrame mf;
   private JPanel panel;
   private int x = 300;  //����(ù��°ȭ��ǥ ��ġ��)
   private int x2 = 300; //����(�ι�°ȭ��ǥ ��ġ��)
   private JLabel[] arrows; //ȭ��ǥ(����)
   private int[] arrNo; //ȭ��ǥ(����)
   private ArrayList<JLabel> inputs;
   private int cnt = 0;
   private int index = 0;
   int num = 0;
   //----�������   
   int su = 0;
   //---------   
   

   public int point = 0;
   private JTextField keyScore;
   private Player123 player;



   public MiniGameDance2(MainFrame mf,Player123 player) { //���ӵι�°ȭ��

      this.mf=mf;
      panel = this;
      this.player = player;
      
      this.setLayout(null);

      back = new ImageIcon("src/miniproject/images/SJH/minigamekey.PNG"); //���
      talk = new ImageIcon("src/miniproject/images/SJH/conv.PNG"); //��ȭâ
      characters = new ImageIcon("src/miniproject/images/SJH/Characters_5.png"); //ĳ����
      //------------����������      (������ٰ� ����.. )
      //keyspace = new ImageIcon("images/keyspace.png"); //��ĭ
      //------------------
      //ȭ��ǥ(����)
      arrows = new JLabel[7];   
      inputs = new ArrayList<JLabel>();
      arrNo = new int[7];

      //this.addMouseListener(new MyMouseAdapter());


      //mf.setFocusable(true);
      buttonInit();
      mf.requestFocus(); // -> �ι�° ȭ�鿡�� ����ȭ��ǥ ��¾ȵǼ� ��Ŀ�� �����
      mf.addKeyListener(new KeyAdapter() {      //**this�� �ϸ� ����ȵ�........z

         @Override
         public void keyPressed(KeyEvent e) { 
//0628
            if(su !=1) {
            System.out.println(e.getKeyCode()+ " ù��° Ȯ�ο� ");

            //a = answer1.getText();
            int num = 0;

            if(e.getKeyCode() == KeyEvent.VK_LEFT) {
               num = 4;
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN) {
               num = 3;
            }
            if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
               num = 2;
            }
            if(e.getKeyCode() == KeyEvent.VK_UP) {
               num = 1;
            }


            
            addButton(num);   //(�Ȼ���.........���Ȥ��ʤ�)->�ذ���.     -----> �̰� �����ΰŰ�����.......��.��.
            mf.repaint();
            cnt++;
         }
         }


      });

   }

   //ù���� ȭ��ǥ ���(����)
   public void buttonInit(){

      x = 300; //-> �����ϸ� �ι�° ���� ��¾ȵ�.. (������ ������ �����..)


      for(int i = 0; i < arrows.length; ++i) {
         int num = new Random().nextInt(4) + 1;
         arrNo[i] = num;
         ImageIcon arrow = new ImageIcon("src/miniproject/Images/SJH/"+num+"-blue.png");
         //URL url = getClass().getClassLoader().getResource(num+"-blue.png");

         arrows[i] = new JLabel(new ImageIcon(arrow.getImage().getScaledInstance(150, 150, 0)));
         arrows[i].setBounds(x, 100, 150, 150);
         x += 150;
         this.add(arrows[i]);
         System.out.println("�ι��� Ȯ�ο�");
         System.out.println("�� ��° ȭ��ǥ ��ġ : " + arrows[i].getX() + ", " + arrows[i].getY());

         //this.revalidate();

      }
      this.repaint();
      System.out.println(mf.isFocused());



   }



   public void addButtonJumsu(int su) {
      this.su = su;

   }




   // �ι�° ȭ��ǥ ���(����)
   public void addButton(int num) { 

      //this.num = num;
      //this.addButton(num);
      //this.add(panel2);

      System.out.println("����°Ȯ�ο� :" + num);
//0628//if(point <21) {
      
      if(index >= 7){
         reset();
         //index = 0;
      }else{
         System.out.println("�׹�°Ȯ�ο� : " + index);

         String color = "";

         if(arrNo[index] == num) { 
            color = "blue";
            ImageIcon arrows = new ImageIcon("src/miniproject/images/SJH/"+num+"-"+color+".png");

            //URL url = getClass().getClassLoader().getResource("pororo-"+num+".png");

            //point-----------------------------------------------------------------------
            point += 1;
            System.out.println("����Ȯ�� : " + point);

            //JLabel label = new JLabel("���ᰳ�� : ");


            if(point >=14) {
               System.out.println("14�� �̻� ȭ��ǥ�� ������ϴ�. �㽺ų +1 ¦¦!!");

               //-------------  
                  su += 1; //��ų���� 


               System.out.println("��ų���� : " + su);

               keygamewin();
               //--------------      



            }else {
               System.out.println("�ƽ��� ��ųȹ���� ���߳׿�...��.��....");
               //-------------------            
               //keygamelose();
               
               
               
               
               this.addMouseListener(new MyMouseAdapter());

               //MiniGameDance3_Lose lose = new MiniGameDance();

            }


            System.out.println("�ټ���°Ȯ�ο� : " + index);
            //this.back.getImage();      

            //---------------------------------------------------------------------------�� �ڵ� ��� �ȵ�.��������.->��
         }else {
            color = "red";

            ImageIcon arrow = new ImageIcon("src/miniproject/images/SJH/"+num+"-"+color+".png");

            System.out.println("������°Ȯ�ο� :" + index);
            //this.back.getImage();

         }

         ImageIcon arrow = new ImageIcon("src/miniproject/images/SJH/"+num+"-"+color+".png");
         //URL url = getClass().getClassLoader().getResource(num + "-" + color + ".png");

         JLabel input = new JLabel(new ImageIcon(arrow.getImage().getScaledInstance(150, 150, 0)));
         input.setBounds(x2, 350, 150, 150);
         inputs.add(input);
         x2 += 150;
         this.add(inputs.get(index));

         System.out.println("�ϰ���° Ȯ�ο�");
         this.repaint();
         //this.revalidate();
         index++;

      }


   //}
   }

   //point----------------------------------------
   /*   public void keyScore() {
      keyScore = new JTextField("���ᰳ�� : " + point);
      keyScore.setFont(new Font("Sanscerif", Font.BOLD, 20));
      keyScore.setBorder(BorderFactory.createEmptyBorder());
      this.setComponentZOrder(keyScore, 0);
      keyScore.setBounds(500, 0, 500, 500);
      panel.add(keyScore);

   }*/

   //--------------------------------------   

   public void reset(){

      System.out.println("������°Ȯ�ο�");

      //21��ȭ��ǥ(��3��)������ ����(7�� ����)�ؼ� ���� ����,  
      //���ٿ� 7��ȭ��ǥ, �� 21�� ȭ��ǥ 
      //ȭ��ǥ�� 7������ �������� ȭ��ǥ ������ �� �ٽ� ��� �� 21������..
      if(cnt <22  ) {


         for (int i = 0; i < arrows.length; i++) {
            this.remove(arrows[i]);
            System.out.println("��ȩ��°Ȯ�ο�" + "arrows : " + arrows +"i"+i  );
            this.repaint();



         }
            buttonInit();
         


         for (int j = 0; j < arrNo.length; j++) {
            this.remove(this.inputs.get(j));
            System.out.println("����°Ȯ�ο�");
            this.repaint();



         }




         inputs.clear();

         System.out.println("���ѹ�°Ȯ�ο�");
         mf.repaint();
         index = 0;
         x =300;
         x2 = 300;

      } else {
         System.out.println("end");
         


      }



   }


   /*public void keygamelose() {
      MiniGamePanel3_Lose lose = new MiniGamePanel3_Lose(mf);
      ChangePanel.changePanel(mf, panel, lose);

   }*/

   public void keygamewin() {

      MiniGameDance3_Win win = new MiniGameDance3_Win(mf,player); //���� �̱�� �̱�� ȭ������ �Ѿ.

      win.keyjumsu(su);  //���� �������(�㽺ų+1)

      ChangePanel.changePanel(mf, panel, win);



   }

   /*   public void keygamelose() {

      MiniGameDance3_Lose lose = new MiniGameDance3_Lose(mf);

      ChangePanel.changePanel(mf, panel, lose);



}
    */






   public void paintComponent(Graphics g) {

      super.paintComponent(g);
      g.drawImage(back.getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
      g.drawImage(talk.getImage(), 0, 600, 1400, 250,null); //���� ��ġ : 0,600,1400,250
      g.setFont(new Font("Neo�ձٸ�", Font.BOLD, 30));
      g.drawString("����ϸ� �뷡��ų +1 !!!", 100, 700); //�۾� ��ġ ���� �ʿ�
      g.drawString("14�� �̻� ������ Ű���带 �Է��ϼ���", 100, 750);
      g.drawImage(characters.getImage(), 10, 100, 398, 398, this); //����ũ�� : 398,398
      setOpaque(false);

      setOpaque(false);

   }

   class MyMouseAdapter extends MouseAdapter{


      @Override
      public void mouseClicked(MouseEvent e) {


         ChangePanel.changePanel(mf, panel, new MiniGameDance3_Lose(mf,player));      
      }



   }
}


