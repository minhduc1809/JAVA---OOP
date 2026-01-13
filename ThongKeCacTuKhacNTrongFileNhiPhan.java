import java.util.*;
import java.io.*;
public class ThongKeCacTuKhacNTrongFileNhiPhan {
    static class Tu implements Comparable<Tu>{
        String s;
        int dem;
        Tu(String s, int dem){
            this.s = s;
            this.dem = dem;
        }
        public int compareTo(Tu other){
            if(other.dem !=  this.dem){
                return other.dem-this.dem;
            }
            else{
                return this.s.compareTo(other.s);
            }
        }
        public String toString(){
            return s + " " + dem;
        }  
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        ObjectInputStream x = new ObjectInputStream(new FileInputStream("Data.in"));
        ArrayList<String> a = (ArrayList<String>) x.readObject();
        Map<String,Integer> b = new HashMap<>();
        for(String i : a){
            if(i.length() == 0) continue;
            String[] t = i.toLowerCase().trim().split("[^a-z0-9]");
            for(String c : t){
                if(!c.isEmpty()){
                    b.put(c,b.getOrDefault(c,0)+1);
                }
            }
        }
        List<Tu> l = new ArrayList<>();
        for(Map.Entry<String,Integer> i : b.entrySet()){
            l.add(new Tu(i.getKey(),i.getValue()));
        }
        Collections.sort(l);
        for(Tu i : l){
            System.out.println(i);
        }
    }
}
