package interview.airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 给了以下一些输入数据，要求将以下行分页显示，每页12行，其中每行已经按score排好序，分页显示的时候如果有相同host id的行，则将后面同host id的行移到下一页。

[

"host_id,listing_id,score,city",

"1,28,300.1,SanFrancisco",

"4,5,209.1,SanFrancisco",

"20,7,208.1,SanFrancisco",

"23,8,207.1,SanFrancisco",

"16,10,206.1,Oakland",

"1,16,205.1,SanFrancisco",

"6,29,204.1,SanFrancisco",

"7,20,203.1,SanFrancisco",

"8,21,202.1,SanFrancisco",

"2,18,201.1,SanFrancisco",

"2,30,200.1,SanFrancisco",

"15,27,109.1,Oakland",

"10,13,108.1,Oakland",

"11,26,107.1,Oakland",

"12,9,106.1,Oakland",

"13,1,105.1,Oakland",

"22,17,104.1,Oakland",

"1,2,103.1,Oakland",

"28,24,102.1,Oakland",

"18,14,11.1,SanJose",

"6,25,10.1,Oakland",

"19,15,9.1,SanJose",

"3,19,8.1,SanJose",

"3,11,7.1,Oakland",

"27,12,6.1,Oakland",

"1,3,5.1,Oakland",

"25,4,4.1,SanJose",

"5,6,3.1,SanJose",

"29,22,2.1,SanJose",

"30,23,1.1,SanJose"

]
 */

public class RearrangePages
{
	private final static int NUM_PER_PAGE = 12;
	
	public Map<Integer, List<String>> arrangeRentalSources( String[] sources )
	{		
		if ( sources.length <= 1 )
		{
			return new HashMap<>();
		}
		
		// calc num of pages
		int totalNumRentals = sources.length - 1;
		int numPages = totalNumRentals / NUM_PER_PAGE; 

		Map<Integer, List<String>> outputPages = new HashMap<>();
		TreeSet<Integer> availableRental = new TreeSet<>();		
		for ( int i = 1; i < sources.length; i++ )
		{
			availableRental.add( i );
		}
		
		for ( int i = 0; i < numPages; i++ )
		{
			List<String> onePage = new ArrayList<>();
			Set<String> onePageSet = new HashSet<>();
			
			// take rentals with unique hostid from unusedRentals
			Iterator<Integer> iterator = availableRental.iterator( );
			while ( iterator.hasNext( ) 
					&& onePage.size( ) < NUM_PER_PAGE )
			{
				int sourceId = iterator.next( );
				String hostId =  sources[sourceId].split( "," )[0];
				if ( !onePageSet.contains( hostId ) )
				{
					onePage.add( sources[sourceId] );
					onePageSet.add( hostId );
					iterator.remove( );
				}
			}
			
			// fill in with highest score rentals if cannot find more
			iterator = availableRental.iterator( );
			while ( iterator.hasNext( ) && onePage.size( ) < NUM_PER_PAGE )
			{
				int sourceId = iterator.next( );
				onePage.add( sources[sourceId] );
				iterator.remove( );
			}
			
			// add to result
			outputPages.put( outputPages.size( ) + 1, onePage );
		}
		
		// if there are redundant results, add to the last map
		if ( availableRental.size() != 0 )
		{
			List<String> onePage = new ArrayList<>();
			for ( Integer sourceId : availableRental )
			{
				onePage.add( sources[sourceId] );
			}
			outputPages.put( outputPages.size( ) + 1, onePage );
		}
		
		return outputPages;
	}
}
