package facebook.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 
What is a memory-efficient way to store a vector of integers? Follow-up question: using your proposed data structure, find an algorithm with constant memory usage to calculate the dot product of two vectors.
 
有两个很大的稀疏向量，问怎么存储和算他们的dot product. 只存储非零元素和他的index
，如果压缩后的向量大小为m,n, O(m+n)和O(mlogn)方法都不难想到。他问有没有更好
，提示divide and conquer，我就说先取一个向量的中间元素，然后搜索他在另一个向
量中对应元素的位置，这样就把两个矩阵都分别分为两半。他问复杂度，我说我要算一
下才知道，然后他说他也不知道，不过平均情况应该比前面的好。

sparse vector dot product。follow up: what if the number of nonzero elements of one vector is 10^10 and the other is 10^2, how can you make it faster?. visit 1point3acres.com for more.

补充内容 (2016-10-20 06:53)
1. vector dot product就是 A{a1, a2, a3...} B{b1, b2, b3...} product = a1 * b1 + a2 * b2... an * bn. 
如果vector很稀疏，那么这么算就很浪费，所以第一步优化是只看非0的，记录成一个pair {aindex, aval}

补充内容 (2016-10-20 06:55)
这样当某个index 在两个vector里都非0我们再进行计算。再一步优化是其中一个vector非零很多另一个很少，可以对非零很多的vector pair进行binary search找对应的index

这道题我当时并没有准备到，但是正因为如此，我认为我跟面试官的交流给我加分了不少。面试官首先问我每个vector很大，并不能在内存中存下，该怎么办，我说只需要存下非零的元素和他们的下标就行，
然后询问面试官是否可以用预处理后的这两个vector非零元素的index和value作为输入，面试官同意后快速写完O(M*N)的代码，M和N分别是两个vector的长度。
面试官说这两个输入如果是根据下标排序好的话应该怎么办，我说可以遍历长度较短的那一个，然后用二分搜索的方法在另一个vector中找index相同的元素，相乘加入到结果中，这样的话复杂度就是O(M*logN)。
这时，面试官又问是否可以同时利用两个输入都是排序好这一个特性，我在这个地方有点卡住，但是在白板上写出一个test case，试着用可视化的方法帮助我来进行思考，
同时面试官给了一些提醒，最后写出了O(M + N)的双指针方法,然后问如果有一个向量比另一个长很多怎么办，遍历短的，对长的二分查找。
 */

public class VectorDotProduct
{
	public int calcVectorDotProduct( int[] vector1, int[] vector2 )
	{
		if ( vector1.length != vector2.length )
		{
			throw new IllegalArgumentException();
		}
		if ( vector1 == null || vector2 == null || vector1.length == 0 || vector2.length == 0 )
		{
			return 0;
		}
		
		Map<Integer, Integer> sparseVector1 = new HashMap<>();
		for ( int i = 0; i < vector1.length; i++ )
		{
			if ( vector1[i] != 0 )
			{
				sparseVector1.put( i, vector1[i] );
			}
		}
		
		int product = 0;
		for ( int i = 0; i < vector2.length; i++ )
		{
			if ( vector2[i] != 0 && sparseVector1.containsKey( i ) )
			{
				product += vector2[i] * sparseVector1.get( i );
			}
		}
		return product;
	}	
}
