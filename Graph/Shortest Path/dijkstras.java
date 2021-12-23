import java.util.*;

class Node implements Comparator<Node> {
	int vertex, weight;
	Node( int vertex, int weight ){
		this.vertex = vertex;
		this.weight = weight;
	}
	
	Node(){ }
	
	public int compare( Node n1, Node n2 ) {
		if( n1.weight < n2.weight ) return -1;
		if( n1.weight > n2.weight ) return 1;
		return 0;
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
	void addEdge( int u, int v, int weight ) {
		this.adj_list[u].add( new Node(v, weight) );
		this.adj_list[v].add( new Node(u, weight) );
	}
	
	// shortest path using bfs
	void shortestPath( int source_vertex) {
		// let's initialize a distance array
		int[] dist = new int[this.vertices];
		// fill the distance array with max value
		Arrays.fill(dist, this.vertices);
		dist[source_vertex] = 0;
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>(this.vertices, new Node() );
		queue.add( new Node(source_vertex, 0) );
		
		// run the loop until stack is empty
		while( !queue.isEmpty() ) {
			Node node = queue.poll();
			// traverse its adjacent nodes
			for( Node adj: this.adj_list[node.vertex] ) {
				if( dist[adj.vertex] > adj.weight + dist[node.vertex] ) {
					dist[adj.vertex] = adj.weight + dist[node.vertex];
					queue.add( new Node( adj.vertex, dist[adj.vertex] ) );
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

public class dijkstras {
	public static void main(String[] args) {
		// we are dealing with a weighted as well as a directed graph
		Graph graph = new Graph(5);
	    graph.addEdge(0, 1, 2);
	    graph.addEdge(0, 3, 1);
	    graph.addEdge(1, 2, 4);
	    graph.addEdge(1, 4, 5);
	    graph.addEdge(3, 2, 3);
	    graph.addEdge(2, 4, 1);
		// find the shortest path of all vertices from vertex 0
		graph.shortestPath( 0 );
		
	}
}