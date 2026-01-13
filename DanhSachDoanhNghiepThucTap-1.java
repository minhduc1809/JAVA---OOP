import java.util.*;
public class DanhSachDoanhNghiepThucTap_1 {
    static class DoanhNghiep {
        String ma, ten;
        int sosv;
        public DoanhNghiep(String ma, String ten, int sosv){
            this.ma = ma;
            this.ten = ten;
            this.sosv = sosv;
        }

        public String toString() {
            return ma + ' ' + ten + ' ' + sosv;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<DoanhNghiep> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            sc.nextLine();
            a.add(new DoanhNghiep(sc.nextLine(), sc.nextLine(), sc.nextInt()));
        }
        a.sort((DoanhNghiep x, DoanhNghiep y) -> {
            if(x.sosv == y.sosv) return x.ma.compareTo(y.ma);
            return y.sosv - x.sosv;
        });
        a.forEach(e -> System.out.println(e));
    }
}
