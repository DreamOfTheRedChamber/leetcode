package trie;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Trie 
{
	
	class TrieNode 
	{
	 public Map<Character, TrieNode> children;
	 public boolean isLeaf;
	 public char val;
	 
	 // Initialize your data structure here.
	 public TrieNode() 
	 {
	  children = new HashMap<>();
	 }
	 
	 public TrieNode( char val )
	 {
	  this();
	  this.val = val;
	 }
	}
	
 private TrieNode root;

 public Trie() 
 {
  root = new TrieNode();
 }

 // Inserts a word into the trie.
 public void insert( String word )
 {
 	TrieNode currNode = root;
 	for ( int i = 0; i < word.length(); i++ )
 	{
 		currNode.children.putIfAbsent( word.charAt( i ), new TrieNode( word.charAt( i ) ) );
 		currNode = currNode.children.get( word.charAt( i ) );
 	}
 	currNode.isLeaf = true;
 }

 public boolean searchIterative( String word )
 {
 	TrieNode currNode = root;
 	for ( int i = 0; i < word.length(); i++ )
 	{
 		currNode = currNode.children.get( word.charAt( i ) );
 		if ( currNode == null )
 		{
 			return false;
 		}
 	}
 	return currNode.isLeaf;
 }
  
 public boolean startWithIterative( String word )
 {
 	TrieNode currNode = root;
 	for ( int i = 0; i < word.length(); i++ )
 	{
 		currNode = currNode.children.get( word.charAt( i ) );
 		if ( currNode == null )
 		{
 			return false;
 		}
 	}
 	return true;
 }
 
 // Returns if the word is in the trie.
 public boolean search( String word )
 {
  if ( root == null )
  {
   throw new IllegalStateException( "" );
  }
  return search( word, 0, root );
 }

 private boolean search( String word, int wordPos, TrieNode currNode )
 {
 	if ( currNode == null )
 	{
 		return false;
 	}
 	else if ( wordPos == word.length() )
 	{
 		return currNode.isLeaf;
 	}
 	else
 	{
 		return search( word, wordPos + 1, currNode.children.get( word.charAt( wordPos ) ) );
 	}
 }

 // Returns if there is any word in the trie
 // that starts with the given prefix.
 public boolean startsWith( String prefix )
 {
 	return startsWith( prefix, 0, root );
 }
 
 private boolean startsWith( String prefix, int prefixPos, TrieNode currNode )
 {
 	if ( currNode == null )
 	{
 		return false;
 	}
 	else if ( prefixPos == prefix.length() )
 	{
 		return true;
 	}
 	else
 	{
 		return startsWith( prefix, prefixPos + 1, currNode.children.get( prefix.charAt( prefixPos ) ) );
 	}
 }

 @Test
 public void test()
 {
 	Trie trie = new Trie();
 	trie.insert( "ab" );
 	// assertTrue( !trie.search( "a" ) );
 	assertTrue( trie.startsWith( "a" ) );
 }
}
