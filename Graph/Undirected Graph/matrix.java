import java.util.*;

class Graph{
	int vertices; // no of vertices
	boolean[][] adj_matrix; // adjacency matrix
	
	Graph( int vertices ){
		this.vertices = vertices;
		this.adj_matrix = new boolean[this.vertices][this.vertices];
	}
	
	// add edge to the graph
	void addEdge( int u, int v ) {
		this.adj_matrix[u][v] = true;
		this.adj_matrix[v][u] = true;
	}
	
	// display the graph
	void print() {
		for( int i=0;i<this.vertices;i++ ) {
			System.out.print( i  );
			for( int j=0;j<this.vertices;j++ ){
				if( this.adj_matrix[i][j] )
					System.out.print( "->" + j );
			}
			System.out.println();
		}
	}
}

public class matrix {
	public static void main(String[] args) {
		// we are dealing with unweighted and undirected graph
		Graph graph = new Graph(5);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);
		graph.addEdge(0, 2);
		graph.addEdge(4, 1);
		graph.addEdge(3, 0);
		graph.print();
		
	}
}