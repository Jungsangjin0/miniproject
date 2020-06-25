package miniproject.views.jungukGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;


public class SubPage extends JPanel {
	private MainFrame mf;
	private JPanel panel = this;
	private Image quest = new ImageIcon("src/miniproject/images/junguk/Q1.png").getImage().getScaledInstance(1000, 700, 0);
	private ImageIcon bg = new ImageIcon("src/miniproject/images/junguk/bg1.PNG");

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg.getImage(), 0, 0, 1400, 900, null);
		setOpaque(false);
	}

	public SubPage(MainFrame mf) {

		JLabel label = new JLabel(new ImageIcon(quest));
		//		label.setLayout(null);
		//		label.setLocation(0,100);
		this.add(label); 


		this.addMouseListener(new MouseAdapter() {
			private GamePanel gp;

			public void mouseClicked(MouseEvent e) {
				System.out.println("다음페이지");
				ChangePanel.changePanel(mf, panel, new GamePanel(mf));
				mf.revalidate();
			}
		});
	}

}
