package com.faculdade.pesquisa_ordenacao.grafo;

import java.util.ArrayList;

public class Caminho {
	private ArrayList<Info> caminho = new ArrayList<>();
	private int tempo;
	private boolean visitado[];

	public Caminho(int size) {
		this.visitado = new boolean[size];
	}

	public Caminho(Caminho caminho) {
		clonarCaminho(caminho.getCaminho());
		this.tempo = caminho.tempo;
		clonarVisitado(caminho.getVisitado());
	}

	public boolean[] getVisitado() {
		return visitado;
	}

	public ArrayList<Info> getCaminho() {
		return caminho;
	}

	public void setCaminho(ArrayList<Info> caminho) {
		this.caminho = caminho;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public void addVertice(int tempo, Info info) {
		this.tempo += tempo;
		caminho.add(info);
		/* System.out.println(caminho.toString()); */
	}

	public void clonarCaminho(ArrayList<Info> infos) {
		for (Info info : infos) {
			caminho.add(info);
		}
	}

	public void clonarVisitado(boolean[] visitado) {
		this.visitado = new boolean[visitado.length];
		for (int i = 0; i < visitado.length; i++) {
			this.visitado[i] = visitado[i];
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return caminho.toString() + " Tempo: " + tempo;
	}
}
