package com.faculdade.games.m2.paint;

/*import java.awt.Color;
 import java.awt.Graphics;
 import java.awt.Graphics2D;
 import java.awt.Point;
 import java.awt.RenderingHints;
 import java.awt.event.MouseEvent;
 import java.awt.event.MouseListener;
 import java.awt.event.MouseMotionListener;
 import java.awt.image.BufferedImage;
 import java.util.List;

 import javax.swing.JFrame;
 import javax.swing.JPanel;

 public class PaintPanel extends JPanel implements MouseListener, MouseMotionListener
 {
 private Color[][] pixels;

 private int brushRadius = 4;

 private Color color = Color.RED;

 private JFrame parentFrame;

 private Point lastDragPoint;

 private PaintMode mode;

 public int getBrushRadius()
 {
 return brushRadius;
 }

 public void setBrushRadius(int brushRadius)
 {
 this.brushRadius = brushRadius;
 }

 public Color getColor()
 {
 return color;
 }

 public void setColor(Color color)
 {
 this.color = color;
 }

 public PaintMode getMode()
 {
 return mode;
 }

 public void setMode(PaintMode mode)
 {
 this.mode = mode;
 }

 public PaintPanel(JFrame parentFrame)
 {
 this.parentFrame = parentFrame;

 int width = getWidth();

 int height = getHeight();

 pixels = new Color[height][width];

 iteratePixels((color, line, column) -> {
 pixels[line][column] = Color.RED;
 });

 addMouseListener(this);
 addMouseMotionListener(this);
 }

 public void newImage(int width, int height)
 {
 pixels = new Color[width][height];

 setSize(width, height);

 parentFrame.setSize(width, height + 70);

 iteratePixels((color, line, column) -> {
 pixels[line][column] = getBackground();
 });


 repaint();
 }

 public void loadImage(BufferedImage image)
 {
 pixels = ImageUtils.pixels(image);

 parentFrame.setSize(image.getWidth(), image.getHeight() + 70);

 repaint();
 }

 public BufferedImage getImage()
 {
 BufferedImage img = new BufferedImage(pixels.length, pixels[0].length, BufferedImage.TYPE_INT_RGB);

 ImageUtils.setPixels(img, pixels);

 return img;
 }

 void iteratePixels(PixelIterator iterator)
 {
 for (int line = 0; line < pixels.length; line++)
 {
 for (int column = 0; column < pixels[line].length; column++)
 {
 iterator.iterate(pixels[line][column], line, column);
 }
 }
 }

 @Override
 protected void paintComponent(Graphics g)
 {
 super.paintComponent(g);

 // System.out.println(g.getClass());

 Graphics2D graphics = (Graphics2D) g;

 graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
 RenderingHints.VALUE_ANTIALIAS_ON);

 iteratePixels((color, line, column) -> {
 paintPixel(graphics, color, line, column);
 });
 }

 void paintPixel(Graphics2D g, Color color, int line, int column)
 {
 g.setColor(color);
 g.fillRect(line, column, 1, 1);
 }

 void addPixel(int line, int column)
 {
 Color targetColor = mode == PaintMode.Brush ? color : getBackground();

 for (int i = line - brushRadius; i < line + brushRadius; i++)
 {
 for (int j = column - brushRadius; j < column + brushRadius; j++)
 {
 Point p1 = new Point(line, column);

 boolean validColumn = i < pixels.length && i >= 0;
 boolean validLine = j < pixels[0].length && j >= 0;

 if (p1.distance(i, j) < brushRadius && validColumn && validLine)
 {
 pixels[i][j] = targetColor;
 }
 }
 }

 repaint();
 }

 @Override
 public void mouseDragged(MouseEvent e)
 {
 int x = e.getX();
 int y = e.getY();

 if (lastDragPoint != null)
 {
 List<Point> linePixels = PaintUtils.getPixelsInLine(lastDragPoint.x, lastDragPoint.y,
 x, y);

 for (Point point : linePixels)
 {
 addPixel(point.x, point.y);
 }
 }
 else
 {
 addPixel(x, y);
 }

 lastDragPoint = new Point(x, y);
 }

 @Override
 public void mouseMoved(MouseEvent e)
 {

 }

 @Override
 public void mouseClicked(MouseEvent e)
 {
 int x = e.getX();

 int y = e.getY();

 addPixel(x, y);
 }

 @Override
 public void mousePressed(MouseEvent e)
 {
 }

 @Override
 public void mouseReleased(MouseEvent e)
 {
 lastDragPoint = null;
 }

 @Override
 public void mouseEntered(MouseEvent e)
 {
 }

 @Override
 public void mouseExited(MouseEvent e)
 {
 }
 }
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintPanel extends JPanel implements MouseListener, MouseMotionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BufferedImage image;

	private int brushRadius = 4;

	private Color color = Color.RED;

	private JFrame parentFrame;

	private Point lastDragPoint;

	private PaintMode mode;

	Graphics2D imageGraphics;

	public int getBrushRadius()
	{
		return brushRadius;
	}

	public void setBrushRadius(int brushRadius)
	{
		this.brushRadius = brushRadius;
	}

	public Color getColor()
	{
		return color;
	}

	public void setColor(Color color)
	{
		this.color = color;
	}

	public PaintMode getMode()
	{
		return mode;
	}

	public void setMode(PaintMode mode)
	{
		this.mode = mode;
	}

	void setImage(BufferedImage image)
	{
		this.image = image;
		this.imageGraphics = (Graphics2D) image.getGraphics();
	}

	public PaintPanel(JFrame parentFrame)
	{
		this.parentFrame = parentFrame;
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void newImage(int width, int height)
	{
		Color[][] pixels = new Color[width][height];

		setSize(width, height);

		parentFrame.setSize(width, height + 70);

		for (int i = 0; i < pixels.length; i++)
		{
			for (int j = 0; j < pixels[i].length; j++)
			{
				pixels[i][j] = getBackground();
			}
		}

		BufferedImage img = new BufferedImage(pixels.length, pixels[0].length,
				BufferedImage.TYPE_INT_RGB);

		ImageUtils.setPixels(img, pixels);

		setImage(img);

		repaint();
	}

	public void loadImage(BufferedImage image)
	{
		setImage(image);

		parentFrame.setSize(image.getWidth(), image.getHeight() + 70);

		repaint();
	}

	public BufferedImage getImage()
	{
		return this.image;
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		// System.out.println(g.getClass());

		Graphics2D graphics = (Graphics2D) g;

		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		graphics.drawImage(image, 0, 0, null);
	}

	void addPixel(int line, int column)
	{
		Color targetColor = mode == PaintMode.Brush ? color : getBackground();
		
		imageGraphics.setColor(targetColor);

		imageGraphics.fillOval(line - brushRadius, column - brushRadius, brushRadius * 2,
				brushRadius * 2);

		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		int x = e.getX();
		int y = e.getY();

		if (lastDragPoint != null)
		{
			List<Point> linePixels = PaintUtils.getPixelsInLine(lastDragPoint.x, lastDragPoint.y,
					x, y);

			for (Point point : linePixels)
			{
				addPixel(point.x, point.y);
			}
		}
		else
		{
			addPixel(x, y);
		}

		lastDragPoint = new Point(x, y);
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		int x = e.getX();

		int y = e.getY();

		addPixel(x, y);
	}
	
	@Override
	public void mouseReleased(MouseEvent e)
	{
		lastDragPoint = null;
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		//TODO: IN�TIL
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		//TODO: IN�TIL
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		//TODO: IN�TIL
	}
}