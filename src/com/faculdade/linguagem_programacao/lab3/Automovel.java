package com.faculdade.linguagem_programacao.lab3;

public class Automovel {
	private double distancia;
	private double volume;
	private Combustivel combustivel;
	private Motor motor;
	
	public Automovel(double distancia, double volume, Combustivel combustivel,
			Motor motor) {
		this.distancia = distancia;
		this.volume = volume;
		this.combustivel = combustivel;
		this.motor = motor;
	}
	
	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getPrecoMedio() {
		return combustivel.getPreco() / (distancia / volume);
	}
	
	@Override
	public String toString() {
		return "\nDistância = " + distancia + "\nVolume = " + volume + combustivel.toString() + motor.toString();
	}
}
