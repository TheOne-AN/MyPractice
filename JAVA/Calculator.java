import java.util.Scanner;

public class Calculator {
    int num1;
    int num2;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        int choice = 0;
        while (true){
            System.out.println("1.加法");
            System.out.println("2.减法");
            System.out.println("3.乘法");
            System.out.println("4.除法");
            System.out.println("请输入数字1：");
            calculator.num1=scanner.nextInt();
            System.out.println("请输入数字2：");
            calculator.num2 = scanner.nextInt();
            System.out.println("请选择运算方式：");
            switch (choice=scanner.nextInt()){
                case 1:
                   calculator.add(calculator.num1,calculator.num2);
                    break;
                case 2:
                    calculator.reduce(calculator.num1,calculator.num2);
                    break;
                case 3:
                    calculator.mul(calculator.num1,calculator.num2);
                    break;
                case 4:
                    calculator.divi(calculator.num1,calculator.num2);
                    break;
                default:
                        break;
             }
        }
    }
    public void add(int x,int y){
        System.out.println(x+y);
    }
    public void reduce(int x,int y){
        System.out.println(Math.abs(x-y));
    }
    public void divi(int x,int y){
        double ret =(double)x/y;
        System.out.println(ret);
    }
    public void mul(int x,int y){
        System.out.println(x*y);
    }
}
