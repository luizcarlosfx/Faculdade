package com.faculdade.linguagem_programacao.lab2;

public class Funcionario {

	private int codigo;
	private String nome;
	private int horas_trabalhadas;
	private double salario;

	public Funcionario() {
		salario = codigo = horas_trabalhadas = 0;
		nome = "";
	}

	public Funcionario(int codigo, String nome, int horas_trabalhadas) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.horas_trabalhadas = horas_trabalhadas;
	}

	public String getNome() {
		return nome;
	}

	public void setHoras_trabalhadas(int horas_trabalhadas) {
		this.horas_trabalhadas = horas_trabalhadas;
	}

	public double calculaSalario() {
		salario = 50 * horas_trabalhadas;
		return salario;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome = " + nome + "\nCódigo = " + codigo
				+ "\nHoras Trabalhadas = " + horas_trabalhadas + " \nSalário = "
				+ salario;
	}

	public static Funcionario quemGanhaMais(Funcionario funcionario, Funcionario f2) {
		return (funcionario.salario < f2.salario) ? f2 : funcionario;
	}
}
