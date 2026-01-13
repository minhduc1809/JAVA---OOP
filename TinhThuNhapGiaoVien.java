import java.util.Scanner;

public class TinhThuNhapGiaoVien {
    static int chuyen(String s){
        if("HT".compareTo(s) == 0) return 2000000;
        if("HP".compareTo(s) == 0) return 900000;
        return 500000;
    }
    public static void main(String[] a) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine(); 
        System.out.printf("%s %s %d %d %d", s, sc.nextLine(), Integer.parseInt(s.substring(2)), chuyen(s.substring(0,2)),
        chuyen(s.substring(0,2)) + sc.nextInt() * Integer.parseInt(s.substring(2)));
    }
}
