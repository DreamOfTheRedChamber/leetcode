import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

import sys

def decToBin(input: str) -> str:
    result = ""
    decimal = int(input)
    while decimal != 0:
        residual = str(decimal % 2)
        result += residual
        decimal = decimal // 2

    return result[::-1]

def decToBinEightBits(input: str) -> str:
    result = ""
    decimal = int(input)
    for i in range(8):
        residual = str(decimal % 2)
        result += residual
        decimal = decimal // 2

    return result[::-1]

def binToDec(input: str) -> str:
    result = 0
    for i in range(len(input)):
        result = int(input[i]) + result * 2
    return str(result)

# ipAddresses = list(map(int, input().strip().split('.')))
# decimal = int(input().strip())
ipAddresses = [10, 0, 3, 193]
decimal = 167969729

# convert each ip address range to 8-bit binary string, and concatenate
binStr = ""
for i in range(len(ipAddresses)):
    binStr += decToBinEightBits(ipAddresses[i])

# convert the binary string to decimal
print(binToDec(binStr))

# convert the decimal to a binary string
binStr = decToBin(str(decimal))
while len(binStr) < 32:
    binStr = '0' + binStr

# for each 8 binary string bit from left to right, convert to decimal
addresses = list(map(binToDec, [binStr[0:8], binStr[8:16], binStr[16:24], binStr[24:32]]))

result = '.'.join(addresses)
print(result)

# input
# 10.0.3.193
# 167969729

# output
# 167773121
# 10.3.3.193
