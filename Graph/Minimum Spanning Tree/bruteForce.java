import java.util.*;

class Node {
	int u, w;
	Node( int u, int w ){
		this.u = u;
		this.w = w;
	}
	int getU() {
		return this.u;
	}
	int getW() {
		return this.w;
	}
}

class Graph {
	int vertices; // no of vertices;
	ArrayList<Node> list[]; // adjacency list;
	Graph( int vertices ){
		this.vertices = vertices;
		this.list = new ArrayList[this.vertices];
		for( int i=0;i<this.vertices;i++ )
			this.list[i] = new ArrayList<Node>();
	}
	
	void addEdge( int u, int v, int w ) {
		this.list[u].add( new Node(v,w) );
		this.list[v].add( new Node(u,w) );
	}
	
	void minSpanningTree() {
		int[] key = new int[this.vertices];
		int[] parent = new int[this.vertices];
		boolean[] mst = new boolean[this.vertices];
		// fill the arrays
		Arrays.fill(mst, false);
		Arrays.fill(key, 2*this.vertices);
		Arrays.fill(parent, -1);
		// As node 0 is the minimum possible vertex and also it is not visited yet
		key[0] = 0;
		// algorithm
		for( int j=0;j<this.vertices-1;j++ ) {
			int min_key = 2*this.vertices, v = 0;
			// find the minimum key who is not visited in minimum spanning tree yet
			for( int i=0;i<this.vertices;i++ ) {
				if( mst[i] == false && key[i] < min_key ) {
					min_key = key[i];
					v = i;
				}
			}
			//System.out.println( min_key + " " + v );
			mst[v] = true;
			for( Node node : this.list[v] ) {
				int u = node.getU();
				int w = node.getW();
				if( !mst[u] && w < key[u] ) {
					key[u] = w;
					parent[u] = v;
				}
			}
		}
		// display the minimum spanning tree
		for( int i=1;i<this.vertices;i++ ) {
			System.out.println( parent[i] + "->" + i );
		}
	}
	
	void display() {
		for( int i=0;i<this.vertices;i++ ) {
			System.out.print( i + "->" );
			for( Node node : this.list[i] )
				System.out.print( " " + node.getU() );
			System.out.println();
		}
	}
}

public class bruteForce {
	public static void main(String[] args) {
		// PRIM'S ALGORITHM
		// finds the minimum spanning tree
		// brute force approach
		Graph graph = new Graph(5);
		graph.addEdge( 0, 1, 2 );
		graph.addEdge( 1, 2, 3 );
		graph.addEdge( 0, 3, 6 );
		graph.addEdge( 1, 3, 8 );
		graph.addEdge( 1, 4, 5 );
		graph.addEdge( 2, 4, 7 );
		//graph.display();
		graph.minSpanningTree();
	}
}