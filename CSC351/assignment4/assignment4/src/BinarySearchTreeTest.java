import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTree tree;

    @BeforeEach
    void setUp() {
        int[] array = new int[0];
        tree = new BinarySearchTree(array);
    }

    @Test
    public void testNothingInListWhenEmpty(){
        assertEquals(0, tree.list().size());
    }

    @Test
    public void testOneElementInListAfterAdd(){
        tree.insert(1);
        assertEquals(List.of(1), tree.list());
    }

    @Test
    public void testTwoElementInListAfterAdds(){
        tree.insert(1);
        tree.insert(-1);
        assertEquals(Arrays.asList(-1, 1), tree.list());
    }

    @Test
    public void testTwoElementInListOrderAfterAdd(){
        tree.insert(1);
        tree.insert(2);
        assertEquals(Arrays.asList(1,2), tree.list());
    }

    @Test
    public void testManyElementsInOrderAfterAdd(){
        tree.insert(13);
        tree.insert(2);
        tree.insert(5);
        tree.insert(4);
        tree.insert(1);
        assertEquals(Arrays.asList(1,2,4,5,13), tree.list());
    }

    @Test
    public void testContains(){
        tree.insert(3);
        assertTrue(tree.contains(3));
        assertFalse(tree.contains(34));
    }
    @Test
    public void addAndDelete(){
        tree.insert(3);
        tree.insert(2);
        tree.insert(5);
        tree.insert(6);
        tree.remove(2);
        tree.remove(5);
        assertEquals(Arrays.asList(3, 6), tree.list());
    }
    @Test
    public void removeRoot(){
        tree.insert(3);
        tree.remove(3);
        assertEquals(List.of(), tree.list());
    }
    @Test
    public void removeEmptyTree(){
        tree.remove(3);
        assertEquals(List.of(), tree.list());
    }

    @Test
    public void containsEmptyTree(){
        assertFalse(tree.contains(3));
    }

    @Test
    public void removeAndAddRoot(){
        tree.insert(3);
        tree.remove(3);
        tree.insert(3);
        assertEquals(List.of(3), tree.list());
    }
    @Test
    public void removeAndAddRootAndAddOneElement(){
        tree.insert(3);
        tree.remove(3);
        tree.insert(3);
        tree.insert(6);
        assertEquals(Arrays.asList(3, 6), tree.list());
    }
    @Test
    public void minAndMax(){
        int min = 2;
        int max = 51;
        tree.insert(8);
        tree.insert(5);
        tree.insert(2);
        tree.insert(51);
        tree.insert(37);
        assertEquals(min, tree.min());
        assertEquals(max, tree.max());
    }
    @Test
    public void negativeMin(){
        int min = -13;
        tree.insert(8);
        tree.insert(-13);
        tree.insert(2);
        assertEquals(min, tree.min());
    }
}