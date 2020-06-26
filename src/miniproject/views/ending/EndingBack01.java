package miniproject.views.ending;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import miniproject.views.MainFrame;

public class EndingBack01 extends JPanel { //0~50% - 방구석스타(남캐릭터)
	
	ImageIcon imageicon = new ImageIcon("src/miniproject/images/SJH/ending_01.PNG");
	Image image = imageicon.getImage();
	MainFrame mf;
	EndingBack01 panel = this;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Neo둥근모",Font.BOLD,30));
		g.drawString("총점은~", 50, 50);
		
	}
	
	public EndingBack01(MainFrame mf) {
		this.mf = mf;
		this.setFocusable(true);
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.exit(0);
				}
				
			}
		});
	}
	
}
	
	/*private Game1 mf; //frame
	private JPanel ending; //panel  */	
	
	/*public Ending01(Game1 mf) { //background-ending1
		this.mf= mf;
		ending = this;
		this.setLayout(null);
		
		Image icon; //엔딩1배경
		
		
		icon = new ImageIcon("images/images/ending_01.PNG").getImage().getScaledInstance(1100, 650, 0);
	
		JLabel label = new JLabel(new ImageIcon(icon));
		label.setBounds(0,0,1100,650);
				
		ending.add(label);	 // 배경
		*/

		

