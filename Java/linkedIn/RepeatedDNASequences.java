package linkedIn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". 
When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return: ["AAAAACCCCC", "CCCCCAAAAA"].


要升序打印所有不同的长度为10的序列)
还要写dfs, 带间距输出
follow up 重复元素要允许存在
 * */

public class RepeatedDNASequences
{
    public List<String> findRepeatedDnaSequences( String s ) 
    {
    	List<String> result = new ArrayList<>();
    	if ( s == null || s.length () < 10 )
    	{
    		return result;
    	}
    	
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	// calculate initial hashcode
    	int hashCode = 0;
    	int base = 1;
    	for ( int i = 0; i < 10; i++ )
    	{
    		hashCode += getCode( s.charAt ( i ) ) * base;
    		base *= 5;
    	}
    	
    	map.put ( hashCode, 1 );
    	for ( int i = 10; i < s.length (); i++ )
    	{
    		hashCode = hashCode / 5 + getCode( s.charAt ( i ) ) * base;
    		if ( !map.containsKey ( hashCode ) )
    		{
    			map.put ( hashCode, 1 );
    		}
    		else if ( map.get ( hashCode ) == 1 )
    		{
    			result.add ( s.substring ( i - 9, i + 1 ) );
    			map.put ( hashCode, 2 );
    		}
    	}
    	return result;
    }
    
    private int getCode( char c )
    {
    	switch ( c )
    	{
    		case 'A': return 1;
    		case 'C': return 2;
    		case 'G': return 3;
    		case 'T': return 4;
    		default: return 0;
    	}
    }    
}
