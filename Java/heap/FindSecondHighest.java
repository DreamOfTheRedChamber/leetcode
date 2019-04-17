package heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindSecondHighest 
{
    public static void main( String[] args )
    {
        System.out.println("Hello world");
        System.out.println( findSecond("aabbbcdee") );
    }       
    
    public static List<Character> findSecond( String input )
    {
        if ( input == null )
        {
            throw new IllegalArgumentException("not exist");
        }
        
        Map<Character, Integer> histogram = new HashMap<>();
        for ( char ch : input.toCharArray() )
        {
            histogram.put( ch, 1 + histogram.getOrDefault( ch, 0 ) );
        }
        
        Queue<Map.Entry<Character, Integer>> maxQueue = new PriorityQueue<>( ( o1, o2 ) -> o2.getValue() - o1.getValue() );
        maxQueue.addAll( histogram.entrySet() );
        
        if ( maxQueue.size() < 2 ) 
        {
            return new ArrayList<>();
        }
        
        Map.Entry<Character, Integer> pair = maxQueue.poll( );
        char firstElem = pair.getKey();
        int firstElemFreq = pair.getValue();
        while ( maxQueue.size() > 0 && maxQueue.peek().getValue() == firstElemFreq )
        {
            maxQueue.poll();
        }
        if ( maxQueue.size() == 0 )
        {
            return new ArrayList<>();
        }
        
        List<Character> result = new ArrayList<>();
        pair = maxQueue.poll( );
        char secondElem = pair.getKey();
        int secondElemFreq = pair.getValue();
        result.add( secondElem );
        while ( maxQueue.size() > 0 && maxQueue.peek().getValue() == secondElemFreq )
        {
            result.add( maxQueue.poll().getKey() );            
        }
        return result;
    }
}
