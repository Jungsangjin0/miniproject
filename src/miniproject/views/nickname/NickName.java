package miniproject.views.nickname;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.selectC.SelectC;


public class NickName extends JPanel {
   public static String nickname;
   Graphics g;
   Set nicks = new LinkedHashSet(); 
   MainFrame mf;
   NickName nick = this;
   // ���ȭ�� �����κ�
   public void paintComponent(Graphics g) { 
	   ImageIcon bground = new ImageIcon("src/miniproject/images/nickNameSelect/nickname_background.jpeg");
	   
	   g.drawImage(bground.getImage(), 0, 0, 1400, 900, null);
	   //         Point p = scrollPane.getViewport().getViewPosition();
	   //g.drawImage(bground.getImage(), p.x, p.y, null);
	   setOpaque(false); //�׸��� ǥ���ϰ� ����,�����ϰ� ����
	   super.paintComponent(g);
   };
   public NickName(MainFrame mf) {
      
	   Scanner sc = new Scanner(System.in);

      //�ؽ�Ʈ �Է��ϴ� ��-------------------------------
      JTextField get_nickname = new JTextField() {
         public void paintComponent (Graphics g) {
        	 ImageIcon inputw = new ImageIcon("src/miniproject/images/nickNameSelect/malpung.png");
            g.drawImage(inputw.getImage(), 0, 0, 450, 120, null);
            setOpaque(false);
          super.paintComponent(g);
         }
      };
      

      Font neo = new Font("Neo�ձٸ�",Font.BOLD,30);
      get_nickname.setLayout(null);
      get_nickname.setBorder(null);
      get_nickname.setHorizontalAlignment(JTextField.CENTER);
      get_nickname.setFont(neo);   
      get_nickname.setBounds(540,350,480,120);
      get_nickname.setOpaque(false);
      this.add(get_nickname);
//      get_nickname.addKeyListener(new KeyAdapter() {
//         @Override
//         public void keyPressed(KeyEvent e) {
//            if(e.getKeyCode() == KeyEvent.VK_ENTER){
//               nickname = get_nickname.getText();
//               System.out.println(nickname);
//               JLabel lb = new JLabel() {
//               public void paintComponents(Graphics g) {
//                  g.drawString(nickname, 500, 150);
//                  
//                  setOpaque(false);
//                  super.paintComponents(g);
//               }
//               };
//               background.add(lb);
////               if(nickname.equals())
//            }
//         }
//      }
//            );
      //�г��� ���� �κ�-----------
      JLabel nn = new JLabel() {
    	  ImageIcon nickn = new ImageIcon("src/miniproject/images/nickNameSelect/nickname.png");
         public void paintComponent (Graphics g) {
            g.drawImage(nickn.getImage(), 0, 0, 300, 100, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      nn.setLayout(null);
      nn.setBounds(190,350,400,100);
      this.add(nn);

      //�г��� ������ �� ����ϴ� �κ�~~~
      

      nickname = get_nickname.getText(); 
      JTextField setBtnText = new JTextField();
//      setBtnText.setBorder(null);
      setBtnText.setBounds(450, 100, 700, 100);
      setBtnText.setEditable(false);
      this.add(setBtnText);
      Font neo2 = new Font("Neo�ձٸ�",Font.BOLD, 25);
      setBtnText.setForeground(Color.WHITE);
      setBtnText.setFont(neo2);
//      setBtnText.setHorizontalAlignment(JTextField.CENTER);
      setBtnText.setBorder(null);
      setBtnText.setOpaque(false);
      

      Image select_btn =    new ImageIcon("src/miniproject/images/nickNameSelect/select.png").getImage();

      JButton btn = new JButton(new ImageIcon(select_btn));

      btn.setBounds(550,650,300,50);
      btn.setBorderPainted(false);
      btn.setContentAreaFilled(false);
      btn.setFocusPainted(false);
      this.add(btn);
      btn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            nickname = get_nickname.getText();
            
            if (nickname.equals("")) {
            	 setBtnText.setText("�г����� 1���� �̻�, 5���� ���Ϸ� �Է����ּ���");
            }else {
            setBtnText.setText("����� �г����� "+ nickname + " �Դϴ�. ȯ���մϴ�.");
            setBtnText.removeAll();
            setBtnText.setFocusable(true);
            ChangePanel.changePanel(mf,nick,new SelectC(mf));
            }
            
         }
      });

      
      

   }





   
}
