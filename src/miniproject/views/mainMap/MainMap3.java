package miniproject.views.mainMap;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import dongyub.PlayerLabel;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.jungukGame.MainPage;
import miniproject.views.somang.Park;
import miniproject.views.somang.Sosok;
import miniproject.views.trotGame.TrotGame;



public class MainMap3 extends JPanel {	
	private int donum;
	MainFrame mf;
	MainMap3 panel = this;
	private Door[] doors = {new Door(), new Door(), new Door(), new Door(), new Door(), new Door()};
	
	
	PlayerLabel fl = new PlayerLabel();
	
	public void paintComponent(Graphics g) {
		ImageIcon bground = new ImageIcon("src/miniproject/images/mainMap/MainMap.png");
		
		g.drawImage(bground.getImage(), 0, 0, 1400, 900, null);
		//			Point p = scrollPane.getViewport().getViewPosition();
		//g.drawImage(bground.getImage(), p.x, p.y, null);
		setOpaque(false); //그림을 표시하게 설정,투명하게 조절
		super.paintComponent(g);
	}
	public MainMap3 (MainFrame mf) {
		
		this.mf = mf;
		
		this.addKeyListener(new MyKeyListener(fl));
		fl.setLayout(null);
		fl.setBounds(1075, 500, 100, 100);
		this.add(fl);
		this.setFocusable(true);
		
		
		
		
//	this.doors[0].setLayout(null); //집
//	this.doors[0].setBounds(1075, 500, 50, 25); 
//	doors[0].setVisible(false);
	
//	this.doors[1].setLayout(null); //공원
//	this.doors[1].setBounds(500, 180, 308, 65); 
//	doors[1].setVisible(false);
	
//	this.doors[2].setLayout(null); //소속사
//	this.doors[2].setBounds(650, 500, 50, 25); 
//	doors[2].setVisible(false);
	
	this.doors[3].setLayout(null); //전국노래자랑
	this.doors[3].setBounds(850, 30, 80, 40); 
//	
	this.doors[4].setLayout(null); //미스터트롯 방송국 
	this.doors[4].setBounds(340, 595, 70, 30); 
//	
//	this.doors[5].setLayout(null); //디스패치
//	this.doors[5].setBounds(870, 0, 10, 900); 
	
//	this.add(doors[0]);
//	this.add(doors[1]);
//	this.add(doors[2]);
	this.add(doors[3]);
	this.add(doors[4]);
//	this.add(doors[5]);
	
//	doors[0].addMouseListener(new MouseAdapter() {
//		
//		
//		
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			
//			donum = 1;
//			doors_excute();
//			System.out.println("ㄱ,민헤...");
//			
//		}
//	});
//	
//	doors[1].addMouseListener(new MouseAdapter() {
//		
//		
//		
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			
//			donum = 2;
//			doors_excute();
//			System.out.println("ㄱ,민헤...");
//		}
//	});
//	
	doors[3].addMouseListener(new MouseAdapter() {
		
		
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			donum = 4;
			doors_excute();
			System.out.println("ㄱ,민헤...");
		}
	});
//	
//}
	doors[4].addMouseListener(new MouseAdapter() {
		
		
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			donum = 5;
			doors_excute();
			System.out.println("ㄱ,민헤...");
		}
	});
	
}
	
	
	
	public void doors_excute() {
		
		switch(donum) {
		case 1:
			break;
		
		case 2:
			ChangePanel.changePanel(mf, panel, new Park(mf));
			mf.revalidate();
			break;
		case 3:
			ChangePanel.changePanel(mf, panel, new Sosok(mf));
			mf.revalidate();
			break;
		case 4: 
			ChangePanel.changePanel(mf, panel, new MainPage(mf));
			mf.revalidate();
			break;
		case 5:
			ChangePanel.changePanel(mf, panel, new TrotGame(mf));
			mf.revalidate();
			break;
		case 6: break;
		}
	}
}
	

