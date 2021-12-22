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
	
	// display the graph
	void print() {
		for( int i=0;i<this.vertices;i++ ) {
			System.out.print( i );
			for( int num : this.adj_list[i] ) {
				System.out.print( "->" + num );
			}
			System.out.println();
		}
	}
}

public class list {
	public static void main(String[] args) {
		// we are dealing with unweighted and directed graph
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