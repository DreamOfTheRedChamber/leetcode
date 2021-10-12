- [Bit Manipulation](#bit-manipulation)
  - [Common tasks](#common-tasks)
  - [XOR](#xor)
  - [Bit Mask](#bit-mask)

# [Bit Manipulation](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation)

[137.Single-Number-II](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/137.Single-Number-II) \(H-\)  
[260.Single-Number-III](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/260.Single-Number-III) \(H\)  
371.Sum-of-Two-Integers \(H\)  
[318.Maximum-Product-of-Word-Lengths](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/318.Maximum-Product-of-Word-Lengths) \(M+\)  
342.Power-of-Four \(H\)  
[957.Prison-Cells-After-N-Days](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/957.Prison-Cells-After-N-Days) \(H\)  
1461.Check-If-a-String-Contains-All-Binary-Codes-of-Size-K \(TBD\)  
[1521.Find-a-Value-of-a-Mysterious-Function-Closest-to-Target](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1521.Find-a-Value-of-a-Mysterious-Function-Closest-to-Target) \(H-\)

## Common tasks

* get bit, set bit, clear bit and update bit

```java
boolean getBit( int num, int i )
{
  return ((num & (1 << i)) != 0 );
}

int setBit( int num, int i ) 
{ 
  return num | (1 << i); 
}

int clearBit( int num, int i ) 
{ 
  int mask = ~(1 << i); 
  return num & mask; 
}

// clear all bits from the most significant bit through i (inclusive) 
int clearBitsMSBthroughI( int num, int i ) 
{ 
  int mask = (1 << i) - 1; 
  return num & mask; 
}

// clear all bits from i (inclusive) through 0 
int clearBitsIthrough0( int num, int i ) 
{ 
  int mask = ~(-1 >>> (31 - i)); 
  return num & mask; 
}

// set the ith bit to a value v 
int updateBit(int num, int i, boolean bitIs1) 
{ 
  int value = bitIs1 ? 1 : 0; 
  int mask = ~(1 << i); 
  
  return (num & mask) | (value << i); 
}

```



## XOR

[136.Single-Number](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/136.Single-Number) \(M\)  
[268.Missing-Number](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/268.Missing-Number) \(H-\)  
[1310.XOR-Queries-of-a-Subarray](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1310.XOR-Queries-of-a-Subarray) \(M\)  
[1442.Count-Triplets-That-Can-Form-Two-Arrays-of-Equal-XOR](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1442.Count-Triplets-That-Can-Form-Two-Arrays-of-Equal-XOR) \(M+\)  
[1506.Find-Root-of-N-Ary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1506.Find-Root-of-N-Ary-Tree) \(M+\)  
[1734.Decode-XORed-Permutation](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1734.Decode-XORed-Permutation) \(M+\)  
[1738.Find-Kth-Largest-XOR-Coordinate-Value](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1738.Find-Kth-Largest-XOR-Coordinate-Value) \(M+\)  
[1835.Find-XOR-Sum-of-All-Pairs-Bitwise-AND](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1835.Find-XOR-Sum-of-All-Pairs-Bitwise-AND) \(M\)

## Bit Mask

[1239.Maximum-Length-of-a-Concatenated-String-with-Unique-Characters](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1239.Maximum-Length-of-a-Concatenated-String-with-Unique-Characters) \(M+\)  
[1284.Minimum-Number-of-Flips-to-Convert-Binary-Matrix-to-Zero-Matrix](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1284.Minimum-Number-of-Flips-to-Convert-Binary-Matrix-to-Zero-Matrix) \(M+\)  
[1452.People-Whose-List-of-Favorite-Companies-Is-Not-a-Subset-of-Another-List](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1452.People-Whose-List-of-Favorite-Companies-Is-Not-a-Subset-of-Another-List) \(H-\)  
[1601.Maximum-Number-of-Achievable-Transfer-Requests](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1601.Maximum-Number-of-Achievable-Transfer-Requests) \(H-\)  
[1755.Closest-Subsequence-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1755.Closest-Subsequence-Sum) \(H\)  
[1774.Closest-Dessert-Cost](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1774.Closest-Dessert-Cost) \(M\)  
[2002.Maximum-Product-of-the-Length-of-Two-Palindromic-Subsequences](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/2002.Maximum-Product-of-the-Length-of-Two-Palindromic-Subsequences)
