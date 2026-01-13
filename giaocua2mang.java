import java.util.*;
public class giaocua2mang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();
        for (int i = 0; i < n; i++) {
            A.add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            B.add(sc.nextInt());
        }
        A.retainAll(B);
        List<Integer> result = new ArrayList<>(A);
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(result.get(i));
        }
    }
}
