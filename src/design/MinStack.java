package design;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> values;
    
    // the min stack value from top to bottom
    private Stack<Integer> minValues;
    
    /** initialize your data structure here. */
    public MinStack() {
        values = new Stack<>();
        minValues = new Stack<>();
    }
    
    public void push(int x) {
        values.push( x );
        if ( minValues.isEmpty() )
        {
            minValues.push( x );
        }
        else
        {
            if ( minValues.peek() < x )
            {
                minValues.push( minValues.peek() );
            }
            else
            {
                minValues.push( x );
            }
        }
    }
    
    public void pop() 
    {
        minValues.pop();
        values.pop();
    }
    
    public int top() 
    {
        return values.peek();
    }
    
    public int getMin() 
    {
        return minValues.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
