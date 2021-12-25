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
	
	void findBridges() {
		boolean[] visited = new boolean[this.vertices]; // visited array
		int[] time = new int[this.vertices]; // insertion time
		int[] low = new int[this.vertices]; // lowest insertion time
		Arrays.fill(visited, false);
		Arrays.fill(time, -1);
		Arrays.fill(low, -1);
		// algorithm
		int timer = 0;
		for( int i=1;i<this.vertices;i++ ) {
			if( !visited[i] ) {
				dfs( i, -1, visited, time, low, timer );
			}
		}
	}
	
	void dfs( int node, int parent, boolean[] visited, int[] time, int[] low, int timer ) {
		visited[node] = true;
		time[node] = low[node] = timer++;
		// traverse its adjacent nodes
		for( int num : this.list[node] ) {
			if( num == parent ) continue;
			if( !visited[num] ) {
				dfs( num, node, visited, time, low, timer );
				low[node] = Math.min( low[node], low[num] );
				if( low[num] > time[node] ) {
					System.out.println( num + "->" + node );
				}
			} else low[node] = Math.min(low[node], time[num]);
		}
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

public class bridges {
	public static void main(String[] args) {
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
		graph.findBridges();
	}
}