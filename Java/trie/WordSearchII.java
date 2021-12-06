package trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.

You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?

If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. What kind of data structure could answer such query efficiently?
Does a hash table work? Why or why not? How about a Trie? If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.
 */
public class WordSearchII
{
 public List<String> findWords( char[][] board, String[] words ) 
 {
 	List<String> result = new LinkedList<>();
 	Trie wordsTrie = buildDicTrie( words );
 	
 	boolean[][] isVisited = new boolean[board.length][board[0].length]; 	
 	for ( int i = 0; i < board.length; i++ )
 	{
 		for ( int j = 0; j < board[0].length; j++ )
 		{
 			dfs( result, board, new StringBuilder(), i, j, wordsTrie, isVisited );
 		}
 	}
 	
 	return result.stream( )
 				   .distinct( )
 				   .collect( Collectors.toList( ) );
 }
 
 private void dfs( List<String> result, char[][] board, StringBuilder currPath, int xCoor, int yCoor, Trie trie, boolean[][] isVisited )
 {
 	if ( xCoor < 0 || xCoor >= board.length || yCoor < 0 || yCoor >= board[0].length || isVisited[xCoor][yCoor] )
 	{
 		return;
 	}

		isVisited[xCoor][yCoor] = true;
		currPath.append( board[xCoor][yCoor] );

		if ( !trie.startsWith( currPath.toString() ) )
		{
			return;
		}
		if ( trie.search( currPath.toString() ) )
		{
			result.add( currPath.toString() );
		}

		dfs( result, board, currPath, xCoor + 1, yCoor, trie, isVisited );
		dfs( result, board, currPath, xCoor - 1, yCoor, trie, isVisited );
		dfs( result, board, currPath, xCoor, yCoor + 1, trie, isVisited );
		dfs( result, board, currPath, xCoor, yCoor - 1, trie, isVisited );
		
		currPath.deleteCharAt( currPath.length() - 1 );
		isVisited[xCoor][yCoor] = false;
 }
  
 private Trie buildDicTrie( String[] words )
 {
 	Trie wordsTrie = new Trie();
 	for ( String word : words )
 	{
 		wordsTrie.insert( word );
 	}
 	return wordsTrie;
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
 
	class Trie
	{
		public TrieNode root;
		public Trie()
		{
			root = new TrieNode( '\0' );
		}
		
		public void insert( String word )
		{
			TrieNode currNode = root;
			for ( Character ch : word.toCharArray() )
			{
				currNode.children.putIfAbsent( ch, new TrieNode( ch ) );
				currNode = currNode.children.get( ch );
			}
			currNode.isLeaf = true;
		}
		
		public boolean search( String word )
		{
			return search( word, 0, root );
		}

		private boolean search( String word, int index, TrieNode currNode )
		{
			if ( currNode == null )
			{
				return false;
			}
			else if ( index == word.length() )
			{
				return currNode.isLeaf;
			}
			else
			{
				if ( word.charAt( index ) != currNode.val )
				{
					return false;
				}

				for ( TrieNode child : currNode.children.values() )
				{
					if ( search( word, index + 1, child ) )
					{
						return true;
					}
				}
				return false;
			}
		}
		
		public boolean startsWith( String word )
		{
			return startsWith( word, 0, root );
		}

		private boolean startsWith( String word, int index, TrieNode currNode )
		{
			if ( currNode == null )
			{
				return false;
			}
			else if ( index == word.length() )
			{
				return true;
			}
			else
			{
				if ( word.charAt( index ) != currNode.val )
				{
					return false;
				}

				for ( TrieNode child : currNode.children.values() )
				{
					if ( search( word, index + 1, child ) )
					{
						return true;
					}
				}
				return false;
			}
		}
	}
}
