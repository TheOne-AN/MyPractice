import java.util.Arrays;

public class arrys {
    public static void main(String[] args){
        arrys arr = new arrys();
        arr.transString();
        arr.copyString();
        arr.maxNum();
        arr.avarage();
        arr.toSearch();
        arr.binarySearch();
        arr.sortArry();
    }
    private void transString(){
        System.out.println("数组转字符串：");
        int[] arr = {1,2,3,4,5};
        String str = Arrays.toString(arr);
        System.out.println(str);
    }
    private void copyString(){
        System.out.println("拷贝后的：");
        int[] arr = {1,2,3,4,5};
        int[] newArr = Arrays.copyOf(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    private void maxNum(){
        int[] arr = {1,5,2,7,12,56,89,15};
        int max = arr[0];
        for (int x : arr) {
            if (x > max) {
                max = x;
            }
        }
        System.out.println("最大元素是"+max);
    }
    private void avarage(){
        int[] arr = {1,2,3,4,5,6,7,8};
        double sum = 0;
        for (int x : arr) {
            sum += x;
        }
        System.out.println("平均值是："+sum/arr.length);
    }
    private void toSearch(){
        int[] arr = {1,2,3,4,5,67,8};
        int find = 2;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == find){
                System.out.println(find+"的下标是"+i);
                return;
            }
        }
        System.out.println("没有这个数字！");
    }
    private void binarySearch(){
        int[] arr = {1,2,3,4,5,6,7,8};
        int toFind = 45;
        int left = 0;
        int right = arr.length - 1;
        while (left<=right){
            int mid = (left+right)/2;
            if (arr[mid]<toFind){
                left = mid+1;
            }
            if (arr[mid]>toFind){
                right = mid - 1;
            }
            if (arr[mid] == toFind){
                System.out.println("这个数的位置是"+mid);
                break;
            }
        }
        System.out.println("没有这个数！");
    }
    private void sortArry(){
        int[] arr = {12,3,4,48,6,78,5,9,2,15,16,18};
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            while(left<right && arr[left]%2 != 0){
                left++;
            }
            while (left<right && arr[right]%2 == 0){
                right--;
            }
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
