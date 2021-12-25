import java.util.*;

class Node{
	int u, w, v;
	Node( int u, int v, int w ){
		this.u = u;
		this.v = v;
		this.w = w;
	}
	int getU() {
		return this.u;
	}
	int getV() {
		return this.v;
	}
	int getW() {
		return this.w;
	}
}

class Graph {
	int vertices; // no of vertices;
	ArrayList<Node> list; // adjacency list;
	Graph( int vertices ){
		this.vertices = vertices;
		this.list = new ArrayList<Node>();
	}
	
	void addEdge( int u, int v, int w ) {
		this.list.add( new Node( u, v, w ) );
	}
	
	void shortestPath( int src ) {
		int[] dist = new int[this.vertices]; // distance array
		Arrays.fill(dist, this.vertices);
		dist[src] = 0;
		// relaxing the array at n-1 times
		for( int i=0;i<this.vertices;i++ ) {
			relaxation( dist );
		}
		/*// display the distance array
		for( int i=0;i<this.vertices;i++ ) {
			System.out.println( "Distance of vertex " + i + " from "+ src + " is " + dist[i] );
		}*/
		for( Node node : this.list ) {
			int u = node.getU();
			int v = node.getV();
			int w = node.getW();
			if( dist[u] + w < dist[v] ) {
				dist[v] = dist[u] + w;
				System.out.println( "Negative Cycle" );
				return ;
			}
		}
		System.out.println( "Positive Cycle" );
	}
	
	void relaxation( int[] dist ) {
		int u = 0, v = 0, w = 0;
		for( Node node : this.list ) {
			u = node.getU();
			v = node.getV();
			w = node.getW();
			if( dist[u] + w < dist[v] )
				dist[v] = dist[u] + w;
		}
	}
}

public class bellmans {
	public static void main(String[] args) {
		// bellman ford algorithm ( only for directed graph with positive cycle )
		// works with the negative weights as well
		// detects the negative cycle in graph
		// undirected graph must be converted into directed graphs in order to apply the bellman ford algorithm
		Graph graph = new Graph(6);
		graph.addEdge( 0, 1, 5 );
		graph.addEdge(1, 5, -3);
		graph.addEdge(5, 3, 1);
		graph.addEdge(1, 2, -2);
		graph.addEdge(3, 2, 6);
		graph.addEdge(3, 4, -2);
		graph.addEdge(2, 4, 3);
		graph.shortestPath( 0 );
		// if the distance reduces even after the relaxation of n-1 times it means that the graph has a negative cycle
	}
}