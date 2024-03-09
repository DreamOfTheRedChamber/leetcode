from typing import List

def isMaskValid(input: List[int]) -> bool:
    for seg in input:
        if not 0 <= seg < 256:
            return False

    maskBin = decToBin(input)
    flag = False
    for char in maskBin:
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
        segStr = str(bin(seg)).replace("0b", "")
        if len(segStr) < 8:
            segStr = "0" * (8 - len(segStr)) + segStr
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

def calculate(mask: str, ip1: str, ip2: str) -> int:
    mask = list(map(int, mask.split('.')))
    ip1 = list(map(int, ip1.split('.')))
    ip2 = list(map(int, ip2.split('.')))

    maskBin = decToBin(mask)
    ip1Bin = decToBin(ip1)
    ip2Bin = decToBin(ip2)

    if not isMaskValid(mask) or not isIpValid(ip1) or not isIpValid(ip2):
        return 1
    else:
        result1 = binAnd(maskBin, ip1Bin)
        result2 = binAnd(maskBin, ip2Bin)
        if result1 == result2:
            return 0
        else:
            return 2

"""
mask = input().strip()
ip1 = input().strip()
ip2 = input().strip()

"""

mask = "255.255.255.0"
ip1 = "192.168.224.256"
ip2 = "192.168.10.4"
print(calculate(mask, ip1, ip2)) # 1

mask = "255.0.0.0"
ip1 = "193.194.202.15"
ip2 = "232.43.7.59"
print(calculate(mask, ip1, ip2)) # 2

mask = "255.255.255.0"
ip1 = "192.168.0.254"
ip2 = "192.168.0.1"
print(calculate(mask, ip1, ip2)) # 0

mask = "255.0.0.0"
ip1 = "92.24.244.54"
ip2 = "146.46.253.71"
print(calculate(mask, ip1, ip2)) # 2

mask = "-255.0.0.0"
ip1 = "119.70.215.88"
ip2 = "227.120.96.170"
print(calculate(mask, ip1, ip2)) # 1

mask = "255.256.0.0"
ip1 = "130.32.67.107"
ip2 = "143.32.132.184"
print(calculate(mask, ip1, ip2)) # 1
