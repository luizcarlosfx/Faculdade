package com.faculdade.pesquisa_ordenacao.lab3;

import java.util.ArrayList;
import java.util.List;

public class Livro {
	private String titulo, autor, editora, assunto;
	private double preco;

	public Livro(String titulo, String autor, String editora, String assunto,
			double preco) {
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.assunto = assunto;
		this.preco = preco;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Titulo: " + titulo + "\n Autor: " + autor + "\n Editora: " + editora + "\n Assunto: " + assunto + "\n Preço: " + preco;
	}

}
