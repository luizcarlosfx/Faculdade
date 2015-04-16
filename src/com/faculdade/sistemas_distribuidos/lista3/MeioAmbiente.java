package com.faculdade.sistemas_distribuidos.lista3;

public class MeioAmbiente
{
	public static void main(String[] args)
	{
		for(int i = 0; i < 100; i++)
		{
			Regiao regiao = new Regiao();
			
			regiao.start();
		}
	}
}

class SensoresQualidadeAr extends Thread
{
	int quantia;

	public SensoresQualidadeAr(int quantia)
	{
		this.quantia = quantia;
	}
}

class Regiao extends Thread
{
	private SensoresQualidadeAr sensores = new SensoresQualidadeAr(50);

	private Light light;
}

class Light
{
	public void ativar()
	{
	}
}
