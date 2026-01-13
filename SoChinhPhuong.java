import java.util.*;
public class SoChinhPhuong {
    public static void main(String[] a){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for( int i = 0; i < n; i++){
           long x = in.nextLong();
           long m = (long) Math.sqrt((double)x);
           if(m*m == x){
            System.out.println("YES");
           }
           else{
            System.out.println("NO");
           }
        }
    }
}
