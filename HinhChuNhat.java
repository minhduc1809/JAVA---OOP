import java.util.*;
public class HinhChuNhat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        if(a<=0 || b<=0){
            System.out.println(0);
        }
        else{
            System.out.println( ((a+b)*2) + " " + (a*b) );
        }
    }
}
