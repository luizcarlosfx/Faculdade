package com.faculdade.pesquisa_ordenacao.lab8;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Buscaoo2 {

	// Busca em profundidade a partir de um vértice origem
	// vértices estão númerados de 0 até n-1
	// REPRESENTAÇÃO DO GRAFO (A - B) (A - C) (B - D) (B - E) (D-E)
	// A ---------B
	// ! ! .
	// ! ! .
	// C----------D ----E
	public static void main(String args[]) {
		int G[][] = { { 0, 7, 0, 5, 0, 0, 0 }, { 7, 0, 8, 9, 7, 0, 0 }, { 0, 8, 0, 0, 5, 0, 0 }, { 5, 9, 0, 0, 15, 6, 0 }, { 0, 7, 5, 15, 0, 8, 9 },
				{ 0, 0, 0, 6, 8, 0, 11 }, { 0, 0, 0, 0, 9, 11, 0 } };

		// matriz de adjacência

		int n = 7; // número de vértices neste grafo

		Info v1, v2, v3, v4, v5, v6, v7;

		v1 = new Info("A");
		v2 = new Info("B");
		v3 = new Info("C");
		v4 = new Info("D");
		v5 = new Info("E");
		v6 = new Info("F");
		v7 = new Info("G");

		List<Info> vertices = new ArrayList<Info>();
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		vertices.add(v4);
		vertices.add(v5);
		vertices.add(v6);
		vertices.add(v7);
		Grafo grafo = new Grafo(n, G, vertices);

		int from = Integer.parseInt(JOptionPane.showInputDialog("De:")) - 1;
		int to = Integer.parseInt(JOptionPane.showInputDialog("Para:")) - 1;
		grafo.melhorCaminho(from, to);

	}
}