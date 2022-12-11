import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


public class TimedTaskExecutor {
    public TimedTaskExecutor(){}

    public TimedTaskResult execute(Supplier<TimedTask> suppliedTime, int trials){
        List<Long> timedTaskResult = new ArrayList<>();
        // make way to return results
        while (trials > 0){
            long initTime, endTime, trialTime;
            TimedTask addLong = suppliedTime.get();
            initTime = System.currentTimeMillis(); // start init time
            addLong.execute(); // run
            endTime = System.currentTimeMillis(); // get exit time
            trialTime = endTime - initTime; // do math (END - START)
            timedTaskResult.add(trialTime); // add to TimedTaskResult
            --trials;
        }
        return new TimedTaskResult(timedTaskResult);
    }
}
