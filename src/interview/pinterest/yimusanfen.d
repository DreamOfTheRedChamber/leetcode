电面：
1. 给一个矩阵如下：
a b c d
e f g h
i j k l
m n o p

要求按如下方式打印：
a f k p
b g l
c h
d
e j o
i n 
m

2. 设计题：
如果要给每个Pin加上一个price tag，怎么去evaluate这是否work？
（1） A/B testing -> 可以有好几种，讨论优劣性
（2） metrics to monitor -> click rate, impression, return user ratio, etc

上门：
1. 假设Pinterest的更新系统只能显示3条更新，怎么设计？更新可以是：用户评论、
加新的pin，repin等等，一共可能有一千多种。讨论各种方法的优劣性
回答：a ranking problem...

2. 给如下的数据格式：

比如有一组数据：
1, 3, 100
2, 4, 200
5, 6, 300
。。。
这些数据时间点可能有重合。在时间段2~3之间，value的和是100+200 = 300. 找出这
组数据中最高的value和。
回答1： 用一个数组，每个cell代表一个timestamp，然后扫一遍数据，increment相应
的cell。-》 面试官：时间连续怎么办？有没有更好的办法。
答案：把数据变成：；然后按照时间排序。如果是start_time,就
+value，不然就-value：
int sum = 0;
int max = 0;

// sort by time

while(have more lines) {
if(type is start) sum += value;
else sum -= value;
if(sum > max) max = sum;
}
return max;

3. 设计一个数据结构支持O(1)的insert， remove， find random（老题）

4. java arraylist里如果满了，怎么办？为什么？
答： make a new copy, size double. 原因是：double size的时候需要拷贝原来的n
个数据，当当前这个长度为2*n的arraylist再满的时候，至少还需要插入n个数据，这
样平均每个数据的cost是在O(1)级别的

5. 怎么做weighted random sampling？（老题）

6. 有产生5的随机数，怎么生成7的？（老题）

7. 怎么去找log中的异常？outlier detection

觉得答的还可以，一个星期不到就告知被剧了，效率还是很高的。
