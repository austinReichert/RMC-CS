import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloydTest {

    @Test
    void singleEdgeGraphIsUnchanged() {
        Floyd floyd = new Floyd(10, false);

        floyd.insertEdge(1, 2, 10);

        floyd.floyd();

        assertEquals(10, floyd.getWeight(1, 2));
    }

    @Test
    void twoEdgeGraphHasPairWeights() {
        Floyd floyd = new Floyd(10, false);

        floyd.insertEdge(1, 2, 10);
        floyd.insertEdge(2, 3, 10);

        floyd.floyd();

        assertEquals(10, floyd.getWeight(1, 2));
        assertEquals(10, floyd.getWeight(2, 3));
        assertEquals(20, floyd.getWeight(1, 3));
        assertEquals(20, floyd.getWeight(3, 1));
        assertEquals(10, floyd.getWeight(3, 2));
        assertEquals(10, floyd.getWeight(2, 1));
    }

    @Test
    void twoEdgeDiGraphHasPairWeights() {
        Floyd floyd = new Floyd(10, true);

        floyd.insertEdge(1, 2, 10);
        floyd.insertEdge(2, 3, 10);

        floyd.floyd();

        assertEquals(10, floyd.getWeight(1, 2));
        assertEquals(10, floyd.getWeight(2, 3));
        assertEquals(20, floyd.getWeight(1, 3));
        assertTrue(floyd.edgeMissing(2, 1));
        assertTrue(floyd.edgeMissing(3, 2));
        assertTrue(floyd.edgeMissing(3, 1));
    }

    @Test
    void threeCycleDiGraphHasPairWeights() {
        Floyd floyd = new Floyd(10, true);

        floyd.insertEdge(1, 2, 10);
        floyd.insertEdge(2, 3, 10);
        floyd.insertEdge(3, 1, 10);

        floyd.floyd();

        assertEquals(10, floyd.getWeight(1, 2));
        assertEquals(10, floyd.getWeight(2, 3));
        assertEquals(10, floyd.getWeight(3, 1));
        assertEquals(20, floyd.getWeight(1, 3));
        assertEquals(20, floyd.getWeight(3, 2));
    }
    /**
     * digraph g{
     * 1 -> 4 [label=5]
     * 1 -> 2 [label=3]
     * 2 -> 1 [label=2]
     * 2 -> 4 [label=4]
     * 4 -> 3 [label=2]
     * 3 -> 2 [label=1]
     * }
     **/
    @Test
    void cyclicDirectedWithBackEdge(){
        Floyd floyd = new Floyd(10, true);

        floyd.insertEdge(1,4,5);
        floyd.insertEdge(1,2,3);
        floyd.insertEdge(2,1,2);
        floyd.insertEdge(2,4,4);
        floyd.insertEdge(4,3,2);
        floyd.insertEdge(3,2,1);

        floyd.floyd();

        assertEquals(5, floyd.getWeight(1,4));
        assertEquals(3, floyd.getWeight(1,2));
        assertEquals(2,floyd.getWeight(2,1));
        assertEquals(4, floyd.getWeight(2,4));
        assertEquals(2, floyd.getWeight(4,3));
        assertEquals(1, floyd.getWeight(3,2));
        assertEquals(3, floyd.getWeight(4,2));
        assertEquals(6, floyd.getWeight(2,3));
    }

    /**
     * digraph g{
     * 1 -> 2 [label=5]
     * 1 -> 3 [label=2]
     * 2 -> 4 [label=4]
     * 4 -> 1 [label=3]
     }
     **/
    @Test
    void cyclicDirectedWithBranch(){
        Floyd floyd = new Floyd(10, true);

        floyd.insertEdge(1,2,5);
        floyd.insertEdge(1,3,2);
        floyd.insertEdge(2,4,4);
        floyd.insertEdge(4,1,3);

        floyd.floyd();

        assertEquals(5, floyd.getWeight(1,2));
        assertEquals(8, floyd.getWeight(4,2));
        assertEquals(9, floyd.getWeight(1, 4));
        assertTrue(floyd.edgeMissing(3,1));
    }

    /**
     * digraph g{
     * 1 -> 2 [label=5]
     * 1 -> 3 [label=2]
     * 2 -> 3 [label=1]
     * 3 -> 2 [label=1]
     * 2 -> 4 [label=3]
     * 3 -> 5 [label=3]
     * 4 -> 7 [label=5]
     * 4 -> 5 [label=3]
     * 6 -> 4 [label=19]
     * 5 -> 6 [label=2]
     * 6 -> 7 [label=3]
     * 5 -> 1 [label=10]
     * }
     **/
    @Test
    void hugeDirectedGraphWithBackEdges(){
        Floyd floyd = new Floyd(10, true);

        floyd.insertEdge(1,2,5);
        floyd.insertEdge(1,3,2);
        floyd.insertEdge(2,3,1);
        floyd.insertEdge(3,2,1);
        floyd.insertEdge(2,4,3);
        floyd.insertEdge(3,5,3);
        floyd.insertEdge(4,7,5);
        floyd.insertEdge(4,5,3);
        floyd.insertEdge(6,4,19);
        floyd.insertEdge(5,6,2);
        floyd.insertEdge(6,7,3);
        floyd.insertEdge(5,1,10);

        floyd.floyd();

        assertEquals(14, floyd.getWeight(2,1));
        assertEquals(32, floyd.getWeight(6,1));
        assertEquals(10, floyd.getWeight(1,7));
        assertEquals(6,floyd.getWeight(2,6));
        assertTrue(floyd.edgeMissing(7,1));
        assertTrue(floyd.edgeExists(4,1));
    }
}