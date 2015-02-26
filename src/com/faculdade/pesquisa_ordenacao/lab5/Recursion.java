package com.faculdade.pesquisa_ordenacao.lab5;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Recursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int index = Integer.parseInt(JOptionPane.showInputDialog("Digite o �ndice para localizar um elemento da sequ�ncia de fibonacci"));
		int fib = fibonnaci(index);
		JOptionPane.showMessageDialog(null, "O " + index + "� elemento da sequ�ncia de fibonacci � " + fib);

		JLabel tvBase = new JLabel("Base");
		JLabel tvExponent = new JLabel("Expoente");
		JTextField etBase = new JTextField();
		JTextField etExponent = new JTextField();

		JComponent[] jComponents = { tvBase, etBase, tvExponent, etExponent };

		JOptionPane.showMessageDialog(null, jComponents, "Pot�ncia��o", JOptionPane.PLAIN_MESSAGE);
		int base = Integer.parseInt(etBase.getText());
		int exponent = Integer.parseInt(etExponent.getText());
		int pow = pow(base, exponent);
		
		JOptionPane.showMessageDialog(null, base + "^" + exponent + " = " + pow);
	}

	public static int fibonnaci(int index) {
		if (index < 2) {
			return index;
		}

		return fibonnaci(index - 1) + fibonnaci(index - 2);
	}

	public static int pow(int base, int exponent) {
		if (exponent == 0) {
			return 1;
		}
		return base * pow(base, exponent - 1);
	}

}
