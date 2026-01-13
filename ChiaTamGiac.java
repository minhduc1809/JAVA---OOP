import java.util.*;
public class ChiaTamGiac {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int a = in.nextInt();
            float b = in.nextFloat();
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j < a; j++){
                sb.append(String.format("%.6f ", b * Math.sqrt((double)j / a)));
            }
            System.out.println(sb.toString().trim());
        }
    }
}
