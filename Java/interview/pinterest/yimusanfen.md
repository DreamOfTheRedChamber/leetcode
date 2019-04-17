提早一天到SF，P家说每天的面试可以报销50块钱的吃的，就跑去住处旁边一家日料，使劲吃.. 吃完之后想到两个月前从西雅图开车回San Diego的时候路过SF，就住在不远，两个月后还居然没找到工作，第二天还要去面一家根本进不了的公司，就悲从中来，加上吃太饱，反正感觉非常不好。

第二天去了P家办公室，那里有SF创业公司的统一特点：有点像车库.. . 鍥磋鎴戜滑@1point 3 acres
因为NDA，不方便把很详细的题目放上来，放一点大致的题目，知道这个离题目也不远了. 1point 3acres 璁哄潧

11:00 － 12:00 
首先是一个美国小哥，进来就一直打哈欠，说礼拜一，你懂的...  然后就问了点基本的问题，就开始coding。 题目和Pinterest很相关问怎么怎么创建一种data structure，可以表述对于一个pin，用户和用户间repin的关系。一开始忽略了log是按照时间先后顺序进来的，一开始思路有点混乱，一会bfs，一会dfs的，不过20多分钟之后也写完了。写完之后小哥说，有没有简单点的方法，然后我就盯着log看了一下，发现不存在先创建很低下的subtree再创建上层的node，关键点还是在于log是根据时间先后放进来的，就知道怎么做了。写完之后被他挑了一个bug，不过他一说就改掉了。写完之后好像小哥对java的Map<String, Person> map = new HashMap<String, Person>() 这个很感兴趣，就问为什么前面不直接写HashMap，我就扯了扯java的polymorphysm， 以及这样用interface在stack上创建object的好处，然后时间就到了

12:00 － 12:30. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴
午餐是和本学校的一个上一届目前在P工作的大牛学长吃饭的，之前就取得过联系，没机会吃过Google， Facebook等公司的午餐所以无法比较，但是总的来说还是很不错的。

12:30 － 1:00 . 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴
和一个在growth team的engineer（听口音好像是法国人）做了cultural fit的interview。她一进来就说这只是cultural fit, 没什么大问题..之类的，让我放松不少，更像是一个behavioral interview。就讨论了下一些scenario，怎么处理之类的。我提到到了怎样提高Pinterest在男性用户中得到青睐， 比如多放一些男性用户repin过的pin，来让我们感兴趣。她还问如果和别的组员意见不一怎么办，我就说可以做下用户测试，比方说iOS的test flight，让1000个用户采取我的方式，另外1000个用户采取别的方式，看哪个方式比较好. stats speak louder than words

1:00 - 2:00
一个国人小哥来面试system design，具体讨论了下P家每个pin背后都有一个url，以及需要进行web crawling来得到关于这个pin的信息，设计一个这样的系统，有些什么tradeoff等等问题。

2:00 － 3:00
一个台湾女生（真是大神， new grad毕业后去了pre－ipo的Twitter，然后两年前跳到了Pin， 现在还很年轻）面试。前20分钟基本在讨论project，以及过去的经历等等（似乎她不是很在乎coding面试），然后很详细问了问我在amazon实习时候的project。聊得差不多了她说，那就做做题目吧！于是给我出了一题算法题，是道fb的高频题。这题我之前和朋友讨论过，然后就直接跟她说了解法，她就让我写code。写code的时候，似乎她也不在乎我怎么写，一直在看手机.. 可能觉得我算法知道了写出来应该问题不大，还是说完全对我放弃了？然后搞定之后她一直问怎样提高效率，我说Asymptatically肯定没法提高了，因为已经是O(n)了，但是可以进行剪枝，遇到一定条件就可以break，她说没错。 然后看看还有时间，她说那我们再做一题吧，就出了leetcode上一道类似找最大triangle的题目，就写了code，然后说有没有更优解，于是我就顿时卡住了，因为只做过暴力解... 于是她提示说用DP，然后再根据多一点提示才想出了DP的办法，可是她不要求写code，只是想要说思路，就跟她说了说思路，她说ok。从头到尾她似乎就不怎么care coding的感觉。

过了一个礼拜后recruiter打电话来说给offer，总的感觉面试运气很好，不然肯定挂，我有几个大牛同学就因为运气不好挂了。

报下package：12万base  16万 options/stock, 5万sign－on， 5千的一次性旅游费

面试注意点：. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴
1） 反应要快，不能卡住，卡住的话面试官会提示，一定要马上接下去他的思路，最好不要卡住
2） 口语很重要，交流要尽量做到很无障碍很愉快. more info on 1point3acres.com



补充内容 (2014-11-21 12:20):. 1point3acres.com/bbs
Pinterest内推可以加群 385022929 群里大牛多，一起做题也不错



Coding 1) K-way merge sort 2) LRU


deep copy of a graph. From 1point 3acres bbs
may contains cycle
以及各种附加问题
也不是很难的题，写出了一个bug，哭一下。。。不知道能不能过攒rp


没签NDA神马的，攒人品了~
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
<start_time, end_time, value>
比如有一组数据：
1, 3, 100
2, 4, 200
5, 6, 300
。。。
这些数据时间点可能有重合。在时间段2~3之间，value的和是100+200 = 300. 找出这
组数据中最高的value和。
回答1： 用一个数组，每个cell代表一个timestamp，然后扫一遍数据，increment相应
的cell。-》 面试官：时间连续怎么办？有没有更好的办法。
答案：把数据变成：<type, time, value>；然后按照时间排序。如果是start_time,就
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