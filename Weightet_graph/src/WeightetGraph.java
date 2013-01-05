import java.util.Random;


public class WeightetGraph {
	private Vertex[] vertecies;
	private Random random = new Random();
	//maximum weight of an edge
	private final int MAX_WEIGHT = 200;
	
	/**
	 * creates an Weighted with a given number of vertecies and ramdomly creates a given number edges between them
	 * @param vertecies the number of vertecies to create
	 * @param edges the number of edges to create
	 */
	public WeightetGraph(int vertecies,int edges){
		createVertecies(vertecies);
		//TODO: it is possible that some random connection occurs twice and since edges are stored in a HashSet may less than i edges are created
		for (int i=0;i<=edges;i++){
			int from = random.nextInt(vertecies);
			int to = random.nextInt(vertecies);
			addEdge(from,to);
		}
		
	}
	/**
	 * creates some vertecies
	 * @param howMany the number of vertecies to create
	 */
	private void createVertecies(int howMany){
		vertecies = new Vertex[howMany];
		for (int i=0;i<howMany;i++){
			vertecies[i] = new Vertex();
		}
	}
	/**
	 * adds and edge to a vertex
	 * @param fromVertex the vertex to add the edge to
	 * @param toVertex the vertex the edge points to
	 */
	private void addEdge(int fromVertex,int toVertex){
		int weight = random.nextInt(MAX_WEIGHT);
		vertecies[fromVertex].addEdge(vertecies[toVertex], weight);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new WeightetGraph(20,10);

	}

}
