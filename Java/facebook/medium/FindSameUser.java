package facebook.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Contact Dedup, 输入是这样的:数字是用户，字母是邮箱，有很多人有多个邮箱，找出相同的用户
  1- {x,y,z},  
  2-{x} 
  3-{a,b}
  4-{y, z}
  5-{b}
  6-{m}
  7-{t,b}
这样输出就是 [1,2,4,7] [3,5] [6] 总共有三个用户。. 

合并邮件列表（后来才知道也是个面经题）
Given 1 million email list:
list 1: a@a.com, b@b.com
list 2: b@b.com, c@c.com
list 3: e@e.com
list 4: a@a.com
...
Combine lists with identical emails, and output tuples:
(list 1, list 2, list 4) (a@a.com, b@b.com, c@c.com)
(list 3) (e@e.com)


You are given a list of contacts containing name/emails/phone numbers in any order. 
You are required to identify the similar contacts (i.e., same person having many different contacts ) and output the union of similar contacts. For. e.g. check the below list.

[ "Gaurav", "gaurav@gmail.com", "gaurav@gfgQA.com"]
[ "Lucky", "lucky@gmail.com", "+1234567"]
[ "gaurav123", "+5412312", "gaurav123@skype.com"]
[ "gaurav1993", "+5412312", "gaurav@gfgQA.com"]

Thus it is clear that gaurav1993, Gaurav and gaurav123 are the same person.
So we should output:
0 2 3
1

as 0, 2, 3 are contacts of same person and 1 is contact of some other different person.
 */

class Contact
{
	public String name;
	public List<String> emails;
	public Contact( String name )
	{
		this.name = name;
		this.emails = new LinkedList<>();
	}
	public void addEmail( String email )
	{
		emails.add( email );
	}
}

class UnionFind
{
	private int[] father, ranks;
	public UnionFind( int numNodes )
	{
		father = new int[numNodes];
		ranks = new int[numNodes];
		for ( int i = 0; i < numNodes; i++ )
		{
			father[i] = i;
			ranks[i] = 0;
		}
	}

	public int find( int x )
	{
		while ( x != father[x] )
		{
			x = father[x];
		}
		return x;
	}
	
	public void union( int x, int y )
	{
		int xAncestor = find( x );
		int yAncestor = find( y );
		if ( xAncestor == yAncestor )
		{
			return;
		}
		else if ( ranks[xAncestor] < ranks[yAncestor] )
		{
			father[xAncestor] = yAncestor;
		}
		else
		{
			father[yAncestor] = xAncestor;
			if ( ranks[xAncestor] == ranks[yAncestor] )
			{
				ranks[xAncestor]++;
			}
		}
	}
}

public class FindSameUser
{
	public List<List<Contact>> findSameUser( Contact[] input )
	{
		Map<String, List<Integer>> emailToOwner = new HashMap<>();
		for ( int i = 0; i < input.length; i++ )
		{
			for ( String email : input[i].emails )
			{
				emailToOwner.putIfAbsent( email, new ArrayList<>() );
				emailToOwner.get( email ).add( i );
			}
		}
		
		UnionFind uf = new UnionFind( input.length );
		for ( List<Integer> owners : emailToOwner.values() )
		{
			int firstOwner = owners.get( 0 );
			for ( int i = 1; i < owners.size(); i++ )
			{
				uf.union( firstOwner, owners.get( i ) );
			}
		}
		
		Map<Integer, List<Contact>> groups = new HashMap<>();
		for ( int i = 0; i < input.length; i++ )
		{
			int ancestor = uf.find( i );
			groups.putIfAbsent( ancestor, new LinkedList<>() );
			groups.get( ancestor ).add( input[i] );
		}
		return groups.values().stream().collect( Collectors.toList() );
	}
}