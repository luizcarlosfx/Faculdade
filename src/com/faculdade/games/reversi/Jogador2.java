package com.faculdade.games.reversi;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class Jogador2
{
	private String nome;

	private Color cor;
	
	private Border borda;

	private boolean humano;

	private JogoReversi2 jogo;

	public JogoReversi2 getJogo()
	{
		return jogo;
	}

	public void setJogo(JogoReversi2 jogo)
	{
		this.jogo = jogo;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public Color getCor()
	{
		return cor;
	}

	public void setCor(Color cor)
	{
		this.cor = cor;
	}

	public boolean isHumano()
	{
		return humano;
	}

	public Border getBorda()
	{
		return borda;
	}

	public Jogador2(String name, boolean human, Color color, Border borda)
	{
		super();
		this.nome = name;
		this.cor = color;
		this.humano = human;
		this.borda = borda;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador2 other = (Jogador2) obj;
		if (nome == null)
		{
			if (other.nome != null)
				return false;
		}
		else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return nome;
	}

	public List<Celula2> minhasCelulas(Celula2[][] board)
	{
		List<Celula2> toReturn = new ArrayList<Celula2>();

		for (Celula2[] cellRow : board)
		{
			for (Celula2 cell : cellRow)
			{
				// se essa celula é minha
				if (cell.isDono(this))
				{
					toReturn.add(cell);
				}
			}
		}

		return toReturn;
	}

	public int obterPontucao(Celula2[][] board)
	{
		return minhasCelulas(board).size();
	}

	private Celula2[][] clonarTabuleiro(Celula2[][] tabuleiro)
	{
		Celula2[][] clone = new Celula2[8][8];

		for (int i = 0; i < clone.length; i++)
		{
			for (int j = 0; j < clone[i].length; j++)
			{
				clone[i][j] = tabuleiro[i][j].clone();
			}
		}

		return clone;
	}

	public void fazerMelhorJogada(Celula2[][] tabuleiro, boolean simularProximaJogada)
	{
		List<Movimento2> movimentos = possiveisMovimentos(tabuleiro);

		List<Jogada2> jogadas = Jogada2.obterJogadasAPartirDeMovimentos(tabuleiro, movimentos);

		int melhorPontuacao = 0;

		Jogada2 melhorJogada = null;

		// obtem a melhor jogada simulando também a melhor jogada do adversário
		// na proxima jogada
		for (Jogada2 jogada : jogadas)
		{
			Celula2[][] tabuleiroClone = clonarTabuleiro(tabuleiro);

			jogada.concretizar(tabuleiroClone);

			Jogador2 adversario = jogo.adversario(this);

			if (simularProximaJogada)
			{
				adversario.fazerMelhorJogada(tabuleiroClone, false);
			}

			int pontuacao = obterPontucao(tabuleiroClone)
					- adversario.obterPontucao(tabuleiroClone);

			if (melhorJogada == null || pontuacao > melhorPontuacao)
			{
				melhorJogada = jogada;
				melhorPontuacao = pontuacao;
			}
		}

		if (melhorJogada != null)
		{
			if (simularProximaJogada)
			{
				melhorJogada.destacar(true);
				sleep(1000);
			}

			melhorJogada.concretizar(tabuleiro);
		}
	}

	public boolean fazerJogada(Celula2[][] tabuleiro, Celula2 destino)
	{
		Jogada2 jogada = obterJogada(tabuleiro, destino);

		if (jogada != null)
		{
			jogada.concretizar(tabuleiro);
			return true;
		}

		return false;
	}

	public Jogada2 obterJogada(Celula2[][] tabuleiro, Celula2 destino)
	{
		List<Movimento2> todosMovimentos = obterMovimentosPossiveis(tabuleiro, destino);

		if (!todosMovimentos.isEmpty())
		{
			Jogada2 jogada = new Jogada2(destino, todosMovimentos.get(0));

			for (int i = 1; i < todosMovimentos.size(); i++)
			{
				jogada.adicionarMovimento(todosMovimentos.get(i));
			}

			return jogada;
		}

		return null;
	}

	private List<Movimento2> obterMovimentosPossiveis(Celula2[][] tabuleiro, Celula2 destino)
	{
		List<Movimento2> movimentos = possiveisMovimentos(tabuleiro);

		return movimentos.stream().filter(m -> m.getDestino().equals(destino))
				.collect(Collectors.toList());
	}

	public List<Movimento2> possiveisMovimentos(Celula2[][] tabuleiro)
	{
		List<Movimento2> movimentos = new ArrayList<Movimento2>();

		List<Celula2> minhasCelulas = minhasCelulas(tabuleiro);

		for (Celula2 ceula : minhasCelulas)
		{
			movimentos.addAll(obterMovimentosPorOrigem(tabuleiro, ceula));
		}

		return movimentos;
	}

	private List<Movimento2> obterMovimentosPorOrigem(Celula2[][] tabuleiro, Celula2 destino)
	{
		List<Movimento2> movimentos = new ArrayList<Movimento2>();

		// direita
		adicionarMovimentos(movimentos, tabuleiro, destino, 1, 0);

		// esquerda
		adicionarMovimentos(movimentos, tabuleiro, destino, -1, 0);

		// cima
		adicionarMovimentos(movimentos, tabuleiro, destino, 0, 1);

		// baixo
		adicionarMovimentos(movimentos, tabuleiro, destino, 0, -1);

		// direita/cima
		adicionarMovimentos(movimentos, tabuleiro, destino, 1, 1);

		// direita/baixo
		adicionarMovimentos(movimentos, tabuleiro, destino, 1, -1);

		// esquerda/cima
		adicionarMovimentos(movimentos, tabuleiro, destino, -1, 1);

		// esquerda/baixo
		adicionarMovimentos(movimentos, tabuleiro, destino, -1, -1);

		return movimentos;
	}

	private void adicionarMovimentos(List<Movimento2> movimentos, Celula2[][] tabuleiro,
			Celula2 origem, int dirX, int dirY)
	{
		// começa com um movimento, pois o mínimo que uma peça pode mover é 2
		// vezes
		int linha = origem.getLinha();
		int coluna = origem.getColuna();

		// uma lista com todas as celulas capturadas após o movimento, isso
		// ajudará a determinar o valor do movimento
		List<Celula2> celulasCapturadas = new ArrayList<Celula2>();

		boolean primeiroMovimento = true;

		// enquanto o movimento está dentro de um campo válido
		while ((linha + dirY) <= 7 && (linha + dirY) >= 0 && (coluna + dirX) <= 7
				&& (coluna + dirX) >= 0)
		{
			linha += dirY;
			coluna += dirX;

			Celula2 celulaAtual = tabuleiro[linha][coluna];

			// se na primeira movimentação eu encontrar uma peça que não seja do
			// outro jogador já quer dizer que esse movimento não será válido
			if (primeiroMovimento)
			{
				if (celulaAtual.obterDono() == null || celulaAtual.isDono(this))
				{
					return;
				}
				else
				{
					celulasCapturadas.add(celulaAtual);
				}

				primeiroMovimento = false;

				continue;
			}

			// aqui já é seguro verificar se posso fazer o movimento. E se
			// possível crio um novo movimento
			if (celulaAtual.obterDono() == null)
			{
				celulasCapturadas.add(celulaAtual);

				Movimento2 movimento = new Movimento2(jogo, this, origem, celulaAtual,
						celulasCapturadas);

				movimentos.add(movimento);
				return;
			}
			else if (!celulaAtual.isDono(this))
			{
				// captura todas as células do outro jogador que estiverem no
				// caminho
				celulasCapturadas.add(celulaAtual);
			}
			else
			{
				// se eu encontrar uma célula que já é minha o movimento se
				// torna inválido
				return;
			}
		}
	}

	private void sleep(long millis)
	{
		try
		{
			Thread.sleep(millis);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
