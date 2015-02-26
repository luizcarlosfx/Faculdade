package com.faculdade.pesquisa_ordenacao.lab7;

import java.util.ArrayList;
import java.util.List;

public class BuscaLargura {

	// Busca em profundidade a partir de um v�rtice origem
	// v�rtices est�o n�merados de 0 at� n-1
	// REPRESENTA��O DO GRAFO (A - B) (A - C) (B - D) (B - E) (D-E)
	// A ---------B
	// ! ! .
	// ! ! .
	// C----------D ----E
	public static void main(String args[]) {
		int G[][] = { { 0, 1, 1, 0, 0 }, { 1, 0, 0, 1, 0 }, { 1, 0, 0, 1, 0 }, { 0, 1, 1, 0, 1 }, { 0, 0, 0, 1, 0 } };// grafo
																														// representado
																														// por
																														// matriz
																														// de
																														// adjac�ncia

		int n = 5; // n�mero de v�rtices neste grafo

		Info v1, v2, v3, v4, v5;

		v1 = new Info("A");
		v2 = new Info("B");
		v3 = new Info("C");
		v4 = new Info("D");
		v5 = new Info("E");
		List<Info> vertices = new ArrayList<Info>();
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		vertices.add(v4);
		vertices.add(v5);

		Grafo grafo = new Grafo(n, G, vertices);

		grafo.busca();

	}

}