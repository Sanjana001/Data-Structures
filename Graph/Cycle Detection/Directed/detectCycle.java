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
	
	// cycle detection using dfs
	void detectCycle() {
		// let's initialize a track array to keep track of elements in dfs search
		boolean[] track = new boolean[this.vertices];
		boolean[] visited = new boolean[this.vertices];
		// fill both the arrays
		Arrays.fill(track, false);
		Arrays.fill(visited, false);
		
		// traverse through eack vertex
		for( int i=0;i<this.vertices;i++ ) {
			if( !visited[i] ) {
				if( dfsUtil( track, visited, i ) ) {
					System.out.println( "Cycle Exists" );
					return ;
				}
			}
		}
		System.out.println( "Cycle Doesn't Exist" );
	}
	
	// apply the dfs search
	boolean dfsUtil( boolean[] track, boolean[] visited, int vertex ) {
		track[vertex] = true;
		visited[vertex] = true;
		// traverse its adjacent nodes
		for( int num: this.adj_list[vertex] ) {
			if( !visited[num] ) {
				if( dfsUtil( track, visited, num ) ) return true;
			} else if( track[num] ) return true;
		}
		track[vertex] = false;
		return false;
	}
}

public class detectCycle {
	public static void main(String[] args) {
		// we are dealing with unweighted and directed graph
		Graph graph = new Graph(6);
		graph.addEdge(5, 0);
		graph.addEdge(4, 1);
		graph.addEdge(3, 1);
		graph.addEdge(3, 5);
		graph.addEdge(2, 3);
		graph.addEdge(5, 2);
		graph.addEdge(4, 0);
		graph.detectCycle();
		
	}
}