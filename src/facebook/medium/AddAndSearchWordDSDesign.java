package facebook.medium;

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
    		if ( word == null )
    		{
    			return;
    		}
    		TrieNode curr = root;
    		for ( char ch : word.toCharArray() )
    		{
    			if ( curr.children[ch - 'a'] != null )
    			{
    				curr = curr.children[ch - 'a'];
    			}
    			else
    			{
    				TrieNode newNode = new TrieNode( ch );
    				curr.children[ch-'a'] = newNode;
    				curr = newNode;
    			}
    		}
    	}
    	
    	public boolean search( String word )
    	{
    		if ( word == null )
    		{
    			return false;
    		}
    		return search( word, root, 0 );
    	}
    	
    	private boolean search( String word, TrieNode root, int index )
    	{
    		if ( index >= word.length() )
    		{
    			return true;
    		}
    		
    		if ( word.charAt( index ) == '.' )
    		{
    			for ( int i = 0; i < root.children.length; i++ )
    			{
    				if ( root.children[i] != null 
    						&& search( word, root.children[i], index + 1 ) )
    				{
    					return true;
    				}
    			}
    			return false;
    		}
    		else
    		{
    			return root.children[word.charAt( index ) - 'a'] == null ? false : true;
    		}
    	}
    }
    
    private class TrieNode
    {
    	public char value;
    	public TrieNode[] children;    	
    	public TrieNode( char value )
    	{
    		this.value = value;
    	}
    }
}