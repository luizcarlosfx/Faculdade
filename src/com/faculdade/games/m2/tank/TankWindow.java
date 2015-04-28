package com.faculdade.games.m2.tank;

import javax.swing.JFrame;

public class TankWindow extends JFrame
{
	public TankWindow()
	{
		new Input(this);

		BattleFieldPanel panel = new BattleFieldPanel();

		setSize(700, 700);
		setResizable(false);
		add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new TankWindow();
	}
}
