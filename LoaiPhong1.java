import java.io.*;
import java.util.*;

public class LoaiPhong1 {
    static class LoaiPhong implements Comparable<LoaiPhong>{
        String p,name;
        public LoaiPhong(String s){    
            p = s;
            Scanner sc = new Scanner(s);
            sc.next();
            ArrayList<String> arr = new ArrayList<>();
            while (sc.hasNext()) {
                arr.add(sc.next());
            }
            arr.remove(arr.size() - 1);
            arr.remove(arr.size() - 1);
            StringBuilder sb = new StringBuilder();
            for (String x : arr) {
                sb.append(x).append(" ");
            }

            name = sb.toString().trim();
        }
        public String ToString(){
            return p;
        }
        @Override
        public int compareTo(LoaiPhong o){
            return name.compareTo(o.name);
        }
    }
    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }
}
