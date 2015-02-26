package com.faculdade.sistemas_distribuidos.lab2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transito
{
	public static void main(String[] args)
	{
		Semaforo semaforo = new Semaforo();
		Carro carro1 = new Carro(Direcao.RUA1, semaforo, "Carro1");
		Carro carro2 = new Carro(Direcao.RUA2, semaforo, "Carro2");
		
		new Thread(carro1::mover).start();
		new Thread(carro2::mover).start();
		new Thread(semaforo::mudarDirecao).start();
	}
}

class Carro
{
	private Direcao direcao;

	private Semaforo semaforo;

	private String nome;

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public Direcao getDirecao()
	{
		return direcao;
	}

	public void setDirecao(Direcao direcao)
	{
		this.direcao = direcao;
	}

	public Semaforo getSemaforo()
	{
		return semaforo;
	}

	public void setSemaforo(Semaforo semaforo)
	{
		this.semaforo = semaforo;
	}

	public Carro(Direcao direcao, Semaforo semaforo, String nome)
	{
		this.direcao = direcao;
		this.semaforo = semaforo;
		this.nome = nome;
	}

	void mover()
	{
		for (int i = 0; i < 15; i++)
		{
			try
			{
				Thread.sleep((long) (Math.random() * 10000));

				semaforo.atravessar(this, i);

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}

class Semaforo
{
	private Direcao direcaoAtual = Direcao.RUA1;

	public synchronized void atravessar(Carro carro, int volta) throws InterruptedException
	{
		while (carro.getDirecao() != direcaoAtual)
		{
			System.out.println("\n" + carro.getNome() + " esperando para atravessar o semáforo");
			wait();
		}

		System.out.println("\n" + carro.getNome() + " atravessando o semáforo " + tempoAtual()
				+ ", volta " + volta);
	}

	static String tempoAtual()
	{
		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");

		return format.format(new Date());
	}

	public void mudarDirecao()
	{
		while (true)
		{
			try
			{
				Thread.sleep(5000);

				synchronized (this)
				{
					if (direcaoAtual == Direcao.RUA1)
					{
						direcaoAtual = Direcao.RUA2;
					}
					else
					{
						direcaoAtual = Direcao.RUA1;
					}

					System.out.println("\nMudando direcao para: " + direcaoAtual);
					
					notify();
				}
				
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}

enum Direcao
{
	RUA1, RUA2
}