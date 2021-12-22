import java.util.*;

class Node{
	int parent, vertex;
	Node( int vertex, int parent ){
		this.vertex = vertex;
		this.parent = parent;
	}
}

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
	
	// detect cycle in graph
	void detectCycle() {
		boolean[] visited = new boolean[this.vertices];
		Arrays.fill(visited, false);
		// traverse the graph through each vertex
		// as it might be possible that the given graph is a disconnected one
		// or the graph whose all components are not connected to others
		for( int i=0;i<this.vertices;i++ ) {
			if( visited[i] != true ) {
				if( dfs( visited, i, -1 ) ) {
					// let's assume that the parent of the root node is -1
					System.out.println( "Cycle Exists" );
					return ;
				}
			}
		}
		System.out.println( "Cycle Doesn't Exist" );
	}
	
	// apply the breadth first search algorithm
	boolean dfs( boolean[] visited, int vertex, int parent ) {
		visited[vertex] = true;
		// run loop for the adjacent nodes of vertex
		for( int i=0;i<this.vertices;i++ ) {
			if( this.adj_matrix[vertex][i] ) {
				if( !visited[i] ) {
					if( dfs(visited, i, vertex) ) return true;
				} else {
					if( i != parent ) return true;
				}
			}
		}
		return false;
	}
}

public class cycleDfs {
	public static void main(String[] args) {
		// we are dealing with unweighted and undirected graph
		Graph graph = new Graph(8);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);
		graph.addEdge(0, 2);
		graph.addEdge(4, 1);
		graph.addEdge(3, 0);
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		graph.addEdge(7, 5);
		// let's check whether there exist any cycle in the graph or not
		// for detecting the cycle we are going to use the bfs
		graph.detectCycle();
	}
}