import java.util.*;
class GiangVien implements Comparable<GiangVien>{
    private String ma,ten,cc,hoten;
    GiangVien(int id, String  hoten, String cc){
        this.ma = String.format("GV%02d",id);
        this.hoten = hoten.trim();
        this.ten = tachten(hoten);
        this.cc = chuanhoa(cc);
    }
    public String tachten(String s){
        String[] tach = s.split("\\s+");
        return tach[tach.length -1];
    }
    public String chuanhoa(String s){
        String a = "";
        String[] b = s.trim().split("\\s+");
        for(String i : b){
            a+=Character.toUpperCase(i.charAt(0));
        }
        return a;
    }
    public int compareTo (GiangVien other){
        if(!this.ten.equals(other.ten)){
            return this.ten.compareTo(other.ten);
        }
        else{
            return this.ma.compareTo(other.ma);
        } 
    }
    public String toString(){
        return ma + " " + hoten + " " + cc;
    }
}
public class SapXepDanhSachGiangVien {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        ArrayList<GiangVien> a = new ArrayList<>();
        int i=1;
        while(n-->0){
            a.add(new GiangVien(i,in.nextLine(),in.nextLine()));
            i++;
        }
        Collections.sort(a);
        for(GiangVien x : a){
            System.out.println(x);
        }
    }
}
