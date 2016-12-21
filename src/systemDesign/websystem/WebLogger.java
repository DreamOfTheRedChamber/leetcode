package systemDesign.websystem;

import java.util.LinkedList;

/*
Implement a web logger, which provide two methods:

hit(timestamp), record a hit at given timestamp.
get_hit_count_in_last_5_minutes(timestamp), get hit count in last 5 minutes.
the two methods will be called with non-descending timestamp (in sec).

Have you met this question in a real interview? Yes
Example
hit(1);
hit(2);
get_hit_count_in_last_5_minutes(3);
>> 2
hit(300);
get_hit_count_in_last_5_minutes(300);
>> 3
get_hit_count_in_last_5_minutes(301);
>> 2
 * */

public class WebLogger {
    private LinkedList<Integer> timestamps;
    public WebLogger() {
        // initialize your data structure here.
        timestamps = new LinkedList<Integer>();
    }

    /**
     * @param timestamp an integer
     * @return void
     */
    public void hit(int timestamp) {
        // Write your code here
        timestamps.add(timestamp);
    }

    /**
     * @param timestamp an integer
     * @return an integer
     */
    public int get_hit_count_in_last_5_minutes(int timestamp) {
        // Write your code here
        while (!timestamps.isEmpty() && timestamps.getFirst()  + 300 <= timestamp)
            timestamps.removeFirst();
        return timestamps.size();
    }
}
