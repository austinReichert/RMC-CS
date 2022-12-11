import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphArticulationPointsOnNonDirectedGraphTest {
    private final Graph graph = new Graph(false);

    @Test
    void twoVertexGraph() {
        graph.insertEdge(1, 2);

        Set<Integer> points = graph.findArticulationPoints();
        assertEquals(items(), points);
    }

    @Test
    void testFindLineOf3ArticulationPoint() {
        graph.insertEdge(1, 2);
        graph.insertEdge(2, 3);

        Set<Integer> points = graph.findArticulationPoints();

        assertEquals(points, items(2));
    }

    @Test
    void testFindLineOf5ArticulationPoint() {
        graph.insertEdge(1, 2);
        graph.insertEdge(2, 3);
        graph.insertEdge(3, 4);
        graph.insertEdge(4, 5);

        Set<Integer> points = graph.findArticulationPoints();
        assertEquals(points, items(2, 3, 4));
    }

    @Test
    void testFindLineOf4WithLinkBetween1and3ArticulationPoint() {
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 3);
        graph.insertEdge(2, 3);
        graph.insertEdge(3, 4);

        Set<Integer> points = graph.findArticulationPoints();

        assertEquals(points, items(3));
    }

    @Test
    void rootCutNode() {
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 3);

        Set<Integer> points = graph.findArticulationPoints();
        assertEquals(items(1), points);
    }

    @Test
    void parentCutNode() {
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 3);
        graph.insertEdge(2, 3);
        graph.insertEdge(3, 4);
        graph.insertEdge(3, 5);
        graph.insertEdge(4, 5);
        graph.insertEdge(4, 6);
        graph.insertEdge(5, 6);

        Set<Integer> points = graph.findArticulationPoints();
        assertEquals(items(3), points);
    }


    @Test
    void bridgeCutNode() {
        graph.insertEdge(1, 2);
        graph.insertEdge(2, 3);
        graph.insertEdge(3, 4);
        graph.insertEdge(3, 5);
        graph.insertEdge(4, 5);


        Set<Integer> points = graph.findArticulationPoints();
        assertEquals(items(2, 3), points);
    }

    @Test
    void testWithBackEdge(){
        graph.insertEdge(1,2);
        graph.insertEdge(2,3);
        graph.insertEdge(2,4);
        graph.insertEdge(4,1);

        Set<Integer> points = graph.findArticulationPoints();
        assertEquals(items(2), points);
    }

    @Test
    void testWithCycle(){
        graph.insertEdge(1,2);
        graph.insertEdge(2,3);
        graph.insertEdge(3,4);
        graph.insertEdge(4,1);

        Set<Integer> points = graph.findArticulationPoints();
        assertEquals(items(), points);
    }
    @Test
    void rootCutNodeWithTwoCycles(){
        graph.insertEdge(1,2);
        graph.insertEdge(1,3);
        graph.insertEdge(2,3);
        graph.insertEdge(1,4);
        graph.insertEdge(1,5);
        graph.insertEdge(5,4);

        Set<Integer> points = graph.findArticulationPoints();
        assertEquals(items(1), points);
    }
    @Test
    void testStraightWithTwoBackEdges(){
        graph.insertEdge(1,2);
        graph.insertEdge(2,3);
        graph.insertEdge(3,4);
        graph.insertEdge(4,2);
        graph.insertEdge(3,1);
        Set<Integer> points = graph.findArticulationPoints();
        assertEquals(items(), points);
    }
    @Test
    void testStronglyConnectedComponents(){
        graph.insertEdge(1,3);
        graph.insertEdge(1,7);
        graph.insertEdge(2,4);
        graph.insertEdge(2,8);
        graph.insertEdge(3,4);
        graph.insertEdge(4,6);
        graph.insertEdge(3,5);
        graph.insertEdge(5,6);
        graph.insertEdge(7,9);
        graph.insertEdge(9,8);

        Set<Integer> points = graph.findArticulationPoints();
        assertEquals(items(), points);
    }
    @Test
    void testWithOneBackAndRoot(){
        graph.insertEdge(1,2);
        graph.insertEdge(1,3);
        graph.insertEdge(3,5);
        graph.insertEdge(2,4);
        graph.insertEdge(4,6);
        graph.insertEdge(6,2);

        Set<Integer> points = graph.findArticulationPoints();
        assertEquals(items(1,2,3), points);
    }
    @Test
    void testWithTwoWeaklyConnectedComponents(){
        graph.insertEdge(1, 5);
        graph.insertEdge(1,2);
        graph.insertEdge(1,3);
        graph.insertEdge(2,3);
        graph.insertEdge(2,4);
        graph.insertEdge(3,4);
        graph.insertEdge(4,5);
        graph.insertEdge(4,6);
        graph.insertEdge(6,10);
        graph.insertEdge(6,7);
        graph.insertEdge(6,8);
        graph.insertEdge(8,9);
        graph.insertEdge(9,10);

        Set<Integer> points = graph.findArticulationPoints();
        assertEquals(items(4,6), points);
    }
    @Test
    void testWithSplitAtNodeGraphWithOneCrossEdge(){
        graph.insertEdge(1,2);
        graph.insertEdge(2,3);
        graph.insertEdge(1,4);
        graph.insertEdge(4,5);
        graph.insertEdge(3,5);

        Set<Integer> points = graph.findArticulationPoints();
        assertEquals(items(), points);
    }

    private HashSet<Integer> items(Integer... i) {
        return new HashSet<>(Arrays.asList(i));
    }
}