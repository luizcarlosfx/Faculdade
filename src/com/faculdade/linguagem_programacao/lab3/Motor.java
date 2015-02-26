package com.faculdade.linguagem_programacao.lab3;

public class Motor {

	private double portencia;
	public Motor(double portencia) {
		super();
		this.portencia = portencia;
	}

	public double getPortencia() {
		return portencia;
	}

	public void setPortencia(double portencia) {
		this.portencia = portencia;
	}

	@Override
	public String toString() {
		return "\nPotência = " + portencia;
	}
}
