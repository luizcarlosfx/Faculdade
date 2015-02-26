package com.faculdade.pesquisa_ordenacao.lab8.com.faculdade;

import java.util.ArrayList;
import java.util.List;

import com.faculdade.pesquisa_ordenacao.lab8.com.faculdade.Grafo;
import com.faculdade.pesquisa_ordenacao.lab8.com.faculdade.Info;

public class Buscaoo {

	// Busca em profundidade a partir de um vértice origem
	// vértices estão númerados de 0 até n-1
	// REPRESENTAÇÃO DO GRAFO (A - B) (A - C) (B - D) (B - E) (D-E)
	// A ---------B
	// ! ! .
	// ! ! .
	// C----------D ----E
	public static void main(String args[]) {
		int G[][] = { { 0 , 10, 5, 0, 0, 0 }, 
				      { 10, 0 , 4, 1, 4, 0 },
					  { 5 , 4 , 0, 0, 6, 0 }, 
					  { 0 , 1 , 0, 0, 2, 3 },
				      { 0 , 6 , 4, 2, 0, 1 }, 
				      { 0 , 0 , 0, 3, 1, 0 } };// grafo
																// representado
																// por
		// matriz de adjacência

		int n = 6; // número de vértices neste grafo

		Info v1, v2, v3, v4, v5, v6;

		v1 = new Info("1");
		v2 = new Info("2");
		v3 = new Info("3");
		v4 = new Info("4");
		v5 = new Info("5");
		v6 = new Info("6");
		List<Info> vertices = new ArrayList<Info>();
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		vertices.add(v4);
		vertices.add(v5);
		vertices.add(v6);
		Grafo grafo = new Grafo(n, G, vertices);

		grafo.melhorCaminho(0, 5);

	}
}