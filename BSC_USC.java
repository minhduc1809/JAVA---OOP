import java.util.*;
public class BSC_USC {
        public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public static void main(String[] q){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t>0){
           t--;
           long a = in.nextLong();
           long b = in.nextLong();
           long x = gcd(a,b);
           long y = (a*b)/x;
           System.out.println(y + " " + x);
        }
    }
}
