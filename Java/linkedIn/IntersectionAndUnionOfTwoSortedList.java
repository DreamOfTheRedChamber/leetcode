package linkedIn;

import utility.ListNode;

/*
第二轮，韩国人+中国人shadow，就写了一道题，intersection and union of two list（sorted），注意参数给的是List<Integer> ，不知道实现的话get方法可能是o（n）的。一开始写了个用get的，doubt 我的时间复杂度，我说这个可能是o（n），那可能需要用iterator。考官说对那就写吧，然后秒写，这里楼主就突然傻逼了。这题相当于peeking iterator，双指针（双iterator）遍历两个list时，iter.hasNext()是不能作为跳出循环的依据的，因为有一个元素是缓存起来的，只有当那个缓存的头元素也用完了之后才能跳出循环。所以这个bug卡了十分钟都没查出来，其实非常明显的但就是先入为主觉得这怎么可能错没有注意检查这个边界条件。最后给了个test case我才恍然卧槽，这智商真是坑了坑了。

建议再有这种要在iterator上搞peek的，不要嫌费事，写一个peekiterator的类包装一下原来的iter。. Waral 鍗氬鏈夋洿澶氭枃绔�,
然后时间空间复杂度再问
写完了这个，问union多个list的话怎么办，我说那就merge吧，面试官说不行这个空间复杂度很高。我说那就priorityqueue吧，面试官表示满意，问了下空间时间复杂度。然后继续follow up问那就俩list union，你搞个parallel算法。楼主蒙了一下，想了两分钟，说那就第一个数组分n份，找到pivotal点在第二个数组上二分搜索该元素对应的位置，得到这些位置传给并行算法就可以了吧。面试官说行，问了下空间复杂度（我觉得并没有卵区别，还是和以前一样）。
面试过了大概45分钟（晚打来了6分钟），就直接问问题了。
韩国人和中国小哥都很好，面试过程中韩国人一直都ok ok，让你感觉到你在right track上。看linkedin也都是大神，希望能高抬贵手，当然写一道题还有bug还半天没发现其实表现的挺差的。。。看人品吧. Waral 鍗氬鏈夋洿澶氭枃绔�,

follow up2 是多线程或者多台机器怎么做

然后又问了两个sorted arrays of integers的union。比如[1, 1, 1, 2 ]和[1, 1 , 3]要return [1, 1,1, 2, 3]。我一开始没注意是sorted，用hashMap做了

Leetcode 160. 
Total Accepted: 105573 Total Submissions: 352082 Difficulty: Easy Contributors: Admin
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:    a1 → a2
       ↘
      c1 → c2 → c3
       ↗   
B:  b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

linked list焦点问题，面经里很多，考虑相交不相交，有环无环
1. 无环不相交
2. 无环相交.
3. 有环不相交.
4. 有环相交

 * */

public class IntersectionAndUnionOfTwoSortedList 
{
 public ListNode getIntersectionNode( ListNode headA, ListNode headB ) 
 {
  return null;
 }
}
