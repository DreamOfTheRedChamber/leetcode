# Arrangement with Stride

[767.Reorganize-String](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/767.Reorganize-String) \(M+\)  
[1054.Distant-Barcodes](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1054.Distant-Barcodes) \(M+\)  
[358.Rearrange-String-k-Distance-Apart](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/358.Rearrange-String-k-Distance-Apart) \(H-\)  
[621.Task-Scheduler](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/621.Task-Scheduler) \(H-\)  
[984.String-Without-AAA-or-BBB](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/984.String-Without-AAA-or-BBB) \(M+\)  
[1405.Longest-Happy-String](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1405.Longest-Happy-String) \(H-\)  

* [1953.Maximum-Number-of-Weeks-for-Which-You-Can-Work](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/1953.Maximum-Number-of-Weeks-for-Which-You-Can-Work) \(M+\)
  * My original ideas: 
    1. Put items inside PQ, each time take out two different items from heap. Decrement and then put back in PQ. Since complexity O(10^9 * 10^5) = O(10^14)
    1. Decrement is too small step in 1. Minus the biggest with the second biggest element and then put back in PQ. However, this solution does not work because it is incorrect in some cases
  * Read the answer: 
    * The only exceptional case where not all milestones could be finished is when the biggest is too big. 
    * So the problem reduces to an edge case handling math problem...... Totally unexpected.