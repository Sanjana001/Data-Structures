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
		this.adj_list[v].add( u );
	}
	
	// check for bipartite using dfs
	void checkBipartite() {
		// let's initialize a color array
		int[] color = new int[this.vertices];
		Arrays.fill(color, -1);
		
		// traverse through each vertex
		for( int i=0;i<this.vertices;i++ ) {
			if( color[i] == -1 ) {
				if( !dfsUtil( i, color ) ) {
					System.out.println( "Not Bipartite" );
					return ;
				}
			}
		}
		System.out.println( "Bipartite" );
	}
	
	// apply the dfs search
	boolean dfsUtil( int vertex, int[] color ) {
		if( color[vertex] == -1 ) color[vertex] = -1;
		// traverse its adjacent nodes
		for( int num: this.adj_list[vertex] ) {
			if( color[num] == -1 ) {
				color[num] = 1 - color[vertex];
				if( !dfsUtil( num, color ) ) return false;
			} else if( color[num] == color[vertex] ) return false;
		}
		return true;
	}
}

public class dfs{
	public static void main(String[] args) {
		// we are dealing with unweighted and directed graph
		Graph graph = new Graph(6);
		graph.addEdge(5, 0);
		graph.addEdge(4, 1);
		graph.addEdge(3, 1);
		graph.addEdge(2, 3);
		graph.addEdge(5, 2);
		graph.addEdge(4, 0);
		graph.checkBipartite();
		
	}
}