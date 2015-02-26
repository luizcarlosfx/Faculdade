package com.faculdade.computacaografica.lab1;

import java.awt.BorderLayout;

import javax.swing.*; // para JPanel e JFrame

public class Janela extends JFrame
{

	public Janela(String titulo, JPanel painel)
	{
		super(titulo);
		
		getContentPane().setLayout(new BorderLayout());
		this.setSize(painel.getSize().width, painel.getSize().height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		getContentPane().add(painel);
	}
}
