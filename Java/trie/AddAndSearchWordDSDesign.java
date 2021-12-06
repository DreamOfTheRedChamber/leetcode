package trie;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
 * */

public class AddAndSearchWordDSDesign 
{	
	@Test
	public void test()
	{
		AddAndSearchWordDSDesign object = new AddAndSearchWordDSDesign();
		object.addWord( "a" );
		assertTrue( object.search( "." ) );
	}
	
	private TrieNode root = new TrieNode('0');
	
    // Adds a word into the data structure.
    public void addWord( String word )
    {
    	if ( word == null || word.length() == 0 )
    	{
    		return ;
    	}
    	TrieNode curr = root;
    	for ( Character ch : word.toCharArray() )
    	{
    		curr.children.putIfAbsent( ch, new TrieNode( ch ) );
    		curr = curr.children.get( ch );
    	}
    	curr.isLeaf = true;
    }
    
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search( String word )
    {
    	if ( word == null || word.length() == 0 )
    	{
    		return false;
    	}
    	return search( word, 0, root );
    } 
    
    private boolean search( String word, int index, TrieNode root )
    {
    	if ( root == null )
    	{
    		return false;
    	}
    	else if ( index == word.length() )
    	{
    		return root.isLeaf;
    	}
    	else if ( word.charAt( index ) != '.' )
    	{
			return search( word, index + 1, root.children.get( word.charAt( index ) ) );    		
    	}
    	else
    	{
    		for ( TrieNode child : root.children.values() )
    		{
    			if ( search( word, index + 1, child ) )
    			{
    				return true;
    			}    					
    		}
    		return false;
    	}
    }
        
    private class TrieNode
    {
    	public final int CHARSET_SIZE = 26;
    	public char val;
    	public Map<Character, TrieNode> children;    	
    	public boolean isLeaf;
    	public TrieNode( char val )
    	{
    		this.val = val;
    		children = new HashMap<>( CHARSET_SIZE );
    	}    	
    }    
}