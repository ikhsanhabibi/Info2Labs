import java.util.HashMap;

/**
 * A vertex in a weighted graph
 * it stores all the edges to other vertecies and thier weights
 */
public class Vertex {
	private HashMap<Vertex,Integer> edges;
	
	/**
	 * creates a vertex witout any edges
	 */
	public Vertex (){
		edges = new HashMap<Vertex,Integer>();
	}
	/**
	 * creates a vertex and assiges a set of edges to it
	 * @param edges a set of edges to add to the vertex
	 */
	public Vertex (HashMap<Vertex,Integer> edges){
		this.edges = edges;
	}
	
	/**
	 * adds a new edge to the vertex
	 * @param vertex the destination of the edge
	 * @param weight the weight of the edge
	 */
	public void addEdge(Vertex vertex, Integer weight){
		edges.put(vertex,weight);
	}
	

}
