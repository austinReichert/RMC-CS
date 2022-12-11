import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AllPathBacktrackingTest {
    Graph directedGraph = new Graph(true);
    Graph undirectedGraph = new Graph(false);

    /*
    graph G {
    1 -- 2
    }
    */
    @Test
    void twoVertexUndirectedGraph(){
        undirectedGraph.insertEdge(1,2);

        int result = new AllPathBacktracking(undirectedGraph, 2).getSolutionCount();

        assertEquals(1, result);
    }
    /*
    digraph G {
    1 -> 2
    }
    */
    @Test
    void twoVertexDirectedGraph(){
        directedGraph.insertEdge(1,2);

        AllPathBacktracking result = new AllPathBacktracking(directedGraph, 2);

        assertEquals(1, result.getSolutionCount());
    }
    /*
    graph G {
    1 -- 2
    2 -- 3
    3 -- 1
    }
    */
    @Test
    void undirectedCyclicGraph(){
        undirectedGraph.insertEdge(1,2);
        undirectedGraph.insertEdge(2,3);
        undirectedGraph.insertEdge(3,1);

        AllPathBacktracking result = new AllPathBacktracking(undirectedGraph, 3);

        assertEquals(2, result.getSolutionCount());
    }

    /*
    digraph G {
    1 -> 2
    2 -> 3
    3 -> 1
    }
    */
    @Test
    void directedCyclicGraph(){
        directedGraph.insertEdge(1,2);
        directedGraph.insertEdge(2,3);
        directedGraph.insertEdge(3,1);

        AllPathBacktracking result = new AllPathBacktracking(directedGraph, 3);

        assertEquals(1, result.getSolutionCount());
    }

    /*
    graph G {
    1 -- 2
    2 -- 3
    3 -- 4
    }
    */
    @Test
    void undirectedStraightLine(){
        undirectedGraph.insertEdge(1,2);
        undirectedGraph.insertEdge(2,3);
        undirectedGraph.insertEdge(3,4);

        AllPathBacktracking result = new AllPathBacktracking(undirectedGraph, 4);

        assertEquals(1, result.getSolutionCount());
    }

    /*
    digraph G {
    1 -> 2
    2 -> 3
    3 -> 4
    }
    */
    @Test
    void directedStraightLine(){
        directedGraph.insertEdge(1,2);
        directedGraph.insertEdge(2,3);
        directedGraph.insertEdge(3,4);

        AllPathBacktracking result = new AllPathBacktracking(directedGraph, 4);

        assertEquals(1, result.getSolutionCount());
    }

    /*
    graph G {
    1 -- 2
    1 -- 3
    3 -- 5
    2 -- 4
    5 -- 6
    4 -- 6
    4 -- 5
    }
    */
    @Test
    void undirectedWithCross(){
        undirectedGraph.insertEdge(1,2);
        undirectedGraph.insertEdge(1,3);
        undirectedGraph.insertEdge(3,5);
        undirectedGraph.insertEdge(2,4);
        undirectedGraph.insertEdge(5,6);
        undirectedGraph.insertEdge(4,6);
        undirectedGraph.insertEdge(4,5);

        AllPathBacktracking result = new AllPathBacktracking(undirectedGraph, 6);

        assertEquals(4, result.getSolutionCount());
    }

    /*
    digraph G {
    1 -> 2
    1 -> 3
    3 -> 5
    2 -> 4
    5 -> 6
    4 -> 6
    4 -> 5
    }
    */
    @Test
    void directedWithCross(){
        directedGraph.insertEdge(1,2);
        directedGraph.insertEdge(1,3);
        directedGraph.insertEdge(3,5);
        directedGraph.insertEdge(2,4);
        directedGraph.insertEdge(5,6);
        directedGraph.insertEdge(4,6);
        directedGraph.insertEdge(4,5);

        AllPathBacktracking result = new AllPathBacktracking(directedGraph, 6);

        assertEquals(3, result.getSolutionCount());
    }

    /*
    graph G{
    1 -- 2
    1 -- 3
    2 -- 4
    3 -- 5
    5 -- 6
    6 -- 2
    2 -- 6
    4 -- 5
    4 -- 7
    }
    */
    @Test
    void undirectedWithTwoEdgesOnTwoEdges(){
        undirectedGraph.insertEdge(1,2);
        undirectedGraph.insertEdge(1,3);
        undirectedGraph.insertEdge(2,4);
        undirectedGraph.insertEdge(3,5);
        undirectedGraph.insertEdge(5,6);
        undirectedGraph.insertEdge(6,2);
        undirectedGraph.insertEdge(2,6);
        undirectedGraph.insertEdge(4,5);
        undirectedGraph.insertEdge(4,7);

        int result = new AllPathBacktracking(undirectedGraph, 7).getSolutionCount();
        assertEquals(6, result);

        result = new AllPathBacktracking(undirectedGraph, 6).getSolutionCount();
        assertEquals(6, result);

        result = new AllPathBacktracking(undirectedGraph, 5).getSolutionCount();
        assertEquals(4, result);
    }

    /*
    digraph G{
    1 -> 2
    1 -> 3
    2 -> 4
    3 -> 5
    5 -> 6
    6 -> 2
    2 -> 6
    4 -> 5
    4 -> 7
    }
    */
    @Test
    void directedWithTwoEdgesOnTwoEdges(){
        directedGraph.insertEdge(1,2);
        directedGraph.insertEdge(1,3);
        directedGraph.insertEdge(2,4);
        directedGraph.insertEdge(3,5);
        directedGraph.insertEdge(5,6);
        directedGraph.insertEdge(6,2);
        directedGraph.insertEdge(2,6);
        directedGraph.insertEdge(4,5);
        directedGraph.insertEdge(4,7);

        int result = new AllPathBacktracking(directedGraph, 7).getSolutionCount();
        assertEquals(2, result);

        result = new AllPathBacktracking(directedGraph, 6).getSolutionCount();
        assertEquals(3, result);

        result = new AllPathBacktracking(directedGraph, 5).getSolutionCount();
        assertEquals(2, result);
    }

    /*
    graph G{
    1 -- 2
    2 -- 1
    2 -- 3
    3 -- 2
    3 -- 1
    1 -- 3
    }
    */
    @Test
    void undirectedCyclicDoubleEdgedGraph(){
        undirectedGraph.insertEdge(1,2);
        undirectedGraph.insertEdge(2,1);
        undirectedGraph.insertEdge(2,3);
        undirectedGraph.insertEdge(3,2);
        undirectedGraph.insertEdge(3,1);
        undirectedGraph.insertEdge(1,3);

        int result = new AllPathBacktracking(undirectedGraph, 2).getSolutionCount();
        assertEquals(6, result);

        result = new AllPathBacktracking(undirectedGraph, 3).getSolutionCount();
        assertEquals(6, result);
    }

    /*
    digraph G{
    1 -> 2
    2 -> 1
    2 -> 3
    3 -> 2
    3 -> 1
    1 -> 3
    }
    */
    @Test
    void directedCyclicDoubleEdgedGraph(){
        directedGraph.insertEdge(1,2);
        directedGraph.insertEdge(2,1);
        directedGraph.insertEdge(2,3);
        directedGraph.insertEdge(3,2);
        directedGraph.insertEdge(3,1);
        directedGraph.insertEdge(1,3);

        int result = new AllPathBacktracking(directedGraph, 2).getSolutionCount();
        assertEquals(2, result);

        result = new AllPathBacktracking(directedGraph, 3).getSolutionCount();
        assertEquals(2, result);
    }
}
