import java.util.*;

class Graph {
	int vertices; // no of vertices;
	ArrayList<Integer> list[]; // adjacency list;
	Graph( int vertices ){
		this.vertices = vertices;
		this.list = new ArrayList[this.vertices];
		for( int i=0;i<this.vertices;i++ )
			this.list[i] = new ArrayList<Integer>();
	}
	
	void addEdge( int u, int v ) {
		this.list[u].add(v);
	}
	
	void algorithm() {
		boolean[] visited = new boolean[this.vertices]; // visited array
		Arrays.fill(visited, false);
		// find the topological Sort
		Stack<Integer> stack = new Stack<Integer>();
		for( int i=1;i<this.vertices;i++ ) {
			if( !visited[i] )
				topologicalSort( i, visited, stack );
		}
		// transpose the adjacency list
		ArrayList<Integer> transpose[] = new ArrayList[this.vertices];
		transpose( transpose, visited );
		//
		while( !stack.isEmpty() ) {
			int node = stack.pop();
			if( !visited[node] ) {
				System.out.print( "SSC: ");
				reverseDFS( node, transpose, visited );
				System.out.println();
			}
		}
	}
	
	void reverseDFS( int node, ArrayList<Integer>[] list, boolean[] visited ) {
		visited[node] = true;
		System.out.print( node + " " );
		for( int num : list[node] ) {
			if( !visited[num] )
				reverseDFS( num, list, visited );
		}
	}
	
	void transpose( ArrayList<Integer>[] transpose, boolean[] visited ) {
		for( int i=0;i<this.vertices;i++ )
			transpose[i] = new ArrayList<Integer>();
		for( int i=0;i<this.vertices;i++ ) {
			visited[i] = false;
			for( int num : this.list[i] ) {
				transpose[num].add( i );
			}
		}
	}
	
	void topologicalSort( int node, boolean[] visited, Stack<Integer> stack ) {
		visited[node] = true;
		for( int num : this.list[node] ) {
			if( !visited[num] ) {
				topologicalSort( num, visited, stack );
			}
		}
		stack.push(node);
	}
	
	void display() {
		for( int i=0;i<this.vertices;i++ ) {
			System.out.print( i + "->" );
			for( int num : this.list[i] )
				System.out.print( " " + num );
			System.out.println();
		}
	}
}

public class kosarajus {
	public static void main(String[] args) {
		// kosaraju's algorithm
		// finds the strongly connected components
		/*
		   step1: Sort all nodes in order of finishing time (topological sort)
		   step2: Transpose the graph
		   step3: Apply the dfs on the transpose graph in reverse
		   
		*/
		Graph graph = new Graph(6);
		graph.addEdge( 1, 2 );
		graph.addEdge( 2, 4 );
		graph.addEdge( 4, 5 );
		graph.addEdge( 2, 3 );
		graph.addEdge( 3, 1);
		//graph.display();
		graph.algorithm();
	}
}