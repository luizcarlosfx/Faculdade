package com.faculdade.games.reversi;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MainWindow2 extends JFrame
{
	private final Border bordaPlayer1 = BorderFactory.createLineBorder(new Color(45, 137, 239), 4,
			false);
	private final Border bordaPlayer2 = BorderFactory.createLineBorder(Color.red, 4, false);

	private Color preto = Color.black;

	private Color amarelo = new Color(255, 196, 13);

	private JComboBox<Cor> cores;

	public MainWindow2()
	{
		setLayout(null);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setSize(350, 200);

		JButton singlePlayer = new JButton("Computador");
		
		singlePlayer.addActionListener(this::singlePlayer);

		JButton multiplayer = new JButton("Multiplayer");
		
		multiplayer.addActionListener(this::multiplayer);

		singlePlayer.setBounds(50, 80, 100, 50);

		multiplayer.setBounds(175, 80, 100, 50);

		cores = new JComboBox<MainWindow2.Cor>(Cor.values());

		cores.setBounds(95, 15, 150, 45);

		add(singlePlayer);

		add(multiplayer);

		add(cores);
		setVisible(true);
	}

	void singlePlayer(ActionEvent event)
	{
		Cor cor = (Cor) cores.getSelectedItem();

		Color cor1 = preto;
		Border borda1 = bordaPlayer1;
		Color cor2 = amarelo;
		Border borda2 = bordaPlayer2;
		String nome1 = "Preto";
		String nome2 = "Amarelo";

		if (cor == Cor.Amarelo)
		{
			cor1 = amarelo;
			cor2 = preto;
			borda1 = bordaPlayer2;
			borda2 = bordaPlayer1;
			nome1 = "Amarelo";
			nome2 = "Preto";
		}

		Jogador2 player1 = new Jogador2(nome1, true, cor1, borda1);

		Jogador2 player2 = new Jogador2(nome2, false, cor2, borda2);

		JogoReversi2 jogo = new JogoReversi2(player1, player2);

		new ReversiWindow2(jogo).setVisible(true);
	}

	void multiplayer(ActionEvent event)
	{
		Cor cor = (Cor) cores.getSelectedItem();

		Color cor1 = preto;
		Border borda1 = bordaPlayer1;
		Color cor2 = amarelo;
		Border borda2 = bordaPlayer2;
		String nome1 = "Preto";
		String nome2 = "Amarelo";

		if (cor == Cor.Amarelo)
		{
			cor1 = amarelo;
			cor2 = preto;
			borda1 = bordaPlayer2;
			borda2 = bordaPlayer1;
			nome1 = "Amarelo";
			nome2 = "Preto";
		}

		Jogador2 player1 = new Jogador2(nome1, true, cor1, borda1);

		Jogador2 player2 = new Jogador2(nome2, true, cor2, borda2);

		JogoReversi2 jogo = new JogoReversi2(player1, player2);

		new ReversiWindow2(jogo).setVisible(true);
	}

	enum Cor
	{
		Amarelo, Preto
	};

	public static void main(String[] args) throws UnsupportedLookAndFeelException
	{
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new MainWindow2();
	}
}
