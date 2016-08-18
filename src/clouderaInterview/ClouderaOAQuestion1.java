package clouderaInterview;

/**
 * 第一题，把一个integer的数字顺序打乱后得到的新的integer叫做该integer的sibling   比如 123和231，132，213，321都是sibling，但和222就不是。
写个程序找一个integer的所有sibling里面最大的。比如上面那个例子返回321.
我的思路就是把integer弄成string 再转成char array，然后sort一下，再转回integer。注意最后的integer可能会溢出，所以查看edge case

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
                }else{. 1point3acres.com/bbs
                        return (int)result;
                }                .1point3acres缃�
        }

 */

public class ClouderaOAQuestion1
{

	public ClouderaOAQuestion1( )
	{
		// TODO Auto-generated constructor stub
	}

}
