import java.util.Scanner;

public class TongNsodautien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long N = sc.nextLong(); 
            long sum = N * (N + 1) / 2;
            System.out.println(sum);
        }
        sc.close();
    }
}
