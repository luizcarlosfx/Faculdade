package com.faculdade.computacaografica.lab3;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.faculdade.computacaografica.lab1.TrianglePanel;

public class MoveTriangleGUI extends JFrame
{

	private JPanel contentPane;
	private JTextField textField;


	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MoveTriangleGUI frame = new MoveTriangleGUI();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MoveTriangleGUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final TrianglePanel panel = new TrianglePanel();
		panel.setBounds(10, 11, 414, 164);
		panel.setVisible(true);
		contentPane.add(panel);

		JButton btnTranslation = new JButton("Translation");
		btnTranslation.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				panel.Transladar(15, 0);
			}
		});
		btnTranslation.setBounds(10, 211, 94, 28);
		contentPane.add(btnTranslation);

		JButton btnRotate = new JButton("Scale");
		btnRotate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				panel.Escalonar(2, 2);
			}
		});
		btnRotate.setBounds(114, 211, 94, 28);
		contentPane.add(btnRotate);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.Reset();
			}
		});
		btnReset.setBounds(226, 211, 94, 28);
		contentPane.add(btnReset);

		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(330, 211, 94, 28);
		contentPane.add(btnQuit);

		JLabel lblOperaoSelecionada = new JLabel("Opera\u00E7\u00E3o selecionada:");
		lblOperaoSelecionada.setBounds(10, 265, 118, 14);
		contentPane.add(lblOperaoSelecionada);

		textField = new JTextField();
		textField.setBounds(145, 262, 175, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	
	
}
