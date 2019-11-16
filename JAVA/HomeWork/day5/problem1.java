package day5;

public class problem1 {
    String str = new String("Hello");
    char[] chars = {'a','b'};
    public static void main(String[] args){
        problem1 pl = new problem1();
        pl.change(pl.str,pl.chars);
        System.out.println(pl.str + " and ");
        System.out.println(pl.chars);

    }
    public void change(String str, char[] chars) {
        str = "hehe";
        System.out.println(str);
        chars[0] = 'c';
    }
}
