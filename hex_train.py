class Solution:
    def addBinary(self, a: str, b: str) -> str:
        a = int(a, 2)
        b = int(b, 2)
        result = 0
        while b != 0:
            result = a ^ b
            carry = (a & b) << 1
            a, b = result, carry
        # 返回前缀是0b
        return bin(a)[2:]


s = Solution
re = s.addBinary(s, "11", "1")
