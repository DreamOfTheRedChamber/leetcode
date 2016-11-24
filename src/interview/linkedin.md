一个是判断括号是否匹配，一个是层序遍历，follow up按格式print。level order脑抽连特别简单的follow up都答得不

1、Valid parentheses。不同的是只有圆括号，而且string里可能有其它数字或加减号，直接设一个counter计左括号数，遇到左括号counter++，右括号counter--，每次check if (counter < 0)，是就return false，最后check counter是否为0，不为0也return false。
2、Search in Rotated Sorted Array I & II。原题，注意可以包含duplicates。
3、Nested List Weight Sum。

先讲Project。我在cmu做的是web方面的project，这个面试官似乎很感兴趣问了很多，包括怎么test遇到什么问题performance什么的，讲的还不错。然后是两个coding:

1. Deepest comman ancestor (with parent nodes). LinkedIn这题都快问烂了...我说了用hashmap的方法，他说你能不能不用额外空间，我想了一下又说了那个把两个节点调到一个高度的做法。
2. 实现一个Max Stack， 支持peekMax() 和popMax(). 很自然地用两个栈去做，但是这样popMax的时候很费时间。然后我又加了一个stack存的是max value的index, 把stack全变成ArrayList, 然后就开始纠结pop了。。。结果corner case太多没写完。。。不过他也说这题要简单clean是比较难

valid parenthese
2sum interface.

1. 自我介绍
2. 介绍一下之前的工作经历和项目，然后最喜欢哪个部分
3. Sum of NestedInteger
4. Two Sum III 两种方法

去年年底的LinkedIn面经~~两轮phone。听朋友讲都是地里的面经题。。。但没刷过地里面经表示LinkedIn对本科还是挺友好的，题都不难

第一面：
1. leetcode – kth largest原题
我一开始说用heap来做，面试官就问我runtime然后接着问我can u do better? 没办法，还是写了k select的做法

2. weighted sum, 根据depth来求sum
e.g. {1, 2, {4, {6} } } return 29原因：depth 1 有 1 2, depth 2 有 4,depth 3 有 6, 即 (1 + 2) * 1 + 4 * 2 + 6 * 3 = 29

第二面：
1. leetcode – tree level order traversal 原题

2. Design 一个 data structure
要求：add(int val), remove(int val) and int removeRandomElement() all in O(1) time



今天面了LinkedIn一面（ML track)。碰到一个中国小哥，人非常nice非常赞。小哥应该之前是做distributed system，现在过来做optimization。一上来小哥简单自我介绍，然后告诉我两个part，一个是聊ML，另一个是做题，让我自己选择顺序。我选择先ML
开始ML之后，我有一个项目大概是LDA+NN。也是醉了，小哥两个都不太懂的样子，然后就开始狂问（或者装作不懂？）。然后让我先解释LDA，然后让我解释我的model比LDA哪里好。并且过程中不断challenge我对两个模型的理解。然后又让我简单介绍一个Classifier。我就说Logistic Regression，刚说了一句，然后小哥说你不妨来说Neural Networks吧。然后我就开始说neural networks..期间聊了一下overfitting…后来somehow我mention了一些MapReduce。显然小哥对这个很感兴趣，然后就开始问我对MapReduce的理解。然后我就开始大概说了一下streaming data, sort, reduce之类的。
说道MapReduce之后，小哥就很自然的开始的开始做题了。然后做的题就是跟Streaming有关。大概就是design一个class，去处理stream data。basic idea是stream流过data，存储N个数据，实现两个函数求求mean和variance。我设计的就是用一个queue，每次pop出第一个，把新流入的数据加入到队尾，然后求均值就直接求存下来的N个数好了。然后就是分析一下complexity，问我求均值能不能O(1)。我靠这么问了肯定可以啊，然后我就想了一下，大概就是每次流入数据的时候顺便update一下mean。方差的思路是差不多的, E(x^2) – E(x)^2就可以了。小哥很开心，说对的。

整个过程小哥都很好，所以觉得或许有机会能够过第一轮（迷之自信啊。。），要是挂了也是惨啊。。。攒人品啊，发一下面经。之前看到地里很多小伙伴中了面经。。虽然我没有中，攒人品啊。。

前几天的实习电话面试 System infra
recruiter都很好，很有耐心也很愿意帮助我，只不过我不太熟悉考的parallel programs 让implement一个multiple-thread producer-consumer. 第二题还有，serialize and deserialize binary tree.
总之面试经历很愉快！结果什么的不重要了！！ 重在参与！


给你一个java interface, 实现两个method，一个是void add interval(int from,
int to), 另一个是int getTotalLength()返回已有interval的总时间，当然，要考虑
overlapping。比如(1,5), (2, 6)的total length 是5.

不知道用什么样的data structure 去解决。


上周四的技术电面LZ被分到data infrastructure组。
首先是面试官和我的自我介绍
然后问C++问题： thread和process， 我答的比较细，然后追问了下thread和process分别怎么通信。 然后是a==b，什么时候++a != ++b
然后coding问题： valid number不考虑e 和 shortest word distance， 并进行优化
然后问问题。
好像没问我project的东西，不记得了。。。



Reschedule 了一次，现在来发面经。
1. Implement Hash Table 我记得有 实现Put, Get Method。要求避免Collision。
2. Hop Iterator, 类似于这个/**
* Implement an iterator that hops specified number of times and then returns the next
* element after the hop. Note: the iterator always returns the first element as
* it is, and starts hopping only after the first element.
*
* Examples:
*
* If the original iterator returns: [1, 2, 3, 4, 5] in order, then the hopping
* iterator will return [1, 3, 5] in order when the hop value is 1.
*
* If the original iterator returns: [1, 2, 3, 4, 5] in order, then the hopping
* iterator will return [1, 4] in order when the hop value is 2.
*
* If the original iterator returns: [1, 2, 3, 4, 5] in order, then the hopping
* iterator will return [1, 5] in order when the hop value is 3.
*
* Methods expected to be implemented:
*
* public class HoppingIterator implements Iterator {
* public HoppingIterator(Iterator iterator, int numHops) {…}
* public boolean hasNext() {…}
* public T next() {…}
* }
*/复制代码已挂， 供大家参考。




我的情况是已经工作了一年,h1b也到手了,于是准备跳槽, 题还没怎么刷突然Linkedin他们自己的Recruiter在Linkedin里面联系我和我们公司好几个engineer(我们都是好基友所以大家互相知道都无所谓), 我们就集体面试啰, 每天下班刷两小时题准备了三周, 今天的电面, 好久没面试了有点紧张.

面试官是一个Hawaiian, 十几年工作经验但是在Linkedin就一年多. 今天在Remote上班, 家里还有狗叫(我也是醉了).

一开始互相讲了下各自的role和working experience, 然后叫我讲了一个在公司最challenging的project, 就blabla…感觉工作一年多口语锻炼得还可以就没什么大碍.
然后剩45分钟开始做题.

第一题:
public interface TwoSum {
/**
* Stores @param input in an internal data structure.
*/
void store(int input);

/**
* Returns true if there is any pair of numbers in the internal data structure which
* have sum @param val, and false otherwise.
* For example, if the numbers 1, -2, 3, and 6 had been stored,
* the method should return true for 4, -1, and 9, but false for 10, 5, and 0
*/
boolean test(int val);
}

我的回答: (因为是interface, 所以要implements所有的virtual function).
public class TwoSumTest implements TwoSum{
private HashMap map;
private ArrayList list;

public TwoSumTest(){
map = new HashMap();
list = new ArrayList();
}

public void store(int input){
map.put(input,1);
list.add(input);
}

public boolean test(int val){
for (int i=0; i< list.size(); i++){ int key = list.get(i); if (map.containsKey(val-key)) return true; } return false; } } /////用了HashMap没用HashSet是怕要follow up说有duplicates, 结果没有, 也算了不影响逻辑. 第二题: follow up, 如果我要实现O(1)的test怎么办? 回答: 那store就不能保证O(1)了,每次存一个新数的时候,map要存前面所有数与这个数的和. 就是把可能的2 sum结果都枚举出来丢到map里 public class TwoSumTest2 implements TwoSum{ private HashMap map;
private ArrayList list;
int lastIndex;

public TwoSumTest2(){
map = new HashMap();
list = new ArrayList();
lastIndex = 0;
}

public void store(int input){
list.add(input);
for(int i =1; i<= lastIndex;i++){ map.put(list.get(i)+input,1); } lastIndex++; } public boolean test(int val){ if (map.containsKey(val)){ return true; } return false; } } //再次声明用的HashMap没用HashSet是因为怕follow up.不过也没问,面试官说也不用改了没关系. 第三题: 老生常谈WordDistance, 我问了, assume WordOne != WordTwo, 那就再简单不过了 /* This class will be given a list of words (such as might be tokenized * from a paragraph of text), and will provide a method that takes two * words and returns the shortest distance (in words) between those two * words in the provided text. * Example: * WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList("the", "quick", "brown", "fox", "quick")); * assert(finder.distance("fox","the") == 3); * assert(finder.distance("quick", "fox") == 1); * * "quick" appears twice in the input. There are two possible distance values for "quick" and "fox": * (3 - 1) = 2 and (4 - 3) = 1. * Since we have to return the shortest distance between the two words we return 1. */ public class WordDistanceFinder { public WordDistanceFinder (List words) {
// implementation here
}
public int distance (String wordOne, String wordTwo) {
// implementation here
}
}

我的回答:
public class WordDistanceFinder {
private String[] words2;

public WordDistanceFinder (List words) {
// implementation here
words2 = new String[words.size()];
for(int i = 0; i< words.size()-1; i++){ words2[i] = words.get(i); } } public int distance (String wordOne, String wordTwo) { // implementation here int p =-1, q =-1, min = Integer.MAX_VALUE; for (int i =0 ;i< words2.size()-1; i++){ if (words2[i].equals(wordOne)) p=i; if (words2[i].equals(wordsTwo)) q=i; if (p >0 q>0 ){
min = Math.min(Math.abs(p-q), min);
}
}
return min;
}
}

//感觉第一个constructor可以直接就private List然后把words pass 过去就行..当时就走直觉了..

之后时间差不多了就没继续出题了,问我有没有什么问题要问就blabla…

总体感觉和听几个同事说的, 感觉在职的题目简单一些似乎…完全没有超纲, 全在leetcode上和地里.

不过他们的题的特色就是总是会写一个完整的class, input总是一个个数而不是一整个数组给你, 所以用java的同学们就好好准备下面向对象啰.



只想起有一题挺难的是（10, (15, 20)), 考了这个数据结构，就是（10, (15, 20))
是一个bigNum, 10也是一个bigNum， (15, 20) 也是一个bigNum，先让你算多少层，
比如这个就是2层。然后再算有权值得时候得乘积，第一层算2， 第二层算1 （逆序）
，然后算 层数＊权值 的值。这里，10 ＊ 2 ＋ （15 ＋20）＊1 ＝ 55



10/20 LinkedIn 前一周的周五跟Google的HR通过电话，所以心里有了底，来这里面试的时候就没有那么紧张了，但是由于楼主感冒发烧了好几天，去LinkedIN的时候还在咳嗽，所以发挥的并不是很好。
周日晚上从LA飞到SJC，下飞机有公司的林肯车接送，十分洋气，到了Moorpark Hotel之后住下，条件感觉比之前的westin还要好。
checkin的时候发了linkedin的矿泉水和小饼干，十分贴心~第二天早上shuttle接着一群面试的人去campus，紧挨着google，虽然只有七栋楼，但是感觉环境非常的好，楼里的装修十分符合我的口味~九点半checkin，
十一点才开始第一轮面试，之间都是听recruiter介绍演讲以及跟同桌的小伙伴聊天，公司会发给你lego积木作为icebreaker。 
11:00-12：00，第一轮面试，直接是设计题，考察的点很多，包括web前端后端，数据存储，数据结构，通信，加密等等问题。但是问题都是一点一点加难度，所以不会有什么也说不出来的情况，大家千万不要被网上onsite的设计题吓到，面试官都是循循善诱的，总是会让你有思路的。
12:00-13:00，算法面，两道题，非常简单。 
午饭，campus tour等。个人感觉这里的饭比Google的食堂更符合中国人的口味，linkedin对于员工其他方面的重视真的是非常多，包括健身计划等等，还有及其酷炫的music room！ 
15:00-16:00，算法面，问了两个题，非常简单，第三个题直接告诉面试官做过，这时候主面试官没辙了。。说没题了，然后接受培训的那个小哥坐不住了，说我这有个题，费半天劲描述清楚之后，楼主想了一阵说了思路就到时间了，感觉这一轮应该还算不错的。 
16:00-17:00，manager面。linkedin一定会有这样一轮面试，只问你的project，然后会给你一些情景，比如叫你负责一些项目，你会注意哪些问题等等。 晚饭，被拉到一个日本料理吃寿司，然后送回宾馆~ 




电面： 
第一次：印男，implement string matching and replacing 
第二次：国男，producer consumer,谢谢中国小弟弟出了这个我非常熟悉的题 

onsite: 

第一轮：hiring manager，主要就是谈project，我讲了我最近在做的一个OO design的 
东西，因为和面的组没啥关系，看得出来hiring manager是耐着性子听我说完的 :-P 

第二轮：印男加国男，given a stream of data and a sliding window, implement 
put(), getAverage(),和另外一个function（忘了是啥了）。考虑multithreading的情况 

第三轮: 吃饭 

第四轮：最坑爹的一轮，recruiter告诉我也是跪在了这一轮，所以多说两句。来的是 
个中年老印加一个中年国男，国男shadow。老印一出现就是一幅超鄙夷超不屑的臭脸。 
出了一个inverted index的题，就是有一大堆doc，对doc里出现的word建inverted 
index，doc很多所以是distribute在很多machine上的，问怎么实现这个inverted 
index。我听了题目暗爽，这种题我准备的很充分啊！因为这题有很多解法，我就从差 
到好一一说来，每个都说了为啥不好，然后引出我认为最好的那一个。可是我每说一个 
老印就急吼吼的跳起来反驳我。搞了两回，我意识到可能老印就是想听最佳答案，我就 
解释说我只是想list一下所有的option，我也问他你是不是prefer直接告诉你最佳答案 
？他说是。我就直接给了我认为的最佳答案。 

接下来还有几个相关的小问题我都忘了，有一个是关于map reduce的。最后一个，是找 
出前K个最常用的word。我说用min heap找出每个machine的K个最常见word，再用一个 
min heap merge这些list。奇葩的事情就出现了，老印跳出来说，不对，你用min heap 
是不对的，应该用max heap！这时国男也一脸诚恳的“提醒”我说：是的，你用min 
heap找出来的是最不常用的K个word哦！我我我，我当场就愣了！不会吧，俩linkedin 
的老员工了，好歹是个面试官啊，居然连min heap和max heap是啥都不知道？愣了两秒 
，我就给他们讲了一遍啥是min heap啥是max heap，和为啥找K个最常用的word要用min 
heap而不是max heap。一遍讲我一边想：我这是来面试的还是来给linkedin的员工培 
训基本data structure的？最后俩人还是将信将疑，又问了一个有关于thread的小问题 
就结束了。 

第五轮：小印女加小印男，也是问了一个类似在stream里找k个最大数的题，我还是用 
了min heap，还好俩人都知道啥是min heap，也比较认同我的做法。然后大部分的时间 
都在讨论multi threading的实现，我提到了read write lock，和三种fairness 
policy，不过他俩都是一脸茫然，好像他们只知道read write lock，但不知道 
fairness这回事，挺奇怪的。（另：刚又想起，这一轮还问了max point on a line一 
题，leetcode上有，只要求pseudo code，我做了个square的，问小印男还有没有更快 
的，他说就他所知没有了）。 

第六轮：亚裔男（不是国男）加印男，问了romanToInt和intToRoman的题，intToRoman 
和leetcode一样，但romanToInt要考虑很多corner case。这些corner case在leetcode 
和EPI上都没有提到过。另外，好像EPI上的解法很多错误，我没看几道题就已经找出很 
多错了，有的错的很离谱，大家得注意一下。 

第七轮：白男加国女，问了一个design的题，design monitoring system，自我感觉是 
发挥的最好的一轮。 

面完以后我就觉得，成败就在第四轮，最后果然就跪在了这一轮。不过我是一点遗憾都 
没有，要是给了我offer，让我去和对我天生有敌意的老印，还有分不清min heap和max 
heap的人一起共事，其实也不是什么好事。还有我觉得好几个问道我multithreading 
问题的人，本身对multithreading也不是很熟，像那个read write lock fairness 
policy的问题，还有lock free algo的ABA问题，他们好像都不知道，那他们平时是咋 
把multithreading的程序写对的啊？ 

所以我现在挺疑惑的：是不是我特别倒霉，碰上的都是linkedin里水平比较低的一些人 
，还是linkedin的员工水平并不像原本我想的那么高？ 



Linkedin官网投的简历，两个月了才被鸟。
Phone interview：电面前recruiter会打电话来做最基本的phone screen，然后会发给你面试官的linkedin链接，让你做好迎接老印的准备。. from: 1point3acres.com/bbs 
1. 电话对面两个面试官，老中+毛子，collabedit上写题。第一题，验证一个string是不是valid number，需要考虑正负和小数，不用考虑指数。第二题也是被问烂的，print a binary tree in level order。感觉发挥得不好，虽然写出来了但是被指出了几个bug。当时脑袋犯糊涂了做过的题竟然都写得不顺。
2. 本来以为上一面跪了，结果一天之后HR又约了第二个电面。老印+毛子。第一题，求pow(n, x)，要求O(logn)解法。第二题，maximum subarray。第三题，实现singleton并让其thread-safe，还问到了lazy initialiation的和volatile关键字的意义。这一面相当顺畅，没有任何差错。
Onsite：Mountain view总部，一共五轮，除了第一轮，每轮两位面试官，时长一小时,看来2v1是他们的特色。虽然每轮有两位面试官，但是其中一个是shadow，全程基本不发言，也就是来学习面试流程的，所以不用慌张。从这些shadow的脸色来看，他们其实比你更紧张。当我问他们问题的时候，他们的回答都是都结结巴巴的。当然主面试官还是相当老练的。因为签了NDA，而且拿到offer了，为了以防万一，下面的题目故意写得模糊些。

老印，主要问简历，每一项都被问到，而且非常细节。要求画出实习project的架构图。

老印+老印，依然是问简历，基本同上，并且要求你从algorithm和design的角度说出怎么improve你的project。面完以后被其中一个老印带去lunch interview

老美+老中，两个coding题，一题简单10分钟，一题复杂30-35分钟，题目就不说了，leetcode上有类似的。

老美+老中，也是两个coding题，难度基本同上。
老美+老印，design题，如何设计一个web的多人在线游戏。写出所需的类和data member，还要画出系统架构图。

从电面到onsite，见过的coding题都是leetcode上的类似题，所以各位应该知道我的意思。我比较惊讶的是linkedin竟然这么重视design，甚至重于coding。虽然前两轮都是问简历，但是都讨论到了很多design方面的问题。所以整个面试应该是三轮design和两轮coding。Onsite结束后一星期，recruiter打电话来follow-up，说feedback没齐。第二个星期来了口头offer，说是还要跟hiring manager电话聊一聊。聊完之后给了正式offer。我被分到的组是Core team里面的presentation team，做profile page的，也就是个人主页。感觉这个team相当不错，离用户最近，impact大，也符合我的兴趣。版上好像有个帖求证Linkedin的package，这里报一下fresh master的，以作参考：105k base + 1500RSU/4yr (worth 170k) + 10% target bonus + 10k relocation。除此之外，公司三餐免费(不过很难吃)，还有免费饮料和零食，报销公共交通，入职发macbook，假期很多。公司里面的文化相对于大多数tech公司比较formal，办公室非常整洁，没有那么多geek元素。老印很多，但是我遇到的都很好。




电面：
1.  给一个二叉树，返回它的镜像
    实现一个 thread-safe blocking queue

2. 一个嵌套Map， 就是一个HashMap, 它的value可以是一个element也可以是另外一个
嵌套map或是空的map. 实现一个iterator来遍历这个map里面的所有element。 就是类
似树遍历一样的方法

Onsite:

第一个:  给两个单词， 比如head,  tail: 找到一个最短的转换，从head到tail，每
次只能变一个字母，path上的word都必须是有效的英文单词，我用的Graph shortest 
path

第二个: memcpy:  源区域和目标区域可能有重叠
   BST 插入和删除操作实现
   BST iterator 实现

3: 实现两个函数: H() and O(), 这两个函数会被多线程调用。当一个线程调用H或O时
，如果当前已经有至少两个线程call H和一个线程call O。那么让两个call H和一个
call O的线程返回（产生一个水分子），其他的都block。

4: Given a social graph, find if there is a path between two persons with at
most 2 steps (3rd level connection), how to handle it in distributed way (
large graph stored at a large number of nodes, minimize cross-communication)
  
5: 设计题:  a restful server with 4GB,  
given a request such as: http://seq=4?len=60?xxxxdata
the system will store the binary data with that sequence number.
given a request: http://startseq=3?maxLen=100, the system returns all data objects with sequence >= 3 with total data length less equal than 100.

multiple clients calling simutaneous
what data structure, concurrency, locking, etc..



String Rotation. Given two string check if String1 is rotating match for String2
# Given two strings. Write a function that will return true if one string is a rotation of the other string.
# e.g. 'bca' and 'cab' are rotations of 'abc' and the function should return true
# 'barbazfoo', 'oobarbazf' and 'rbazfooba' are rotations of 'foobarbaz'
def is_rotation(string1, string2):


Find unique integers from list of integers
# Question
# Write a function that will return an array of integers that occur exactly once in a given array of integers.
# e.g. For a list [1,2,3,5,2,2,3,4], return [1,5,4] since they appear once (order does not matter).

def once_integers(integers):
Follow up: 
Optimize the code if input is sorted.

# What if the input is sorted, such as [1,2,2,2,3,3,4,5], could the algorithm be further optimized
# (e.g. space complexity)?

def once_integers_sorted(integers):



You are designing the client side of a Survey website. Provide the list of classes and methods you will use to break the problem down. Also, provide the API interaction with server.



Given an array of numbers find the duplicates



Suppose you have a list of Dishes, where each dish is associated with a list of ingredients. Group together dishes with common ingredients. 

E.g: 
Input: 
"Pasta" -> ["Tomato Sauce", "Onions", "Garlic"] 
"Chicken Curry" --> ["Chicken", "Curry Sauce"] 
"Fried Rice" --> ["Rice", "Onions", "Nuts"] 
"Salad" --> ["Spinach", "Nuts"] 
"Sandwich" --> ["Cheese", "Bread"] 
"Quesadilla" --> ["Chicken", "Cheese"] 

Output: ("Pasta", "Fried Rice") ("Fried Rice, "Salad") , ("Chicken Curry", "Quesadilla") ("Sandwich", "Quesadilla") 

Follow up: What is the time and space complexity?




Basic background questions, describe a situation where you proposed a design and it was opposed. What did you do to convince people that your design was sound. Describe a situation where something you suggested resulted in improved process or caused a big positive impact on the company, etc.



Write a program that takes an integer and prints out all ways to multiply smaller integers that equal the original number, without repeating sets of factors. In other words, if your output contains 4 * 3, you should not print out 3 * 4 again as that would be a repeating set. Note that this is not asking for prime factorization only. Also, you can assume that the input integers are reasonable in size; correctness is more important than efficiency. 

Eg: PrintFactors(12) 12 * 1 6 * 2 4 * 3 3 * 2 * 2


