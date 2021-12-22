import java.util.*;

class Node{
	int vertex, parent;
	Node( int vertex, int parent ){
		this.vertex = vertex;
		this.parent = parent;
	}
}

class Graph{
	int vertices; // no of vertices
	LinkedList<Integer> adj_list[]; // adjacency list
	
	Graph( int vertices ){
		this.vertices = vertices;
		this.adj_list = new LinkedList[this.vertices];
		initializeList();
	}
	
	// initialize the adjacency list
	void initializeList() {
		for( int i=0;i<this.vertices;i++ ) {
			this.adj_list[i] = new LinkedList<Integer>();
		}
	}
	
	// add edge to the graph
	@SuppressWarnings("unchecked")
	void addEdge( int u, int v ) {
		this.adj_list[u].add( v );
	}
	
	// dfs algorithm using recursion
	void dfs() {
		boolean[] visited = new boolean[this.vertices];
		Arrays.fill(visited, false);
		// traverse from the each vertex
		// as it might be possible that the given graph is disconnected
		for( int i=0;i<this.vertices;i++ ) {
			if( !visited[i] ) {
				dfsUtil( visited, i );
			}
		}
	}
	
	// apply the depth first search algorithm
	void dfsUtil( boolean[] visited, int vertex ) {
		visited[vertex] = true;
		System.out.println( vertex );
		for( int num: this.adj_list[vertex] ) {
			if( !visited[num] ) {
				dfsUtil( visited, num );
			}
		}
	}
}

public class dfsUsingStack {
	public static void main(String[] args) {
		// we are dealing with unweighted and directed graph
		Graph graph = new Graph(5);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);
		graph.addEdge(0, 2);
		graph.addEdge(4, 1);
		graph.addEdge(3, 0);
		// traverse the graph from depth
		graph.dfs();
	}
}