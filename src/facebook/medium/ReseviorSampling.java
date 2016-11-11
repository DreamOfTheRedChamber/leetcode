package facebook.medium;

/*
reservior sampling的题目
windows里面的扫雷，给一个h,w和m. 生成一个高度h，宽度w，总共m颗雷的矩阵。要求m颗雷随机分布。

第一个想法是把雷都放在前m个位置，从m+1的位置开始产生一个index小于m+1的位置，然后交换雷的位置。这一问写的磕磕绊绊，然后结果居然swap function 写错了，有个地方写太快把i写成了j。被指出来了之后很尴尬。

然后小哥又问了运行时间。说了是O(hw)。然后问能不能在O(m)时间内搞定。才想起来正确的reservior sampling的写法。

 * */

public class ReseviorSampling {

}
