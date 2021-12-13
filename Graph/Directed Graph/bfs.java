import java.util.*;

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
	
	// apply the breadth first search
	void bfs( int vertex ) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[this.vertices]; // to keep track of visited elements
		queue.add( vertex );
	    visited[vertex] = true;
	    // bfs algorithm
	    while( queue.size() != 0 ) {
	    	vertex = queue.remove();
	    	System.out.print( vertex + " " );
	    	for( int num : this.adj_list[vertex] ) {
	    		if( visited[num] != true ) {
	    			visited[num] = true;
	    			queue.add( num );
	    		}
	    	}
	    }
	}
	
}

public class bfs {
	public static void main(String[] args) {
		// we are dealing with unweighted and directed graph
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		System.out.println( "Breadth First Search" );
		graph.bfs(2);
	}
}