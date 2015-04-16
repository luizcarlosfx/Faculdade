package com.faculdade.games.m2.tank.base;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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

	public static List<Consumer<Button>> buttonDownListender = new ArrayList<Consumer<Button>>();

	public static void addButtonDownListener(Consumer<Button> onButtonDown)
	{
		buttonDownListender.add(onButtonDown);
	}

	private static void buttonDown(Button button)
	{
		buttonDownListender.forEach(c -> c.accept(button));
	}

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
					if (!Up)
						buttonDown(Button.Up);
					Up = pressed;
				}
				else if (keyCode == KeyEvent.VK_DOWN)
				{
					if (!Down)
						buttonDown(Button.Down);
					Down = pressed;
				}
				else if (keyCode == KeyEvent.VK_LEFT)
				{
					if (!Left)
						buttonDown(Button.Left);
					Left = pressed;
				}
				else if (keyCode == KeyEvent.VK_RIGHT)
				{
					if (!Right)
						buttonDown(Button.Right);
					Right = pressed;
				}
				else if (keyCode == KeyEvent.VK_SPACE)
				{
					if (!Shoot)
						buttonDown(Button.Shoot);
					Shoot = pressed;
				}
			}
		});
	}
}
