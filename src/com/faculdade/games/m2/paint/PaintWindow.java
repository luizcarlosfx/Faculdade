package com.faculdade.games.m2.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.Box.Filler;
import javax.swing.event.ChangeEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class PaintWindow extends JFrame implements KeyListener
{
	private static final long serialVersionUID = 1L;

	JMenuBar menu = new JMenuBar();

	JMenu fileMenu = new JMenu("File");

	JMenuItem newImage = new JMenuItem("New");
	JMenuItem openImage = new JMenuItem("Open...");
	JMenuItem saveImage = new JMenuItem("Save as...");

	JButton chooseColor = new JButton();

	JButton chooseColor2 = new JButton();

	PaintPanel paint;

	JPanel paletePanel;

	JComboBox<PaintTool> tools = new JComboBox<PaintTool>(PaintTool.values());

	JFileChooser fileChooser;

	public PaintWindow()
	{
		setSize(500, 500);

		setLayout(new BorderLayout());

		setMenu();

		paint = new PaintPanel(this);

		newImage(null);

		add(paint, BorderLayout.CENTER);

		setPaletePanel();

		setResizable(false);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setVisible(true);

		addKeyListener(this);
	}

	void setPaletePanel()
	{
		paletePanel = new JPanel();

		paletePanel.setBackground(Color.LIGHT_GRAY);

		paletePanel.setLayout(new GridLayout(1, 4, 10, 10));

		setPaintModeComboBox();

		setColorButtons();

		setBrushSizeSlider();

		paletePanel.add(chooseColor);

		paletePanel.add(chooseColor2);

		add(paletePanel, BorderLayout.NORTH);
	}

	void setPaintModeComboBox()
	{
		tools.addActionListener(this::changePaintMode);

		paletePanel.add(tools);

		changePaintMode(null);
	}

	void changePaintMode(ActionEvent e)
	{
		paint.setTool((PaintTool) tools.getSelectedItem());
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

	void setColorButtons()
	{
		chooseColor.setBackground(paint.getColor());

		chooseColor.addActionListener(this::chooseColor);

		chooseColor2.setBackground(paint.getColor2());

		chooseColor2.addActionListener(this::chooseColor);
	}

	void chooseColor(ActionEvent e)
	{
		JButton source = (JButton) e.getSource();

		boolean color1 = source == chooseColor;

		Color color = JColorChooser.showDialog(this, "Choose brush color",
				color1 ? paint.getColor() : paint.getColor2());

		source.setBackground(color);

		if (color1)
		{
			paint.setColor(color);
		}
		else
		{
			paint.setColor2(color);
		}
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
		paint.newImage(1024, 650);
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

	@Override
	public void keyTyped(KeyEvent e)
	{
		/*
		 * System.out.println("key pressed"); if(e.getKeyCode() ==
		 * KeyEvent.VK_B) { System.out.println("b caralho");
		 * tools.setSelectedItem(PaintTool.Brush); } else if(e.getKeyCode() ==
		 * KeyEvent.VK_E) { tools.setSelectedItem(PaintTool.Eraser); } else
		 * if(e.getKeyCode() == KeyEvent.VK_F) {
		 * tools.setSelectedItem(PaintTool.Fill); }
		 */
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		System.out.println("key pressed");
		/*
		 * System.out.println("key pressed"); if(e.getKeyCode() ==
		 * KeyEvent.VK_B) { System.out.println("b caralho");
		 * tools.setSelectedItem(PaintTool.Brush); } else if(e.getKeyCode() ==
		 * KeyEvent.VK_E) { tools.setSelectedItem(PaintTool.Eraser); } else
		 * if(e.getKeyCode() == KeyEvent.VK_F) {
		 * tools.setSelectedItem(PaintTool.Fill); }
		 */
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}
}
