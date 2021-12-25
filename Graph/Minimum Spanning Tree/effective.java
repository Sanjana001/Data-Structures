import java.util.*;

class Node implements Comparator<Node> {
	int u, w;
	Node( int u, int w ){
		this.u = u;
		this.w = w;
	}
	Node() {}
	int getU() {
		return this.u;
	}
	int getW() {
		return this.w;
	}
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
		PriorityQueue<Node> queue = new PriorityQueue<Node>(this.vertices, new Node());
		queue.add( new Node(0, key[0]) );
		// algorithm
		for( int j=0;j<this.vertices-1;j++ ) {
			int v = queue.poll().getU();
			mst[v] = true;
			for( Node node : this.list[v] ) {
				int u = node.getU();
				int w = node.getW();
				if( !mst[u] && w < key[u] ) {
					key[u] = w;
					parent[u] = v;
					queue.add( new Node(u, key[u]) );
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

public class effective {
	public static void main(String[] args) {
		// PRIM'S ALGORITHM
		// finds the minimum spanning tree
		// effective approach
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