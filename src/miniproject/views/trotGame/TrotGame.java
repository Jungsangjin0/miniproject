package miniproject.views.trotGame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.mainMap.MainMap5;

public class TrotGame extends JPanel{
	
	Image off = new ImageIcon("src/miniproject/images/camera/image_0.png").getImage().getScaledInstance(400, 250,java.awt.Image.SCALE_SMOOTH);
	Image on = new ImageIcon("src/miniproject/images/camera/image_1.png").getImage().getScaledInstance(400, 250, java.awt.Image.SCALE_SMOOTH);
	Image back = new ImageIcon("src/miniproject/images/camera/background.jpeg").getImage().getScaledInstance(1400, 900, java.awt.Image.SCALE_SMOOTH);
	
	private MainFrame mf;
	private JPanel panel;
	private int[] board = new int[9];
	private JLabel[] cameraoff = new JLabel[9];
	
	private int score = 0 ;
	private int timeLeft = 30;
	
	
	private JLabel lbScore;
	private JLabel lbTimeLeft;
	
	private JButton btnStart;
	private JButton btnExit;
	private Timer timer;
	
	private String  con = "ON";
	private String  coff = "OFF";
	private int i2;
	JLabel label = new JLabel();
	private boolean programStart = false;
	
	public TrotGame(MainFrame mf) {
		this.mf = mf;
		panel = this;
		
		initGUI();
		addC();
		initEvents();
		
	}
	
	private void initGUI() {
		
		this.setLayout(null);
		
		lbScore = new JLabel("점수 : 0");
		lbScore.setHorizontalAlignment(SwingConstants.TRAILING);
		
		lbScore.setFont(new Font("Gothic", Font.BOLD, 20));
		lbScore.setBounds(423,20,144,200);
		panel.add(lbScore);
		
		lbTimeLeft = new JLabel("시간 : ");
		lbTimeLeft.setHorizontalAlignment(SwingConstants.CENTER);
		lbTimeLeft.setFont(new Font("Gothic", Font.BOLD, 20));
		lbTimeLeft.setBounds(232,20,144,200);
		panel.add(lbTimeLeft);
		
		btnStart = new JButton("눌러주세용");
		btnStart.setBounds(32,60,110,33);
		btnExit  = new JButton("종료버튼이랍니다~");
		btnExit.setBounds(180,60,110,33);
		
		panel.add(btnExit);
		panel.add(btnStart);
		btnExit.setEnabled(false);
		
		
	}
	
	private void addC() {
		cameraoff[0] = new JLabel(coff);
		cameraoff[0].setName(coff);
		cameraoff[0].setIcon(new ImageIcon(off));
		cameraoff[0].setBounds(50, 150, 400, 250);
		panel.add(cameraoff[0]);

		cameraoff[1] = new JLabel(coff);
		cameraoff[1].setName(coff);
		cameraoff[1].setIcon(new ImageIcon(off));
		cameraoff[1].setBounds(470, 150, 400, 250);
		panel.add(cameraoff[1]);

		cameraoff[2] = new JLabel(coff);
		cameraoff[2].setName(coff);
		cameraoff[2].setIcon(new ImageIcon(off));
		cameraoff[2].setBounds(900, 150, 400, 250);
		panel.add(cameraoff[2]);
		
		cameraoff[3] = new JLabel(coff);
		cameraoff[3].setName(coff);
		cameraoff[3].setIcon(new ImageIcon(off));
		cameraoff[3].setBounds(50, 370, 400, 250);
		panel.add(cameraoff[3]);
		
		cameraoff[4] = new JLabel(coff);
		cameraoff[4].setName(coff);
		cameraoff[4].setIcon(new ImageIcon(off));
		cameraoff[4].setBounds(470, 370, 400, 250);
		panel.add(cameraoff[4]);
		
		cameraoff[5] = new JLabel(coff);
		cameraoff[5].setName(coff);
		cameraoff[5].setIcon(new ImageIcon(off));
		cameraoff[5].setBounds(900, 370, 400, 250);
		panel.add(cameraoff[5]);
		
		
		cameraoff[6] = new JLabel(coff);
		cameraoff[6].setName(coff);
		cameraoff[6].setIcon(new ImageIcon(off));
		cameraoff[6].setBounds(50, 600, 400, 250);
		panel.add(cameraoff[6]);
		
		
		cameraoff[7] = new JLabel(coff);
		cameraoff[7].setName(coff);
		cameraoff[7].setIcon(new ImageIcon(off));
		cameraoff[7].setBounds(470, 600, 400, 250);
		panel.add(cameraoff[7]);
		
		
		cameraoff[8] = new JLabel(coff);
		cameraoff[8].setName(coff);
		cameraoff[8].setIcon(new ImageIcon(off));
		cameraoff[8].setBounds(900, 600, 400, 250);
		panel.add(cameraoff[8]);
		
		
	}
	
	
	private void initEvents() {
		
		for(int i = 0; i < cameraoff.length; i++) {
			cameraoff[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JLabel lbl = (JLabel)e.getSource();
					String id = lbl.getText();
					System.out.println(id);
					System.out.println("인식됨");
					pressedButton(id,lbl);			
				}
			});
		}
		
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnStart.setEnabled(false);
				timer.start();
				for(int i = 0; i < cameraoff.length;i++) {
					new Thread(new DThread(i)).start();
				}
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.changePanel(mf, panel, new MainMap5(mf));
				
			}
		});
		
		
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(timeLeft == 0) {
					lbTimeLeft.setText("남은시간  : ");
					timer.stop();
					programStart = true;
					btnExit.setEnabled(true);
					
				}
				lbTimeLeft.setText("남은시간 : " + timeLeft);
				timeLeft--;
				
			}
		});
	}
	
	

	private void pressedButton(String id/*, int i*/, JLabel lbl) {
		String val = id;
		System.out.println(id);
		if("ON".equals(val)) {
			score += 10;
			lbScore.setText("점수 : " + score);
			lbl.setIcon(new ImageIcon(off));
			lbl.setText(coff);
			repaint();
		}else if("OFF".equals(val)){
			if(score <= 0) {
				score = 0;
				lbScore.setText("점수 : " + score);
			} else {
				score -= 10;
			}
		}
		lbScore.setText("점수 : " + score);
//		clearBoard(id);
		
	}
	
	private void saveHighscore() {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir")+"/highscore.txt", false));
			bw.write(""+score);
			bw.flush();
			bw.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error while saving hiasda sd", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	private void onHandler(int index) {
		cameraoff[index].setIcon(new ImageIcon(on));
		cameraoff[index].setText(con);
	}
	
	private void offHandler(int index) {
		cameraoff[index].setIcon(new ImageIcon(off));
		cameraoff[index].setText(coff);
	}
	
	
	
	
	public class DThread implements Runnable{
		int index = 0; //두더지번호
		
		public DThread(int index) {
			this.index = index;
		}
		
		@Override
		public void run() {
			while(!(programStart)) {
				try {
					int offtime = new Random().nextInt(8000) + 1000;
					Thread.sleep(offtime);
					onHandler(index);
					
					
					
					Thread.sleep(3000);
					offHandler(index);
//					int ontime = 0;
//					if((3000-ontime) == 3000) {
//						Thread.sleep(3000);
//						offHandler(index);
//					}else {
//						Thread.sleep(3000 - ontime);
//						ontime = ontime + 5000;
//						offHandler(index);
//					}
					
					
					
					
					
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(back,0, 0, 	1400, 900,null);
		setOpaque(false);
		mf.repaint();
	}
	

	
	
	

}