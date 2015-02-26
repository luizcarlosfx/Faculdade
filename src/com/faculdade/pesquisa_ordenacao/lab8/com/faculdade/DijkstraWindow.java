package com.faculdade.pesquisa_ordenacao.lab8.com.faculdade;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class DijkstraWindow extends JFrame
{
	private Container contentPane = getContentPane();
	private JComboBox<String> from;
	private JComboBox<String> to;

	public static void main(String[] args) throws UnsupportedLookAndFeelException
	{
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new DijkstraWindow();
	}

	public DijkstraWindow()
	{
		buildWindow();
		setSize(340, 325);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

	public void buildWindow()
	{
		String[] values = new String[6];

		for (char c = 'U'; c <= 'Z'; c++)
		{
			values[c - 'U'] = c + "";
		}

		from = new JComboBox<String>(values);
		to = new JComboBox<String>(values);

		contentPane.setLayout(null);

		JLabel jlfrom = new JLabel("De: ");
		JLabel jlto = new JLabel("Para: ");

		contentPane.add(jlfrom);
		jlfrom.setBounds(10, 10, 25, 25);

		contentPane.add(from);
		from.setBounds(40, 10, 100, 25);

		contentPane.add(jlto);
		jlto.setBounds(165, 10, 40, 25);

		contentPane.add(to);
		to.setBounds(210, 10, 100, 25);

		ImageIcon image = resizeImage(305, 170, new ImageIcon(this.getClass().getClassLoader()
				.getResource("com/luizprogrammer/po/lab8/image.jpg")));
		JLabel imageLabel = new JLabel(image);
		contentPane.add(imageLabel);
		imageLabel.setBounds(10, 35, 305, 200);

		final JLabel betterWay = new JLabel("Melhor Caminho: ");
		contentPane.add(betterWay);
		betterWay.setBounds(10, 230, 305, 25);

		JButton action = new JButton("Buscar Melhor Caminho");
		contentPane.add(action);
		action.setBounds(10, 260, 305, 25);

		action.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				int matAdj[][] = new int[6][6];
				matAdj[0] = new int[]
					{ 0, 2, 5, 1, 0, 0 }; // u
				matAdj[1] = new int[]
					{ matAdj[1][0], 0, 3, 2, 0, 0 }; // v
				matAdj[2] = new int[]
					{ matAdj[2][1], matAdj[2][1], 0, 2, 1, 2 }; // w
				matAdj[3] = new int[]
					{ matAdj[3][0], matAdj[3][1], matAdj[3][2], 0, 1, 0 }; // x
				matAdj[4] = new int[]
					{ matAdj[4][0], matAdj[4][1], matAdj[4][2], matAdj[4][3], 0, 2 }; // y
				matAdj[5] = new int[]
					{ matAdj[5][0], matAdj[5][1], matAdj[5][2], matAdj[5][3], matAdj[5][4], 0 }; // z

				List<Info> vertices = new ArrayList<Info>();
				// adicionando os vertices ao array
				for (char i = 'U'; i <= 'Z'; i++)
				{
					vertices.add(new Info("" + i));
				}

				MeuGrafo meuGrafo = new MeuGrafo(matAdj, vertices);

				int iFrom = vertices.indexOf(new Info(from.getSelectedItem().toString()));
				int iTo = vertices.indexOf(new Info(to.getSelectedItem().toString()));

				String melhor = meuGrafo.melhorCaminho(iFrom, iTo);

				betterWay.setText("Melhor Caminho: " + melhor);
			}
		});
	}

	public static ImageIcon resizeImage(int width, int heigth, ImageIcon imageIcon)
	{

		Image img = imageIcon.getImage().getScaledInstance(width, heigth,
				java.awt.Image.SCALE_DEFAULT);
		return new ImageIcon(img);
	}
}
