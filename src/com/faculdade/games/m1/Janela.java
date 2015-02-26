package com.faculdade.games.m1;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Janela extends JFrame
{
	public Janela(JPanel panel)
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenSize.height -= 40;

		setSize(screenSize);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		add(panel);

		setVisible(false);
	}

	@Override
	public void setVisible(final boolean visible)
	{
		super.setVisible(visible);
		
		if(visible == true)
		{
			setState(JFrame.NORMAL);
			requestFocus();
		}
	}
}
