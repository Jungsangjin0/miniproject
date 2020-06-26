package miniproject.views.selectC;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.firstPage.FirstPage;
public class SelectC extends JPanel {
	
	private MainFrame mf;
	private SelectC sc = this;
	
//	Image m = new ImageIcon("src/miniproject/images/selectC/Characters02.gif").getImage();
	JLabel label;
	
	public void paintComponent(Graphics g) {	
		ImageIcon  sback = new ImageIcon("src/miniproject/images/nickNameSelect/nickname_background.jpeg");
		g.drawImage(sback.getImage(), 0, 0, 1400, 900, null);
		mf.repaint();
		setOpaque(false); 
		super.paintComponent(g);
		mf.repaint();
		
	}
	
	public SelectC(MainFrame mf) {
		this.mf =mf;
//		Male m = new Male(mf);
//		m.setLayout(null);
//		m.setBounds(300,300,100,100);
//		this.setComponentZOrder(m, 0);
//		this.add(m);
		label = new JLabel();
		label.setIcon(new ImageIcon("src/miniproject/images/selectC/Characters02.gif"));
		label.setBounds(200,50,1000,700);
		sc.add(label);
		
		
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, sc, new FirstPage(mf));
				mf.validate();
				
			}

			
			
		});
		
	}
	
}	
	