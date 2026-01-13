import java.util.*;
public class BaiToanTinhCong {
    static int chuyen(String s) {
        if (s.compareTo("GD") == 0)
            return 250000;
        if (s.compareTo("PGD") == 0)
            return 200000;
        if (s.compareTo("TP") == 0)
            return 180000;
        return 150000;
    }

    static int convert(int l, int days) {
        if (days >= 25)
            return l / 5;
        if (days >= 22)
            return l / 10;
        return 0;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("NV01 %s ", in.nextLine());
        int x = in.nextInt();
        int ngay = in.nextInt();
        String cv = in.next();
        int plus = convert(x*ngay, ngay);
        int pc = chuyen(cv);
        System.out.printf("%d %d %d %d", x * ngay, plus, pc, x * ngay  + plus + pc);
    }
}

