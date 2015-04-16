package com.faculdade.games.m2.tank;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.HashSet;
import java.util.Set;

import com.faculdade.games.m2.tank.base.GameObject;

public class SceneController
{
	public static final int FPS = 60;

	public static final int DELTA_TIME = 1000 / FPS;

	private static Set<GameObject> gameObjects = new HashSet<GameObject>();

	public static Rectangle battleField = new Rectangle(494, 471);

	private static int lastId;

	private static void registerGameObject(GameObject gameObject)
	{
		gameObjects.add(gameObject);
	}

	private static synchronized int nextId()
	{
		lastId++;

//		System.out.println(lastId);
		return lastId;
	}

	public static GameObject instantiateNew(Point position, double rotation)
	{
		GameObject obj = new GameObject(nextId(), position, rotation);

		registerGameObject(obj);

		return obj;
	}

	public static GameObject instantiateNew(AffineTransform transform)
	{
		GameObject obj = new GameObject(nextId(), transform);

		registerGameObject(obj);

		return obj;
	}

	public static void destroy(GameObject gameObjct)
	{
		gameObjects.remove(gameObjct);
	}

	public static Set<GameObject> getGameObjects()
	{
		return gameObjects;
	}
}
