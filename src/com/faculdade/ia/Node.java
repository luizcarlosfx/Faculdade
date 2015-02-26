/*package com.faculdade.ia;

import java.util.ArrayList;
import java.util.List;

public class Node
{
	private List<Jug> jugs;
	
	private List<Node> childs = new ArrayList<Node>();

	public void addChild(Node node)
	{
		childs.add(node);
	}

	public List<Node> getChilds()
	{
		return childs;
	}

	public int getJarro1()
	{
		return jarro1;
	}

	public void setJarro1(int jarro1)
	{
		this.jarro1 = jarro1;
	}

	public int getJarro2()
	{
		return jarro2;
	}

	public void setJarro2(int jarro2)
	{
		this.jarro2 = jarro2;
	}

	public int getJarro3()
	{
		return jarro3;
	}

	public void setJarro3(int jarro3)
	{
		this.jarro3 = jarro3;
	}
	
	public Node(int jarro1, int jarro2, int jarro3)
	{
		super();
		this.jarro1 = jarro1;
		this.jarro2 = jarro2;
		this.jarro3 = jarro3;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + jarro1;
		result = prime * result + jarro2;
		result = prime * result + jarro3;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (jarro1 != other.jarro1)
			return false;
		if (jarro2 != other.jarro2)
			return false;
		if (jarro3 != other.jarro3)
			return false;
		return true;
	}

}
*/