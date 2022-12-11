import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        TimedTaskExecutor timedTaskExecutor = new TimedTaskExecutor();
        ArrayList<TimedTaskResult> results = new ArrayList<>();

        int[] arraySizes = {1, 10, 100, 1_000, 10_000, 100_000, 1_000_000};
        int i = 0; // iterator for printing above stuffs

        // used this block to test all 3 for times
        for (int arraySize : arraySizes){
            int[] array = randomOrderedInts(arraySize);
            results.add(timedTaskExecutor.execute(() -> new librarySort(array)));
        }
        System.out.println("Random");
        for (TimedTaskResult result : results) {
            System.out.printf("Time for data size of %d: %d\n", arraySizes[i], result.time());
            i++;
        }

        i = 0;
        System.out.println("\nReverse");
        results.clear();
        for (int arraySize : arraySizes){
            int[] array = reverseOrderedInts(arraySize);
            results.add(timedTaskExecutor.execute(() -> new librarySort(array)));
        }
        for (TimedTaskResult result : results) {
            System.out.printf("Time for data size of %d: %d\n", arraySizes[i], result.time());
            i++;
        }

        i = 0;
        System.out.println("\nOrdered");
        results.clear();
        for (int arraySize : arraySizes){
            int[] array = orderedInts(arraySize);
            results.add(timedTaskExecutor.execute(() -> new librarySort(array)));
        }
        for (TimedTaskResult result : results) {
            System.out.printf("Time for data size of %d: %d\n", arraySizes[i], result.time());
            i++;
        }
    }

    public static int[] randomOrderedInts(int size){
        int[] data = new int[size];
        Random r = new Random();
        for(int i = 0; i < size; i++){
            data[i] = r.nextInt();
        }
        return data;
    }
    public static int[] orderedInts(int size){
        int[] data = new int[size];
        for(int i = 0; i < size; i++){
            data[i] = i;
        }
        return data;
    }
    public static int[] reverseOrderedInts(int size){
        int[] data = new int[size];
        for(int i = 0; i < size; i++){
            data[i] = ((size-1)-i);
        }
        return data;
    }
}
