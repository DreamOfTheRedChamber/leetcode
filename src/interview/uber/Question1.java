package interview.uber;

/* 
1. 3个长度一样的array a1, a2, a3, 找出所有 A + B = C 的组合，A在a1里，B在a2，C在a3里；扩展到4个数组 a2, a2, a3, a4，找出A+B+C=D的组合。。 然后扩展到n各数组；做完了又给了一道题目，不难，忘了。。
2. 一个系统里面，有user 在不断的login and logout, 现在给你几组user的（username, login_time, logout_time)的数据，打印出各个时间点系统有几个active user；follow-up，修改我的实现，让我的函数支持 类似JS的callback机制
3. 面我的是一个中国人神牛。因为我说我用c++,然后感觉他临时选了这道题给我。。 reader-writer problem. 用mutex 实现user-writer problem。 follow-up，问会有什么问题，其实会有starving 的情况发生，然后一起商量怎么处理


还有第二题，暴力的话就是所有user过一遍，咱后对其active的时间段，每个时间点的active user数量加一，这样复杂度就是O(m×n)，m个user，n个时间点
.鏈枃鍘熷垱鑷�1point3acres璁哄潧
优化的话，用两个hashtable存储某个时间点新上线和下线的人数，所有user过一遍，然后只对开始的时间点上线人数和结束的时间点下线人数加一。再过一遍所有的时间点，根据hashtable对上一个时间点update得到当前时间点人数，这样复杂度就是O(max(m, n))

http://www.1point3acres.com/bbs/thread-114976-1-1.html

 * */

public class Question1 {

}
