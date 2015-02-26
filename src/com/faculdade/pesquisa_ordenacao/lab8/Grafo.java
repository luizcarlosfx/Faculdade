package com.faculdade.pesquisa_ordenacao.lab8;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

	int num_vertices;
	int[][] MatAdj;
	List<Info> vertices;
	boolean[] visitado;
	private int soma;

	public Grafo(int n, int G[][], List<Info> ver) {
		// inicilizações
		MatAdj = new int[n][n];
		visitado = new boolean[n];

		vertices = new ArrayList<Info>();
		num_vertices = n;

		// Armazenamento dos vertices
		vertices = ver;

		// for (int i=0;i<n ;i++ )
		// for (int j=0;j<n;j++ )
		// MatAdj[i][j]=G[i][j];

		// OU

		// Armazenamento da matriz de adjacencia
		MatAdj = G;

		for (int k = 0; k < n; k++)
			visitado[k] = false;

	}

	public void Busca() {
		for (int v = 0; v < num_vertices; v++)
			if (visitado[v] == false)
				Visita(v);
	}

	public void Visita(int origem) {
		visitado[origem] = true;
		// Imprimir o vertice
		vertices.get(origem).Imprimir();

		for (int i = 0; i < num_vertices; i++)

		{
			if ((MatAdj[origem][i] == 1) && (visitado[i] == false))
				Visita(i); // i aponta p/ o prox vertice a ser visitado
		}

	}

	void melhorCaminho(int origem, int destino) {
		ArrayList<Info> arrayList = new ArrayList<Info>();
		arrayList.add(vertices.get(origem));
		visitado[origem] = true;
		int menor = origem;
		while (menor != destino) {
			menor = menorCaminho(menor);
			arrayList.add(vertices.get(menor));
			visitado[menor] = true;
		}
		imprimirMenorCaminho(arrayList);
	}

	int menorCaminho(int origem) {
		int menor = 0;
		for (int i = 0; i < MatAdj[origem].length; i++) {
			System.out.println(visitado[i]);
			if (MatAdj[origem][i] > 0) {
				if (((MatAdj[origem][menor] == 0) || (visitado[menor])) && !visitado[i]) {
					menor = i;
				} else {
					if ((MatAdj[origem][i] < MatAdj[origem][menor]) && !visitado[i]) {
						menor = i;
					}
				}
			}
		}
		soma += MatAdj[origem][menor];
		return menor;
	}

	void imprimirMenorCaminho(List<Info> infos) {
		System.out.println(infos.toString());
		System.out.println("tempo " + soma);
	}

	public int getSoma() {
		return soma;
	}

	public void setSoma(int soma) {
		this.soma = soma;
	}

}
