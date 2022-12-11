import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Comparator;

public class MergeSortTest {
    Integer[] unsortedIntArray = {3, 61, 196, 10, 35, 12, 7};
    Integer[] sortedIntArray = {3, 7, 10, 12, 35, 61, 196};
    String[] unsortedStringArray = {"This", "is", "an", "Example", "of", "sorting", "Strings"};
    String[] sortedStringArray = {"Example", "Strings", "This", "an", "is", "of", "sorting"};

    @BeforeEach
    void setUp(){}

    @Test
    void MergeSortWorksOnIntegerArray(){
        MergeSortImplementation.mergeSort(unsortedIntArray, Comparator.naturalOrder());
        Assertions.assertArrayEquals(sortedIntArray, unsortedIntArray);
    }
    @Test
    void MergeSortWorksOnStringArray(){
        MergeSortImplementation.mergeSort(unsortedStringArray, Comparator.naturalOrder());
        Assertions.assertArrayEquals(sortedStringArray, unsortedStringArray);
    }
    @Test
    void MergeSortDoesntWorkOnEmptyArray(){
        String[] emptyArray = {};
        MergeSortImplementation.mergeSort(emptyArray, Comparator.naturalOrder());
        Assertions.assertArrayEquals(emptyArray, emptyArray);
    }
    @Test
    void MergeSortDoesntWorkOnOneSizedArray(){
        Integer[] oneSizedArray = {31};
        MergeSortImplementation.mergeSort(oneSizedArray, Comparator.naturalOrder());
        Assertions.assertArrayEquals(oneSizedArray, oneSizedArray);
    }
    @Test
    void MergeSortWorksOnTwoSizedIntegerArray(){
        Integer[] unsortedTwoSizedArray = {31, 2};
        Integer[] sortedTwoSizedArray = {2, 31};
        MergeSortImplementation.mergeSort(unsortedTwoSizedArray, Comparator.naturalOrder());
        Assertions.assertArrayEquals(sortedTwoSizedArray, unsortedTwoSizedArray);
    }
    @Test
    void MergeSortWorksOnTwoSizedStringArray(){
        String[] unsortedTwoSizedArray = {"Pizza", "Hamburger"};
        String[] sortedTwoSizedArray = {"Hamburger", "Pizza"};
        MergeSortImplementation.mergeSort(unsortedTwoSizedArray, Comparator.naturalOrder());
        Assertions.assertArrayEquals(sortedTwoSizedArray, unsortedTwoSizedArray);
    }
    @Test
    void MergeSortWorksOnStringsWithNumbersOnly(){
        String[] unsortedStringArray = {"51", "16", "13", "601", "219", "16103", "9", "2", "-2", "-1315", "-3", "85", "221"};
        // sorts by first character I think? then second etc...
        String[] sortedStringArray = {"-1315", "-2", "-3", "13", "16", "16103", "2", "219", "221", "51", "601", "85", "9"};
        MergeSortImplementation.mergeSort(unsortedStringArray, Comparator.naturalOrder());
        Assertions.assertArrayEquals(sortedStringArray, unsortedStringArray);
    }
    @Test
    void MergeSortWorksOnFiftySizedIntegerArray(){
        Integer[] unsortedFiftySizedArray = {417201, -378899, 849628, 825141, -857959, -137536, -559317, 237436, -227212, -14742, -685756, -477719, -776213, -760291, -177668, 289250, 485008, 881877, -901102, -550845, 960443, 989684, 993806, 874413, 555405, -577817, 638719, -936349, -950362, -392707, -439681, 848989, 82827, 368490, 467894, -863955, 207429, -301824, 100158, -998131, 704309, -581131, -446872, 794814, -767408, -817155, 326328, -168450, -299419, -397297};
        Integer[] sortedFiftySizedArray = {-998131,-950362,-936349,-901102,-863955,-857959,-817155,-776213,-767408,-760291,-685756,-581131,-577817,-559317,-550845,-477719,-446872,-439681,-397297,-392707,-378899,-301824,-299419,-227212,-177668,-168450,-137536,-14742,82827,100158,207429,237436,289250,326328,368490,417201,467894,485008,555405,638719,704309,794814,825141,848989,849628,874413,881877,960443,989684,993806};
        MergeSortImplementation.mergeSort(unsortedFiftySizedArray, Comparator.naturalOrder());
        Assertions.assertArrayEquals(sortedFiftySizedArray, unsortedFiftySizedArray);
    }
}
