package com.faculdade.pesquisa_ordenacao.lab8.com.faculdade;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class BuscaooCaminho {

	// Busca em profundidade a partir de um vértice origem
	// vértices estão númerados de 0 até n-1
	// REPRESENTAÇÃO DO GRAFO (A - B) (A - C) (B - D) (B - E) (D-E)
	// A ---------B
	// ! ! .
	// ! ! .
	// C----------D ----E
	public static void main(String args[]) {
		while (true){
			int G[][] = { { 0, 7, 0, 5, 0, 0, 0 }, { 7, 0, 8, 9, 7, 0, 18 }, { 0, 8, 0, 0, 5, 0, 0 }, { 5, 9, 0, 0, 15, 6, 0 }, { 0, 7, 5, 15, 0, 8, 9 },
					{ 0, 0, 0, 6, 8, 0, 11 }, { 0, 18, 0, 0, 9, 11, 0 }, };// grafo
																			// representado
																			// por
			// matriz de adjacência

			int n = 7; // número de vértices neste grafo

			List<Info> vertices = new ArrayList<Info>();
			vertices.add(new Info("A"));
			vertices.add(new Info("B"));
			vertices.add(new Info("C"));
			vertices.add(new Info("D"));
			vertices.add(new Info("E"));
			vertices.add(new Info("F"));
			vertices.add(new Info("G"));
/*
			Grafo grafo = new Grafo(n, G, vertices);
			um = JOptionPane.showInputDialog("Digite a origem [A,B,C,D,E,F,G]: \nou 'S' para sair.").toUpperCase();
			if (um.equals("S")) {
				break;
			}
			dois = JOptionPane.showInputDialog("Digite a origem [A,B,C,D,E,F,G]: \nou 'S' para sair.").toUpperCase();
			if (dois.equals("S")) {
				break;
			}
			Info valor1 = new Info(um);

			Info valor2 = new Info(dois);*/

			/*grafo.melhorCaminho(vertices.indexOf(valor1), vertices.indexOf(valor2));*/
			MeuGrafo meuGrafo = new MeuGrafo(G, vertices);
			/*grafos.Visita(0);*/
		}
	}
}