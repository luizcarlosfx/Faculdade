package com.faculdade.linguagem_programacao.lab13;

public class Pizza {
	private String massa;
	private String molho;
	private String cobertura;

	public void setmassa(String massa) {
		this.massa = massa;
	}

	public void setmolho(String molho) {
		this.molho = molho;
	}

	public void setcobertura(String cobertura) {
		this.cobertura = cobertura;
	}

	public void print() {
		System.out.println("massa = " + massa);
		System.out.println("molho = " + molho);
		System.out.println("cobertura = " + cobertura);
	}
}

abstract class PizzaBuilder {
	protected Pizza pizza;

	public Pizza getPizza() {
		return pizza;
	}

	public void createNewPizzaProduct() {
		pizza = new Pizza();
	}

	public abstract void buildmassa();

	public abstract void buildmolho();

	public abstract void buildcobertura();
}

class HawaiianPizzaBuilder extends PizzaBuilder {
	public void buildmassa() {
		pizza.setmassa("crocante");
	}

	public void buildmolho() {
		pizza.setmolho("suave");
	}

	public void buildcobertura() {
		pizza.setcobertura("queijo + prezunto");
	}
}

class Waiter {
	private PizzaBuilder pizzaBuilder;

	public void setPizzaBuilder(PizzaBuilder pb) {
		pizzaBuilder = pb;
	}

	public Pizza getPizza() {
		return pizzaBuilder.getPizza();
	}

	public void constructPizza() {
		pizzaBuilder.createNewPizzaProduct();
		pizzaBuilder.buildmassa();
		pizzaBuilder.buildmolho();
		pizzaBuilder.buildcobertura();
	}
}

class SpicyPizzaBuilder extends PizzaBuilder {
	public void buildmassa() {
		pizza.setmassa("cozida");
	}

	public void buildmolho() {
		pizza.setmolho("apimentado");
	}

	public void buildcobertura() {
		pizza.setcobertura("pepperoni+salame");
	}
}
