package com.faculdade.linguagem_programacao.lab10;

public class Empregado {

	protected String nome;
	protected String endereco;
	protected double salario;

	
	public Empregado(String nome, String endereco, double salario) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}

	public void imprimir() {
		System.out.println(this);
	}

	public double callINSS() {
		return salario * .11;
	}

	public double calRPF() {
		if(salario < 1800){
			return salario *.15;
		}else{
			return salario * .27;
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome: " + nome + "\nEndereco: " + endereco + "\nSalário: " + salario;
	}
}
