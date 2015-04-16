package com.faculdade.games.m2.tank;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Set;

import javax.swing.JPanel;

import com.faculdade.games.m2.tank.base.GameObject;

public class BattleFieldPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	public GameObject tankObj;

	public BattleFieldPanel()
	{
		setSize(200, 200);

		Tank tank = new Tank();
		
		TankPlayer player = new TankPlayer(tank);

		tankObj = SceneController.instantiateNew(new Point(100, 100), 45);

		tankObj.addComponent(tank);
		
		tankObj.addComponent(player);
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D graphics = (Graphics2D) g;

		Set<GameObject> objs = SceneController.getGameObjects();
		
//		System.out.println(objs.size());

		for (GameObject gameObject : objs)
		{
			gameObject.paint(graphics);
		}

		repaint();
	}
}
