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
		this.list[v].add(u);
	}
    
	void articulationPt() {
		boolean[] isArticulation = new boolean[this.vertices]; // store the articulation points using hashing
		boolean[] visited = new boolean[this.vertices]; // visited array
		int[] time = new int[this.vertices]; // insertion time
		int[] low = new int[this.vertices]; // lowest insertion time
		Arrays.fill(visited, false);
		Arrays.fill(isArticulation, false);
		Arrays.fill(time, 0);
		Arrays.fill(low, 0);
		// algorithm
		int timer = 0;
		for( int i=0;i<this.vertices;i++ ) {
			if( !visited[i] ) {
				dfs( i, -1, visited, time, low, timer, isArticulation );
			}
		}
		// display articulation points
		for( int i=0;i<this.vertices;i++ ) {
			if( isArticulation[i] ) {
				System.out.println(i);
			}
		}
	}
	
	void dfs( int node, int parent, boolean[] visited, int[] time, int[] low, int timer, boolean[] isArticulation ) {
		visited[node] = true;
		time[node] = low[node] = timer++;
		int child = 0;
		// traverse its adjacent nodes
		for( int num : this.list[node] ) {
			if( !visited[num] ) {
				dfs( num, node, visited, time, low, timer, isArticulation );
				low[node] = Math.min( low[node], low[num] );
				if( low[num] >= time[node] && parent != -1 ) {
					isArticulation[node] = true;
				}
				child++;
			} else low[node] = Math.min(low[node], time[num]);
		}
		// if the first guy has more than one children
		if( parent == -1 && child > 1 ) isArticulation[node] = true;
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

public class articulationPt {
	public static void main(String[] args) {
		// Articulation Point
		// A node which when removes, splits the graph into two or more components
		// if lowest insertion time of adjacent nodes should be grater than or equal to insertion time of node
		Graph graph = new Graph(13);
		graph.addEdge( 1, 2 );
		graph.addEdge( 2, 3 );
		graph.addEdge( 1, 4 );
		graph.addEdge( 4, 3 );
		graph.addEdge( 4, 5 );
		graph.addEdge( 5, 6 );
		graph.addEdge( 6, 7 );
		graph.addEdge( 7, 8 );
		graph.addEdge( 9, 8 );
		graph.addEdge( 8, 10 );
		graph.addEdge( 10, 11 );
		graph.addEdge( 11, 12 );
		graph.addEdge( 10, 12 );
		graph.addEdge( 6, 9 );
		//graph.display();
		graph.articulationPt();
	}
}