package systemDesign.typeahead;

import java.util.HashMap;

/*
 * Implement a trie with insert, search, and startsWith methods.

 Notice

You may assume that all inputs are consist of lowercase letters a-z.

Have you met this question in a real interview? Yes
Example
insert("lintcode")
search("code")
>>> false
startsWith("lint")
>>> true
startsWith("linterror")
>>> false
insert("linterror")
search("lintcode)
>>> true
startsWith("linterror")
>>> true
 * */

//Version 2: HashMap Version
/*
Your Trie object will be instantiated and called as such:
Trie trie = new Trie();
trie.insert("lintcode");
trie.search("lint"); will return false
trie.startsWith("lint"); will return true
*/
class TrieNode {
 // Initialize your data structure here.
 char c;
 HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
 boolean hasWord;
 
 public TrieNode(){
     
 }
 
 public TrieNode(char c){
     this.c = c;
 }
}

public class Trie {
 private TrieNode root;

 public Trie() {
     root = new TrieNode();
 }

 // Inserts a word into the trie.
 public void insert(String word) {
     TrieNode cur = root;
     HashMap<Character, TrieNode> curChildren = root.children;
     char[] wordArray = word.toCharArray();
     for(int i = 0; i < wordArray.length; i++){
         char wc = wordArray[i];
         if(curChildren.containsKey(wc)){
             cur = curChildren.get(wc);
         } else {
             TrieNode newNode = new TrieNode(wc);
             curChildren.put(wc, newNode);
             cur = newNode;
         }
         curChildren = cur.children;
         if(i == wordArray.length - 1){
             cur.hasWord= true;
         }
     }
 }

 // Returns if the word is in the trie.
 public boolean search(String word) {
     if(searchWordNodePos(word) == null){
         return false;
     } else if(searchWordNodePos(word).hasWord) 
       return true;
       else return false;
 }

 // Returns if there is any word in the trie
 // that starts with the given prefix.
 public boolean startsWith(String prefix) {
     if(searchWordNodePos(prefix) == null){
         return false;
     } else return true;
 }
 
 public TrieNode searchWordNodePos(String s){
     HashMap<Character, TrieNode> children = root.children;
     TrieNode cur = null;
     char[] sArray = s.toCharArray();
     for(int i = 0; i < sArray.length; i++){
         char c = sArray[i];
         if(children.containsKey(c)){
             cur = children.get(c);
             children = cur.children;
         } else{
             return null;
         }
     }
     return cur;
 }
}