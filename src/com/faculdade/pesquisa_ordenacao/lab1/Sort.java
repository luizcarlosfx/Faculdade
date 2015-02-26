package com.faculdade.pesquisa_ordenacao.lab1;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		int[] v = randomArray(1000);
		int[] v2 = v.clone();
		int[] v3 = v.clone();
		int[] v4 = v.clone();
		int[] v5 = v.clone();
		int [] v6 = v.clone();

/*		long inic = System.nanoTime();
		shellsort(v);
		long fim = System.nanoTime();
		System.out.println("SHELL TEMPO: " + (fim - inic));

		inic = System.nanoTime();
		insertion(v2);
		fim = System.nanoTime();
		System.out.println("INSERT TEMPO: " + (fim - inic));

		inic = System.nanoTime();
		selectionSort(v3);
		fim = System.nanoTime();
		System.out.println("SELECAO TEMPO: " + (fim - inic));

		inic = System.nanoTime();
		bubblesort(v4);
		fim = System.nanoTime();
		System.out.println("BUBBLE TEMPO: " + (fim - inic));

		inic = System.nanoTime();
		quick_sort(v5, 0, v5.length);
		fim = System.nanoTime();
		System.out.println("QUICK TEMPO: " + (fim - inic));
		
		inic = System.nanoTime();
		javaSort(v6);
		fim = System.nanoTime();
		System.out.println("JAVA TEMPO: " + (fim - inic));*/

	}

	public static void quick_sort(int[] v, int ini, int fim) {
		int meio;
		if (ini < fim) {
			meio = partition(v, ini, fim);
			quick_sort(v, ini, meio);
			quick_sort(v, meio + 1, fim);
		}
	}

	public static int partition(int[] v, int ini, int fim) {
		int pivo, topo, i;
		pivo = v[ini];
		topo = ini;

		for (i = ini + 1; i < fim; i++) {
			if (v[i] < pivo) {
				v[topo] = v[i];
				v[i] = v[topo + 1];
				topo++;
			}
		}
		v[topo] = pivo;
		return topo;
	}

	public static void bubblesort(int vetor[]) {
		int temp;
		boolean alterado = true;

		while (alterado) {
			temp = 0;
			alterado = false;
			for (int j = 0; j < vetor.length - 1; j++) {
				if (vetor[j] > vetor[j + 1]) {
					temp = vetor[j + 1];
					vetor[j + 1] = vetor[j];
					vetor[j] = temp;
					alterado = true;
				}
			}
		}
	}

	public static void selectionSort(int[] vetor) {

		int minimo, temp;

		for (int i = 0; i < vetor.length; i++) {
			minimo = i;
			for (int j = i + 1; j < vetor.length; j++) {
				if (vetor[j] < vetor[minimo]) {
					minimo = j;
				}
			}
			if (minimo != i) {
				temp = vetor[minimo];
				vetor[minimo] = vetor[i];
				vetor[i] = temp;
			}
		}
	}

	public static void shellsort(int nums[]) {

		int n = nums.length;
		int h = n / 2;
		int c, j;
		while (h > 0) {
			for (int i = h; i < n; i++) {
				c = nums[i];
				j = i;
				while (j >= h && nums[j - h] > c) {
					nums[j] = nums[j - h];
					j = j - h;
				}
				nums[j] = c;
			}
			h = h / 2;
		}
	}

	public static void insertion(int nums[]) {
		for (int i = 1; i < nums.length; i++) {
			int a = nums[i];
			int j;
			for (j = i - 1; j >= 0 && nums[j] > a; j--) {
				nums[j + 1] = nums[j];
				nums[j] = a;
			}
		}

	}

	public static int[] randomArray(int tam) {

		int[] iArray = new int[tam];

		for (int i = 0; i < iArray.length; i++) {
			iArray[i] = (int) (Math.random() * tam + 1);
		}

		return iArray;
	}
	
	public static void javaSort(int [] array)
	{
		Arrays.sort(array);
	}
}
