import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimGraphTest {
    /**
     * graph line {
     * 1 -- 2 [label=5]
     * 2 -- 3 [label=7]
     * }
     **/
    @Test
    void testLineIsTheMinSpanningTree() {
        Graph graph = new Graph(false);
        graph.insertEdge(1, 2, 5);
        graph.insertEdge(2, 3, 7);

        Graph.PrimResult prim = graph.prim(1);
        assertEquals(0, prim.getDistance().get(1));
        assertEquals(5, prim.getDistance().get(2));
        assertEquals(7, prim.getDistance().get(3));

        assertEquals(-1, prim.getParents().get(1));
        assertEquals(1, prim.getParents().get(2));
        assertEquals(2, prim.getParents().get(3));
    }

    /**
     * graph circle {
     * 1 -- 2 [label=5]
     * 2 -- 3 [label=6]
     * 3 -- 1 [label=5]
     * }
     **/
    @Test
    void testCircleOfThree() {
        Graph graph = new Graph(false);
        graph.insertEdge(1, 2, 5);
        graph.insertEdge(2, 3, 6);
        graph.insertEdge(3, 1, 5);

        Graph.PrimResult prim = graph.prim(1);
        assertEquals(0, prim.getDistance().get(1));
        assertEquals(5, prim.getDistance().get(2));
        assertEquals(5, prim.getDistance().get(3));

        assertEquals(-1, prim.getParents().get(1));
        assertEquals(1, prim.getParents().get(2));
        assertEquals(1, prim.getParents().get(3));
    }
    /**
     * graph sharedChild{
     * 1 -- 2 [label=3]
     * 1 -- 3 [label=5]
     * 3 -- 4 [label=2]
     * 2 -- 4 [label=2]
     * }
     **/
    @Test
    void testSharedChild(){
        Graph graph = new Graph(false);
        graph.insertEdge(1,2,3);
        graph.insertEdge(1,3,5);
        graph.insertEdge(3,4,4);
        graph.insertEdge(2,4,2);

        Graph.PrimResult prim = graph.prim(1);
        assertEquals(0, prim.getDistance().get(1));
        assertEquals(3, prim.getDistance().get(2));
        assertEquals(4, prim.getDistance().get(3));
        assertEquals(2, prim.getDistance().get(4));

        assertEquals(-1, prim.getParents().get(1));
        assertEquals(1, prim.getParents().get(2));
        assertEquals(4, prim.getParents().get(3));
        assertEquals(2, prim.getParents().get(4));
    }
    /**
     * graph greedyCostsMore{
     * 1 -- 2 [label=13]
     * 1 -- 3 [label=5]
     * 3 -- 4 [label=5]
     * 4 -- 5 [label=5]
     * 2 -- 6 [label=1]
     * 5 -- 6 [label=5]
     * }
     **/
    @Test
    void testGreedyGoesLongWayAround(){
        Graph graph = new Graph(false);
        graph.insertEdge(1,2,13);
        graph.insertEdge(1,3, 5);
        graph.insertEdge(3,4,5);
        graph.insertEdge(4,5,5);
        graph.insertEdge(2,6,1);
        graph.insertEdge(5,6,5);

        Graph.PrimResult prim = graph.prim(1);
        assertEquals(0, prim.getDistance().get(1));
        assertEquals(1, prim.getDistance().get(2));
        // went all the way around to avoid 13
        assertEquals(5, prim.getDistance().get(3));
        assertEquals(5, prim.getDistance().get(4));
        assertEquals(5, prim.getDistance().get(5));
        assertEquals(5, prim.getDistance().get(6));

        assertEquals(-1, prim.getParents().get(1));
        assertEquals(6, prim.getParents().get(2));
        // went all the way around to avoid 13
        assertEquals(1, prim.getParents().get(3));
        assertEquals(3, prim.getParents().get(4));
        assertEquals(4, prim.getParents().get(5));
        assertEquals(5, prim.getParents().get(6));
    }
}