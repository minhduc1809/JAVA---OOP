import java.util.*;
public class SapXepThoiGian {
    static class ThoiGian implements Comparable<ThoiGian> {
        int gio, phut, giay;

        public ThoiGian(String time) {
            String[] parts = time.split(":");
            gio = Integer.parseInt(parts[0]);
            phut = Integer.parseInt(parts[1]);
            giay = Integer.parseInt(parts[2]);
        }

        public int chuyenVeGiay() {
            return gio * 3600 + phut * 60 + giay;
        }

        @Override
        public int compareTo(ThoiGian o) {
            return Integer.compare(this.chuyenVeGiay(), o.chuyenVeGiay());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<ThoiGian> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            String time = sc.nextLine();
            list.add(new ThoiGian(time));
        }
        Collections.sort(list);
        for(ThoiGian tg : list){
            System.out.printf("%02d %02d %02d\n",tg.gio,tg.phut,tg.giay);
        }
    }

}