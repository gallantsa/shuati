package 贪心算法._22单调递增的数字._738_单调递增的数字;

public class Main {
}

class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int flag = chars.length;
        for (int i = chars.length - 1; i > 0; i--) {
            // 如果当前数字小于前一个数字, 则将当前数字减一, 并将后面的数字全部变成9
            if (chars[i] < chars[i - 1]) {
                chars[i - 1]--;
                flag = i;
            }
        }
        for (int i = flag; i < chars.length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));
    }
}