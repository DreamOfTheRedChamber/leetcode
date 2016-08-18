package interview.airbnb;

/*Screen

网申一天后，小编收到HR电话，约定第一个电话面试时间。三天后，电面开始。面试官是一个美国人，很利索的自我介绍，然后马上进入Coding。题目是关于如何Parse csv file：举个例子，给定一个CSV文件，格式是 “some_name|some_address|some_phone|some_job”，要求输出Json format “{name:some_name, address:some_addres,phone:some_phone, job:some_job}”。输入内容中有些特殊符号要注意处理，这个面试官会提醒。小编的感觉，这道题目的重点是Bug free code，另外面试者需要在30分钟内完成代码，并且编译运行。最后面试官会用几个Test case来测试面试者的代码是否有问题。因此其实A家的电面难度并不低，应该用准备Onsite的标准对待。

Onsite

由于小编在和HR聊天的时候告知自己的选择窗口比较紧，所以电面当天下午收到Onsite通知。简短截说：A家的Onsite一共有七轮，前五轮每轮四十五分钟，后两轮是三十分钟的culture fit.

第一轮遇到一位亚裔姑娘。主要就是聊天，考察以前做过的项目。面试官会慢慢深入，展开问项目细节和个人贡献。具体的项目回答心得在上篇博客中有详细讨论。由于准备比较充分，所以这轮比较轻松。

第二轮是美国面试官，主要考察系统设计：设计一个distributed cache. 回答这类题目需要对分布式系统有一定了解，小编觉得以下几点是需要讲清楚的：

Distribute策略：当Cache数据量巨大的时候，需要用多个Node来存储Cache。由于Cache本质上是Key-value-pair，那么可以通过对Key进行类似Hash的Sharding可以决定Value需要存储/读取的Node.
Cache策略：基本上就是Pull (on-demand)/Push(regular update)的区别。具体情况要考虑需求的具体情况，比如对与Cache数据实时性的要求，对于Performance要求等，一定程度上也考察面试者的沟通能力。
Failure case以及Scalability的讨论，主要是展示面试者思考问题的全面性。
从第三轮开始，连续三轮Coding interviews: 每轮除去了面试官讨论的时间，大概只有三十分钟做Coding，加之每个解法都需要编译出结果，所以感觉时间比较紧迫。

基于数据结构的算法题：Encode an alien dictionary using a tree and then produce a dictionary using topological traversal. Topological sorting类型，Leetcode中等难度。
算法题：实现Regular expression match，比Leetcode的原题多一两个通配符，但思路想通，做过Leetcode那道题的朋友，写这题难度不大。
DP题，具体题目实在无法记得，印象中是中等难度的Leetcode的DP题，sorry.
这三轮技术面试，总体感觉时间比较紧。小编建议最好与面试无关的问题留到最后，因为有些技术问题会有Follow-up，最好留出足够时间做完所有关卡。

最后的两轮面试比较轻松。和两位Non-technical面试官聊天，很多Behavior questions，主要考察面试者是否适合公司文化。比如，为什么选择Airbnb？ 如何改进Airbnb现有的产品？你最想做的事？给你三分钟，教他一件事？这种类型的问题。最好面试前看看网上关于Airbnb文化相关的讨论，答题尽量贴合的它家的做事风格，一般来说，过关问题不大。

Onsite三点半面完所有七轮，五点左右接到Offer，整个面试体验还是非常不错的。
 * */

public class Question1 {

}
