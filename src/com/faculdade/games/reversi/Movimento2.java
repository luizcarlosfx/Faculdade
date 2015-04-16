package com.faculdade.games.reversi;

import java.util.List;

public class Movimento2
{
	private JogoReversi2 jogo;

	// celuladas capturadas após a concretização do movimento
	private List<Celula2> celulasCapturadas;

	// jogador responsável pelo movimento
	private Jogador2 jogador;

	// de qual celula saiu o movimento
	private Celula2 origem;

	// qual é a celula destino, a que o jogador clicou
	private Celula2 destino;

	public JogoReversi2 getJogo()
	{
		return jogo;
	}

	public Celula2 getOrigem()
	{
		return origem;
	}

	public List<Celula2> getCelulasCapturadas()
	{
		return celulasCapturadas;
	}

	public Jogador2 getJogador()
	{
		return jogador;
	}

	public Celula2 getDestino()
	{
		return destino;
	}

	public Movimento2(JogoReversi2 jogo, Jogador2 jogador, Celula2 origem, Celula2 destino,
			List<Celula2> celulasCapturadas)
	{
		super();
		this.jogo = jogo;
		this.jogador = jogador;
		this.origem = origem;
		this.celulasCapturadas = celulasCapturadas;
		this.destino = destino;
	}

	public void concretizar(Celula2[][] board)
	{
		origem.destacar(null);

		for (Celula2 cell : celulasCapturadas)
		{
			board[cell.getLinha()][cell.getColuna()].destacar(null);
			board[cell.getLinha()][cell.getColuna()].setarDono(jogador);
		}
	}

	@Override
	public String toString()
	{
		return String.format("Movimento(%s, %s)", origem, destino);
	}
}
