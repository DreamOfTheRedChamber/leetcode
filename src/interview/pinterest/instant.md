版上P家面经比较少， 我就写一个吧 

店面1： given a list of lists of file names such as [ ] Filecontents in each sub-list are unique. Find duplicate files across lists. 我是用hash做的。 然后再问了一些测试的问题， 包括对于video 文件体积太大改如何处理的followup 

店面2： 简化版的alien dictionary。 直接把graph给你让重建顺序。 

上门： 1.1 CanWin. 给一个数组比如 和一个index比如4，从这个index每次可以向左或者向右跳ary的距离， 如果能跳到值为0的index则返回true。 1.2 Merge k sorted list. 比较麻烦的是要我自己实现一个heap， 写出push（）和pop（）两个方法。 1.3 设计一个ACL serevice。 这题没有几分钟了， 就大概巴拉了几句。 

2 系统设计。 设计个dashboard可以显示成千上万台机器的qps， 90%latency 和 request success rate in nearly real-time. 如果要追求精确度怎么办？ 答案是牺牲real time这个要求。。。 

3 系统设计。 和2有点类似的题目， 在计算percentile的时候， 需要把每个数据都发送到aggregator， 如果单机数据量太大没法发送怎么办？ 答案是牺牲精确度使用histogram。 然后一堆followup。 — 所有的设计其实都是tradeoff， 一切都是算计。。。 

4. 把以前做的某个项目详细过一遍。 

5. Culture fit。 有没有项目失败的时候， 和老板/同事合不来怎么办, etc. 推荐的人是mit上面的某著名大神。 P家的建筑外面看着不起眼， 如果不是那个图钉招牌， 几乎认不出来。 进去之后布置的还不错， 浓浓的怀旧风格。

链接: https://instant.1point3acres.com/thread/179391
来源: 一亩三分地



这家老实说是我面试经历最不愉快，但也是题答得最好的一次。但是还是莫名其妙的跪了。问了recruiter有什么feedback么，杳无音信。 面的职位是data engineer。当初投也是看中p家的engineer实力挺强的。 
一轮电话面试，中国小哥，leetcode原题 binary tree max path sum。 聊了聊project， 我面的这个职位是data infrastructure team， 主要做一些data integration， etl pipeline etc。小哥说和我的经历挺匹配的。 两天后接到recruiter onsite 通知，结果发了邮件定了onsite时间。过了一周都没有confirmation letter，发邮件催了recruiter好几次，好不容易来了个onsite confirmation letter，也是临近onsite几天。 

onsite总共3轮coding， 一轮system design，一轮culture fit。五个面试官里，三个是国人。 
第一轮， 国人小哥上来问我map reduce的东西（我简历里就没有map reduce相关的经验）。答说不是很熟map reduce，只是略知皮毛。小哥趾高气昂的说：那今天我们就来学学map reduce（心中一万匹草泥马蹦腾而过），说有一本巨大的书，怎么用map reduce 做word count。大致说了下思路，小哥说那我们来coding吧。 
有一列task， tasks 可能depend on other task。 topological sort， 用了dfs和adjacency list做法， 小哥翻了翻白眼，说adjacency list是什么？（这时心中的草泥马都已经跑不动了），稍微解释了一下，小哥说adj list不够直观，graph多直观阿。。。。（心想pinterest就这水平？） 很快写完了，简单跑了一下test case。 小哥没有评价，来了个followup， 说这只是topo order的一种，怎么找出所有的可能的order，答用bfs从每个vertex without incoming edges出发做topo sort，小哥又面无表情直接把我带到了QA环节，聊到了我关注pinterest的engineering blog，觉得pinball和skyline etl 开源的项目非常感兴趣，小哥得意的露出微笑：o, youknow pinball, that's good. oh, you know skyline, I wrote the blog. 把小哥哄开心了，迎来了第二轮面试。 

第二轮，东欧的一大叔，也是从头到尾，面无表情，就像是打了太多肉毒杆菌一样，上来直接coding，说有一个list of task， task纪录了开始时间，结束时间，需要的cpu 数量。 求最小的cpu数量可以满足complete all task without cpu deficit。 其实就是meeting rooms 2的变种，多了个cpu number而已。用meeting room的解法和priority queue，先sort list based on start time，如果当前小于这个最小end time，就push，如果大于，keep popping item from priority queue unti the minimum end time > cur_start，keep tracking max of cur_cpu_count。顺利写完加test，test中间有一个小bug，找到bug并修正。很明显，我根本从东欧大哥的表情上看不出任何的feedback， 不过挺自信这题答的没问题。 

第三轮，culture fit 白人product manager。聊了之前project的desig， data model的design(normalization vs denormalization, transactional db vs reporting db)。 包括各种behavior question（conflits with your manager， colleague？ time management？ how to counque challenge？）这轮说实话是聊的最愉快的一轮， 至少是面带微笑充满互动的沟通。 

第四轮， 一个刚毕业一年的中国小哥和一个从google跳去p的senior engineer（reverse shadow）－－也是中国小哥。 题目是给定两个函数， get_files(dir), get_dir(dir) 返回所有内容相同的file，问怎么定义内容相同，用文件名还是binary， 小哥说要内容相同，那我就用recursion遍历所有file， 然后用hashing把文件的内容hash成key放在dictionary，最后返回这个dictionary。很快写完code，test case。 小哥follow up说， 如果hashing非常expensive怎么办， 答曰hashing前先check file size，如果文件大小一样，再用hashing判断是不是一样。 小哥点头，又来一个follow up说get_files, get_dir如果expensive怎么办，答曰用parrallel programming （gpu or multi core） 可以优化，小哥点头。

迎来第五轮system design的面试官。 第五轮，又是一国人小哥， 设计一个log ingestion system。log包括user activities on mobile and browser。 terabyte/day 级别的。 我把设计分成了两部分，用flusk framework，client side and server side。 client side用cookie或者mobile app有个线程追踪event，然后每隔几分钟http post server。server side controller把log存到file。 另外用一个kafka producer tail log file， 然后publish 到对应的consumer， consumer再ETL到对应的service db（当然还有不同的db connector）。全程国人小哥多数在看自己电脑，时不时点头敷衍一下。等我在白板上diagram画完了（也不知道他听没听进去），小哥说怎么highly scalable， 答曰，用load balancer， replication handler， master－slave， heart－beat bla bla。

最后握手，道别，滚粗。 这次面完感觉虽然期间交流不是很愉快和谐，但是自认题目都答得可以。没想到过了一个星期，recruiter发邮件说team决定not move forward。发了邮件问有什么可以improve的地方吗？recruiter也是不理不睬。失望的同时，也让我对pinterest彻底的失去了兴趣，也不是酸葡萄心理。只是觉得这次的面试经历非常的不愉快。 原来觉得pinterest的engieering非常强，面了以后觉得水平也就那样。国人面试官的傲慢，自大。recruiter整个过程的效率低下，沟通不顺畅。看了之前地里p家的面经都评价不错。 不知道为什么我这次却大相径庭。面试的过程应该是平等的，双方都投资了时间和精力，电话通知一下，然后给个feedback应该不是什么过分的要求吧。


1. 给一个string，判断是否是Palindrome。 2. 给一个string，找最长的substring同时也是Palindrome。 


第一轮电面很简单：word count，输入一个string，返回word number. 要求不要用一些现有string api, follow up也很简单，类似与－连接一个单词怎么修改代码。自己写一些test case跑一下。 然后面完就有onsite onsite很折腾，6轮在一个下午，完全没有休息，疲劳轰炸，似乎运气不好被安排面试的姐姐坑了才有这个安排，不过当攒人品ing 
1）系统设计一个production level的storage center。因为背景，所以接口用restful webservice。问了一些http protocol。其实答的不太好，不过中国叔叔估计面恶心善，事实证明也没有因为这个挂我。然后其他就是p2p最基础napster设计，然后说说弊端，比如single server failure怎么解决，纯说就可以 
2）原来在twitter的一个印度小哥，似乎热衷于用dropbox原题，第一个让做phone combination，由于之前吃过不老实说做过的亏就跟哥哥说做过了，然后就是dfs filesystem原题了。然后细节问的多，纠结在hardlink还有softlink里面，要说说特殊例子怎么jiejue 
3）算法，做一个游戏，输入一个array，array代表可以向左或者右走的步骤，然后给个开始点j，如果走着走着到了array == 0就赢了，判断能不能赢。做的比较快就再做了merge k sorted list。跟小哥说了heap解，但是写起来比较简单，就写了merge sort。说了下复杂度还有扯了点分布式的话hardoop之类云云。
4）qa 
5）系统设计，和他们组做的有关，本质上还是分布式扯一扯，当时有点饿晕了不太记得扯了什么，讲话的是一个不太在重点上但是人很nice的白人大叔。 6）hiring manager，带着逛，是人很好的ibm中国哥哥，第一轮电面的人 尽可能记得的都说了，希望能多攒人品，一切顺利～ 


两道比较简单的题目: 1. Maximum subarray sum. 2. Print linked list reversely. 


binary tree zig level traverse, LC 上面的； Time Interval merge， 也是 LC上面的， 都是高频， 

美国小哥面的，上来寒暄了一下，聊了一下天气，然后问了一下现在做的东西，大概花了17分钟。 接下来就写code，小哥举了几个例子，
意思就是要写sqrt(x) 一开始说可以先写 
public int sqrt(int n) 找到最近的整数 我就直接二分查找开始做，大概就是设好上下界每次找中间的。但要注意防止溢出。然后在确定最近一个最近的整数时候觉得很麻烦。 就提出说直接写 

double sqrt(int n) , 设置一个theshold = 0.0001 小哥觉得ok，就写完了，写完了开始编译，有一些语法错误改了过来。小哥就说写 double sqrt(double n)，其实差不多，就注意一下 0-1的特殊性 写完了有个小bug改了过来。 然后小哥问时间复杂度。 其实我不太清楚，就答log(n)，但还说了depend on数据的精度。小哥说跟theshold有没有关系，我觉得有道理，就连连说有关系。 然后又寒暄了几句，就拜拜了。 


国人小哥2点准时打电话过来，先是讲了面试的流程，接着开始做互相介绍，大概花了15分钟左右，
接着小哥出了一个变形版的decode ways。 假设1对应的是‘a',..., 26对应的是’z'，现在给一个integer，求出所对应的可能的string 方法的接口是： public static Set decode(int num); 


deep copy of a graph may contains cycle 


又悲剧了，贡献P家电面题目，其实很简单 给你一个string array，比如{“abc”， “def”， “hg”} 让你返回abc， def and hg 面试的阿三说有个bug，从此大脑短路，20分钟都没找到，丫非坚持有 各种例子都试了，他们家用coderpad，马上可以跑，lz最后说你丫有本事给我个反例 结果丫说这个问题就这样吧，然后扯了10分钟淡，哎 

Pinterest电面两轮： 
1. 第一轮很简单，在collabeit,就是看看有没代码能力，这轮pass了： # write a function that takes a single argument (a # list of names) and returns a string representing the English-formatted # conjunction of those names. 
# # For example, given these names: # # The output would be: “Alice, Bob, Carlos and Diana” # def conjunctNames(names): line = “” length = len(names) for i in range(len(names)-1): if i == len(names)-2: line += names+' and' else: line += names+', ' line += ‘ ’ + names print line # Once the above is working, we iterate on the problem by adding a second # argument to our function. # # This new argument is called `limit` and controls the maximum number of names # that should be displayed. Any remaining items are “summarized” using the # string “# more” (e.g. “Alice, Bob and 2 more” when `limit=2`). def conjunctNames(names,li): line = “” length = len(names) limit = li num = length - li if num <= 0: limit = length-1 for i in range(limit): if i == limit-1: line += names+' and' else: line += names+', ' if num > 0: line += ‘ ’ + str(num)+' more' else: line += ‘ ’ + names print line # CODE READING（what's the purpose of this function） def getFieldToItemsDict(list_of_items, field_name): d = defaultdict(list) for item in list_of_items: d.append(item) return d # find bug in this function, this is my corrected version, th bugs are some minor subscript bugs, note the edge cases def sb(sorted_list, needle): def sb_internal(low, high): if not sorted_list: return None if low > high: return None pivot_pos = (low + high) / 2 if pivot_pos >= len(sorted_list): return None elif pivot_pos < 0: return None pivot = sorted_list if needle == pivot: return pivot elif needle < pivot: return sb_internal(low, pivot_pos) else: return sb_internal(pivot_pos + 1, high) . return sb_internal(0, len(sorted_list) - 1) 
2.二轮问了项目，preference,然后coding: code isBipartiteGraph, 注意robustness, graph can be not strongly connected.看代码习惯， 注意不让user有太多传进参数。这轮有点紧张，面得不好，跪了。

链接: https://instant.1point3acres.com/thread/138675
来源: 一亩三分地



Pinterest的面经不多 现在有机会回报地里 顺便求大米 攒RP 求offer 因为楼主人在湾区 所以面试全过程都是去到Pinterest HQ里的 感觉面对面的交流确实比电话里轻松很多 Pinterest的人也都特别nice 里面超多小美女小帅哥 
第一关 HR 邮件约了时间 说有没有兴趣亲自来Pinterest里面喝杯咖啡 当然有了！！！ 在Pinterest里 边逛边presentation楼里面一些有趣的设计 比如会议室的名字都是collection啊 makathon的“作品”啊 。。。 最后在大堂里面找地方 开始聊背景 聊Why Pinterest 聊聊聊。。。 临走的时候送了一袋Pinterest的纪念品 开心 总体感觉 HR特别贴心 印象超好 
第二关 美大叔 因为第一轮是去了HQ里 面对面聊 感觉不错  所以第二轮phone 就又跑了一趟 “onsite” phone interview 在楼里被带进了一个白板上写着Welcome 的房间 感动啊。。。被当人看了 美国大叔进来先开始问经历 Why Pinterest 。。。 聊得挺开心 聊了大概半小时后 反应过来说那咱们写code吧 Pinterest面试是让你选白板还是电脑 我选的电脑（不想擦白板） 不会当场run code 觉得主要还是看思路 考的是LRU cache 说思路 写code 面完之后 聊得开心 写的开心 所以尽管时间到了 又在大厅里聊了接近半小时 善谈的美大叔 感激 好人啊！ 
第三关 onsite 第一轮 国人大哥 culture fit  一开始 巨紧张 巨兴奋 加上 面试之喝的咖啡 结果 国人大哥好人 一直在说 slowdown 还开开玩笑 哼哼歌 缓和气氛 让我放松 后来回想 觉得当时口脑不同频 脑子的转速比嘴快太多 想到了好多 没全说出来 说的也不是很有条理 诶。。。太兴奋了 问了简历, Why Pinterest, Why you, Your interest ... 午饭 美姐姐 在G很多年PM跳槽 刚入职没多久 随便聊一聊 兴奋到没什么胃口吃饭 不过Pinterest家伙食还是不错的 包午餐和晚餐 第二轮 印度二代？ABI 简单聊两句 开始做题 题目是给两个json 输出两个的合并 合并的结果不包括两个json的intersection 写完了之后follow up了怎么improve 怎么test 小哥一直在他的电脑上做笔记 第三轮 美哥 在面之前 因为看了其他的面经 一直以为这轮会是System Design 准备吐名词 被大神碾压 结果小哥上来 拿着电脑说 这轮是code reading和architecture 所以咱们先来reading 后面再design一个game 石化的同时窃喜 幸亏不是SD reading 是从Java和Python里面选 我选Python 然后给你看一些function 让你说出这些function是干什么的 边看code 边说思路 有一些API没用过 我说不知道 小哥会举例子 好人！ design OOP 是 贪食蛇 pseudo code就可以 
第四轮 亚裔二代？ABC？ABK 这轮交流的最生涩 说什么感觉小哥都慢悠悠的说 Ooooo.Kkkkk.... （估计是not ok的意思） 上来先聊简历 最后这轮才稍微详细的问了简历 其他轮都没多问 然后介绍他 然后问我有什么问题问他么 （难道这就是面完了的节奏么） 就问了几个问题 终于还是出题了 说这题是他刚加入时和现在每天要处理的问题（真假的？！） 他说了好久题目 大概意思是有log file 记录了 user, time, platform 和 一些 operations 每个operation是递进的关系 要输出每一步没有进行到下一步的百分比 和 进行到最后一步的占总人数的百分比 面完等了一周 recruiter还是说拒了 虽然题都答出来了 感觉交流的也还好 整个过程都挺好的 可还是简历不牛X 实力不够吧 在大神面前也是装不下去的 木有自信啊。。。 Pinterest还是很好的 给人感觉很舒服 大家加油 争取他们家offer！ 悲剧了还给Pinerest做广告。。。 真爱啊 T.T 写了这么多 希望有帮助 因为频频悲剧 处于找工崩溃边缘 求大米 攒RP 求offer 求面试 求onsite 求内推 

链接: https://instant.1point3acres.com/thread/138860
来源: 一亩三分地





感觉网上的面经太少了，稍微来加一笔吧。 写在前面： 拿到面试的方法比较特殊。我本来想内推，不过听朋友说pinterest在一波一波地冻结申请（就是你申了先放置play一阵子，有空了处理一批）。当时觉得直接内推机会不大，然后就想等等看朋友的申请如果开始move on了我马上内推进去会不会有点效果。结果等的过程里，他们家跑来我们学校开了个极其短的info session（哥大）。
于是头天晚上认真看了他们家的engineering blog，第二天在info session大家围着问问题的时候，问了一些明显和其他人的“你们家招实习嘛”“你们工程师多少人呀”“你们都用什么技术呀”这种问题很不一样的，比如“你们的rich pin是怎么想到的呀”“你们的cpm真高，是一开始就以这个为目标吗”，吸引到了recruiter的注意。然后让我回去发她邮件，就拿到面试了。听说那天直接拿她邮箱主动发邮件的基本都被放置了，看来刷好感还是有用的。 电面： 
0，面试我的是个非常有名的大佬，我提前看他的各种访谈，把自己都洗脑到和他的价值观差不多了。结果开始聊天10分钟，我直接轰炸了一大串我的想法和对pinterest的愿景，对面都是good good you hit all the points。 
1，全程接下来就讨论一道题，如何去爬一个网页上的图片，把值得pin的筛选出来，然后返回一个整理过的格式。爬网页的接口写好了会返回整个html页面的内容，要做的就是如何找到img元素（有两种，可能是tag里，也可能是用css的背景属性设定出来），然后如何对元素进行判断（比如要细长的图片，适合pinterest主页，然后meta tag里又有一些和rich pin有关的东西）。虽然是javascript最好，用其他语言只要大概意思到位了也可以，不会跑你的代码只是看你写的过程，比如我就是用java。总之是个很有意思的题，是他工作里实际碰到的一个问题，就和他一边讨论需求一边提出看法。似乎我提到的一个读取window长宽来对比图片长宽，还有读取图片meta信息来加速分析这两个让他有点中意。 
2，没问题了，是的，就一个实战题讨论到最后。完了直接告诉我你准备onsite吧小子。谢谢大哥不rej之恩。 写在后面： 总得来说是个很轻松愉快得电面，等着onsite被虐了，不过大家都很nice，被虐也如初恋！ 

链接: https://instant.1point3acres.com/thread/137546
来源: 一亩三分地





找同学内推的。。两轮电面，结果面到第二轮跪了 第一轮： 三哥，感觉很凶。。两题leetcode 原题，
1. serialize and deserialize binary tree 
2. merge k sorted arrays/lists . 由于这两题之前写过，所以30分钟搞定。 两天后收到第二轮通知 第二轮： 本来安排一位国人大叔面的，结果上来一听又是位三哥（运气真是好）。 regular expression matching... 当初lc看这题是hard就直接跳过了，结果悲催的被面到。坑坑巴巴的写了40多分钟。 第二天收到拒信 

链接: https://instant.1point3acres.com/thread/142484
来源: 一亩三分地




