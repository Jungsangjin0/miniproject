package miniproject.views.nickname;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.*;


public class MainFrame extends JFrame {
	String nickname = "";


	public MainFrame() {
		Scanner sc = new Scanner(System.in);
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) { 
				ImageIcon bground = new ImageIcon("nickNameSelect/nickname_background.jpeg");

				g.drawImage(bground.getImage(), 0, 0, 1400, 900, null);
				//			Point p = scrollPane.getViewport().getViewPosition();
				//g.drawImage(bground.getImage(), p.x, p.y, null);
				setOpaque(false); //그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
			
			
			
			
		};






		ImageIcon inputw = new ImageIcon("nickNameSelect/input.png");
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
		get_nickname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					nickname = get_nickname.getText();
					System.out.println(nickname);
					get_nickname.setText("");
					
//					if(nickname.equals())
				}
			}
		}
				);

		ImageIcon nickn = new ImageIcon("nickNameSelect/nickname.png");
		JLabel nn = new JLabel() {
			public void paintComponent (Graphics g) {
				g.drawImage(nickn.getImage(), 0, 0, 350, 100, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		nn.setLayout(null);
		nn.setBounds(550,250,400,100);

		//	System.out.println(neo.getFontName()); //글꼴 확인용

		Image select_btn = 	new ImageIcon("nickNameSelect/select.png").getImage();

		JButton btn = new JButton(new ImageIcon(select_btn));

		btn.setBounds(550,650,300,50);
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);

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




