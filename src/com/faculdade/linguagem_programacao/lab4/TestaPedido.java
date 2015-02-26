package com.faculdade.linguagem_programacao.lab4;

public class TestaPedido {
	public static void main(String[] args) {
		ItemCompra itemCompra = new ItemCompra(1, "Notebook Dell", 3, 3000);
		Pedido pedido = new Pedido(1, new Data(30, 06, 1993), itemCompra);
		Cliente cliente = new Cliente("Luiz Carlos", "Rua das Tuiras", pedido);
		System.out.println(cliente);
	}
}
