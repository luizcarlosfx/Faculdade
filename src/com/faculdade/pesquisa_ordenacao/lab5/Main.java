package com.faculdade.pesquisa_ordenacao.lab5;

public class Main {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		
		int numbers [] = {100, 50, 150, 120, 25, 0};
		
		for (int i = 0; i < numbers.length; i++) {
			binaryTree.addNewNode(numbers[i]);
		}

		binaryTree.printInOrder();

		System.out.println();

		binaryTree.printPreOrder();

		System.out.println();

		binaryTree.printPostOrder();
	} 
}
