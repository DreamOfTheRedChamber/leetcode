package hashtable;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * 
 */

public class HappyNumber
{

    public boolean isHappy( int n )
    {
    	if ( n < 1 )
    	{
    		throw new IllegalArgumentException("");
    	}
    	
    	Set<Integer> appearedNums = new HashSet<>();
    	appearedNums.add( n );
    	return isHappy( n, appearedNums );
    }
    
    private boolean isHappy( int n, Set<Integer> appearedNums )
    {
    	int squareSum = 0;
    	while ( n != 0 )
    	{
    		squareSum += ( n % 10 ) * ( n % 10 ); 
    		n /= 10;    		
    	}
    	
    	if ( squareSum == 1 )
    	{
    		return true;
    	}
    	else if ( appearedNums.contains( squareSum ) )
    	{
    		return false;
    	}
    	else
    	{
    		appearedNums.add( n );
    		return isHappy( squareSum, appearedNums );
    	}
    }
    
    @Test
    public void test()
    {
//    	assertTrue( isHappy( 1 ) );
//    	assertTrue( isHappy( 19 ) );
    }
}
