public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(false);
        graph.insertEdge(1, 2, false);
        graph.insertEdge(2, 3, false);
        graph.insertEdge(3, 5, true);
        System.out.println(graph + "\n");
        PrintGraphVisitor visitor = new PrintGraphVisitor();
        graph.traverseBreadthFirst(1, visitor);

    }
}