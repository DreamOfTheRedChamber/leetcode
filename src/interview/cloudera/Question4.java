package interview.cloudera;

/* 2016年04月22日
 * 电面: 
1. 实现一个histogram, 能inc/get每种metric的counter.     
void incCounter(String metric)
int getCounter(String metric)
2. followup: 修改以上histogram应付并发读写


onsite: 
1. how to create a generic singleton class
2. 求integer流中最近k条数据的avg

public class KAvg {
    public KAvg(int k );

    public void add(int x);
   
    public int getKAvg();
}

followup: 并发add/getAvg

3. 用AtomicLong或compareAndSwap原语实现spin_lock, spin_semaphore, reentrant_
spin_lock
描述spin_lock的self deadlock情况

4. design whatsapp

5. behavior/ team conflict/strength/weakpoint

6. go through background

 * */

public class Question4 {

}
