class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        array = []
        removes_count = 0
        for num in nums:
            if num != val:
                array.append(num)
            else :
                
                removes_count = removes_count + 1
        count = len(array)
        
        for i in range(removes_count):
            nums.remove(val)
        
        for i in range(removes_count):
            nums.append('_')
        return count