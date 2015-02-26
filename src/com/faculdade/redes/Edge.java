package com.faculdade.redes;
public class Edge
{
	private Vertex target;
	private Double weight;

	public Edge(Vertex argTarget, double argWeight)
	{
		target = argTarget;
		weight = argWeight;
	}

	public Vertex getTarget()
	{
		return target;
	}

	public Double getWeight()
	{
		return weight;
	}
}