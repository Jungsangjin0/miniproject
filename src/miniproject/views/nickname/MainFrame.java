package miniproject.views.nickname;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.*;


public class MainFrame extends JFrame {
	String nickname = "";
	Graphics g;

	public MainFrame() {
		Scanner sc = new Scanner(System.in);
		
		// 배경화면 설정부분
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) { 
				ImageIcon bground = new ImageIcon("src/miniproject/images/nickNameSelect/nickname_background.jpeg");

				g.drawImage(bground.getImage(), 0, 0, 1400, 900, null);
				//			Point p = scrollPane.getViewport().getViewPosition();
				//g.drawImage(bground.getImage(), p.x, p.y, null);
				setOpaque(false); //그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
			
			
			
			
		};

		//텍스트 입력하는 곳-------------------------------
		ImageIcon inputw = new ImageIcon("src/miniproject/images/nickNameSelect/input.png");
		JTextField get_nickname = new JTextField() {
			public void paintComponent (Graphics g) {
				g.drawImage(inputw.getImage(), 0, 0, 600, 150, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};


		Font neo = new Font("Neo둥근모",Font.BOLD,30);
		get_nickname.setLayout(null);
		get_nickname.setHorizontalAlignment(JTextField.CENTER);
		get_nickname.setFont(neo);	
		get_nickname.setBounds(400,400,600,150);
//		get_nickname.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if(e.getKeyCode() == KeyEvent.VK_ENTER){
//					nickname = get_nickname.getText();
//					System.out.println(nickname);
//					JLabel lb = new JLabel() {
//					public void paintComponents(Graphics g) {
//						g.drawString(nickname, 500, 150);
//						
//						setOpaque(false);
//						super.paintComponents(g);
//					}
//					};
//					background.add(lb);
////					if(nickname.equals())
//				}
//			}
//		}
//				);
		//닉네임 설정 부분-----------
		ImageIcon nickn = new ImageIcon("src/miniproject/images/nickNameSelect/nickname.png");
		JLabel nn = new JLabel() {
			public void paintComponent (Graphics g) {
				g.drawImage(nickn.getImage(), 0, 0, 350, 100, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		nn.setLayout(null);
		nn.setBounds(150,250,400,100);

		//닉네임 설정한 거 출력하는 부분~~~
		

		nickname = get_nickname.getText(); 
		JTextField setBtnText = new JTextField();
		setBtnText.setBorder(null);
		setBtnText.setBounds(550, 250, 600, 100);
		setBtnText.setEditable(false);
		
		Font neo2 = new Font("Neo둥근모",Font.BOLD,19);
		setBtnText.setFont(neo2);
		setBtnText.setHorizontalAlignment(JTextField.CENTER);
		
	
		

		Image select_btn = 	new ImageIcon("src/miniproject/images/nickNameSelect/select.png").getImage();

		JButton btn = new JButton(new ImageIcon(select_btn));

		btn.setBounds(550,650,300,50);
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nickname = get_nickname.getText();
				setBtnText.setText("당신의 닉네임은 '"+ nickname + "' 입니다. 환영합니다.");
				setBtnText.removeAll();
				setBtnText.setFocusable(true);
				
				
			}
		});
		btn.setFocusPainted(false);

		
		background.add(setBtnText);
		background.add(nn);
		background.add(get_nickname);
		background.add(btn);
		background.setLayout(null);
		setContentPane(background);

	}





	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1400, 900);
		frame.setVisible(true);
	}
}




