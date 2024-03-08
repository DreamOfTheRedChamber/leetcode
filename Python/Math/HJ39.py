from typing import List

def isMaskValid(input: str) -> bool:
    flag = False
    for char in input:
        if char == '0':
            flag = True
        if char == '1' and flag:
            return False

    return True

def isIpValid(input: List[int]) -> bool:
    for seg in input:
        if not 0 <= seg < 256:
            return False

    return True

def decToBin(input: List[int]) -> str:
    binStr = ""
    for seg in input:
        segStr = ''
        while seg != 0:
            residual = seg % 2
            seg = seg // 2
            segStr = segStr + str(residual)
        if len(segStr) < 8:
            segStr = segStr + '0' * (8 - len(segStr))

        binStr = binStr + segStr
    return binStr

def binAnd(ip: str, mask: str) -> str:
    result = ''
    for i in range(len(ip)):
        if int(ip[i]) & int(mask[i]) == 0:
            result = result + '0'
        else:
            result = result + '1'

    return result

mask = list(map(int, input().strip().split('.')))
ip1 = list(map(int, input().strip().split('.')))
ip2 = list(map(int, input().strip().split('.')))

maskBin = decToBin(mask)
ip1Bin = decToBin(ip1)
ip2Bin = decToBin(ip2)

if not isMaskValid(maskBin) or not isIpValid(ip1) or not isIpValid(ip2):
    print(1)

result1 = binAnd(mask, ip1)
result2 = binAnd(mask, ip2)
if result1 == result2:
    print(0)
else:
    print(2)


"""
255.255.255.0
192.168.224.256
192.168.10.4

1

255.0.0.0
193.194.202.15
232.43.7.59

2

255.255.255.0
192.168.0.254
192.168.0.1

0
"""