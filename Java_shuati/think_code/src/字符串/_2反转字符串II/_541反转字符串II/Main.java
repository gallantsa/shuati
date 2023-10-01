package 字符串._2反转字符串II._541反转字符串II;


public class Main {

}

class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            if(i + k <= chars.length) {
                reverse(chars, i, i + k - 1);
                continue;
            }
            reverse(chars, i, chars.length - 1);

        }
        return new String(chars);
    }

    private static void reverse(char[] ch, int i, int j) {
        for (; i < j; i++, j--) {
            char temp  = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }
    }
}