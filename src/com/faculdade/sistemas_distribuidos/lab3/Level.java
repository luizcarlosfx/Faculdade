package com.faculdade.sistemas_distribuidos.lab3;

public class Level
{
	private double level1;
	private double level2;
	private double level3;
	
	public double getLevel1()
	{
		return level1;
	}
	
	public void setLevel1(double level1)
	{
		this.level1 = level1;
	}
	
	public double getLevel2()
	{
		return level2;
	}
	
	public void setLevel2(double level2)
	{
		this.level2 = level2;
	}
	
	public double getLevel3()
	{
		return level3;
	}
	
	public void setLevel3(double level3)
	{
		this.level3 = level3;
	}
	
	public void setLevels(double level1, double level2, double level3)
	{
		setLevel1(level1);
		setLevel2(level2);
		setLevel3(level3);
	}
}
