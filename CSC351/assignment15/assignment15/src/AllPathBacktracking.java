import java.util.*;

public class AllPathBacktracking extends BackTracking<Integer>{
    private int solutionCount = 0;
    private final Graph graph;

    public AllPathBacktracking(Graph graph, int target){
        this.graph = graph;
        super.maxCandidates = getLargestEdge();
        int[] a = new int[edgeCount()];
        a[1] = 1;
        backtrack(a, 1, target);
    }

    protected int constructCandidate(int[] a, int k, Integer input, int[] candidates){
        HashSet<Integer> inSolution = new HashSet<>();
        for (int i = 1; i < k; i++){
            inSolution.add(a[i]);
        }
        int count = 0;
        if(k==1){
            candidates[0] = 1;
            count = 1;
        }
        else{
            int last = a[k-1];
            ArrayList<Graph.EdgeNode> p = (ArrayList<Graph.EdgeNode>) graph.findEdges(last);
            for (Graph.EdgeNode edgenode : p){
                if (!inSolution.contains(edgenode.y)){
                    candidates[count] = edgenode.y;
                    count++;
                }
            }
        }
        return count;
    }

    protected boolean isSolution(int[] a, int k, Integer input) {
        return (a[k] == input);
    }

    protected void processSolution(int[] a, int k, Integer input) {
        solutionCount++;
    }

    public int getSolutionCount() {
        return solutionCount;
    }

    private int getLargestEdge(){
        int largestEdge = 0;
        HashMap<Integer, ArrayList<Graph.EdgeNode>> edges = graph.getEdges();
        for (ArrayList<Graph.EdgeNode> value : edges.values()) {
            if (value.size() > largestEdge){
                largestEdge = value.size();
            }
        }
        return largestEdge+1;
    }

    private int edgeCount(){
        int edgeCount = 1;
        HashMap<Integer, ArrayList<Graph.EdgeNode>> edges = graph.getEdges();
        for (ArrayList<Graph.EdgeNode> value : edges.values()) {
            edgeCount += value.size();
        }
        return edgeCount + 1;
    }

    public static void main(String[] args) {
        Graph g = new Graph(false);
        g.insertEdge(1,2);
        g.insertEdge(2,3);
        g.insertEdge(3,4);
        g.insertEdge(1,5);
        g.insertEdge(5,4);
        g.insertEdge(4,6);
        g.insertEdge(3,5);
        AllPathBacktracking apbt = new AllPathBacktracking(g, 6);
        System.out.println(apbt.getSolutionCount());
    }
}
