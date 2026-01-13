import java.util.*;
import java.io.*;
public class SoKhacNhauTrongFile2 {
    public static void main(String[] args) throws IOException{
        DataInputStream x = new DataInputStream(new FileInputStream("DATA.IN"));
        Map<Integer,Integer> a = new HashMap<>();
        for(int i=0; i<100000; i++){
            int d = x.readInt();
            if(!a.containsKey(d)){
                a.put(d,1);
            }
            else{
                a.put(d,a.get(d)+1);
            }
        }
        for(Map.Entry<Integer,Integer> i : a.entrySet()){
            System.out.println(i.getKey() + " " + i.getValue());
        }
        x.close();
    }
}
