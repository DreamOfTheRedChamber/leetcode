import sys
from typing import List

def calculate(operand: List[int], operator: List[str]) -> int:
    op2 = operand.pop()
    op1 = operand.pop()
    oper = operator.pop()
    result = 0
    if oper == '+':
        result = op1 + op2
    elif oper == '-':
        result = op1 - op2
    elif oper == '*':
        result = op1 * op2
    else: # oper == '/':
        result = op1 // op2
    return result

def isHigher(operator: List[str], op: str) -> bool:
    if len(operator) == 0:
        return False
    if (op == '+' or op == '-') and operator[-1] != '(':
        return True
    elif (op == '*' or op == '/') and (operator[-1] == '*' or operator[-1] == '/'):
        return True
    else:
        return False

exp = input().strip()
#exp = "3+2*{1+2*[-4/(8-6)+7]}"
exp = exp.replace('{', '(')
exp = exp.replace('}', ')')
exp = exp.replace('[', '(')
exp = exp.replace(']', ')')

operator = []
operand = []
i = 0
if len(exp) > 0 and (exp[0] == '-' or exp[0] == '+') :
    operand.append(0)

while i < len(exp):
    if '0' <= exp[i] <= '9':
        number = 0
        while i < len(exp) and exp[i].isdigit():
            number = number * 10 + int(exp[i])
            i += 1
        operand.append(number)
    elif exp[i] == '(':
        operator.append(exp[i])
        if exp[i + 1] == '-' or exp[i + 1] == '+':
            operand.append(0)
        i += 1
    elif exp[i] == ')':
        while operator[-1] != '(':
            operand.append(calculate(operand, operator))
        operator.pop()
        i += 1
    else:
        char = exp[i]
        while isHigher(operator, exp[i]):
            operand.append(calculate(operand, operator))
        operator.append(exp[i])
        i += 1

while len(operator):
    operand.append(calculate(operand, operator))

print(operand.pop())

# input: 3+2*4+8/2
# input: -3+4*4/8
# input: -3*(-2+5)
# input: 3+2*{1+2*[-4/(8-6)+7]}
# output: 25