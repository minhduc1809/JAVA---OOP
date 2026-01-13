import java.util.*;
public class TongGiaiThua {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long x = 1;
        long s = 0;
        for(int i = 1; i < n ; i++){
            x=x*i;
            s+=x;
        }
        System.out.println(s);
    }
}
