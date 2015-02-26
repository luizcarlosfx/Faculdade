package com.faculdade.games.lab2.ex2;

import java.awt.JobAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Produtos
{
	public static void main(String[] args)
	{
		Map<String, Produto> produtos = new HashMap<String, Produto>();

		Map<String, Double> vendidos = new HashMap<String, Double>();

		Produto p1 = new Produto("P1", 1);
		Produto p2 = new Produto("P2", 2.98);
		Produto p3 = new Produto("P3", 9.98);
		Produto p4 = new Produto("P4", 4.49);
		Produto p5 = new Produto("P5", 6.87);

		produtos.put(p1.getCodigo(), p1);
		produtos.put(p2.getCodigo(), p2);
		produtos.put(p3.getCodigo(), p3);
		produtos.put(p4.getCodigo(), p4);
		produtos.put(p5.getCodigo(), p5);

		while (true)
		{
			String codigo = JOptionPane.showInputDialog("Código");

			if (!produtos.containsKey(codigo))
				break;

			int quantidade = Integer.parseInt(JOptionPane.showInputDialog("quantidade"));

			double valor = vendidos.containsKey(codigo) ? vendidos.get(codigo) : 0;

			valor += (quantidade * produtos.get(codigo).getValor());
			
			vendidos.put(codigo, valor);
		}

		double total = vendidos.values().stream().collect(Collectors.summingDouble(d -> d));
		
		System.out.println("Total: " + total);
		
		for (String produto : vendidos.keySet())
		{
			System.out.println(produto + ": R$" + vendidos.get(produto) + ", " + ((vendidos.get(produto) / total) * 100) + "%");
		}
		
		
	}
}

class Produto
{
	private String codigo;
	private double valor;

	public String getCodigo()
	{
		return codigo;
	}

	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}

	public double getValor()
	{
		return valor;
	}

	public void setValor(double valor)
	{
		this.valor = valor;
	}

	public Produto(String codigo, double valor)
	{
		super();
		this.codigo = codigo;
		this.valor = valor;
	}

	@Override
	public String toString()
	{
		return "Produto [codigo=" + codigo + ", valor=" + valor + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigo == null)
		{
			if (other.codigo != null)
				return false;
		}
		else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
