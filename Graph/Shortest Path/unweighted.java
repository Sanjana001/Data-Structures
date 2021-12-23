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
	
	// shortest path using bfs
	void shortestPath( int source_vertex) {
		// let's initialize a distance array
		int[] dist = new int[this.vertices];
		// fill the distance array with max value
		Arrays.fill(dist, this.vertices);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add( source_vertex );
		dist[source_vertex] = 0;
		
		// run the loop until queue is empty
		while( !queue.isEmpty() ) {
			int node = queue.poll();
			// traverse its adjacent nodes
			for( int num: this.adj_list[node] ) {
				if( dist[num] > 1 + dist[node] ) {
					dist[num] = 1 + dist[node];
					queue.add( num );
				}
			}
		}
		
		// print the distance array
		displayDistance( dist, source_vertex );
	}
	
	void displayDistance( int[] dist, int src ) {
		for( int i=0;i<dist.length;i++ ) {
			System.out.println( "Distance of " + i + " vertex from " + src + " is: " + dist[i] );
		}
	}
}

public class unweighted {
	public static void main(String[] args) {
		// we are dealing with undirected graph
		// as the weights are not given
		// so we assume the weight of each vertex as 1
		Graph graph = new Graph(9);
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 3);
		graph.addEdge(1, 2);
		graph.addEdge(2, 6);
		graph.addEdge(4, 3);
		graph.addEdge(4, 5);
		graph.addEdge(6, 5);
		graph.addEdge(6, 7);
		graph.addEdge(6, 8);
		graph.addEdge(7, 8);
		// find the shortest path of all vertices from vertex 3
		graph.shortestPath( 3 );
		
	}
}