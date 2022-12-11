import java.util.Arrays;
public class librarySort implements TimedTask{
    int[] arrayToSort;

    public librarySort(int[] arrayToSort){
        this.arrayToSort = arrayToSort;
    }

    @Override
    public void execute() {
        Arrays.sort(arrayToSort);
    }
}
