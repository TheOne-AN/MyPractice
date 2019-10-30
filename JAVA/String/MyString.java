package MyPractice;




public class MyString {
    private String name;
 //   private int length;
    public MyString(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public int getLength() {
        int length = 0;
        char [] ch = name.toCharArray();
        for (char c : ch) {
            length++;
        }
        return length;
    }

    public static void main(String[] args){
        MyString str = new MyString("abcdebc");
        String str1 = "12345123136";

//        boolean ret = str.equals(new MyString("abc"));
//        System.out.println(ret);
//        System.out.println(str.compareTo("bde"));
//        System.out.println(str.toCharArry());
//        System.out.println(str.contains("bc"));
//        System.out.println(str1.indexOf("234",5));
//        System.out.println(str.indextOf("b",6));
//        System.out.println(str1.lastIndexOf("5",5));
//        System.out.println(str.lastIndexOf("b",2));
//       System.out.println(str1.replaceAll("345","45678"));
//        System.out.println(str.myreplaceAll("d","123"));
       // System.out.println(str1.replaceFirst("12","89"));
//        System.out.println(str1.replaceAll("12","89"));

//        System.out.println(str1.indexOf("12"));
        System.out.println(str.myreplaceFirst("bc","we"));
    }
    public boolean equals(Object anObiect) {
        if(this == anObiect) {
            return  true;
        }
        if(anObiect instanceof MyString) {
            String str1 = ((MyString) anObiect).getName();
            char[] ch = str1.toCharArray();
            String str2 = this.getName();
            char[] ch2 = str2.toCharArray();
            if(ch.length == ch2.length) {
                for (int i = 0; i < ch.length; i++) {
                    if (ch[i] != ch2[i]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    public int compareTo(String str) {
        String str1 = this.getName();
        char[] ch1 = str1.toCharArray();
        char[] ch = str.toCharArray();
        if(ch.length == ch1.length) {
            for (int i = 0; i <ch.length ; i++) {
                    if(ch[i] != ch1[i]) {
                        return ch[i] - ch1[i];
                    }
            }
            return 0;
        }
        if(ch.length > ch1.length) {
            if (str.contains(str1)) {
                return Math.abs(ch.length - ch1.length);
            }
        }
        int ret = 0;
        for (int i = 0; i < ch.length; i++) {
            if(ch1[i] != ch[i]) {
                 ret = ch[i] - ch1[i];
            }
        }
        return ret;
    }
    private char[] toCharArry() {
        char[] ret = new char[this.getLength()];
        String str = this.getName();
        for (int i = 0; i < ret.length; i++) {
            ret[i] = str.charAt(i);
        }
        return ret;
    }
    private boolean contains(CharSequence s) {
        //字符串转数组
        char[] ch = this.getName().toCharArray();
        String str = s.toString();
        char[] ch1 = str.toCharArray();
        int j = 0;
        for(int i=0;i<ch.length;i++){
            //记录ch数组下标为i的元素
            char temp2 = ch[i];
            for(;j<ch1.length;j++){
                char temp1 = ch1[j];
                //如果两个元素相等则 i++,j++比较下两个元素
                if(temp1 == temp2){
                    //如果两个一起走到结尾，返回true
                    if(i==ch.length-1 && j == ch1.length-1){
                        return true;
                    }
                    //第一个走完了。第二个没走完返回false
                    if (i==ch.length-1 && j != ch1.length-1){
                        return false;
                    }
                    //第二个走完了，第一个还没完，第一个包含第二个
                    //返回true
                    if (j == ch1.length-1) {
                        return true;
                    }
                    i++;
                    temp2 = ch[i];
                }else{
                    //如果B的第一个元素和A的不相等，break,继续比较A的下一个元素
                   break;
                }
            }
        }
        return false;
    }
    //找到返回第一个数的位置下标，找不到返回-1
    private int indextOf(String str,int index) {
        String string = this.getName();
        char[] ch = string.toCharArray();
        char[] ch1 = str.toCharArray();
        int index1 = 0;
        //判断index是否合法
        if (index<0 || index >= string.length()) {
            return -1;
        }
        //判断是否是子串，不是，直接返回-1
        if(!string.contains(str)) {
            return -1;
        }
        //是子串，找到和子串第一个相同的元素的位置，跳出循环
        //返回下标
        for (int i = index,j = 0; i <ch.length ; i++) {
                if (ch[i] == ch1[j]) {
                    index1 = i;
                    break;
                }
        }
        return index1;
    }
    //与indexOf同理
    public int lastIndexOf(String str ,int index) {
        String string = this.getName();
        char[] ch = string.toCharArray();
        char[] ch1 = str.toCharArray();
        int index1 = 0;
        //判断index是否合法
        if (index<0 || index >= string.length()) {
            return -1;
        }
        //判断是否是子串，不是，直接返回-1
        if(!string.contains(str)) {
            return -1;
        }
        for (int i = index,j = 0; i >=0 ; i--) {
            if (ch[i] == ch1[j]) {
                index1 = i;
                break;
            }
        }
        return index1;
    }
//    private String myreplaceAll(String regex,String replacement) {
//        String  string = this.getName();
//        if(!string.contains(regex)) {
//                return string;
//        }
//        String [] str = string.split(regex);
//        String newStr="";
//
//    }
    //目前只能修改与被修改目标长度相同的字符串
    private String myreplaceFirst(String regex,String replacement) {
        String string = this.getName();
        if (!string.contains(regex)) {
            return string;
        }
        char[] toChange = replacement.toCharArray();
        char[] ch = string.toCharArray();
        char [] ch1 = regex.toCharArray();
        int index = 0;
        int flag = 0;
        for (int i = 0; i < ch.length - ch1.length; i++) {
            StringBuilder s = new StringBuilder();
            flag = i;
            for (int j = 0; j < ch1.length; j++) {
               s.append(ch[i]);
               i++;
            }
            if (s.toString().equals(regex)) {
                index = flag;
                break;
            }
            i = flag;
        }
        for (int i = 0,j = index; i <ch1.length &&j <index+ch1.length ; i++,j++) {
            ch[j] = toChange[i];
        }
        String newStr = ch.toString();
        System.out.println(ch);
        return  newStr;
    }

}
