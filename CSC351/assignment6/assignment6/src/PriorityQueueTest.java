import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {
    PriorityQueue pq;
    int[] queueToBuild = {3, 6, 1};
    int[] sortedArray = {1,3,6};
    int[] emptyQueueToBuild = {};

    @BeforeEach
    void setUp(){
        this.pq = new PriorityQueue();
    }
    @Test
    void SizeWorks(){
        pq.makeHeap(queueToBuild, queueToBuild.length);
        assertEquals(3, pq.size());
    }
    @Test
    void QueueSizeGrowsWithAdds(){
        pq.makeHeap(queueToBuild, ((queueToBuild.length)+5));
        assertEquals(3, pq.size());
        pq.add(61);
        assertEquals(4, pq.size());
        pq.add(96);
        pq.add(66);
        assertEquals(6, pq.size());
    }
    @Test
    void MakeEmptyQueueAndFillItWithAdds(){
        pq.makeHeap(emptyQueueToBuild, 30);
        for(int i = 1; i < 31; i++){
            pq.add(i);
        }
        assertEquals(30, pq.size());
    }
    @Test
    void BuildingEmptyQueueFails(){
        pq.makeHeap(emptyQueueToBuild, emptyQueueToBuild.length);
        assertEquals(0,pq.size());
    }
    @Test
    void BuildingQueueWithDifferentSize(){
        pq.makeHeap(queueToBuild, 2);
        assertEquals(2, pq.size());
    }
    @Test
    void TakeMinReturnsMin(){
        pq.makeHeap(queueToBuild, queueToBuild.length);
        assertEquals(1, pq.takeMin());
        assertEquals(3, pq.takeMin());
        assertEquals(6, pq.takeMin());
    }
    @Test
    void TakeMinOnEmptyQueueReturnsNull(){
        pq.makeHeap(emptyQueueToBuild, emptyQueueToBuild.length);
        assertNull(pq.takeMin());
    }
    @Test
    void TakeMinOfAllQueueReturnsNull(){
        pq.makeHeap(queueToBuild, queueToBuild.length);
        assertEquals(1, pq.takeMin());
        assertEquals(3, pq.takeMin());
        assertEquals(6, pq.takeMin());
        assertNull(pq.takeMin());
    }
    @Test
    void HeapSortWorks(){
        pq.makeHeap(queueToBuild, queueToBuild.length);
        int[] minArray = pq.heapSort();
        assertArrayEquals(minArray, sortedArray);
    }
    @Test
    void HeapSortOnEmptyQueueReturnsEmptyArray(){
        pq.makeHeap(queueToBuild, 0);
        int[] minArray = pq.heapSort();
        assertArrayEquals(minArray, emptyQueueToBuild);
    }
    @Test
    void HeapSortOnBigQueue(){
        int[] bigArray = {3, 16, 5, 10, 35, 12, 51, 38, 27, 19, 73, 1, 22, 84, 98};
        int[] sortedBigArray = {1, 3, 5, 10, 12, 16, 19, 22, 27, 35, 38, 51, 73, 84, 98};
        pq.makeHeap(bigArray, bigArray.length);
        int[] minArray = pq.heapSort();
        assertArrayEquals(minArray, sortedBigArray);
    }
    @Test
    void HeapSortOnBigRANDOMQueue(){
        Random random = new Random();
        int[] bigArray = new int[50];
        for(int i = 0; i < 51; i++){
            bigArray[0] = random.nextInt();
        }
        pq.makeHeap(bigArray, bigArray.length);
        int[] sortedBigArray = bigArray.clone();
        Arrays.sort(sortedBigArray);
        int[] minArray = pq.heapSort();
        assertArrayEquals(minArray, sortedBigArray);
    }
    @Test
    void AddAfterHeapsort(){
        pq.makeHeap(queueToBuild,queueToBuild.length);
        pq.heapSort();
        pq.add(51);
        assertEquals(1, pq.size());
        pq.add(91601);
        pq.add(165);
        assertEquals(3, pq.size());
    }
}
