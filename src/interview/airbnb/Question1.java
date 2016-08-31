package interview.airbnb;

/*Screen
Distribute策略：当Cache数据量巨大的时候，需要用多个Node来存储Cache。由于Cache本质上是Key-value-pair，那么可以通过对Key进行类似Hash的Sharding可以决定Value需要存储/读取的Node.
Cache策略：基本上就是Pull (on-demand)/Push(regular update)的区别。具体情况要考虑需求的具体情况，比如对与Cache数据实时性的要求，对于Performance要求等，一定程度上也考察面试者的沟通能力。
Failure case以及Scalability的讨论，主要是展示面试者思考问题的全面性。
从第三轮开始，连续三轮Coding interviews: 每轮除去了面试官讨论的时间，大概只有三十分钟做Coding，加之每个解法都需要编译出结果，所以感觉时间比较紧迫。

基于数据结构的算法题：Encode an alien dictionary using a tree and then produce a dictionary using topological traversal. Topological sorting类型，Leetcode中等难度。
算法题：实现Regular expression match，比Leetcode的原题多一两个通配符，但思路想通，做过Leetcode那道题的朋友，写这题难度不大。
DP题，具体题目实在无法记得，印象中是中等难度的Leetcode的DP题，sorry.
 * */

public class Question1 {

}
