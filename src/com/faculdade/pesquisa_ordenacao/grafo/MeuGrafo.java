package com.faculdade.pesquisa_ordenacao.grafo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MeuGrafo {

	private int[][] matAdj;
	private List<Info> vertices;
	private Caminho melhorCaminho;
	private int numVertices;

	public MeuGrafo(int[][] matAdj, List<Info> vertices) {
		this.vertices = vertices;
		this.matAdj = matAdj;
		numVertices = matAdj.length;
	}

	public String melhorCaminho(int origem, int destino) {
		if (origem != destino) {
			Caminho caminho = new Caminho(numVertices);
			caminho.addVertice(0, new Info(vertices.get(origem).toString()));
			buscarMelhorCaminho(origem, destino, caminho);
		} else {
			Caminho caminho = new Caminho(numVertices);
			caminho.addVertice(0, vertices.get(origem));
			melhorCaminho = caminho;
		}
		return melhorCaminho.toString();
	}

	private void buscarMelhorCaminho(int linha, int destino, Caminho caminho) {
		caminho.getVisitado()[linha] = true;
		System.out.println(caminho);
		if (melhorCaminho != null && caminho.getTempo() >= melhorCaminho.getTempo())
			return;

		for (int j = 0; j < matAdj[linha].length; j++) {
			if (matAdj[linha][j] > 0 && j == destino && !caminho.getVisitado()[j]) {
				caminho.addVertice(matAdj[linha][j], new Info(vertices.get(j).toString()));
				melhorCaminho = caminho;
				return;
			}
			if (matAdj[linha][j] > 0 && !caminho.getVisitado()[j]) {
				Caminho caminho2 = new Caminho(caminho);
				caminho2.addVertice(matAdj[linha][j], new Info(vertices.get(j).toString()));
				caminho.getVisitado()[j] = true;
				buscarMelhorCaminho(j, destino, caminho2);
			}
		}
	}

	public static void main(String[] args) {
		String continuar;
		do {
			int matAdj[][] = { { 0, 7, 0, 5, 0, 0, 0 }, { 7, 0, 8, 9, 7, 0, 0 }, { 0, 8, 0, 0, 5, 0, 0 }, { 5, 9, 0, 0, 15, 6, 0 }, { 0, 7, 5, 15, 0, 8, 9 },
					{ 0, 0, 0, 6, 8, 0, 11 }, { 0, 0, 0, 0, 9, 11, 0 }, };

			List<Info> vertices = new ArrayList<Info>();
			// adicionando os vertices ao array
			for (char i = 'A'; i <= 'G'; i++) {
				vertices.add(new Info("" + i));
			}

			MeuGrafo meuGrafo = new MeuGrafo(matAdj, vertices);
			int from = vertices.indexOf(new Info(JOptionPane.showInputDialog("De:").toUpperCase()));
			int to = vertices.indexOf(new Info(JOptionPane.showInputDialog("Para:").toUpperCase()));

			long inicio = System.nanoTime();
			String melhor = meuGrafo.melhorCaminho(from, to);
			long fim = System.nanoTime();

			System.out.println("Melhor Caminho = " + melhor + "\nTempo para rotear = " + (fim - inicio) + " nano " + "segundos");

			continuar = JOptionPane.showInputDialog("Deseja Continuar? (S / N)").toUpperCase();
		} while (continuar.charAt(0) != 'N');
	}
}
