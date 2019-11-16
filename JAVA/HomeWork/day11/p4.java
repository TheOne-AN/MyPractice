package day11;
//leetcode 125 验证回文串
public class p4 {
    public static void main(String[] args){
        p4 aa = new p4();
        String s = "race a car";
        boolean ret = aa.isPalindrome(s);
        System.out.println(ret);
    }
//    public boolean isPalindrome(String s) {
//        if (s  == null) {
//            return true;
//        }
//        StringBuilder str1 = new StringBuilder();
//        for (char x: s.toCharArray()) {
//            if ((x >= '0'&& x <= '9') || (x >= 'a' && x <= 'z')) {
//                str1.append(x);
//            }
//            if ((x >= 'A' && x <= 'Z')) {
//                char tmp = (char) (x - 'A' + 'a');
//                str1.append(tmp);
//            }
//        }
//        System.out.println(str1);
//        StringBuilder str2 = new StringBuilder();
//        for (char x:str1.toString().toCharArray()) {
//            str2.append(x);
//        }
//        str1.reverse();
//        System.out.println(str2);
//        for (int i = 0; i < str1.length(); i++) {
//            if (str1.charAt(i) != str2.charAt(i)) {
//                return false;
//            }
//        }
//        return true;
//    }

    ///好一点的方法
    //双指针
    public boolean isPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        int a = 0, b = s.length() - 1;
        while (a < b) {
            if (!Character.isLetterOrDigit(s.charAt(a))) {
                a++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(b))) {
                b--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(a)) != Character.toLowerCase(s.charAt(b))) {
                return false;
            }

            a++;
            b--;
        }
        return true;
    }
}
