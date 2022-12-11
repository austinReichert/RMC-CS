import java.util.Comparator;

public class QuickSortImplementation<Type>{
    public static <Type> void quickSort(Type[] toSort, Comparator<Type> comparator){
        if (toSort.length > 0) {
            QuickSortImplementation<Type> qs = new QuickSortImplementation<>();
            qs.actualQuickSort(0, (toSort.length-1), toSort, comparator);
        }
    }
    private void actualQuickSort(int low, int high, Type[] toSort, Comparator<Type> comparator){
        int partitionIndex;
        if ((high-low)>0){
            partitionIndex = partition(low, high, toSort, comparator);
            actualQuickSort(low, partitionIndex-1, toSort, comparator);
            actualQuickSort(partitionIndex+1, high, toSort, comparator);
        }
    }
    private int partition(int low, int high, Type[] toSort, Comparator<Type> comparator){
        int i;
        int pivotIndex;
        int firstHigh;
        pivotIndex = high;
        firstHigh = low;
        for(i=low;i<high;i++){
            if(comparator.compare(toSort[i], toSort[pivotIndex]) < 0){
                // - -> (<) // 0 -> (=) // + -> (>)
                // this means we are checking if it is equal to or below 0
                swap(i, firstHigh, toSort);
                firstHigh++;
            }
        }
        swap(pivotIndex, firstHigh, toSort);
        return firstHigh;
    }
    private void swap(int indexOne, int indexTwo, Type[] array){
        Type itemOne = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = itemOne;
    }
}
