package miniProject4.com.kh.views;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Timer2 extends Thread{
	private  JFrame mf;
	private JPanel panel;
	private boolean isStop = false;
	MouseEvent e;
	
	public Timer2() {
		
	}
	
	public Timer2(JFrame mf, JPanel panel) {
		this.mf=mf;
		this.panel =panel;
	}
	
	
	
	@Override
	public void run() {
		int i  = 20;
		JTextField label = new JTextField();
		label.setBounds(0,0,150,50);
		label.setFont(new Font("Sanscerif",Font.BOLD,20));
		panel.add(label);
		//while(i >= 0 && (!isStop)) {
		while(i >= 0 && !Thread.currentThread().isInterrupted()) {	
			try {
				System.out.println(i);
				this.sleep(1000);
				label.setText("제한시간 : " + i);
			}catch(InterruptedException e) {
				//e.printStackTrace();
				
			}
			i--;
//			if(Thread.interrupted()) {
//				//ssingNext_lose();
//				break;
//			}
		}
		
		System.out.println("종료");

		
	}//--run 
	
	public void setStop(boolean isStop) {
		this.isStop = isStop;
	}
	
	
//	class clickPanel extends MouseAdapter {
//		@Override
//		public void mouseClicked(MouseEvent e) {
//
//			SsingNext_lose gp = new SsingNext_lose(mf);
//
//			ChangePanel.replacePanel(mf, panel, gp);
//
//		}
//	}
	



	
	public class Test1{
		
		public void process() {
			Timer2 t2 = new Timer2();
			Thread thread = new Thread(t2);
			thread.start();
			try {
				Thread.sleep(2000);
			}catch(Exception e) {
				e.printStackTrace();
			}
			t2.interrupt();
		}
	}
	
	
}
