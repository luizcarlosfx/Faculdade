package com.faculdade.computacaografica.lab8;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Convolution1 extends JFrame
{
	private JPanel contentPane;

	private BufferedImage image;

	private String imgFileName = "images/capture.png";

	private float[] convolutionMatrix2 =
		{ 0, 0, 0, 0, 1, 0, 0, 0, 0 };

	private int[][] convolutionMatrix =
		{
			{ 1, 0, 1 },
			{ 0, 1, 0 },
			{ 1, 0, 1 } };

	public Convolution1() throws IOException
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(1, 3));
		setContentPane(contentPane);

		loadImage();

		int[][] matrix = convertTo2DUsingGetRGB(image);

		JLabel imageLabel = new JLabel(new ImageIcon(image));

		getContentPane().add(imageLabel);


		BufferedImage dstbimg = new BufferedImage(image.getWidth(), image.getHeight(),
				BufferedImage.TYPE_INT_RGB);

		Kernel kernel = new Kernel(3, 3, convolutionMatrix2);

		ConvolveOp cop = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);

		cop.filter(image, dstbimg);

		JLabel newImageLabel = new JLabel(new ImageIcon(dstbimg));

		getContentPane().add(newImageLabel);
		
		int[][] newMatrix = calculateConvolution(matrix);

		BufferedImage newImage = createImageFromMatrix(newMatrix);

		contentPane.add(new JLabel(new ImageIcon(newImage)));
	}

	public static void main(String[] args) throws IOException
	{
		Convolution1 frame = new Convolution1();
		frame.setVisible(true);
	}

	private int move(int position, int step, int max)
	{
		return (max + position + step) % max;
	}

	private int[][] calculateConvolution(int[][] matrix)
	{
		int[][] newMatrix = new int[matrix.length][matrix[0].length];

		int lineLength = matrix.length;

		int columnLength = matrix[0].length;

		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				int[][] neighbors = new int[convolutionMatrix.length][convolutionMatrix[0].length];

				// top left
				neighbors[0][0] = matrix[move(i, -1, lineLength)][move(j, -1, columnLength)];

				// top center
				neighbors[0][1] = matrix[move(i, -1, lineLength)][j];

				// top right
				neighbors[0][2] = matrix[move(i, -1, lineLength)][move(j, +1, columnLength)];

				// middle left
				neighbors[1][0] = matrix[i][move(j, -1, columnLength)];

				// middle center
				neighbors[1][1] = matrix[i][j];

				// middle right
				neighbors[1][2] = matrix[i][move(j, +1, columnLength)];

				// bottom left
				neighbors[2][0] = matrix[move(i, +1, lineLength)][move(j, -1, columnLength)];

				// bottom center
				neighbors[2][1] = matrix[move(i, +1, lineLength)][j];

				// bottom right
				neighbors[2][2] = matrix[move(i, +1, lineLength)][move(j, +1, columnLength)];

				// calculate the new value
				newMatrix[i][j] = calculateNewValue(neighbors, convolutionMatrix);
			}
		}

		return newMatrix;
	}

	private int calculateNewValue(int[][] neighbors, int[][] convolutionMatrix)
	{
		int total = 0;

		for (int i = 0; i < neighbors.length; i++)
		{
			for (int j = 0; j < neighbors[i].length; j++)
			{
				total += (neighbors[i][j] * convolutionMatrix[i][j]);
			}
		}

		return total;
	}

	private int[][] convertTo2DUsingGetRGB(BufferedImage image)
	{
		int width = image.getWidth();
		int height = image.getHeight();

		int[][] result = new int[height][width];

		for (int row = 0; row < height; row++)
		{
			for (int col = 0; col < result[0].length; col++)
			{
				result[row][col] = image.getRGB(col, row);
			}
		}

		return result;
	}

	public BufferedImage createImageFromMatrix(int[][] matrix)
	{
		BufferedImage image = new BufferedImage(matrix[0].length, matrix.length,
				BufferedImage.TYPE_INT_RGB);

		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				image.setRGB(j, i, matrix[i][j]);
			}
		}

		return image;
	}

	public void loadImage() throws IOException
	{
		URL url = getClass().getClassLoader().getResource(imgFileName);

		image = ImageIO.read(url);
	}
}
