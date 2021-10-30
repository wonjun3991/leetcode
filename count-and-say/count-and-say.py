class Solution:
    def countAndSay(self, n: int) -> str:
        # Init
        times = 1
        s = "1"
        
        # Unfold
        while times < n:
            times += 1
            c = "0"
            vc = []
            vcn = []
            
            # Count the numbers of repeat characters
            for w in s:
                if w != c:
                    c = w
                    vc.append(w)
                    vcn.append(1)
                else:
                    vcn[-1] += 1
            
            # Clear the current string
            s = ""
            
            # Create the new string
            for i in range(len(vc)):
                s += str(vcn[i]) + vc[i]
            
        return s;