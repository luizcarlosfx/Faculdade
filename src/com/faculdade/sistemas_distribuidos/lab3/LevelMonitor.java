package com.faculdade.sistemas_distribuidos.lab3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class LevelMonitor extends Thread
{
	private Level level;

	private String fileLocation;

	private long interval = 30000;

	public LevelMonitor(String fileLocation, Level level)
	{
		this.fileLocation = fileLocation;
		this.level = level;
	}

	public Level getLevel()
	{
		return level;
	}

	public String getFileLocation()
	{
		return fileLocation;
	}

	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				writeToTextFile();
				Thread.sleep(interval);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	private void writeToTextFile()
	{
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

		String date = formater.format(new Date());

		String text1 = String.format("%s-%s", date, level.getLevel1());
		String path1 = String.format("%s/Level%s.txt", fileLocation, 1);

		String text2 = String.format("%s-%s", date, level.getLevel1());
		String path2 = String.format("%s/Level%s.txt", fileLocation, 2);

		String text3 = String.format("%s-%s", date, level.getLevel1());
		String path3 = String.format("%s/Level%s.txt", fileLocation, 3);

		writeToText(path1, text1);
		writeToText(path2, text2);
		writeToText(path3, text3);
	}

	private void writeToText(String path, String text)
	{
		try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(path, true))))
		{
			writer.println(text);
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
