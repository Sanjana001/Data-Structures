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
	
	// topological sort using dfs
	void topologicalSort() {
		boolean[] visited = new boolean[this.vertices];
		// fill the array
		Arrays.fill(visited, false);
		// let's initialize a stack to store the topological sort of array
		Stack<Integer> stack = new Stack<Integer>();
		// let's traverse from the vertices
		// as there is a possibility that the given graph is disconnected
		for( int i=0;i<this.vertices;i++ ) {
			if( !visited[i] ) {
				dfs( visited, i, stack );
			}
		}
		// print the stack
		System.out.println( "Topological Sort Using DFS: " );
		while( !stack.isEmpty() ) {
			System.out.print( stack.pop() + " " );
		}
	}
	
	// dfs algorithm with some changes
	void dfs( boolean[] visited, int vertex, Stack<Integer> stack ) {
		visited[vertex] = true;
		// traverse through the adjacent nodes
		for( int num: this.adj_list[vertex] ) {
			if( !visited[num] ) {
				dfs( visited, num, stack );
			}
		}
		stack.push( vertex );
	}
}

public class topologicalSort1{
	public static void main(String[] args) {
		// we are dealing with unweighted and directed graph
		Graph graph = new Graph(6);
		graph.addEdge(5, 0);
		graph.addEdge(4, 1);
		graph.addEdge(3, 1);
		graph.addEdge(2, 3);
		graph.addEdge(5, 2);
		graph.addEdge(4, 0);
		// linear ordering of edges such that there is an edge u->v, and u always come before v
		// This thing is possible only in directed acyclic graph (dag)
		graph.topologicalSort();
		
	}
}