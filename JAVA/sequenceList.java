import java.util.Arrays;
import java.util.Scanner;

public class sequenceList {
    private int space = 10;
    private int[] arr = new int [space];
    private int size = 0;

    public static void main(String[] args){
       sequenceList sqList = new sequenceList();
       sqList.menu();
    }
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int pos=0;
        int value=0;
        int ret=0;
        while(true) {
            System.out.println("--------------------");
            System.out.println("     1.添加数据");
            System.out.println("     2.查看数据");
            System.out.println("     3.搜索数据");
            System.out.println("     4.删除数据");
            System.out.println("     5.查询长度");
            System.out.println("     6.修改元素");
            System.out.println("输入你的选择：");
            switch (scanner.nextInt()){
                case 1:
                    System.out.println("请输入插入的位置：");
                     pos =  scanner.nextInt();
                    System.out.println("请输入插入数据：");
                     value = scanner.nextInt();
                    add(pos,value);
                    break;
                case 2:
                    System.out.println("顺序表数据为：");
                    display();
                    break;
                case 3:
                    System.out.println("请输入要找的数字：");
                    int find = scanner.nextInt();
                    ret = search(find);
                    if (ret==-1){
                        System.out.println("没有这个数据");
                    }
                    else {
                        System.out.println("这个数字的下标是:"+ret);
                    }
                    break;
                case 4:
                    System.out.println("请输入要删除的数据");
                    int num = scanner.nextInt();
                    remove(num);
                    break;
                case 5:
                    ret = size();
                    System.out.println("顺序表实际数据长度是"+ret);
                    break;
                case 6:
                    System.out.println("请输入修改的位置：");
                    pos =  scanner.nextInt();
                    System.out.println("请输入修改数据：");
                    value = scanner.nextInt();
                    setPos(pos,value);
                    break;
                default:
                    break;
            }
        }
        }
    //打印顺序表
    public void display() {
        System.out.println(Arrays.toString(arr));
    }
    //添加数据
    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if (size > (space-1)){
            addSpace();
        }
        if(pos == size){
            arr[pos]=data;
       }
      if(pos>=0&&pos<size){
            for (int i = size;i>pos;i--){
                arr[i] = arr[i-1];
            }
            arr[pos]=data;
          size++;
       }
       else {
            arr[pos]=data;
            size++;
      }

    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int x:arr) {
            if (x!=toFind){
                return false;
            }
        }
        return true;
    }
    public int search(int toFind) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos>=0&&pos<size){
            return arr[pos];
        }
            return -1;
        }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
            arr[pos] = value;
        }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
            int ret = search(toRemove);
            for (int i = ret; i <size-1 ; i++) {
                arr[i] = arr[i+1];
            }
            size--;
        }
    // 获取顺序表长度
    public int size( ){
            if(size!=0){
                return size;
            }
            return 0;
        }
    // 清空顺序表
    public void clear(){
            size = 0;
}
    public void addSpace(){
            int[] newArry = new int [space*2];
            for(int i=0; i<size;i++){
                newArry[i]=arr[i];
            }
            arr=newArry;
    }

}
