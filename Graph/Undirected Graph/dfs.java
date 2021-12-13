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
	
	// depth first search
	void dfs( int vertex ) {
		// iterative approach
		boolean[] visited = new boolean[this.vertices]; // to keep track of the visited elements
		Stack<Integer> stack = new Stack<Integer>();
		stack.push( vertex );
		visited[vertex] = true;
		// dfs algorithm
		while( stack.size() != this.vertices ) {
			 vertex = stack.peek();
			 for( int i=0;i<this.vertices;i++ ) {
				 if( this.adj_matrix[vertex][i] && visited[i] != true ) {
					 stack.push( i );
					 visited[i] = true;
					 break;
				 }
			 }
		}
		System.out.println( stack );
	}
}

public class dfs {
	public static void main(String[] args) {
		// we are dealing with unweighted and undirected graph
		Graph graph = new Graph(5);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);
		graph.addEdge(0, 2);
		graph.addEdge(4, 1);
		graph.addEdge(3, 0);
		System.out.println( "Depth First Search: " );
		graph.dfs( 3 );
		
	}
}