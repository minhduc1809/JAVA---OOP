import java.util.*;
public class TinhLuyThua {
    static final long MOD = 1_000_000_007;
    public static long modPow(long a, long b, long mod) {
        long result = 1;
        a %= mod;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1; 
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            long a = in.nextLong();
            long b = in.nextLong();
            if (a == 0 && b == 0) {
                break;
            }
            System.out.println(modPow(a, b, MOD));
        }
    }
}
