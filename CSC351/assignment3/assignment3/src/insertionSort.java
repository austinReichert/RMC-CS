import java.util.Arrays;

public class insertionSort implements TimedTask{
    int[] arrayToSort;

    public insertionSort(int[] arrayToSort){
        this.arrayToSort = arrayToSort;
    }

    @Override
    public void execute() {
        int temp, j;
        int arraySize = arrayToSort.length;
        for (int i=0; i < arraySize; i++){
            j = i;
            while((j > 0) && (arrayToSort[j] < arrayToSort[j-1])){
                temp = arrayToSort[j];
                arrayToSort[j] = arrayToSort[j-1];
                arrayToSort[j-1] = temp;
                j--;
            }
        }
    }
}
