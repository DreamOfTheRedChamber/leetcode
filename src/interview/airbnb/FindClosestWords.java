package interview.airbnb;

import java.util.List;

/**
rd list 和一个target word，要求输出在word list 里跟target 
word的edit distance 相差不大于k的所有words。我写了一个基于edit distance的解
法(见下面)，程序是要从头到尾都要写，包括main函数和test数据。写完后他问有没有
更好的解法，我说可以用trie，但是我不觉得我能在剩余时间里写得出来基于trie的解
法，就大致说了一下我认为的思路。在此也求大牛给一个基于trie解法的code。
link: http://www.mitbbs.com/article_t/JobHunting/32692817.html 

Question:
Given a list of word and a target word, output all the words for each the edit distance with the target no greater than k.

e.g. [abc, abd, abcd, adc], target "ac", k = 1,

output = [abc, adc]

 */

public class FindClosestWords
{

	public List<String> FindClosestWords( List<String> words, String targetWord, int distance )
	{
	}

}
