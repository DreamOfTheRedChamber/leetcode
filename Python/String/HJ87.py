"""
简单  通过率：29.00%  时间限制：1秒  空间限制：32M
知识点
字符串
模拟
warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
描述
密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。

一、密码长度:
5 分: 小于等于4 个字符
10 分: 5 到7 字符
25 分: 大于等于8 个字符

二、字母:
0 分: 没有字母
10 分: 密码里的字母全都是小（大）写字母
20 分: 密码里的字母符合”大小写混合“

三、数字:
0 分: 没有数字
10 分: 1 个数字
20 分: 大于1 个数字

四、符号:
0 分: 没有符号
10 分: 1 个符号
25 分: 大于1 个符号

五、奖励（只能选符合最多的那一种奖励）:
2 分: 字母和数字
3 分: 字母、数字和符号
5 分: 大小写字母、数字和符号

最后的评分标准:
>= 90: 非常安全
>= 80: 安全（Secure）
>= 70: 非常强
>= 60: 强（Strong）
>= 50: 一般（Average）
>= 25: 弱（Weak）
>= 0:  非常弱（Very_Weak）

对应输出为：

VERY_SECURE
SECURE
VERY_STRONG
STRONG
AVERAGE
WEAK
VERY_WEAK

请根据输入的密码字符串，进行安全评定。

注：
字母：a-z, A-Z
数字：0-9
符号包含如下： (ASCII码表可以在UltraEdit的菜单view->ASCII Table查看)
!"#$%&'()*+,-./     (ASCII码：0x21~0x2F)
:;<=>?@             (ASCII码：0x3A~0x40)
[\]^_`              (ASCII码：0x5B~0x60)
{|}~                (ASCII码：0x7B~0x7E)

提示:
1 <= 字符串的长度<= 300
输入描述：
输入一个string的密码

输出描述：
输出密码等级

示例1
输入：
38$@NoNoN
复制
输出：
VERY_SECURE
复制
说明：
样例的密码长度大于等于8个字符，得25分；大小写字母都有所以得20分；有两个数字，所以得20分；包含大于1符号，所以得25分；由于该密码包含大小写字母、数字和符号，所以奖励部分得5分，经统计得该密码的密码强度为25+20+20+25+5=95分。

示例2
输入：
Jl)M:+
复制
输出：
AVERAGE
复制
说明：
示例2的密码强度为10+20+0+25+0=55分。
"""

import sys

import bisect
import unittest
from dataclasses import dataclass

class TestMath(unittest.TestCase):

    def test_calcScore(self):
        self.calcScore("12ab")

    def calcScore(self, password: str) -> str:
        score = 0
        # length
        if len(password) <= 4:
            score += 5
        elif 5 <= len(password) <= 7:
            score += 10
        else:
            score += 25

        # letter
        numUpper = 0
        numLower = 0
        numDigit = 0
        numSymbol = 0
        for l in list(password):
            if l.isupper():
                numUpper += 1
            elif l.islower():
                numLower += 1
            elif l.isnumeric():
                numDigit += 1
            elif l.isascii():
                numSymbol += 1

        if numDigit == 1:
            score += 10
        elif numDigit > 1:
            score += 20

        if numSymbol == 1:
            score += 10
        elif numSymbol > 1:
            score += 25

        if numLower == 0 and numUpper > 0:
            score += 10
        elif numUpper == 0 and numLower > 0:
            score += 10
        elif numLower > 0 and numUpper > 0:
            score += 20

        if numUpper > 0 and numLower > 0 and numDigit > 0 and numSymbol > 0:
            score += 5
        elif numUpper + numLower > 0 and numDigit > 0 and numSymbol > 0:
            score += 3
        elif numUpper + numLower > 0 and numDigit > 0:
            score += 2

        result = ""
        if score >= 90:
            result = "VERY_SECURE"
        elif score >= 80:
            result = "SECURE"
        elif score >= 70:
            result = "VERY_STRONG"
        elif score >= 60:
            result = "STRONG"
        elif score >= 50:
            result = "AVERAGE"
        elif score >= 25:
            result = "WEAK"
        else:
            result = "VERY_WEAK"

        return result

if __name__ == '__main__':
    unittest.main()

