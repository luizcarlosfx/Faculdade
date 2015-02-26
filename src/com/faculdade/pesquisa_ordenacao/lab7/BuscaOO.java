package com.faculdade.pesquisa_ordenacao.lab7;

 import java.util.List;
import java.util.ArrayList;
 
   
public class BuscaOO
{


  
//Busca em profundidade a partir de um vértice origem   
//vértices estão númerados de 0 até n-1   
// REPRESENTAÇÃO DO GRAFO (A - B) (A - C) (B - D) (B - E) (D-E)
//    A ---------B
//    !          !  .
//    !          !   .    
//    C----------D ----E
public static void main(String args[])
	{
	int G[][] ={{0,1,1,0,0},
		        {1,0,0,1,0},
		        {1,0,0,1,0},
		        {0,1,1,0,1},
		        {0,0,0,1,0}};//grafo representado por matriz de adjacência     
     
	 
    int n=5; //número de vértices neste grafo   


     Info v1, v2, v3, v4, v5;

	 v1= new Info("A");
	 v2= new Info("B");
	 v3= new Info("C");
	 v4= new Info("D");
	 v5= new Info("E");
     List<Info> vertices = new ArrayList<Info>();
	 vertices.add(v1);
	 vertices.add(v2);
	 vertices.add(v3);
	 vertices.add(v4);
	 vertices.add(v5);

	 Grafo grafo = new Grafo(n, G,vertices);

	  grafo.busca();
	  
	  GrafoLargura grafolarg = new GrafoLargura(n, G, vertices);
	  
	  grafolarg.busca();
      

	}
 
 
} 

///////////////////////////
class Info

{
	String valor;
	public Info(String v)
	{
		valor=v;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return valor;
	}

}
/////////////////////////////
class Grafo

{
	int num_vertices;
	int [][] MatAdj;
	List <Info> vertices;
	boolean[] visitado;
	public Grafo(int n, int G[][], List<Info> ver)
	{
		//inicilizações
		MatAdj = new int[n][n];
		visitado = new boolean[n];

		vertices = new ArrayList<Info>();
		num_vertices=n;

		// Armazenamento dos vertices
		vertices=ver;
		
		
		//for (int i=0;i<n ;i++ )
		//	for (int j=0;j<n;j++ )
		//		MatAdj[i][j]=G[i][j]; 

			//OU
		 

		 // Armazenamento da matriz de adjacencia
				MatAdj=G;

		for (int k=0;k<n ;k++ )
			visitado[k]=false;

	}

	public void busca()
	{
		for (int v=0;v<num_vertices ;v++ )
			if(visitado[v]==false)
				imprime(v);
	}
	
	public void imprime(int origem)
	{ 
		visitado[origem]=true;
		//Imprimir o vertice
		System.out.println(vertices.get(origem));

		for (int i = 0; i<num_vertices;i++)

		{
			if((MatAdj[origem][i]==1) &&(visitado[i]==false))
				imprime(i); // i aponta p/ o prox vertice a ser visitado
		}
	
	}

}