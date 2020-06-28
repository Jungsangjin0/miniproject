package miniproject.views.jungukGame;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.minipublic.Sosok_01_second;

public class GamePanel extends JPanel{
	private MainFrame mf;
	private JPanel panel;
	private Player123 player;
	
	private int t = 60;
	private int num = (((int)(Math.random()*5 )+1)) ;
	private ImageIcon [] games = new ImageIcon[5];

	private Image bicon = new ImageIcon("src/miniproject/images/junguk/button.PNG").getImage().getScaledInstance(190, 58, 0);
	private Image sL2 = new ImageIcon("src/miniproject/images/junguk/scorelabel2.PNG").getImage().getScaledInstance(600, 200, 0);
	private Image score0 = new ImageIcon("src/miniproject/images/junguk/0.PNG").getImage().getScaledInstance(100, 200, 0);
	private Image score10 = new ImageIcon("src/miniproject/images/junguk/10.PNG").getImage().getScaledInstance(200, 200, 0);
	private Image score20 = new ImageIcon("src/miniproject/images/junguk/20.PNG").getImage().getScaledInstance(200, 200, 0);
	private Image score30 = new ImageIcon("src/miniproject/images/junguk/30.PNG").getImage().getScaledInstance(200, 200, 0);
	private Image score40 = new ImageIcon("src/miniproject/images/junguk/40.PNG").getImage().getScaledInstance(200, 200, 0);
	private Image score60 = new ImageIcon("src/miniproject/images/junguk/60.PNG").getImage().getScaledInstance(200, 200, 0);
	private Image sp = new ImageIcon("src/miniproject/images/junguk/sp.PNG").getImage().getScaledInstance(600, 200, 0);

	private String[] answer = new String[5];
	private int gamescore = 0;

	private String one = "";
	private String two = "";
	private String three = "";
	private String four = "";
	private String five = "";
	
	private JTextField input;
	private JTextField input2;
	private JTextField input3;
	private JTextField input4;
	private JTextField input5;
	private JTextField scoreLabel;
	private JTextField timeLabel;
	private JLabel printLabel;
	private int point = 0;

	private Timer timer;


	public GamePanel(MainFrame mf, Player123 player) {
		
		this.mf = mf;
		this.player = player;
		
		panel = this;
		this.setLayout(null);

		games[0] = new ImageIcon("src/miniproject/images/junguk/0_game.png");
		games[1] = new ImageIcon("src/miniproject/images/junguk/1_game.png");
		games[2] = new ImageIcon("src/miniproject/images/junguk/2_game.png");
		games[3] = new ImageIcon("src/miniproject/images/junguk/3_game.png");
		games[4] = new ImageIcon("src/miniproject/images/junguk/4_game.png");

		int i = (int)(Math.random()*games.length);
		System.out.println(i);
		Image newGame = games[i].getImage().getScaledInstance(1400, 900, 0);


		JLabel gamePage = new JLabel(new ImageIcon(newGame));
		gamePage.setLayout(null);
		gamePage.setBounds(0, -30, 1400, 900);
		this.add(gamePage);


		JButton submit = new JButton(new ImageIcon(bicon));
		submit.setLayout(null);
		submit.setBounds(308, 710, 190, 38);
		submit.setVisible(true);
		submit.setBorderPainted(false);
		submit.setContentAreaFilled(false);
		submit.setFocusPainted(true);
		this.setComponentZOrder(submit, 0);
		gamePage.add(submit);



		input = new JTextField();
		input.setLayout(null);
		input.setBounds(130,560,170,40);

		input2 = new JTextField();
		input2.setLayout(null);
		input2.setBounds(130,620,170,40);

		input3 = new JTextField();
		input3.setLayout(null);
		input3.setBounds(130,680,170,40);

		input4 = new JTextField();
		input4.setLayout(null);
		input4.setBounds(320,560,170,40);

		input5 = new JTextField();
		input5.setLayout(null);
		input5.setBounds(320,620,170,40);

		JLabel silpae = new JLabel(new ImageIcon(sp));
		silpae.setLayout(null);
		silpae.setBounds(440, 400, 600, 200);
		gamePage.add(silpae);
		silpae.setVisible(false);
		
		silpae.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new Sosok_01_second(mf, player));
			}
		});

		Font neo = new Font("Sanscerif",Font.BOLD,27);
		JTextField tm = new JTextField("  ���� �ð�  : ");

		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tm.setText("  ���� �ð�  :  " + (t));
				if (t == 0) {
					timer.stop();
					try {
						Thread.sleep(1200);
						silpae.setVisible(true);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					tm.setText("  �ð��ʰ�!");
				}
				t--;
			}
		}   
				);
		tm.setFont(neo);
		tm.setLayout(null);
		tm.setBounds(250, 95, 250, 80);
		gamePage.add(tm);
		timer.start();


		this.add(input);
		this.add(input2);
		this.add(input3);
		this.add(input4);
		this.add(input5);

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

				if(i == 0) {
					for (int j = 0; j < answer.length; j++  ) {
						if("����ǹ��͸�".equals(answer[j])|| "����� ���͸�".equals(answer[j])) {
							point += 10;
						} if("������".equals(answer[j])) {
							point += 10;
						} if("�α��".equals(answer[j])) {
							point += 10;
						} if("��ٴ°�".equals(answer[j])) {
							point += 10;
						} if("�����".equals(answer[j])) {
							point += 10;
						}

					}} else if(i == 1) {
						for (int j = 0; j < answer.length; j++  ) {
							if("��Ŭ��������".equals(answer[j])|| "��Ŭ�� ������".equals(answer[j])) {
								point += 10;
							} if("�ȵ�������".equals(answer[j])) {
								point += 10;
							} if("�����λ�".equals(answer[j])|| "���� �λ�".equals(answer[j])) {
								point += 10;
							} if("������".equals(answer[j])) {
								point += 10;
							} if("������".equals(answer[j])) {
								point += 10;
							}

						}} else if(i == 2) {
							for (int j = 0; j < answer.length; j++  ) {
								if("ù���".equals(answer[j])|| "ù ���".equals(answer[j])) {
									point += 10;
								} if("�����".equals(answer[j])) {
									point += 10;
								} if("��ӳ�".equals(answer[j])) {
									point += 10;
								} if("§¥��".equals(answer[j])) {
									point += 10;
								} if("�̵��̵���".equals(answer[j])) {
									point += 10;
								}
							}} else if(i == 3) {
								for (int j = 0; j < answer.length; j++  ) {
									if("�����Ʈ����Ʈ".equals(answer[j])|| "����� Ʈ����Ʈ".equals(answer[j])) {
										point += 10;
									} if("����ǿ���".equals(answer[j])|| "����� ����".equals(answer[j])) {
										point += 10;
									} if("�׷����ھ����".equals(answer[j])||"�׷����� �����".equals(answer[j])) {
										point += 10;
									} if("���ű���".equals(answer[j])||"���ű� ���".equals(answer[j])) {
										point += 10;
									} if("����".equals(answer[j])) {
										point += 10;
									}
								}} else if(i == 4) {
									for (int j = 0; j < answer.length; j++  ) {
										if("�Ƹ���Ƽ".equals(answer[j])|| "�Ƹ� ��Ƽ".equals(answer[j])) {
											point += 10;
										} if("������".equals(answer[j])) {
											point += 10;
										} if("��Ÿ��".equals(answer[j])) {
											point += 10;
										} if("������ ����".equals(answer[j])||"�����ǿ���".equals(answer[j])) {
											point += 10;
										} if("���������".equals(answer[j])||"����� ����".equals(answer[j])) {
											point += 10;
										}
									}
								} if (point ==50) {
									point += 10;
								} if (point >= 0) {
									gamescore += point;
									System.out.println(gamescore);
									gamePage.remove(submit);
									gamePage.repaint();
									JLabel scoreprint = new JLabel(new ImageIcon(sL2));
									scoreprint.setLayout(null);
									scoreprint.setBounds(530, 300, 600, 200);
									gamePage.add(scoreprint);
									
									scoreprint.addMouseListener(new MouseAdapter() {
										@Override
										public void mouseClicked(MouseEvent e) {
											ChangePanel.changePanel(mf, panel, new Sosok_01_second(mf, player));
											
										}
									});


									if (gamescore ==0) {
										JLabel scoreP = new JLabel(new ImageIcon(score0));
										scoreP.setLayout(null);
										scoreP.setBounds(330, 300, 200, 200);
										gamePage.add(scoreP);
									}
									if(gamescore == 60) {
										JLabel scoreP1 = new JLabel(new ImageIcon(score60));
										scoreP1.setLayout(null);
										scoreP1.setBounds(330, 300, 200, 200);
										gamePage.add(scoreP1);
									} else if(gamescore == 40 && gamescore >39) {
										JLabel scoreP1 = new JLabel(new ImageIcon(score40));
										scoreP1.setLayout(null);
										scoreP1.setBounds(330, 300, 200, 200);
										gamePage.add(scoreP1);
									}else if(gamescore == 30 && gamescore >29) {
										JLabel scoreP1 = new JLabel(new ImageIcon(score30));
										scoreP1.setLayout(null);
										scoreP1.setBounds(330, 300, 200, 200);
										gamePage.add(scoreP1);
									} else if(gamescore == 20 && gamescore >19 ) {
										JLabel scoreP1 = new JLabel(new ImageIcon(score20));
										scoreP1.setLayout(null);
										scoreP1.setBounds(330, 300, 200, 200);
										gamePage.add(scoreP1);
									} else if(gamescore == 10 && gamescore >9) {
										JLabel scoreP1 = new JLabel(new ImageIcon(score10));
										scoreP1.setLayout(null);
										scoreP1.setBounds(330, 300, 200, 200);
										gamePage.add(scoreP1);
									} 
								}
								
			};
		});
	}
};

