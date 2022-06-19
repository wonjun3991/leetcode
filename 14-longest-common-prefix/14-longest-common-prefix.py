class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        prefix = list(strs[0])
        for string in strs:
            prefix = prefix[:len(string)]
            string = string[:len(prefix)]
            for index,char in enumerate(string):
                if prefix[index] != char:
                    prefix = prefix[:index]
                    break
                
        return ''.join(prefix)