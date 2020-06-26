package miniproject.views.suddenGame;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.mainMap.MainMap6;

public class GamePanelReal extends JPanel {
   private Banner banner = new Banner();
   private Gamepan pan = new Gamepan();
   private GamePanelReal panel = this;
   private MainFrame mf;
   
   public void paintComponent(Graphics g) {
      ImageIcon bground = new ImageIcon("src/miniproject/images/suddenGame/bground_0.jpg");
      g.drawImage(bground.getImage(), 0, 0, 1400, 900, null);
      setOpaque(false); 
      super.paintComponent(g);
   }
   
   public GamePanelReal (MainFrame mf) {
      this.mf = mf;
      pan.setLocation(30,30);
      this.add(pan);
      JButton tempPass = new JButton ("»Æ¿Œ!");
      tempPass.setLayout(null);
      tempPass.setBounds(1000,20,200,50);
      this.add(tempPass);
      
      tempPass.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            ChangePanel.changePanel(mf, panel, new MainMap6(mf));
            
         }
      });
   }
}