package facebook.medium;

import static org.junit.Assert.assertTrue;

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
		Trie trie = new Trie();
		trie.addWord( "a" );
	}
	
	@Test
	public void test2()
	{
		Trie trie = new Trie();
		trie.addWord( "a" );
		trie.addWord( "a" );
		
		assertTrue( trie.search( "." ) );
		assertTrue( trie.search( "a" ) );
		assertTrue( !trie.search( "aa" ) );
		assertTrue( trie.search( "a" ) );
		assertTrue( !trie.search( ".a" ) );
		assertTrue( !trie.search( "a." ) );		
	}	
	
	@Test
	public void test3()
	{
		Trie trie = new Trie();
		trie.addWord( "at" );
		trie.addWord( "and" );
		trie.addWord( "an" );
		trie.addWord( "add" );
		assertTrue( !trie.search( "a" ) );
		assertTrue( !trie.search( ".at" ) );
		trie.addWord( "bat" );
		assertTrue( trie.search( ".at" ) );
		assertTrue( trie.search( "an." ) );
		assertTrue( !trie.search( "a.d." ) );
		assertTrue( !trie.search( "b." ) );
		assertTrue( trie.search( "a.d" ) );
		assertTrue( !trie.search( "." ) );
	}
	
	private Trie trie = new Trie();
	
    // Adds a word into the data structure.
    public void addWord( String word )
    {
        trie.addWord( word );
    }
    
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search( String word )
    {
        return trie.search( word );
    }    
    
    private class Trie
    {
    	public TrieNode root = new TrieNode( '0' );    		
    	
    	public void addWord( String word )
    	{

    	}
    	
    	public boolean search( String word )
    	{
    		if ( word == null )
    		{
    			return false;
    		}
    		return search( word, root, 0 );
    	}
    }
    
    private class TrieNode
    {
    	public final int CHARSET_SIZE = 26;
    	public char value;
    	public TrieNode[] children;    	
    	public TrieNode( char value )
    	{
    		this.value = value;
    		children = new TrieNode[CHARSET_SIZE];
    	}
    }    
}