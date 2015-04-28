package com.faculdade.games.m2.tank;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Input
{
	public enum Button
	{
		Up, Left, Down, Right, Shoot;
	}

	public static boolean Up;
	public static boolean Left;
	public static boolean Down;
	public static boolean Right;
	public static boolean Shoot;
	public static boolean Shoot2;

	public Input(JFrame window)
	{
		window.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyReleased(KeyEvent e)
			{
				int keyCode = e.getKeyCode();

				buttonPressedReleased(keyCode, false);
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
				int keyCode = e.getKeyCode();

				buttonPressedReleased(keyCode, true);
			}

			public void buttonPressedReleased(int keyCode, boolean pressed)
			{
				if (keyCode == KeyEvent.VK_UP)
				{
					Up = pressed;
				}
				else if (keyCode == KeyEvent.VK_DOWN)
				{
					Down = pressed;
				}
				else if (keyCode == KeyEvent.VK_LEFT)
				{
					Left = pressed;
				}
				else if (keyCode == KeyEvent.VK_RIGHT)
				{
					Right = pressed;
				}
				else if (keyCode == KeyEvent.VK_SPACE)
				{
					Shoot = pressed;
				}
				else if(keyCode == KeyEvent.VK_CONTROL)
				{
					Shoot2 = pressed;
				}
			}
		});
	}
}
