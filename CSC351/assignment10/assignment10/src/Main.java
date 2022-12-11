public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(true);

        CycleFinderVisitor visitor = new CycleFinderVisitor();
        graph.insertEdge(0,1);
        graph.insertEdge(0,5);
        graph.insertEdge(1,2);
        graph.insertEdge(2,3);
        graph.insertEdge(3,4);
        graph.insertEdge(4,2);
        graph.traverseDepthFirst(0, visitor);
        System.out.println(visitor.getCycle());
    }
}