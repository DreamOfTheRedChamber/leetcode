package design;

import java.util.Iterator;
import java.util.List;

public class ZigzagIterator 
{
	private boolean isEven;
	private Iterator<Integer> v1Iterator;
	private Iterator<Integer> v2Iterator;
	
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) 
    {
    	if ( v1 == null 
    			|| v2 == null )
    	{
    		throw new NullPointerException("");
    	}
    	isEven = true;
    	v1Iterator = v1.iterator( );
    	v2Iterator = v2.iterator( );
    }

    public int next() 
    {
    	if ( isEven )
    	{
    		isEven = false;
    		if ( v1Iterator.hasNext( ) )
    		{
    			return v1Iterator.next( );
    		}
    		else
    		{
    			return v2Iterator.next( );
    		}
    	}
    	else
    	{
    		isEven = true;
    		if ( v2Iterator.hasNext( ) )
    		{
    			return v1Iterator.next( );
    		}
    		else
    		{
    			return v1Iterator.next( );
    		}
    	}
    }

    public boolean hasNext() 
    {
        return v1Iterator.hasNext( ) 
        		|| v2Iterator.hasNext( );
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */