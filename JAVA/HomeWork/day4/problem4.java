package day4;
//leetcode  58 最后一个单词的长度
public class problem4 {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        int count = 0;
        while (end > 0 && s.charAt(end) == ' '){
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) !=' '){
            start--;
            count++;
        }
        return count;
    }
//    public int lengthOfLastWord(String s) {
//        int count = 0;
//        StringBuffer str = new StringBuffer(s);
//        int end = str.length() - 1;
//        while (end > 0 && str.charAt(end) == ' ') {
//            str.deleteCharAt(end);
//            end--;
//        }
//        if (end < 0) {
//            return 0;
//        }
//        while (end >= 0 && str.charAt(end) != ' ') {
//            end--;
//            count++;
//        }
//        return count;
//    }
    public static void main(String[] args){
        problem4 problem4 = new problem4();
        System.out.println(problem4.lengthOfLastWord("a"));
    }
}
