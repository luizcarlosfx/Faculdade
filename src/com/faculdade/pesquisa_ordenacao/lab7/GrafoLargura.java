package com.faculdade.pesquisa_ordenacao.lab7;

import java.util.List;

public class GrafoLargura extends Grafo {

	public GrafoLargura(int n, int[][] G, List<Info> ver) {
		super(n, G, ver);
	}

	@Override
	public void imprime(int origem) {
		visitado[origem] = true;
		// Imprimir o vertice
		System.out.println(vertices.get(origem));

		for (int i = 0; i < num_vertices; i++) {
			if (!(visitado[i])) {
				visitado[i] = true;
				System.out.println(vertices.get(i));
			}
		}
	}
}
