package com.faculdade.games.reversi;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

import javax.swing.JOptionPane;

public class JogoReversi2
{
	private Jogador2 player1;
	private Jogador2 player2;
	private Jogador2 atual;

	public Consumer<Resultado2> onGameEnded;

	private Celula2[][] tabuleiro = new Celula2[8][8];

	public Jogador2 getPlayer1()
	{
		return player1;
	}

	public Jogador2 getPlayer2()
	{
		return player2;
	}

	public Jogador2 getAtual()
	{
		return atual;
	}

	public Jogador2 adversario(Jogador2 player)
	{
		return player == player1 ? player2 : player1;
	}

	public Celula2[][] getTabuleiro()
	{
		return tabuleiro;
	}

	public JogoReversi2(Jogador2 player1, Jogador2 player2)
	{
		super();
		this.player1 = player1;
		this.player2 = player2;
		this.atual = player1;

		player1.setJogo(this);
		player2.setJogo(this);

		tabuleiro = new Celula2[8][8];

		for (int i = 0; i < tabuleiro.length; i++)
		{
			for (int j = 0; j < tabuleiro[i].length; j++)
			{
				tabuleiro[i][j] = new Celula2(i, j);
				tabuleiro[i][j].addActionListener(this::cellClicked);
				tabuleiro[i][j].addMouseListener(new BoardCellMouseEvents(this));
			}
		}

		tabuleiro[3][3].setarDono(player1);
		tabuleiro[4][4].setarDono(player1);
		tabuleiro[3][4].setarDono(player2);
		tabuleiro[4][3].setarDono(player2);
	}

	void cellClicked(ActionEvent event)
	{
		Celula2 destino = (Celula2) event.getSource();

		if (atual.isHumano())
		{
			if (atual.fazerJogada(tabuleiro, destino))
			{
				proxima();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Jogada inválida");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Espere pela sua vez");
		}
	}

	private boolean temJogada(Jogador2 jogador)
	{
		return !jogador.possiveisMovimentos(tabuleiro).isEmpty();
	}

	private void finalizarJogo()
	{
		int p1 = player1.obterPontucao(tabuleiro);
		int p2 = player2.obterPontucao(tabuleiro);

		Jogador2 vencedor = null;
		
		if (p1 > p2)
		{
			vencedor = player1;
		}
		else if (p1 < p2)
		{
			vencedor = player2;
		}
		
		onGameEnded.accept(new Resultado2(vencedor, p1, p2));
	}

	public void proxima()
	{
		atual = atual == player2 ? player1 : player2;

		if (!temJogada(atual))
		{
			JOptionPane.showMessageDialog(null, atual.getNome() + " não tem mais jogadas");

			finalizarJogo();
		}

		if (!atual.isHumano())
		{
			new Thread(() -> {
				try
				{
					Thread.sleep(500);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				atual.fazerMelhorJogada(tabuleiro, true);

				proxima();
			}).start();
		}
	}
}

class BoardCellMouseEvents extends MouseAdapter
{
	private JogoReversi2 jogo;

	private Jogada2 jogadaDestacada;

	// private List<Celula> hightLightedCells = new ArrayList<Celula>();

	public BoardCellMouseEvents(JogoReversi2 jogo)
	{
		super();
		this.jogo = jogo;
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		Celula2 destino = (Celula2) e.getSource();

		Jogador2 atual = jogo.getAtual();

		if (atual.isHumano())
		{
			Jogada2 jogada = atual.obterJogada(jogo.getTabuleiro(), destino);

			if (jogada != null)
			{
				jogadaDestacada = jogada;
				jogada.destacar(true);
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		if (jogadaDestacada != null)
		{
			jogadaDestacada.destacar(false);
			jogadaDestacada = null;
		}
	}

	@Override
	public void mouseClicked(MouseEvent event)
	{
		mouseExited(event);
	}
}
