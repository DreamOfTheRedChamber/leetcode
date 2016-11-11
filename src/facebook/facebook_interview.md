三轮 
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=207534&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26sortid%3D311

第一轮behavior 撤了一大堆 然后move zero 最悲剧了。。lz没写过前后两指针的 有bug。。. 鍥磋鎴戜滑@1point 3 acres

第二轮 写一个小parser 再写一个找fb共同好友的题. visit 1point3acres.com for more.
虽然没见过 但还是运气不错 写出来了 而且最后用了bucket sort取top k 小哥很满意

第三轮 扯淡的顺时针打印树 各种corner cases 用的是先根 后右 叶子 左的方法 各种corner cases不忍直视 没写过真的一遍写出来无bug不容易 吭哧吭哧写完 跑了cases 时间 空间复杂度也算是最优了 但是就只做了这一题

估计要跪就在第一轮的behavior的move zero了 真心没注意这题有几个corner cases 


http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=208442&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26sortid%3D311
顺便提个电面题，利特扣得题的基本计算器，不过没有减号和除号；跟进问题是有括号如何处理。。。话说电面题怎么感觉比昂赛还难 -_-||

Pirate: 白人小哥，给一堆二维坐标表示饭店，以及一个当前位置，找最近的k个饭店。如果不只是饭店，还有其标签怎么处理优化。
Jedi：亚裔女PhD，先是PhD research和behavior 问题。之后同是二维坐标找k个最近的点。不过Pirate是偏系统设计和数据结构优化，Jedi就是写个简单代码。
Ninja1：克罗地亚小哥，一个机器人在一个二维的地图上，对地图信息一无所知，包括长和宽。只有一个move命令可以控制机器人，可以东西南北走一步并返回true，如果是墙会返回false。求机器人可以到达位置的总个数。如何优化？.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
Ninja2：国人小哥：验证二叉查找树，先要求写递归法或迭代法，再写个分治解法。再来一题，找出二叉查找树最大的k个结点。

http://www.1point3acres.com/bbs/thread-206287-1-1.html
刚刚面完 感觉是个中国大哥 move zero +
word break
写个BST 的 in-order iterator. 要写的function有 next() 和 all(), next 一次return 下一个node； all() return所以剩下的。
follow up是 改成 preorder 和 postorder。 我全用的stack  本来很基础的东西我磕磕绊绊40分钟勉强写完 这到底算几道题？ 一般二面intern结果多长时间能出？


http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=206743&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26sortid%3D311
第一轮三哥：
k个二进制数相加
给一个数组，每个元素有一个概率，写一个函数按照每个元素的概率每次返回一个元素。比如1：0.2，2：0.3，3：0.5    返回1的概率是0.2，返回3的概率是0.5
第二轮美国人behavior：
自我介绍
project dive deep
coding：反向打印链表
第三轮中国人：
serialize和deserialize二叉树
. From 1point 3acres bbs

4sum

min windown substring。 leetcode那道hard里面很简单得。
第2题，变形sort color。

http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=207547&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26sortid%3D311
第一轮，美国大哥，先是behavior，问了很多项目的问题，然后一道coding，merge two sorted linkedlist，之后follow up，结果集不能有重复元素。. from: 1point3acres.com/bbs 
第二轮，美国小哥，说话有点儿大舌头，上来也是先问了下简历，不过就是随便哈拉了几句，出了一道题，print all root to leaf paths，做完以后，小哥问了空间复杂度，我说O(n)，他说不对，因为用了recursive，每一层都传的string，当时没想明白，回答的不好，然后就在这个问题上交流了很久，发现是O(n2)，之后让优化，想复杂了，最后发现换成stringbuilder就行。这轮就做了这一道题，小哥一直拿着小本儿在记记记，感觉面的不大好。
第三轮，中国大哥，介绍了一下自己就开始做题，先出了一道两个string相加输出结果，很快做完。之后，做了一个在有向图中，给两个点，求最短路径。一开始听岔了，返回的是路径长度，大哥说要全部路径，稍微改动了一下代码就OK。之后就是QA环节。
第四轮，两个人进了屋，面试官是个亚裔小哥，感觉应该是个abc，因为口语很溜。这轮就应该是传说中f家来锻炼新面试官的那一轮。啥也没说直接做题，第一题就是一个two sum，不过只返回true or false，一开始用hashmap，写着写着，我问了一句有没有重复元素，他说有，我说那可以用双指针做，他说为啥，我说双指针空间用的少，然后他说他不管空间，只要时间上最快，我就继续写hashmap，其实我当时是没想明白，写着写着一下想明白了，很快做完，之后很逗得的是那个面试官没看懂，我给他讲了好多遍又举了很多例子，他才说你做得对。之后又出了一道把数字转换成英文大写的那道题，我边写边给他讲思路，他又没听懂。。让我先写代码，然后他抱着电脑，可能查答案去了。后来写到处理十位的时候，他说时间来不及了，让我说下后面的思路因为算法最主要的部分已经写出来了，说了说之后他说可以，之后QA一下就结束了。

http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=207529&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26sortid%3D311
1. 问了三题，第一个应该是LC300 :D 以为成LC128，不过后来发现问题赶紧改回来，这一下感觉很不好，跟没进入状态也有关系... 都没好好看题
第二题应该是LT102，因为第一个不好，这个赶紧不装秒了
第三题应该是LT151，为了弥补第一个不足，也赶紧秒了 0 - 0 然后聊天
2. 问了一题，又遇到悲剧的事情，看到过的面经，因为频率很低，所以觉得自己应该碰不上... 就没准备 0 - 0 所以遇到活该. more info on 1point3acres.com
Longest Arithmetic Progression
http://www.geeksforgeeks.org/length-of-the-longest-arithmatic-progression-in-a-sorted-array/
原面经贴忘了在哪儿了，只记得当时搜了一下这个结果文章太长没看 T_T.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
最后用n^2时间和n^2空间解决掉了，似乎华人姐姐希望我优化时间 0 - 0 但是没有做到，空间也尝试了一下，失败了
然后follow up一下是输出最后最长的那个结果，这个就用两个变量标记一下输出即可. 涓€浜�-涓夊垎-鍦帮紝鐙鍙戝竷
最后让我描述了一下为啥想到这么做，然后说一下brute force的算法复杂度，说错了应该是n!说成n^(n - 1)
3. behavior，就问问各种过去的项目和一些小问题


第一题 flatten tree to linked list
      a
   b   c
d   e  f      to     d->b->e->a->f->c
第二题 strStr()，然后求复杂度. more info on 1point



http://www.1point3acres.com/bbs/thread-206262-1-1.html
Convert binray search tree to circular doubly linkedlist. From 1point 3acres bbs
面经里的老题了， lintcode也有类似的题， 只是不要求circular. 鐗涗汉浜戦泦,涓€浜╀笁鍒嗗湴
http://www.lintcode.com/en/probl ... doubly-linked-list/
一面面经在这里， 虽然code很messy而且写出了bug， 但好在是国人小哥, lol
http://www.1point3acres.com/bbs/thread-205369-2-1.html
面完一小时就说进pool了，太喜欢脸家的效率，尤其是跟某家相比，大家都懂的，咳咳
以下是流水账......
一接电话是印度小哥， 感觉略慌
大概20分钟做完题， 就开始脑跑test case，跑完一个又来一个，大概印度小哥觉得我的方法不对？
发现code木有问题之后就开始refactoring，把repeated code写成function，开始没明白想让我干嘛耽误了一点时间
最后还有10分钟问follow up， 说如果是balanced bst应该怎么优化？我有点懵逼， 之前的code是O(n) time， O(h) space， 如果bst是balanced， 只是h = log(n)， 还能有更好的算法优化么？
沉默了一会儿印度小哥说你想想如果有多个thread， 恍然大悟原来是想让我parallel啊， 于是立马说， 左子树右子树分thread算然后再合并， 之后被问到时间空间复杂度和需要多少个thread

http://www.1point3acres.com/bbs/thread-208455-1-1.html
刚刚面完的fb店面 开始前10分钟hr发邮件说面试官可能有事冲突 问我明天有没有空 我以为不面了 结果约定时间过了6分钟电话又打来了 匆忙开始面试是一个姐姐 人挺好的
第一题 robber house
第二题 给两个string string是一串数字 再给一个int base, assume base <= 10 就是给两串数字 数字是base进制的 然后加起来 返回sum


http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=206614&extra=page%3D3%26filter%3Dsortid%26sortid%3D311%26sortid%3D311
Coding题
1. vector dot product
sparse怎么处理？一个很长一个很短怎么优化
2. build itinerary，先是输出一个解就好，follow up是在所有解中间输出字母表序最小的
leetcode原题，我隐约记得有个比较好的方法但忘记了，只能用普通的dfs backtracking. from: 1point3acres.com/bbs 
3. add binary，我觉得主要跪在这里，我很傻X的每加一个数都insert到stringbuilder的最前面.鏈枃鍘熷垱鑷�1point3acres璁哄潧
但忽略了stringbuilder/buffer这种东西是array base的 所以插入的时间消耗是很大的，当面试官.鏈枃鍘熷垱鑷�1point3acres璁哄潧
问我你这个解法input很大的时候不是线性时间你觉得问题在哪里？我没有第一时间想到这点。
其实直接append 最后reverse就好。. 1point3acres.com/bbs
4. group anagram， follow up是如果考虑所有字符 甚至汉字日文韩文klingon 怎么办

Design-google 1point3acres
design memcache， 跟distributed system 0关系，问的很细，hash怎么设计，collision怎么办
每个node怎么设计，free之后的list怎么保存，插入是first fit还是best fit等等。-google 1point3acres

Manager聊天
比较正常的套路，就是project啊 人际关系啊 当你老板让你做你不愿意做的事情怎么办之类的。

上周五ref我的哥们说hr管他要ref letter了以为有戏（其实我也不知道这个是不是hr觉得还行才会去要）但周一还是告诉我跪了。不过也正常，面完就知道9成跪，因为答题过程中还是有不少瑕疵。感觉FB的面试难度真的不高，但是要求完成度很高，有点差错都会Good Game Well Played了...
. more info on 1point3acres.com

补充内容 (2016-10-20 06:53):. 鍥磋鎴戜滑@1point 3 acres
1. vector dot product就是 A{a1, a2, a3...} B{b1, b2, b3...} product = a1 * b1 + a2 * b2... an * bn. From 1point 3acres bbs
如果vector很稀疏，那么这么算就很浪费，所以第一步优化是只看非0的，记录成一个pair {aindex, aval} 再算 鏉ユ簮涓€浜�.涓夊垎鍦拌鍧�. 

补充内容 (2016-10-20 06:55):. 鐗涗汉浜戦泦,涓€浜╀笁鍒嗗湴
这样当某个index 在两个vector里都非0我们再进行计算。再一步优化是其中一个vector非零很多另一个很少，可以对非零很多的vector pair进行binary search找对应的index

补充内容 (2016-10-20 06:56):
2. 332. Reconstruct Itinerary




第一题：Multiply Strings:
Given two numbers represented as strings, return multiplication of the numbers as a string. (Leetcode 原题， medium）
第二题：Binary Tree Path：
Given a binary tree, return all root-to-leaf paths. （Leetcode 原题，easy）. 涓€浜�-涓夊垎-鍦帮紝鐙鍙戝竷
. more info on 1point3acres.com



http://www.1point3acres.com/bbs/thread-208210-1-1.html
传说签了NDA，不好发面筋。但是。。。
3轮面试。1. behavior。一个中国姐姐面的，这轮没面好，导致后面加面了一轮。最后问了一个bst，有两个node交换了一下，让找出这两个node，恢复原来的bst。
2. coding。一个印度小哥。lc158以及print bst path。
3. coding。罗马尼亚姐姐，可能是妹妹。两道sorting题。第一题是narutal sort，也就是aaa2应该排在aaa11前。follow up是如果可以存在不同进制的数，怎么处理。比如aaaA1x15, aaa6x13怎么比较，string中的一般字母全是小写的，不同进制里用英文代替的数字都是大写的。第二题是counting sort，与lc75类似。

9.8收到加面通知，9.12号完成加面。说是45min，但是面了1小时15分钟。问了一小时behavior question，然后15分钟做了一道题，类似lc的clone graph。

9.20要了reference，之后就是漫长的等待，一直到10.14才收到offer。

. more info on 1point3acres.com

补充内容 (2016-10-31 14:14):
behavior面经推荐，楼主就是按照这个准备的，基本覆盖90%的behavior question.
http://www.1point3acres.com/bbs/ ... id%3D311%26searc...


http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=207013&extra=page%3D7%26filter%3Dsortid%26sortid%3D311%26sortid%3D311
利扣91，做完dp解之后，又被问了不用dp怎么做（不限算法时间复杂度）
给n个d维的vector和一个first selected的vector, 选出k个vector,每次选择下一个时要求：选离所有selected vector最远的vector, 计算距离的函数已给出D(v1,v2)并假设调用此函数时间复杂度为O(1), 某vector与所有selected vectors的距离定义为这个vector与其nearest selected neighbor的距离。在面试官的提示下最终找到了复杂度为O(nk)的最优解，对每个unselected的vector存下其与selected vectosr的距离,每次遍历unselected vectors找出距离最远的vector为下一个selected vector, 用这个vector与每个unselected vector的距离去更新距离（若小于原距离，表示nearest selected neighbor更换了）  
给一个task序列ABBABBC, 和相同task的最小interval. 例如interval=3, 则BB运行时间为5（B_ _ _ B, _ 表示wait). 写一个函数输入task序列和interval, 输出总的运行时间。 follow up是给一个序列和interval，task的执行顺序可以打乱，输出optimal(总执行时间最短)的执行顺序
最近在做什么以及细问了简历。给一个手机键盘（只有0-9，不考虑*#那两个位置）样式的棋盘，骑士初始在数字1的位置，问走了s步以后（每步走日字），有多少种可能的走法。提示是可以hard code下一步的位置， 比如1->(6，8)。 应该可以用dp解，时间不多用了DFS/backtracking暴力解了. 1point3acr

电面：烙印，听不清楚说啥，还好可以在coderpad上打字，基本可以交流(1) Number of Islands
(2) LC 76

http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=192328&extra=page%3D7%26filter%3Dsortid%26sortid%3D311%26sortid%3D311
Onsite:
(1) Contact Dedup, 输入是这样的:数字是用户，字母是邮箱，有很多人有多个邮箱，找出相同的用户
  1- {x,y,z},  
  2-{x} 
  3-{a,b}
  4-{y, z}
  5-{b}
  6-{m}
  7-{t,b}
这样输出就是 [1,2,4,7] [3,5] [6] 总共有三个用户。. visit 1point3acres.com for more.
可以用UnionFind或者Connected Components的方法做，
（2） Behaviour Questions. more info on 1point3acres.com
light coding写了Clone Graph. 1point3acres.com/bbs
（3） 单链表反转. Waral 鍗氬鏈夋洿澶氭枃绔�,
         大数相乘，写了brute force，跑test case花了太久时间，没来的及写优化，简单聊了聊Divide Conquer的办法
（4）TinyURL，这个题准备到了，后来HR说这一轮答的最惨，MB被烙印黑惨了


http://www.1point3acres.com/bbs/thread-205379-1-1.html
然后题目是 lc.257 要把结果print out

follow up 是问如果node 里面value 类型不确定怎么打印

略懵，反复问了好多遍最后快结束想起来说用 parseJSON 转为JSON 存String，print string


http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=205944&extra=page%3D11%26filter%3Dsortid%26sortid%3D311%26sortid%3D311
一烙印面的，上来一道简单的题，intersection of two arrays。 看到这么简单的还挺激动，但故事肯定不是这么简单啦。. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴
先把简单的two pointer解法写完，然后问可不可优化。尼玛，都O(m + n)了，还要咋。
于是说如果一个特长，那就binary search吧。好写完了。问如何优化？ 尼玛，都mlog(n)了，还咋样啊。
于是说如果找到了，一个元素，那就用这次的index作为下次binary search的开始。可以节约掉之前的东西，不用search了。然后问，如果找不到呢，如何优化。尼玛-google 1point3acres
折腾了一会儿，说如果找不到，也返回上次search 结束的index，然后下次接着search。终于时间到了。
感觉要黑也是有操作空间的。. 鐗涗汉浜戦泦,涓€浜╀笁鍒嗗湴
现在FB是不是喜欢问follow up， 而不是2个问题了？


刚面了fb的电面， lc原题297， 求onsite

上周店面的f家，是个美国女人，问了三道题
stock1 （买卖无限多）
stock2 （买卖一次）
stock3 （买卖两次）
过了，hr给feed back说写完没有自己test，下次得注意了



Career Fair随便投的简历...结果居然收到面试邀请了...
是个印度小哥，但是感觉人蛮好的，好像也没什么口音。上来先问why Facebook，还有想给Facebook加什么新功能。
两道code题：
1. Add Binary.鏈枃鍘熷垱鑷�1point3acres璁哄潧
2. 我没见过的... 给很多组pair，［(1, 3), (2, 4), (3, 10), (5, 9)］这样，然后(1, 3)就相当于坐标轴上1到3的一条线，然后问最多有几条线overlap...



https://instant.1point3acres.com/thread/195722?from_discuz=1
两道题，题目不难，就是第二道不算leetcode原题，但也挺简单。 第一题 leetcode原题 firstBadVersion。很快写完之后，小哥问我如果这题recursive做怎么样，我正琢磨着要不要写，他又问优缺点是啥。我就说recursive做这道题不好，要用stack memory，如果stack太深的话还有可能stack overflow。然后他沉吟了片刻，正当我以为他要出各种地里说的follow up时，他直接说下一道了... 第二题 最单纯的两点之间最短路径，但是没实际的图，告诉你每个点uniquely labeled而且是有向图没回路, 然后就两给两个API， 一个叫 getChildren(int num), 返回这个点通向的所有点。 还有个一个叫getParent()，这个function有些诡异，返回的是所有没有incoming nodes的点。 让你实现 List shortedPath(int start, int end)。LZ当时百思不得其解这个getParent()有啥用，用BFS做完之后，强行用上这个function，说在做之前先判断下end在不在getParent()返回的list里...如果是就直接返回了。小哥说That's good...也不知道是不是他的本意。follow up问我DFS能不能做，我当时心想这难道要让我写吗，就说DFS不好，不适合做最短路径，会绕路。小哥就说You're right。 


https://www.glassdoor.com/Interview/Facebook-Interview-Questions-E40772.htm
Given two words and a dictionary, print the path from one word to the next changing one letter at a time  
binary search
Finding the minimum k elements of a list  

Round 1:
tree traversal problems.
1) Given a tree structure, print the preorder sequence of the tree or postorder sequence of the tree. 2) Given a sequence, construct a binary tree from it. 
Round 2:
1) valid palindrome,
2) longest palindrome of a string.
3) Sort colors (as in leetcode).  
Round 3:
Talk about their projects. Asked me a machine learning design problem. I forget the details. 

first round: array based question (never seen before on CTC/leetcode/glassdoor),
second: getting to know me. Again I had an engineer who works on mobile where as I have 0 experience in that. Could feel a little disconnect as I was very interested and excited about their feed team and ads team.
Third round: Leetcode question. Medium level. Doable..so went well
Interview is all about being quick, why facebook, KEEPING CALM.  


https://www.careercup.com/page?pid=facebook-interview-questions

Given two (binary) trees, return the first pair of non-matching leaves 
Tree 1: A, B, C, D, E, null, null 
Tree 2: A, D, B 
Output: (E,B)


Given: sorted array of integers 
Return: sorted array of squares of those integers 
Ex: [1,3,5] -> [1,9,25] 
Integers can be negative.

https://www.glassdoor.com/Interview/Facebook-Software-Engineer-Interview-Questions-EI_IE40772.0,8_KO9,26_IP2.htm
Given many points, find k points that are closest to the origin.  
Onsite:
1. isolated island number in matrix
2. Merge sort (just pure merge sort), but absolutely no bug
3. selling stock III
4. Haffman code implement  
Least Common Ancestor of a binary tree, then a binary search tree.  
Given an array of commits, return the first bad commit?  
/*
 sorted array of integers
 sorted array of squares of those integers
 Ex: [1,3,5] -> [1,9,25]

 */

Phone interview
*********************
1. Valid Palindrome
Easy level question in Leetcode
2. First bad version (Binary search solution)
Easy level question in Leetcode
Onsite interview
**********************
1. Serialize and Deserialize Binary Tree
Hard level question in Leetcode
2. Simplify Unix path
Medium level question in Leetcode.
Given an absolute path for a file (Unix-style), simplify it.
For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
3. Note: Copied this question from Glassdoor. I was asked the same question.
You have an unsorted array of… 
 
In a BST find the next element of given element   
 
Given a list of sorted integers, and a target sum, return True if there is a consecutive set of numbers that add to the target sum.   

Design the Google search bar that prompts you with suggestions as you type in it. These suggestions are not personalized but based on most popular queries in the past by all Google users. e.g. as you type "Fac" in the search bar the drop down prompts you with "Facebook" or "Facts about Great Britain" and so on based on recent most popular queries. Once designed, optimize this based on feedback… 

used leetcode and hackerrank for preparation, but some interview questions were new for me. 3SUM, Intervals intersection, palindrome, BST to linked list conversion.




15. 3Sum

139. Word Break I/II

91. Decode Ways

209. Minimum Size Subarray Sum
Map store previous values ( O(N) )
把第一题extend到2D。给一个matrix, all elements are positive，问有没有个sub rectangle加起来和等于target。return true/false。
Lz听到题目有点懵，认真调整心态，解决之。先写了个cumulative sum。把所有从0,0 到i,j的和算在新的matrix的i,j上。方便之后算head到tail的sub rectangle的和。这一步O(n^2)


350. Intersection of Two Arrays II
Sort, then find duplicates


给一个字典包括很多字符串(e.g., abcd, dhfyf)，然后给定一个字符串查看字典中是否包含这个字符串。字符串中可能包括*，*可以匹配任何字符。我用的Trie。
Task那道题，很多面经都提到过。就是比如给你一串task，再给一个cooldown，执行每个task需要时间1，两个相同task之间必须至少相距cooldown的时间，问执行所有task总共需要多少时间。比如执行如下task：12323，假设cooldown是3。总共需要的时间应该是 1 2 3 _ _ 2 3，也就是7个单位的时间。再比如 1242353，假设cool down是4，那总共时间就是 1 2 4 _ _ _ 2 3 5 _ _ _ 3，也就是13个单位的时间
基于1，给出最优的排列，使得字符串最短。


自然string comparator。不知道的搜下。就是string 比较的时候考虑里面数字的大小，比如 abc9 < abc123 abc > ab9  因为char比digit重要。
. From 1point 3acres bbs
117. Populating Next Right Pointers in Each Node II
salbring tree，不过没有next指针， 你要用原来的left，right指针

Level BFS


binary tree转换成doubly linked list
And revert it back (reverted to balanced tree): 109. Convert Sorted List to Binary Search Tree


75. Sort Colors

Print a binary tree by columns top to bottom.

We're given a sorted array of integers: [-3, -1, 0, 1, 2]. We want to generate a sorted array of their squares: [0, 1, 1, 4, 9]
. Waral 鍗氬鏈夋洿澶氭枃绔�,
list of sorted integer arrays，要求找所有的数的median. e.g. [1,3,6,7,9], [2,4, 8], [5], return 5

two sum + three sum + follow up

Best Time to Buy and Sell Stock, (I and II)
buy and sell stock，每天可以买一股，也可以都卖了，或者不买不卖。

Find maximum, buy from earlier days, and sell on that day.


33. Search in Rotated Sorted Array

38. Count and Say

sparse vector dot multiplication
这道题我当时并没有准备到，但是正因为如此，我认为我跟面试官的交流给我加分了不少。面试官首先问我每个vector很大，并不能在内存中存下，该怎么办，我说只需要存下非零的元素和他们的下标就行，然后询问面试官是否可以用预处理后的这两个vector非零元素的index和value作为输入，面试官同意后快速写完O(M*N)的代码，M和N分别是两个vector的长度。面试官说这两个输入如果是根据下标排序好的话应该怎么办，我说可以遍历长度较短的那一个，然后用二分搜索的方法在另一个vector中找index相同的元素，相乘加入到结果中，这样的话复杂度就是O(M*logN)。这时，面试官又问是否可以同时利用两个输入都是排序好这一个特性，我在这个地方有点卡住，但是在白板上写出一个test case，试着用可视化的方法帮助我来进行思考，同时面试官给了一些提醒，最后写出了O(M + N)的双指针方法
然后问如果有一个向量比另一个长很多怎么办，遍历短的，对长的二分查找。
两个vector相乘

. 鍥磋鎴戜滑@1point 3 acres
211. Add and Search Word

239. Sliding Window Maximum

282. Expression Add Operators

158. Read N Characters Given Read4 II - Call multiple times

49. Group Anagrams - use counting sort

linked list 反序输出 - 1) reverse the list; 2) recursion

问题一：flatten an array?
. 1point 3acres 璁哄潧
285. Inorder Successor in BST

283. Move Zeroes
Minimizing “writes”
. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴

5. Longest Palindromic Substring
62. Unique Paths I/II

moving all the nonzeros to the front of a list。

Prettify JSON:  输入[1,2,3, {"id": 1, "name": "wang", "tag":[1,"home",2], "price":234}]

Smallest subarray with sum greater than a given value:

flatten nested array

215. Kth Largest Element in an Array

114. Flatten Binary Tree to Linked List
Linked list needs to be formed as a cycle


301. Remove Invalid Parentheses (hard)
Maintain counter and go from left to right, remove when necessary, then counter must be > 0, then remove “(“ from right hand side
. 鍥磋鎴戜滑@1point 3 acres

218. The Skyline Problem (hard)
. visit 1point3acres.com for more.
278. First Bad Version

Min Queue, 跟Min Stack类似， 实现一个Queue， 然后O（1）复杂度获得这个Queue里最小的元素。

interval [startTime, stoptime)   ----integral  time stamps
给这样的一串区间 I1, I2......In  
找出 一个 time stamp  出现在interval的次数最多。
startTime <= t< stopTime 代表这个数在区间里面出现过。
example：  [1,3),  [2, 7),   [4,  8),   [5, 9)
5和6各出现了三次， 所以答案返回5，6。  (Hard)

shortest continuous substring with all characters in input
76. Minimum Window Substring

. more info on 1point3acres.com
合并邮件列表（后来才知道也是个面经题）
Given 1 million email list:
list 1: a@a.com, b@b.com
list 2: b@b.com, c@c.com
list 3: e@e.com
list 4: a@a.com
...
Combine lists with identical emails, and output tuples:
(list 1, list 2, list 4) (a@a.com, b@b.com, c@c.com)
(list 3) (e@e.com)

79. Word Search

输出所有 root - leaf 的路径，递归做完了让迭代。
Iterative? BFS?
. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴

17. Letter Combinations of a Phone Number

28. Implement strStr()

398. Random Pick Index

37. Sudoku Solver

一个完全树。node有parent指针。
每个node的值为 0或 1
每个parent的值为两个子node的 “and” 结果
现在把一个leaf翻牌子（0变1或者1变0）. visit 1point3acres.com for more.
把树修正一遍

200. Number of Islands

BST to increasing array
Recursive, iterative
173. Binary Search Tree Iterator
. From 1point 3acres bbs
BST iterator
Iterator for a list of BSTs (heap contain each BST’s iterator)

128. Longest Consecutive Sequence

22. Generate Parentheses

238. Product of Array Except Self
. 涓€浜�-涓夊垎-鍦帮紝鐙鍙戝竷
191. Number of 1 Bits

给2D平面上的N个点，求离原点最近的K个点

33. Search in Rotated Sorted Array

找出两个给出两个string, leetcode, codyabc和一个数字k = 3,问两个string里面存不存在连续的common substring大于等于k.比如这个例子，两个string都有cod,所以返回true。楼主用dp建了一个m*n的table秒了，然后写test case,发现有个小corner case,改了,pass
Longest common substring


给定一个数列，比如1234，将它match到字母上，1是A，2是B等等，那么1234可以是
ABCD
但是还可以是12是L，所以1234也可以写作
LCD 或者
AWD

给出N个序列，比如2个序列A,B,没个序列包含若干的区间，比如
A: [1,5], [10,14], [16,18]
B: [2,6], [8,10], [11,20]
Merge them all:  [1,6], [8, 20].
. more info on 1point3acres.com
balance parentheses in a string
例子：
"(a)()" -> "(a)()"
"((bc)" -> "(bc)"
")))a((" -> "a"
"(a(b)" ->"(ab)" or "a(b)"
Note: balance的意思就是把原来string里unpaired的括号变成paired的形式。如果有多个可能的结果， 比如上述最后一种情况，我们就只需要输出一个对的结果即可，所以这点简化了题目的难度。感受： 遍历string， 用一个stack存储每个open parenthesis的index，也就是'('的index, 每当遇到closed parenthesis就执行一次pop操作。
注意两种unbalanced的情况：
1. 出现多余的')':
    对应情况就是stack为空，但遇到了一个')'。
2. 出现多余的'(':
    对应情况就是遍历结束，stack未空

get binary tree's next node in inorder
class Node {Node left, Node right, Node parent}
Node getNext (Node current) {}

给一个tree，每个node 有很多children，
找到所有最深的nodes 的common  ancestor,
比如只有一个点最深，那返回他自己。
Similar to 236. Lowest Common Ancestor of a Binary Tree
. 1point3acres.com/bbs

78. Subsets
90. Subsets II
.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
341. Flatten Nested List Iterator

102. Binary Tree Level Order Traversal

给三个funtions: is_low(), is_mid(), is_high(). 让给一个数组排序, low的放在最前面, mid的放在中间, high的放在最后面.
Color sort: think about when there are K colors


39. Combination Sum
.1point3acres缃�
125. Valid Palindrome
214. Shortest Palindrome
.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
98. Validate Binary Search Tree

Longest Arithmetic Progression)

10. Regular Expression Matching

211. Add and Search Word

138. Copy List with Random Pointer
. 涓€浜�-涓夊垎-鍦帮紝鐙鍙戝竷
71. Simplify Path

Maximal square:
.鏈枃鍘熷垱鑷�1point3acres璁哄潧
314. Binary Tree Vertical Order Traversal

198. House Robber
-google 1point3acres
53. Maximum Subarray

152. Maximum Product Subarray
. 鐗涗汉浜戦泦,涓€浜╀笁鍒嗗湴
32. Longest Valid Parentheses

277. Find the Celebrity

56. Merge Intervals
Variant: 一串start time － end time，格式是Apr 2010 － Mar 2011这种，要求计算出这些时间的总跨度，重叠的跨度不重复计算。举例：["Apr 2010 - Dec 2010", "Aug 2010 - Dec 2010", "Jan 2011 - Mar 2011"]

.鏈枃鍘熷垱鑷�1point3acres璁哄潧
57. Insert Interval

206. Reverse Linked List

implement circular array
Circular buffer


Check big/small endian

第一题：binary tree，给定一个value，return bin tree里面下一个比value大的值
第二题：binary tree的node加一个ptr next，point到inorder traversal的下一个node，比上一个简单

297. Serialize and Deserialize Binary Tree
. 1point 3acres 璁哄潧
Given a list of number, there is only one peak or one drop. Find the maximum drop.
Exps:
1 -> 2 -> 3 -> 9 -> 3 -> 0 = 9;
10 -> 4 -> 3 -> 8 = 7 ;

224. Basic Calculator
. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴
43. Multiply Strings
. from: 1point3acres.com/bbs 
282. Expression Add Operators

顺时针的print binary tree boundary, 就是从根开始，先打右边界，再打叶子，最后打左边界。

310. Minimum Height Trees
.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
不用“／”，“％”运算符实现division，说了可以用binary search

273. Integer to English Words

111. Minimum Depth of Binary Tree

找两个字符串中长度为N以上的共同子串
. 1point3acres.com/bbs
117. Populating Next Right Pointers in Each Node I / II
.鏈枃鍘熷垱鑷�1point3acres璁哄潧
29. Divide Two Integers

一个数组内要是存在至少三个升序的数（array[x] < array[y] < array[z], x < y < z）就返回true
. Waral 鍗氬鏈夋洿澶氭枃绔�,
161. One Edit Distance

print max depth path of a binary tree

151. Reverse Words in a String

261. Graph Valid Tree
any connected graph without simple cycles is a tree.


给一个linkedlist，里面的element都排序好了，但是是一个blackbox，有三个function可以调用。pop()随机pop出最前面或最后面的element，peek()随机偷看最前面或最后面的element，isEmpty()回传linkedlist是不是空了。问设计一个资料结构，list或是array都可以，把linkedlist里面所有的element都拿出来，并保持他们的排序。followup是如果不能用peek()该怎么做。
My thinking: if I got element A, and next element B is smaller than A, then A is from the tail of the list; otherwise, A is from the head of the list.


133. Clone Graph

Erase duplicate in an unsorted array

几何算法问题。如果给你一堆的矩形， 求重合矩形重合最多的坐标位置。我上过一个算法课，大概思路就是做一个二维的meeting room II
-google 1point3acres
给定N个2D坐标（可以设想为餐厅的位置），要求输入任意坐标，可以返回方圆d距离内的所有餐厅

65. Valid Number

253. Meeting Rooms II
求最多interval的时间点，返回任意一个就行。




补充内容 (2016-9-30 07:30): 鏉ユ簮涓€浜�.涓夊垎鍦拌鍧�. 
一夜暴富了。。。谢谢大家。我昨天又做了一些修改，删去重复，合并了一些。另外一些难题的还写了写代码。可是帖子不能编辑啊？太菜了。
PS，刚刚面了FB第一轮，iterator for merging K sorted arrays

 
 
 
 Round 1 behavior + coding （美国人）
我的第一位面试官感觉早上刚来上班就要面试，好像心情很一般，全程比较冷漠。behavior主要是自我介绍，自己未来想做的方向，how you see youself in 5 years，具体说自己做过的project。因为这位面试官在fb做广告的machine learning，对我之前的ml项目很感兴趣。但是楼主的这个project比较水，一下就被人家抓到破绽，然后又问我一些ml的概念我也是全懵逼状态，感觉让他更加不爽了。整个behavior大概25分钟。之后开始做题。LC 10. Regular Expression Matching。我把思路说了下，用文字写了各种Corner case的讨论。之后开始在白板上写。最后写出来大半，他说时间不多了不用写了。问了时间复杂度，我说O(n)。他问我确定吗。我其实也不太知道，因为我用的是lc discuss里面vote较高的一个recursive方法写的，这种带递归的时间复杂度我也不是特别清楚。最后问了他点儿问题就结束了。

后面两轮纯coding

Round 2：
俄罗斯小哥，有一点点口音但是好可爱那种。面着面着突然给我用中文来一句“你会说中文吗？”。 然后说自己正在学。. 1point 3acres 璁哄潧
上来就让我简要说了下上个实习做了什么就开始做题。
1，LC28 Implement strStr(). 鐗涗汉浜戦泦,涓€浜╀笁鍒嗗湴
2, 面经原题：Task那道题，很多面经都提到过。就是比如给你一串task，再给一个cooldown，执行每个task需要时间1，两个相同task之间必须至少相距cooldown的时间，问执行所有task总共需要多少时间。比如执行如下task：12323，假设cooldown是3。总共需要的时间应该是 1 2 3 _ _ 2 3，也就是7个单位的时间。再比如 1242353，假设cool down是4，那总共时间就是 1 2 4 _ _ _ 2 3 5 _ _ _ 3，也就是13个单位的时间。（我把自己写的代码附在后面了。）
这两题基本都是秒做。我先用例子来解释自己思路，边写也边说了每个步骤在干什么，最后有用例子给他跑了一遍。没有任何问题他也比较满意。最后随便问问问题就结束了。
. 1point3acres.com/bbs
Round 3：
美国小哥，邻家型。
也是上来让我随便说说上个intern就开始做题。. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴
1，面经原题：We're given a sorted array of integers: [-3, -1, 0, 1, 2]. We want to generate a sorted array of their squares: [0, 1, 1, 4, 9]。要求用O(n)。也是先用例子给他解释思路，然后秒写代码，再用例子给他demo。
2，LC43 Multiply Strings。写出来之后小哥发现一个小bug，后来他自己犯了个错误，我们讨论后他发现自己错了。之后问问题他也很开心那种。

面完后带着大家一起吃饭，下午逛逛公司，q/a环节以及玩儿vr眼镜。

整体下来感觉coding还可以，behavior可能比较不好。看地里好多同学被加面了behavior，估计我也得是吧。还有一点个人经验，就是写代码前和写代码后都要自己主动用例子来解释思路或是验证代码，这样不仅能让自己思路更清晰，还能发现自己的bug。这样总比被面试官指出来更好。


Calculate the square root of a double
Given n intervals [si, fi], find the maximum number of overlapping intervals.
Print all the paths from root to every leaf in a binary tree.
Print the sum of all the numbers at every vertical level in a binary tree
Given a set of n jobs with [start time, end time, cost] find a subset so that no 2 jobs overlap and the cost is maximum ?
Given 1 trillion messages on FB and each message has at max 10 words, how do you build the index table and how many machines do you need on the cluster to store the index table ?
Given an input array and another array that describes a new index for each element, mutate the input array so that each element ends up in their new index. Discuss the runtime of the algorithm and how you can be sure there won’t be any infinite loops.
Find all the anagrams in an array of strings
Combinations(n, k) – print all combinations of k out of n items
Printing a binary tree L-R,
Implementing a comparator function to sort files based on a certain naming convention.
Implement a LRU cache
Design FB newsfeed
How would you query for all the Places near a given coordinate? The focus is on how to scale this to a large number of places while keeping response time to within acceptable user expectations
Given a list of words, group anagrams.
Find all 3 items that sum to 0 in an array.
Write a function that calculates input strings with operators +,-,*,/ eg. “5+5*6″ should output 35
Printing the nodes of a linked list in reverse
Finding the longest palindrome in a given string
Finding maximum subarray sum (similar to Kadane’s Algorithm) with the constraint that two numbers in the array that form the max sum cannot be next to each other
How do you use Facebook app and what are the problems with it? How would you fix it?
Design a Facebook travel app
designing a system to do spam detection work and describing it in a huge flowchart, as might be done in an early but detailed product planning session. Be prepared to think on large scales.
Write a palindrome-checking function
Print a tree, level by level.
Write all solutions for a^3+b^3 = c^3 + d^3, where a, b, c, d lie between [0, 10^5]
Print a list in reverse
Compute maximum profit for buying selling a stock given an array of prices for n days.
Check if two binary trees are Isomorphic
How would you come to an agreement if you and another senior level engineer couldn’t agree on a technical design?
Write a function that takes 2 arguments: a binary tree and an integer n, it should return the n-th element in the inorder traversal of the binary tree.
Add up two big integers represented in arrays.
Design a system to support Facebook status update.
Design the recommendation system for search keywords
Given 2 very large numbers, each of which is so large it can only be represented as an array of integers, write a function to multiply them.
Write a function to display a JSON string in pretty format.
Write a function to check if polygon is simple based on given list of points
Function to compute the number of ways to climb a flight of n steps. Taking 1, 2, or 3 steps at a time. Do it in Linear time and constant space. Example:
n = 3.
1 1 1
1 2
2 1
3
Ans = 4
Interweave a linked list. Do it in Linear time and constant space.
Input: A->B->C->D->E
Output: A->E->B->D->C
Given a dictionary based simple password, create all possible (special character) passwords based on a provided mapping.
Input: face
Map: {a -> @, 4, A}
Output: f@ce, f4ce, fAce
Get numeric number out of a roman string, linear time
Given: mapping I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
Input/Output:
II = 2, III = 3, IV = 4
VI, VII, VIII
IX = 9
XL = 40,
XLIX = 49
Merge ‘k’ sorted arrays, each array may have max ‘n’ elements
What would you change in Facebook?
Given a sorted array, write a program to decide if two elements sum up to a third.
Determine the 10 most frequent words given a terabyte of strings

We know a string is Palindrome if it is the same reading from both sides. Now we define the following string also Palindrome: 

A man, a plan, a canal, Panama! 

Write a code that returns if an string is palindrome and it should return true for above input. (Without directly saying, I should conclude that I have to only consider alphanumerical characters in a string). In addition, we assume the string is very long and we can not keep a copy of this string or even a copy of preprocessed version of this string. Therefore the result should be returned with the first sweep of the string.