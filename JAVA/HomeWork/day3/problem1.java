package day3;

public class problem1 {
    public static void main(String[] args){
        int i = 7;
        int count = 0;
        do {
            System.out.println(--i);
            --i;
            count++;
        }while ( i != 0);
    }
}
