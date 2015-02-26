package com.faculdade.linguagem_programacao.lab4.part2;

public class TestePedido {

	public static void main(String[] args) {
		Data data = new Data(30, 06, 2013);
		ItemCompra itemCompra = new ItemCompra(12, "Office", 2, 2500);
		ItemCompra itemCompra1 = new ItemCompra(12, "Office", 2, 2500);
		ItemCompra itemCompra2 = new ItemCompra(12, "Office", 2, 2500);
		ItemCompra itemCompra3 = new ItemCompra(12, "Office", 2, 2500);

		Pedido pedido = new Pedido(12, "Luiz", data);
		pedido.addItem(itemCompra);
		pedido.addItem(itemCompra1);
		pedido.addItem(itemCompra2);
		pedido.addItem(itemCompra3);

		System.out.println(pedido);
		
		Data data2 = new Data(20, 20, 20);
		pedido.setData(data2);
		pedido.addItem(new ItemCompra(1,"bla",2,2));
		pedido.addItem(new ItemCompra(1,"bla",2,2));
		pedido.addItem(new ItemCompra(1,"bla",2,2));
		pedido.addItem(new ItemCompra(1,"bla",2,2));
		
		Pedido pedido2 = new Pedido(2, "Nome", data2);
		pedido2.addItem(itemCompra);
		pedido2.addItem(itemCompra1);
		pedido2.addItem(itemCompra2);
		pedido2.addItem(itemCompra3);
		
		System.out.println(pedido);
		System.out.println();
		System.out.println(pedido2);

	}
}
