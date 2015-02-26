package com.faculdade.games;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JFrame
{
	public Test()
	{
		JPanel test = new TestPanel();
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(test);		
	}
	
	public static void main(String[] args)
	{
		new Test();
	}
}
