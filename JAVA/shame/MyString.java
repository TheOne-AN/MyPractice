package test;

import java.util.Scanner;

public class MyString {
    public static void main(String[] args){
        String str1;
        Scanner scanner = new Scanner(System.in);
        str1 = scanner.next();
        char[] arr = str1.toCharArray();
        char[] arr2 = new char[arr.length];
        int flag = 0;
        for (int i = 0; i < arr.length; i++) {
           arr2[i] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j <=i; j++) {
                if(arr[i] == arr2[j]) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.print(arr[i]);
            }
        }
    }
}
