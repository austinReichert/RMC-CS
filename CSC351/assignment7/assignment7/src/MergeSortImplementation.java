import java.util.Comparator;
import java.util.LinkedList;

public class MergeSortImplementation<Type>{
    public static <Type> void mergeSort(Type[] toSort, Comparator<Type> comparator){
            MergeSortImplementation<Type> ms = new MergeSortImplementation<>();
            ms.actualMergeSort(0, toSort.length, toSort, comparator);
    }
    private void actualMergeSort(int low, int high, Type[] toSort, Comparator<Type> comparator){
        if (high - low <= 1){return;}
        int middle;
        middle = ((low + high) / 2);
        actualMergeSort(low, middle, toSort, comparator);
        actualMergeSort(middle, high, toSort, comparator);
        merge(low, middle, high, toSort, comparator);
    }
    private void merge(int low, int middle, int high, Type[] toSort, Comparator<Type> comparator){
        int i;
        LinkedList<Type> bufferOne = new LinkedList<>();
        LinkedList<Type> bufferTwo = new LinkedList<>();
        for(i = low; i < middle; i++){bufferOne.addLast(toSort[i]);}
        for(i = middle; i < high; i++){bufferTwo.addLast(toSort[i]);}
        i = low;
        while (!(bufferOne.isEmpty()) && !(bufferTwo.isEmpty())) {
                if (comparator.compare((bufferOne.peekFirst()), (bufferTwo.peekFirst())) <= 0) {
                    // - -> (<) // 0 -> (=) // + -> (>) // [this means we are checking if it is equal to or below 0]
                    toSort[i++] = bufferOne.removeFirst();
                } else {
                    toSort[i++] = bufferTwo.removeFirst();
                }
        }
        while(!(bufferOne.isEmpty())){
            toSort[i++] = bufferOne.removeFirst();
        }
        while(!(bufferTwo.isEmpty())){
            toSort[i++] = bufferTwo.removeFirst();
        }
    }
}
