package day3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
//leetcode  383 赎金信
public class problem4 {
    public static void main(String[] args) {
        String a ="aa";
        String b = "ab";
        problem4 p = new problem4();
        boolean ret = p.canConstruct(a,b);
        System.out.println(ret);
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        if (magazine.length() < ransomNote.length()) return false;
        int caps[] = new int[26];
        for (char c : ransomNote.toCharArray()) {
            int index = magazine.indexOf(c, caps[c - 'a']);
            if (index == -1)
                return false;
            caps[c - 97] = index + 1;
        }
        return true;
    }
}
