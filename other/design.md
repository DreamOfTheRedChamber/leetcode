- [design](#design)
  - [Cache - [TODO]](#cache---todo)

# design
[432.All-O-one-Data-Structure](https://github.com/wisdompeak/LeetCode/tree/master/Design/432.All-O-one-Data-Structure) (H)\
[380.Insert-Delete-GetRandom-O(1)](https://github.com/wisdompeak/LeetCode/tree/master/Design/380.Insert-Delete-GetRandom-O-1/) (M+)\
[381.Insert-Delete-GetRandom-O1-Duplicates-allowed](https://github.com/wisdompeak/LeetCode/tree/master/Design/381.Insert-Delete-GetRandom-O1-Duplicates-allowed) (H-)\
[716.Max-Stack](https://github.com/wisdompeak/LeetCode/tree/master/Design/716.Max-Stack) (M+)\
[355.Design-Twitter](https://github.com/wisdompeak/LeetCode/tree/master/Design/355.Design-Twitter) (H)\
[535.Encode-and-Decode-TinyURL](https://github.com/wisdompeak/LeetCode/tree/master/Design/535.Encode-and-Decode-TinyURL) (M)\
[631.Design-Excel-Sum-Formula](https://github.com/wisdompeak/LeetCode/tree/master/Design/631.Design-Excel-Sum-Formula) (H)\
[642.Design-Search-Autocomplete-System](https://github.com/wisdompeak/LeetCode/tree/master/Design/642.Design-Search-Autocomplete-System) (M+)\
[895.Maximum-Frequency-Stack](https://github.com/wisdompeak/LeetCode/tree/master/Design/895.Maximum-Frequency-Stack) (H)\
[1146.Snapshot-Array](https://github.com/wisdompeak/LeetCode/tree/master/Design/1146.Snapshot-Array) (H)\
[1172.Dinner-Plate-Stacks](https://github.com/wisdompeak/LeetCode/tree/master/Design/1172.Dinner-Plate-Stacks) (H)\
[1381.Design-a-Stack-With-Increment-Operation](https://github.com/wisdompeak/LeetCode/tree/master/Design/1381.Design-a-Stack-With-Increment-Operation) (H-)\
[1352.Product-of-the-Last-K-Numbers](https://github.com/wisdompeak/LeetCode/tree/master/Design/1352.Product-of-the-Last-K-Numbers) (M+)\
[1418.Display-Table-of-Food-Orders-in-a-Restaurant](https://github.com/wisdompeak/LeetCode/tree/master/Design/1418.Display-Table-of-Food-Orders-in-a-Restaurant) (H-)\
[1622.Fancy-Sequence](https://github.com/wisdompeak/LeetCode/tree/master/Design/1622.Fancy-Sequence) (H+)

## Cache - [TODO]
* [146.LRU-Cache](https://github.com/wisdompeak/LeetCode/tree/master/Design/146.LRU-Cache) (H-)\
  * Brute force: Use a single dictionary impl, key -> (value, timestamp)
 * Get: O(1)
 * Set: O(n) because need to pop out elements if exceed maximum capacity
  * Complexity optimal: Dictionary + LinkedList
 * Get: O(1)
 * Set: O(1)
  * Simplest: Use the Python bulit-in OrderedDict impl (not SortedDict which order items based on keys) https://www.kunxi.org/2014/05/lru-cache-in-python/
 * Get: O(1)
 * Set: O(1)

* [460.LFU Cache](https://github.com/wisdompeak/LeetCode/tree/master/Design/460.LFU-Cache) (H)\
  * Brute force: Use a single dictionary impl, key -> (value, frequency)
 * Get: O(1)
 * Set: O(nlogn)
  * Direct inherit from LRU: Dictionary + linkedlist. Sort linkedlist using bubblesort https://www.kunxi.org/2016/12/lfu-cache-in-python/
 * Get: O(1)
 * Set: O(N) in LRU there is no sorting needed, but in LFU there is. 
  * Dictionary + BST tree:
 * Get: O(1) + log(N) because BST needs to be balanced
 * Set: O(1) + log(N) because BST needs to delete element
  * MY original solution: https://www.kunxi.org/2016/12/lfu-cache-in-python/
 * One dictionary: key -> freq, another dictionary freq -> defaultdict(ordereddict)
 * Get: O(1)
 * Set: O(1)