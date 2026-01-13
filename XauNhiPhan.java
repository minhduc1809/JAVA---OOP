import java.util.*;
public class XauNhiPhan {
    static long[] len = new long[95];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        len[0] = 1;
        len[1] = 1; 
        for (int i = 2; i <= 93; i++) {
            len[i] = len[i-2] + len[i-1];
        }
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            long k = in.nextLong(); 
            System.out.println(getChar(n, k-1));
        }
    }
    static char getChar(int n, long k) {
        if (n == 0) return '0';
        if (n == 1) return '1';
        if (k < len[n-2]) {
            return getChar(n-2, k);
        } else {
            return getChar(n-1, k - len[n-2]);
        }
    }
}
