package day3;
//leetcode 9 回文数
public class problem5 {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        long y = 0;
        int z = x;
        while (x != 0) {
            int i = x%10;
            y = y*10 + i;
            x /= 10;
        }
        return y==z;
    }
}
