package clouderaInterview;

/**
 * 第一题，把一个integer的数字顺�?打乱�?�得到的新的integer�?��?�该integer的sibling   比如 123和231，132，213，321都是sibling，但和222就�?是。
写个程�?找一个integer的所有sibling里�?�最大的。比如上�?�那个例�?返回321.
我的�?路就是把integer弄�?string �?转�?char array，然�?�sort一下，�?转回integer。注�?最�?�的integer�?�能会溢出，所以查看edge case

public static int solution(int N){
                long result=0;
                String s=String.valueOf(N);
                char[] c= s.toCharArray();
                Arrays.sort(c);
                for(int i=c.length-1;i>=0;i--){
                        result=result*10+(int)(c[i]-'0');
                }
                if(result>Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                }else{
                        return (int)result;
                }                
        }
 */

public class ClouderaOAQuestion1
{

	public ClouderaOAQuestion1( )
	{
		// TODO Auto-generated constructor stub
	}

}
