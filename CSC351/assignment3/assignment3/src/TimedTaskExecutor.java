import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


public class TimedTaskExecutor {
    public TimedTaskExecutor(){}

    public TimedTaskResult execute(Supplier<TimedTask> suppliedTime){
        // make way to return results
        long initTime;
        TimedTask addLong = suppliedTime.get();
        initTime = System.currentTimeMillis(); // start init time
        addLong.execute(); // run
        long timedTaskResult = (System.currentTimeMillis() - initTime);
        return new TimedTaskResult(timedTaskResult);
    }
}
