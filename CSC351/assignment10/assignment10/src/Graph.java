import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    private final HashMap<Integer, List<EdgeNode>> edges = new HashMap<>();
    private final HashMap<Integer, Integer> degrees = new HashMap<>();
    private final HashSet<Integer> vertices = new HashSet<>();
    private int numberOfEdges = 0;
    public final boolean directed;
    public Graph(boolean directed) {
        this.directed = directed;
    }

    public void insertEdge(int x, int y) {
        insertEdge(x, y, directed);
    }

    private void insertEdge(int x, int y, boolean directed) {
        EdgeNode edge = new EdgeNode(y, null);

        edges
                .computeIfAbsent(x, key -> new ArrayList<>())
                .add(edge);
        degrees.put(
                x,
                degrees.computeIfAbsent(x, (key) -> 0)
        );
        vertices.add(x);
        vertices.add(y);

        if (!directed) {
            insertEdge(y, x, true);
        } else {
            numberOfEdges++;
        }
    }
    public void traverseBreadthFirst(int start, GraphVisitor visitor){
        traverseBreadthFirst(start, visitor, new GraphVisitor.SearchContext());
    }
    public void traverseBreadthFirst(int startingVertex, GraphVisitor visitor, GraphVisitor.SearchContext context) {
        LinkedList<Integer> traversalQueue = new LinkedList<>();
        traversalQueue.addLast(startingVertex);
        context.setDiscovered(startingVertex);
        while(!traversalQueue.isEmpty()){
            int vertex = traversalQueue.removeFirst();
            visitor.visitVertexEarly(vertex, context);
           context.setProcessed(vertex);
            List<EdgeNode> p = edges.getOrDefault(vertex, Collections.emptyList());
            for (EdgeNode edgeNode : p) {
                if ((!context.getProcessed().contains(edgeNode.y)) || directed) {
                    visitor.visitEdge(vertex, edgeNode.y, context);
                }
                if (!context.getDiscovered().contains(edgeNode.y)) {
                    traversalQueue.addLast(edgeNode.y);
                    context.setDiscovered(edgeNode.y);
                    context.setParent(edgeNode.y, vertex);
                }
            }
            visitor.visitVertexLate(vertex, context);
        }
    }

    public void traverseDepthFirst(int start, GraphVisitor visitor){
        traverseDepthFirst(start, visitor, new GraphVisitor.SearchContext());
    }
    private void traverseDepthFirst(int startingVertex, GraphVisitor visitor, GraphVisitor.SearchContext context) {
        if(context.getFinished()){return;}
        context.setDiscovered(startingVertex);
        context.updateEntryTime(startingVertex);
        visitor.visitVertexEarly(startingVertex, context);
        List<EdgeNode> p = edges.getOrDefault(startingVertex, Collections.emptyList());
        for(EdgeNode edgeNode : p){
            if(!context.getDiscovered().contains(edgeNode.y)){
                context.setParent(edgeNode.y, startingVertex);
                visitor.visitEdge(startingVertex, edgeNode.y, context);
                traverseDepthFirst(edgeNode.y, visitor, context);
            }
            else if ((!context.getProcessed().contains(edgeNode.y)) || directed){
                visitor.visitEdge(startingVertex, edgeNode.y, context);
            }
            if(context.getFinished()){return;}
        }
        visitor.visitVertexLate(startingVertex, context);
        context.updateExitTime(startingVertex);
        context.setProcessed(startingVertex);
    }


    @Override
    public String toString() {
        String edgeList = edges
                .entrySet()
                .stream().flatMap(i -> {
                    Integer x = i.getKey();
                    return i.getValue().stream().map(e -> "[" + x + " " + e.y + "]");
                })
                .collect(Collectors.joining(", "));

        return "{ 'edges': " + numberOfEdges + ", 'vertices':" + vertices.size() + " 'edges': " + edgeList + "}";
    }

    private static class EdgeNode {
        Integer y;
        Integer weight;

        public EdgeNode(Integer y, Integer weight) {
            this.y = y;
            this.weight = weight;
        }
    }
}