package com.faculdade.games.m2.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class PaintWindow extends JFrame
{
	private static final long serialVersionUID = 1L;

	JMenuBar menu = new JMenuBar();

	JMenu fileMenu = new JMenu("File");

	JMenuItem newImage = new JMenuItem("New");
	JMenuItem openImage = new JMenuItem("Open...");
	JMenuItem saveImage = new JMenuItem("Save as...");

	JMenu editMenu = new JMenu("Edit");

	JButton chooseColor = new JButton();

	PaintPanel paint;

	JPanel paletePanel;

	JComboBox<PaintTool> modes = new JComboBox<PaintTool>(PaintTool.values());

	JFileChooser fileChooser;

	public PaintWindow()
	{
		setSize(500, 500);

		setLayout(new BorderLayout());

		setMenu();

		paint = new PaintPanel(this);

		add(paint, BorderLayout.CENTER);

		setPaletePanel();

		setResizable(false);

		paint.newImage(1000, 500);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setVisible(true);
	}

	void setPaletePanel()
	{
		paletePanel = new JPanel();

		paletePanel.setBackground(Color.LIGHT_GRAY);

		paletePanel.setLayout(new GridLayout(1, 3, 10, 10));

		setPaintModeComboBox();

		setColorButton();

		setBrushSizeSlider();

		paletePanel.add(chooseColor);

		add(paletePanel, BorderLayout.NORTH);
	}

	void setPaintModeComboBox()
	{
		modes.addActionListener(this::changePaintMode);

		paletePanel.add(modes);

		changePaintMode(null);
	}

	void changePaintMode(ActionEvent e)
	{
		paint.setTool((PaintTool) modes.getSelectedItem());
	}

	void setBrushSizeSlider()
	{
		JSlider slider = new JSlider(1, 50, 5);

		slider.addChangeListener(this::brushSizeChanged);

		paletePanel.add(slider);
	}

	void brushSizeChanged(ChangeEvent e)
	{
		JSlider slider = (JSlider) e.getSource();

		paint.setBrushRadius(slider.getValue());
	}

	void setColorButton()
	{
		chooseColor.setSize(500, 500);

		chooseColor.setBackground(paint.getColor());

		chooseColor.addActionListener(this::chooseColor);
	}

	void chooseColor(ActionEvent e)
	{
		Color color = JColorChooser.showDialog(this, "Choose brush color", paint.getColor());

		chooseColor.setBackground(color);

		paint.setColor(color);
	}

	void setMenu()
	{
		menu.add(fileMenu);

		fileMenu.add(newImage);
		fileMenu.add(openImage);
		fileMenu.add(saveImage);

		openImage.addActionListener(this::openImage);
		newImage.addActionListener(this::newImage);
		saveImage.addActionListener(this::saveImage);

		setJMenuBar(menu);
	}

	void saveImage(ActionEvent e)
	{
		BufferedImage image = paint.getImage();

		FileNameExtensionFilter jpg = new FileNameExtensionFilter("JPG", "jpg");
		FileNameExtensionFilter png = new FileNameExtensionFilter("PNG", "png");

		fileChooser = new JFileChooser("%UserProfile%/Desktop/");
		fileChooser.setFileFilter(jpg);
		fileChooser.addChoosableFileFilter(jpg);
		fileChooser.addChoosableFileFilter(png);

		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		int result = fileChooser.showSaveDialog(this);

		if (result == JFileChooser.APPROVE_OPTION)
		{
			File path = fileChooser.getSelectedFile();

			if (!path.getPath().endsWith(".jpg") && !path.getPath().endsWith(".png"))
			{
				String extension = ".jpg";
				String newPath = path.getPath() + extension;

				path = new File(newPath);
			}

			ImageUtils.saveImage(image, path);
		}
	}

	void newImage(ActionEvent e)
	{
		paint.newImage(500, 400);
	}

	void openImage(ActionEvent e)
	{
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png",
				"gif", "jpeg");

		fileChooser = new JFileChooser("%UserProfile%/Desktop/");

		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		fileChooser.setFileFilter(filter);

		int result = fileChooser.showOpenDialog(this);

		if (result == JFileChooser.APPROVE_OPTION)
		{
			String path = fileChooser.getSelectedFile().getPath();

			paint.loadImage(ImageUtils.getImage(path));
		}
	}

	public static void main(String[] args) throws UnsupportedLookAndFeelException
	{
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new PaintWindow();
	}
}
