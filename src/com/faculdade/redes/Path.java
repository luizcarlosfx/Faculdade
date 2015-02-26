package com.faculdade.redes;

import java.util.ArrayList;
import java.util.List;

public class Path
{
	private List<Vertex> vertices = new ArrayList<>();
	private double cost;

	public Path(Vertex root)
	{
		this.vertices.add(root);
	}
	
	public Path(Path path)
	{
		vertices.addAll(path.vertices);
		this.cost = path.cost;
	}
	
	public double getCost()
	{
		return cost;
	}

	public void add(Edge edge)
	{
		this.vertices.add(edge.getTarget());
		this.cost += edge.getWeight();

	}

	public boolean contains(Vertex vertex)
	{
		return vertices.contains(vertex);
	}

	@Override
	public String toString()
	{
		return vertices + " - Custo = " + cost;
	}
}