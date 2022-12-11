import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        String[] stringArray = {"X", "Z", "B", "A", "Y", "H"};
        MergeSortImplementation.mergeSort(stringArray, Comparator.naturalOrder());
        System.out.println(Arrays.toString(stringArray));
    }
}