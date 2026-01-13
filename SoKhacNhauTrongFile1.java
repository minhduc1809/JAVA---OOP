import java.util.*;
import java.io.*;
public class SoKhacNhauTrongFile1 {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new File("DATA.in"));
        Map<Integer,Integer> x = new HashMap();
        while(in.hasNextInt()){
            int a = in.nextInt();
            if(!x.containsKey(a)){
                x.put(a,1);
            }
            else{
                x.put(a,x.get(a)+1);
            }
        }
        for(Map.Entry<Integer,Integer> i : x.entrySet()){
            System.out.println(i.getKey() + " " + i.getValue());
        }
    }
}
