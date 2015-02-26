package com.faculdade.redes;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JComboBox<Vertex> from;
	private JComboBox<Vertex> to;
	private Vertex[] values;

	public static void main(String[] args) throws UnsupportedLookAndFeelException
	{
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new DijkstraWindow();
	}

	public DijkstraWindow()
	{
		buildVerticesAndAdjacenseList();
		buildWindow();
	}

	public void buildWindow()
	{
		from = new JComboBox<Vertex>(values);
		to = new JComboBox<Vertex>(values);

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

		final JLabel shortestPath = new JLabel("Melhor Caminho: ");
		contentPane.add(shortestPath);
		shortestPath.setBounds(10, 230, 305, 25);

		JButton action = new JButton("Buscar Melhor Caminho");
		contentPane.add(action);
		action.setBounds(10, 260, 305, 25);

		action.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Vertex fromVertex = from.getItemAt(from.getSelectedIndex());
				Vertex toVertex = to.getItemAt(to.getSelectedIndex());
				shortestPath.setText("Melhor Caminho: " + fromVertex.distanceTo(toVertex).toString());
			}
		});
		
		setSize(332, 325);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

	private void buildVerticesAndAdjacenseList()
	{
		Vertex u = new Vertex("U");
		Vertex v = new Vertex("V");
		Vertex w = new Vertex("W");
		Vertex x = new Vertex("X");
		Vertex y = new Vertex("Y");
		Vertex z = new Vertex("Z");

		values = new Vertex[]
			{ u, v, w, x, y, z };

		u.setAdjacencies(new Edge(v, 2), new Edge(x, 1));

		v.setAdjacencies(new Edge(u, 2), new Edge(w, 2), new Edge(x, 3));

		w.setAdjacencies(new Edge(u, 1), new Edge(v, 2), new Edge(x, 3), new Edge(y, 1));

		x.setAdjacencies(new Edge(v, 3), new Edge(w, 3), new Edge(y, 1), new Edge(z, 5));

		y.setAdjacencies(new Edge(w, 1), new Edge(x, 1), new Edge(z, 2));

		w.setAdjacencies(new Edge(x, 5), new Edge(y, 2));
	}

	public static ImageIcon resizeImage(int width, int heigth, ImageIcon imageIcon)
	{

		Image img = imageIcon.getImage().getScaledInstance(width, heigth,
				java.awt.Image.SCALE_DEFAULT);
		return new ImageIcon(img);
	}
}
