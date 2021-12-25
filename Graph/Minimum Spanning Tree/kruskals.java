import java.util.*;

class Node {
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

class Sort implements Comparator<Node>{
	Sort() {}
	@Override
	public int compare( Node n1, Node n2 ) {
		if( n1.getW() < n2.getW() )
			return -1;
		if( n2.getW() < n1.getW() )
			return 1;
		return 0;
	}
}

class Graph {
	int vertices; // no of vertices;
	ArrayList<Node> list;
	int[] parent;
	int[] rank;
	Graph( int vertices ){
		this.vertices = vertices;
		this.list = new ArrayList<Node>();
		this.parent = new int[this.vertices]; // parent array
		this.rank = new int[this.vertices]; // rank array
		for( int i=0;i<this.vertices;i++ ) {
			this.parent[i] = i;
			this.rank[i] = 0;
		}
	}
	
	void addEdge( int u, int v, int w ) {
		this.list.add( new Node(u,v,w) );
	}
	
	void minSpanningTree() {
		// sort all the edges w.r.t weight
		Collections.sort( this.list, new Sort() );
		// check whether the two nodes connected to the same component or not
		int costMst = 0;
		ArrayList<Node> mst = new ArrayList<Node>(); // stores the minimum spanning tree
		for( Node node: this.list ) {
			int u = node.getU();
			int v = node.getV();
			int w = node.getW();
			if( findParent( u ) != findParent( v ) ) {
				costMst += w;
				mst.add( node );
				union( u, v );
			}
		}
		// cost of mst
		System.out.println( "Minimum cost of mst is " + costMst );
		for( Node node : mst ) {
			System.out.println( node.getU() + "->" + node.getV() );
		}
	}
	
	void initializeArrays() {
		for( int i=1;i<=this.vertices;i++ )
			this.parent[i] = i;
		for( int i=0;i<=this.vertices;i++ )
			this.rank[i] = 0;
	}
	
	void union( int u, int v ) {
		int parent_1 = findParent(u);
		int parent_2 = findParent(v);
		
		if( parent_1 < parent_2 )
			parent[parent_1] = parent_2;
		else if( parent_2 < parent_1 )
			parent[parent_2] = parent_1;
		else {
			parent[parent_2] = parent_1;
			rank[parent_1]++;
		}
	}
	
	int findParent( int src ) {
		if( src == parent[src] )
			return src;
		return parent[src] = findParent( parent[src] );
	}
}

public class kruskals {
	public static void main(String[] args) {
		// KRUSKAL'S ALGORITHM
		// finds the minimum spanning tree
		// effective approach
		/*
		   step1: Sort all the edges w.r.t weight
		   step2: check whether nodes are connected to the same component or not as mst doesn't have any cycle
		   step3: Don't pick the same components which already have picked before
		*/
		Graph graph = new Graph(7); // starts from 1
		graph.addEdge(5, 4, 9);
		graph.addEdge(5, 1, 4);
		graph.addEdge(4, 3, 5);
		graph.addEdge(4, 1, 1);
		graph.addEdge(4, 2, 3);
		graph.addEdge(1, 2, 2);
		graph.addEdge(3, 2, 3);
		graph.addEdge(3, 6, 8);
		graph.addEdge(2, 6, 7);
		graph.minSpanningTree();
	}
}