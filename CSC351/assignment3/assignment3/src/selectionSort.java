import java.util.Arrays;

public class selectionSort implements TimedTask{
    int[] arrayToSort;

    public selectionSort(int[] arrayToSort){
        this.arrayToSort = arrayToSort;
    }

    @Override
    public void execute() {
        int min, temp;
        int arraySize = arrayToSort.length;
        for (int i=0; i < arraySize; i++){
            min = i;
            for (int j = (i + 1); j < arraySize; j++){
                if (arrayToSort[j] < arrayToSort[min]){
                    min = j;
                }
            }
        temp = arrayToSort[i];
        arrayToSort[i] = arrayToSort[min];
        arrayToSort[min] = temp;
        }
    }
}
