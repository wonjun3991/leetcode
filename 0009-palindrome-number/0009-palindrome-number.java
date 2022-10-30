class Solution {
    public boolean isPalindrome(int x) {
        String number = Integer.toString(x);
        StringBuffer sb = new StringBuffer(number);
        String reversedStr = sb.reverse().toString();
        return number.equals(reversedStr);
    }
}