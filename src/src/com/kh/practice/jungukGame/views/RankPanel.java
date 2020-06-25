package com.kh.practice.jungukGame.views;

import java.awt.Color;
import java.util.*;
import javax.swing.*;

public class RankPanel extends JPanel{
	private JFrame mf;
	private ArrayList list;
	
	
	public RankPanel(JFrame mf, ArrayList list) {
		this.mf = mf;
		this.list = list;
		this.setBackground(Color.white);
		this.setBounds(0, 0, 1400 ,900);
		
//		printRank(list);
//		
//		mf.add(this);
//		
//		public void printRank(ArrayList list) {
//			JTextArea ta = new JTextArea();
//
//		for(int i = 0; i < list.size(); i++) {
//			score s = (Score)list.get(i);
//			ta.append((i+1) + "À§" + s.getPoint() + "Á¡  " + s.getUserId() + "\n");
//		
//		
//		
//		}
//			
//		}
		
//		ta.setFont(new Font("Sanscerif", Font.BOLD, 50));
//		this.add(ta);
	}
}
