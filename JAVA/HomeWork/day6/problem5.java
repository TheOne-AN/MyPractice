package day6;

import java.util.Arrays;
import java.util.Stack;
//leetcode 917 仅仅反转字母
public class problem5 {
    public static void main(String[] args) {
        problem5 pl = new problem5();
        String str = pl.reverseOnlyLetters("aaa--bbb");
        System.out.println(str);
    }
    public String reverseOnlyLetters(String S) {
        char[] ch = S.toCharArray();
        int start = 0;
        int end = ch.length - 1;
        char tmp;
        while (start < end) {
            if (!Character.isLetter(ch[start]))
                start++;
            if (!Character.isLetter(ch[end]))
                end--;
            if (Character.isLetter(ch[start]) &&
                    Character.isLetter(ch[end])) {
                tmp = ch[start];
                ch[start] = ch[end];
                ch[end] = tmp;
                end--;
                start++;
            }
        }
        StringBuilder str = new StringBuilder();
        for (char x:ch) {
            str.append(x);
        }
        return str.toString();
    }
}
