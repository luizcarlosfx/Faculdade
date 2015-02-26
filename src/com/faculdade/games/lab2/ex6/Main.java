package com.faculdade.games.lab2.ex6;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main
{

	public static void main(String[] args)
	{
		Loja loja = new Loja();

		double[] gastos1 =
			{ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120 };
		double[] gastos2 =
			{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		double[] gastos3 =
			{ 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60 };
		double[] gastos4 =
			{ 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24 };
		double[] gastos5 =
			{ 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36 };

		Cliente c1 = new Cliente("Cliente 1", "cliente1@outlook.com", "qualquer endereço",
				"qualquer telefone", gastos1);
		Cliente c2 = new Cliente("Cliente 2", "cliente2@outlook.com", "qualquer endereço",
				"qualquer telefone", gastos2);
		Cliente c3 = new Cliente("Cliente 3", "cliente3@outlook.com", "qualquer endereço",
				"qualquer telefone", gastos3);
		Cliente c4 = new Cliente("Cliente 4", "cliente4@outlook.com", "qualquer endereço",
				"qualquer telefone", gastos4);
		Cliente c5 = new Cliente("Cliente 5", "cliente5@outlook.com", "qualquer endereço",
				"qualquer telefone", gastos5);

		loja.registrar(c1, c2, c3, c4, c5);
		
		loja.relatorioDeGastos();
	}
}

class Loja
{
	private List<Cliente> clientes = new ArrayList<Cliente>();

	public void registrar(Cliente... toAdd)
	{
		for (Cliente cliente : toAdd)
		{
			clientes.add(cliente);
		}
	}

	public void remover(Cliente... toAdd)
	{
		for (Cliente cliente : toAdd)
		{
			clientes.add(cliente);
		}
	}

	public Optional<Cliente> encontrarCliente(String email)
	{
		return clientes.stream().filter(c -> c.getEmail() == email).findFirst();
	}

	public void imprimir()
	{
		System.out.println("Imprimindo clientes...");
		clientes.forEach(this::imprimirCliente);
	}

	public void relatorioDeGastos()
	{
		double total = 0;

		for (int i = 0; i < 12; i++)
		{
			double mes = totalPorMes(i);

			System.out.println(String.format("Total no mês %s = R$%.2f", i + 1, mes));

			total += mes;
		}

		System.out.println(String.format("Total acumulado = R$%.2f", total));

		System.out.println();
		
		for (int i = 0; i < 12; i++)
		{
			Cliente maiorGasto = maiorGastoNoMes(i);
			System.out.println(String.format(
					"Cliente com maior gasto no mês %s foi o %s. Ele gastou %.2f", i + 1,
					maiorGasto.getNome(), maiorGasto.gasto(i)));
		}

		System.out.println();
		
		Cliente maiorGastoTotal = maiorGastoTotal();

		System.out.println(String.format("Cliente com maior gasto total %s. Ele gastou %.2f",
				maiorGastoTotal.getNome(), maiorGastoTotal.totalGasto()));
	}

	private Cliente maiorGastoTotal()
	{
		Cliente cliente = clientes.get(0);

		for (int i = 1; i < clientes.size(); i++)
		{
			Cliente atual = clientes.get(i);

			if (atual.totalGasto() > cliente.totalGasto())
			{
				cliente = atual;
			}
		}

		return cliente;
	}

	private Cliente maiorGastoNoMes(int mes)
	{
		Cliente cliente = clientes.get(0);

		for (int i = 1; i < clientes.size(); i++)
		{
			Cliente atual = clientes.get(i);

			if (atual.gasto(mes) > cliente.gasto(mes))
			{
				cliente = atual;
			}
		}

		return cliente;
	}

	double totalPorMes(int mes)
	{
		return clientes.stream().collect(Collectors.summingDouble(c -> c.gasto(mes)));
	}

	void imprimirCliente(Cliente cliente)
	{
		System.out.println(cliente);
	}
}

class Cliente
{
	private String nome, email, endereco, telefone;

	private double[] gastos = new double[12];

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getEndereco()
	{
		return endereco;
	}

	public void setEndereco(String endereco)
	{
		this.endereco = endereco;
	}

	public String getTelefone()
	{
		return telefone;
	}

	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}

	public double gasto(int mes)
	{
		return gastos[mes];
	}

	public double totalGasto()
	{
		double total = 0;

		for (double d : gastos)
		{
			total += d;
		}

		return total;
	}

	public double[] getGastos()
	{
		return gastos;
	}

	public void setGastos(double[] gastos)
	{
		this.gastos = gastos;
	}

	public Cliente(String nome, String email, String endereco, String telefone, double[] gastos)
	{
		super();
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
		this.gastos = gastos;
	}

	@Override
	public String toString()
	{
		String toReturn = "Cliente [nome=" + nome + ", email=" + email + ", endereco=" + endereco
				+ ", telefone=" + telefone + "]\nGastos:";

		for (int i = 0; i < gastos.length; i++)
		{
			toReturn += String.format("Mês %s - Gasto R$%.2f", i + 1, gastos[i]);
		}

		return toReturn;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Cliente other = (Cliente) obj;
		if (email == null)
		{
			if (other.email != null)
				return false;
		}
		else if (!email.equals(other.email))
			return false;
		return true;
	}
}