package facebook.medium;

/**
 * Contact Dedup, 输入是这样的:数字是用户，字母是邮箱，有很多人有多个邮箱，找出相同的用户
  1- {x,y,z},  
  2-{x} 
  3-{a,b}
  4-{y, z}
  5-{b}
  6-{m}
  7-{t,b}
这样输出就是 [1,2,4,7] [3,5] [6] 总共有三个用户。. 

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
 */

public class FindSameUser
{
}
