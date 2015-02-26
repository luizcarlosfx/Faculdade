package com.faculdade.games.m1;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

@SuppressWarnings("serial")
public class Main extends JFrame
{
	private JFrame image1 = new Janela(new Image1Panel());
	private JFrame image2 = new Janela(new Image2Panel());
	private JFrame image3 = new Janela(new Image3Panel());
	private JFrame image4 = new Janela(new Image4Panel());
	private JFrame image5 = new Janela(new Image5Panel());
	private JFrame image6 = new Janela(new Image6Panel());

	public Main()
	{
		setSize(300, 125);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setLocation(screenSize.width / 2 - 150, screenSize.height / 2 - 63);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		setLayout(new GridLayout(3, 2));

		JButton ex1 = new JButton("Exercício 1");

		ex1.addActionListener((action) -> {
			image1.setVisible(true);
		});

		add(ex1);

		JButton ex2 = new JButton("Exercício 2");

		ex2.addActionListener((action) -> {
			image2.setVisible(true);
		});

		add(ex2);

		JButton ex3 = new JButton("Exercício 3");

		ex3.addActionListener((action) -> {
			image3.setVisible(true);
		});

		add(ex3);

		JButton ex4 = new JButton("Exercício 4");

		ex4.addActionListener((action) -> {
			image4.setVisible(true);
		});

		add(ex4);

		JButton ex5 = new JButton("Exercício 5");

		ex5.addActionListener((action) -> {
			image5.setVisible(true);
		});

		add(ex5);

		JButton ex6 = new JButton("Exercício 6");

		ex6.addActionListener((action) -> {
			image6.setVisible(true);
		});

		add(ex6);

	}

	public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		UIManager.setLookAndFeel(new NimbusLookAndFeel());

		new Main();
	}
}
