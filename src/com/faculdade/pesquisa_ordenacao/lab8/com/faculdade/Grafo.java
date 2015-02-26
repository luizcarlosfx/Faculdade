package com.faculdade.pesquisa_ordenacao.lab8.com.faculdade;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

	int num_vertices;
	int[][] MatAdj;
	List<Info> vertices;
	boolean[] visitado;

	public Grafo(int n, int G[][], List<Info> vertices2) {
		// inicilizações
		MatAdj = new int[n][n];
		visitado = new boolean[n];

		vertices = new ArrayList<Info>();
		num_vertices = n;

		// Armazenamento dos vertices
		vertices = vertices2;

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
		System.out.println(vertices.get(origem));

		for (int i = 0; i < num_vertices; i++)

		{
			if ((MatAdj[origem][i] == 1) && (visitado[i] == false))
				Visita(i); // i aponta p/ o prox vertice a ser visitado
		}

	}

	void melhorCaminho(int origem, int destino) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		ArrayList<Info> info = new ArrayList<Info>();
		info.add(vertices.get(origem));
		visitado[origem] = true;
		int menor = origem;
		while (origem != destino) {
			menor = menorCaminho(origem);

			arrayList.add(MatAdj[origem][menor]);

			info.add(vertices.get(menor));
			visitado[menor] = true;
			origem = menor;
		}
		imprimirMenorCaminho(arrayList, info);
	}

	int menorCaminho(int origem) {
		int menor = 0;
		for (int i = 0; i < MatAdj[origem].length; i++) {
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
		return menor;
	}

	void imprimirMenorCaminho(List<Integer> infos, ArrayList<Info> info) {
		int total = 0;
		for (Integer integer : infos) {
			total += integer;
		}
		System.out.println(info.toString() + "\nTempo: " + total);
	}

}
