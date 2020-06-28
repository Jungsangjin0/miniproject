package miniproject.views.mainMap;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import dongyub.PlayerLabel;
import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.jungukGame.MainPage;
import miniproject.views.somang.Park;



public class MainMapdispatch extends JPanel {	
	private int donum;
	private MainFrame mf;
	private MainMapdispatch panel = this;
	private Door[] doors = {new Door(), new Door(), new Door(), new Door(), new Door(), new Door()};
	private Player123 player;

	private PlayerLabel fl = new PlayerLabel();

	public void paintComponent(Graphics g) {
		setFocusable(true);
		requestFocus();
		ImageIcon bground = new ImageIcon("src/miniproject/images/mainMap/MainMap.png");
		g.drawImage(bground.getImage(), 0, 0, 1400, 900, null);
		setOpaque(false); //그림을 표시하게 설정,투명하게 조절
		super.paintComponent(g);
	}

	public MainMapdispatch (MainFrame mf,Player123 player) {
		this.player = player;
		this.mf = mf;
		this.addKeyListener(new MyKeyListenerDispatch(fl, mf, panel, player));
		fl.setLayout(null);
		fl.setBounds(1075, 500, 100, 100);
		this.add(fl);
		this.setFocusable(true);

	}

}


