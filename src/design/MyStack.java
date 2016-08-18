package design;

import java.util.LinkedList;
import java.util.Queue;

class MyStack 
{
	private Queue<Integer> queueForPush = new LinkedList<>();
	private Queue<Integer> queueForPop = new LinkedList<>();
	
    // Push element x onto stack.
    public void push(int x) 
    {
    	queueForPush.offer( x );
    }

    // Removes the element on top of the stack.
    public void pop() 
    {
        // dequeue elem from queueForPush and enqueue in queueForPop
    	while ( queueForPush.size() > 1 )
    	{
    		queueForPop.offer( queueForPush.poll() );
    	}
    	
    	// dequeue elem from queueForPop and enqueue in queueForPush
    	while ( !queueForPop.isEmpty() )
    	{
    		queueForPush.offer( queueForPop.poll() );
    	}    	
    }

    // Get the top element.
    public int top() 
    {
        // dequeue elem from queueForPush and enqueue in queueForPop
    	int lastNumber = 0;
    	while ( !queueForPush.isEmpty() )
    	{
    		lastNumber = queueForPush.poll();
    		queueForPop.offer( lastNumber );
    	}
    	
    	// dequeue elem from queueForPop and enqueue in queueForPush
    	while ( !queueForPop.isEmpty() )
    	{
    		queueForPush.offer( queueForPop.poll() );
    	}
    	
    	return lastNumber;        
    }

    // Return whether the stack is empty.
    public boolean empty() 
    {
        return queueForPush.isEmpty();
    }
}