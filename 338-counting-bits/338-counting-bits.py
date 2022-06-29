class Solution:
    def countBits(self, n: int) -> List[int]:
        result = []
        
        for i in range(0,n+1):
            string = format(i,'b')
            result.append(string.count('1'))
        return result
        