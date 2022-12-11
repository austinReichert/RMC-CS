import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
       String[] data =  {"This", "is", "an", "Example", "of", "sorting", "Strings"};
       QuickSortImplementation.quickSort(data, Comparator.naturalOrder());
       System.out.println(Arrays.toString(data));
    }
}