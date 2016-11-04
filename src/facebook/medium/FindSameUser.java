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


You are given a list of contacts containing name/emails/phone numbers in any order. You are required to identify the similar contacts (i.e., same person having many different contacts ) and output the union of similar contacts. For. e.g. check the below list.

[ "Gaurav", "gaurav@gmail.com", "gaurav@gfgQA.com"]
[ "Lucky", "lucky@gmail.com", "+1234567"]
[ "gaurav123", "+5412312", "gaurav123@skype.com"]
[ "gaurav1993", "+5412312", "gaurav@gfgQA.com"]

Thus it is clear that gaurav1993, Gaurav and gaurav123 are the same person.
So we should output:
0 2 3
1

as 0, 2, 3 are contacts of same person and 1 is contact of some other different person.
 */

public class FindSameUser
{
}
