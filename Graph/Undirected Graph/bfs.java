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
	
	// apply the breadth first search
	void bfs( int vertex ) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[this.vertices]; // to keep track of visited elements
		queue.add( vertex );
		visited[vertex] = true; // mark the given vertex as visited
		// bfs algorithm
		while( queue.isEmpty() != true ) {
			 vertex = queue.remove();
			 System.out.print( vertex + " " );
			 for( int i=0;i<this.vertices;i++ ) {
				 if( this.adj_matrix[vertex][i] && visited[i] != true ) {
					 queue.add(i);
					 visited[i] = true;
				 }
			 }
		}
		System.out.println();
	}
}

public class bfs {
	public static void main(String[] args) {
		// we are dealing with unweighted and undirected graph
		Graph graph = new Graph(5);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);
		graph.addEdge(0, 2);
		graph.addEdge(4, 1);
		graph.addEdge(3, 0);
		System.out.println( "Breadth First Search: " );
		graph.bfs(0);
		
	}
}