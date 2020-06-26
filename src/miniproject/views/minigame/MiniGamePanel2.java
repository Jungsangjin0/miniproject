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

import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.somang.Sosok;

public class MiniGamePanel2 extends JPanel  { // �̴ϰ��� ����ȭ�� (�㿬���� ���� �ι�°ȭ��) -> �ٽ� �Ҽӻ� 
											  // Ű���� �Է¹��� �� �ι�°ȭ�� ����(ȭ��ǥ) �ȶ�..., ���� ����(3����(ȭ��ǥ21��)�� 2�� �̻� ����� ��ų+1, �ƴϸ� ���� �� ������.
	private ImageIcon back;
	private ImageIcon talk;
	private ImageIcon characters;
	private MainFrame mf;
	private JPanel panel2;
	private int x = 300;  //����(ù��°ȭ��ǥ ��ġ��)
	private int x2 = 300; //����(�ι�°ȭ��ǥ ��ġ��)
	private JLabel[] arrows; //ȭ��ǥ(����)
	private int[] arrNo; //ȭ��ǥ(����)
	private ArrayList<JLabel> inputs;
	private int ctn = 0;
	private int index = 0;
	int num = 0;


	public MiniGamePanel2(MainFrame mf) { //����ȭ��

		this.mf=mf;
		panel2 = this;
		this.setLayout(null);

		back = new ImageIcon("src/miniproject/images/SJH/minigamekey.PNG"); //���
		talk = new ImageIcon("src/miniproject/images/SJH/conv.PNG"); //��ȭâ
		characters = new ImageIcon("src/miniproject/images/SJH/Characters_1.GIF"); //ĳ����
		
//		mf.setFocusable(true);

		//ȭ��ǥ(����)
		arrows = new JLabel[7];
		inputs = new ArrayList<JLabel>();
		arrNo = new int[7];

		panel2.addMouseListener(new MyMouseAdapter());

		buttonInit();
		

		mf.addKeyListener(new KeyAdapter() {		//**this�� �ϸ� ����ȵ�........z

			@Override
			public void keyPressed(KeyEvent e) { 
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


				addButton(num);	//(�Ȼ���.........���Ȥ��ʤ�)->�ذ���.	
				ctn++;
			}


		});

	}

	//ù���� ȭ��ǥ ���(����)
	public void buttonInit(){
			
		for(int i = 0; i < arrows.length; ++i) {
			int num = new Random().nextInt(4) + 1;
			arrNo[i] = num;
			ImageIcon arrow = new ImageIcon("src/miniproject/images/SJH/"+num+"-blue.png");
			//URL url = getClass().getClassLoader().getResource(num+"-blue.png");

			arrows[i] = new JLabel(new ImageIcon(arrow.getImage().getScaledInstance(150, 150, 0)));
			arrows[i].setBounds(x, 100, 150, 150);
			x += 150;
			this.add(arrows[i]);
			System.out.println("�ι��� Ȯ�ο�");

			this.repaint();
			this.revalidate();
			
		}
		
		
		
	}




	// �ι�° ȭ��ǥ ���(����)
	public void addButton(int num) { 

		//this.num = num;
		//this.addButton(num);
		//this.add(panel2);

		System.out.println("����°Ȯ�ο� :" + num);

		if(index >= 7){
			reset();
			index = 0;
		}else{
			System.out.println("�׹�°Ȯ�ο� : " + index);

			String color = "";

			if(arrNo[index] == num) { 
				color = "blue";
				ImageIcon arrow = new ImageIcon("src/miniproject/images/SJH/"+num+"-"+color+".png");

				//URL url = getClass().getClassLoader().getResource("pororo-"+num+".png");


				System.out.println("�ټ���°Ȯ�ο� : " + index);
				//this.back.getImage();		

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


	}


	public void reset(){

		System.out.println("������°Ȯ�ο�");

		//21��ȭ��ǥ(��3��)������ ����(7�� ����)�ؼ� ���� ����,  
		//���ٿ� 7��ȭ��ǥ, �� 21�� ȭ��ǥ 
		//ȭ��ǥ�� 7������ �������� ȭ��ǥ ������ �� �ٽ� ��� �� 21������..
		if(ctn < 22 ) {
			
		for (int i = 0; i < arrows.length; i++) {
			this.remove(arrows[i]);
			System.out.println("��ȩ��°Ȯ�ο�" + "arrows : " + arrows +"i"+i  );
			this.repaint();
		}

		buttonInit();

		for (int i = 0; i < arrNo.length; i++) {
			this.remove(this.inputs.get(i));
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
			
		}
	}

	





	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(back.getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
		g.drawImage(talk.getImage(), 0, 600, 1400, 250,null); //���� ��ġ : 0,600,1400,250
		g.setFont(new Font("Neo�ձٸ�", Font.BOLD, 30));
		g.drawString("����ϸ� �뷡��ų +1 !!!", 100, 700); //�۾� ��ġ ���� �ʿ�
		g.drawImage(characters.getImage(), 10, 100, 398, 398, this); //����ũ�� : 398,398


	}

	class MyMouseAdapter extends MouseAdapter{


		@Override
		public void mouseClicked(MouseEvent e) {
//			ChangePanel.changePanel(mf, panel2, new MiniGamePanel3(mf));		
			ChangePanel.changePanel(mf, panel2, new Sosok(mf));		
			mf.revalidate();
			
		}



	}
}




