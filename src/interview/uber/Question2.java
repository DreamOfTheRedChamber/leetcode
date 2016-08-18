package interview.uber;

/*
 * 第一轮：系统设计问题 How to design netflix?

这个其实小编也不太了解，就尽量根据自己之前看过的资料开始一步一步给出自己的Solution，然后进行优化。架构上：基本上就是数据层，Service层，前端。因为小编知道Netflix是AWS的忠实用户，所以基本就以AWS为例：数据存储使用s3，配合Relational db / Non sql database；然后是Service layer，功能包括：User authentication，session management，data streaming and other business logic；前台则主要是用户界面。优化包括：如何Cache，如何利用CDN network replicate data close to the users. 因为Netflix的数据大部分是静态数据，很少更新，电影电视剧的内容完全可以Replicate很多份放到Internet的Edge server上。

第二轮：Deep dive personal project.

聊过去的项目，这种类型的面试真的是因人而异，以下是小编对它的理解：Project在技术上要Impressive，如果你能让面试官认可Project的架构设计甚至从你的Project里学到东西，他肯定会希望和你成为同事，这是面试中很重要的一个标准。在日常工作中，每个人都要和组员或者公司其他员工交流沟通很多，如果面试官发现很难和你交流、或者很难理解你的话，过关的几率会大大下降。所以这轮面试的重点就是测试面试者是否有能力进行有效的交流沟通，从面试官的角度，以后愿不愿意Work on something together。

Baozi Tip

因为这类面试通常是自己准备话题，所以可以提前找好朋友多Mock interview几次，这样子可以确保真正面试的时候可以说的有条理，有主有细。

第三轮：Behavior question / Cultural fit面试。

这一轮面试基本和HR Recruiter的那轮差不多，区别就是这次时间更长，想象一下45分钟全是Behavior question，面对面。小编个人觉得这一轮真的就是看前期的准备工作是不是到位：最起码要使用几次面试公司的产品，最好发现一些需要改进的地方，能说清楚产品的优点，大体了解公司的愿景，潜在的客户群体。然后尽量多关注关于公司的报道，记得当时Uber刚刚在纽约Launch delivery service，所以当小编跟面试官提到的时候，可以明显感觉到她是很高兴的。

第四轮：Coding + OO design (Design windows excel)

这个主要是看OO design的功底，其实不难。Follow-up question: In excel, one cell can refer to other cells, if I update one cell, how do you update all the dependent cells？这个问题可以被转化成经典的Topological sort，所以这里就不详细展开啦，如果不知道可以看看算法书，或者关注包子博客之后的总结。

 * */

public class Question2 {

}
