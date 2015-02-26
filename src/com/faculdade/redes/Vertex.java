package com.faculdade.redes;

import java.util.ArrayList;
import java.util.List;

public class Vertex
{
	private String name;
	private List<Edge> adjacencies = new ArrayList<>();
	private static Path shortestPath;	// Auxiliary variable to store the shortest path

	public Vertex(String argName)
	{
		name = argName;
	}

	public void setAdjacencies(Edge... edges)
	{
		for (Edge edge : edges)
		{
			adjacencies.add(edge);
		}
	}

	public Path distanceTo(Vertex v)
	{
		// Reset the shortest path variable
		shortestPath =  null;
		
		// Recalculate the shortest path
		computePathTo(new Path(this), v);
		return shortestPath;
	}

	private void computePathTo(Path path, Vertex v)
	{
		if (shortestPath != null && path.getCost() > shortestPath.getCost())
			return;
		
		if(this.equals(v))
		{
			shortestPath = path;
		}
		
		for (Edge edge : adjacencies)
		{
			if (!path.contains(edge.getTarget()))
			{
				Path newPath = new Path(path);
				newPath.add(edge);
				edge.getTarget().computePathTo(newPath, v);
			}
		}		
	}

	public String toString()
	{
		return name;
	}

	@Override
	public boolean equals(Object obj)
	{
		// if the obj is really a vertex
		if(obj.getClass() == Vertex.class)
		{
			Vertex ob = (Vertex) obj;
			return name.equals(ob.name);
		}
		// If we're here they aren't equals
		return false;
	}
}