package com.faculdade.games.m1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;

@SuppressWarnings("serial")
public class Image2Panel extends Panel2D
{
	@Override
	protected void paintComponent2D(Graphics2D graphics)
	{
		// TODO Auto-generated method stub
		super.paintComponent2D(graphics);

		Dimension size = new Dimension(250, 220);

		int width = getWidth();

		int height = getHeight();

		int quarterWidth = width / 4;

		int quarterHeight = height / 4;

		Point first = new Point(quarterWidth - (size.width / 2), quarterHeight - (size.height / 2));

		Point second = new Point(quarterWidth * 3 - (size.width / 2), quarterHeight
				- (size.height / 2));

		Point third = new Point(quarterWidth - (size.width / 2), quarterHeight * 3
				- (size.height / 2));

		Point fourth = new Point(quarterWidth * 3 - (size.width / 2), quarterHeight * 3
				- (size.height / 2));

		Color white = Color.white;
		Color blue = new Color(79, 129, 189);
		Color yellow = Color.yellow;
		Color black = Color.black;
		Color darkYellow = new Color(205, 205, 0);

		Rectangle box = new Rectangle(10, 10, width - 20, height - 20);

		drawShape(graphics, box, white, blue);

		drawSmiley(graphics, first, size, white, blue, white, blue, true);
		drawSmiley(graphics, second, size, white, blue, white, blue, false);
		drawSmiley(graphics, third, size, yellow, black, darkYellow, black, true);
		drawSmiley(graphics, fourth, size, yellow, black, darkYellow, black, false);

	}

	void drawSmiley(Graphics2D graphics, Point point, Dimension size, Color color,
			Color borderColor, Color eyeColor, Color eyeBorderColor, boolean smile)
	{
		Ellipse2D.Float face = new Ellipse2D.Float(point.x, point.y, size.width, size.height);

		Point center = new Point((int) face.getCenterX(), (int) face.getCenterY());

		drawShape(graphics, face, color, borderColor);

		Dimension eyeSize = new Dimension(size.width / 8, size.height / 8);

		Point rightEyePoint = new Point(center);

		rightEyePoint.translate(40, -40);

		Point leftEyePoint = new Point(center);

		leftEyePoint.translate(-40, -40);

		Ellipse2D.Float rightEye = new Ellipse2D.Float(rightEyePoint.x, rightEyePoint.y,
				eyeSize.width, eyeSize.height);

		Ellipse2D.Float leftEye = new Ellipse2D.Float(leftEyePoint.x, leftEyePoint.y,
				eyeSize.width, eyeSize.height);

		drawShapeOnCenter(graphics, leftEye, eyeColor, eyeBorderColor);
		drawShapeOnCenter(graphics, rightEye, eyeColor, eyeBorderColor);

		Dimension mouthSize = new Dimension((size.width / 3) * 2, (size.width / 3) * 2);

		Point mouthPosition = new Point(center);

		if (smile)
		{
			mouthPosition.translate(0, -10);
		}
		else
		{
			mouthPosition.translate(0, 125);
		}

		float startAngle = smile ? 225 : 45;
		float extents = 90;

		Arc2D.Float mouth = new Arc2D.Float(mouthPosition.x, mouthPosition.y, mouthSize.width,
				mouthSize.height, startAngle, extents, Arc2D.OPEN);

		drawShapeOnCenter(graphics, mouth, color, borderColor);
	}

	void drawShape(Graphics2D graphics, Shape shape, Color fill, Color border)
	{
		graphics.setColor(fill);

		graphics.fill(shape);

		graphics.setColor(border);

		graphics.draw(shape);
	}

	void drawShapeOnCenter(Graphics2D graphics, Shape shape, Color fill, Color border)
	{
		Rectangle bounds = shape.getBounds();

		graphics.translate(-bounds.width / 2, -bounds.height / 2);

		drawShape(graphics, shape, fill, border);

		graphics.translate(bounds.width / 2, bounds.height / 2);
	}
}
