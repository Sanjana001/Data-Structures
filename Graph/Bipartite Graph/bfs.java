import java.util.*;

class Graph{
	int vertices; // no of vertices
	boolean[][] adj_matrix; // adjacency matrix
	
	Graph( int vertices ){
		this.vertices = vertices;
		this.adj_matrix = new boolean[this.vertices][this.vertices];
	}
	
	// add edge to the graph
	void addEdge( int u, int v ) {
		this.adj_matrix[u][v] = true;
		this.adj_matrix[v][u] = true;
	}
	
	// check for bipartite graph
	void checkBipartite() {
		// initialize the color array
		int[] colors = new int[this.vertices];
		// fill the array
		Arrays.fill(colors, -1);
		
		// traverse the vertices
		for( int i=0;i<this.vertices;i++ ) {
			if( colors[i] == -1 ) {
			    if( !bfsUtil( colors, i ) ) {
			    	System.out.println( "The given graph is a Bipartite Graph" );
			    	return ;
			    }
			}
		}
		System.out.println( "The given graph is not a Bipartite Graph" );
	}

	// apply the bfs search
	boolean bfsUtil( int[] colors, int vertex ) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add( vertex );
		colors[vertex] = 1;
		// run loop until the queue is empty
		while( queue.isEmpty() ) {
			int vertice = queue.poll();
			// traverse its adjacent nodes
			for( int i=0;i<this.vertices;i++ ) {
				if( this.adj_matrix[vertice][i] ) {
					if( colors[i] == -1 ) {
						colors[i] = 1 - colors[vertice];
						queue.add( i );
					} else if( colors[i] == colors[vertice] ) return false;
				}
			}
		}
		return true;
	}
}

public class bfs {
	public static void main(String[] args) {
		// we are dealing with unweighted and undirected graph
		Graph graph = new Graph(9);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(5, 6);
		graph.addEdge(4, 5);
		graph.addEdge(6, 7);
		graph.addEdge(0, 6);
		graph.addEdge(2, 8);
		graph.addEdge(8, 0);
		// check for bipartite graph
		// That can be colored using 2 colors such that no 2 adjacent nodes have same colours
		graph.checkBipartite();
		
	}
}