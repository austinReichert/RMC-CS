import java.util.List;

public class TimedTaskResult {
    List<Long> listOfTimes;
    public TimedTaskResult(List<Long> listOfTimes) {
        this.listOfTimes = listOfTimes;
    }
    // constructor
    public Long max(){
        if (checkIsEmpty()){ return 0L;}
        else if (checkIsSizeOne()) { return listOfTimes.get(0);}
        Long maxTime = listOfTimes.get(0);
        for (Long time : listOfTimes){
            if (maxTime < time){
                maxTime = time;
                // check if the currentTime > maxTime, if so update it
            }
        }
        return maxTime;
    }
    // return long max
    public Double mean(){
        if (checkIsEmpty()){ return 0.0;}
        else if (checkIsSizeOne()) { return (double)listOfTimes.get(0);}
        double mean = 0.0;

        for (Long time : listOfTimes){
            mean += time;
        }
        mean = (mean/listOfTimes.size());
        return mean;
    }
    // return double average
    public Long min(){
        if (checkIsEmpty()){ return 0L;}
        else if (checkIsSizeOne()) { return listOfTimes.get(0);}
        Long minTime = listOfTimes.get(0);
        for (Long time : listOfTimes){
            if (minTime > time){
                minTime = time;
                // check if the currentTime > maxTime, if so update it
            }
        }
        return minTime;
    }
    // return long min

    public List<Long> times(){
        return listOfTimes;
    }
    // returns a list of longs

    public int trials(){
        return listOfTimes.size();
    }
    // returns int size

    // special cases
    public Boolean checkIsEmpty(){
        return this.listOfTimes.size() == 0;
    }
    public Boolean checkIsSizeOne(){
        return this.listOfTimes.size() == 1;
    }
}
