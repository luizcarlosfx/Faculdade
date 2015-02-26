package com.faculdade.pesquisa_ordenacao.lab8.com.faculdade;

import java.util.ArrayList;
import java.util.List;

public class BuscaooPolicia {

	// Busca em profundidade a partir de um vértice origem
	// vértices estão númerados de 0 até n-1
	// REPRESENTAÇÃO DO GRAFO (A - B) (A - C) (B - D) (B - E) (D-E)
	// A ---------B
	// ! ! .
	// ! ! .
	// C----------D ----E
	public static void main(String args[]) {
		int G[][] = {
				{0,	8,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	10,	0,	0},
				{0,	0,	10,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	7,	0},
				{0,	0,	0,	12,	9,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0},
				{0,	0,	0,	0,	0,	0,	0,	14,	0,	0,	0,	0,	0,	0,	0},
				{0,	0,	0,	0,	0,	4,	3,	0,	0,	0,	0,	0,	0,	0,	0},
				{0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0},
				{0,	0,	0,	0,	0,	5,	0,	0,	0,	0,	0,	0,	0,	0,	0},
				{0,	0,	0,	0,	0,	0,	9,	0,	0,	0,	0,	0,	0,	0,	10},
				{0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	9},
				{0,	0,	0,	0,	0,	0,	0,	0,	4,	0,	0,	0,	0,	0,	0},
				{0,	0,	0,	0,	0,	0,	0,	0,	16,	11,	0,	0,	0,	0,	0},
				{0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	8,	0,	0,	0,	0},
				{0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	13,	0,	0,	0},
				{0,	0,	0,	0,	0,	8,	0,	0,	0,	0,	0,	0,	6,	0,	0},
				{0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0}
				};// grafo
																// representado
																// por
		// matriz de adjacência

		int n = 15; // número de vértices neste grafo
		
		List<Info> vertices = new ArrayList<Info>();
		vertices.add(new Info("1"));
		vertices.add(new Info("2"));
		vertices.add(new Info("3"));
		vertices.add(new Info("4"));
		vertices.add(new Info("5"));
		vertices.add(new Info("6"));
		vertices.add(new Info("7"));
		vertices.add(new Info("8"));
		vertices.add(new Info("9"));
		vertices.add(new Info("10"));
		vertices.add(new Info("11"));
		vertices.add(new Info("12"));
		vertices.add(new Info("13"));
		vertices.add(new Info("14"));
		vertices.add(new Info("15"));

		
		Grafo grafo = new Grafo(n, G, vertices);

		grafo.melhorCaminho(0, 14);

	}
}