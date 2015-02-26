package com.faculdade.pesquisa_ordenacao.lab3;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

	private List<Livro> livros = new ArrayList<Livro>();

	public Biblioteca() {
		adicionarLivro("Java como programar", "Deittel", "Alguma", "Desenvolvimento de Sistemas", 150);
		adicionarLivro("Harry Potter", "J. K. Rowling", "Sei lá", "Ficção Científica", 50);
		adicionarLivro("As Crônicas de Narnia", "C.S.Lewis", "Não Sei", "Ficção Científica", 300);
		adicionarLivro("Reforma Ortográfica", "Não Sei", "Brasileira", "Lingua Portuguesa", 30);
		adicionarLivro("Default", "Default", "Default", "Default", 0);
	}

	public Livro adicionarLivro(String titulo, String autor, String editora, String assunto, double preco) {
		Livro livro = new Livro(titulo, autor, editora, assunto, preco);
		livros.add(livro);
		return livro;
	}

	public void ordenarLivrosPor(String fieldReference) {
		Ordenador<Livro> ordenador = new Ordenador<>(livros, Livro.class);
		ordenador.ordenar(fieldReference);
		listarLivros();
	}

	public void ordenarLivrosPorTitulo() {
		Livro temp = null;
		boolean alterado = true;

		while (alterado) {
			alterado = false;
			for (int j = 0; j < livros.size() - 1; j++) {
				if (maior(livros.get(j).getTitulo(), livros.get(j + 1).getTitulo())) {
					temp = livros.get(j + 1);
					livros.set(j + 1, livros.get(j));
					livros.set(j, temp);
					alterado = true;
				}
			}
		}
	}

	public void ordenarLivrosPorEditora() {
		for (int i = 1; i < livros.size(); i++) {
			Livro livro = livros.get(i);

			for (int j = i - 1; j >= 0 && maior(livros.get(j).getEditora(), livro.getEditora()); j--) {
				livros.set(j + 1, livros.get(j));
				livros.set(j, livro);
			}
		}
	}

	public void ordenarLivrosPorPreco() {
		for (int i = 0; i < livros.size(); i++) {
			int minimo = i;
			for (int j = i + 1; j < livros.size(); j++) {
				if (livros.get(j).getPreco() < livros.get(minimo).getPreco()) {
					minimo = j;
				}
			}
			if (minimo != i) {
				Livro temp = livros.get(i);
				livros.set(i, livros.get(minimo));
				livros.set(minimo, temp);
			}
		}
	}

	public void listarLivros() {
		System.out.println("\nListando os livros...");
		for (Livro livro : livros) {
			System.out.println();
			System.out.println(livro);
			System.out.println();
		}
		System.out.println("\nListagem concluída!");
	}

	private boolean maior(String string, String string2) {
		return string.compareTo(string2) > 0;
	}
}
