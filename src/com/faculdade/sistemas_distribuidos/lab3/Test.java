package com.faculdade.sistemas_distribuidos.lab3;

public class Test
{
	public static void main(String[] args)
	{
		Level level = new Level();

		level.setLevel1(40);
		level.setLevel2(30);
		level.setLevel3(90);

		new LevelMonitor("c:/users/luizcarlos/desktop/", level).start();
	}
}
