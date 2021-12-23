import java.util.*;

class Node {
	int vertex, weight;
	Node( int vertex, int weight ){
		this.vertex = vertex;
		this.weight = weight;
	}
}

class Graph{
	int vertices; // no of vertices
	ArrayList<Node> adj_list[]; // adjacency list
	
	Graph( int vertices ){
		this.vertices = vertices;
		this.adj_list = new ArrayList[this.vertices];
		initializeList();
	}
	
	// initialize the adjacency list
	void initializeList() {
		for( int i=0;i<this.vertices;i++ ) {
			this.adj_list[i] = new ArrayList<Node>();
		}
	}
	
	// add edge to the graph
	@SuppressWarnings("unchecked")
	void addEdge( int u, Node v ) {
		this.adj_list[u].add( v );
	}
	
	// shortest path using bfs
	void shortestPath( int source_vertex) {
		Stack<Integer> stack = new Stack<Integer>();
		topologicalSort( stack );
		
		// let's initialize a distance array
		int[] dist = new int[this.vertices];
		// fill the distance array with max value
		Arrays.fill(dist, this.vertices);
		dist[source_vertex] = 0;
		
		/*Queue<Integer> queue = new LinkedList<Integer>();
		queue.add( source_vertex );
		dist[source_vertex] = 0;*/
		
		// run the loop until stack is empty
		while( !stack.isEmpty() ) {
			int v = stack.pop();
			// check the popped element is a source or not
			if( dist[v] != this.vertices ) {
				// traverse its adjacent nodes
				for( Node node: this.adj_list[v] ) {
					if( dist[node.vertex] > node.weight + dist[v] ) {
						dist[node.vertex] = node.weight + dist[v];
					}
				}
			}
		}
		
		// print the distance array
		displayDistance( dist, source_vertex );
	}
	
	// topological sort
	void topologicalSort( Stack<Integer> stack ) {
		boolean[] visited = new boolean[this.vertices];
		Arrays.fill(visited, false);
		for( int i=0;i<this.vertices;i++ ) {
			if( !visited[i] ) {
				topologicalSortUtil( stack, visited, i );
			}
		}
	}
	
	void topologicalSortUtil( Stack<Integer> stack, boolean[] visited, int vertex ) {
		visited[vertex] = true;
		// traverse its adjacent nodes
		for( Node num: this.adj_list[vertex] ) {
			if( !visited[num.vertex] ) {
				topologicalSortUtil( stack, visited, num.vertex );
			}
		}
		stack.push( vertex );
	}
	
	void displayDistance( int[] dist, int src ) {
		for( int i=0;i<dist.length;i++ ) {
			System.out.println( "Distance of " + i + " vertex from " + src + " is: " + dist[i] );
		}
	}
}

public class weighted {
	public static void main(String[] args) {
		// we are dealing with a weighted as well as a directed graph
		Graph graph = new Graph(6);
		graph.addEdge(0, new Node(1, 2) );
		graph.addEdge(0, new Node(4, 1) );
		graph.addEdge(1, new Node(2, 3) );
		graph.addEdge(4, new Node(2, 2) );
		graph.addEdge(4, new Node(5, 4) );
		graph.addEdge(2, new Node(3, 6) );
		graph.addEdge(5, new Node(3, 1) );
		// find the shortest path of all vertices from vertex 0
		graph.shortestPath( 0 );
		
	}
}