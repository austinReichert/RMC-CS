public class DynamicArray<T>{
    private int currentSize = 0;
    // CURRENTSIZE IS ALWAYS LOOKING ONE AHEAD REMEMBER
    private int maxSize;
    private T[] array;
    public DynamicArray(){}
    public DynamicArray(int maxSize){
        this.maxSize = maxSize;
        this.array = makeArray(this.maxSize);
    }
    public void add(T item){
        if (maxSize == 0 || array == null){
            maxSize = 1;
            array = makeArray(maxSize);
            // MAKE SIZE = 1 ARRAY
            array[currentSize] = item;
            // add item
            currentSize++;
            // increment
        }
        else if (currentSize == maxSize){
            maxSize = maxSize*2;
            // make size*2 array
            array = makeNewArrayAndCopy();
            // make new array and copy stuff over
            array[currentSize] = item;
            // add item
            currentSize++;
            // increment
        }
        else{
            // add item
            array[currentSize] = item;
            currentSize++;
            // iterate size up to keep track
        }
    }
    public T get(int index){
        if (array != null) {
            if (index < currentSize) {
                return array[index];
            }
        }
        return null;
    }
    public T remove(int index){
        if (array != null && index < currentSize && index > -1){
            // if we aren't working with an empty array AND the indexes are in bounds
            T removedItem = array[index];
            array[index] = null;
            // get the item now and delete it
            if (currentSize == 1){
                // if the array only has one thing
                array = null;
                maxSize = 0;
                currentSize = 0;
                //clear everything
            }
            else if (index < currentSize-1){
                // if we are not deleting from the end
                for (int i = index; i < currentSize-1; i++){
                    array[i] = array[i+1];
                    array[i+1] = null;
                }
                currentSize--;
                // shift so nulls are at end
            }
            // do nothing if we have to delete from end since the null is already at the back
            if (currentSize == (maxSize/2) && currentSize != 0){
                // if removing stuff made the currentsize 1/2 of maxsize
                // the 0 part is because it kept trying to run this too after being emptied >:(
                array = makeNewArrayAndCopyHalf();
                // make a new array of half.
            }
            return removedItem;
        }
        return null;
    }
    public int size(){
        return currentSize;
    }
    private T[] makeNewArrayAndCopy(){
        T[] newArray = makeArray(maxSize);
        if (currentSize >= 0) System.arraycopy(array, 0, newArray, 0, currentSize);
        // alt enter did this
        return newArray;
    }
    private T[] makeNewArrayAndCopyHalf(){
        T[] newArray = makeArray(currentSize);
        if (currentSize >= 0) System.arraycopy(array, 0, newArray, 0, currentSize);
        // alt enter did this
        return newArray;
    }
    @SuppressWarnings("unchecked")
    private T[] makeArray(int size){
        return (T[]) new Object[size];
    }
}
