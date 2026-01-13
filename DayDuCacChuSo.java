import java.util.*;
public class DayDuCacChuSo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                solve(n);
            }
        }
        sc.close();
    }
    private static void solve(int n) {
        if (n == 0) {
            System.out.println("Impossible");
            return;
        }
        Set<Integer> so = new HashSet<>();
        int i = 1;
        long k = 0;
        while (true) {
            k = (long) n * i;
            long temp = k;
            while (temp > 0) {
                int digit = (int) (temp % 10);
                so.add(digit);
                temp /= 10;
            }
            if (so.size() == 10) {
                System.out.println(k);
                break;
            }
            i++;
        }
    }
}