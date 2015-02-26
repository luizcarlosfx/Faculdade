package com.faculdade.pesquisa_ordenacao.lab5;

public class Node {
	private int value;
	private Node leftNode;
	private Node rightNode;

	public Node(int value) {
		this.value = value;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int valor) {
		this.value = valor;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + getValue();
	}
}
