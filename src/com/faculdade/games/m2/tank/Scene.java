package com.faculdade.games.m2.tank;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Scene
{
	public static final int FPS = 60;

	public static final int DELTA_TIME = 1000 / FPS;

	private static List<GameObject> gameObjects = new ArrayList<GameObject>();

	public static Rectangle battleFieldBounds = new Rectangle(694, 671);
	
	private static int lastId;

	public static void registerObject(GameObject gameObject)
	{
		gameObject.setInstanceId(nextId());
		gameObjects.add(gameObject);
		gameObject.start();
	}

	private static synchronized int nextId()
	{
		lastId++;

		return lastId;
	}

	public static void destroy(GameObject gameObjct)
	{
		gameObjects.remove(gameObjct);
		gameObjct.onDestroy();
	}

	public static List<GameObject> getGameObjects()
	{
		return gameObjects;
	}
}
