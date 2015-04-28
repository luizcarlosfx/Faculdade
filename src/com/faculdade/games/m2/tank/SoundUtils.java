package com.faculdade.games.m2.tank;

import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;

public class SoundUtils
{
	static
	{
		// initialize TinySound
		TinySound.init();
	}

	public static Sound getSound(String path)
	{
		return TinySound.loadSound(ClassLoader.getSystemClassLoader().getResource(path));
	}

	public static void shutDown()
	{
		TinySound.shutdown();
	}
}
