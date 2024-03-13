import java.util.*;

/* 
 * https://c...content-available-to-author-only...e.com/questions/48518/depth-first-search-breadth-first-search-implementation
 */
 
// @author : rootTraveller, June 2017


class GraphDemo {
	//INNER CLASS
	private class GraphNode {
		private int weight;
		private boolean visited;
		
		public GraphNode(int weightIn, boolean visitedIn) {
			this.weight = weightIn;
			this.visited = visitedIn;
		}
		
		public GraphNode(int weightIn) {
			this.weight = weightIn;
			this.visited = false;
		}
	}

	class Graph {
		int vertexCount;
		List<GraphNode>[] edge; //an array to store vertext
		
		public Graph(int vertexCountIn) {
			this.vertexCount = vertexCountIn;
			this.edge = new ArrayList<GraphNode>[this.vertexCount];
			for(int v=0; v < this.vertexCount; ++v){
				edge[v] = new ArrayList<GraphNode>(); //arraylist for neighbours i.e an array of linkedlist
			}
		}
		
		public void addEdge(GraphNode src, GraphNode dest) {
			this.edge[src].add(dest);
		}
		
		public void doDFSAll() {
			List<LinkedList<GraphNode>> dfsList = new LinkedList<>();
			for(int v=0; v < vertexCount; ++v){
				if(edge[v].visited == false){
					dfsList.add(doDFSOnElem(edge[v]));
				}
			}
			
			printDFSAll(dfsList);
		}
		
		public List<GraphNode> doDFSOnElem(GraphNode src) {
			return doDFSUtil(src);
		}
		
		private List<GraphNode> doDFSUtil(GraphNode src) {
			src.visited = true;
			List<GraphNode> dfsNodesList = new LinkedList<>();
			dfsNodesList.add(src); //add source node too !important
			
			Iterator<GraphNode> iter = this.edge[src].listIterator();  //traverse the list (row)
			while(iter.hasNext()) {
				GraphNode dummyNode = iter.next();
				if(dummyNode.visited == false) {
					doDFSUtil(dummyNode);
				}
			}
			return dfsNodesList;
		}
		
		private void printDFSAll(List<LinkedList<GraphNode>> dfslist) {
			for(LinkedList<GraphNode> rowlist : dfsList) {
				Iterator<GraphNode> iter = rowlist.listIterator(); //traverse the row 
				while(iter.hasNext()){
					GraphNode dummyNode = iter.next();
					System.out.printf("%-10d %-10b", dummyNode.weight, dummyNode.visited);
					System.out.flush(); //flush the stream 
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(5); //vertexCount = 5
		
	}

}
