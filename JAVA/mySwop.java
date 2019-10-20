public class mySwop {
    int x = 10;
    int y = 20;
    public static void main(String[] args){
       mySwop swop = new mySwop();
       swop.exchange(swop.x,swop.y);
       System.out.println(swop.x+"  "+swop.y);
    }
    private void exchange(int x,int y){
        this.y = x;
        this.x = y;
    }
}


