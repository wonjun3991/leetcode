class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        arr = []
        def backtrack(a = [], left = 0, right = 0):
            if len(a) == 2 * n:
                arr.append("".join(a))
                return
            if left < n :
                a.append("(")
                backtrack(a, left + 1, right )
                a.pop()
            if right < left :
                a.append(")")
                backtrack(a, left, right + 1)
                a.pop()
        backtrack()
        return arr