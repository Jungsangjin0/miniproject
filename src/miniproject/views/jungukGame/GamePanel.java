package miniproject.views.jungukGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.Timer;
import miniproject.views.mainMap.MainMap4;

public class GamePanel extends JPanel{
	private MainFrame mf;
	private GamePanel panel;
	private ImageIcon icon = new ImageIcon("src/miniproject/images/junguk/Junguk_2.png");
	private Image bicon = new ImageIcon("src/miniproject/images/junguk/button.png").getImage().getScaledInstance(200, 60, 0);
	private String[] answer = new String[5];
	private int gamescore = 0;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(icon.getImage(), 0, 0, 1400, 900, null);
		JTextField sText = new JTextField();
		sText.setBounds(50,500,180,40);
		setOpaque(false);
	}

	String one = "";
	String two = "";
	String three = "";
	String four = "";
	String five = "";
	private JTextField input;
	private JTextField input2;
	private JTextField input3;
	private JTextField input4;
	private JTextField input5;
	private JTextField scoreLabel;
	private JTextField timeLabel;
	private JTextField printLabel;
	private int point = 0;


	public GamePanel(MainFrame mf) {
		this.mf = mf;
		panel = this;
		this.setLayout(null);

		JLabel label = new JLabel();
		label.setBounds(0, 0, 1400, 900);

		JButton submit = new JButton(new ImageIcon(bicon));
		submit.setLayout(null);
		submit.setBounds(275, 700, 200, 40);
		this.add(submit);
		submit.setBorderPainted(false);
		submit.setContentAreaFilled(false);
		submit.setFocusPainted(false);




		input = new JTextField();
		input.setLayout(null);
		input.setBounds(70,580,200,40);

		input2 = new JTextField();
		input2.setLayout(null);
		input2.setBounds(70,640,200,40);

		input3 = new JTextField();
		input3.setLayout(null);
		input3.setBounds(70,700,200,40);

		input4 = new JTextField();
		input4.setLayout(null);
		input4.setBounds(280,580,200,40);

		input5 = new JTextField();
		input5.setLayout(null);
		input5.setBounds(280,640,200,40);




		this.add(input);
		this.add(input2);
		this.add(input3);
		this.add(input4);
		this.add(input5);

		//		int num = (int)(Math.random()*1)+1;
		//		ImageIcon test = new ImageIcon("image/images/sTest_"+num+".png");


		scoreLabel = new JTextField("  SCORE : " + gamescore);
		scoreLabel.setFont(new Font("Sanscerif", Font.BOLD, 30));
		scoreLabel.setBorder(BorderFactory.createEmptyBorder());
		scoreLabel.setBackground(Color.white);
		this.setComponentZOrder(scoreLabel, 0);
		scoreLabel.setBounds(0, 0, 200, 50);
		this.add(scoreLabel);

		
		
		Timer timer = new Timer(panel);
		timer.start();

		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				answer[0] = input.getText();
				answer[1]  = input2.getText();
				answer[2] = input3.getText();
				answer[3] = input4.getText();
				answer[4] = input5.getText();
				System.out.println(answer[0]);
				System.out.println(answer[1]);
				System.out.println(answer[2]);
				System.out.println(answer[3]);
				System.out.println(answer[4]);
				for (int i = 0; i < answer.length; i++  ) {
					if("����ǹ��͸�".equals(answer[i])|| "����� ���͸�".equals(answer[i])) {
						point += 10;
					} if("������".equals(answer[i])) {
						point += 10;
					} if("�α��".equals(answer[i])) {
						point += 10;
					} if("��ٴ°�".equals(answer[i])) {
						point += 10;
					} if("�����".equals(answer[i])) {
						point += 10;
					}
				} if (point ==50) {
					point += 10;
				} if (point >= 0) {
					gamescore += point;
					System.out.println(gamescore);
					String totalscore = Integer.valueOf(gamescore).toString();
					scoreLabel.setText(" SCORE : " + totalscore);
					panel.remove(submit);
					panel.repaint();
					
				} if(gamescore == 0 || gamescore == 10 || gamescore == 20 || gamescore == 30 || gamescore == 40 || gamescore == 60) {
					printLabel.setBorder(BorderFactory.createEmptyBorder());
					printLabel.setText(gamescore + "����  ȹ���߽��ϴ�!");
					printLabel.setBounds(300,300,900,200);
					printLabel.setHorizontalAlignment(JTextField.CENTER);
					panel.repaint();
					

				}
			};
		});
		printLabel = new JTextField(gamescore + "����  ȹ���߽��ϴ�!");
		printLabel.setFont(new Font("Sanscerif", Font.BOLD, 70));
		printLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new MainMap4(mf));
				
			}
		});
		this.setComponentZOrder(scoreLabel, 0);
		this.add(printLabel);
	}
}



