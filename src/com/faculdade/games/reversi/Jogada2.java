package com.faculdade.games.reversi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 * 
 * @author LuizCarlos Uma jogada é caracterizada por todos os movimenots que um
 *         jogador pode fazer e que resultam na mesma celula destino
 */
public class Jogada2
{
	private Jogador2 jogador;

	private Celula2 destino;

	private List<Movimento2> movimentos = new ArrayList<Movimento2>();

	public Jogada2(Celula2 destino, Movimento2 movimento)
	{
		this.destino = destino;
		this.movimentos.add(movimento);
		this.jogador = movimento.getJogador();
	}

	public void adicionarMovimento(Movimento2 movimento)
	{
		movimentos.add(movimento);
	}

	public void destacar(boolean destacar)
	{
		Border borda = destacar ? jogador.getBorda() : null;

		for (Movimento2 movimento : movimentos)
		{
			movimento.getOrigem().destacar(borda);
			for (Celula2 celula : movimento.getCelulasCapturadas())
			{
				celula.destacar(borda);
			}
		}
	}

	public void concretizar(Celula2[][] tabuleiro)
	{
		// JOptionPane.showMessageDialog(null, this);
		for (Movimento2 movimento : movimentos)
		{
			movimento.concretizar(tabuleiro);
		}
	}

	/**
	 * 
	 * @param tabuleiro
	 * @param movimentos
	 *            todos os movimentos que um jogador pode fazer
	 * @return retorna uma lista de jogadas que agrupa todos os movimentos que
	 *         tem como destino a mesma celula
	 */
	public static List<Jogada2> obterJogadasAPartirDeMovimentos(Celula2[][] tabuleiro,
			List<Movimento2> movimentos)
	{
		Map<Celula2, Jogada2> moveMap = new HashMap<Celula2, Jogada2>();

		for (Movimento2 movimento : movimentos)
		{
			Celula2 destino = movimento.getDestino();

			// se a jogada não existe eu a crio e já adiciono o primeiro
			// movimento em seu construtor
			if (!moveMap.containsKey(movimento.getDestino()))
			{
				moveMap.put(destino, new Jogada2(destino, movimento));
			}
			else
			{
				// caso contrário eu apenas adiciono o movimento a jogada
				// existente
				moveMap.get(destino).adicionarMovimento(movimento);
			}
		}

		return moveMap.values().stream().collect(Collectors.toList());
	}

	@Override
	public String toString()
	{
		return movimentos.toString();
	}
}
