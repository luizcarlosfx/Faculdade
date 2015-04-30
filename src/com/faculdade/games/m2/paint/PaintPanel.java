package com.faculdade.games.m2.paint;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PaintPanel extends JPanel implements MouseListener, MouseMotionListener
{
	private static final long serialVersionUID = 1L;

	private BufferedImage image;

	private int brushRadius = 4;

	private Color color = Color.RED;

	private Color color2 = Color.WHITE;

	private JFrame parentFrame;

	private Point lastDragPoint;

	private PaintTool tool;

	Graphics2D imageGraphics;

	private Map<PaintTool, Cursor> cursors = new HashMap<>();

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

	public Color getColor2()
	{
		return color2;
	}

	public void setColor2(Color color2)
	{
		this.color2 = color2;
	}

	public Color getColor(MouseEvent e)
	{
		// System.out.println(mouseButton);
		if (tool == PaintTool.Eraser)
			return getBackground();
		else
			return SwingUtilities.isLeftMouseButton(e) ? color : color2;
	}

	public PaintTool getTool()
	{
		return tool;
	}

	public void setTool(PaintTool mode)
	{
		this.tool = mode;
		updateCursor();
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

		setSize(1000, 1000);
		createCursors();
		updateCursor();
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

	void addPixel(int line, int column, Color color)
	{
		imageGraphics.setColor(color);

		imageGraphics.fillOval(line - brushRadius, column - brushRadius, brushRadius * 2,
				brushRadius * 2);

		repaint();
	}

	private ArrayList<Point> todo = new ArrayList<Point>();

	public synchronized void startFlood(int x, int y, Color[][] pixels, boolean[][] visited,
			Color color)
	{
		todo.clear();

		todo.add(new Point(x, y));

		while (!todo.isEmpty())
		{
			Point p = todo.remove(todo.size() - 1);

			if (!visited[p.x][p.y])
			{
				flood(p.x, p.y, pixels, visited, color);

				/*try
				{
					Thread.sleep(50);
					repaint();
				}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		}
	}
	
	boolean last = false;

	public synchronized void flood(int x, int y, Color[][] pixels, boolean[][] visited, Color color)
	{
		Rect rect = new Rect(x, y);

		Color pixelColor = pixels[x][y];

		rect.grow(pixels, visited, pixelColor);

		/*color = last ? getColor() : getColor2();
		
		last = !last;*/
		
		rect.paint(imageGraphics, color);

		int minX = rect.getMinX();

		int maxX = rect.getMaxX();

		int minY = rect.getMinY();

		int maxY = rect.getMaxY();

		for (int i = minX; i <= maxX; i++)
		{
			for (int j = minY; j <= maxY; j++)
			{
				pixels[i][j] = color;
				visited[i][j] = true;
			}
		}

		// direita
		for (int i = minY; i <= maxY; i++)
		{
			Point p = new Point(maxX + 1, i);

			if (PaintUtils.validPixel(pixels, pixelColor, maxX + 1, i) && !visited[maxX + 1][i])
			{
				todo.add(p);
			}
		}

		// esquerda
		for (int i = minY; i <= maxY; i++)
		{
			Point p = new Point(minX - 1, i);

			if (PaintUtils.validPixel(pixels, pixelColor, minX - 1, i) && !visited[minX - 1][i])
			{
				todo.add(p);
			}
		}

		// cima
		for (int i = minX; i <= maxX; i++)
		{
			Point p = new Point(i, minY - 1);

			if (PaintUtils.validPixel(pixels, pixelColor, i, minY - 1) && !visited[i][minY - 1])
			{
				todo.add(p);
			}
		}

		// baixo
		for (int i = minX; i <= maxX; i++)
		{
			Point p = new Point(i, maxY + 1);

			if (PaintUtils.validPixel(pixels, pixelColor, i, maxY + 1) && !visited[i][maxY + 1])
			{
				todo.add(p);
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		if (tool != PaintTool.Eraser && tool != PaintTool.Brush)
			return;

		int x = e.getX();
		int y = e.getY();
		/*
		 * System.out.println(e.getButton());
		 */

		Color color = getColor(e);

		if (lastDragPoint != null)
		{
			List<Point> linePixels = PaintUtils.getPixelsInLine(lastDragPoint.x, lastDragPoint.y,
					x, y);

			for (Point point : linePixels)
			{
				addPixel(point.x, point.y, color);
			}
		}
		else
		{
			addPixel(x, y, color);
		}

		lastDragPoint = new Point(x, y);
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{

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
		int x = e.getX();

		int y = e.getY();

		Color selectedColor = getColor(e);

		if (tool == PaintTool.Eraser || tool == PaintTool.Brush)
			addPixel(x, y, selectedColor);
		else
		{
			new Thread(() -> {
				long timeInit = System.currentTimeMillis();

				Color[][] pixels = ImageUtils.getPixels(image);

				boolean[][] visited = new boolean[pixels.length][pixels[0].length];

				startFlood(x, y, pixels, visited, selectedColor);

				repaint();

				long timeFinal = System.currentTimeMillis();

				System.out.println("Tempo: " + (timeFinal - timeInit) + " millisegundos");
			}).start();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO: INÚTIL
	}

	void createCursors()
	{
		cursors.put(PaintTool.Fill, Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		cursors.put(PaintTool.Eraser, Cursor.getDefaultCursor());

		cursors.put(PaintTool.Brush, Cursor.getDefaultCursor());
	}

	void updateCursor()
	{
		setCursor(cursors.get(tool));
	}
}
