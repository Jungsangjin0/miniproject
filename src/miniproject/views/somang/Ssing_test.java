package miniproject.views.somang;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import miniProject4.com.kh.model.vo.UserAnswer;

public class Ssing_test {
	private JFrame mf;
	private JPanel panel;
	int num;
	JTextField input; // ���옣�븷怨듦컙 ���엯 �꽑�뼵
	JTextField input2;
	JTextField input3;
	private int cnt = 0;
	String one = "";
	String two = "";
	String three = "";
	boolean fone = false;
	boolean ftwo = false;
	boolean fthree = false;
	Thread thread;
	boolean isStop;
	Timer2 timer;
	MouseEvent e;

	public Ssing_test(JFrame mf, JPanel panel, int num, JTextField input, JTextField input2, JTextField input3) {
		this.mf = mf;
		this.panel = panel;
		this.num = num;
		this.input = input;
		this.input2 = input2;
		this.input3 = input3;

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

	public void cancel() {

		// Timer timer = new Timer(mf,panel);
		// boolean status = Thread.interrupted();
		// if(status) {
		// return;
		// }
		// if(!tStop) {

		timer	= new Timer2(mf, panel);

		
		thread.start();
		try {
			// if(!tStop) {
			// e.getSource()).stop();
			// }
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();

		}

		timer.interrupt();
		System.out.println(timer);
		// if(tStop) {

		// }

		// }

		// new clickPanel();
		// click.mouseClicked();
		// ssingNext_lose();

	}

	

	public void ssingNext() {
		// �넻怨쇱씠硫�(cnt 2�씠�긽�씠怨� 3�씠�릺硫�) �끂�옒�젏�닔+1
		// ���씠癒� stop�븯怨� �떎�쓬 �솕硫� �꽆�뼱媛�湲�
		SsingNext gp = new SsingNext(mf);

		ChangePanel.replacePanel(mf, panel, gp);
		stop();
	}

	
	
	public void cancel2() {

		timer	= new Timer2(mf, panel);



		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
		
		
		timer.interrupt();

//		timer.setStop(true);

	}
	public void ssingNext_lose() {
		// �넻怨쇱씠硫�(cnt 2�씠�긽�씠怨� 3�씠�릺硫�) �끂�옒�젏�닔+1
		// ���씠癒� stop�븯怨� �떎�쓬 �솕硫� �꽆�뼱媛�湲�
		SsingNext_lose gp = new SsingNext_lose(mf);

		ChangePanel.replacePanel(mf, panel, gp);
		stop();
	}
	
	public final void stop() {
		timer	= new Timer2(mf, panel);

		timer.interrupt();
	}
	
	
	//

	// �뀒�뒪�듃 �넻怨� �뿬遺�
	public void StestPass(String[] inputArr) {
		String[][] answers = {{"�뼹援�", "紐몃ℓ", "紐⑤뱺寃껋씠"}, 
							{"�떦�떊","�굹�뒗","諛고꽣由�"},
							{"�떦�떊", "�룞諛섏옄", "�꽑臾�"},
							{"媛��씤","媛��씤","媛��씤"},
							{"萸먯빞萸먯빞","萸먯빞","�궡踰꾨젮"},
							{"�쑀�뻾媛�","�굹�룄","荑듭영"},
							{"�닽�옄","吏꾩쭨","媛��뒾"},
							{"�븸踰�","湲곕떎由щ떎","異붿썙�슂"},
							{"留뚮뱶�젅","�굹�뒗","�뼢湲곗냽�뿉"},
							{"�삤�뒛","�궗�옉","�뿤�뼱吏�硫�"}		
		};
		
	//public void StestPass(UserAnswer user) {
		//clickPanel cp = new clickPanel();

		// num媛믪뿉 �뵲瑜� �젙�떟 鍮꾧탳
		switch (num) {
		case 1:
			//if (tf == input && "�떦�떊".equals(input.getText())) {
			if (answers[0][0].equals(inputArr[0])) {
				// 媛� �븳媛쒖뵫 鍮꾧탳 �썑 �젙�떟�씠硫� cnt++ -> cnt媛� 2�씠�긽�씠硫� �넻怨� -> �떎�쓬 �옣硫댁쑝濡� �꽆�뼱媛�湲�?
				System.out.println(input.getText());
				if (!fone) {
					cnt++;
					fone = true;

				}

				System.out.println(cnt);
			}
			if (answers[0][1].equals(inputArr[1])){
				System.out.println(cnt);
				if (!ftwo) {
					cnt++;
					ftwo = true;
				}
			}
			if (answers[0][2].equals(inputArr[2])) {
				System.out.println(cnt);
				if (!fthree) {
					cnt++;
					fthree = true;
				}
				// ((Timer2) timer).rre();
			}
			System.out.println(cnt);

			// ssingNext_lose();
			break;

		case 2:
			if (answers[1][0].equals(inputArr[0])) {
				// 媛� �븳媛쒖뵫 鍮꾧탳 �썑 �젙�떟�씠硫� cnt++ -> cnt媛� 2�씠�긽�씠硫� �넻怨� -> �떎�쓬 �옣硫댁쑝濡� �꽆�뼱媛�湲�?
				System.out.println(input.getText());
				if (!fone) {
					cnt++;
					fone = true;
				}

				System.out.println(cnt);
			}
			if (answers[1][1].equals(inputArr[1])) {
				System.out.println(cnt);
				if (!ftwo) {
					cnt++;
					ftwo = true;
				}
			}
			if (answers[1][2].equals(inputArr[2])) {
				System.out.println(cnt);
				if (!fthree) {
					cnt++;
					fthree = true;
				}
			}
			System.out.println(cnt);

			// ssingNext_lose();
			break;

		case 3:
			if (answers[2][0].equals(inputArr[0])) {
				// 媛� �븳媛쒖뵫 鍮꾧탳 �썑 �젙�떟�씠硫� cnt++ -> cnt媛� 2�씠�긽�씠硫� �넻怨� -> �떎�쓬 �옣硫댁쑝濡� �꽆�뼱媛�湲�?
				System.out.println(input.getText());
				if (!fone) {
					cnt++;
					fone = true;
				}

				System.out.println(cnt);
			}
			if (answers[2][1].equals(inputArr[1])) {
				System.out.println(cnt);
				if (!ftwo) {
					cnt++;
					ftwo = true;
				}
			}
			if (answers[2][2].equals(inputArr[2])) {
				System.out.println(cnt);
				if (!fthree) {
					cnt++;
					fthree = true;
				}
			}
			System.out.println(cnt);

			// ssingNext_lose();
			break;

		case 4:
			if (answers[3][0].equals(inputArr[0])) {
				// 媛� �븳媛쒖뵫 鍮꾧탳 �썑 �젙�떟�씠硫� cnt++ -> cnt媛� 2�씠�긽�씠硫� �넻怨� -> �떎�쓬 �옣硫댁쑝濡� �꽆�뼱媛�湲�?
				System.out.println(input.getText());
				if (!fone) {
					cnt++;
					fone = true;
				}

				System.out.println(cnt);
			}
			if (answers[3][1].equals(inputArr[1])) {
				System.out.println(cnt);
				if (!ftwo) {
					cnt++;
					ftwo = true;
				}
			}
			if (answers[3][2].equals(inputArr[2])) {
				System.out.println(cnt);
				if (!fthree) {
					cnt++;
					fthree = true;
				}
			}
			System.out.println(cnt);

			// ssingNext_lose();
			break;

		case 5:
			if (answers[4][0].equals(inputArr[0])) {
				// 媛� �븳媛쒖뵫 鍮꾧탳 �썑 �젙�떟�씠硫� cnt++ -> cnt媛� 2�씠�긽�씠硫� �넻怨� -> �떎�쓬 �옣硫댁쑝濡� �꽆�뼱媛�湲�?
				System.out.println(input.getText());
				if (!fone) {
					cnt++;
					fone = true;
				}

				System.out.println(cnt);
			}
			if (answers[4][1].equals(inputArr[1])) {
				System.out.println(cnt);
				if (!ftwo) {
					cnt++;
					ftwo = true;
				}
			}
			if (answers[4][2].equals(inputArr[2])) {
				System.out.println(cnt);
				if (!fthree) {
					cnt++;
					fthree = true;
				}
			}
			System.out.println(cnt);

			// ssingNext_lose();
			break;

		case 6:
			if (answers[5][0].equals(inputArr[0])) {
				// 媛� �븳媛쒖뵫 鍮꾧탳 �썑 �젙�떟�씠硫� cnt++ -> cnt媛� 2�씠�긽�씠硫� �넻怨� -> �떎�쓬 �옣硫댁쑝濡� �꽆�뼱媛�湲�?
				System.out.println(input.getText());
				if (!fone) {
					cnt++;
					fone = true;
				}

				System.out.println(cnt);
			}
			if (answers[5][1].equals(inputArr[1])) {
				System.out.println(cnt);
				if (!ftwo) {
					cnt++;
					ftwo = true;
				}
			}
			if (answers[5][2].equals(inputArr[2])) {
				System.out.println(cnt);
				if (!fthree) {
					cnt++;
					fthree = true;
				}
			}
			System.out.println(cnt);

			// ssingNext_lose();
			break;

		case 7:
			if (answers[6][0].equals(inputArr[0])) {
				// 媛� �븳媛쒖뵫 鍮꾧탳 �썑 �젙�떟�씠硫� cnt++ -> cnt媛� 2�씠�긽�씠硫� �넻怨� -> �떎�쓬 �옣硫댁쑝濡� �꽆�뼱媛�湲�?
				System.out.println(input.getText());
				if (!fone) {
					cnt++;
					fone = true;
				}

				System.out.println(cnt);
			}
			if (answers[6][1].equals(inputArr[1])) {
				System.out.println(cnt);
				if (!ftwo) {
					cnt++;
					ftwo = true;
				}
			}
			if (answers[6][2].equals(inputArr[2])) {
				System.out.println(cnt);
				if (!fthree) {
					cnt++;
					fthree = true;
				}
			}
			System.out.println(cnt);

			// ssingNext_lose();
			break;

		case 8:
			if (answers[7][0].equals(inputArr[0])) {
				// 媛� �븳媛쒖뵫 鍮꾧탳 �썑 �젙�떟�씠硫� cnt++ -> cnt媛� 2�씠�긽�씠硫� �넻怨� -> �떎�쓬 �옣硫댁쑝濡� �꽆�뼱媛�湲�?
				System.out.println(input.getText());
				if (!fone) {
					cnt++;
					fone = true;
				}

				System.out.println(cnt);
			}
			if (answers[7][1].equals(inputArr[1])) {
				System.out.println(cnt);
				if (!ftwo) {
					cnt++;
					ftwo = true;
				}
			}
			if (answers[7][2].equals(inputArr[2])){
				System.out.println(cnt);
				if (!fthree) {
					cnt++;
					fthree = true;
				}
			}
			System.out.println(cnt);

			// ssingNext_lose();
			break;

		case 9:
			if(answers[8][0].equals(inputArr[0])) {
				// 媛� �븳媛쒖뵫 鍮꾧탳 �썑 �젙�떟�씠硫� cnt++ -> cnt媛� 2�씠�긽�씠硫� �넻怨� -> �떎�쓬 �옣硫댁쑝濡� �꽆�뼱媛�湲�?
				System.out.println(input.getText());
				if (!fone) {
					cnt++;
					fone = true;
				}

				System.out.println(cnt);
			}
			if (answers[8][1].equals(inputArr[1])) {
				System.out.println(cnt);
				if (!ftwo) {
					cnt++;
					ftwo = true;
				}
			}
			if (answers[8][2].equals(inputArr[2])) {
				System.out.println(cnt);
				if (!fthree) {
					cnt++;
					fthree = true;
				}
			}
			System.out.println(cnt);

			// ssingNext_lose();
			break;

		case 10:
			if (answers[9][0].equals(inputArr[0])) {
				// 媛� �븳媛쒖뵫 鍮꾧탳 �썑 �젙�떟�씠硫� cnt++ -> cnt媛� 2�씠�긽�씠硫� �넻怨� -> �떎�쓬 �옣硫댁쑝濡� �꽆�뼱媛�湲�?
				System.out.println(input.getText());
				if (!fone) {
					cnt++;
					fone = true;
				}

				System.out.println(cnt);
			}
			if (answers[9][1].equals(inputArr[1])) {
				System.out.println(cnt);
				if (!ftwo) {
					cnt++;
					ftwo = true;
				}
			}
			if (answers[9][2].equals(inputArr[2])) {
				System.out.println(cnt);
				if (!fthree) {
					cnt++;
					fthree = true;
				}
			}
			System.out.println(cnt);

			// ssingNext_lose();
			break;
		}
		
		ifTest();
	}

	
	public void ifTest() {
		if (cnt >= 2) {
			// �젏�닔 �쉷�뱷 +1
			System.out.println("�넻怨�");
			System.out.println("cnt_pass : " + cnt);

			ssingNext();
			//cancel();

		} //else if(Thread.interrupted()){
			//System.out.println("�떎�뙣!");
		else if (cnt < 2 ) {
				ssingNext_lose();
				System.out.println("cnt" + cnt);

					// �젏�닔 �쉷�뱷 �뾾�쓬
					
					cancel2();
					// cp.mouseClicked(e);
				
					System.out.println("�떎�뙣!");
			}
			
		//}*/
	}
	/*
	 * class clickPanel extends MouseAdapter {
	 * 
	 * @Override public void mouseClicked(MouseEvent e) { SsingNext gp = new
	 * SsingNext(mf); Timer timer = new Timer(mf,gp); Thread t1 = timer;
	 * t1.interrupt();
	 * 
	 * 
	 * 
	 * ChangePanel.replacePanel(mf, panel, gp);
	 * 
	 * }
	 * 
	 * }
	 */

}
