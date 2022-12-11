import java.util.Arrays;

public class PriorityQueue {
    private int[] queue;
    private int size = 0;
    // number of queue elements (N in book)

    public PriorityQueue(){
        this.queue = new int[]{0};
        // make it so we start at 1
    }
    public void add(int number){
        if (size < queue.length-1){
            size++;
            queue[size] = number;
            bubbleUp(size);
        }
    }
    public int size(){
        return size;
    }
    public Integer takeMin(){
        Integer min = null;
        if (size > 0){
            min = queue[1];
            // save min
            queue[1] = queue[size];
            size--;
            bubbleDown(1);
        }
        return min;
    }
    private void bubbleUp(int element){
        if (getParent(element) == -1){
            return;}
        if (queue[getParent(element)] > queue[element]){
            swap(element, getParent(element));
            bubbleUp(getParent(element));
        }
    }
    private void bubbleDown(int element){
        int childIndex, minIndex, i;
        childIndex = getChild(element);
        minIndex = element;
        for (i = 0; i <= 1; i++){
            if((childIndex+i) <= size){
                if(queue[minIndex] > queue[childIndex+i]){
                    minIndex = childIndex + i;
                }
            }
        }
        if (minIndex != element){
            swap(element, minIndex);
            bubbleDown(minIndex);
        }
    }
    private void swap(int indexOne, int indexTwo){
        int temp = queue[indexOne];
        queue[indexOne] = queue[indexTwo];
        queue[indexTwo] = temp;
    }
    private int getParent(int index){
        if (index == 1){
            return -1;
        }
        else{
            return (index/2);
        }
    }
    private int getChild(int index){
        return (2 * index);
    }
    public void makeHeap(int[] array, int amountOfElements){
        makeQueue(amountOfElements);
        for (int i = 0; i < array.length; i++){
            add(array[i]);
        }
    }
    public int[] heapSort(){
        int[] minArray = new int[size];
        if(size > 0) {
            int currentSize = size;
            for (int i = 0; i < currentSize; i++) {
                minArray[i] = takeMin();
            }
        }
        return minArray;
    }
    private void makeQueue(int queueSize){
        if(queueSize > 0) {
            queue = Arrays.copyOf(queue, (queueSize+1));
        }
    }
}
