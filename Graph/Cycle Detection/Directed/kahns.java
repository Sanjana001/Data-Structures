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
	
	// cycle detection using Kahn's Algorithm (bfs)
	void detectCycle() {
		// let's initialize an array to store the in-degrees of the adjacency list
		int[] indegree = new int[this.vertices];
		
		// calculate the in-degree of every vertex
		calculateIndegree( indegree );
		
		// store the elements having 0 in-degree into queue
		Queue<Integer> queue= new LinkedList<Integer>();
		for( int i=0;i<indegree.length;i++ ) {
			if( indegree[i] == 0 ) queue.add( i );
		}
		
		// run a loop until the size of queue becomes 0
		// decrements the in-degree of adjacent nodes of the top item of queue by 1
		// And when in-degree becomes to zero push it into queue
		int count = 0;
		while( !queue.isEmpty() ) {
			int node = queue.poll();
			count++;
			// traverse its adjacent nodes
			for( int num: this.adj_list[node] ) {
				indegree[num]--;
				if( indegree[num] == 0 ) queue.add( num );
			}
		}
		
		if( count == this.vertices ) {
			System.out.println( "Cycle Doesn't Exist" );
		} else {
			System.out.println( "Cycle Exists" );
		}
	}
	
	void calculateIndegree( int[] indegree ) {
		Arrays.fill(indegree, 0);
		for( int i=0;i<this.vertices;i++ ) {
			for( int num: this.adj_list[i] ) {
				indegree[num]++;
			}
		}
	}
}

public class kahns {
	public static void main(String[] args) {
		// we are dealing with unweighted and directed graph
		Graph graph = new Graph(6);
		graph.addEdge(5, 0);
		graph.addEdge(4, 1);
		graph.addEdge(3, 1);
		graph.addEdge(2, 3);
		graph.addEdge(5, 2);
		graph.addEdge(4, 0);
		graph.detectCycle();
		
	}
}