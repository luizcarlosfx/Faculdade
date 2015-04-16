package com.faculdade.games.reversi;

import javax.swing.JButton;
import javax.swing.border.Border;

public class Celula2 extends JButton implements Cloneable
{
	private Jogador2 dono;

	private int linha;

	private int coluna;

	public Jogador2 obterDono()
	{
		return dono;
	}

	public void setarDono(Jogador2 player)
	{
		this.dono = player;

		if (dono != null)
		{
			// System.out.println(dono.getCor());
			setBackground(dono.getCor());
		}
	}

	public int getLinha()
	{
		return linha;
	}

	public int getColuna()
	{
		return coluna;
	}

	public Celula2(int linha, int coluna)
	{
		/*try
		{
			setIcon(new ImageIcon(ImageIO.read(new File("download.jpg"))));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		// setBackground(Color.green);
		this.linha = linha;
		this.coluna = coluna;
		this.setText(this.toString());
	}

	public boolean isDono(Jogador2 player)
	{
		return player.equals(dono);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + coluna;
		result = prime * result + linha;
		return result;
	}

	@Override
	protected Celula2 clone()
	{
		Celula2 cell = new Celula2(linha, coluna);

		cell.setarDono(dono);

		return cell;
	}

	public void destacar(Border border)
	{
		setBorder(border);
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
		Celula2 other = (Celula2) obj;
		if (coluna != other.coluna)
			return false;
		if (linha != other.linha)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return String.format("(%s,%s)", linha, coluna);
	}
}
