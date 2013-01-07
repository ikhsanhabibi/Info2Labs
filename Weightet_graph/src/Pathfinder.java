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
	
	public int printCheapestPath(int numberOfVertecies, int numberOfEdges){
		WeightetGraph graph = new WeightetGraph(numberOfVertecies,numberOfEdges);
		Vertex[] vertecies = graph.getallVertecies(); 
		//choose two random vertecies
		int start = random.nextInt(numberOfVertecies);
		int end = random.nextInt(numberOfVertecies);
//			       for each vertex v in Graph:                     
//			           dist[v] := infinity ;  
//        			   previous[v] := undefined ;                            
//    			   end for  
		int[] dist = new int[numberOfVertecies];
		Arrays.fill(dist, Integer.MAX_VALUE);
		int[] prev = new int[numberOfVertecies];
		Arrays.fill(prev, Integer.MAX_VALUE);		       
//			       dist[source] := 0 ;                                        
		dist[start] = 0;
//			       Q := the set of all nodes in Graph;
		LinkedList<Vertex> queue = new LinkedList<Vertex>();
		for(int i = 0;i<vertecies.length;i++){
			queue.add(vertecies[i]);
		}
//			      while Q is not empty:
		while (!queue.isEmpty()){
//			          u := vertex in Q with smallest distance in dist[] ; 
//			          remove u from Q ;
//			          if dist[u] = infinity:
//			              break ;                                            // all remaining vertices are
//			          end if                                                 // inaccessible from source
//			          
//			          for each neighbor v of u:                              // where v has not yet been 
//			                                                                 // removed from Q.
//			              alt := dist[u] + dist_between(u, v) ;
//			              if alt < dist[v]:                                  // Relax (u,v,a)
//			                  dist[v] := alt ;
//			                  previous[v] := u ;
//			                  decrease-key v in Q;                           // Reorder v in the Queue
//			              end if
//			          end for
//			      end while
		}
//			  return dist;
		return 0;

	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pathfinder path = new Pathfinder();
		path.printShortestPath(20,60);

	}

}
