package iterator;
import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> 
{

	private Integer peekedVal;
	private boolean isPeeked;
	private Iterator<Integer> iterator;
	
	public PeekingIterator(Iterator<Integer> iterator) 
	{
	    // initialize any member here.
		this.iterator = iterator;
		isPeeked = false;
		peekedVal = null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() 
	{
		if ( !isPeeked )
		{
			peekedVal = iterator.next( );
		}
		return peekedVal;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() 
	{
		if ( isPeeked )
		{
			isPeeked = false;
			return peekedVal;
		}
		else
		{
			return iterator.next( );
		}
	}

	@Override
	public boolean hasNext() 
	{
	    return iterator.hasNext( ) || isPeeked;
	}
}