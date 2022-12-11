import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TimedTaskExecutor timedTaskExecutor = new TimedTaskExecutor();
        ArrayList<TimedTaskResult> results = new ArrayList<>();

        results.add(timedTaskExecutor.execute(() -> new AddLongOperation(square(1_000)), 50));
        results.add(timedTaskExecutor.execute(() -> new AddLongOperation(square(10_000)), 30));
        results.add(timedTaskExecutor.execute(() -> new AddLongOperation(square(100_000)), 10));
        // apparently these don't have 0 as a third sometimes. I have no idea why it does it and doesn't

        for (TimedTaskResult result : results) {
            System.out.println("Max trials: " + result.trials());
            System.out.println("All times: " + result.times());
            System.out.printf("Min: %d || Mean: %f || Max: %d\n", result.min(), result.mean(), result.max());
        }
    }
    public static Long square(long i){
        return (i*i);
    }
}