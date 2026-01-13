import java.util.Scanner;
public class DanhSachMatHang {
    static class Goods {
        String ten, donVi;
        int giaMua, giaBan, loiNhuan, ma;
        public Goods(String n, String u, int b, int s, int i) {
            ten = n;
            donVi = u;
            giaMua = b;
            giaBan = s;
            loiNhuan = s - b;
            ma = i;
        }
        public String sma() {
            String s = Integer.toString(ma);
            while (s.length() < 3) s = "0" + s;
            return "MH" + s;
        }
        public boolean behon(Goods b) {
            if (loiNhuan == b.loiNhuan) return ma > b.ma;
            return loiNhuan < b.loiNhuan;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Goods[] a = new Goods[n];
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            a[i] = new Goods(sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextInt(), i + 1);
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i].behon(a[j])) {
                    Goods tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("%s %s %s %d %d %d\n",
                    a[i].sma(), a[i].ten, a[i].donVi, a[i].giaMua, a[i].giaBan, a[i].loiNhuan);
        }
    }
}
