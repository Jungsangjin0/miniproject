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
		//JFrame �� ���� �⺻ �� ����
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//JFrame ������ ����
		setSize(1400,900);
		//JFrame  �� �г� ���̱�
		add(s);
		setVisible(true);
		setResizable(false);
		
//		// �гο� Ű������ �߰�
//		cp.addKeyListener(new MyKeyListener(la));
//		// �гο� �� ���� �� �гο� ����
//		cp.add(la);
//		//�гο� ��Ŀ��
//		cp.requestFocus(); 
//		//JPanel ���̾ƿ� null 
//		cp.setLayout(null);
//		
//		//�� ���� �⺻ ����
//		la.setLocation(440, 440);
//		la.setSize(100, 100);
		
	}
	



}
