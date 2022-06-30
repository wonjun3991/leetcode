class Solution:
    def heightChecker(self, heights: List[int]) -> int:
        sorted_list = sorted(heights)
        
        output = 0
        for i, height in enumerate(heights):
            if sorted_list[i] != height:
                output = output + 1
        return output
            