public class AddLongOperation implements TimedTask{
    long numberToGoTo;
    long numberToAdd = 0;

    public AddLongOperation(long numberToGoTo){
        this.numberToGoTo = numberToGoTo;
    }
    // constructor
    @Override
    public void execute() {
        while (numberToAdd < numberToGoTo) {
            numberToAdd++;
        }
    }
    // implemented method
}
