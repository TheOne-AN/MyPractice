package day9;
//leetcode 67 二进制求和
public class p5 {
    public String addBinary(String a, String b) {
        StringBuilder a1 = new StringBuilder(a).reverse();
        StringBuilder b1 = new StringBuilder(b).reverse();
        int maxLen = Math.max(a.length(),b.length());
        while (a1.length() < maxLen) {
            a1.append(0);
        }
        while (b1.length() < maxLen) {
            b1.append(0);
        }
        StringBuilder ret = new StringBuilder();
        int tmp = 0;
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < maxLen; i++) {
            num1 = a1.charAt(i) - '0';
            num2 = b1.charAt(i) - '0';
            if (tmp+num1+num2 > 1) {
                ret.append(tmp+num1+num2-2);
                tmp = 1;
            }else {
                ret.append(tmp+num1+num2);
                tmp = 0;
            }
        }
        if (tmp == 1) {
            ret.append(1);
        }
        return ret.reverse().toString();
    }
}
