package com.faculdade.pesquisa_ordenacao.lab3;

import java.text.Normalizer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		Biblioteca biblioteca = new Biblioteca();

		int opcao;

		do {

			opcao = Integer
					.parseInt(JOptionPane
							.showInputDialog("Biblioteca Veris: \nDigite \n 1 - Inserir um livro \n 2 - Listar todos os livros \n 3 - Ordenar por Título \n 4 - Ordenar por Editora \n 5 - Ordenar por Preço \n 6 - Ordenar Por um Campo Específico \n7 - Sair"));
			switch (opcao) {
				case 1:
					String titulo = JOptionPane.showInputDialog("Digite o título do livro");
					String autor = JOptionPane.showInputDialog("Digite o nome do autor do livro " + titulo);
					String editora = JOptionPane.showInputDialog("Digite a editora do livro " + titulo);
					String assunto = JOptionPane.showInputDialog("Digite o assunto tratado no livro " + titulo);

					double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do livro " + titulo));

					biblioteca.adicionarLivro(titulo, autor, editora, assunto, preco);
					break;

				case 2:
					biblioteca.listarLivros();
					break;

				case 3:
					biblioteca.ordenarLivrosPorTitulo();
					break;

				case 4:
					biblioteca.ordenarLivrosPorEditora();
					break;
				case 5:
					biblioteca.ordenarLivrosPorPreco();
					break;

				case 6:
					biblioteca.ordenarLivrosPor(removeAccents(JOptionPane.showInputDialog(
							"Entre com o nome do atributo do livro \nEx:(Título, Autor, Preço, Editora, Assunto")
							.toLowerCase()));
			}
		} while (opcao != 7);
	}

	public static String removeAccents(String str) {
		str = Normalizer.normalize(str, Normalizer.Form.NFD);
		str = str.replaceAll("[^\\p{ASCII}]", "");
		return str;
	}
}
