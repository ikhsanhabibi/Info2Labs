import java.util.*;

public class Pathfinder {
	private Random random = new Random();
	
	public int printShortestPath(int numberOfVertecies, int numberOfEdges){
		WeightetGraph graph = new WeightetGraph(numberOfVertecies,numberOfEdges);
		Vertex[] vertecies = graph.getallVertecies(); 
		//choose two random vertecies
		int start = random.nextInt(numberOfVertecies);
		int end = random.nextInt(numberOfVertecies);
		
		
		boolean[] marked = new boolean[numberOfVertecies];
		Arrays.fill(marked,false);
		LinkedList<Vertex> queue = new LinkedList<Vertex>();
		
		queue.add(vertecies[start]);
		marked[start] = true;
		
		while (!queue.isEmpty()){
			Vertex thisVertex = queue.remove();
			if(thisVertex == vertecies[end]){
				return end; //we arrived at the end point
			}
			//get all the edges of this Vetex
			HashMap<Vertex,Integer> edges = thisVertex.getEdges();
			Iterator<Vertex> itEdgdes = edges.keySet().iterator();
			//look in all edges of this Vertex
			while (itEdgdes.hasNext()){
				Vertex thatVertex = itEdgdes.next();
				int vName = thatVertex.getName();
				if(!marked[vName]){
					marked[vName] = true;
					System.out.println("Go from: "+thisVertex.getName()+" to: "+ vName);
					queue.add(thatVertex);
				}
			}
		}
		System.out.println("keine Verbindung vorhanden");
		return -1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pathfinder path = new Pathfinder();
		path.printShortestPath(20,60);

	}

}
