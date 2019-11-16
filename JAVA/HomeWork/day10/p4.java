package day10;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.regexp.internal.RE;
//leetcode 8 字符串转成整数
public class p4 {
    public static void main(String[] args){
        String str = "2147483648";
        p4 aa = new p4();
        int ret = aa.myAtoi(str);
        System.out.println(ret);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() < 1) {
            return 0;
        }
        int flag = 1;
        int i = 0;
        char ch = str.charAt(0);
        if (ch == '-' || ch == '+') {
            i = 1;
            if (ch == '-' ) {
                flag = -1;
            }
        }
        long ret = 0;
        for (;i < str.length();i++) {
            int num = str.charAt(i) - '0';
            if (num >= 0 && num <= 9) {
                ret = ret*10 + num*flag;
                if (ret > Integer.MAX_VALUE ) {
                    return Integer.MAX_VALUE;
                }
                if (ret < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }else {
                return (int) ret;
            }
        }
        return (int) ret;
    }
}
