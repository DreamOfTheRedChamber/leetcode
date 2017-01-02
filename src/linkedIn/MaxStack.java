package linkedIn;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
design a max stack that supports all regular stack operations and peekMax popMax in log time

http://wxx5433.github.io/max-stack.html
Generics

*/

public class MaxStack<T>
{
	private LinkedList<T> stack;
	private PriorityQueue<T> maxHeap;

	public MaxStack() 
	{
		stack = new LinkedList<T> ();
		maxHeap = new PriorityQueue<T> ( Collections.reverseOrder () ); // reverse
																			// order
	}

	public void push( T value )
	{
		stack.addLast ( value );
		maxHeap.offer ( value );
	}

	public T pop()
	{
		T num = stack.removeLast ();
		maxHeap.remove ( num );
		return num;
	}

	public T top()
	{
		return stack.peekLast ();
	}

	public T peekMax()
	{
		return maxHeap.peek ();
	}

	public T popMax()
	{
		T num = maxHeap.poll ();
		stack.remove ( num );
		return num;
	}

}