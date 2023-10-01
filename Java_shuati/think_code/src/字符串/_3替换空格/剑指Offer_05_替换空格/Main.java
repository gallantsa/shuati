package 字符串._3替换空格.剑指Offer_05_替换空格;

public class Main {
}

class Solution {
    public String replaceSpace(String s) {
        String replace = s.replace(" ", "%20");
        return replace;
    }

    public String replaceSpace2(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                stringBuffer.append("%20");
            } else {
                stringBuffer.append(s.charAt(i));
            }
        }
        String s1 = stringBuffer.toString();
        return s1;
    }
}