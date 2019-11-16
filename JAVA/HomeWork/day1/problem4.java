package day1;
    //leetcode 709 转换成小写字母
public class problem4 {
    public static void main(String[] args) {
        problem4 problem4 = new problem4();
        String str = problem4.toLowerCase("HellO");
        System.out.println(str);
    }
    public String toLowerCase(String str) {
        String ret = new String();
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (tmp >= 'A'&& tmp <= 'Z' ) {
                tmp +=32;
            }
            ret += tmp;
        }
        return  ret;
    }
}
