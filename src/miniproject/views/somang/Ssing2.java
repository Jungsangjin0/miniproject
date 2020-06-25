package miniproject.views.somang;

import java.awt.*;
import java.awt.event.ActionEvent;
//import java.util.Scanner;
//import java.awt.event.*;
//import java.net.URL;
//import java.util.Random;
import java.awt.event.ActionListener;

//import javax.activation.ActivationDataFlavor;
import javax.swing.*;

public class Ssing2 extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private ImageIcon icon;
	private ImageIcon talk;
	private ImageIcon charac01;
	private ImageIcon sTest;

	private JTextField input;
	private JTextField input2;
	private JTextField input3;
	String one = "";
	String two = "";
	String three = "";
	//int ncnt=0;
	
	// Scanner sc = new Scanner(System.in);
	public Ssing2(JFrame mf) {
		// panel = new JPanel();
		panel = this;
		this.setLayout(null);
		icon = new ImageIcon("image/Ssing/sosokSing.png");
		talk = new ImageIcon("image/Ssing/talkFrame.png");
		charac01 = new ImageIcon("image/Ssing/Characters01.gif");

		// sTest = new ImageIcon("image/images/sTest_1.png");
		// Stext();

		// �뀓�뒪�듃�엯�젰
		JLabel label = new JLabel("鍮덉뭏�뿉 �뱾�뼱媛� 留먯�? : ");
		label.setFont(new Font("Neo�뫁洹쇰え", Font.PLAIN, 25));
		label.setBounds(70, 740, 250, 50);
		panel.add(label);

		input = new JTextField();
		input2 = new JTextField();
		input3 = new JTextField();

		// input.addActionListener(action);
		input.setFont(new Font("Neo�뫁洹쇰え", Font.BOLD, 30));
		input.setBounds(300, 740, 100, 50);

		// input2.addActionListener(action);
		input2.setFont(new Font("Neo�뫁洹쇰え", Font.BOLD, 30));
		input2.setBounds(410, 740, 100, 50);

		// input3.addActionListener(action);
		input3.setFont(new Font("Neo�뫁洹쇰え", Font.BOLD, 30));
		input3.setBounds(520, 740, 100, 50);

		panel.add(input);
		panel.add(input2);
		panel.add(input3);

		// StestPass();
		Ssing_test st = new Ssing_test(mf, panel, num, input, input2, input3);

//		input.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				one = input.getText();
//				System.out.println(one);
//				st.StestPass(input);
//			}
//
//		});
//		input2.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				two = input2.getText();
//				System.out.println(two);
//				st.StestPass(input2);
//			}
//
//		});
		//3踰덉㎏�뿉�꽌留� �뿏�꽣 �씠踰ㅽ듃 諛쒖깮  -> �쟾泥� �엯�젰�떆 �븳踰덉뿉 寃��넗�썑 �꽆�뼱媛�湲�
		input3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				one = input.getText();
				System.out.println(one);
				//st.StestPass(input);

				two = input2.getText();
				System.out.println(two);
				//st.StestPass(input2);

				three = input3.getText();
				System.out.println(three);
				//st.StestPass(input3);
				
				String[] inputArr = {one, two, three};
				
				st.StestPass(inputArr);
				
//				UserAnswer userAnswer = new UserAnswer();
//				userAnswer.setFirstAnswer(input.getText());
//				userAnswer.setSecondAnswer(input2.getText());
//				userAnswer.setThirdAnswer(input3.getText());
//				
//				st.StestPass(userAnswer);
				//ncnt++;				
			}

		});

	}

	int num = (int) (Math.random() * 10) + 1;
	ImageIcon test = new ImageIcon("image/Ssing/sTest_" + num + ".png");
	

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		// JTextField sText = new JTextField();
		// sText.setBounds(50,500,180,40);

		// 諛곌꼍�씠誘몄�
		g.drawImage(icon.getImage(), 0, 0, null);
		// ���솕李쎌씠誘몄�
		g.drawImage(talk.getImage(), 5, 620, 1390, 250, null);
		// 罹먮┃�꽣 �씠誘몄�
		if (charac01 != null) {
			g.drawImage(charac01.getImage(), 50, 200, 398, 398, this);
		}
		// �뀒�뒪�듃 �씠誘몄�

		sTest = test; // �씠誘몄� 1
		g.drawImage(sTest.getImage(), 500, 180, 772, 408, null); 

		g.setFont(new Font("Neo 둥근모" , Font.BOLD, 36));
		g.drawString("鍮덉뭏�뿉 �븣留욎� �끂�옒媛��궗瑜� �쟻�옄! �뿏�꽣瑜� �늻瑜댁� �븡�쑝硫� 臾댄슚! \n", 70, 720);

//	if(ncnt==0) {
//		sTest = test; // �씠誘몄� 1
//		g.drawImage(sTest.getImage(), 500, 180, 772, 408, null); 
//	}else if(ncnt ==1){
//		sTest = test; // �씠誘몄� 1
//		g.drawImage(sTest.getImage(), 500, 180, 772, 408, null); 
//	}
		
		setOpaque(false);

	}

}
