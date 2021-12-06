package queue;

import java.util.Stack;

class MyQueue 
{
 Stack<Integer> stackForPush = new Stack<>();
 Stack<Integer> stackForPop = new Stack<>();
 
 // Push element x to the back of queue.
 public void push(int x) 
 {
  while ( !stackForPop.isEmpty() )
  {
   stackForPush.push( stackForPop.pop() );
  }
  stackForPush.push( x );
 }

 // Removes the element from in front of queue.
 public void pop() 
 {
  while ( !stackForPush.isEmpty() )
  {
   stackForPop.push( stackForPush.pop() );
  }
  stackForPop.pop();
 }

 // Get the front element.
 public int peek() 
 {
  while ( !stackForPush.isEmpty() )
  {
   stackForPop.push( stackForPush.pop() );
  }
  return stackForPop.peek();
 }

 // Return whether the queue is empty.
 public boolean empty() 
 {
  return stackForPush.isEmpty() && stackForPop.isEmpty();  
 }
}
