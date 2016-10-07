package iterator;

import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> 
{
	private Iterator<List<Integer>> rowIterator;
	private Iterator<Integer> colIterator;
	
    public Vector2D(List<List<Integer>> vec2d) 
    {
    	rowIterator = vec2d.iterator( );
    }

    @Override
    public Integer next() 
    {
    	return colIterator.next( );
    }

    @Override
    public boolean hasNext() 
    {
		while ( rowIterator.hasNext( ) 
				&& !colIterator.hasNext( ) )
		{
			colIterator = rowIterator.next( ).iterator( );
		}
		
		return colIterator.hasNext( );
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */