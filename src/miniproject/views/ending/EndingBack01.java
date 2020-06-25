package miniproject.views.ending;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class EndingBack01 extends JPanel { //0~50% - 방구석스타(남캐릭터)
	
	ImageIcon imageicon = new ImageIcon("images/ending_01.PNG");
	Image image = imageicon.getImage();
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Neo둥근모",Font.BOLD,30));
		g.drawString("총점은~", 50, 50);
		
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

		

