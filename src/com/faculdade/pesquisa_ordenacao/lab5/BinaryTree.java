package com.faculdade.pesquisa_ordenacao.lab5;

public class BinaryTree {
	private Node root;

	public Node getRoot() {
		return this.root;
	}

	public void addNewNode(int value) {
		root = addNewNode(new Node(value), root);
	}

	private Node addNewNode(Node newNode, Node begin) {
		if (begin != null) {
			if (newNode.getValue() < begin.getValue()) {
				begin.setLeftNode(addNewNode(newNode, begin.getLeftNode()));
			} else {
				begin.setRightNode(addNewNode(newNode, begin.getRightNode()));
			} 
			return begin;
		} else {
			return newNode;
		}
	}

	public void printInOrder() {
		System.out.println("Imprimindo em Ordem...");
		printInOrder(root);
		System.out.println();
	}

	private void printInOrder(Node root) {
		if (root != null) {
			printInOrder(root.getLeftNode());
			System.out.print(root + "  ");
			printInOrder(root.getRightNode());
		}
	}

	public void printPostOrder() {
		System.out.println("Imprimindo em Pós Ordem...");
		printPostOrder(root);
		System.out.println();
	}

	private void printPostOrder(Node root) {
		if (root != null) {
			printPostOrder(root.getLeftNode());
			printPostOrder(root.getRightNode());
			System.out.print(root + "  ");
		}
	}

	public void printPreOrder() {
		System.out.println("Imprimindo em Pré Ordem...");
		printPreOrder(root);
		System.out.println();
	}

	private void printPreOrder(Node root) {
		if (root != null) {
			System.out.print(root + "  ");
			printPreOrder(root.getLeftNode());
			printPreOrder(root.getRightNode());
		}
	}
}
