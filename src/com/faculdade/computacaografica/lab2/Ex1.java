package com.faculdade.computacaografica.lab2;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class Ex1 extends JFrame
{
	private Container container;
	private JTextField firstnumber = new JTextField();
	private JTextField secondNumber = new JTextField();
	private JTextField result = new JTextField();
	
	public Ex1(){
		this.setSize(240, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		container = getContentPane();
		container.setLayout(null);
		
		JLabel lbFirstButton = new JLabel("first number: ");
		lbFirstButton.setBounds(10, 10, 100, 30);
		
		firstnumber.setBounds(110, 10, 100, 30);
		
		JLabel lbSecond = new JLabel("second number: ");
		lbSecond.setBounds(10, 45, 100, 30);
		
		secondNumber.setBounds(110, 45, 100, 30);
		
		JLabel lbresult = new JLabel("Result: ");
		lbresult.setBounds(10, 80, 100, 30);
		
		result.setBounds(110, 80, 100, 30);
		
		JButton add = new JButton("add");
		add.setBounds(110, 120, 100, 30);
		
		JButton clear = new JButton("clear");
		clear.setBounds(10, 120, 100, 30);
		
		clear.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				result.setText("");
				firstnumber.setText("");
				secondNumber.setText("");
			}
		});
		
		add.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int first = Integer.parseInt(firstnumber.getText());
				int second = Integer.parseInt(secondNumber.getText());
				
				result.setText((first + second) + "");
			}
		});
		
		container.add(lbFirstButton);
		container.add(firstnumber);
		container.add(lbSecond);
		container.add(secondNumber);
		container.add(lbresult);
		container.add(result);
		container.add(add);
		container.add(clear);
		
	}
	
	public static void main(String[] args) throws UnsupportedLookAndFeelException
	{
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new Ex1();
	}
}
