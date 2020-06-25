package dongyub;
 
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerFrame extends JFrame {

	//Image icon =  new ImageIcon("dispatch_images/chracter/character.png").getImage().getScaledInstance(100, 100, 0);

	//JPanel cp = new JPanel();

	//JLabel la = new JLabel(new ImageIcon(icon));

	PlayerPanel s = new PlayerPanel();
	
	public PlayerFrame() {
		//JFrame 에 대한 기본 값 설정
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//JFrame 사이즈 설정
		setSize(1400,900);
		//JFrame  에 패널 붙이기
		add(s);
		setVisible(true);
		setResizable(false);
		
//		// 패널에 키리스너 추가
//		cp.addKeyListener(new MyKeyListener(la));
//		// 패널에 라벨 설정 및 패널에 붙임
//		cp.add(la);
//		//패널에 포커싱
//		cp.requestFocus(); 
//		//JPanel 레이아웃 null 
//		cp.setLayout(null);
//		
//		//라벨 관련 기본 설정
//		la.setLocation(440, 440);
//		la.setSize(100, 100);
		
	}
	



}
