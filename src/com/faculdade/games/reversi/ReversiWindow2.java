package com.faculdade.games.reversi;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ReversiWindow2 extends JFrame
{
	private Container container;

	public ReversiWindow2(JogoReversi2 jogo)
	{
		jogo.onGameEnded = this::jogoFinalizado;

		container = getContentPane();

		GridLayout layout = new GridLayout(8, 8, 1, 1);

		container.setLayout(layout);

		Celula2[][] board = jogo.getTabuleiro();

		for (Celula2[] cells : board)
		{
			for (Celula2 cell : cells)
			{
				container.add(cell);
			}
		}

		setSize(500, 500);

		setResizable(false);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	void jogoFinalizado(Resultado2 resultado)
	{
		JOptionPane.showMessageDialog(this, String.format("%s Venceu! (%s x %s)",
				resultado.vencedor.getNome(), resultado.pontuacao1, resultado.pontuacao2));

		dispose();
	}
}
