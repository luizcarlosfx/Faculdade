package com.faculdade.pesquisa_ordenacao.lab8.com.faculdade;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class MeuGrafo
{

	private int[][] matAdj;
	private List<Info> vertices;
	private Caminho melhorCaminho;
	private int numVertices;

	public MeuGrafo(int[][] matAdj, List<Info> vertices)
	{
		this.vertices = vertices;
		this.matAdj = matAdj;
		numVertices = matAdj.length;
	}

	public String melhorCaminho(int origem, int destino)
	{
		if (origem != destino)
		{
			Caminho caminho = new Caminho(numVertices);
			caminho.addVertice(0, new Info(vertices.get(origem).toString()));
			buscarMelhorCaminho(origem, destino, caminho);
		}
		else
		{
			Caminho caminho = new Caminho(numVertices);
			caminho.addVertice(0, vertices.get(origem));
			melhorCaminho = caminho;
		}
		return melhorCaminho.toString();
	}

	private void buscarMelhorCaminho(int linha, int destino, Caminho caminho)
	{
		caminho.getVisitado()[linha] = true;
		if (melhorCaminho != null && caminho.getCusto() >= melhorCaminho.getCusto())
			return;

		for (int j = 0; j < matAdj[linha].length; j++)
		{
			if (matAdj[linha][j] > 0 && j == destino && !caminho.getVisitado()[j])
			{
				caminho.addVertice(matAdj[linha][j], new Info(vertices.get(j).toString()));
				melhorCaminho = caminho;
				return;
			}
			if (matAdj[linha][j] > 0 && !caminho.getVisitado()[j])
			{
				Caminho caminho2 = new Caminho(caminho);
				caminho2.addVertice(matAdj[linha][j], new Info(vertices.get(j).toString()));
				caminho.getVisitado()[j] = true;
				buscarMelhorCaminho(j, destino, caminho2);
			}
		}
	}

	public static void main(String[] args)
	{
		String continuar;

		int matAdj[][] = new int[6][6];
		matAdj[0] = new int[]
			{ 0, 2, 5, 1, 0, 0 }; // u
		matAdj[1] = new int[]
			{ matAdj[1][0], 0, 3, 2, 0, 0 }; // v
		matAdj[2] = new int[]
			{ matAdj[2][1], matAdj[2][1], 0, 2, 1, 2 }; // w
		matAdj[3] = new int[]
			{ matAdj[3][0], matAdj[3][1], matAdj[3][2], 0, 1, 0 }; // x
		matAdj[4] = new int[]
			{ matAdj[4][0], matAdj[4][1], matAdj[4][2], matAdj[4][3], 0, 2 }; // y
		matAdj[5] = new int[]
			{ matAdj[5][0], matAdj[5][1], matAdj[5][2], matAdj[5][3],matAdj[5][4], 0 }; // z
		do
		{
			List<Info> vertices = new ArrayList<Info>();
			// adicionando os vertices ao array
			for (char i = 'U'; i <= 'Z'; i++)
			{
				vertices.add(new Info("" + i));
			}

			MeuGrafo meuGrafo = new MeuGrafo(matAdj, vertices);
			int from = vertices.indexOf(new Info(JOptionPane.showInputDialog("De:").toUpperCase()));
			int to = vertices.indexOf(new Info(JOptionPane.showInputDialog("Para:").toUpperCase()));

			String melhor = meuGrafo.melhorCaminho(from, to);

			System.out.println("Melhor Caminho = " + melhor); 

			continuar = JOptionPane.showInputDialog("Deseja Continuar? (S / N)").toUpperCase();
		}
		while (continuar.charAt(0) != 'N');
	}
}
