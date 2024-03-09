import sys

address = input().strip().split('.')
if len(address) != 4:
    print("NO")
else:
    for seg in address:
        if not seg.isdigit() or not 0 <= int(seg) < 256 or (seg[0] == '0' and len(seg) >= 2):
            print("NO")
            quit()
    print("YES")

# .1.3.8
# 01.2.3.8