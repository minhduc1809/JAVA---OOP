import java.util.Scanner;
public class MangDoiXung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            boolean check = true;
            for (int i = 0; i < n / 2; i++) {
                if (arr[i] != arr[n - 1 - i]) {
                    check = false;
                    break;
                }
            }

            if (check) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}

