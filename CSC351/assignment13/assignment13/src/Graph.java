import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    private final HashMap<Integer, ArrayList<EdgeNode>> edges = new HashMap<>();
    private final HashMap<Integer, Integer> degrees = new HashMap<>();
    private final HashSet<Integer> vertices = new HashSet<>();
    private int numberOfEdges = 0;
    public final boolean directed;

    public Graph(boolean directed) {
        this.directed = directed;
    }

    public void insertEdge(int x, int y) {
        insertEdge(x, y, directed, null);
    }

    public void insertEdge(int x, int y, int weight) {
        insertEdge(x, y, directed, weight);
    }

    private void insertEdge(int x, int y, boolean directed, Integer weight) {
        EdgeNode edge = new EdgeNode(y, weight);

        edges.computeIfAbsent(x, key -> new ArrayList<>()).add(edge);
        degrees.put(x, degrees.computeIfAbsent(x, (key) -> 0));
        vertices.add(x);
        vertices.add(y);

        if (!directed) {
            insertEdge(y, x, true, weight);
        } else {
            numberOfEdges++;
        }
    }

    public PrimResult prim(int start) {
        HashMap<Integer, Integer> distance = new HashMap<>();
        HashMap<Integer, Integer> parents = new HashMap<>();
        HashSet<Integer> inTree = new HashSet<>();
        int bestDistance;
        for (Integer v : vertices) {
            distance.put(v, Integer.MAX_VALUE);
            parents.put(v, -1);
        }
        int vertex = start;
        distance.put(vertex, 0);

        while (!inTree.contains(vertex)) {
            inTree.add(vertex);
            ArrayList<EdgeNode> p = edges.getOrDefault(vertex, new ArrayList<>());
            for (EdgeNode edgeNode : p) {
                if ((distance.get(edgeNode.y) > edgeNode.weight) && (!inTree.contains(edgeNode.y))) {
                    distance.put(edgeNode.y, edgeNode.weight);
                    parents.put(edgeNode.y, vertex);
                }
            }
            vertex = 1;
            bestDistance = Integer.MAX_VALUE;
            for (Integer v : vertices) {
                if ((!inTree.contains(v)) && (bestDistance > distance.get(v))) {
                    bestDistance = distance.get(v);
                    vertex = v;
                }
            }
        }

        return new PrimResult(distance, parents);
    }

    public static class PrimResult {
        private final HashMap<Integer, Integer> distance;
        private final HashMap<Integer, Integer> parents;

        public PrimResult(HashMap<Integer, Integer> distance, HashMap<Integer, Integer> parents) {
            this.distance = distance;
            this.parents = parents;
        }

        public HashMap<Integer, Integer> getDistance() {
            return distance;
        }

        public HashMap<Integer, Integer> getParents() {
            return parents;
        }
    }

    @Override
    public String toString() {
        String edgeList = edges.entrySet().stream().flatMap(i -> {
            Integer x = i.getKey();
            return i.getValue().stream().map(e -> "[" + x + " " + e.y + "]");
        }).collect(Collectors.joining(", "));

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