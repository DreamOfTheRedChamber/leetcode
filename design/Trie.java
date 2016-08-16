class TrieNode 
{
    private final static int CHARSET_SIZE = 26;
    public TrieNode[] children;
    public boolean isLeaf;
    public char val;
    
    // Initialize your data structure here.
    public TrieNode() 
    {
        children = new TrieNode[CHARSET_SIZE];
    }
    
    public TrieNode( char val )
    {
        this();
        this.val = val;
    }
}

public class Trie 
{
    private TrieNode root;

    public Trie() 
    {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) 
    {
        insertRecurse( word, 0, root );
    }
    
    private void insertRecurse( String word, int wordPos, TrieNode currNode )
    {
        if ( wordPos >= word.length() )
        {
            throw new IllegalStateException("");
        }
        
        // go to trieNode correspond to next word char
        int nextNodePos = (int)( word.charAt( wordPos ) - 'a' );
        TrieNode nextNode = currNode.children[nextNodePos];
        if ( nextNode == null )
        {
            nextNode = new TrieNode( word.charAt( wordPos ) );
        }
        
        // handle leaf/internal node
        if ( nextNodePos == word.length() - 1 )
        {
            nextNode.isLeaf = true;
        }
        else
        {
            insertRecurse( word, nextNodePos + 1, nextNode );
        }
    }

    // Returns if the word is in the trie.
    public boolean search( String word )
    {
        if ( root == null )
        {
            throw new IllegalStateException("");
        }
        return searchRecurse( word, 0, root );
    }

    private boolean searchRecurse( String word, int wordPos, TrieNode currNode )
    {
        if ( wordPos >= word.length() )
        {
            throw new IllegalStateException("");
        }
        else if( currNode == null )
        {
            return false;
        }
        else
        {
            int nextNodePos = (int)( word.charAt( wordPos ) - 'a' );
            if ( currNode.children[nextNodePos] == null )
            {
                return false;
            }

            if ( wordPos == word.length() - 1)
            {
                if ( currNode.children[nextNodePos].isLeaf )
                {
                    return true;
                }
                else 
                {
                    return false;
                }
            }
            else
            {
                return searchRecurse( word, wordPos + 1, currNode.children[nextNodePos] );
            }
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) 
    {
        if ( root == null )
        {
            throw new IllegalStateException("");
        }
        return startsWithRecurse( prefix, 0, root );
    }
    
    private boolean startsWithRecurse( String prefix, int prefixPos, TrieNode currNode )
    {
        if ( prefixPos >= prefix.length() )
        {
            throw new IllegalStateException("");
        }
        else
        {
            int nextNodePos = (int)( prefix.charAt( prefixPos ) - 'a' );
            if ( currNode.children[nextNodePos] == null )
            {
                return false;
            }

            if ( prefixPos == prefix.length() - 1 )
            {
                return true;
            }
            else
            {
                return startsWithRecurse( prefix, prefixPos + 1, currNode.children[nextNodePos] );
            }
        }
    }
}
