package com.faculdade.pesquisa_ordenacao.lab3;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Ordenador<Tipo> {
	private String className;
	private List<Tipo> list;

	public Ordenador(List<Tipo> list, Class classType) {
		this.list = list;
		this.className = classType.getName();
		System.out.println(className);
	}

	public void ordenar(String fieldReference) {
		Class classe = null;
		Tipo instance = null;
		try {
			classe = Class.forName(className);
			Method method = classe.getDeclaredMethod("get" + (fieldReference.charAt(0) + "").toUpperCase() + fieldReference.substring(1));
			Class type = method.getReturnType();
			if (type.isPrimitive() || oneClassExtendsAnOther(type, Number.class)) {
				ordenarNumero(method);
			} else {
				ordenarString(method);
			}
		} catch (Exception e) {
			System.out.println("exception " + e.getMessage());
		}
	}

	private void ordenarNumero(Method method) {
		Tipo temp = null;
		boolean alterado = true;
		try {
			while (alterado) {
				alterado = false;
				for (int j = 0; j < list.size() - 1; j++) {
					Double number1;
					number1 = Double.parseDouble(method.invoke(list.get(j)).toString());
					Double number2 = Double.parseDouble(method.invoke(list.get(j + 1)).toString());
					if (number1 > number2) {
						temp = list.get(j + 1);
						list.set(j + 1, list.get(j));
						list.set(j, temp);
						alterado = true;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void ordenarString(Method method) {
		Tipo temp = null;
		boolean alterado = true;
		try {
			while (alterado) {
				alterado = false;
				for (int j = 0; j < list.size() - 1; j++) {
					String string1;
					string1 = method.invoke(list.get(j)).toString();
					String string2 = method.invoke(list.get(j + 1)).toString();
					if (string1.compareTo(string2) > 0) {
						temp = list.get(j + 1);
						list.set(j + 1, list.get(j));
						list.set(j, temp);
						alterado = true;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ordenou");
	}

	private boolean oneClassExtendsAnOther(Class oneClass, Class anOtherClass) {
		Class temp = oneClass;
		while (temp != null) {
			if (temp.getName().equals(anOtherClass.getName())) {
				System.out.println(true);
				return true;
			}
			temp = temp.getSuperclass();
		}
		return false;
	}
}
