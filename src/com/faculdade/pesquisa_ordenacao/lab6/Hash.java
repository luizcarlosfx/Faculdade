package com.faculdade.pesquisa_ordenacao.lab6;

public class Hash {
	public static void main(String[] args) {

		Integer array[] = criaArray(10);
		System.out.println("Linear");
		for (int i = 0; i < array.length / 2; i++) {
			insereLinear((int) (Math.random() * 100), array);
		}
		System.out.println(imprimeHash(array));
		
		
		array = criaArray(10);
		System.out.println("Double-Hash");
		for (int i = 0; i < array.length / 2; i++) {
			insereLinear((int) (Math.random() * 100), array);
		}
		System.out.println(imprimeHash(array));
	}

	public static void insereLinear(int elemento, Integer[] array) {
		int hash = criaHash(elemento, array);
		addLinear(hash, array, elemento);
	}

	public static Integer[] criaArray(int i) {
		return new Integer[i * 2];
	}

	public static void addLinear(int hash, Integer[] array, int elemento) {
		if (array[hash] == null) {
			array[hash] = elemento;
		} else {
			addLinear(++hash % array.length, array, elemento);
		}
	}

	public static void addDoubleHash(int hash, Integer[] array, int elemento) {
		if (array[hash] == null) {
			array[hash] = elemento;
		} else {
			addLinear(incremento(elemento, array)+hash, array, elemento);
		}
	}

	public static String imprimeHash(Integer[] a) {
		String r = "";

		for (int i = 0; i < a.length; i++) {
			r += i+" - "+(a[i]==null?"-":a[i])+"\n";
		}

		return r;
	}

	public static int criaHash(int num, Integer[] a) {
		return num % a.length;
	}
	
	public static int incremento(int valorpos, Integer[] a) {
		return (valorpos % a.length-1) +1;
	}

}
