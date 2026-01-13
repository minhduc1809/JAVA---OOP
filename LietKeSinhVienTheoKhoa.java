import java.util.*;
public class LietKeSinhVienTheoKhoa {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Map<Integer, List<String>> Ds = new HashMap<>();
        int t = Integer.parseInt(in.nextLine());
        while(t > 0){
            t-=1;
            String Msv = in.nextLine();
            String Hoten = in.nextLine();
            String Lop = in.nextLine();
            String Email = in.nextLine();
            String S = Msv + " " + Hoten + " " + Lop + " " + Email;
            String nam = Lop.substring(1,3);
            int x = Integer.parseInt(nam);
            if(!Ds.containsKey(x)){
                Ds.put(x,new ArrayList<>());
            }
            Ds.get(x).add(S);
        }
        int q = Integer.parseInt(in.nextLine());
        while(q>0){
            q-=1;
            String kh = in.nextLine();
            int khoa = Integer.parseInt(kh.substring(2));
            for(Map.Entry<Integer,List<String>> entry: Ds.entrySet()){
                if(entry.getKey() == khoa){
                    System.out.printf("DANH SACH SINH VIEN KHOA " + kh + ":");
                    for(String s : entry.getValue()){
                        System.out.printf(s);
                    }
                }
            }
        }
    }
}
