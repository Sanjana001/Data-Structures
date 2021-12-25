import java.util.*;

class Disjoint {
	int vertices; // no of vertices
	int[] rank;
	int[] parent;
	
	Disjoint( int vertices ){
		this.vertices = vertices;
		this.rank = new int[this.vertices+1];
		this.parent = new int[this.vertices+1];
		initializeArrays();
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

public class union {
	public static void main(String[] args) {
		// disjoint set
		// union by rank and path compression
		Disjoint obj = new Disjoint(7);
		obj.union( 1, 2 );
		obj.union( 2, 3 );
		obj.union( 4, 5 );
		obj.union( 6, 7 );
		obj.union( 5, 6 );
		obj.union( 3, 7 );
		if( obj.findParent(4) != obj.findParent(3) ) {
			System.out.println( "Not connected" );
		} else System.out.println( "Connected" );
	}
}