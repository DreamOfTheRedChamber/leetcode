package linkedIn;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.


I: 1
V: 5
X: 10
L: 50
C: 100
D: 500
M: 1000

字母可以重复，但不超过三次，当需要超过三次时，用与下一位的组合表示：
I: 1, II: 2, III: 3, IV: 4
C: 100, CC: 200, CCC: 300, CD: 400

s = 3978
3978/1000 = 3: MMM
978>(1000-100), 998/900 = 1: CM
78<(100-10), 78/50 = 1 :L
28<(50-10), 28/10 = XX
8<(100-1), 8/5 = 1: V
3<(5-1), 3/1 = 3: III
ret = MMMCMLXXVIII

所以可以将单个罗马字符扩展成组合形式，来避免需要额外处理类似IX这种特殊情况。
I: 1
IV: 4
V: 5
IX: 9
X: 10
XL: 40
L: 50
XC: 90
C: 100
CD: 400
D: 500
CM: 900
M: 1000
 */

public class IntegerToRoman
{
 public String intToRoman( int num )
 {
 	if ( num <= 0 || num > 3999 )
 	{
 		throw new IllegalArgumentException("");
 	}
 	
 	String[] dictionary = { "M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I" };
 	int[] value = { 1000,900,500,400,100,90,50,40,10,9,5,4,1 };
 	StringBuilder result = new StringBuilder();
 	for ( int i = 0; i < value.length; i++ )
 	{
 		if ( num >= value[i] )
 		{
 			int count = num / value[i];
 			for ( int j = 0; j < count; j++ )
 			{
 				result.append( dictionary[i] );
 			}
 			num -= count * value[i];
 		}
 	}
 	return result.toString();
 }
 
 @Test
 public void test()
 {
 	assertEquals( "M", intToRoman( 1000 ) );
 	assertEquals( "DC", intToRoman( 600 ) );
 	assertEquals( "MMMCMLXXVIII", intToRoman( 3978 ) );
 }
}
