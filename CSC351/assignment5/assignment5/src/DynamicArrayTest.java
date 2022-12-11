import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicArrayTest {
    private DynamicArray<String> stringDynamicArray;
    private DynamicArray<Integer> integerDynamicArray;

    @BeforeEach
    void setUp(){
        this.integerDynamicArray = new DynamicArray<>(0);
        this.stringDynamicArray = new DynamicArray<>(0);
    }

    @Test
    public void addingToEmptyArray(){
        // add to empty array
        integerDynamicArray.add(1);
        stringDynamicArray.add("hi");
        // test if something is in it
        assertEquals(1, integerDynamicArray.get(0));
        assertEquals("hi", stringDynamicArray.get(0));
    }
    @Test
    public void getFromEmptyArray(){
        assertNull(integerDynamicArray.get(1));
        assertNull(stringDynamicArray.get(1));
    }
    @Test
    public void removeFromEmptyArray(){
        assertNull(integerDynamicArray.remove(3));
        assertNull(stringDynamicArray.remove(2));
    }
    @Test
    public void getFromArrayOfTwo(){
        integerDynamicArray.add(2);
        integerDynamicArray.add(4);
        stringDynamicArray.add("hi");
        stringDynamicArray.add("bye");
        assertEquals(2, integerDynamicArray.get(0));
        assertEquals(4, integerDynamicArray.get(1));
        assertEquals("hi", stringDynamicArray.get(0));
        assertEquals("bye", stringDynamicArray.get(1));
    }
    @Test
    public void addThenRemoveThenGetFromArray(){
        integerDynamicArray.add(3);
        integerDynamicArray.remove(0);
        assertNull(integerDynamicArray.get(0));
    }
    @Test
    public void addThenRemoveThenAddAgainThenGetFromArray(){
        integerDynamicArray.add(3);
        integerDynamicArray.remove(0);
        integerDynamicArray.add(156);
        assertEquals(156, integerDynamicArray.get(0));
    }
    @Test
    public void removeOutOfIndex(){
        integerDynamicArray.add(43);
        stringDynamicArray.add("hi");
        assertNull(integerDynamicArray.remove(3));
    }
    @Test
    public void getOutOfIndex(){
        integerDynamicArray.add(3);
        assertNull(integerDynamicArray.get(3));
    }
    // shift means size shift not number shift
    @Test
    public void addBunchOfItemsAndRemoveOneWithoutShift(){
        integerDynamicArray.add(5);
        integerDynamicArray.add(32);
        integerDynamicArray.add(6);
        integerDynamicArray.add(-3);
        integerDynamicArray.add(4);
        integerDynamicArray.add(1256);
        integerDynamicArray.add(8);
        integerDynamicArray.add(-12);
        integerDynamicArray.add(13);
        integerDynamicArray.remove(6);
        assertNotEquals(integerDynamicArray.get(6),8);
        assertEquals(integerDynamicArray.get(6), -12);
        // shift + removal
    }
    @Test
    public void addBunchOfItemsAndRemoveOneWithOneShift(){
        integerDynamicArray.add(5);
        integerDynamicArray.add(32);
        integerDynamicArray.add(6);
        integerDynamicArray.add(-3);
        integerDynamicArray.add(4);
        integerDynamicArray.add(1256);
        integerDynamicArray.add(8);
        integerDynamicArray.add(-12);
        integerDynamicArray.remove(6);
        assertNotEquals(integerDynamicArray.get(6),8);
        assertEquals(integerDynamicArray.get(6), -12);
        // shift + removal
    }
    @ Test
    public void addBunchOfItemsAndRemoveFourWithTwoShift(){
        integerDynamicArray.add(5);
        integerDynamicArray.add(32);
        integerDynamicArray.add(6);
        integerDynamicArray.add(-3);
        integerDynamicArray.add(4);
        integerDynamicArray.add(1256);
        integerDynamicArray.add(8);
        integerDynamicArray.add(-12);
        integerDynamicArray.remove(4);
        integerDynamicArray.remove(4);
        integerDynamicArray.remove(4);
        integerDynamicArray.remove(4);
        assertEquals(integerDynamicArray.get(3),-3);
    }
    @Test
    public void addBunchOfItemsAndRemoveAll(){
        integerDynamicArray.add(5);
        integerDynamicArray.add(32);
        integerDynamicArray.add(6);
        integerDynamicArray.add(-3);
        integerDynamicArray.add(4);
        integerDynamicArray.add(1256);
        integerDynamicArray.add(8);
        integerDynamicArray.add(-12);
        integerDynamicArray.remove(0);
        integerDynamicArray.remove(0);
        integerDynamicArray.remove(0);
        integerDynamicArray.remove(0);
        integerDynamicArray.remove(0);
        integerDynamicArray.remove(0);
        integerDynamicArray.remove(0);
        integerDynamicArray.remove(0);
        assertNull(integerDynamicArray.get(0));
    }
    @Test
    public void sizeWorksWithAdds(){
        integerDynamicArray.add(3);
        integerDynamicArray.add(2);
        integerDynamicArray.add(1);
        integerDynamicArray.add(4);
        assertEquals(integerDynamicArray.size(), 4);
    }
    @Test
    public void sizeWorksWithAddsAndOneRemove(){
        integerDynamicArray.add(3);
        integerDynamicArray.add(2);
        integerDynamicArray.add(1);
        integerDynamicArray.add(4);
        integerDynamicArray.remove(0);
        assertEquals(integerDynamicArray.size(), 3);
    }
}
