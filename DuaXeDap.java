import java.util.*;
public class DuaXeDap {
    static class CuaRo implements Comparable<CuaRo> {
        String id;
        String hoTen;
        String donVi;
        double thoiGianDua; 
        long vanToc;      
        public CuaRo(String hoTen, String donVi, String thoiDiemDen) {
            this.hoTen = hoTen;
            this.donVi = donVi;
            this.id = taoMa(donVi) + taoMa(hoTen);
            String[] parts = thoiDiemDen.split(":");
            double gioDen = Double.parseDouble(parts[0]);
            double phutDen = Double.parseDouble(parts[1]);
            this.thoiGianDua = (gioDen - 6) + (phutDen / 60.0);
            this.vanToc = Math.round(120 / this.thoiGianDua);
        }
        private String taoMa(String s) {
            StringBuilder sb = new StringBuilder();
            String[] words = s.trim().split("\\s+");
            for (String word : words) {
                sb.append(word.charAt(0));
            }
            return sb.toString(); 
        }
        @Override
        public String toString() {
            return id + " " + hoTen + " " + donVi + " " + vanToc + " Km/h";
        }
        @Override
        public int compareTo(CuaRo o) {
            if (this.thoiGianDua < o.thoiGianDua) return -1;
            if (this.thoiGianDua > o.thoiGianDua) return 1;
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<CuaRo> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String ten = sc.nextLine();
            String donVi = sc.nextLine();
            String thoiDiem = sc.nextLine();
            list.add(new CuaRo(ten, donVi, thoiDiem));
        }
        Collections.sort(list);
        for (CuaRo cr : list) {
            System.out.println(cr);
        }
        sc.close();
    }
}