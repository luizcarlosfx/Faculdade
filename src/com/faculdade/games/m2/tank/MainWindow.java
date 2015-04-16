package com.faculdade.games.m2.tank;

import javax.swing.JFrame;

import com.faculdade.games.m2.tank.base.Input;

public class MainWindow extends JFrame
{
	public MainWindow()
	{
		new Input(this);

		BattleFieldPanel panel = new BattleFieldPanel();

		setSize(500, 500);
		setResizable(false);
		add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		
		new MainWindow();
	}
}
