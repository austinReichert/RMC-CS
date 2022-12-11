import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class GraphTests {
    CycleFinderVisitor cyclicVisitor = new CycleFinderVisitor();
    CycleFinderVisitor acyclicVisitor = new CycleFinderVisitor();
    LinkedList<Integer> cycleResults;
    Graph acyclicSmallGraph = new Graph(true);
    Graph cyclicSmallGraph = new Graph(true);
    Graph acyclicLargeGraph = new Graph(true);
    Graph cyclicLargeGraph = new Graph(true);
    Graph circleGraph = new Graph(true);
    Graph oneEdgeGraph = new Graph(true);
    Graph emptyGraph = new Graph(true);
    LinkedList<Integer> expectedResults;

    @BeforeEach
    void setUp(){
        cyclicSmallGraph.insertEdge(0,1);
        cyclicSmallGraph.insertEdge(1,2);
        cyclicSmallGraph.insertEdge(2,3);
        cyclicSmallGraph.insertEdge(3,1);
        cyclicSmallGraph.insertEdge(0,4);

        acyclicSmallGraph.insertEdge(0,1);
        acyclicSmallGraph.insertEdge(1,2);
        acyclicSmallGraph.insertEdge(2,3);
        acyclicSmallGraph.insertEdge(0,4);

        acyclicLargeGraph.insertEdge(0,1);
        acyclicLargeGraph.insertEdge(0,2);
        acyclicLargeGraph.insertEdge(1,3);
        acyclicLargeGraph.insertEdge(2,5);
        acyclicLargeGraph.insertEdge(3,4);
        acyclicLargeGraph.insertEdge(4,6);
        acyclicLargeGraph.insertEdge(4,7);
        acyclicLargeGraph.insertEdge(4,8);
        acyclicLargeGraph.insertEdge(5,9);
        acyclicLargeGraph.insertEdge(5, 10);

        cyclicLargeGraph.insertEdge(0,1);
        cyclicLargeGraph.insertEdge(0,2);
        cyclicLargeGraph.insertEdge(1,3);
        cyclicLargeGraph.insertEdge(2,5);
        cyclicLargeGraph.insertEdge(3,4);
        cyclicLargeGraph.insertEdge(4,6);
        cyclicLargeGraph.insertEdge(4,7);
        cyclicLargeGraph.insertEdge(4,8);
        cyclicLargeGraph.insertEdge(5,9);
        cyclicLargeGraph.insertEdge(9, 10);
        cyclicLargeGraph.insertEdge(10,5);

        circleGraph.insertEdge(0,1);
        circleGraph.insertEdge(1,2);
        circleGraph.insertEdge(2,3);
        circleGraph.insertEdge(3,4);
        circleGraph.insertEdge(4,5);
        circleGraph.insertEdge(5,6);
        circleGraph.insertEdge(6,0);

        oneEdgeGraph.insertEdge(0,1);
    }

    @Test
    void CycleWorksOnSmallGraph(){
        expectedResults = new LinkedList<>(Arrays.asList(1,2,3));

        cyclicSmallGraph.traverseDepthFirst(0, cyclicVisitor);
        cycleResults = cyclicVisitor.getCycle();
        Assertions.assertEquals(expectedResults, cycleResults);

        acyclicSmallGraph.traverseDepthFirst(0,acyclicVisitor);
        cycleResults = acyclicVisitor.getCycle();
        Assertions.assertNull(cycleResults);
    }
    @Test
    void CycleWorksOnLargeGraph(){
        expectedResults = new LinkedList<>(Arrays.asList(5,9,10));
        cyclicLargeGraph.traverseDepthFirst(0, cyclicVisitor);
        cycleResults = cyclicVisitor.getCycle();
        Assertions.assertEquals(expectedResults, cycleResults);

        acyclicLargeGraph.traverseDepthFirst(0,acyclicVisitor);
        cycleResults = acyclicVisitor.getCycle();
        Assertions.assertNull(cycleResults);
    }
    @Test
    void CycleWorksOnCircle(){
        expectedResults = new LinkedList<>(Arrays.asList(0,1,2,3,4,5,6));

        circleGraph.traverseDepthFirst(0, cyclicVisitor);
        cycleResults = cyclicVisitor.getCycle();
        Assertions.assertEquals(expectedResults, cycleResults);
    }
    @Test
    void CycleDoesNothingOnEmptyGraph(){
        emptyGraph.traverseDepthFirst(0, cyclicVisitor);
        cycleResults = cyclicVisitor.getCycle();
        Assertions.assertNull(cycleResults);
    }
    @Test
    void CycleDoesNothingOnOneEdgeGraph(){
        oneEdgeGraph.traverseDepthFirst(0, cyclicVisitor);
        cycleResults = cyclicVisitor.getCycle();
        Assertions.assertNull(cycleResults);
    }
}
