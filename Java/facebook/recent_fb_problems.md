其他家面试的总结在另外一贴。 这里专门开一贴讲讲fb家的面试。
http://www.1point3acres.com/bbs/ ... D311%26sortid%3D311
. 1point3acres.com/bbs
lz对fb的面试研究的最多，分享下经验。
. visit 1point3acres.com for more.
FB家对new grad 或者毕业后工作短于一年的同学是可以不考design的。

对phd 毕业或者毕业超过一年的童鞋是要考desig
phone interview 只考coding。
onsite 经典4轮 Coding/"Ninja" (2)  Design/"Pirate" (1)  Conversation/Career Background & Trajectory/"Jedi" (1)
根据面试情况可能会加试一轮。

算法 & coding ： 个人感觉 leetcode 刷透做熟悉就够了。 fb 家不是以难度取胜。他家一般都是leetcode medium level的题目，一般是原题或者小变种。
他家coding的难点是bug free， 细节和追问。
比如说给你一个 binary tree， 每个节点存一个整数值，让你求每个layer的平均数。
这个题目看上去很简单， 但是要注意输出， 3和4 平均是3.5， 如何你用java 解，输出是整数，那么你的结果就不准确。
这些细节点一点要问清楚，如果考官让你自己定，那就选保险一些的。

另外就是bug free， 这里bug free指的是没有逻辑和算法错误，变量名啥的写错了也没啥。

另外coding 轮最重要的一点还是communication， 考官问完问题以后，一定要clearfy 一下题目的意思和输入输出。
然后把你的思路和考官说一下，之后考官同意，再写code。 他家很注重交流，如何你听完题目，就直接写code。
就算是最优解，你也会fail，因为没有交流的过程。 coding 轮不光考算法，也会看你的交流能力如何。
. 涓€浜�-涓夊垎-鍦帮紝鐙鍙戝竷
design： 他家的design 有难有易。  基本部分另外一帖子说过了直接贴过来。
能准备的准备好了，剩下的就是放宽心态，好好发挥了。实力到了，那么胜率自然高。
fb家大牛很多，design比较看运气。

design 轮是有技巧性的。
一般过程是 
１ 问清 requirement ５～１０ 分钟. 1point 3acres 璁哄潧
２ high level design（设计flow 相关api 和数据存储）
３ 细节设计，详谈flow， api

一定要按顺序来。不要直接跳到第三步。
下面几段话感觉很有用。lz是实战后得出的这些总结。. 1point3acres.com/bbs
ab和fb都跪在design，之后调整策略，胜率就上升了。. 1point 3acres 璁哄潧

准备design主要是参考了这个网站：
http://www.hiredintech.com/system-design/
感觉还是挺有用的。其他就是mitbbs上那位大牛给的一些资源
http://www.mitbbs.com/article_t/JobHunting/32777529.html

. visit 1point3acres.com for more.
Conversation/Career Background :
自己的工作经验和project要准备好，这个没啥好说的。
下面几个是常见的 behavious question：

1 First, ask some questions about Facebook, do you use Facebook?. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴
2 Why you like it? 
3 Which part of it should be improved? . Waral 鍗氬鏈夋洿澶氭枃绔�,
4 What challenge you face in your pre project and how you result it?
5 Why facebook 
6 My current project and how I scale our applications.
7 包括以前的成就，怎么说服别人做design的修改，说服不通怎么办。
8 FB specifically (vs. other companies)



附录FB 常见design 问题=============================
1 Design a web crawler with fixed set of resources.

2 Design a real-time type-ahead search-phrase predictor which presents the top-10 ranked search strings that begin with a given prefix. 
3 Design timeline的group权限，比如说user发一条status可以选择对某个group的好
友可见。题目很简单，但是会讨论到facebook用户规模的估算，服务器估算，social  graph的存储。感觉system design只要讲个大概思路就行，面试官不会去纠结太细节的东西。
4 design偏向设计存储结构
5 system design: 设计key-value store，直接列了一大堆从client到server的要求，基本处处陷阱，经验这里比较重要，光按面试准备
基本没效果。
6 搜索栏的自动完成功能
7 那个给你一个点， 然后有几个million的POI， 找出最近的20个。。。我说那个Z distance。。 two dimension变成一个dimension， 那个面试官说， 没听说过Zdistance， 不行。。。. 1point3acres.com/bbs
8 find close coordinates
9 上来讨论了20分钟的如何设计data structure表示fb的friend和follower两种关系.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
，各种结构的tradeoff。我边讨论边猜是不是要我clone graph，然后默念怎么还不让
我写code。果然，deep copy。不过最后讨论的data structure 和lc上有点不同，dfs
思路是一样的。整个过程很愉快，abc男也是好多positive feedback。面试结束了还和. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴
我激动的说了半天来fb的种种好处（工资，休假之类的）
10 deadlock设计. From 1point 3acres bbs
11 问为什么Facebook，对Facebook的哪个feature最喜欢，为什么喜欢，然后这个feature还有什么不足。
12 之后让给他一个非常specific的例子说当你和同事出现技术上的冲突的时候，应该怎么解决，问的特别细，
特别深入。
13 从头到尾面无表情，口音也很难懂，我当时就觉得不妙，
果真就跪在这轮。design news feed API, 这题我准备过，但是按pull/push model准.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
备的，还准备了pub/sub model，就是给每一个friend都建一个queue,推送一份news，
算准备过的题。但他不考这些，根本不让我说关于aggregator tier或者database tier. From 1point 3acres bbs
的东西，主要focus API怎么写，input/output, feed里图片怎么存，想mention -google 1point3acres
friends怎么存，怎么做multi device sync。我觉得他的考点似乎在data . 鐗涗汉浜戦泦,涓€浜╀笁鍒嗗湴
serialization/deserialization这边？感觉和他交流就是隔着窗户喊话,一直在猜，所
以差评也是必然的。。。

14 设计题，传输10G的data到5个data center，每个data center 有1000的.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
节点。三哥从问背景就开始找茬，面试过程中要求解gossip protocol的微分方程， 被
黑。
15 设计iPhone Find Friends 的后端。Geohashing + DHT解之
16 设计题问得很细，比如DHT如何实现，单机的Hash table如何实现能节省内存， 如何做
concurrency control，如何实现mutex之类的。
17 system design: 每个record有个很大field，比如年龄，性别，爱好等。给一个field的组合，比如小于25岁，爱好体育，query满足这些组合条件的用户个数
18 设计一个facebook的搜索引擎，这个引擎能搜索出包含关键字的facebook动态。没有讨
论太多前端的，主要在讨论架构和存储。
给出了倒排索引来存储index，以及讨论了下如何存储facebook的动态(key-value 存储.1point3acres缃�
）如何handle hot keyword。面试官人很好，引导我的思路。
19 system design白人大叔， 有个function是List<id> getNearest(int x, int y
){}, 假设从mobile上在地图上点一下，然后返回改点附近的所有建筑location。怎么. 鍥磋鎴戜滑@1point 3 acres
设计data structure以及data scheme
20 System design设计手机上读取photo feeds的app。
    功能： 读取好友的最近图片
               阅览好友的相册
    要求： 满足功能的同时减少对手机的能耗。
21 design：tiny url。
22 System design： instgram
23 Culture fit： 有200M个用户，现在让你进行分组，将他们分成大概20个组，每个
组里大概有10M的用户，尽量让用户interaction多的在一起
24 design看了下几篇文章，知道个大意，google的mapreduce, file system, big table,
fb的memcache, unicorn。其他看到过的觉得还不错的design资料，最后一个常见题目
汇总可以过过看，很有帮助:
http://blog.csdn.net/v_july_v/article/details/7382693. from: 1point3acres.com/bbs 
https://www.youtube.com/watch?v=-W9F__D3oY4 
http://www.mitbbs.com/article_t/JobHunting/32741713.html
另外建议稍微准备下常见数据类的写法(包括generic programming), 我倒是没碰到其
他一些concurrency, database, NP-hard之类的题目.
25 设计一个facebook功能：在一个post下面，如果有了新的comment，可以自动显示，
不需要刷新后再显示。
26 design facebook chat
27 design facebook chat
28 写一个sequential 多线程pool。实现f（Runable r）要求caller不可以block，但是. 涓€浜�-涓夊垎-鍦帮紝鐙鍙戝竷
在pool里面要一个跟这一个的运行。
29 设计类似gogle地图系统，从A点到B点的算法已经有了。整个地图大概有好几亿条线
段组成，这个系统的市场占有大概30%。要求在小于1妙的时间里算出结果。估算需要多
少台机？要怎么样保存地图，怎么cache？
30 然后面试中有个印度人问了个问题，就是如果系统出问题了，有个size很大的log如何
从里面找出相关的信息，同学说直接search关键字，但是面试官不满意也没给提示，所
以不知道怎么回答。
31 国人面试官面出的 design：Shorten Url。面试官人非常nice，可是自己答的一般
，在此谢谢他。

32 google的mapreduce, file system, big table,
fb的memcache, unicorn。其他看到过的觉得还不错的design资料，最后一个常见题目
汇总可以过过看，很有帮助:
http://blog.csdn.net/v_july_v/article/details/7382693
https://www.youtube.com/watch?v=-W9F__D3oY4 
http://www.mitbbs.com/article_t/JobHunting/32741713.html
另外建议稍微准备下常见数据类的写法(包括generic programming), 我倒是没碰到其
他一些concurrency, database, NP-hard之类的题目.
33 设计一个SparseVector （就是一个超长的vector，大部分elements都是0）的
class，实现dot product的操作。follow-up1:如果一个vector很长（millionsof non-. 1point3acres.com/bbs
zeros）， 另一个vector很短（hundredsof  non-zeros），如何优化。follow-up2:如
何利用index之间的关系（比如设计class的时候规定按照递增的原则存non-
zeroelements的index）进一步优化。
34 ystem Design：设计一个K recent contact 的service，就是当用户把鼠标点到
chat对话框的时候，自动弹出K个最近的联系人。follow-up是如果要弹出K个最熟悉的
人怎么设计，以及资源估计（需要多少台机器来做数据存储，多少个处理request等等
）。
35 design准备：板上有几个design总结贴，非常管用。我就是照着 flamingos和beidapig
的两个总结贴，大概看了看，学习了不少知识。
http://www.mitbbs.com/article_t/JobHunting/32777529.html
http://www.mitbbs.com/article_t/JobHunting/32984309.html





补充内容 (2016-5-20 02:51):
面试经验谈（facebook，airbnb，google，linkedin，amazon
http://www.1point3acres.com/bbs/ ... D311%26sortid%3D311

FB 面经 phone & onsite  攻略 附录题库呦 
http://www.1point3acres.com/bbs/thread-1910...

补充内容 (2016-5-20 02:52):
airbnb 面经 phone interview & onsite 附录题库呦  http://www.1point3acres.com/bbs/ ... D311%26sortid%3D311

补充内容 (2016-5-20 02:52):
lz的刷题攻略。。 http://www.1point3acres.com/bbs/ ... D311%26sortid%3D311.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
. Waral 鍗氬鏈夋洿澶氭枃绔�,
补充内容 (2016-5-20 02:53):
补充的几个帖子里 有高频的机经（design & 算法）



fb这次面试总共3轮，第一次去menlo park，公司的楼很低调，像一个campus，里面什么都有。

第一轮是behavior，是做infrastructure的，一上来相互介绍完后先问了我觉得自己最骄傲的项目，我说了我实习的项目。小哥好像很感兴趣，问得非常细非常细，连架构，调度流程都问了，还画了各种flowchart给他解释。期间穿插着一些你如何处理跟mentor以及跟manager之间的关系，如果manager分给你不喜欢的项目你怎么办，你做的项目impact在哪里，代码量有多大之类的问题。基本花了30min都在讲这个项目，小哥很高兴的样子。然后问了一道sparse dot product的coding题，以前面经里有，我装着思考跟他讨论什么算法好，然后直接挑了O（M+N）的算法实现。小哥连连cool cool，结束。

第二轮是个三哥，做广告的，我也只能呵呵呵。。。都说三哥喜欢黑中国人，我看是这样的。相互介绍的时候特别开心，然后一到做题就不愿意交流，一直看手机。第一题是lc原题，valid BST， inorder tranverse秒了。第二问是remove invallid parenthesis，只要求输出一种结果就行，O（n）实现，所以这里就不能用deleteCharAt（）之类的方法。我说用一个counter，然后左到右遍历一遍，再从右到左遍历一遍就行。三哥让我跑了好多test case，说不用implement。不知道这里是不是想黑我，感觉一直在拖时间。最后问他问题的环节，他却回答得特别开心。。。

第三轮是个国人小哥，感觉这轮没咋面好，也确实最后有点累了。第一题是merge interval说这些interval表示整数集合。我说了一下思路很快写完了，小哥一直让我想corner case，我绞尽脑汁想了很久，但好像都不是他想要的。。然后他说no worry就下一题了。下一题是有一片森林，森林中的树节点只有指向parent的指针，然后给出其中的两个节点，求它们的lca。回来想想其实挺简单的，但当时只剩下10min了，就简单说了一下思路，说每个节点建个class，里面有一个field记录是否有孩子是被指定的节点。一直到某个节点左右两个孩子都有被指定的节点就是lca。但是这个思路好像跟小哥想的不一样，他一开始还没听懂，后来算是懂了。怎么办，感觉跟国人小哥用英语交流不是很顺畅233333。。。
-google 1point3acres
自我感觉第一轮面的最好，交流起来也很有激情~后面两轮感觉实在一般。不知道结果会怎么样，只能慢慢等了。我在onsite之前就被要了reference。所以个人感觉要不要reference并不代表什么，大家不要担心。
-google 1point3acres
然后的话就是给大家一些旅行小tips吧，毕竟露珠是第一次onsite，也第一次住米国的宾馆，简直诸多不如意啊！已经有过onsite经验的小伙伴可以忽略~宾馆里没有牙具，没有拖鞋，没有免费WiFi。所以这些可以在出发之前在google上查好，该带的需要准备一下。然后就是一定要睡好，吃好！楼主第一晚挺紧张，没咋睡好，面完第二天早上7：10的回程飞机，感觉是一次下乡求虐的经历，不忍直视。. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴


面经是  
1. behavior + convert string to double   -12.35e2 -> double。。这题可以assume给的string都是valid的
2. design http get/post
3.1 subset product, follow up if duplicate exists
3.2 find root to leaf path sum to target, follow up, what if all node's value are positive
4.1 divide two Integers
4.2 merge K arrays.
