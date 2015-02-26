package com.faculdade.pesquisa_ordenacao.lab8;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Buscaoo {

	// Busca em profundidade a partir de um vértice origem
	// vértices estão númerados de 0 até n-1
	// REPRESENTAÇÃO DO GRAFO (A - B) (A - C) (B - D) (B - E) (D-E)
	// A ---------B
	// ! ! .
	// ! ! .
	// C----------D ----E
	public static void main(String args[]) {
		int G[][] = { { 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0 }, { 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0 },
				{ 0, 0, 0, 12, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 10 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9 }, { 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 16, 11, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 0, 0, 0 }, { 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 6, 0, 0 },
				{ 0, 0, 0, 00, 0, 0, 0, 0, 0, 0, 0, 0, 00, 0, 0 } };
	

		// matriz de adjacência

		int n = 15; // número de vértices neste grafo

		Info v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15;

		v1 = new Info("1");
		v2 = new Info("2");
		v3 = new Info("3");
		v4 = new Info("4");
		v5 = new Info("5");
		v6 = new Info("6");
		v7 = new Info("7");
		v8 = new Info("8");
		v9 = new Info("9");
		v10 = new Info("10");
		v11 = new Info("11");
		v12 = new Info("12");
		v13 = new Info("13");
		v14 = new Info("14");
		v15 = new Info("Ourivesaria");
		
		List<Info> vertices = new ArrayList<Info>();
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		vertices.add(v4);
		vertices.add(v5);
		vertices.add(v6);
		vertices.add(v7);
		vertices.add(v8);
		vertices.add(v9);
		vertices.add(v10);
		vertices.add(v11);
		vertices.add(v12);
		vertices.add(v13);
		vertices.add(v14);
		vertices.add(v15);
		Grafo grafo = new Grafo(n, G, vertices);

		int from = Integer.parseInt(JOptionPane.showInputDialog("De:"))-1;
		int to = Integer.parseInt(JOptionPane.showInputDialog("Para:"))-1 ;
		grafo.melhorCaminho(from, to);

	}
}