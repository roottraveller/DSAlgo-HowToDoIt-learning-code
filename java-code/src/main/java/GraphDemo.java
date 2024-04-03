import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphDemo {
    public static void main(String[] args) {
        GraphDemo graphDemo = new GraphDemo();
        Graph graph = graphDemo.new Graph(5); //vertexCount = 5

        // Example usage with dummy data
        GraphNode node1 = graphDemo.new GraphNode(0);
        GraphNode node2 = graphDemo.new GraphNode(1);
        GraphNode node3 = graphDemo.new GraphNode(2);
        GraphNode node4 = graphDemo.new GraphNode(3);
        GraphNode node5 = graphDemo.new GraphNode(4);

        graph.addEdge(node1, node2);
        graph.addEdge(node2, node3);
        graph.addEdge(node3, node4);
        graph.addEdge(node4, node5);

        graph.doDFSAll();
    }

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
        List<GraphNode>[] edge; //an array to store vertex

        @SuppressWarnings("unchecked")
        public Graph(int vertexCountIn) {
            this.vertexCount = vertexCountIn;
            this.edge = new ArrayList[this.vertexCount];
            for (int v = 0; v < this.vertexCount; ++v) {
                edge[v] = new ArrayList<GraphNode>(); //arraylist for neighbours i.e an array of linkedlist
            }
        }

        public void addEdge(GraphNode src, GraphNode dest) {
            this.edge[src.weight].add(dest);
        }

        public void doDFSAll() {
            List<List<GraphNode>> dfsList = new LinkedList<>();
            for (int v = 0; v < vertexCount; ++v) {
                if (!edge[v].isEmpty() && !edge[v].get(0).visited) {
                    dfsList.add(doDFSOnElem(edge[v].get(0)));
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

            for (GraphNode node : edge[src.weight]) {
                if (!node.visited) {
                    dfsNodesList.addAll(doDFSUtil(node));
                }
            }
            return dfsNodesList;
        }

        private void printDFSAll(List<List<GraphNode>> dfsList) {
            for (List<GraphNode> rowlist : dfsList) {
                for (GraphNode dummyNode : rowlist) {
                    System.out.printf("%-10d %-10b%n", dummyNode.weight, dummyNode.visited);
                }
            }
        }
    }
}
