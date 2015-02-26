package com.faculdade.complexidade_algoritmo.lab2;

import java.util.ArrayList;
import java.util.List;

import com.faculdade.pesquisa_ordenacao.grafo.Caminho;
import com.faculdade.pesquisa_ordenacao.grafo.Info;

import javax.swing.JOptionPane;

public class MeuGrafo
{
	private int instructionsOtimizado;
	private int instructions;
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
		instructions = 0;
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
		System.out.println("Não Otimizado: " + instructions + " Instruções");
		return melhorCaminho.toString();
	}

	public String melhorCaminhoOtimizado(int origem, int destino)
	{
		instructionsOtimizado = 0;
		if (origem != destino)
		{
			Caminho caminho = new Caminho(numVertices);
			caminho.addVertice(0, new Info(vertices.get(origem).toString()));
			buscarMelhorCaminhoOtimizado(origem, destino, caminho);
		}
		else
		{
			Caminho caminho = new Caminho(numVertices);
			caminho.addVertice(0, vertices.get(origem));
			melhorCaminho = caminho;
		}
		System.out.println("Otimizado: " + instructionsOtimizado + " Instruções");
		return melhorCaminho.toString();
	}

	private void buscarMelhorCaminhoOtimizado(int linha, int destino, Caminho caminho)
	{
		instructionsOtimizado += 2;

		caminho.getVisitado()[linha] = true;

		if (melhorCaminho != null && caminho.getTempo() >= melhorCaminho.getTempo())
			return;

		for (int j = 0; j < matAdj[linha].length; j++)
		{
			instructionsOtimizado += 3;
			if (matAdj[linha][j] > 0 && j == destino && !caminho.getVisitado()[j])
			{
				caminho.addVertice(matAdj[linha][j], new Info(vertices.get(j).toString()));
				melhorCaminho = caminho;
				return;
			}

			instructionsOtimizado += 5;
			if (matAdj[linha][j] > 0 && !caminho.getVisitado()[j])
			{
				Caminho caminho2 = new Caminho(caminho);
				caminho2.addVertice(matAdj[linha][j], new Info(vertices.get(j).toString()));
				caminho.getVisitado()[j] = true;
				buscarMelhorCaminhoOtimizado(j, destino, caminho2);
			}
		}
	}

	private void buscarMelhorCaminho(int linha, int destino, Caminho caminho)
	{
		instructions += 1;

		caminho.getVisitado()[linha] = true;

		for (int j = 0; j < matAdj[linha].length; j++)
		{
			instructions += 3;
			if (matAdj[linha][j] > 0 && j == destino && !caminho.getVisitado()[j])
			{
				caminho.addVertice(matAdj[linha][j], new Info(vertices.get(j).toString()));
				melhorCaminho = caminho;
				return;
			}

			instructions += 5;
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
		int matAdj[][] =
			{
				{ 0, 7, 0, 5, 0, 0, 0 },
				{ 7, 0, 8, 9, 7, 0, 0 },
				{ 0, 8, 0, 0, 5, 0, 0 },
				{ 5, 9, 0, 0, 15, 6, 0 },
				{ 0, 7, 5, 15, 0, 8, 9 },
				{ 0, 0, 0, 6, 8, 0, 11 },
				{ 0, 0, 0, 0, 9, 11, 0 }, };

		List<Info> vertices = new ArrayList<Info>();
		// adicionando os vertices ao array
		for (char i = 'A'; i <= 'G'; i++)
		{
			vertices.add(new Info("" + i));
		}

		MeuGrafo meuGrafo = new MeuGrafo(matAdj, vertices);
		int from = vertices.indexOf(new Info(JOptionPane.showInputDialog("De:").toUpperCase()));
		int to = vertices.indexOf(new Info(JOptionPane.showInputDialog("Para:").toUpperCase()));

		// Normal
		meuGrafo.melhorCaminho(from, to);
		
		//Otimizado
		meuGrafo.melhorCaminhoOtimizado(from, to);
	}
}
