package com.faculdade.computacaografica.lab6;

public class TestModaMediaMediana
{
	public static void main(String[] args)
	{
		ImageAnalize imageAnalize = new ImageAnalize();
		
		imageAnalize.printOcurrences();
		
		System.out.println();
		
		System.out.println("Mediana: " + imageAnalize.getMediana());
		System.out.println("Moda: " + imageAnalize.getModa());
		System.out.println("Media: " + imageAnalize.getAverage());
	}
}
