package com.faculdade.computacaografica.lab2;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Ex2 extends JFrame
{
	private Container container;
	private JTextField ladoa = new JTextField();
	private JTextField ladob = new JTextField();
	private JTextField result = new JTextField();
	private JTextField ladoc = new JTextField();

	public Ex2()
	{
		this.setSize(235, 245);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		container = getContentPane();
		container.setLayout(null);

		JLabel lbladoa = new JLabel("maior lado: ");
		lbladoa.setBounds(10, 10, 100, 30);

		ladoa.setBounds(110, 10, 100, 30);

		JLabel lbladob = new JLabel("lado b: ");
		lbladob.setBounds(10, 45, 100, 30);

		ladob.setBounds(110, 45, 100, 30);

		JLabel lbladoc = new JLabel("lado c: ");
		lbladoc.setBounds(10, 80, 100, 30);

		ladoc.setBounds(110, 80, 100, 30);

		JLabel resultado = new JLabel("resultado: ");
		resultado.setBounds(10, 130, 100, 30);

		result.setBounds(110, 130, 100, 30);

		JButton avaliar = new JButton("avaliar");
		avaliar.setBounds(110, 170, 100, 30);

		JButton clear = new JButton("clear");
		clear.setBounds(10, 170, 100, 30);

		clear.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				result.setText("");
				ladoa.setText("");
				ladob.setText("");
				ladoc.setText("");
			}
		});

		avaliar.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				int maior = Integer.parseInt(ladoa.getText());
				int b = Integer.parseInt(ladob.getText());
				int c = Integer.parseInt(ladoc.getText());

				if ((b + c) > maior)
				{
					result.setText("Triangulo");
				}

				else
				{
					result.setText(" Não Triangulo");
				}

			}
		});

		container.add(lbladoa);
		container.add(ladoa);
		container.add(lbladob);
		container.add(ladob);
		container.add(lbladoc);
		container.add(result);
		container.add(resultado);
		container.add(ladoc);
		container.add(avaliar);
		container.add(clear);

	}

	public static void main(String[] args) throws Exception
	{
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new Ex2();
	}
}
